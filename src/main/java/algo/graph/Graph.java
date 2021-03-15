package algo.graph;

import java.util.LinkedList;

public class Graph {

	private int vertexSize;  // ��������
	private int[] vertexs;  // ��������
	private int[][] matrix;  // ����
	private static final int MAX_WEIGHT = 1000;  // ��1000�����
	private boolean[] isVisited;
	// ���캯��
	public Graph(int vertexSize) {
		this.vertexSize = vertexSize;
		matrix = new int[vertexSize][vertexSize];
		vertexs = new int[vertexSize];
		for(int i=0; i < vertexSize; i++) {
			vertexs[i] = i;
		}
		isVisited = new boolean[vertexSize];
	}

	public int[] getVertexs() {
		return vertexs;
	}

	public void setVertexs(int[] vertexs) {
		this.vertexs = vertexs;
	}
	
	/**
	 * ��ȡ����
	 * @param index
	 */
	public int getOutDegree(int index) {
		int degree = 0;
		for(int j=0; j < vertexSize; j++) {
			int weight = matrix[index][j];
			if(weight != 0 && weight != MAX_WEIGHT) {
				degree++;
			}
		}
		return degree;
	}
	/**
	 * ��ȡ��������֮���Ȩֵ
	 */
	public int getWeight(int v1, int v2) {
		int weight = matrix[v1][v2];
		return weight == 0 ? 0 : (weight == MAX_WEIGHT ? -1 : weight);
	}
	
	/**
	 * ��ȡĳ������ĵ�һ���ڽӵ�
	 */
	public int getFirstNeighbor(int index) {
		for(int j = 0; j < vertexSize; j++) {
			if(matrix[index][j] > 0 && matrix[index][j] < MAX_WEIGHT) {
				return j;
			}
		}
		return -1;
	}
	
	/**
	 * ����ǰһ���ڽӵ���±���ȡ����һ���ڽӵ�
	 * @param v ��ʾҪ�ҵĶ���
	 * @param index ��ʾ�ö�������ĸ��ڽӵ�ȥ��ȡ��һ���ڽӵ�
	 * @return
	 */
	public int getNextNeighbor(int v, int index) {
		for(int j = index + 1; j < vertexSize; j++) {
			if(matrix[v][j] > 0 && matrix[v][j] < MAX_WEIGHT) {
				return j;
			}
		}
		return -1;
	}
	
	private void depthFirstSearch(int i) {
		
		isVisited[i] = true;
		int w = getFirstNeighbor(i);
		while(w != -1) {
			if(!isVisited[w]) {
				// ��Ҫ�����ö���
				System.out.println("���ʵ��ˣ�" + w + "���㣡");
				depthFirstSearch(w);
			}
			// ��һ�������w���ڽӵ�
			w = getNextNeighbor(i, w);
		}
	}
	
	/**
	 * ���⹫����������ȱ���
	 */
	public void depthFirstSearch() {
		isVisited = new boolean[vertexSize];
		for(int i = 0; i < vertexSize; i++) {
			if(!isVisited[i]) {
				System.out.println("���ʵ��ˣ�"+ i + "���㣡");
				depthFirstSearch(i);
			}
		}
		isVisited = new boolean[vertexSize];
	}
	
	public void broadFirstSearch() {
		isVisited = new boolean[vertexSize];
		for(int i = 0; i < vertexSize; i++) {
			if(!isVisited[i]) {
				broadFirstSearch(i);
			}
		}
	}
	
	/**
	 * ������ȱ���
	 * @param i
	 */
	private void broadFirstSearch(int i) {
		int u,w;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		System.out.println("���ʵ��ˣ�" + i + "���㣡");
		isVisited[i] = true;
		queue.add(i); // ��һ�ΰ�v0�ӵ�����
		while(!queue.isEmpty()) {
			u = (Integer)(queue.removeFirst()).intValue();
			w = getFirstNeighbor(u);
			while(w != -1) {
				if(!isVisited[w]) {
					System.out.println("���ʵ��ˣ�" + w + "���㣡");
					isVisited[w] = true;
					queue.add(w);
				}
				w = getNextNeighbor(u,w);
			}
		}
		
	}
	
	/**
	 * prim ����ķ�㷨
	 */
	public void prim() {
		// ��С���۶���Ȩֵ�����飬Ϊ0��ʾ�Ѿ�
		int[] lowcost = new int[vertexSize];
		// �Ŷ���Ȩֵ
		int[] adjvex = new int[vertexSize];
		int minWeight; //��СȨֵ
		int minId; //��СȨֵ����
		int sum = 0; //Ȩֵ�ܺ�
		//�ȳ�ʼ������һ�еĶ���Ȩֵ��ŵ���ʱȨֵ������
		for(int i = 1; i < vertexSize; i++) {
			lowcost[i] = matrix[0][i];
		}
		for(int i = 1; i < vertexSize; i++) {
			//ÿ��ѭ�����ҳ���ʱ����Ȩֵ����С��Ȩֵ
			minWeight = MAX_WEIGHT;
			minId = 0;
			for(int j = 1; j < vertexSize; j++) {
				if(lowcost[j] < minWeight && lowcost[j] > 0) {
					minWeight = lowcost[j];
					minId = j;
				}
			}
			//�ҵ�Ŀ�궥��minId,����ȨֵΪminweight��
			System.out.println("���㣺" + adjvex[minId] + "Ȩֵ��" + minWeight);
			sum += minWeight;
			
			lowcost[minId] = 0;
			//�����ҵ��Ķ���minId������һ�е�����������Ķ���Ȩֵ��ӵ���ʱȨֵ������
			for(int k = 1; k < vertexSize; k++) {
				if(lowcost[k] != 0 && matrix[minId][k] < lowcost[k]) {
					lowcost[k] = matrix[minId][k];
					adjvex[k] = minId;
				}
			}
		}
		System.out.println("��С������Ȩֵ�ͣ�" + sum);
	}

	public static void main(String[] args) {
		/*
		Graph graph = new Graph(5);
		int[] a0 = new int[] {0,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,6};
		int[] a1 = new int[] {9,0,3,MAX_WEIGHT,MAX_WEIGHT};
		int[] a2 = new int[] {2,MAX_WEIGHT,0,5,MAX_WEIGHT};
		int[] a3 = new int[] {MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,0,1};
		int[] a4 = new int[] {MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,0};
		graph.matrix[0] = a0;
		graph.matrix[1] = a1;
		graph.matrix[2] = a2;
		graph.matrix[3] = a3;
		graph.matrix[4] = a4;*/
//		int degree = graph.getOutDegree(4);
//		System.out.println("v0�ĳ��ȣ�" + degree);
//		System.out.println("Ȩֵ��" + graph.getWeight(0, 4));
		
		Graph graph = new Graph(9);
		int[] a0 = new int[] {0,10,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,11,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT};
		int[] a1 = new int[] {10,0,18,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,16,MAX_WEIGHT,12};
		int[] a2 = new int[] {MAX_WEIGHT,MAX_WEIGHT,0,22,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,8};
		int[] a3 = new int[] {MAX_WEIGHT,MAX_WEIGHT,22,0,20,MAX_WEIGHT,24,16,21};
		int[] a4 = new int[] {MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,20,0,26,MAX_WEIGHT,7,MAX_WEIGHT};
		int[] a5 = new int[] {11,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,26,0,17,MAX_WEIGHT,MAX_WEIGHT};
		int[] a6 = new int[] {MAX_WEIGHT,16,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,17,0,19,MAX_WEIGHT};
		int[] a7 = new int[] {MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,16,7,MAX_WEIGHT,19,0,MAX_WEIGHT};
		int[] a8 = new int[] {MAX_WEIGHT,12,8,21,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,0};
		
		graph.matrix[0] = a0;
		graph.matrix[1] = a1;
		graph.matrix[2] = a2;
		graph.matrix[3] = a3;
		graph.matrix[4] = a4;
		graph.matrix[5] = a5;
		graph.matrix[6] = a6;
		graph.matrix[7] = a7;
		graph.matrix[8] = a8;
		
//		graph.depthFirstSearch();
		
//		graph.broadFirstSearch();
		
		graph.prim();
	}
	
}
