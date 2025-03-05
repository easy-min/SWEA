package Day02조합;

import java.util.Arrays;

public class 조합01_재귀함수 {
	static String[] 재료;
	static String[] sel; // 햄버거를 만드는 재료
	static int N, R; // N : 전체 재료의 수, R : 내가 뽑을 재료의 수
	public static void main(String[] args) {
		N = 4;
		R = 2;
		재료 = new String[]{"상추", "패티", "토마토", "치즈"};
		sel = new String[R];
		comb(0,0);
		
	}// main
	
	// idx : 내가 이번에 고려할 (판단할) 재료들의 인덱스
	// sidx : 뽑은 재료의 인덱스
	public static void comb (int idx, int sidx) {
		// 종료 조건
		if (sidx==R) {
			// 재료 선정 완료!
			System.out.println(Arrays.toString(sel));
			return;
		}
		if (idx==N) {
			// 더 이상 고려할 재료가 없어!
			return;
		}
		// 재귀 조건
		sel[sidx] = 재료[idx];
		comb(idx+1, sidx+1); // 이번 재료 포함하고 다음 재료 넘어가자
//		sel[sidx] = null; // 재료를 사용하지 않는다. 그렇지만 어차피 덮어질 것
		comb(idx+1, sidx); // 이번 재료 안 포함하고 다음 재료 넘어가자
	}

}
