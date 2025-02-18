package 문제3499퍼펙트셔플;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/문제3499퍼펙트셔플.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // (1 ≤ N ≤ 1,000)
			sc.nextLine();
			String s = sc.nextLine();
			String[] arr = s.split(" ");
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i<arr.length/2; i++) {
				if (arr.length%2!=0) { // 홀수
					sb.append(arr[i]+" ");
					sb.append(arr[arr.length/2+i+1]+" ");
				} else {
					sb.append(arr[i]+" ");
					sb.append(arr[arr.length/2+i]+" ");
				} 
			}
			if (arr.length%2!=0) sb.append(arr[arr.length/2]+" ");
			System.out.println("#" + test_case + " " + sb);
		}
	}

}
