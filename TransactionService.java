import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class TransactionService {

    Scanner sc = new Scanner(System.in);

    public void deposit() {

        try {

            Connection con = DatabaseConnection.getConnection();

            System.out.print("Enter Account ID: ");
            int id = sc.nextInt();

            System.out.print("Enter Amount: ");
            double amount = sc.nextDouble();

            String query = "UPDATE accounts SET balance = balance + ? WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setDouble(1, amount);
            ps.setInt(2, id);

            ps.executeUpdate();

            System.out.println("Deposit Successful");

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void withdraw() {

        try {

            Connection con = DatabaseConnection.getConnection();

            System.out.print("Enter Account ID: ");
            int id = sc.nextInt();

            System.out.print("Enter Amount: ");
            double amount = sc.nextDouble();

            String query = "UPDATE accounts SET balance = balance - ? WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setDouble(1, amount);
            ps.setInt(2, id);

            ps.executeUpdate();

            System.out.println("Withdrawal Successful");

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void checkBalance() {

        try {

            Connection con = DatabaseConnection.getConnection();

            System.out.print("Enter Account ID: ");
            int id = sc.nextInt();

            String query = "SELECT balance FROM accounts WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Balance: " + rs.getDouble("balance"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}