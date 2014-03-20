import java.io.BufferedReader;
import java.io.FileReader;


public class MyStack {

	public static class mystack {
	    
		int[] array;
		int top;
		public mystack(int size){
			
			array = new int[size];
			top = -1;
			
		}
		
		public void push(int num){
			this.array[++top] = num;
		}
		
		public int pop(){
			if(top == -1){
				return 0;
			}else{
				return this.array[top--];
			}
		}
	}
	
	public static void readFromFile(String filename){
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = null;
			
			while((line = br.readLine()) != null){
				startpushnpop(line);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void startpushnpop(String numsquence){
		
		
		String[] str = numsquence.split("\\s");
		mystack stack = new mystack(str.length);
		
		for(String s : str){
			stack.push(Integer.parseInt(s));
		}
		
		startpoppin(stack);
	}
	
	public static void startpoppin(mystack s){
		
		int i = 0;
		
		while(i<s.array.length){
			if(s.top == -1){
				break;
			}
			
			if(i%2 == 0){
				System.out.print(s.pop()+" ");
			}else{
				s.pop();
			}
			i++;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		readFromFile("stackimpl");
	}

}
