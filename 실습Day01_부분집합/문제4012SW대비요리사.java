package 실습Day01_부분집합;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/* 최대한 비슷한 맛의 음식
 * N개의 식재료. N/2개씩 나누어 두 개의 요리를 하려고 한다
 * A,B 맛의 차이가 최소가 되도록 재료를 배분해야 한다
 * 
 */
public class 문제4012SW대비요리사 {
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/문제4012SW대비요리사.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				StringTokenizer st = new StringTokenizer(s);
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 입력
			
			for (int i = 0; i < (1 << N); i++) {
				int countzero = 0;
				Stack<Integer> stack = new Stack<>();
				int[] items = new int[N/2];
				for (int j = 0; j<N; j++) {
					if ((i&(1<<j))==0) {
						countzero++;
						stack.add(j);
					}
				}
				if (countzero==N/2) { // 딱 절반만일 때
					for (int k = 0; k<(1<<countzero); k++) {
						for (int d = 0; d<countzero; d++) {
							if()
						}
					}
				}
			}// 계산중
		}
	}
}
