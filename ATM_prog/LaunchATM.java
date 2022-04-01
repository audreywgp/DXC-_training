import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class Customer2{
	private int card ;
	private int pin ;
	int check_card , check_pin;
	int customerId;
	float balance;
	float  transaction_amt;
	int custNum = 0;
	Scanner scan = new Scanner(System.in);

	
	
	Customer2(int customerId,float bank_bal,int card, int pin) {
//		System.out.println("create 3 customers with 4 params given");
		this.customerId= customerId;
		this.balance = bank_bal;
		this.card = card;
		this.pin=pin;
		custNum++;

	}
	
	 Customer2(){
		 this.customerId= custNum++;
	 }
	 
	public String toString() {

			return "Customer " + this.customerId + " has: " + this.balance + " card " + this.card + " pin "+ this.pin;
	}
	
	
	void login(){
		 try {
				System.out.println("Enter card no.");
				check_card = scan.nextInt();
				System.out.println("Enter PIN ");
				check_pin =scan.nextInt();
			 
		 }
		 catch(InputMismatchException e) {
			 throw e;
			 
		 }
		 
	 }
	
	 void verify() throws InvalidCredentialsException {
		 try {
			 String log = "out";
			 for (Customer2 cus : Bank2.getlist() ) {
				 if(cus.card == check_card && cus.pin == check_pin) {
					 System.out.println("Login Verified, Welcome");
					 log = "in";
					 this.card= check_card;
					 this.pin = check_pin;
					 this.customerId = cus.customerId;
					 this.balance = cus.balance;
		
					 
					 }
				}
			 System.out.print(log);
			 if(!log.equals("in")) {
				 InvalidCredentialsException ice = new InvalidCredentialsException();
				 throw ice; 
			 }
		 }catch(Exception e) {
//			e.printStackTrace();
			 throw e;
		 }
	 }
	 
//	static void editBalance(float amt) {
//		 balance = amt;
//		 
//		 
//	 }
	
	
	
	
	void actions() throws Exception {
			System.out.println("------------------------");
			System.out.print("1.Withdraw ");
			System.out.print("2.Deposit ") ;
			System.out.print("3.Transfer ");
			System.out.print("4.View Transaction ");
			System.out.println("5.Quit ");
			System.out.println("------------------------");
			System.out.println("What would you like to do");
			
			String action;
			action = scan.next();
			action.toLowerCase();
			if(!action.equals("withdraw") || ! action.equals("view")||! action.equals("deposit")||!action.equals("transfer")) {
				System.out.println("enter only the options shown");
				Exception e = new Exception();
				throw e;
			}
			AtmMachine atm = new AtmMachine();

			// when change to while true the bottom line has error
			 while(action.equals("withdraw") ||action.equals("view")|| action.equals("deposit")||action.equals("transfer")) {
				 switch(action) {
				 case "view":
					 //do something
					 Bank2.showDetails(this.customerId);
					 System.out.println("what would you still like to do next");
					 action = scan.next();
					 break;
				 case"withdraw":
					 atm.withdraw(this.customerId,action);
					 System.out.println("what would you still like to do next");
					 action = scan.next();
					 break;
				 case"deposit":
					 atm.deposit(this.customerId,action);
					 System.out.println("what would you still like to do next");
					 action = scan.next();
					 break;
				 case "transfer":
					 atm.transfer(this.customerId,action);
					 System.out.println("what would you still like to do next");
					 action = scan.next();
					 break;	
				default:
					System.exit(0);
				 } 
			 }

		System.out.println(atm.getTransactionHistory());
		System.out.println("total balance: " + atm.targetCustomer.balance);
	 }


	
}

class Bank2{

	static List<Customer2> db= new ArrayList<Customer2>();
	static {
		System.out.println("1: static block");
		db.add(new Customer2(1,100,1111,9999)); 
		db.add(new Customer2(2,200,1112,9999));
		db.add(new Customer2(3,300,1113,9999));
	}
	
	static void showDetails(int customerId) {
		for (Customer2 cus : db) {
			if(cus.customerId == customerId) {
				System.out.println(cus);	
			}
			
		}
		
	}
	
	public static List<Customer2> getlist() {
		return db;
	}
	

	
}

class actions{
	//AtmMachine can extends actions
	// special methods override. 
}

class AtmMachine{
//	Customer2 c = new Customer2();// no need create a new ob
	Customer2 targetCustomer;
	Scanner scan = new Scanner(System.in);
	Customer2 recieveCustomer;

//	int customerId;
//	float balance;
	static List<String> transactionHistory = new ArrayList<>();
	
	
	static void transaction(float amount, String action) {
		transactionHistory.add("amount " +action + " " + amount );
		
	}
	static void transaction(float amount, String action, int customerId) {
		transactionHistory.add("amount " +action + " " + amount  +" to customer: " + customerId);
		
	}
	List<String> getTransactionHistory() {
		return transactionHistory;
	}
	
	Customer2 returnCus(int customerId){
		for (Customer2 cus : Bank2.getlist()) {
			if(cus.customerId == customerId) {
				targetCustomer = cus;

				}
			}
		return targetCustomer;
		
	}
	
	void withdraw(int customerId,String action) {
		 System.out.println("how much would u like to withdraw");
		 float withdrawAmt = scan.nextFloat();
		 returnCus(customerId);
		 if(targetCustomer.balance > withdrawAmt) {
			 targetCustomer.balance -= withdrawAmt;
			
			 if(action.equals("withdraw")) {
				 transaction(withdrawAmt,"withdraw");
				 System.out.println(transactionHistory.toString());
			 }else {
				 transaction(withdrawAmt,"transferred", recieveCustomer.customerId);
			 }
		 }else {
			 System.out.println("yoou too poor, dont do anything out of your limits");
		 }
		 
	}
	

	void deposit(int customerId,String action) {
		 System.out.println("how much would u like to deposit");
		 float depositAmt = scan.nextFloat();
		 returnCus(customerId);
			 targetCustomer.balance += depositAmt;
			 
			 if(action.equals("deposit")) {
				 transaction(depositAmt,"deposit");
				 System.out.println(transactionHistory.toString());
			 }
			
		
	}
	void transfer(int customerId,String action) throws Exception {
		 System.out.println("Who are you transfering to? Please enter their custeromId");
		 int r_customerId = scan.nextInt();
		 returnCus(r_customerId);
		 if(targetCustomer == null) {
			 System.out.println("Error"); 
			 Exception e = new Exception();
			 throw e;
		 }

//		 System.out.println("how much would u like to transfer");
//		 float transferAmt = scan.nextFloat();
		 this.targetCustomer= returnCus(customerId);
		 this.recieveCustomer = returnCus(r_customerId);
		 withdraw(customerId,action);
		 deposit(r_customerId,action);
		
	}
	
	
}

// transfer 
public class Testing123 {

	public static void main(String[] args) throws InvalidCredentialsException {
		// TODO Auto-generated method stub
//		Bank2.showDetails();
	

		Customer2 c1 = new Customer2();
		try {
			c1.login();
			c1.verify();
//			Bank2(c1);
			c1.actions();
			}catch(InvalidCredentialsException ice) {
			System.out.print(ice);
			
		}catch(Exception e) {
			System.out.print(e);
			
		}
		;
	}



}
