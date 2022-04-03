import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import  java.lang.Math;

public class GameBoard {
	
	private StringBuilder board = new StringBuilder();
	private List<Character> seq = new ArrayList<Character>();
	private int size;
	private boolean isfinis;
	
	
	public GameBoard(int size) {
		this.board.append("  ");
		for (int i=0; i<size; i++) 
			this.board.append("  "+i+" ");
		this.board.append("\n");
		for (int j=0; j<size ; j++) {
			this.board.append("   ");
			for (int i=0; i<size; i++) {
				this.board.append("--- ");
			}
			this.board.append("\n");
			this.board.append(j+" |");
			for (int i=0; i<size; i++) {
				this.board.append(" %c |");
			}
			this.board.append("\n");
		}
		this.board.append("   ");
		for (int i=0; i<size; i++) {
			this.board.append("--- ");
		}
		for (int i=0; i<Math.pow(size, 2); i++)
			this.seq.add(' ');
		this.size=size;
		this.isfinis=false;
	}


	public void Print() {
		System.out.println(String.format(this.board.toString(),seq.toArray()));
	}
	
	public void DoMove(int p,char symbol) {
		this.seq.set(p, symbol);
	}
	
	public int GetSize() {
		return this.size;
	}
	
	public List<Character> GetSeq() {
		return this.seq;
	}
	
	public boolean IsFinish() {
		return this.isfinis;
		}
	
	public void SetFinish(boolean b) {
		this.isfinis=b;
	}
}
