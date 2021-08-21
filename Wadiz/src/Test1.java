
public class Test1 {

	public static void main(String[] args) {

		int[][] passwords = {
				{101, 1234}, {102, 54321}, {201, 202}, {202, 1}
		};

		String s = "101#1234#102#654321#51#203#201#202#1#";
		solution(passwords, s);
	}

	public static int solution(int[][] passwords, String s) {
		int answer = 0;
		System.out.println("비교해야하는 문자열: " + s);
		String[] splitS = s.split("#");

		// password 출력
		for (int i = 0; i < passwords.length; i++) {
			int[] inArr = passwords[i];
			for (int j = 0; j < inArr.length; j++) {
				if(j == 0) {
					System.out.print(i +"번째 세대의 호수: " + inArr[j] + "/");        
				} else if(j == 1) {
					System.out.println("비밀번호: " + inArr[j]);        
				}
			}
		}

		System.out.println();
		for(int i = 0; i < splitS.length; i++) {
			if(i % 2 == 0) {    // 호수
				if(i+1 < splitS.length) {
					System.out.println("입력한 호수: " + splitS[i] + ", 비밀번호: " + splitS[i+1]);
				}

				for (int j = 0; j < passwords.length; j++) {
					int[] inArr = passwords[j];

					for (int k = 0; k < inArr.length; k++) {
						if(k == 0) {
							if(Integer.parseInt(splitS[i]) == inArr[k]) {
								if(i+1 < splitS.length) {
									if(Integer.parseInt(splitS[i+1]) == inArr[k+1]) {
										System.out.println(inArr[k] + "의 비밀번호는 " + inArr[k+1] + "(올바르게 입력)");
										answer++;
									}
								}
							}
							//System.out.println(j +"번째 세대의 호수: " + inArr[k]);        
						} else if(k == 1) {
							//System.out.println(j +"번째 세대의 비밀번호: " + inArr[k]);        
						}
					}
				}


			} else if(i % 2 == 1) { // 비밀번호
				//System.out.println("비밀번호: " + splitS[i]);
			}

		}
		
		System.out.println("answer:" + answer);
		return answer;
	}

}
