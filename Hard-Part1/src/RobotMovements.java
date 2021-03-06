
public class RobotMovements {

	static int[][] grid;
	static boolean[][] bgrid;
	public static int move(int x , int y){
		
		if(bgrid[x][y]){
			return 0;
		}
		
		if(x == 3 && y == 3){
			return 1;
		}
		
		if(!validPos(x, y)){
			return 0;
		}
		bgrid[x][y] = true;
		int ways = (validPos(x+1,y) ? move(x+1,y) : 0) +  ( validPos(x-1,y) ? move(x-1,y):0) + (validPos(x,y+1)  ? move(x,y+1) : 0)+ ( validPos(x,y-1) ? move(x,y-1) : 0);
		bgrid[x][y] = false;
		return ways;
	}
	
	public static boolean validPos(int x , int y){
		return x >= 0 && y >= 0 && x < 4 && y < 4 ;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		grid = new int[4][4];
		bgrid = new boolean[4][4];
		
		int ways = move(0, 0);
		
		System.out.println(ways);
	}

}
