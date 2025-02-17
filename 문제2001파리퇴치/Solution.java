package 문제2001파리퇴치;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("res/문제2001파리퇴치.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt(); // 테스트 케이스 개수

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt(); // 격자 크기
            int M = sc.nextInt(); // 파리채 크기
            int[][] pari = new int[N][N];

            // 격자 입력 받기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    pari[i][j] = sc.nextInt();
                }
            }

            // 최대 파리 개수 계산
            int answer = getMaxFlies(pari, N, M);
            System.out.println("#" + test_case + " " + answer);
        }
        sc.close();
    }

    public static int getMaxFlies(int[][] pari, int N, int M) {
        int maxFlies = 0;

        // 파리채를 놓을 수 있는 모든 위치 탐색
        for (int i = 0; i <= N - M; i++) { // 범위를 넘지 않기 위해서 N-M
            for (int j = 0; j <= N - M; j++) {
                int sum = 0;

                // M x M 범위 내의 파리 개수 계산
                for (int x = 0; x < M; x++) {
                    for (int y = 0; y < M; y++) {
                        sum += pari[i + x][j + y];
                    }
                }

                // 최대값 갱신
                maxFlies = Math.max(maxFlies, sum);
            }
        }
        return maxFlies;
    }
}

