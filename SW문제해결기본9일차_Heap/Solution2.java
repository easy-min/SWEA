package SW문제해결기본9일차_Heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution2 {
    static int[] heap;
    static int heapSize;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine()); // 연산의 수
            heap = new int[N + 1]; // 최대 N개의 요소 저장 가능
            heapSize = 0; // 힙 크기 초기화
            System.out.print("#" + test_case + " ");

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int order = Integer.parseInt(st.nextToken());

                if (order == 1) { // 삽입 연산
                    int x = Integer.parseInt(st.nextToken());
                    addHeap(x);
                } else { // 삭제 연산
                    System.out.print(popHeap() + " ");
                }
            }
            System.out.println();
        }
    }

    public static void addHeap(int x) {
        heap[++heapSize] = x; // 마지막 위치에 추가
        sortHeap(heapSize); // 힙 정렬
    }

    public static int popHeap() {
        if (heapSize == 0) return -1; // 힙이 비었을 경우
        int item = heap[1]; // 최댓값 저장
        heap[1] = heap[heapSize]; // 마지막 요소를 루트로 이동
        heapSize--; // 크기 감소
        sortHeap2(1); // 힙 속성 유지
        return item;
    }

    public static void sortHeap(int index) {
        while (index > 1 && heap[index] > heap[index / 2]) { // 부모보다 크면 swap
            int tmp = heap[index / 2];
            heap[index / 2] = heap[index];
            heap[index] = tmp;
            index /= 2; // 부모로 이동
        }
    }

    public static void sortHeap2(int index) {
        while (index * 2 <= heapSize) { // 왼쪽 자식이 있을 때만 진행
            int largerChild = index * 2; // 왼쪽 자식 선택
            if (index * 2 + 1 <= heapSize && heap[index * 2 + 1] > heap[index * 2]) {
                largerChild = index * 2 + 1; // 오른쪽 자식이 더 크면 선택
            }

            if (heap[index] >= heap[largerChild]) break; // 부모가 더 크면 종료

            // swap
            int tmp = heap[index];
            heap[index] = heap[largerChild];
            heap[largerChild] = tmp;

            index = largerChild; // 자식으로 이동
        }
    }
}
