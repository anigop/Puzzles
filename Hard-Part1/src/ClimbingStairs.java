import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;


public class ClimbingStairs {

static BigInteger[] bigcache;


public static void readFromFile(String filename){
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = null;
			
			while((line = br.readLine()) != null){
				climbingstairs(line.trim());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
    public static void climbingstairs(String line){
    	int stairs = Integer.parseInt(line);
    	
    	bigcache = new BigInteger[stairs];
    	BigInteger result = numberOfWays(stairs);
    	
    	System.out.println(result);
    }
    
    public static BigInteger numberOfWays(int stairs){
    	
    	if(stairs <= 0){
    		return new BigInteger("1");
    	}
    	if(stairs == 1){
    		return new BigInteger("1");
    	}
    	
    	if(bigcache[stairs-1] == null){
    		bigcache[stairs-1] = numberOfWays(stairs-1);
    	}
    	
    	if(bigcache[stairs-2] == null){
    		bigcache[stairs-2] = numberOfWays(stairs-2);
    	}
    	
    	
    	return bigcache[stairs-1].add(bigcache[stairs-2]);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		//readFromFile(args[0]);
	}

}
