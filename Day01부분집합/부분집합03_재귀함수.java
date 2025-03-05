package Day01부분집합;

import java.util.Arrays;

public class 부분집합03_재귀함수 {
	static String[] 재료 = {"단무지", "햄", "오이", "계란"};
	static int N = 4;
	static boolean[] sel = new boolean[N];
	public static void main(String[] args) {
		// 문제에서 주어진 대로 테스트 케이스 안에서 초기화를 시키는게 일반적!
		powerset(0);

	}
	// N은 static으로 선언
	// idx : 이번에 판단할 재료!!!!!!! (넣을지 말지)
	public static void powerset(int idx) {
		// 종료 조건 : 재료를 전부 고려했을 때
		if (idx==N) {
			String tmp = "김밥 : ";
			for (int i = 0; i<N; i++) {
				if (sel[i]) {
					tmp+=재료[i];
				}
			}
			System.out.println(tmp);
			return;
		}
		// 재귀 조건
		sel[idx] = true; // 내가 idx 자리의 재료를 넣겠다!!
		powerset(idx+1); // 다음 재료로...
		sel[idx] = false; // idx 자리의 재료를 넣지 않겠다!
		powerset(idx+1); // 다음 재료로...
	}

}
