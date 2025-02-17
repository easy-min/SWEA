package 문제2001파리퇴치;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution2 {
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
        for (int i = 0; i<N; i++) {
        	for (int j = 0; j<N; j++) {
        		int Flies = 0;
        		for (int x = 0; x<M; x++) { // m은 2이상 N이하
        			for (int y = 0; y<M; y++) {
        				if (i+x > pari.length-1 || j+y > pari.length-1) {
        				} else {
            				Flies += pari[i+x][j+y];
        				}
        			}
        		}
        		if (Flies > maxFlies) {
        			maxFlies = Flies;
        		}
        	}
        }
        return maxFlies;
    }
}

