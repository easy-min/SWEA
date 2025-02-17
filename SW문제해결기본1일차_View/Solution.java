package SW문제해결기본1일차_View;

import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 4<=N<=1000
			// 입력 받을 때 애초에 안되는 부분은 제외시키기
			// 2칸 이전 보다 낮다면 제거하기.
			int[] arr = new int[N];
			for (int i =0; i< N; i++) {
				arr[i] = sc.nextInt();
			}
			
			
			int answer = findBuilding(arr);

			System.out.println("#" + test_case + " " + answer);
		}
	}
	public static int findBuilding(int[] arr) {
		int[] dir = {-2, -1, 1, 2};
		int answer = 0;
		for (int i = 2; i<arr.length-2; i++) {
			int maxHeight = arr[i];
			for (int d : dir) {
				maxHeight = (maxHeight > arr[i+d] ? maxHeight : arr[i+d]);
			}
			if (arr[i] > maxHeight) answer += arr[i]-maxHeight;
		}
		return answer;
	}
}
