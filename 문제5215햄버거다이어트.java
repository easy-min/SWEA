package 실습Day01_부분집합;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문제5215햄버거다이어트 {
	/*
	 * 햄버거의 맛은 최대한 유지하면서 정해진 칼로리를 넘지 않는 햄버거를 주문하여 먹으려고 한다.
	 * (단 여러 재료를 조합하였을 햄버거의 선호도는 조합된 재료들의 맛에 대한 점수의 합으로 결정되고, 같은 재료를 여러 번 사용할 수 없으며, 햄버거의 조합의 제한은 칼로리를 제외하고는 없다.)
	 */

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/실습Day01_부분집합.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case<=T; test_case++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int N = Integer.parseInt(st.nextToken()); // 1<=N<=20 선택할 수 있는 자연수
			int L = Integer.parseInt(st.nextToken()); // 1<=L<=10000 제한하는 칼로리수
			int[] arr_score = new int[N];
			int[] arr_kcal = new int[N];
			for (int i = 0; i < N; i++) {
				s = br.readLine();
				st = new StringTokenizer(s);
				int score = Integer.parseInt(st.nextToken()); // i번째 재료에 대한 평가
				int kcal = Integer.parseInt(st.nextToken()); // i번째 재료에 대한 칼로리
				arr_score[i] = score;
				arr_kcal[i] = kcal;
			} // 입력 받기
			
			int max_score = 0;
			for (int i = 0; i < (1 << N); i++) { // 부분집합의 수
				int kcal = 0;
				int score = 0;
				for (int j = 0; j < N; j++) {
					if ((i & (1 << j)) !=0) {
						kcal += arr_kcal[j];
						score += arr_score[j];
					}
				}// j
				if (kcal <= L) max_score = Math.max(score, max_score);
			}// i
			System.out.println("#"+test_case+" "+max_score);
		}

	}

}
