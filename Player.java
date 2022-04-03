
abstract public class Player extends Thread{
	
	private char symbol;
	private GameBoard game;
	private int score;
	
	public Player(GameBoard g,char symbol,int score) {
		this.score=score;
		this.game=g;
		this.symbol=symbol;
	}
	
	public char Getsymbol() {
		return this.symbol;
	}
	
	public void AddPoint() {
		this.score++;
	}
	
	public int GetPoints() {
		return this.score;
	}
	
	public abstract void SetPlace(); 
	
	
	public GameBoard GetGame() {
		return this.game;
	}
	
	public void WhoWon() {
		
		boolean cross=true;
		boolean sec_cross=true;
		boolean row = true;
		boolean col = true;
		
		boolean win=false;
		
		boolean draw=true;
		
		for (int i=0 ; i<this.GetGame().GetSize() ; i++) {
			
			row=true;
			col=true;
			
			for (int j=0 ; j<this.GetGame().GetSize() ; j++) {
				if (!this.game.GetSeq().get(i*this.game.GetSize()+j).equals(this.symbol))
					row=false;
				if (!this.game.GetSeq().get(j*this.game.GetSize()+i).equals(this.symbol))
					col=false;
				if (i == j && !this.game.GetSeq().get(i*this.game.GetSize()+j).equals(this.symbol))
					cross=false;
				if (i+j == this.game.GetSize()-1 && !this.game.GetSeq().get(i*this.game.GetSize()+j).equals(this.symbol))
					sec_cross=false;
				if (this.game.GetSeq().get(i*this.game.GetSize()+j).equals(' '))
					draw=false;
					
			}
			
			if(row || col)
				win=true;	
			
		}
		
		
		if (cross || sec_cross)
			win=true;
		
		if (draw && !win) {
			System.out.println("its a draw");
			this.game.SetFinish(true);
		}
		
		if(win) {
			System.out.printf("The "+this.symbol+" has won\n");
			this.AddPoint();
			this.game.SetFinish(true);
		}
	}

}
