package 문제10761신뢰;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class RobotCommand {
	public char robot; // 둘은 다른 자료형이기에 class를 써서 한 번에 저장하자
	public int btnNum;
}

class Solution {
	private static final int ORANGE_ROBOT = 0;
	private static final int BLUE_ROBOT = 1;

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/문제10761신뢰.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); // Line 읽기
			int btnCount = Integer.parseInt(st.nextToken());
			Queue<RobotCommand> robotMove = new LinkedList<>();
			Queue<Integer>[] eachRobotMove = new LinkedList[2];
			// Integer가 들어가는 Queue를 리스트로 구현하겠다! 근데 오렌지랑 파랑이랑 두 명이니깐 size는 2!
			eachRobotMove[ORANGE_ROBOT] = new LinkedList<>(); // 0번 인덱스에는 오렌지 명령어 큐 초기화
			eachRobotMove[BLUE_ROBOT] = new LinkedList<>(); // 1번 인덱스는 파랑이 명령여 큐 초기화
			// 이제 eachRobotQueue에 각각 0번 인덱스랑 1번 인덱스에 오렌지와 파랑이 명령어를 넣고
			// robotMove에 전체 <오렌지,4번버튼> <오렌지,3번버튼><파랑이,7번버튼> 이런식으로 넣자
			for (int loop = 0; loop < btnCount; loop++) {
				RobotCommand move = new RobotCommand();
				move.robot = st.nextToken().charAt(0);
				move.btnNum = Integer.parseInt(st.nextToken());
				robotMove.add(move);
				switch (move.robot) {
				case 'O':
					eachRobotMove[ORANGE_ROBOT].add(move.btnNum);
					break;
				case 'B' :
					eachRobotMove[BLUE_ROBOT].add(move.btnNum);
					break;
				}
			}
			int result = getMinTime(robotMove, eachRobotMove);
			sb.append('#').append(test_case).append(' ').append(result).append('\n');
            bw.write(sb.toString());
            bw.flush();
            sb.setLength(0); // 내부의 모든 문자열 데이터를 삭제
		}
        bw.close();
        br.close();
	}
	public static int getMinTime(Queue<RobotCommand> robotMove, Queue<Integer>[] eachRobotMove) {
		int[] currentXY = new int[2]; // O가 0, B가 1
		Arrays.fill(currentXY, 1); // 1로 위치 전부 초기화
		int totalTime = 0;
		while (!robotMove.isEmpty()) {
			RobotCommand currentMove = robotMove.poll();
			int btnRobot = currentMove.robot == 'O' ? ORANGE_ROBOT : BLUE_ROBOT; // 버튼 누르는 로봇
			int moveRobot = currentMove.robot == 'O' ? BLUE_ROBOT : ORANGE_ROBOT; // 움직이는 로봇
			eachRobotMove[btnRobot].poll();
			int moveTime = Math.abs(currentMove.btnNum - currentXY[btnRobot]) + 1; // 버튼 누르는 시간 1포함
			totalTime+=moveTime;
			currentXY[btnRobot] = currentMove.btnNum;
			if (!eachRobotMove[moveRobot].isEmpty()) { // 다른 것 움직이기
				int Destination = eachRobotMove[moveRobot].peek();
				int moveDistance = Math.abs(Destination - currentXY[moveRobot]);
				int moveDirection = Destination > currentXY[moveRobot] ? 1 : -1;
				currentXY[moveRobot] = moveTime > moveDistance ? Destination : currentXY[moveRobot] + (moveDirection*moveTime);
				
			}
		}
		
		return totalTime;
	}
}


