package 문제1926간단한369게임;

import java.util.Scanner;

class Solution2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
        	String s = String.valueOf(i);
        	char[] num = s.toCharArray();
        	int clapCount = 0;
        	boolean is369 = false;
        	for (char n : num) {
        		if (n =='3' || n=='6' || n=='9') {
        			is369 = true;
        			clapCount++;
        		}
        	}
        	if (is369) {
        		String clap = "-".repeat(clapCount);
        		System.out.print(clap+" ");
        	} else {
        		System.out.print(s+" ");
        	}
        }
    }
}

