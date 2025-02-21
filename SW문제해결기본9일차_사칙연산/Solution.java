package SW문제해결기본9일차_사칙연산;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

// 찬찬히 보자
/*
 * parent = [null, "-", "-", "10", "88", "65", null, null] 연산자 또는 숫자가 저장
 * leftChild = [0,  2,   4,   0,   0,    0,   0,    0] 왼쪽 노드의 인덱스가 저장
 * rightChild = [0,  3,  5,   0,   0,    0,   0,    0] 오른쪽 노드의 인덱스가 저장
 * 
 * postOrder(1) -> postOrder(leftChild[1]) 과 postOrder(rightChild[1])
 * 				-> postOrder(2)               postOrder(3)
 * 	
 * postOrder(2) -> postOrder(leftChild[2]) 과 postOrder(rightChild[2])
 * 				-> postOrder(4)			      postOrder(5)
 * 
 * postOrder(4) -> postOrder(leftChild[4]) 과 postOrder(rightChild[4])
 * 				-> postOrder(0)			      postOrder(0)
 * 
 * postOrder(0) -> leaf 노드 (0일 경우에는 더 이상 수행할 필요가 없음)
 * 탐색 종료 조건을 postOrder()에 들어오는 int index==0일 경우 더 이상 수행 x -> return 0으로 종료
 * 
 * postOrder(4) -> 탐색 끝난 이후 후위 계산 시작
 * 				-> 숫자이므로 parent[4]의 결과값을 String에서 Integer.parseInt를 사용해서 반환
 * 				-> 88
 * 
 * postOrder(5) -> 마찬가지로 탐색 끝남 & 숫자이므로 65
 * 
 * postOrder(2) -> '-' String이므로 .equals('-') -> left-right 수행
 * 				-> postOrder(4) - postOrder(5)
 * 				-> 88 - 65 = 23
 * 
 * postOrder(3) -> postOrder(leftChild[3]) 과 postOrder(rightchild[3])
 * 				-> postOrder(0)               postOrder(0)
 * 
 * postOrder(3) -> 탐색 끝남. 숫자이므로 10반환
 * 
 * postOrder(1) -> '-' String이므로 .equals('-') -> left - right 수행
 * 				-> postOrder(2) - postOrder(3)
 * 				-> 23 - 10 = 10 반환
 */




class Solution {
    static String[] parent;
    static int[] leftChild;
    static int[] rightChild;

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("res/SW문제해결기본9일차_사칙연산.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine()); // 정점의 개수
            parent = new String[N + 1];  // 문자열 배열 (연산자 또는 숫자 저장)
            leftChild = new int[N + 1];
            rightChild = new int[N + 1];

            for (int i = 0; i < N; i++) {
                String[] arr = br.readLine().split(" ");
                int index = Integer.parseInt(arr[0]);
                parent[index] = arr[1];  // 연산자 또는 숫자 저장

                if (arr.length == 4) {  // 연산자인 경우 (자식이 2개 있음)
                    leftChild[index] = Integer.parseInt(arr[2]);
                    rightChild[index] = Integer.parseInt(arr[3]);
                }
            } 

            // 후위 순회를 통해 연산 결과 계산
            int answer = postOrder(1);
            System.out.println("#" + test_case + " " + answer);
        }
    }

    // 후위 순회 - 계산기는 후위 순회이다.
    public static int postOrder(int index) {
        if (index == 0) return 0; // 자식이 없을 경우
        int left = postOrder(leftChild[index]); // 왼쪽 자식 노드를 구해와
        int right = postOrder(rightChild[index]); // 오른쪽 자식 노드를 구해와 
        // 후위순회
        // 현재 노드가 연산자인 경우
        if (parent[index].equals("+")) return left + right;
        if (parent[index].equals("-")) return left - right;
        if (parent[index].equals("*")) return left * right;
        if (parent[index].equals("/")) return left / right;

        // 숫자인 경우 변환해서 반환
        return Integer.parseInt(parent[index]);
    }
}
