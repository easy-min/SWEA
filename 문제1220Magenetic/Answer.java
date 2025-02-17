package 문제1220Magenetic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Answer {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("res/문제1220Magenetic.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine().trim()); // 문제에서 항상 100이 주어짐
            int[][] arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = findMagnetic(arr);
            System.out.println("#" + test_case + " " + answer);
        }
    }

    public static int findMagnetic(int[][] arr) {
        int count = 0;
        int N = arr.length;

        for (int j = 0; j < N; j++) { // 열을 기준으로 탐색
            boolean hasNorth = false; // N극(1)이 등장했는지 여부

            for (int i = 0; i < N; i++) {
                if (arr[i][j] == 1) { // N극(1)이 나오면 플래그 설정
                    hasNorth = true;
                } else if (arr[i][j] == 2 && hasNorth) { 
                    // S극(2)가 나오면, N극(1)이 있었는지 확인 후 count 증가
                    count++;
                    hasNorth = false; // 다시 초기화 (새로운 교착 상태 확인 위해)
                }
            }
        }
        return count;
    }
}
