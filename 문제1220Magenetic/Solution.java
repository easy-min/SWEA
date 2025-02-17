package 문제1220Magenetic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/문제1220Magenetic.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = 10;
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 모두 100이 들어감
			int[][] arr = new int[N][N];
			// 문제는 한 쪽 방향으로만 진행되지 않는 경우 모두 교착상태에 빠짐
			for (int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j<N; j++) {
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

	    for (int j = 0; j < N; j++) { // 열 기준 탐색
	        boolean hasNorth = false; // N극(1)이 나왔는지 체크

	        for (int i = 0; i < N; i++) {
	            if (arr[i][j] == 1) { 
	                hasNorth = true; // 1을 만나면 N극이 시작됨
	            } 
	            else if (arr[i][j] == 2 && hasNorth) { 
	                // S극(2)이 나오고 앞에 N극(1)이 있었으면 교착 상태 발생!
	                count++;
	                hasNorth = false; // 다시 새로운 교착 상태를 찾기 위해 초기화
	            }
	        }
	    }
	    return count;
	}


}
