package Hc;

public class Platformer {

	int n;
	int position;
	int[] row;
	
	public Platformer(int n, int position) {
		this.n = n;
		this.position = position;
		this.row = new int[n];
		for(int i=0 ; i < row.length; i ++) {
			this.row[i] = 1;
		}
	}

	public void jumpLeft() {
		int next = position;
		int cnt = 2;
		for(int i = position-1 ; i >= 0; i--) {
			System.out.println("row" + i + ":" + row[i]);
			if(row[i] == 1 && cnt != 0) {
				cnt--;
				next = i;
			}
		}
		if(position != next) {
			row[position] = 0;
			position = next;
		}
	}

	public void jumpRight() {
		int next = position;
		int cnt = 2;
		for(int i = position+1; i < row.length; i++) {
			System.out.println("row" + i + ":" + row[i]);
			if(row[i] == 1 && cnt != 0) {
				cnt--;
				next = i;
			}
		}
		if(position != next) {
			row[position] = 0;
			position = next;
		}
	}

	public int position() {
		return this.position;
	}
	
	public static void main(String[] args) {
		Platformer platformer = new Platformer(10, 3);
		System.out.println(platformer.position()); // should print 3

		platformer.jumpLeft();
		System.out.println(platformer.position()); // should print 1

		platformer.jumpRight();
		System.out.println(platformer.position()); // should print 4
	}

}
