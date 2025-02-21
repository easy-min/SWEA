package SW문제해결응용3일차_공통조상;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

class Solution2 {
    static int[] parent;
    static int[] leftChild;
    static int[] rightChild;

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
            // 
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
             *        p     |   |   | 1 | 1 |   |   |
             *        left  |   | 2 |   |   |   |   |
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
             * 1의 부모 = p[1] = 0  // 0이 되는 순간 종료 필요 .
             * 
             *
             */
            StringTokenizer arr_bridge = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
                int p = Integer.parseInt(arr_bridge.nextToken()); // 부모 노드
                int c = Integer.parseInt(arr_bridge.nextToken()); // 자식 노드
                parent[c] = p;  // 자식이 부모를 가리키도록 저장
                
                if (leftChild[p] == 0) leftChild[p] = c;
                else rightChild[p] = c;
            }

            // 공통 조상 찾기 (동시에 올라가면서 찾기) -> 높이를 1씩 낮추면서 A와 B의 조상들을 HashSet에 (중복 비허용)넣으면서 중복된 조상을 HashSet에 넣는 순간 return하기
            int commonAncestor = findCommonParent(A, B);
            int subtreeSize = countNodes(commonAncestor);  // 서브트리 크기 구하기

            System.out.println("#" + test_case + " " + commonAncestor + " " + subtreeSize);
        }
    }

    
    
    // A와 B를 동시에 부모로 이동하면서 공통 조상 찾기
    public static int findCommonParent(int A, int B) {
        HashSet<Integer> visited = new HashSet<>();
        while (A != 0 || B != 0) { // index가 0이라는 것은 곧 부모 노드라는 뜻!
            if (A != 0) {
                if (visited.contains(A)) return A;  // 공통 조상 발견
                visited.add(A);
                A = parent[A];  // 부모로 이동
            }
            if (B != 0) {
                if (visited.contains(B)) return B;  // 공통 조상 발견
                visited.add(B);
                B = parent[B];  // 부모로 이동
            }
        }
        return -1; // 발견 못하면 -1을 리턴하장
    }
    // 공통 조상을 루트로 하는 서브트리 크기 계산 (후위 순회)
    public static int countNodes(int node) {
        if (node == 0) return 0;  // 노드가 없으면 크기 0
        return 1 + countNodes(leftChild[node]) + countNodes(rightChild[node]);  // 서브트리 크기 계산
    }
}
