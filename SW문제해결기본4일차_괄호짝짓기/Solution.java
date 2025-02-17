package SW문제해결기본4일차_괄호짝짓기;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/SW문제해결기본4일차_괄호짝짓기.txt"));
		Scanner sc = new Scanner(System.in);
		int T= 10;
		HashMap<Character, Character> parentheses = new HashMap<>();
		parentheses.put(')', '(');
		parentheses.put(']', '[');
		parentheses.put('}', '{');
		parentheses.put('>', '<');
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int len = sc.nextInt(); // 테스트케이스의 길이
			sc.nextLine();
			String s = sc.nextLine();
			int answer = isPerfect(parentheses, s);
			System.out.println("#" + test_case + " " + answer);
		}
	}
	public static int isPerfect(HashMap<Character, Character> parentheses, String s) {
		char[] str = s.toCharArray();
		Stack<Character> stacks = new Stack<>();
		for (int i = 0; i<str.length; i++) {
			if (parentheses.containsValue(str[i])) { // 왼쪽
				stacks.push(str[i]);
			} else if (parentheses.containsKey(str[i])) { // 오른쪽
				if (stacks.isEmpty()) return 0; // 개수 안 맞음
				if (stacks.pop() != parentheses.get(str[i])) return 0; // 짝이 안 맞음
			} else { } // 그 어느 것도 아님
		}
		if (stacks.isEmpty()) return 1; // 이제 더 볼 것도 없다면
		return 0; // 아직 스택에 남아 있음
	}
}
