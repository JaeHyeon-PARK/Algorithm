import java.lang.Math;

public class BinomialCoefficient {
	public static int bin(int n, int k) {
		int[][] B = new int[n + 1][k + 1];
		
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= Math.min(i, k); j++) {
				if(j == 0 || j == i) B[i][j] = 1;
				else B[i][j] = B[i - 1][j - 1] + B[i - 1][j];
			}
		}
		
		return B[n][k];
	}
	
	public static void main(String[] args) {
		System.out.println(bin(4, 3));
	}
}
