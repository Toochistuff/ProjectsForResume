import javax.swing.*;
import javax.swing.text.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.net.Socket;
import javax.sound.sampled.*;
import javax.imageio.ImageIO;

class Client {
	private Socket socket;
	private JFrame frame;
	private JTextPane chatBox;
	private JTextField inputField;
	private JButton send;
	private JButton media;
	private JButton voice;
	private JScrollPane scrollPane;
	private StyledDocument doc;
	private DataOutputStream dos;

	public Client(String address) {
		setupUI();
		connect(address);
	}

	private void connect(String address) {
		try {
			socket = new Socket(address, 12345);
			dos = new DataOutputStream(socket.getOutputStream());
			// Generate AES key for this client session
			String sharedKey = "GnNtMXjVAoa9PlhBF6f5agOyw+eRdqWJXaQrGTOnhbo=";
			CryptoUtils.setKeyFromBase64(sharedKey);

			new Thread(() -> {
				try {
					DataInputStream dis = new DataInputStream(socket.getInputStream());
					while (true) {
						String type = dis.readUTF();
						if (type.equals("TEXT")) {
							String response = dis.readUTF();
							String decrypted = CryptoUtils.decrypt(response);
							displayMessage("User:", decrypted, false);
						} else if (type.equals("IMAGE")) {
							String imageName = dis.readUTF();
						    long length = dis.readLong();
						    byte[] imageBytes = new byte[(int) length];
						    dis.readFully(imageBytes);
						    ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
						    Image image = ImageIO.read(bis);
						    displayImage("User:", image, false);
						} else if (type.equals("AUDIO")) {
							long length = dis.readLong();
							byte[] audioBytes = new byte[(int) length];
							dis.readFully(audioBytes);
							File receivedAudio = new File("received_voice.wav");
							FileOutputStream fos = new FileOutputStream(receivedAudio);
							fos.write(audioBytes);
							fos.close();
							displayAudio("User:", receivedAudio, false);
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}).start();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Unable to connect. Check server IP or firewall settings.");
			e.printStackTrace();
		}
	}

	private void setupUI() {
		frame = new JFrame("Chat Client");
		frame.setSize(400, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.RED);
		chatBox = new JTextPane();
		chatBox.setEditable(false);

		doc = chatBox.getStyledDocument();
		scrollPane = new JScrollPane(chatBox);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		inputField = new JTextField();
		send = new JButton("Send");

		// MEDIA BUTTON
		media = new JButton("Media");
		// voice button
		voice = new JButton("Voice");
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(inputField, BorderLayout.CENTER);
		panel.add(send, BorderLayout.EAST);
		panel.add(media, BorderLayout.WEST);
		panel.add(voice, BorderLayout.SOUTH);
		frame.add(scrollPane, BorderLayout.CENTER);
		frame.add(panel, BorderLayout.SOUTH);
		frame.setVisible(true);
		inputField.requestFocusInWindow();
		send.addActionListener(e -> sendMessage());
		inputField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});
		voice.addActionListener(e -> { // this is the action for the recording of the audio
			new Thread(() -> {
				try {
					System.out.println("Recording.");
					VoiceRecorder recorder = new VoiceRecorder();
					recorder.start();
					File audioFile = new File("voicemessage.wav");
					if (!audioFile.exists()) {
						System.out.println("Audio file not found.");
						return;
					}
					System.out.println("Sending the audio.");
					sendAudio(audioFile, socket.getOutputStream());
					
					displayAudio("You:", audioFile, true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}).start();
		});
		media.addActionListener(e -> {
			JFileChooser fileChooser = new JFileChooser();
			int result = fileChooser.showOpenDialog(frame);
			if (result == JFileChooser.APPROVE_OPTION) {
				File imageFile = fileChooser.getSelectedFile();
				new Thread(() -> {
					try {
						sendImage(imageFile, socket.getOutputStream());
						displayImage("You:", ImageIO.read(imageFile), true); //local preview
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}).start();
			}
		});
	}

	private void sendMessage() {
		String message = inputField.getText();
		if (!message.isEmpty()) {
			String encrypted = CryptoUtils.encrypt(message);
			try {
				dos.writeUTF("TEXT");
				dos.writeUTF(encrypted);
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			displayMessage("You:", message, true);
			inputField.setText("");
		}
	}

	private void displayMessage(String sender, String message, boolean isSelf) {
		try {
			SimpleAttributeSet attrs = new SimpleAttributeSet();
			StyleConstants.setForeground(attrs, isSelf ? Color.BLUE : Color.RED);
			StyleConstants.setBold(attrs, true);
			SimpleAttributeSet alignment = new SimpleAttributeSet();
			StyleConstants.setAlignment(alignment, isSelf ? StyleConstants.ALIGN_LEFT : StyleConstants.ALIGN_RIGHT);
			int start = doc.getLength();
			doc.insertString(start, sender + "\n", attrs);
			StyleConstants.setBold(attrs, false);
			doc.insertString(doc.getLength(), message + "\n\n", attrs);
			doc.setParagraphAttributes(start, doc.getLength() - start, alignment, false);
			chatBox.setCaretPosition(doc.getLength());
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}

	class VoiceRecorder {
		private static final String audiofile = "voicemessage.wav";
		private static final long audiotime = 10000; // I set it to record up to 10 seconds of audio
		private AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
		private TargetDataLine line;

		public void start() {
			try {
				AudioFormat format = getAudioFormat();
				DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
				if (!AudioSystem.isLineSupported(info)) {
					System.out.println("Line not supported");
					return;
				}
				line = (TargetDataLine) AudioSystem.getLine(info);
				line.open(format);
				line.start();
				Thread thread = new Thread(() -> {
					AudioInputStream ais = new AudioInputStream(line);
					File audioFile = new File(audiofile);
					try {
						AudioSystem.write(ais, fileType, audioFile);
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
				thread.start();
				Thread.sleep(audiotime);
				stop();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		private void stop() {
			line.stop();
			line.close();
			System.out.println("Recording stopped.");
		}

		private AudioFormat getAudioFormat() {
			return new AudioFormat(16000, 16, 2, true, true);
		}
	}

	public void sendAudio(File audioFile, OutputStream output) throws IOException {
		FileInputStream fis = new FileInputStream(audioFile);
		dos.writeUTF("AUDIO"); // tag is as an audio message
		dos.writeLong(audioFile.length());
		byte[] buffer = new byte[4096];
		int bytesRead;
		while ((bytesRead = fis.read(buffer)) != -1) {
			dos.write(buffer, 0, bytesRead);
		}
		fis.close();
		dos.flush();
	}

	 public void playAudio(File audioFile) throws Exception {
	      AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
	      Clip clip = AudioSystem.getClip();
	      clip.open(audioStream);
	      clip.start();
	  }

	//GUI for audio. Aligned and color coded by user
	 private void displayAudio(String sender, File audioFile, boolean isSelf) {
		    SwingUtilities.invokeLater(() -> {
		        try {
		            SimpleAttributeSet attrs = new SimpleAttributeSet();
		            StyleConstants.setForeground(attrs, isSelf ? Color.BLUE : Color.RED);
		            StyleConstants.setBold(attrs, true);

		            SimpleAttributeSet alignment = new SimpleAttributeSet();
		            StyleConstants.setAlignment(alignment, isSelf ? StyleConstants.ALIGN_LEFT : StyleConstants.ALIGN_RIGHT);

		            int start = doc.getLength();
		            doc.insertString(start, sender + "\n", attrs);
		            doc.setParagraphAttributes(start, doc.getLength() - start, alignment, false);

		            JButton playButton = new JButton("▶");
		            playButton.addActionListener(e -> {
		                try {
		                    playAudio(audioFile);
		                } catch (Exception ex) {
		                    ex.printStackTrace();
		                }
		            });

		            JPanel panel = new JPanel(new FlowLayout(isSelf ? FlowLayout.LEFT : FlowLayout.RIGHT));
		            panel.setOpaque(false);
		            panel.add(playButton);

		            chatBox.setCaretPosition(doc.getLength());
		            chatBox.insertComponent(panel);
		            doc.insertString(doc.getLength(), "\n\n", null);
		            chatBox.setCaretPosition(doc.getLength());
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    });
		}

	public void sendImage(File imageFile, OutputStream output) throws IOException {
		FileInputStream fis = new FileInputStream(imageFile);
		DataOutputStream dos = new DataOutputStream(output);
		dos.writeUTF("IMAGE"); // Tag it as an image message
		dos.writeUTF(imageFile.getName());
		dos.writeLong(imageFile.length());
		byte[] buffer = new byte[4096];
		int bytesRead;
		while ((bytesRead = fis.read(buffer)) != -1) {
			dos.write(buffer, 0, bytesRead);
		}
		fis.close();
		dos.flush();
	}

	private void displayImage(String sender, Image image, boolean isSelf) {
	    SwingUtilities.invokeLater(() -> {
	        try {
	            // Resize image to fit the chat box, maintaining aspect ratio
	            int maxWidth = 180;
	            int maxHeight = 180;

	            // Get the current width and height of the image
	            int width = image.getWidth(null);
	            int height = image.getHeight(null);

	            // Calculate new dimensions maintaining aspect ratio
	            int newWidth = width;
	            int newHeight = height;

	            if (width > maxWidth) {
	                newWidth = maxWidth;
	                newHeight = (maxWidth * height) / width;
	            }

	            if (newHeight > maxHeight) {
	                newHeight = maxHeight;
	                newWidth = (maxHeight * width) / height;
	            }

	            // Resize the image
	            Image resizedImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
	            ImageIcon resizedIcon = new ImageIcon(resizedImage);

	            
	            SimpleAttributeSet attrs = new SimpleAttributeSet();
	            StyleConstants.setForeground(attrs, isSelf ? Color.BLUE : Color.RED); //Color coordinate user
	            StyleConstants.setBold(attrs, true);

	            SimpleAttributeSet alignment = new SimpleAttributeSet();
	            StyleConstants.setAlignment(alignment, isSelf ? StyleConstants.ALIGN_LEFT : StyleConstants.ALIGN_RIGHT); //align user

	            int start = doc.getLength();
	            doc.insertString(start, sender + "\n", attrs);
	            doc.setParagraphAttributes(start, doc.getLength() - start, alignment, false);

	            JLabel imageLabel = new JLabel(resizedIcon);
	            JPanel imagePanel = new JPanel(new FlowLayout(isSelf ? FlowLayout.LEFT : FlowLayout.RIGHT));
	            imagePanel.setOpaque(false);
	            imagePanel.add(imageLabel);

	            JPanel outerPanel = new JPanel(new BorderLayout());
	            outerPanel.setOpaque(false);
	            if (isSelf) {
	                outerPanel.add(imagePanel, BorderLayout.WEST);
	            } else {
	                outerPanel.add(imagePanel, BorderLayout.EAST);
	            }

	            chatBox.setCaretPosition(doc.getLength());
	            chatBox.insertComponent(outerPanel);
	            doc.insertString(doc.getLength(), "\n\n", null);
	            chatBox.setCaretPosition(doc.getLength());

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    });
	}


	public static void main(String[] args) {  //time complexity = O(n)
		String serverAddress = JOptionPane.showInputDialog("Enter Server IP Address:");
		if (serverAddress != null && !serverAddress.trim().isEmpty()) {
			new Client(serverAddress.trim());
		} else {
			System.out.println("Invalid server address!");
		}
	}
} 