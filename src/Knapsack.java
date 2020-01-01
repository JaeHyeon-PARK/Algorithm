import java.util.Random;
import java.util.Scanner;

class Item { // Item Ŭ����
	int value;
	int weight;
	
	public Item(int value, int weight) {
		this.value = value;
		this.weight = weight;
	}
}

class KnapsackAlgorithm {
	Item[] items; // Item ���� ����
	int[][] P; // ����� ����(DP)
	
	public KnapsackAlgorithm(long seed, int N, int W) {
		Random rand = new Random(seed);
		items = new Item[N + 1];
		P = new int[N + 1][W + 1];
		
		for(int i = 0; i < N + 1; i++) {
			if(i == 0) items[i] = new Item(0, 0);
			else items[i] = new Item(rand.nextInt(91) + 10, rand.nextInt(26) + 5); // value�� 10 ~ 100, weight�� 5 ~ 30 ���� ����
		}
		
		for(int i = 0; i < N + 1; i++)
			System.out.println(items[i].value + " " + items[i].weight);
	}
	
	public int findRes(int N, int W) {
		for(int n = 0; n < N + 1; n++) {
			for(int w = 0; w < W + 1; w++) {
				if(n == 0 || w == 0) P[n][w] = 0;
				else if(w < items[n].weight) P[n][w] = P[n - 1][w];
				else P[n][w] = Math.max(P[n - 1][w], items[n].value + P[n - 1][w - items[n].weight]);
			}
		}
		return P[N][W];
	}
}

public class Knapsack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Seed�� Item ���� ���� ���� �Է�(���� ���Դ� 40 �̻�): ");
		long seed = sc.nextLong();
		int N = sc.nextInt();
		int W = sc.nextInt();
		sc.close();
		
		KnapsackAlgorithm algorithm = new KnapsackAlgorithm(seed, N, W);
		System.out.println("�ִ�: " + algorithm.findRes(N, W));
	}
}
