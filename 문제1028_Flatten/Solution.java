package 문제1028_Flatten;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
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

            int answer = flatten(arr, dump);
            System.out.println("#" + test_case + " " + answer);
        }
    }

    public static int flatten(int[] arr, int dump) {
        for (int d = 0; d < dump; d++) {
            // 최고점과 최저점 찾기
            int maxIndex = 0, minIndex = 0;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > arr[maxIndex]) maxIndex = i;
                if (arr[i] < arr[minIndex]) minIndex = i;
            }

            // 평탄화가 완료되었는지 확인
            if (arr[maxIndex] - arr[minIndex] <= 1) break;

            // 덤프 실행 (최고점 -1, 최저점 +1)
            arr[maxIndex]--;
            arr[minIndex]++;
        }

        // 최종 최고점과 최저점 찾기
        int max = arr[0], min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
            if (arr[i] < min) min = arr[i];
        }

        return max - min;
    }
}
