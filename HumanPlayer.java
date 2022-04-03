import java.util.Scanner;
import java.util.concurrent.locks.Lock;

public class HumanPlayer extends Player {

	private Scanner s = new Scanner(System.in);
	private Lock lock;
	
	public HumanPlayer(GameBoard g, char symbol, Lock l,int score) {
		super(g,symbol,score);
		this.lock=l;
	}

	@Override
	public void run() {
		while(!super.GetGame().IsFinish()){
			this.lock.lock();	
			synchronized(super.GetGame()) {
				if(super.GetGame().IsFinish()) {
					lock.unlock();
					break;
				}
					
				System.out.println("please make move enter X and Y (with space between): ");
				this.SetPlace();
				super.GetGame().Print();
				this.WhoWon();
				
				this.lock.unlock();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			super.run();
		}
			
		}
	}

	@Override
	public void SetPlace() {
		boolean flag=true;
		int p = 0;
		while(flag) {	
			int x =s.nextInt();
			int y =s.nextInt();
			p=super.GetGame().GetSize()*y+x;
			if (super.GetGame().GetSeq().get(p).equals(' '))
				flag=false;
			else
				System.out.println("this place not empty pleas try again:\n");
		}
		super.GetGame().DoMove(p,super.Getsymbol());
		
	}
	
	
}
