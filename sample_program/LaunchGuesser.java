package Week2_guessnum;
import java.util.Scanner;

class Guesser{
	int gnum;
	 int guessNum() {
		System.out.println("guesser , number :");
		Scanner scan = new Scanner(System.in);
		gnum = scan.nextInt() ; 
		return gnum;
	}
	
}

class Player{
	int pnum;
	int guessNum() {
		System.out.println("player (0-50), number :");
		Scanner scan = new Scanner(System.in);
		pnum = scan.nextInt() ; 
		return pnum ; 
		// return cuz no void and pnum is int type, data type write in method
	}
	
}

class Umpire{
	int gnum;
	int p1num;
	int p2num;
	int p3num;
	
	void  getGnum() {
		Guesser g = new Guesser();
		gnum = g.guessNum();
		
	}
	
	void getPnum() {
		Player p1 = new Player();
		p1num = p1.guessNum();
		
		Player p2 = new Player();
		p2num = p2.guessNum();
		
		Player p3 = new Player();
		p3num = p3.guessNum();
		
	}
	void compare() {
		int count = 0 ;
		if(gnum == p1num  && gnum ==p2num && gnum == p3num) {
			System.out.println("All players won");
		}else if(gnum == p2num) {
			System.out.println("player 2 wins");

		}else if(gnum == p3num){
			System.out.println("player 3 wins");

		}else if(gnum == p1num) { // conditions if 2 or more players win
			
			System.out.println("player 1 wins");
			
		}else {
			while(count <=1) {
				System.out.println("Players try again! ");

				getPnum();
				count ++ ;
			}
			System.out.println("No Win, Game Over! ");


		}
	}
	
	
}


public class launchGuesser {
	public static void main(String [] args) {
		Umpire u = new Umpire();
		u.getGnum();
		u.getPnum();
		u.compare();
		
	}

}
