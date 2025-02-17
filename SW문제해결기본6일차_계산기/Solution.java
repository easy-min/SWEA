package SW문제해결기본6일차_계산기;


import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

class Solution {
    public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/SW문제해결기본6일차_계산기.txt"));
        Scanner sc = new Scanner(System.in);
        int T = 10;
        
        for (int test_case = 1; test_case <= T; test_case++) {
            int len = sc.nextInt(); // 테스트케이스의 길이
            sc.nextLine();
            String s = sc.nextLine();
            int answer = calculater(s);
            System.out.println("#" + test_case + " " + answer);
        }
    }

    static HashMap<Character, Integer> operator = new HashMap<>();
    static {
        operator.put('(', 0); // stack 내부에 들어가는 연산자들
        operator.put('+', 1);
        operator.put('-', 1);
        operator.put('*', 2);
        operator.put('/', 2);
    }

    public static int calculater(String s) {
        Stack<Character> op = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        
        // 후위 표기법으로 변환
        for (int i = 0; i < s.length(); i++) {
            char what = s.charAt(i);
            
            // 괄호를 만났을 때 처리
            if (what == '(') {
                op.push(what);
            }
            else if (what == ')') {
                // '('를 만날 때까지 pop하여 postfix에 추가
                while (op.peek() != '(') {
                    postfix.append(op.pop());
                }
                op.pop(); // '(' 제거
            } 
            // 숫자인 경우
            else if (what >= '0' && what <= '9') {
                postfix.append(what);  // 문자 그대로 추가
            } 
            // 연산자인 경우
            else {
                // 연산자의 우선순위 처리
                while (!op.isEmpty() && operator.get(what) <= operator.get(op.peek())) {
                    postfix.append(op.pop());
                }
                op.push(what);
            }
        }
        
        // 남아있는 연산자 처리
        while (!op.isEmpty()) {
            postfix.append(op.pop());
        }
        
        // 후위 표기법 계산
        Stack<Integer> num = new Stack<>();
        for (int i = 0; i < postfix.length(); i++) {
            char current = postfix.charAt(i);
            
            if (operator.containsKey(current)) { // 연산자라면
                int B = num.pop();
                int A = num.pop();
                switch (current) {
                    case '+': 
                        num.push(A + B);
                        break;
                    case '-':
                        num.push(A - B);
                        break;
                    case '*':
                        num.push(A * B);
                        break;
                    case '/':
                        num.push(A / B);
                        break;
                }
            } else { // 숫자라면
                num.push(current - '0');  // 문자 -> 숫자
            }
        }
        
        return num.pop();
    }
}

