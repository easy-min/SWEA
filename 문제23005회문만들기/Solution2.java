package 문제23005회문만들기;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution2 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/문제23005회문만들기.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String s = sc.nextLine();
			StringBuilder sb = new StringBuilder();
			
			// 공백 제거
			for (String abc : s.split(" ")) {
				sb.append(abc);
			}

			int answer = minInsertionsToPalindrome(sb.toString());
			System.out.println(answer);
		}
		sc.close();
	}

	// 투 포인터 알고리즘을 사용한 최소 'x' 삽입 횟수 계산
	public static int minInsertionsToPalindrome(String s) {
		int left = 0, right = s.length() - 1;
		int count = 0;

		while (left < right) {
			if (s.charAt(left) == s.charAt(right)) {
				// 문자가 일치하는 경우, 다음 비교로 이동
				left++;
				right--;
			} else if (s.charAt(left) == 'x') {
				// 왼쪽이 'x'이면 추가할 필요 없이 포인터 이동
				left++;
				count++;
			} else if (s.charAt(right) == 'x') {
				// 오른쪽이 'x'이면 추가할 필요 없이 포인터 이동
				right--;
				count++;
			} else {
				// 두 문자가 다르고 'x'가 없으면 회문 불가능
				return -1;
			}
		}
		return count;
	}
}
