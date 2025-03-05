package Day02조합;

import java.util.ArrayList;
import java.util.List;

public class 조합04_중복조합 {
	static String[] 재료;
	static int N, R; // N : 전체 재료의 수, R : 내가 뽑을 재료의 수
//	static ArrayList<String[]> result;
	static List<List<String>> result;
	public static void main(String[] args) {
		N = 4;
		R = 2;
		재료 = new String[]{"상추", "패티", "토마토", "치즈"};
//		result = new ArrayList<String[]>();
		combcomb(0, new ArrayList<String>()); // 중간 결과 / 중간 합
	}// main
	// current : 임시 리스트 / 배열로 처리, 등등 인덱스 필요할 지도..
	public static void combcomb(int start, List<String> current) {
		// 종료 조건
		if (current.size() == R) {
//			System.out.println(current);
			List<String>tmp = new ArrayList<>();
			for (String str : current) {
				tmp.add(str);
			}
			result.add(tmp);
			return;
		}
		
		// 재귀 조건
		for (int i = start; i<N; i++) {
			current.add(재료[i]); // 재료 넣기
			combcomb(i, current); // 중복 허용이니 i를 다시 고려하도록
			// 재료 빼기
			current.remove(current.size()-1); // 마지막 인덱스 요소 빼기
		}
	}

}
