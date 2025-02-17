package SW문제해결기본2일차_ladder1;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("res/SW문제해결기본2일차_ladder1.txt"));
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int test = sc.nextInt(); // 테스트케이스의 번호
            int N = 100; // 사다리는 100x100 형태
            int[][] arr = new int[N][N];
            
            // 사다리 입력 받기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            
            int answer = who(arr);
            System.out.println("#" + test_case + " " + answer);
        }
        sc.close();
    }

    public static int who(int[][] arr) {
        int r = arr.length - 1; // 마지막 줄 (도착점 위치)
        int c = -1; // 도착점의 열 위치
        
        // 도착점(2)의 위치 찾기
        for (int i = 0; i < arr.length; i++) {
            if (arr[r][i] == 2) {
                c = i;
                break;
            }
        }
        // 사다리 타기 (위로 올라가기)
        while (r > 0) {
            // if문만 쓰면 계속 오른쪽으로 이동하거나 왼쪽으로 이동하는 경우에 오류 발생하기 때문에
        	// 먼저 if문으로 조건을 확인하고 else로 계속 식행하는 방식
            if (c > 0 && arr[r][c - 1] == 1) { // 왼쪽 이동 가능
                while (c > 0 && arr[r][c - 1] == 1) c--; // 왼쪽으로 계속 이동
            } else if (c < arr.length - 1 && arr[r][c + 1] == 1) { // 오른쪽 이동 가능
                while (c < arr.length - 1 && arr[r][c + 1] == 1) c++; // 오른쪽으로 계속 이동
            }
            // 왼쪽 오른쪽 모든 조건 확인 -> 위로 올라가야 함
            // 위로 이동
            r--;
        }
        
        return c; // 최종적으로 0번째 줄(출발점)에 도착한 c 값 반환
    }
}

