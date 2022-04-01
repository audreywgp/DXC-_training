import java.util.* ;
// import * means all in util 

class Tictactoe{
	//static so no need to create object for the using this variable
	static ArrayList<Integer> playerPos = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPos = new ArrayList<Integer>();

	
	
	// static becuz just printing, so can jsut call
	static void displayboard(char board[][]) {
		
		// use for each loop

		for(char row[]:board) {
			for(char x :row) {
				System.out.print(x);
			}
			System.out.println();
		}
		
	}
	
	static void insert(char board[][],int position, String playerType) {
		char c = 'n';
		
		if(playerType.equals("player")){
			c= 'x';
			playerPos.add(position);
			
		}else if(playerType.equals("cpu")) {
			c = 'o';
			cpuPos.add(position);
		}
		switch(position) {
		case 1: board[0][0] = c;
			break;
		case 2: board[0][2] = c;
			break;
		case 3: board[0][4] = c;
			break;
		case 4: board[2][0] = c;
			break;
		case 5: board[2][2] = c;
			break;
		case 6: board[2][4] = c;
			break;
		case 7: board[4][0] = c;
			break;
		case 8: board[4][2] = c;
			break;
		case 9: board[4][4] = c;
			break;
		default: System.out.println("Invalid number");
			
		}
		
		
	}
	
	public static void winningCond() {
		//related to collected class
		// storing 1,2,3 as a list
		List toprow = Arrays.asList(1,2,3);
		List midrow = Arrays.asList(4,5,6);
		List botrow = Arrays.asList(7,8,9);
		List firstcol = Arrays.asList(1,4,7);
		List secondcol = Arrays.asList(2,5,8);
		List thirdcol = Arrays.asList(3,6,9);
		List leftdiagonal = Arrays.asList(1,5,9);
		List rightdiagonal = Arrays.asList(3,5,7);
		
		ArrayList<List> winningCondition = new ArrayList<List>();
		winningCondition.add(toprow);
		winningCondition.add(midrow);
		winningCondition.add(botrow);
		winningCondition.add(firstcol);
		winningCondition.add(secondcol);
		winningCondition.add(thirdcol);
		winningCondition.add(leftdiagonal);
		winningCondition.add(rightdiagonal);
		
		for(List x : winningCondition) {
			if(playerPos.containsAll(x)) {
				System.out.print("player wins");
				System.exit(0);
				
			}else if (cpuPos.containsAll(x)) {
				System.out.print("cpu wins");
				System.exit(0);
				
			}else if((playerPos.size() + cpuPos.size()) == 9){
				System.out.print("no one wins");
				System.exit(0);
			}
		
	
		}
		
	}
	
	
}


public class LaunchTicTacToe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] board = new int [5][4];
////		System.out.println(Arrays.deepToString(board));
//		
//		for(int i = 0 ; i<board.length;i++) {
//			for(int j = 0 ; j<board[i].length;j++) {
//				if( i == 0 || i == 4 ) {
//					System.out.println(" ");
//				}else if( i == 0 || i == 4 && (j==0|| j==4)) {
//					System.out.println("-");
//				}
//				
//			}
//		}
		
		
//		---- solution
		char board[][] = {
				{' ','|' , ' ', '|',' '} ,
				{'-','+','-','+','-'},
				{' ','|' , ' ', '|',' '} ,
				{'-','+','-','+','-'},
				{' ','|' , ' ', '|',' '}		
		};
		
		//infinite loop when u do while true

		
		while(true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter a number 0-9");
			int player_input = scan.nextInt();
			
			while(Tictactoe.playerPos.contains(player_input) || Tictactoe.cpuPos.contains(player_input)){
			
				System.out.println("Already chosen,player enter number again");
				player_input = scan.nextInt();	
			}
			
			Tictactoe.insert(board,player_input,"player");
//			Tictactoe.displayboard(board);
			System.out.println(" ");
			
			Tictactoe.winningCond();
			
			Random rand = new Random();
			// generate 9 digit, start from 0
//			int cpu_input = rand.nextInt(9)+1;
			
			System.out.println("Cpu, Enter a number 0-9");

			int cpu_input = scan.nextInt();

			
			while(Tictactoe.playerPos.contains(cpu_input) || Tictactoe.cpuPos.contains(cpu_input)){
					System.out.println("Already chosen, cpu enter number again");
//					cpu_input = rand.nextInt(9)+1;	
					cpu_input = scan.nextInt();

			}
			
			Tictactoe.insert(board,cpu_input,"cpu");
			Tictactoe.winningCond();
			Tictactoe.displayboard(board);
			

			
			
		}
		
		
	}

}
