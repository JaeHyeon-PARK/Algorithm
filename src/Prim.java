import java.util.*;

class PrimEdge { // edge Ŭ����
	int from;
	int to;
	int weight;
	
	public PrimEdge(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
}

class PrimAlgorithm {
	int[] distances; // v1�� nearest[i]�� �մ� ������ ����ġ
	int[] nearest; // vi���� ���� ����� ����
	
	public PrimAlgorithm(int N, int[][] W) {
		distances = new int[N];
		nearest = new int[N];
		
		for(int i = 0; i < N; i++) { // �ʱ�ȭ
			nearest[i] = 0;
			distances[i] = W[0][i];
		}
	}
	
	int findMST(int N, int[][] W) {
		int sum_of_edges = 0;
		
		for(int i = 0; i < N - 1; i++) {
			int min = 1000;
			int candidate = 0;
			
			for(int j = 1; j < N; j++) {
				if(distances[j] >= 0 && distances[j] < min) {
					min = distances[j];
					candidate = j;
				}
			}
			
			System.out.println("���� �߰�: [" + nearest[candidate] + ", " + candidate + "] weight = " + W[nearest[candidate]][candidate]);
			sum_of_edges += W[nearest[candidate]][candidate];
			
			distances[candidate] = -1;
			for(int j = 1; j < N; j++) {
				if(W[candidate][j] < distances[j] && W[candidate][j] > 0) {
					distances[j] = W[candidate][j];
					nearest[j] = candidate;
				}
			}
		}
		
		return sum_of_edges;
	}
}

public class Prim {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Seed�� Vertex �� �Է�: ");
		long seed = sc.nextLong();
		int N = sc.nextInt();
		sc.close();
		
		Random rand = new Random(seed);
		int[][] W = new int[N][N];
		
		for(int x = 0; x < N; x++) { // ��� ����
			for(int y = 0; y < N; y++) {
				if(x == y) continue; // �ڱ� �ڽ������� ���
				W[x][y] = W[y][x] = rand.nextInt(15);
			}
		}
		
		PrimAlgorithm algorithm = new PrimAlgorithm(N, W);
		int sum_of_edges = algorithm.findMST(N, W);
		
		System.out.println("Spanning Ʈ���� �����ϴ� �������� �� = " + sum_of_edges);
	}
}
