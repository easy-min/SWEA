package 문제5432쇠막대기자르기;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/문제5432쇠막대기자르기.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		// 레이저는 ()으로 표현.
		// 쇠막대기의 왼쪽 끝은 '(' 오른쪽 끝은 ')'
		// 괄호 문자의 개수는 최대 100,000
		// ()되는 시점에서 (가 몇개가 있는지 체크하는 것 ()는 제외해야 함
		// ()가 등장함 -> 현재 ( 스택에 있는 것 체크해서 그 size만큼 함
		// 이 때 )가 등장하면 (는 스택에서 제거
		for (int test_case = 1; test_case <= T; test_case++) {
			String s = sc.nextLine();
			int answer = pieceCount(s);
			System.out.println("#" + test_case + " " + answer);
		}
	}

	public static int pieceCount(String s) {
		Stack<Character> sticks = new Stack<>(); // '('을 넣을 것
		char[] str = s.toCharArray();
		int answer = 0;
		boolean isLazer = false;
		// 지금 틀린 점 -> 괄호의 끝에서 +1씩 더 해줘야 함
		for (int i = 0; i < str.length; i++) {
			if (str[i] == '(') {
				if (str[i + 1] == ')') { // 이건 레이저임. -> 자르는 count 들어가기
					answer += sticks.size();
					isLazer = true;
				} else {
					sticks.push(str[i]);
				} // 여기까지가 ( 관련한 것

			} else if (str[i] == ')') {
				if (isLazer) { // 아무것도 하지 않아
					isLazer = false;
				} else {
					sticks.pop(); // '('개수 맞는지 확인 안해도 괜춘
					answer++; // 막대는 두개로 나눠짐
				}
			}
		}
		return answer;
	}
}
