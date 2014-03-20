import java.io.BufferedReader;
import java.io.FileReader;


public class MthLast {

	public static class node {
		
		public String val;
		public node next;
	}
	public static void readFromFile(String filename){
			
			try{
				BufferedReader br = new BufferedReader(new FileReader(filename));
				String line = null;
				
				while((line = br.readLine()) != null){
					buildll(line);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	
	
	public static void buildll(String line){
	 
		 String[] tokens = line.split("\\s");
		 String m = tokens[tokens.length-1];
		 
		 node head = null , current = null;
		 
		 for(int i = 0 ; i < tokens.length-1 ; i++){
			 if(head != null){
				 node n = new node();
				 n.val = tokens[i];
				 current.next = n;
				 current = current.next;
			 }else{
				 head = new node();
				 head.val = tokens[i];
				 current = head;
			 }
		 }
		 
		 //System.out.println(m);
		 getMth(head,Integer.parseInt(m));
	}
	
	public static void getMth(node head , int m){
		
		node rabbit = head;
		int i = 0;
		while(i < m-1){
			if(rabbit != null){
				rabbit = rabbit.next;
			}
			i++;
		}
		//System.out.println(rabbit.val);
		if(rabbit != null){
		
			while(rabbit.next != null){
				rabbit = rabbit.next;
				head = head.next;
			}
			
			System.out.println(head.val);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readFromFile("mthlast");
	}

}
