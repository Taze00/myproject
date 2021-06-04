package myproject;
import java.lang.Math;
import myproject.Banking;
import java.util.ArrayList;

public class BankAccount{

        private long balance;
        private String account;
        

        public String getAccount(){
                return account;
        }

        public long getBalance(){
                System.out.println(balance);
                return balance;
        }

        public String setAccount(String account){
                this.account = account;
                return account;
        }


        public long deposit(long einnahme){
        long nbalance = balance + einnahme;
        balance = nbalance;
        return balance;
        }

        public long withdraw(long ausgabe){
        long cbalance = balance - ausgabe;
        balance = cbalance;
        return balance;
        }

        public long withdraw(long foreignValue, double conversionfactor){

            double nforeignValue;
    
            double dforeignValue = (double)foreignValue; 
    
            nforeignValue = dforeignValue * conversionfactor;
            Math.ceil(nforeignValue);
            long aforeignValue =(long)nforeignValue;
            long nbalance = balance - aforeignValue;
            balance = nbalance;
            return balance;
            }


}
