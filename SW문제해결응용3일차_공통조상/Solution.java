package SW문제해결응용3일차_공통조상;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution {
    static int[] parent;
    static int[] leftChild;
    static int[] rightChild;
    static ArrayList<Integer> childrens; 
    static ArrayList<Integer> parentAB;  // A의 부모 리스트

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("res/SW문제해결응용3일차_공통조상.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken()); // 정점 개수
            int E = Integer.parseInt(st.nextToken()); // 간선 개수
            int A = Integer.parseInt(st.nextToken()); // A번 노드
            int B = Integer.parseInt(st.nextToken()); // B번 노드

            parent = new int[V + 1];
            leftChild = new int[V + 1];
            rightChild = new int[V + 1];

            StringTokenizer arr_bridge = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {  // 간선 개수만큼 입력 받음
                int p = Integer.parseInt(arr_bridge.nextToken()); // 부모 노드
                int c = Integer.parseInt(arr_bridge.nextToken()); // 자식 노드
                parent[c] = p;  // 자식이 부모를 가리키도록 저장
                // 이전까지는 index가 parent를 가르키도록 하는 코드였지만 이 코드에서는 index가 child를 가리킨다.
                // 왜냐면 parent[i] = i이기 때문에 따로 Parent의 진짜 값?을 입력할 필요가 없음
                /*
                 *     1
                 *   2   3
                 * 4   5
                 * 
                 * 1-2가 입력으로 들어오면
                 * (1번) 자식(2)에 부모(1)을 입력
                 * child의  index| 0 | 1 | 2 | 3 | 4 | 5 |
                 *        p     |   |   | 1 |   |   |   |
                 *        left  |   |   |   |   |   |   |
                 *        right |   |   |   |   |   |   |
                 * 
                 * (2번) 부모(1)에 자식(2)를 입력
                 * child의  index| 0 | 1 | 2 | 3 | 4 | 5 |
                 *        p     |   |   | 1 |   |   |   |
                 *        left  |   | 2 |   |   |   |   |
                 *        right |   |   |   |   |   |   |
                 * 
                 * 1-3이 입력으로 들어오면
                 * (1번) 자식(3)에 부모(1)을 입력
                 * child의  index| 0 | 1 | 2 | 3 | 4 | 5 |
                 *        p     |   |   | 1 |   |   |   |
                 *        left  |   |   |   |   |   |   |
                 *        right |   |   |   |   |   |   |
                 * 
                 * (2번) 부모(1)에 자식(3)를 입력
                 * child의  index| 0 | 1 | 2 | 3 | 4 | 5 |
                 *        p     |   |   | 1 | 1 |   |   |
                 *        left  |   | 2 |   |   |   |   |
                 *        right |   | 3 |   |   |   |   |
                 *
                 * 만약 2의 부모를 찾고 싶다면
                 * 2의 부모 = p[2] = 1
                 * 3의 부모 = p[3] = 1
                 * 1의 부모 = p[1] = 0  // 0이 되는 순간 종료 필요 
                 *
                 */
                
                if (leftChild[p] == 0) leftChild[p] = c;  // 왼쪽 자식이 없으면 저장
                else rightChild[p] = c;
            }

            // A의 부모들을 미리 저장
            parentAB = new ArrayList<>();
            traceParent(A);  // A의 부모들을 저장

            // 공통 조상 찾기
            int commonAncestor = findCommonParent(B);
            int subtreeSize = countSubtreeSize(commonAncestor);  // 서브트리 크기 구하기

            System.out.println("#" + test_case + " " + commonAncestor + " " + subtreeSize);
        }
    }

    // A의 부모들을 저장하는 함수
    public static void traceParent(int A) {
        while (A != 0) {
            parentAB.add(A);
            A = parent[A];  // 부모 노드로 이동
        }
    }

    // B의 부모를 찾으면서 A의 부모 리스트와 비교하는 함수
    public static int findCommonParent(int B) {
        while (B != 0) {  
            if (parentAB.contains(B)) return B;  // 공통 조상을 발견하면 반환
            B = parent[B];  // 부모 노드로 이동
        }
        return 0;  // 기본적으로 공통 조상이 없을 경우 (이론상 불가능)
    }

    // 공통 조상을 루트로 하는 서브트리 크기 계산
    public static int countSubtreeSize(int root) {
        if (root == 0) return 0; // 공통 조상이 없으면 서브트리 크기도 0
        return countNodes(root);
    }

    // 후위 순회로 서브트리 크기 계산
    public static int countNodes(int node) {
        if (node == 0) return 0;
        return 1 + countNodes(leftChild[node]) + countNodes(rightChild[node]);
    }
}
