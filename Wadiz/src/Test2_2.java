import java.sql.Savepoint;

public class Test2_2 {

	public static void main(String[] args) {

		int[] v = {1, 2, 3};
		
		System.out.println(solution(v));
	}

	public static int solution(int[] v) {
		int answer = -1;

		int cnt = fact(v.length);
		int[] cntArr = new int[cnt];
		
		int max = 0;
		doPermutation(v, 0, cntArr);
		
		return answer;
	}

	public static void doPermutation(int[] arr, int startIdx, int[] cntArr) {
		if(startIdx == arr.length - 1) {
			String a = "";
			for(int n: arr) {
				a += n;
			}
			int sum = 0;
			for(int i=0; i<arr.length-1; i++) {
				if(arr[i] > arr[i+1]) {
					sum += arr[i] - arr[i+1];	
				} else {
					sum += arr[i+1] - arr[i];
				}
				
			}
			System.out.println(a + ":" + sum);
			return;
		}
		
		for(int i = startIdx; i < arr.length; i++) {
			swap(arr, startIdx, i);
			doPermutation(arr, startIdx + 1, cntArr);
			swap(arr, startIdx, i);
		}
	}
	
	public static void swap(int[] arr, int n1, int n2) {
		int temp = arr[n1];
		arr[n1] = arr[n2];
		arr[n2] = temp;
	}
	
	public static int fact(int n) {
		if(n <= 1) {
			return n;
		} else {
			return fact(n-1) * n;
		}
	}
}
