import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;


public class User extends Thread {
    
    Socket mySock = null;
    PrintWriter out = null;
    Scanner in = null;
    StringBuilder sb = new StringBuilder();
    
    static Connection con = null;
    static PreparedStatement pr = null;
        
    public User(Socket s) {
        this.mySock = s;
        try {
            this.out = new PrintWriter(s.getOutputStream(), true);
            this.in = new Scanner(s.getInputStream());
        } catch(IOException e) {
            e.printStackTrace();
        }       
    }
    
    public void run() {
                
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/KAT","root","");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        while(true) {
            String str = in.nextLine();
            
            if(str.equals("exit"))
                break;
            
            try {
                pr = con.prepareStatement("\n" + str);
                ResultSet result = pr.executeQuery();
                ResultSetMetaData metaData = result.getMetaData();
                int count = metaData.getColumnCount();
                int i = 0;

                while(result.next()) {
                    
                    while(i < count) {
                        i++;
                        sb.append(result.getString(i) + "\t");
                    }
                    
                    sb.append("%");
                    i = 0;
                }
                
                out.println(sb);
                sb = sb.delete(0, sb.length()-1);

            } catch (SQLException e) {
                e.printStackTrace();
            }
            
            System.out.println();
        }
        
    }   
}
