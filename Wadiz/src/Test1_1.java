
public class Test1_1 {
	public static void main(String[] args) {
		int N = 1;
		System.out.println("RESULT: " + solution(N));
	}

	
	public static int solution(int N) {
		int RESULT = -1;
		int MAX = 1000000000;
		int MIN = 1;
		
		if(N == MIN) {	// 최소값일 경우
			RESULT = 0;
		} else if (MIN <= N && N <= MAX) {	// 최소,최대 범위 안일 경우
			RESULT = 1;
			while(N/MAX == 0) {
				N /= 10;
				if(N == 0) {
					break;
				}
				//System.out.println(N %10);
				RESULT *= 10;
			}
		} else {	// 범위 외의 수일 경우
			System.out.println("범위 바깥입니다.");
		}
		System.out.println("===========================================================");
		return RESULT;
	}
}
