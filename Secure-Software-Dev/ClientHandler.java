import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
class ClientHandler implements Runnable {
   private Socket socket;
   private DataInputStream dis;
   private DataOutputStream dos;
   public ClientHandler(Socket socket) {
       this.socket = socket;
       try {
           dis = new DataInputStream(socket.getInputStream());
           dos = new DataOutputStream(socket.getOutputStream());
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
   public void sendText(String message) {
       try {
           dos.writeUTF("TEXT");
           dos.writeUTF(message);
           dos.flush();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
   public void sendImage(String name, byte[] data) {
       try {
           dos.writeUTF("IMAGE");
           dos.writeUTF(name);
           dos.writeLong(data.length);
           dos.write(data);
           dos.flush();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
   public void sendAudio(byte[] audioData) {
       try {
           DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
           dos.writeUTF("AUDIO");
           dos.writeLong(audioData.length);
           dos.write(audioData);
           dos.flush();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
   @Override
   public void run() {
       try {
           while (true) {
               String type = dis.readUTF();
               if (type.equals("TEXT")) {
                   String message = dis.readUTF();
                   Server.broadcastText(message, this);
               } else if (type.equals("IMAGE")) {
                   String imageName = dis.readUTF();
                   long length = dis.readLong();
                   byte[] imageBytes = new byte[(int) length];
                   dis.readFully(imageBytes);
                   Server.broadcastImage(imageName, imageBytes, this);
               } else if (type.equals("AUDIO")) {
                   long length = dis.readLong();
                   byte[] audioBytes = new byte[(int) length];
                   dis.readFully(audioBytes);
                   Server.broadcastAudio(audioBytes, this);
               }
           }
       } catch (IOException e) {
           System.out.println("Client disconnected.");
       }
   }
}
