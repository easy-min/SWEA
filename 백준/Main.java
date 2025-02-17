package 백준;

import java.util.Scanner;

public class Main { // 백준에서는 반드시 Main 클래스 사용
	static int N;
	static long[] cow;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		cow = new long[N];
		for (int i = 0; i < N; i++) {
			cow[i] = sc.nextInt();
		}
		// 걸리는 시간을 이분 탐색
		long left = 0; // 가장 빠르게 녹이는 시간
		long right = 300000L * 500000L; // 이보다 오래 걸릴 수는 없다
		// overflow 발생
		// 자바에서 정수를 그냥 적으면 int가 된다.
		while (left <= right) {
			long mid = (left + right) / 2;
			if (check(mid)) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(left);
	}

	static boolean check(long time) {
		long minRight = 500000;
		long maxLeft = -1;
		for (int i = 0; i < N; i++) {
			// 오른쪽 뻗을 수 있는 범위 h = i + time/cow[i]
			minRight = Math.min(minRight, i + time/cow[i]);
			maxLeft = Math.max(maxLeft, i - time/cow[i]);
			if (minRight < maxLeft) {
				return false;
			}
		}
		return true;
	}
}
