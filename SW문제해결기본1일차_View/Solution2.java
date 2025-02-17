package SW문제해결기본1일차_View;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

class Solution2 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/SW문제해결기본1일차_View.txt"));
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 4<=N<=1000
			sc.nextLine();
			String s = sc.nextLine();
			int[] arr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
			int answer = findBuilding(arr);

			System.out.println("#" + test_case + " " + answer);
		}
	}
	public static int findBuilding(int[] arr) {
		int answer = 0;
		for (int i = 2; i<arr.length-2; i++) { // 처음 2, 마지막 2개는 비어 있음
			int maxHeight = Math.max(arr[i+2] ,Math.max(arr[i+1], Math.max(arr[i-2], arr[i-1])));
			if (arr[i] > maxHeight) answer += arr[i] - maxHeight;
		}
		return answer;
	}
}
