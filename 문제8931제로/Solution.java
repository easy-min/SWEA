package 문제8931제로;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/문제8931제로.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			Stack<Integer> nums = new Stack<>();
			int k = sc.nextInt(); // 1<= K<= 100,000
			for (int i = 0; i<k; i++) { // k개의 정수 입력
				int num = sc.nextInt(); // 들어오는 수
				if (num==0) { // 만약 초기화해야 하는 수라면
					// 지울 수 있는 수가 있음을 보장해야 함
					if (nums.isEmpty()) {
						nums.push(num); // 그 수는 그냥 넣어야 함.
					} else {
						nums.pop(); // 이전에 들어갔던 수 빼기	
					}
				} else {
					nums.push(num);
				}
			}// 여기까지가 입력받기
			int answer = 0;
			while(!nums.isEmpty()) {
				answer += nums.pop();
			}
			System.out.println("#" + test_case + " " + answer);
		}
	}
}
