package 문제1230암호문3;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("res/문제1230암호문3.txt"));
        Scanner sc = new Scanner(System.in);
        int T = 10;  // 테스트 케이스 개수
        
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();  // 원본 암호문 뭉치 속 암호문의 개수
            sc.nextLine();  // 개행 처리
            String s = sc.nextLine();  // 원본 암호문 뭉치
            String[] sArray = s.split(" ");
            
            // 원본 암호문을 LinkedList로 변환
            LinkedList<Integer> secrets = new LinkedList<>();
            for (String str : sArray) {
                secrets.add(Integer.parseInt(str));
            }
            
            int M = sc.nextInt();  // 명령어의 개수
            sc.nextLine();  // 개행 처리
            String order = sc.nextLine();  // 명령어 한 줄 읽기
            String[] parts = order.split(" ");
            
            int i = 0; // parts 배열의 인덱스
            while (i < parts.length) {
                // 명령어 처리
                switch (parts[i]) {
                    case "I":  // Insert
                        int index = Integer.parseInt(parts[i + 1]);
                        int count = Integer.parseInt(parts[i + 2]);
                        for (int j = 0; j < count; j++) {
                            secrets.add(index + j, Integer.parseInt(parts[i + 3 + j]));  // index 위치에 삽입
                        }
                        i = i + 3 + count;  // 명령어 처리 후 i 업데이트
                        break;
                    case "D":  // Delete
                        int delIndex = Integer.parseInt(parts[i + 1]);
                        int delCount = Integer.parseInt(parts[i + 2]);
                        for (int j = 0; j < delCount; j++) {
                            secrets.remove(delIndex);  // delIndex 위치에서 삭제
                        }
                        i = i + 3;  // 명령어 처리 후 i 업데이트
                        break;
                    case "A":  // Append
                        int appendCount = Integer.parseInt(parts[i + 1]);
                        for (int j = 0; j < appendCount; j++) {
                            secrets.add(Integer.parseInt(parts[i + 2 + j]));  // 끝에 추가
                        }
                        i = i + 2 + appendCount;  // 명령어 처리 후 i 업데이트
                        break;
                }
            }
            
            // 결과 출력 (첫 10개 값만 출력)
            System.out.print("#" + test_case + " ");
            int count = 0;
            for (int num : secrets) {
                if (count++ == 10) break;
                System.out.print(num + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
