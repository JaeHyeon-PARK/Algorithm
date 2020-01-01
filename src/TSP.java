import java.util.*;

class TSPEdge { // edge 클래스
	int from;
	int to;
	int weight;
	
	public TSPEdge(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
}

class TSPAlgorithm {
	boolean[] visited;
	int min = Integer.MAX_VALUE;
	
	public TSPAlgorithm(int N) {
		visited = new boolean[N];
		visited[0] = true;
	}
	
	void findRes(int[][] W, int N, int S, int sum, int count) {
		if(count == N) {
			min = Math.min(min, sum + W[S][0]);
			visited[S] = false; 
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i] && W[S][i] != 0) {
				visited[i] = true;
				if(sum + W[S][i] < min)
					findRes(W, N, i, sum + W[S][i], count + 1);
				visited[i] = false;
			}
		}
	}
	
	void showRes() {
		System.out.println(min);
	}
}

public class TSP {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Seed와 Vertex 수 입력: ");
		long seed = sc.nextLong();
		int N = sc.nextInt();
		sc.close();
		
		Random rand = new Random(seed);
		int[][] W = new int[N][N];
		
		for(int x = 0; x < N; x++) { // 경로 생성
			for(int y = 0; y < N; y++) {
				if(x == y) continue; // 자기 자신으로의 경로
				W[x][y] = rand.nextInt(10);
			}
		}
		
		TSPAlgorithm algorithm = new TSPAlgorithm(N);
		algorithm.findRes(W, N, 0, 0, 1);
		algorithm.showRes();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++)
				System.out.print(W[i][j] + " ");
			System.out.println();
		}
	}
}
