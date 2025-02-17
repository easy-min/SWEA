package 프로그래머스;

import java.util.Arrays;

class Solution {
    public static void main(String args[]) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        System.out.println(binarySearch(stones, k));

    }
    // 돌다리를 건너는 사람들의 범위 1~20억
    public static int binarySearch(int[] stones, int k) {
    	int L = 1;
    	int R = Arrays.stream(stones).max().getAsInt(); // stone의 최댓값
    	while (L <= R) {
    		int mid = (L+R)/2;
    		if (isWalking(stones, k, mid)) L = mid+1;
    		else R = mid-1;
    	}
    	return R;
    }
    public static boolean isWalking (int[] stones, int k, int mid) {
    	int zeroStones = 0; // 건너뛰지 못한 횟수
    	for (int stone : stones) {
    		if (stone < mid) {
    			zeroStones++;
    			if (zeroStones==k) return false;
    		} else zeroStones = 0;
    	}
    	return true;
    }
}
