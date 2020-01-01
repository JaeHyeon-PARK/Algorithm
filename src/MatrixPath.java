import java.util.Random;
import java.util.Scanner;

public class MatrixPath {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Seed와 길이 입력: ");
		long seed = sc.nextLong();
		int N = sc.nextInt();
		sc.close();
		
		Random rand = new Random(seed);
		int[][] arr = new int[N][N];
		int[][] dp = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++)
				arr[i][j] = rand.nextInt(19) + 1;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i == 0 && j == 0) dp[0][0] = arr[0][0];
				else if(i == 0) dp[i][j] = dp[i][j - 1] + arr[i][j];
				else if(j == 0) dp[i][j] = dp[i - 1][j] + arr[i][j];
				else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + arr[i][j];
			}
		}
		
		System.out.println("----- 초기 경로 -----");
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) System.out.print(arr[i][j] + "	");
			System.out.println();
		}
		
		System.out.println();

		System.out.println("----- 비용 결과 -----");
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) System.out.print(dp[i][j] + "	");
			System.out.println();
		}
	}
}
