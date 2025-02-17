package 문제1288새로운불면증치료법;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int[] count = new int[10]; // 0~9까지의 인덱스
			boolean findAll = false;
			int N = sc.nextInt();
			int NUM = 0;
			int iteration = 1;
			while (!findAll) {
				NUM = N*iteration;
				count = sheep(count, NUM); // 숫자 분해해서 넣기
				int ans = 1;
				for (int i = 0; i<10; i++) ans *= count[i];
				if (ans!=0) findAll = true;
				iteration++;
			}
			System.out.println("#" + test_case + " " + NUM);
		}
	}

	public static int[] sheep(int[] count, int N) {
		String numbers = String.valueOf(N);
		String[] nums = numbers.split("");
		for (int i = 0; i < nums.length; i++) {
			int n = Integer.valueOf(nums[i]);
			count[n]++;
		}
		System.out.println(Arrays.toString(count));
		return count;
	}

}
