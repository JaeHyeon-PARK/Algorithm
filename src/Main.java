import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static long [] DP;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n == 1 || n == 2 || n == 3) System.out.println(1);
			else if(n == 4 || n == 5) System.out.println(2);
			else {
				DP = new long[n + 1];
				DP[1] = DP[2] = DP[3] = 1;
				DP[4] = DP[5] = 2;
				for(int j = 6; j <= n; j++)
					DP[j] = DP[j - 1] + DP[j - 5];
				System.out.println(DP[n]);
			}
		}
	}
}