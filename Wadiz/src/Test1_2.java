import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Test1_2 {

	public static void main(String[] args) {
		String s = "ponzmlkigfxedcbAZA";
		System.out.println(solution(s));

	}

	public static String solution(String s){
		String answer = "";
		s = s.toLowerCase();
		
		HashMap<String, Integer> cntMap = new HashMap<String, Integer>();

		for(int i=0; i<s.length(); i++){
			String character = Character.toString(s.charAt(i));
			cntMap.put(character, (cntMap.get(character) != null)?cntMap.get(character)+1:1);
		}

		String maxEntry = Collections.max(cntMap.entrySet(), Map.Entry.comparingByValue()).getKey();	// z
		
		for(String key : cntMap.keySet()) {
			System.out.println(key + ", " + cntMap.get(key));
			if(cntMap.get(maxEntry).equals(cntMap.get(key))) {
				answer += key;
			}
		}
		return answer;
	}

}
