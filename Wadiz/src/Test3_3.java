import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test3_3 {

	public static void main(String[] args) {

		int N = 3;
		int[] coffee_times = {4, 2, 2, 5, 3};

		solution(N, coffee_times);
	}

	public static int[] solution(int N, int[] coffee_times) {
		int[] answer = new int[coffee_times.length];        // [2, 3, 1, 5, 4]
		int[] hole = new int[N];        // 추출구
		int[] order = new int[N];       // 추출구에 배정된 커피번호

		int min = coffee_times[0];
		for(int i =0; i<coffee_times.length; i++){
			min = Math.min(coffee_times[i],min);
		}

		// 커피 배정
		int pointer = 0;    // 몇번 커피
		for(int i=0; i < hole.length; i++) {
			hole[i] = coffee_times[i] - min + 1;
			order[i] = pointer;
			pointer++;
		}
		int complete = 0;
		int second = 0;
		while(true) {
			if(complete == coffee_times.length) break;
			second++;

			List<Integer> sameTime = new ArrayList<>();
			for(int i=0; i < hole.length; i++) {
				hole[i]--;
				if(hole[i] == 0) {
					sameTime.add(order[i]+ 1);
					// 새로운 커피 배정
					if(pointer < coffee_times.length) {
						hole[i] = coffee_times[pointer] - min + 1;
						order[i] = pointer;
						pointer++;
					}
				}
			}
			// 동시배정 문제 해결
			sameTime.sort(Comparator.naturalOrder());
			for(int i=0; i < sameTime.size(); i++) {
				answer[complete] = sameTime.get(i);
				complete++;
			}
		}
		return answer;
	}

}
