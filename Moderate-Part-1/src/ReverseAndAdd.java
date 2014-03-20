import java.io.BufferedReader;
import java.io.FileReader;


public class ReverseAndAdd {

	public static void readFromFile(String filename){
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = null;
			
			while((line = br.readLine()) != null){
				reverseAdd(line);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void reverseAdd(String number){
		
		
		int iteration = 1;
		
		String current = number;
		while(true){
			
			
			int num = Integer.parseInt(current) + Integer.parseInt(reverse(current));
			current = num+"";
			
			if(isPalindrome(current)){
				System.out.println(iteration+" "+current);
				break;
			}
			
			iteration++;
		}
	}
	
	
	public static String reverse(String s){
		
		if(s.length() == 1){
			return s;
		}
		
		return reverse(s.substring(1, s.length()))+s.substring(0,1);
		
	}
	
	public static boolean isPalindrome(String s){
		
		int i = 0;
		int j = s.length()-1;
		
		while(i<j){
			if(s.charAt(i) == s.charAt(j)){
			  i++;
			  j--;
			  continue;
			}else{
				return false;
			}
			
		}
		
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//readFromFile(args[0]);
       reverseAdd("");
		
	}

}
