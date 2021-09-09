import java.util.Arrays;

class Solution {
	
	public static void main(String[] args) {
		
		int[] v = {20,8,10,1,4,15};
		
		System.out.println(solution(v));
	}
	
	public static int solution(int[] v) {
		int answer = -1;
		int a = 0;
		int b = 0;
		Arrays.sort(v);
		switch (v.length) {
		case 2:
			answer = v[1] - v[0];
			break;
		case 3:
			// 1 2 0
			// 2 0 1
			a = v[2] * 2 - v[0] - v[1];
			b = v[2] - 2 * v[0] + v[1];
			answer = Math.max(a, b);
			break;
		case 4: // 1 3 0 2
			answer = v[3] * 2 + v[2] - v[1] - v[0] * 2;
			break;
		case 5:
			// 2 1 4 0 3
			// 1 4 0 3 2
			a = v[4] * 2 + v[3] + v[2] - v[1] * 2 - v[0] * 2;
			b = v[4] * 2 + v[3] * 2 - v[2] - v[1] - v[0] * 2;
			answer = Math.max(a, b);
			break;

		case 6: // 3 1 5 0 4 2
			answer = v[5] * 2 + v[4] * 2 + v[3] - v[2] - v[1] * 2 - v[0] * 2;
			break;

		case 7:
			// 3 4 1 6 0 5 2
			// 4 1 6 0 5 2 3
			a = v[6] * 2 + v[5] * 2 + v[4] * 2 - v[3] - v[2] - v[1] * 2 - v[0] * 2;
			b = v[6] * 2 + v[5] * 2 + v[4] + v[3] - v[2] * 2 - v[1] * 2 - v[0] * 2;
			answer = Math.max(a, b);
			break;
		case 8: // 3 5 1 7 0 6 2 4
			answer = v[7] * 2 + v[6] * 2 + v[5] * 2 + v[4] - v[3] - v[2] * 2 - v[1] * 2 - v[0] * 2;
			break;
		}
		return answer;
	}

}