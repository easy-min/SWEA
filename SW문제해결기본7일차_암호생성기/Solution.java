package SW문제해결기본7일차_암호생성기;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/SW문제해결기본7일차_암호생성기.txt"));
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int test = sc.nextInt();
			Queue<Integer> queue = new LinkedList<>();
			for (int i = 0; i<8; i++) {
				queue.add(sc.nextInt());
			}
			
			// 0이 생기는 순간 종료
			makeSecret(queue);
			System.out.print("#" + test + " ");
			for (int num:queue) {
				System.out.print(num+" ");
			}
			System.out.println();
		}
	}
	public static void makeSecret(Queue<Integer> queue) {
		boolean find = false;
		while(!find) {
			for (int i = 1; i<=5; i++) {
				int qNum = queue.poll();
				int num = ((qNum -i >0) ? qNum - i : 0);
				queue.add(num);
				if (num<=0) {
					find= true;
					break;
				}
			}
			
			
		}
	}

}
