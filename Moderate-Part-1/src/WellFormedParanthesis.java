import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Stack;


public class WellFormedParanthesis {

	public static void readFromFile(String filename){
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = null;
			
			while((line = br.readLine()) != null){
				validparan(line);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void validparan(String line){
		
		Stack<String> openstack = new Stack<String>();
		int index = 0;
		boolean valid = false;
		
		
		while(index < line.length()){
			if(line.charAt(index) == '(' || line.charAt(index) == '{' || line.charAt(index) == '['){
				openstack.push(line.charAt(index)+"");
			}else{
				
				if( line.charAt(index)== ']'){
					if(openstack.size() > 0 && openstack.peek().equals("[")){
						valid = true;
						openstack.pop();
						
					}else{
						valid =false;
						break;
					}
				}
				
				if( line.charAt(index)== '}'){
					
					
					if(openstack.size() > 0 && openstack.peek().equals("{")){
						valid = true;
						openstack.pop();
						
					}else{
						valid =false;
						break;
					}
				}
				
				
				if( line.charAt(index)== ')'){
					
					
					if(openstack.size() > 0 && openstack.peek().equals("(")){
						valid = true;
						openstack.pop();
						
					}else{
						valid =false;
						break;
					}
				}
				
				
				
				
			}
			index++;
		}
		
		if(valid){
			System.out.println("True");
		}else{
			System.out.println("False");
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readFromFile(args[0]);
		//validparan("([)]");
	}

}
