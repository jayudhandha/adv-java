package adv_java_trn.basic_funda;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CommonFundamentals {

	public static void main(String[] args) {
		Map<String, Object> hmStd = new LinkedHashMap<>();
		
		hmStd.put("name", "Jayesh");
		hmStd.put("email", "test@gmail.com");
		hmStd.put("college", "B.H.Gardi");
		
		for(String key: hmStd.keySet()) {
			System.out.println(hmStd.get(key));
		}
		
		
	}

}
