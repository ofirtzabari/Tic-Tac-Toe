import java.util.Random;
import java.util.concurrent.locks.Lock; 

public class MachinePlayer extends Player{
	
	private Random rand = new Random();
	private Lock lock;
	
	public MachinePlayer(GameBoard g, char symbol, Lock l,int score) {
		super(g,symbol,score);
		this.lock=l;
	}

	@Override
	public void run() {
		while(!super.GetGame().IsFinish()) {
		this.lock.lock();	
		synchronized(super.GetGame()) {
			if(super.GetGame().IsFinish()) {
				lock.unlock();
				break;
			}
				
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
		int x = 0,y = 0,p = 0;
		while(flag) {
			x = rand.nextInt(super.GetGame().GetSize());
        	y = rand.nextInt(super.GetGame().GetSize());
        	p=super.GetGame().GetSize()*y+x;
			if (super.GetGame().GetSeq().get(p).equals(' '))
				flag=false;
		}
        System.out.printf("the computer do the move x="+x+", y="+y+"\n");
        super.GetGame().DoMove(p,super.Getsymbol());
		
	}
	
	

}
