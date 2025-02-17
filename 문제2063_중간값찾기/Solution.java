package 문제2063_중간값찾기;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int N;
		N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
//		System.out.println(selection(arr, arr.length / 2));
		System.out.println(counting(arr, arr.length / 2));

	}

	static int selection(int[] arr, int key) {
		for (int i = 0; i < arr.length - 1; i++) {
			int minIdx = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIdx] > arr[j])
					minIdx = j;
			}
			int tmp = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = tmp;
		}
		return arr[key];
	}

	static int counting(int[] arr, int key) {
		int maxInt = -1;
		// 1. max 계산하기 (문제에서 min은 0이상)
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > maxInt)
				maxInt = arr[i];
		}
		int[] count = new int[maxInt + 1];
		// 2. count 계산하기 (몇 번 나오는지)
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}
		// 3. 누적 count 계산하기
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}
		// 4. 뒤에서부터 순회하면서 위치 찾기
		int[] sortArr = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			sortArr[--count[arr[i]]] = arr[i];
		}

		return sortArr[key];
	}
}
