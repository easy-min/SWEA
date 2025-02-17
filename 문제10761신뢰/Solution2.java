package 문제10761신뢰;
import java.io.FileInputStream;
import java.util.*;

class Solution2 {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("res/문제10761신뢰.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt(); // 눌러야 하는 버튼 개수
            List<Integer> btnOrange = new ArrayList<>();
            List<Integer> btnBlue = new ArrayList<>();
            List<Character> Order = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                char who = sc.next().charAt(0);
                if (who == 'O') {
                    btnOrange.add(sc.nextInt());
                } else {
                    btnBlue.add(sc.nextInt()); // 파랑이
                }
                Order.add(who); // 순서
            }

            int time = 0;
            int standO = 1, standB = 1;
            boolean findAllOrange = false, findAllBlue = false, findOrangePrevious = false;

            while (N > 0) {
                time++;

                // 오렌지
                if (!findAllOrange && !btnOrange.isEmpty()) {
                    if (standO == btnOrange.get(0) && 'O' == Order.get(0)) {
                        btnOrange.remove(0);
                        Order.remove(0);
                        N--;
                        findOrangePrevious = true;
                        if (btnOrange.isEmpty()) findAllOrange = true;
                    } else if (standO < btnOrange.get(0)) {
                        standO++;
                        findOrangePrevious = false;
                    } else {
                        standO--;
                        findOrangePrevious = false;
                    }
                }

                // 블루
                if (!findAllBlue && !btnBlue.isEmpty()) {
                    if (standB == btnBlue.get(0) && 'B' == Order.get(0)) {
                        if (findOrangePrevious) {
                            time++;
                            findOrangePrevious = false;
                        }
                        btnBlue.remove(0);
                        Order.remove(0);
                        N--;
                        if (btnBlue.isEmpty()) findAllBlue = true;
                    } else if (standB < btnBlue.get(0)) {
                        standB++;
                    } else {
                        standB--;
                    }
                }
            }
            System.out.println("#" + test_case + " " + time);
        }
        sc.close();
    }
}
