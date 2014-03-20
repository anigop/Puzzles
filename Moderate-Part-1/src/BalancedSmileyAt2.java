import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Stack;


public class BalancedSmileyAt2 {

	

	 public static void readFromFile(String filename){
			
			try{
				BufferedReader br = new BufferedReader(new FileReader(filename));
				String line = null;
				
				while((line = br.readLine()) != null){
					balancedsmileysat2(line);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	 
	 
	 public static void balancedsmileysat2(String line){
		 
		 int index = 0;
		 boolean isBalanced = true;
		 Stack<String> tracker = new Stack<String>();
		 int frownmaybe = 0;
		 int smilemaybe = 0;
		 
		 while(index < line.length()){
			 if(line.charAt(index) == '('){
				 if(index-1 > 0 && line.charAt(index-1) == ':'){
					 frownmaybe++;
				 }else{
					 tracker.push(line.charAt(index)+"");
				 }
				 
			 }
			 else if(line.charAt(index) == ')'){
				 if(index-1 > 0 && line.charAt(index-1) == ':' && tracker.size() > 0){
					 smilemaybe++;
				 }
				 else if(index-1 > 0 && line.charAt(index-1) == ':' && tracker.size() == 0){
					 index++;
					 continue;
				 }
				 else if(tracker.size() < 1 && frownmaybe == 0){
					 isBalanced = false;
					 break;
				 }
				 else if(tracker.size() < 1 && frownmaybe > 0){
					 frownmaybe--;
				 }
				 else {
					tracker.pop(); 
				 }
				
			 }
			 index++;
		 }
		 
		 if(index < line.length() && !isBalanced){
			 System.out.println(line+"  m NO");
		 }
		 
		 
		 else if(tracker.size() == 0 || tracker.size() - smilemaybe == 0){
			 System.out.println(line+"   YES");
		 }
		 else{
			 System.out.println(line+"  NO");
		 }
	 }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//readFromFile(args[0]);
		balancedsmileysat2("b(:ab:c( :)caba(cccbacccabb(a(ab)( :abc )a())baccbbabbcabba)c:a:aa( ()):) a(aa:a ab (b ): ca:)c:::");
	}

}
