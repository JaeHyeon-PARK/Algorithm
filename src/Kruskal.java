import java.util.*;

class KruskalEdge { // edge Ŭ����
	int from;
	int to;
	int weight;
	
	public KruskalEdge(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
}

class KruskalAlgorithm {
	KruskalEdge[] edges; // Ʈ���� edge ����
	int[] parent; // vertex�� ��Ʈ ����
	
	public KruskalAlgorithm(int N) {
		edges = new KruskalEdge[N * N];
		parent = new int[N];
		
		for(int i = 0; i < N; i++)
			parent[i] = i;
	}
	
	int findMST(int[][] W) {
		int sum_of_edges = 0;
		int N = W.length;
		int pos = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				edges[pos] = new KruskalEdge(i, j, W[i][j]);
				pos++;
			}
		}
		
		Arrays.sort(edges, new Comparator<KruskalEdge>() { // edge�� weight ������ �������� ����
			@Override
			public int compare(KruskalEdge e1, KruskalEdge e2) {
				return e1.weight - e2.weight;
			}
		});
		
		for(int i = 0; i < edges.length; i++) {
			if(edges[i].weight == 0) continue;
			int rootFrom = findRoot(edges[i].from);
			int rootTo = findRoot(edges[i].to);
			
			if(rootFrom == rootTo) continue;
			else {
				parent[rootTo] = rootFrom;
				System.out.println("���� �߰�: [" + edges[i].from + ", " + edges[i].to + "] weight = " + edges[i].weight);
				sum_of_edges += edges[i].weight;
			}
		}
		
		return sum_of_edges;
	}
	
	private int findRoot(int vertex) {
		if(parent[vertex] == vertex) return vertex;
		else return findRoot(parent[vertex]);
	}
}

public class Kruskal {
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
		
		KruskalAlgorithm algorithm = new KruskalAlgorithm(N);
		int sum_of_edges = algorithm.findMST(W);
		
		System.out.println("Spanning Ʈ���� �����ϴ� �������� �� = " + sum_of_edges);
	}
}
