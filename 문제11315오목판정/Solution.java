package 문제11315오목판정;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("res/문제11315오목판정.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt(); // 5 <= N <= 20
            sc.nextLine();
            
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                String s = sc.nextLine();
                for (int j = 0; j < N; j++) {
                    if (s.charAt(j) == '.') arr[i][j] = 0;
                    else arr[i][j] = 1; // 돌일 때
                }
            }
            
            String answer = findFiveStone(arr);
            System.out.println("#" + test_case + " " + answer);
        }
        sc.close();
    }

    public static String findFiveStone(int[][] arr) {
        int[] dx = {0, 1, 1, 1}; // 오른쪽, 아래, 우하 대각선, 좌하 대각선
        int[] dy = {1, 0, 1, -1};

        int N = arr.length;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1) {
                    for (int d = 0; d < 4; d++) { // 4가지 방향 확인
                        int count = 1;
                        for (int k = 1; k < 5; k++) { // 5개까지 확인
                            int nx = i + k * dx[d];
                            int ny = j + k * dy[d];

                            if (nx < 0 || nx >= N || ny < 0 || ny >= N) break; // 범위 초과
                            if (arr[nx][ny] != 1) break; // 돌이 아니면 중단
                            count++;
                        }
                        if (count == 5) return "YES"; // 오목 완성
                    }
                }
            }
        }
        return "NO"; // 오목이 없음
    }
}
