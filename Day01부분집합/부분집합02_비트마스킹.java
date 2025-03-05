package Day01부분집합;

public class 부분집합02_비트마스킹 {
	static String[] 재료 = { "단무지", "햄", "오이", "계란" };
	static int N = 4;

	public static void main(String[] args) {
//		for (int i = 0; i<Math.pow(2, N); i++) {
		for (int i = 0; i < (1 << N); i++) {
			
			System.out.print("김밥: ");
			for (int j = 0; j<N; j++) { // 이게 지금 무슨 김밥이야? 햄이 들어 있니?? 아니면 오이가 들어 있니? 해당 재료만큼만 확인하자
				// 우리가 재료를 하나씩 shift 하면서 검사할 껀데 1이냐로 체크하면 안된당
				if ((i & (1<<j)) != 0) {// 0보다 크거나 0이 아니거나 둘 중 편한 방식으로 쓰면 된다.
					// 해당 코드가 실행이 된다는 뜻은 김밥이 있대
					System.out.print(재료[j]+" ");
				}
			}// 재료 check~
			System.out.println();
		} // 모든 김밥의 경우의 수

	}

}
