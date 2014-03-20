import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;


public class JollyJumper {


	 public static void readFromFile(String filename){
			
			try{
				BufferedReader br = new BufferedReader(new FileReader(filename));
				String line = null;
				
				while((line = br.readLine()) != null){
					isjolly(line);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	 
	 
	public static void isjolly(String line){
		
		
		HashSet<Integer> set = new HashSet<Integer>();
		
		
		String[] token = line.split("\\s");
		int i = 0;
		boolean isJolly = true;
		
		for(String s : token){
			set.add(Math.abs(Integer.parseInt(s)));
		}
		
		while(i <  token.length ){
			if(i+1 < token.length){
				if(!set.contains(difference(token[i],token[i+1]))){
					System.out.println("t1 "+token[i]+" t2 "+token[i+1]+"   "+difference(token[i],token[i+1]));
					isJolly = false;
				}
			}
			i++;
		}
		
		if(isJolly){
			System.out.println("Jolly");
		}else{
			System.out.println("Not jolly");
		}
		
		

	}
	
	public static int difference(String num1,String num2){
		
		int n = Integer.parseInt(num1);
		int m = Integer.parseInt(num2);
		
		n = Math.abs(n);
		m = Math.abs(m);
		
		return Math.abs(n-m);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//readFromFile(args[0]);
		//isjolly("-423 -389 -362 32 -482 -361 -453 -454 -388 -427 -428 -395 -406 -405 -380 -408 -407 -402 -384 -350 -401 -404 -371 -375");
		isjolly("2 5 1 3 4");
 	}

}
