package 문제1204_최빈수구하기;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int[] arr = new int[1000];
			for (int i=0; i<1000; i++) {
				arr[i] = sc.nextInt();
 			}
			int answer = counting(arr);

			System.out.println("#" + test_case + " " + answer);
		}
	}
	static int counting(int[] arr) {
		// 1. 가장 큰 수 (점수는 0이상 100이하)
		int max = -1;
		for (int i=0; i<arr.length; i++) {
			if (max < arr[i]) max = arr[i];
		}
		// 2. index 배열
		int[] count = new int[max+1];
		for (int i=0; i<arr.length; i++) {
			count[arr[i]]++;
		}
		// 최빈값 계산
		int answer = 0;
		for (int i=0; i<count.length; i++) {
			if (count[answer] <= count[i]) answer = i;
		}
		return answer;
	}
}
