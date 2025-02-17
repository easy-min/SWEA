package 문제1028_Flatten;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution2 {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("res/input(3).txt"));
        Scanner sc = new Scanner(System.in);
        int T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            int dump = sc.nextInt(); // 덤프 횟수
            int[] arr = new int[100]; // 가로 길이는 항상 100
            for (int i = 0; i < 100; i++) {
                arr[i] = sc.nextInt(); // 높이는 1 이상 100 이하
            }
            int answer = flatten(dump, arr);
            System.out.println("#" + test_case + " " + answer);
        }
        sc.close();
    }

    public static int flatten(int dump, int[] arr) {
        int minIdx = 0, maxIdx = 0;

        for (int i = 0; i < dump; i++) {
            // 🔥 최댓값 & 최솟값 직접 찾기 (정렬 없이)
            minIdx = 0;
            maxIdx = 0;
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) minIdx = j;
                if (arr[j] > arr[maxIdx]) maxIdx = j;
            }

            // ✅ 평탄화 완료 조건
            if (arr[maxIdx] - arr[minIdx] <= 1) {
                return arr[maxIdx] - arr[minIdx];
            }

            // 🔥 덤프 실행 (최대에서 -1, 최소에서 +1)
            arr[minIdx]++;
            arr[maxIdx]--;
        }

        // 🔥 최종 높이 차이 계산 (마지막 덤프 이후)
        minIdx = 0;
        maxIdx = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[j] < arr[minIdx]) minIdx = j;
            if (arr[j] > arr[maxIdx]) maxIdx = j;
        }

        return arr[maxIdx] - arr[minIdx];
    }
}
