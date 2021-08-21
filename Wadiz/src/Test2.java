
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Test2 {
	public static void main(String[] args) {
		String[] code = {
				"a=3", 
				"..a=4", 
				"..b=3", 
				"..print a", 
				".......a=6", 
				".......print a", 
				".......print b", 
				"..print a", 
				"....a=7", 
				"....print a", 
				"print a", 
				"print b", 
				"a=4", 
				"print a",
				"...print a"
		};
		solution(code);
	}

	public static String[] solution(String[] code) {

		ArrayList<String> answerList = new ArrayList<String>();

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		int block = 1;		// 현재블록
		int bCount = 0;
		for(int i=0; i < code.length; i++) {
			if(code[i].indexOf("=") > -1) {
				// 선언문
				System.out.print("선언문: ");
				System.out.println(code[i]);
				String[] splitC = code[i].split("=");
				
				int count = countChar(splitC[0]);		// 점의 개수 구하기
				
//				System.out.println("점의개수: " + count);
				if(i != 0 && count != 0) {
					if(bCount < count) {		// 블록 추가
						block++;
					} else if(bCount > count) {	// 블록 삭제
						block--;
						
						// 삭제된 블록안의 변수 삭제
						removeValue(map, block);
					}
					bCount = count;
				} else if(i != 0 && count == 0) { // 블록 초기화
					block = 1;
					bCount = count;
					
					// 삭제된 블록안의 변수 삭제
					removeValue(map, block);
					
				}
//				System.out.println("현재 블록은 " + block + "번째 입니다.");
				String varC = splitC[0].replace(".", "");
				map.put(varC + "_" + block, Integer.parseInt(splitC[1]));
			} else {
				// 출력문
				System.out.print("출력문: ");
				System.out.println(code[i]);
				
				String[] splitC = code[i].split("print");
				int count = countChar(splitC[0]);		// 점의 개수 구하기
				if(i != 0 && count != 0) {
					if(bCount < count) {		// 블록 추가
						block++;
					} else if(bCount > count) {	// 블록 삭제
						block--;
						
						// 삭제된 블록안의 변수 삭제
						removeValue(map, block);
					}
					bCount = count;
				} else if(i != 0 && count == 0) { // 블록 초기화
					block = 1;
					bCount = count;
					
					// 삭제된 블록안의 변수 삭제
					removeValue(map, block);
				}
//				System.out.println("현재 블록은 " + block + "번째 입니다.");
				
				String valName = splitC[1].replace(" ", "");
//					System.out.println( String.format("키 -> %s, 값 -> %s", key, map.get(key)) );
				if(map.get(valName + "_" + block) != null) {
//					System.out.println(valName + "=" + map.get(valName + "_" + block));
					answerList.add(valName + "=" + map.get(valName + "_" + block));
				} else {
					boolean getk = false;
					for(int l=block; l > 0; l--) {
						if(!getk) {
							if(map.get(valName + "_" + l) != null) {
//								System.out.println(valName + "=" + map.get(valName + "_" + l));
								answerList.add(valName + "=" + map.get(valName + "_" + l));
								getk = true;
							} 
						}
					}
					if(!getk) {
//						System.out.println("error");
						answerList.add("error");
					}
					
				}
				
			}
//			System.out.println();
		}

		System.out.println("=======map==========");
		for( String key : map.keySet() ){
			System.out.println( String.format("키 -> %s, 값 -> %s", key, map.get(key)) );
		}

		// ArrayList를 배열로 변환
		int arrListSize = answerList.size();
		String answer[] = answerList.toArray(new String[arrListSize]);

		System.out.println("=======answer==========");
		for(int i=0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
		
		return answer;
    }
    
    // 점의 개수
	public static int countChar(String str) {
		int count = 0;	
		for (int j = 0; j < str.length(); j++) {
			if (str.charAt(j) == '.') {
			count++;
			}
		}
		
		return count;
	}
    
    // 삭제된 블록안의 변수 삭제
	public static void removeValue(HashMap<String, Integer> map, int block) {
		Iterator<String> keys = map.keySet().iterator();
		while( keys.hasNext() ){
			String key = keys.next();
			String[] splitK = key.split("_");
			if(Integer.parseInt(splitK[1]) > block) {
				map.remove(key);
				keys = map.keySet().iterator();
			}
		}
	}
}
