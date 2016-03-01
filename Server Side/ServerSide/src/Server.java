import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Server {
    
    static ArrayList<User> users = new ArrayList<User>(4); 
    static ServerSocket ss = null;
    static int port = 1115;
    
    public static void main(String[] args) {
        
        Socket connection = null;
        
        System.out.println("Starting the server...");
        try {
            ss = new ServerSocket(port);
        } catch (IOException e) {
            System.err.println("Unable to host the server!");
            e.printStackTrace();
        }
        System.out.println("Server started on port " + port);
        
        try{
            while(true) {
                System.out.println("Waiting for connection...");
                connection = ss.accept();
                System.out.println("Client connected!");
                User u = new User(connection);
                users.add(u);
                u.start();              
            }
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(ss!=null) {
                    ss.close();
                }
                if(connection!=null) {
                    connection.close();
                }
            } catch(IOException e) {
                e.printStackTrace();
            }       
        }
            
    }
    
}
