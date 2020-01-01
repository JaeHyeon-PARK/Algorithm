public class MaxSubList {
	static double getMax(double[] A, int n, int start, int cnt) {
		double[] B;
		double max;
		int maxStart = 0, maxCnt = 0;
		
		B = new double[n];
		max = B[0] = A[0];
		for(int i = 1; i < n; i++) {
			if(B[i - 1] < 0) {
				B[i] = A[i];
				start = i;
				cnt = 1;
			}
			else {
				B[i] = B[i - 1] + A[i];
				cnt++;
			}
			if(max < B[i]) {
				max = B[i];
				maxStart = start;
				maxCnt = cnt;
			}
		}
		System.out.print("리스트: ");
		for(int i = maxStart; i < maxStart + maxCnt; i++)
			System.out.print(A[i] + " ");
		System.out.println();
		
		return max;
	}
	
	public static void main(String[] args) {
		double[] A = {2.3, 3.2, -4.5, 2.1, -5.3, 3.6, 4.1, -2.3, 3.5, -4.5};
		int start = 0, cnt = 1;
		
		double res = getMax(A, A.length, start, cnt);
		System.out.println("합: " + Math.round(res * 100d) / 100d);
	}
}
