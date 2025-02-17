package 문제1926간단한369게임;

import java.util.Scanner;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        for (int i = 1; i <= N; i++) {
            String s = String.valueOf(i); // 숫자를 문자열로 변환
            int clapCount = 0; // "3", "6", "9"의 개수를 셀 변수
            
            for (char c : s.toCharArray()) { // 문자열을 문자 배열로 변환하여 하나씩 확인
                if (c == '3' || c == '6' || c == '9') {
                    clapCount++; // "3", "6", "9"가 포함될 때마다 증가
                }
            }
            
            if (clapCount > 0) {
                System.out.print("-".repeat(clapCount) + " "); // 개수만큼 "-" 출력
            } else {
                System.out.print(s + " "); // 3,6,9가 없으면 숫자 출력
            }
        }
    }
}

