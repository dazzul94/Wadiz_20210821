import java.util.HashMap;

public class Test2_1 {
	public static void main(String[] args) {
		int[] A = {6, 2, 3, 5, 6, 3};

		System.out.println("RESULT: " + solution(A));
	}


	public static int solution(int[] A) {
		int RESULT = -1;
		int MAX = 1000000000;
		int ARR_MAX = 200000;

		// 주머니 만들기
		int [] pocket = new int[A.length];
		for(int i = 0; i < pocket.length; i++) {
			pocket[i] = 0;
		}

		System.out.println("배열의 크기: " + A.length);
		if(A.length <= ARR_MAX) { // 배열의 가장 큰 크기는 200000

			// 주머니에 넣기
			for(int i=0; i < A.length; i++) {
				pocket[A[i]-1]++;
			}
			System.out.println("===========================================================");
			// 주머니 출력해보기

			HashMap<Integer,Integer> emptyMap = new HashMap<Integer,Integer>();
			HashMap<Integer,Integer> moveMap = new HashMap<Integer,Integer>();

			// 비어있는 주머니 체크
			for(int i = 0; i < pocket.length; i++) {
				System.out.print(i+1+ ": " + pocket[i]);
				if(pocket[i] == 0) {
					System.out.println(" (비었음)");
					emptyMap.put(i+1, pocket[i]);
				} else if(pocket[i] == 1) {
					System.out.println("");
					// System.out.println(" (OK)");
				} else {
					moveMap.put(i+1, pocket[i]);
					System.out.println(" (이동필요)");
				}
			}

			System.out.println("===========================================================");

			// 최소 이동수 세기
			RESULT = MAX;
			for(Integer i : emptyMap.keySet()){
				for(Integer j : moveMap.keySet()){

					int selectI = i;
					int selectJ = j;
					int count = 0;
					
					int a = ((i - j) >= 0) ? (i - j) : -(i - j);
					System.out.println(j + "에서" + i + "로 " +  a + "만큼 이동");
					count += a;
					
					for(Integer k : emptyMap.keySet()){
						for(Integer l : moveMap.keySet()){
							
							if(k != selectI && l != selectJ) {
								int b = ((k - l) >= 0) ? (k - l) : -(k - l);
								count += b;
								System.out.println(k + "에서" + l + "로 " +  b + "만큼 이동");
								//System.out.println();
							}
							
						}
					}
					
					System.out.println("개수: " + count);
					if(RESULT > count) {
						RESULT = count;
					}
				}
			}
			
			if(RESULT > MAX) {	// 최소 무빙수가 MAX보다 크면 결과는 -1 로 리턴
				RESULT = -1;
			}
		}
		System.out.println("===========================================================");
		return RESULT;
	}
}
