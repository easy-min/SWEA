package 문제7102준홍이의카드놀이;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/문제7102준홍이의카드놀이.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 카드 1번덱
			int M = sc.nextInt(); // 카드 2번덱
			preventNum(test_case, N, M);
		}
	}
	public static void preventNum(int test_case, int N, int M) {
		int[] sum = new int[N+M];
		for (int i = 1; i<N; i++) {
			for (int j = 1; j<M; j++) {
				sum[i+j+1]++;
			}
		}
		int[] idxs = new int[N+M];
		int idx = 0;
		for (int i = 0; i<N+M; i++) {
			if (sum[idxs[0]] < sum[i]) {
				Arrays.fill(idxs, 0);
				idxs[0] = i;
				idx = 0;
			} else if (sum[idxs[0]] == sum[i]) {
				idxs[++idx] = i;
			}
		}
		System.out.print("#" + test_case + " ");
		for (int i = 0; i<N+M; i++) {
			if (idxs[i]!=0) {
				System.out.print(idxs[i]+" ");
			}
		}
		System.out.println();
	}

}
