import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Menu{
	
	
	static void display() {
		System.out.println("Here's the Menu, order when you are ready!");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("ID \t\t\t\t Name \t\t\t\t Price");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("1. \t\t\t\t Water  \t\t\t\t\t 2");
		System.out.println("2. \t\t\t\t Coke   \t\t\t\t\t 4");
		System.out.println("3. \t\t\t\t Burger \t\t\t\t\t 10");
		System.out.println("4. \t\t\t\t Fries  \t\t\t\t\t 8");
		System.out.println("5. \t\t\t\t Pizza  \t\t\t\t\t 11");
		System.out.println("-----------------------------------------------------------------------");

	
	}
	
}

class Order{
	static int amt= 0 ;
	static int sub_amt = 0;
	static ArrayList<String> itemarr = new ArrayList<String>();
	static String item; // store in array list
	static int id;
	static int qty = 0;
	static String more_order = "YES" ;
	
	static void selection(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Item ID: ");
		id = scan.nextInt();
		System.out.println("Enter Quantity: ");
		qty = scan.nextInt();

			
			switch(id) {
			case 1 : sub_amt = 2*qty;
					item = "Water";
				break;
			case 2:  sub_amt = 4*qty;
					item = "Coke";
				break;
			case 3:  sub_amt = 10*qty;
					item = "Burger";
				break;
			case 4: sub_amt = 8*qty;
					item = "Fries";
				break;
			case 5:  sub_amt = 11*qty;
					item = "pizza";
				break;
			default:System.out.println("Invalid ID");
			
			}
			System.out.println("Confirm your ordered (YES/NO): " + qty + " " + item);
			String cfm;
			cfm = scan.next();
			
			if(cfm.toUpperCase().equals("YES")) {
				amt += sub_amt;
				itemarr.add(qty+"x"+item);
				System.out.println("Sub Total for " +item+ " : $" + sub_amt);
				
			}
		}
	
	static void cfmOrder(String more_order) {
		if(more_order.toUpperCase().equals("NO")) {
			System.out.println("you have ordered "+itemarr);
			System.out.println("Total Bill: $" + amt);
		}else {
			Menu.display();
			selection();
		}
		
	}
		
	
}



public class LaunchHotelOrders {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Hotel XYZ");
		System.out.println("Please Enter your Name: ");
		Scanner scan = new Scanner(System.in);
		String name;
		name = scan.next();
		Menu.display();
		Order.selection();
		
		String more_order ="yes";
		while(more_order.toUpperCase().equals("YES")) {
			System.out.println("Would you like more? (YES/NO)");
			more_order = scan.next();
			Order.cfmOrder(more_order);
		}
	
		System.out.println("Finish ordering");
		


		
		
		
		

	}

}
