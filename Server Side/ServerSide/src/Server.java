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
        
        System.out.println("���������� �� �������...");
        try {
            ss = new ServerSocket(port);
        } catch (IOException e) {
            System.err.println("�� ���� �� ������ �������!");
            e.printStackTrace();
        }
        System.out.println("�������� � ��������� �� ���� " + port);
        
        try{
            while(true) {
                System.out.println("��������� �� ������...");
                connection = ss.accept();
                System.out.println("������� � ������!");
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
