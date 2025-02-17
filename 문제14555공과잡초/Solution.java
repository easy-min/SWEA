package 문제14555공과잡초;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/문제14555공과잡초.txt"));
		Scanner sc = new Scanner(System.in);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		sc.nextLine();
		// 망가진 공과 멀쩡한 공의 합을 구하는 문제
		for (int test_case = 1; test_case <= T; test_case++) {
			String s = sc.nextLine();
			
			int answer = ballCount(s);
			System.out.println("#" + test_case + " " + answer);
		}
	}
	public static int ballCount(String s) {
		int ball = 0;
		boolean ball_start = false;
		for (int i = 0; i<s.length(); i++) {
			if (s.charAt(i)=='(') {
				ball_start = true;
				ball++;
			} else if (s.charAt(i)==')') {
				if (ball_start) {
					ball_start = false;
				} else {
					ball++;
				}
			} else {
				ball_start= false;
			}
		}
		return ball;
	}

}
