import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Stack;



public class BalancedSmileys {

	
	 public static void readFromFile(String filename){
			
			try{
				BufferedReader br = new BufferedReader(new FileReader(filename));
				String line = null;
				
				while((line = br.readLine()) != null){
					balancedsmileys(line);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	 
	 
	 public static void balancedsmileys(String s){
		Stack<String> stack = new Stack<String>();
		int i = 0;
		int size = 0;
		int undecidedclose = 0;
		int undecidedopen = 0;
		
		while(i < s.length()){
			if(i-1 > 0 && (s.charAt(i) == '(' || s.charAt(i) == ')') && s.charAt(i-1) == ':'){
				if(s.charAt(i-1) == ':' && s.charAt(i) == ')' && stack.size() > 0 ){
					undecidedclose++;
				}else if(s.charAt(i-1) == ':' && s.charAt(i) == ')'){
					undecidedopen++;
				}
				
				i++;
				continue;
			}
		    else if(s.charAt(i) == '('){
				stack.push(s.charAt(i)+"");
			}
			else if(s.charAt(i) == ')'){
				if(!stack.isEmpty()){
					stack.pop();
				}
				else if(undecidedopen > 0){
					undecidedopen--;
				}
				else{
					size--;
					break;
				}
			}
			i++;
		}
		
		if(size < 0){
			System.out.println("NO");
		}
		//System.out.println(size+"  "+stack.size()+"  "+undecided);
		else if(((stack.size() - undecidedclose == 0) || stack.size() == 0)){
			 System.out.println("YES");
		}
		else if(stack.size() > 0 ){
			 System.out.println("NO"); 
		}
	 }
	public static void main(String[] args) {
		//readFromFile(args[0]);
		
		balancedsmileys("bb:bca:):)))aabc:(a(c:(:b:()):c(c:a ab:(b )(a a:() abb():)cbbac)():aa (a:aaccc):");
	}

}
