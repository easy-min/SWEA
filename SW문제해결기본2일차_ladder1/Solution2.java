package SW문제해결기본2일차_ladder1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution2 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/SW문제해결기본2일차_ladder1.txt"));
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			int test = sc.nextInt();
			int[][] arr = new int[100][100];
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			} // 배열 입력 받음
			System.out.println("#"+test_case+" "+findX(arr));
		}
	}

	public static int findX(int[][] arr) {
		// 뒤에서부터 정답을 찾아가기
		int r = arr.length - 1; // 초기화
		int c = -1; // column이 찾아야 하는 것
		for (int i = 0; i < arr.length; i++) {
			if (arr[r][i] == 2) {
				c = i;
				break;
			}
		}
		// 다시 위로 올라가기
		while(r>0) {
			if (c+1<arr.length-1 && arr[r][c+1]==1) { // 오른쪽에 자리가 있을 때
				while (c+1<arr.length-1 && arr[r][c+1]==1) c = c+1;
			}
			// 그냥 if처리하면 오른쪽으로 가다가 다시 왼쪽으로 가는 경우가 발생할 수 있어!
			else if (c-1>=0 && arr[r][c-1]==1) { // 왼쪽에 자리가 있을 때
				while (c-1>=0 && arr[r][c-1]==1) c = c-1;
			}
			r--;
			System.out.println("r"+r+" "+"c"+c);
		}
		return c;
	}
}
