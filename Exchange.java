import java.util.Scanner;
import java.math.*;

public class Exchange{
    private int coin1 ;
    private int coin5 ;
    private int coin10 ;
    private int value;
  
    public Exchange() {
          this.coin1 = 100;
          this.coin5 = 100;
          this.coin10 = 100;
    }   

    private void setCoin(int amount10, int amount5, int amount1){
          this.coin10 = this.coin10 - amount10 ;  
          this.coin5 = this.coin5 - amount5 ;  
          this.coin1 = this.coin1 - amount1 ;  
    }

    private void calCoin(int cash){
      int sub = 0;    
      if(cash == 20){
            sub = cash / 2;                  
      }
      else{
            sub = cash * 60/100;            
      }
      countCoin(sub,cash);    
    }

    private void countCoin(int subcoin , int cash){
          if(checkCoin() == true){
         
            int amount10 = (int) Math.floor(subcoin/10);
            value = amount10 * 10;   
            value = value + 5;   
            int amount5 = (int) Math.floor((cash - value )/5);
            value = value + (amount5 * 5);
     
            if (value == cash ) {
                 displayCoin(amount10 ,amount5, 5);                
            }
          }
          else {
            System.out.print("Run out of coins");
          }
    }

    private boolean checkCoin(){
            int total = this.coin10 *10 + this.coin5 * 5 + this.coin1 * 1;
            if(total > 20)  
                  return true ;
            else           
                  return false;
    }

    private void displayCoin(int amount10, int amount5, int amount1){
            System.out.println("10 Baht " + amount10 + " Coin");
            System.out.println("5 Baht " + amount5 + " Coin");
            System.out.println("1 Baht " + amount1 + " Coin");

            System.out.print("Do you confirm (y/n)? : "); 
            Scanner getconfirm = new Scanner (System.in);
            String confirm = getconfirm.nextLine().toLowerCase();

            if (confirm.equals("y")) { 
                setCoin(amount10,amount5,amount1);
                System.out.println("*****success*****");
                System.out.print("Do you want to continue (y/n)? : ");
                Scanner getcontinue = new Scanner (System.in);
                String next =  getcontinue.nextLine().toLowerCase();
                if (next.equals("y")) 
                        exchangeCash();
                else  
                        System.out.println("*****Thank you*****");
           }
           else 
           {
               System.out.println("*****Refund*****");
           }
    }
    
    private void checkCash(int cash){
     if(cash == 20 || cash == 50 || cash == 100){
           calCoin(cash);
     }
     else{
           System.out.println("Please try again.");    
           exchangeCash();    
     } 
    }

     public void exchangeCash(){
     System.out.print("Enter cash for exchange (20 | 50 | 100)? : ");
     Scanner getcash = new Scanner (System.in);
     int cash = getcash.nextInt();
     checkCash(cash);  
    }
    
     public static void main(String[] args) { 
           Exchange exchange = new Exchange();
           exchange.exchangeCash();                 
     }
}