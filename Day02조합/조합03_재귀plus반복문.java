package Day02조합;

import java.util.ArrayList;
import java.util.Arrays;

public class 조합03_재귀plus반복문 {
	static String[] 재료;
	static String[] sel; // 햄버거를 만드는 재료
	static int N, R; // N : 전체 재료의 수, R : 내가 뽑을 재료의 수
	static ArrayList<String[]> result;
	public static void main(String[] args) {
		N = 4;
		R = 2;
		재료 = new String[]{"상추", "패티", "토마토", "치즈"};
		sel = new String[R];
		result = new ArrayList<String[]>();
		comb(0,0);
		for (String[] arr : result) {
			System.out.println(Arrays.toString(arr));
		}
		
	}// main
	// idx : 내가 이번에 고려할 (판단할) 재료들의 인덱스
	// sidx : 뽑은 재료의 인덱스
	public static void comb(int idx, int sidx) {
		// 종료 조건
		if (sidx == R) {
			System.out.println(Arrays.toString(sel));
			result.add(sel);
			return;
		}
		// 재귀조건
		// 첫번째 재료로 치즈를 고려하지는 않을거야.
		// 범위를 정해놓고 호출할 것!
		for(int i = idx; i <= N-R+sidx;i++) {
			sel[sidx] = 재료[i];
			comb(i+1, sidx+1);
		}
	}

}
