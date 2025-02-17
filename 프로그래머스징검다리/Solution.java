package 프로그래머스징검다리;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]){
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		int k = 3;
		System.out.println(solution(stones, k));
	}
	public static long solution(int[] stones, int k) {
		// 징검다리 건너기
		// k는 한 번에 건너 뛸 수 있는 최대 칸 수
		// 최대 몇 명까지 건널 수 있느냐 -> n명은 건널 수 있느냐? (이분탐색으로 변경)
		// stones 배열의 크기는 1이상 200,000 이하 
		// stones 배열의 각 원소들의 값은 1 이상 200,000,000 
		long L = 1;
//		long R = 200000000L;
		long R = Arrays.stream(stones).max().getAsInt();
		while (L <= R) {
			long mid = (L+R)/2;
			if (check(stones, mid, k)) L = mid+1;
			else R = mid-1;
		}
		return R;
	}
	public static boolean check(int[] stones, long mid, int k) {
		// 최소 mid개의 디딤돌의 횟수이상 있어야 인정
		int notStones = 0;
		for (int i = 0; i<stones.length-k; i++) { // 중간에 건너뛸 수 있음
			if (stones[i]>=mid) {
				notStones = 0; // 건넌 것으로 간주하고 건너뛸 수 있는 디딤돌 횟수 초기화
			}
			else {
				notStones++;
				if (notStones >= k) return false;
			}
			
		}
		return true;
	}
}
