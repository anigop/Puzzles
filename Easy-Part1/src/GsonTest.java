import java.math.BigInteger;

import com.google.gson.Gson;


public class GsonTest {

	
	public static void main(String[] args){
		
		
		BigIntClass b = new BigIntClass();
		
		b.id = new BigInteger("92321263758953");
		
		Gson g = new Gson();
		System.out.println(g.toJson(b));
	}
}
