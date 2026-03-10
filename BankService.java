import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class BankService {

    Scanner sc = new Scanner(System.in);

    public void createAccount(){

        try{

            Connection con = DatabaseConnection.getConnection();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Initial Balance: ");
            double balance = sc.nextDouble();

            String query="INSERT INTO accounts(name,balance) VALUES(?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1,name);
            ps.setDouble(2,balance);

            ps.executeUpdate();

            System.out.println("Account Created Successfully");

        }

        catch(Exception e){
            System.out.println(e);
        }

    }

}