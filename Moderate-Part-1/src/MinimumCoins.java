import java.io.BufferedReader;
import java.io.FileReader;


public class MinimumCoins {

	
	public static int[] c ;

	public static void readFromFile(String filename){
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = null;
			
			while((line = br.readLine()) != null){
				mincoins(line);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public static void mincoins(String line){
		int value = Integer.parseInt(line);
		
		c = new int[value];
		
		System.out.println(compute(value));
	}
	
	
	public static int compute1(int num){
		if(num < 0){
			return 0;
		}
		if(num == 5 || num == 1 || num == 3){
			return 1;
		}
		
		return Math.min(1+compute(num-5), Math.min(1+compute(num-3), 1+compute(num-1)));
	}
	public static int compute(int num ){
		
		int aa = 0;
		int bb = 0;
		int cc = 0;
		if(num < 0){
			return 0;
		}
		if(num == 5 || num == 1 || num == 3){
			return 1;
		}
		
		if(num-5 >= 0 && c[num-5] != 0){
			cc = c[num-5];
		}else{
			cc = compute(num-5);
			if(num -5 >= 0){
				c[num-5] = 1+cc;
			}	
		}
		
		if(num-3 >= 0 &&c[num-3] != 0){
			bb = c[num-3];
		}else{
			bb = compute(num-3);
			if(num -3 >= 0){
				c[num-3] = 1+bb;
			}
			
		}
		
		if(num-1 >=0 && c[num-1] != 0){
			aa = c[num-1];
		}else{
			aa = compute(num-1);
			if(num -1 >= 0){
				c[num-1] = 1+aa;
			}
		}
		return Math.min(1+cc, Math.min(1+bb, 1+aa));
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//readFromFile(args[0]);
		long start = System.currentTimeMillis();
		mincoins("23130");
		long time = System.currentTimeMillis() - start;
		
		System.out.println(time);
	}

}
