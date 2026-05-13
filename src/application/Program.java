package application;

import model.entities.Account;
import model.exceptions.AccountException;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try{
            System.out.println("Enter account data");
            System.out.print("Number: ");
            int number = scanner.nextInt();

            System.out.print("Holder: ");
            String holder = scanner.nextLine();
            scanner.nextLine();

            System.out.print("Inital balance: ");
            double initialBalance = scanner.nextDouble();

            System.out.print("Withdraw limit: ");
            double withdrawLimit = scanner.nextDouble();


            Account acc = new Account(number,holder,initialBalance,withdrawLimit);

            while(true){
                int option;
                System.out.println("Bank Menu");
                System.out.println("1- Deposit");
                System.out.println("2- Withdraw");
                System.out.println("3- Exit");
                System.out.print("Choose option: ");
                option = scanner.nextInt();

                switch (option){
                    case 1:
                        try {
                            System.out.print("Enter amount to deposit: ");
                            acc.deposit(scanner.nextDouble());
                        }catch (AccountException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        try {
                            System.out.println("Withdraw limit: " + acc.getWithdrawLimit());
                            System.out.print("Enter amount to withdraw: ");
                            acc.withdraw(scanner.nextDouble());
                        }catch (AccountException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        System.out.println("Finishing program...");
                        return;
                    default:
                        System.out.println("Invalid option.");
                }
            }


        }catch (AccountException e){
            System.out.println(e.getMessage());
        }







        scanner.close();
    }
}
