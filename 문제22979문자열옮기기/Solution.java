package 문제22979문자열옮기기;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("res/문제22979문자열옮기기.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for (int test_case = 1; test_case <= T; test_case++) {
            String s = sc.nextLine();
            int K = sc.nextInt(); // 연산의 횟수 1~100
            int[] nums = new int[K];
            for (int i = 0; i < K; i++) {
                nums[i] = sc.nextInt(); // -10^9 이상 10^9 이하 (int 범위)
            }
            sc.nextLine();
            
            s = changeNum(nums, s);
            System.out.println("#" + test_case + " " + s);
        }
        sc.close();
    }

    public static String changeNum(int[] nums, String s) {
        int change = 0;
        int length = s.length();

        for (int num : nums) {
            change += num;
            change %= length; // 문자열 길이보다 큰 이동 방지
            if (change < 0) { // 음수일 경우 보정
                change += length;
            }
        }

        // 회전된 문자열 생성
        return s.substring(change) + s.substring(0, change);
    }
}
