package 문제10761신뢰;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution3 {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("res/문제10761신뢰.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt(); // 눌러야 하는 버튼 개수
            int[] btnA = new int[N]; // A가 눌러야 하는 버튼
            int[] btnB = new int[N]; // B가 눌러야 하는 버튼
            char[] whoAB = new char[N]; // 누가 버튼을 눌러야 하는지 저장
            int indexA = 0, indexB = 0, indexAB = 0;

            // 입력 처리
            for (int i = 0; i < N; i++) {
                char who = sc.next().charAt(0);
                whoAB[indexAB] = who; // 누가 버튼을 눌러야 하는지 저장
                if (who == 'O') btnA[indexA++] = sc.nextInt();
                else btnB[indexB++] = sc.nextInt();
            }

            ///////////////////////////////////////////////////////// 버튼을 누르는 시뮬레이션
            int time = 0;
            int pushA = 0, pushB = 0, pushAB = 0; // A, B, 전체 버튼 순서 인덱스
            int standA = 1, standB = 1; // 초기 위치

            while (N>0) { // 모든 버튼을 다 눌렀을 때 종료
                time++; // 매 초마다 시간 증가
                boolean pushedA = false, pushedB = false; // A와 B가 같은 초에 버튼을 눌렀는지 체크

                // A 이동 또는 버튼 누르기
                if (pushA < indexA) {
                    if (standA < btnA[pushA]) {
                        standA++;
                    } else if (standA > btnA[pushA]) {
                        standA--;
                    } else if (standA == btnA[pushA] && whoAB[pushAB] == 'O') {
                        // 현재 위치가 맞고, 버튼을 눌러야 하는 순서가 맞다면
                        pushA++; // A가 버튼을 누름
                        N--;
                        pushAB++;
                        System.out.println(time+"초에 지금 O가 버튼 누름");
                    }
                }

                // B 이동 또는 버튼 누르기
                if (pushB < indexB) {
                    if (standB < btnB[pushB]) {
                        standB++;
                    } else if (standB > btnB[pushB]) {
                        standB--;
                    } else if (standB == btnB[pushB] && whoAB[pushAB] == 'B') {
                        // 현재 위치가 맞고, 버튼을 눌러야 하는 순서가 맞다면
                        pushB++; // B가 버튼을 누름
                        N--;
                        pushAB++;
                        System.out.println(time+"초에 지금 B가 버튼 누름");
                    }
                }
            }

            System.out.println("#" + test_case + " " + time);
        }
        sc.close();
    }
}
