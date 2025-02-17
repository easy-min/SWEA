package 문제21131행렬정렬;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        // 파일 입력 설정
        System.setIn(new FileInputStream("res/문제21131행렬정렬.txt"));
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt(); // 테스트 케이스 개수

        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt(); // 행렬 크기
            int[][] arr = new int[n][n];

            // 행렬 입력 받기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            // 결과 출력
            System.out.println(run(arr));
        }

        sc.close();
    }

    private static int run(int[][] arr) {
        int sum = 0;
        int n = arr.length;

        // 첫 번째 행의 두 번째 원소가 2가 아니면 정렬 필요
        if (arr[0][1] != 2) sum++;

        // 첫 번째 행이 올바르게 정렬되어 있는지 확인
        for (int i = 1; i < n - 1; i++) {
            boolean correctNow = arr[0][i] == i + 1;  // 현재 값이 맞는지
            boolean correctNext = arr[0][i + 1] == i + 2; // 다음 값이 맞는지
            if (correctNow && !correctNext) {
                sum += 2; // 연속성이 깨진 경우 정렬 필요
            }
        }

        return sum;
    }
}
