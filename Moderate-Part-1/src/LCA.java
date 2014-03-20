import java.io.BufferedReader;
import java.io.FileReader;


public class LCA {

	public static class node{
		
		String val;
		node left;
		node right;
	}
	
	
	public static void readFromFile(String filename){
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = null;
			
			while((line = br.readLine()) != null){
				lca(line);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	public static void lca(String line){
		
		String[] token = line.split("\\s");
		
		
		node root = buildTree();
		
		node current = root;
		
		while(current != null){
			
			if(nam(current.val) == nam(token[0]) || nam(current.val) == nam(token[1])){
				System.out.println(current.val);
				break;
			}
			if((nam(current.val) > nam(token[0]) && nam(current.val) < nam(token[1])) || (nam(current.val) < nam(token[0]) && nam(current.val) > nam(token[1]))){
				System.out.println(current.val);
				break;
			}
			else if(nam(current.val) > nam(token[0])){
				current = current.left;
			}else{
				current = current.right;
			}
			
			
		}
		
	}
	
	public static int nam(String num){
		return Integer.parseInt(num);
	}
	public static node buildTree(){
		
		node root = new node();
		root.val = "30";
		
		
		root.left = new node();
		root.left.val = "8";
		
		root.right = new node();
		root.right.val = "52";
		
		node left1 = root.left;
		
		left1.left = new node();
		
		left1.left.val = "3";
		
		left1.right = new node();
		left1.right.val = "20";
		
		
		node right = left1.right;
		right.left = new node();
		
		right.left.val = "10";
		right.right = new node();
		
		right.right.val = "29";
		
		return root;
	}
	public static void main(String[] args) {
		
		
        readFromFile(args[0]);
	}

}
