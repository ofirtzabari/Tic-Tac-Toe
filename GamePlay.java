import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GamePlay {
	
	public static void main(String[] args) {
		System.out.println("which board size you want to play?: ");
		Scanner s = new Scanner(System.in);
		int size=s.nextInt();
		
		GameBoard g= new GameBoard(size);
		Lock lock = new ReentrantLock();
		
		System.out.println("Welcome to Tic-Tac-Toe\n"
				+ "pleas select number:\n"
				+ "1. play with the computer and be the first.\n"
				+ "2. play with the computer and be the second.\n"
				+ "3. play with friend\n"
				+ "your choice: ");
		
		int choice=s.nextInt();
		
		Player p1 = new HumanPlayer(g,'x',lock,0);
		Player p2 = null;
		String toplay = "y";
		
		
		
		g.Print();
			
			switch (choice) {
			case 1:
				p2 = new MachinePlayer(g,'0',lock,0);
				System.out.printf("user score: "+p1.GetPoints()+" other score: "+p2.GetPoints()+"\n");
				p1.start();
				p2.start(); 
				break;
			case 2:
				p2 = new MachinePlayer(g,'0',lock,0);
				System.out.printf("user score: "+p1.GetPoints()+" other score: "+p2.GetPoints()+"\n");
				p2.start();
				p1.start(); 
				break;
			case 3:
				p2 = new HumanPlayer(g,'0',lock,0);
				System.out.printf("user score: "+p1.GetPoints()+" other score: "+p2.GetPoints()+"\n");
				p1.start();
				p2.start();
				break;
			}
			try {
				p1.join();
				p2.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.printf("user score: "+p1.GetPoints()+" other score: "+p2.GetPoints()+"\n");
			System.out.println("do you want to play another game enter y/n: ");
			s=new Scanner(System.in);
			toplay=s.nextLine();
			System.out.println(toplay);
			while(toplay.equals("y")) {
				//Player p3 = null;
				//Player p4 = null;
				g = new GameBoard(size);
				g.Print();
			if (choice == 1) {
				p1 = new HumanPlayer(g,'x',lock,p1.GetPoints());
				p2 = new MachinePlayer(g,'0',lock,p2.GetPoints());
				p2.start();
				p1.start();
				choice = 2;
			}
			else if(choice ==2) {
				p1 = new HumanPlayer(g,'x',lock,p1.GetPoints());
				p2 = new MachinePlayer(g,'0',lock,p2.GetPoints());
				p1.start();
				p2.start();
				choice = 1;
			}
			else if(choice ==3) {
				p1 = new HumanPlayer(g,'x',lock,p1.GetPoints());
				p2 = new HumanPlayer(g,'0',lock,p2.GetPoints());
				p2.start();
				p1.start();
			}
			
			
			try {
				p1.join();
				p2.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.printf("user score: "+p1.GetPoints()+" other score: "+p2.GetPoints()+"\n");
			System.out.println("do you want to play another game enter y/n:");
			
			s=new Scanner(System.in);
			toplay=s.nextLine();
			
			
		}
				
		System.out.println("bye bye!");	
	}
	
}
