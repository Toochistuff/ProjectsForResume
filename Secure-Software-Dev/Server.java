import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;
class Server {
   private static final int PORT = 12345;
   private static Set<ClientHandler> clients = new HashSet<>();
   public static void main(String[] args) {
       try {
           String wifiIP = "10.100.172.53"; //Replace with WIFI IP
           ServerSocket serverSocket = new ServerSocket(PORT, 50, InetAddress.getByName(wifiIP));
           System.out.println("Server started on Wi-Fi IP: " + wifiIP + ", Port: " + PORT);
           while (true) {
               Socket socket = serverSocket.accept();
               ClientHandler client = new ClientHandler(socket);
               clients.add(client);
               System.out.println("Client connected");
               new Thread(client).start();
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
   static void broadcastText(String message, ClientHandler sender) {
       for (ClientHandler client : clients) {
           if (client != sender) {
               client.sendText(message);
           }
       }
   }
   static void broadcastImage(String imageName, byte[] data, ClientHandler sender) {
       for (ClientHandler client : clients) {
           if (client != sender) {
               client.sendImage(imageName, data);
           }
       }
   }
  
   static void broadcastAudio(byte[] audioData, ClientHandler sender) {
       for (ClientHandler client : clients) {
           if (client != sender) {
               client.sendAudio(audioData);
           }
       }
   }
}
