package SW문제해결기본2일차_sum;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution2 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/SW문제해결기본2일차_sum.txt"));
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for (int test_case=1; test_case<=T; test_case++) {
			int test = sc.nextInt();
			int N = 100;
			int[][] arr = new int[N][N];
			for (int i = 0; i<N; i++) {
				for (int j = 0; j<N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println("#"+test_case+" "+findMaxSum(arr, N));
		}
	}
	public static int findMaxSum(int[][] arr, int N) {
		int diagonal1 = 0;
		int diagnoal2 = 0;
		int answer = 0;
		for (int i = 0; i<N; i++) {
			int sumRow = 0;
			int sumColumn = 0;
			diagonal1 += arr[i][i]; // 대각선 오른쪽 아래
			diagnoal2 += arr[N-1-i][i]; // 대각선 왼쪽 위
			for (int j = 0; j<N; j++) {
				sumRow += arr[i][j];
				sumColumn += arr[j][i];
			}
			int sum = Math.max(sumRow, sumColumn);
			answer = Math.max(answer, sum);
		}
		int sum = Math.max(diagonal1, diagnoal2);
		answer = Math.max(answer, sum);
		return answer;
	}

}
