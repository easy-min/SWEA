package SW문제해결기본3일차_회문2;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/SW문제해결기본3일차_회문2.txt"));
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			int test = sc.nextInt(); 
			sc.nextLine();
			String target = sc.nextLine();
			String text = sc.nextLine(); // 문자열의 길이 <= 10;
			int answer = findText(text, target);
			System.out.println("#" + test_case + " " + answer);
		}
	}
	public static int findText(String text, String target) {
		char[] t = text.toCharArray();
		char[] find = target.toCharArray();
		int N = t.length;
		int M = find.length;
		int answer = 0; // 찾은 문자열
		for (int i=0; i<N-M+1; i++) { // 모두 끝까지 다 검색할 필요는 없음
			boolean isOk = true; // 위치가 중요하다. 다음으로 넘어갔을 때 다시 확인하는 과정!!
			for (int j = 0; j<M; j++) { // 해당하는 문자 확인
				if (t[i+j] != find[j]) {
					isOk = false;
					break; // 가장 가까운 반복문 종료
				}
			}
			if (isOk) answer++; // 왜 전부 isOk = false가 되는지 생각해보자.
		}
		return answer;
	}
}
