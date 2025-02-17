package 문제7102준홍이의카드놀이;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Solution2 {
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
		int[] sum = new int[N+M+1]; // 인덱스 1번에 1이 등장하는 빈도 입력
		for (int i = 1; i<N; i++) {
			for (int j = 1; j<M; j++) {
				sum[i+j+1]++;
			}
		}
		// 최대로 등장한 idx 찾기
		int max = 0;
		System.out.print("# "+test_case+" ");
		for (int i = 0; i<N+M; i++) {
			max = Math.max(max, sum[i]);
		}
		for (int i = 0; i<N+M; i++) {
			if (sum[i]==max) {
				System.out.print(i+" ");
			}
		}
		System.out.println();
		
	}

}
