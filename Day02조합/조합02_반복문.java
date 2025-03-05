package Day02조합;

public class 조합02_반복문 {

	public static void main(String[] args) {
		// 반복문을 이용할 때는 R개 고정적으로 사용되면 좋음
		int[] arr = {0, 1, 2, 3, 4};
		int N = arr.length;
		int R = 3;
		
		for (int i = 0; i<N-2; i++) { // i<N이라고 해도 어차피 인덱스 벗어나도 그대로 나옴 (밑의 조건들에서 걸리기 때문에)
			for (int j = i+1; j<N-1; j++) {
				for (int k = j+1; k<N; k++) {
					System.out.println(arr[i]+" "+arr[j]+" "+arr[k]); // 고정적으로 사용했을 때 이런 걸 해줄 수 있다
				}
			}
		}

	}

}
