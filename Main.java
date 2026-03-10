import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        BankService bank = new BankService();
        TransactionService transaction = new TransactionService();

        while(true){

            System.out.println("\nBANKING SYSTEM");
            System.out.println("1 Create Account");
            System.out.println("2 Deposit");
            System.out.println("3 Withdraw");
            System.out.println("4 Check Balance");
            System.out.println("5 Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){

                case 1:
                    bank.createAccount();
                    break;

                case 2:
                    transaction.deposit();
                    break;

                case 3:
                    transaction.withdraw();
                    break;

                case 4:
                    transaction.checkBalance();
                    break;

                case 5:
                    System.out.println("Thank You");
                    return;

                default:
                    System.out.println("Invalid Choice");

            }

        }

    }

}