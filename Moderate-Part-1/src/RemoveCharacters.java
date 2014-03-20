import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;


public class RemoveCharacters {
	
	public static void readFromFile(String filename){
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = null;
			
			while((line = br.readLine()) != null){
				removeCharacters(line);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void removeCharacters(String line){
		
		HashSet<Character> trashthis = new HashSet<Character>();
		
		String[] token = line.split(",");
		String s = "";
		int index = 0;
		String sentence = token[0].trim();
		String trashables = token[1].trim();
		
		while(index < trashables.length()){
			if(trashables.charAt(index) != ' '){
				trashthis.add(trashables.charAt(index));
			}
			index++;
		}
		
		
		for(int i =0 ; i< sentence.length();i++){
			char c = sentence.charAt(i);
			
			if(!trashthis.contains(c)){
				s += c;
			}
		}
	
		
		System.out.println(s);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readFromFile(args[0]);
	}

}
