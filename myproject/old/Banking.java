package myproject;
import myproject.BankAccount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class Banking {

    static ArrayList<BankAccount> myBankAccounts = new ArrayList<BankAccount>();

    public static void main (String []args){

        command(myBankAccounts);

    }



    public static void transfer(String saccount, String taccount , long amount){

        for(BankAccount d : myBankAccounts){
            if(saccount.equals(d.getAccount())){
                d.withdraw(amount);
                System.out.println("Kontostand von: " + d);
        }
    }

        for(BankAccount a : myBankAccounts){
            if(taccount.equals(a.getAccount())){
                a.deposit(amount);
                System.out.println("Kontostand von: " + a);
        }
    }
    
        }

    public static void depositcommand (long amount, String account) {
        BankAccount result = null;
        for (BankAccount c : myBankAccounts) {
            if (account.equals(c.getAccount())) {
                result = c;
                result.deposit(amount);
            }
        }
    }

        public static void withdrawcommand (long amount, String account) {

            BankAccount result = null;
            for (BankAccount c : myBankAccounts) {
            if (account.equals(c.getAccount())) {
                result = c;
                result.withdraw(amount);
            }
        }
    }
    

    public static void usage(){
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|    Sie können die folgenden Befehle benutzen:                                                                              |");
        System.out.println("|    transfer <sourceaccount> <targetaccount> <amount>       |Überweist <amount von <sourceaccount> auf <targetaccount>      |");    
        System.out.println("|    deposit <amount> <account>                              |Zahlt <amount> auf <account>                                   |");
        System.out.println("|    withdraw <amount> <account>                             |Hebt <amount> von <account> ab                                 |");
        System.out.println("|    createaccount <name>                                    |Erzeugt ein neues Konto und gibt den Namen des Kontos zurück   |");
        System.out.println("|    exit                                                    |Um das Programm zu beenden                                     |");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
    }

    public static void command(ArrayList<BankAccount> myBankAccounts){

        Scanner sc = new Scanner(System.in);

        Boolean exitFlag = false;

        while ( exitFlag == false){

        String command = sc.nextLine();


        String splited[] = command.split(" ");
        int arrayLength = splited.length;

        String cmd = splited[0];
        
        

        if (cmd.equals("transfer")){
            
            if(arrayLength == 4){
                String sourceaccount = splited[1];
                String targetaccount = splited[2];
                String amount = splited[3];
                long lamount = Long.parseLong(amount);

                transfer(sourceaccount, targetaccount, lamount);

            }
            else{
                System.out.println("Falsche Eingabe ");
                usage();
            }

        } 

        else if (cmd.equals("deposit")){
            if(arrayLength == 3){
                String amount = splited[1];
                String account = splited[2];
                long lamount = Long.parseLong(amount);

                depositcommand(lamount, account);
            }
            else{
                System.out.println("Falsche Eingabe");
                usage();
            }

        } 

        else if (cmd.equals("withdraw")){

            if(arrayLength == 3){
                String amount = splited[1];
                String account = splited[2];
                long lamount = Long.parseLong(amount);

                withdrawcommand(lamount, account);

            }
            else{
                System.out.println("Falsche Eingabe");
                usage();
            }

        } 
        
        else if (cmd.equals("createaccount")){

            try{
                String name = splited[1];

                BankAccount BankAccounts = new BankAccount();
    
                myBankAccounts.add(BankAccounts);
    
                BankAccounts.setAccount(name);
    
                System.out.println("Der Bankaccount "+ name + " wurde erstellt");
    
                System.out.println(myBankAccounts.size());
                
            } catch(Exception test){
                System.out.println("Fehler. Versuch es mit :");
                System.out.println("createaccount <name>");
            }

        } 
        else if (cmd.equals("exit")){
            exitFlag = true;
        } 

        else {
            usage();
        }
    }
}
}



