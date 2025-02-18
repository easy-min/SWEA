package 백준;

import java.util.*;

class xy { 
    int x, y;
    public xy(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 문제2667단지번호붙이기 { 
    static int N;
    static int[][] arr;
    static int[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 5 <= N <= 25
        arr = new int[N][N];
        visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = sc.next(); // 공백 없는 문자열 입력 받기
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j) - '0'; // 문자 '0'을 빼서 숫자로 변환
            }
        }

        List<Integer> homeCount = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && visited[i][j] == 0) { 
                    homeCount.add(findHome(i, j)); // 단지 크기 저장
                }
            }
        }

        Collections.sort(homeCount); // 오름차순 정렬
        System.out.println(homeCount.size()); // 단지 개수 출력
        for (int count : homeCount) {
            System.out.println(count); // 단지별 집 개수 출력
        }
    }

    public static int findHome(int i, int j) {
        Queue<xy> queue = new LinkedList<>();
        queue.add(new xy(i, j));
        visited[i][j] = 1;
        int homeSize = 1; // 현재 단지 크기

        while (!queue.isEmpty()) { 
            xy current = queue.poll(); // 큐에서 노드 꺼냄
            int x = current.x;
            int y = current.y;

            for (int k = 0; k < 4; k++) { 
                int nx = x + dx[k];
                int ny = y + dy[k];

                // 🔥 배열 범위 확인 후, 방문 여부 체크
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) { 
                    if (arr[nx][ny] == 1 && visited[nx][ny] == 0) {
                        queue.add(new xy(nx, ny));
                        visited[nx][ny] = 1;
                        homeSize++; // 단지 크기 증가
                    }
                }
            }
        }
        return homeSize; // 현재 단지 크기 반환
    }
}
