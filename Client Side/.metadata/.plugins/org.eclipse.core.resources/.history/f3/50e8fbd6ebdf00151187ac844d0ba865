import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Client {
    
    public static void main(String[] args) {
        
        Socket connection = null;
        Scanner getResult = null;
        Scanner keyboard = new Scanner(System.in);
        
        final String host = "localhost";
        final int port = 1115;
        
        System.out.println("Trying to connect to the server...");
        try {
            connection = new Socket(host, port);
            getResult = new Scanner(connection.getInputStream());
        }
        catch(IOException e1) {
            e1.printStackTrace();
        }
        System.out.println("Connected succesffully!");
        
        while(true) {
            printMenu(connection);
            String result = getResult.nextLine();
            result = result.replaceAll("%", "\n");
            System.out.println(result);
            System.out.println("Click <ENTER>, to continue... ");
            keyboard.nextLine();
            
        }
        
    }
    
    public static void printMenu(Socket s) {
        
        int myChoice;
        Socket c = s;
        String str = null;
        PrintWriter out = null;
        try {
            out = new PrintWriter(c.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scanner input = new Scanner(System.in);
        System.out.println("Menu:");
        System.out.println("1. Show information about all the automobiles.");
        System.out.println("2. Show information about autmobile of your chosing.");
        System.out.println("3. Write your own query.");
        System.out.println("4. Exit!");
        
        do {
            System.out.println("Choice: ");          
            myChoice = input.nextInt();
            input.nextLine();
        } while((myChoice < 1) && (myChoice > 6));
        
        
        switch(myChoice) {
            case 1: {
                str = "SELECT Automobile.Make, Automobile.Model, Owners.FName, Owners.LName, Fines.Type, Violations.Type FROM Automobile INNER JOIN Owners ON Automobile.RegNum = Owners.RegNum INNER JOIN Violations ON Owners.OwnerID = Violations.OwnerID INNER JOIN Fines ON Violations.ViolationID = Fines.ViolationID;";
                out.println(str);
                break;
            } case 2: {
                System.out.print("Enter automobile make to search for: ");
                String name = input.nextLine();
                str = "SELECT Automobile.Make, Automobile.Model, Owners.FName, Owners.LName, Fines.Type, Violations.Type FROM Automobile INNER JOIN Owners ON Automobile.RegNum = Owners.RegNum INNER JOIN Violations ON Owners.OwnerID = Violations.OwnerID INNER JOIN Fines ON Violations.ViolationID = Fines.ViolationID WHERE Automobile.Make = '" + name + "';";
                out.println(str);
                break;
            } case 3: {
                System.out.println("Write your query!");
                String query = input.nextLine();
                out.println(query);
                break;
            } case 4: {
                out.println("exit");
                System.exit(0);
            }
        }       
    }
    
}
