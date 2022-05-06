package algorithm.dijkstra;

import java.util.LinkedList;

public class Graph {

	private int vertexSize;  // 顶点数量
	private int[] vertexs;  // 顶点数组
	private int[][] matrix;  // 矩阵
	private static final int MAX_WEIGHT = 1000;  // 用1000代替∞
	private boolean[] isVisited;
	// 构造函数
	public Graph(int vertexSize) {
		this.vertexSize = vertexSize;
		matrix = new int[vertexSize][vertexSize];
		vertexs = new int[vertexSize];
		for(int i=0; i < vertexSize; i++) {
			vertexs[i] = i;
		}
		isVisited = new boolean[vertexSize];
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public int getVertexSize() {
		return vertexSize;
	}

	public void setVertexSize(int vertexSize) {
		this.vertexSize = vertexSize;
	}

	public int[] getVertexs() {
		return vertexs;
	}

	public void setVertexs(int[] vertexs) {
		this.vertexs = vertexs;
	}

	/**
	 * 获取出度
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
	 * 获取二个顶点之间的权值
	 */
	public int getWeight(int v1, int v2) {
		int weight = matrix[v1][v2];
		return weight == 0 ? 0 : (weight == MAX_WEIGHT ? -1 : weight);
	}

	/**
	 * 获取某个顶点的第一个邻接点
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
	 * 根据前一个邻接点的下标来取得下一个邻接点
	 * @param v 表示要找的顶点
	 * @param index 表示该顶点对于哪个邻接点去获取下一个邻接点
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
				// 需要遍历该顶点
				System.out.println("访问到了：" + w + "顶点！");
				depthFirstSearch(w);
			}
			// 第一个相对于w的邻接点
			w = getNextNeighbor(i, w);
		}
	}

	/**
	 * 对外公开的深度优先遍历
	 */
	public void depthFirstSearch() {
		isVisited = new boolean[vertexSize];
		for(int i = 0; i < vertexSize; i++) {
			if(!isVisited[i]) {
				System.out.println("访问到了："+ i + "顶点！");
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
	 * 广度优先遍历
	 * @param i
	 */
	private void broadFirstSearch(int i) {
		int u,w;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		System.out.println("访问到了：" + i + "顶点！");
		isVisited[i] = true;
		queue.add(i); // 第一次把v0加到队列
		while(!queue.isEmpty()) {
			u = (Integer)(queue.removeFirst()).intValue();
			w = getFirstNeighbor(u);
			while(w != -1) {
				if(!isVisited[w]) {
					System.out.println("访问到了：" + w + "顶点！");
					isVisited[w] = true;
					queue.add(w);
				}
				w = getNextNeighbor(u,w);
			}
		}

	}

	/**
	 * prim 普里姆算法
	 */
	public void prim() {
		// 最小代价顶点权值的数组，为0表示已经
		int[] lowcost = new int[vertexSize];
		// 放顶点权值
		int[] adjvex = new int[vertexSize];
		int minWeight; //最小权值
		int minId; //最小权值顶点
		int sum = 0; //权值总和
		//先初始化将第一行的顶点权值存放到临时权值数组中
		for(int i = 1; i < vertexSize; i++) {
			lowcost[i] = matrix[0][i];
		}
		for(int i = 1; i < vertexSize; i++) {
			//每次循环都找出临时顶点权值的最小的权值
			minWeight = MAX_WEIGHT;
			minId = 0;
			for(int j = 1; j < vertexSize; j++) {
				if(lowcost[j] < minWeight && lowcost[j] > 0) {
					minWeight = lowcost[j];
					minId = j;
				}
			}
			//找到目标顶点minId,他的权值为minweight。
			System.out.println("顶点：" + adjvex[minId] + "权值：" + minWeight);
			sum += minWeight;

			lowcost[minId] = 0;
			//根据找到的顶点minId，将这一行的所有相关联的顶点权值添加到临时权值数组中
			for(int k = 1; k < vertexSize; k++) {
				if(lowcost[k] != 0 && matrix[minId][k] < lowcost[k]) {
					lowcost[k] = matrix[minId][k];
					adjvex[k] = minId;
				}
			}
		}
		System.out.println("最小生成树权值和：" + sum);
	}

	public void createGraph() {
		int[] a0 = new int[]{0,1,5,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT};
		int[] a1 = new int[]{1,0,3,7,5,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT};
		int[] a2 = new int[]{5,3,0,MAX_WEIGHT,1,7,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT};
		int[] a3 = new int[]{MAX_WEIGHT,7,MAX_WEIGHT,0,2,MAX_WEIGHT,3,MAX_WEIGHT,MAX_WEIGHT};
		int[] a4 = new int[]{MAX_WEIGHT,5,1,2,0,3,6,9,MAX_WEIGHT};
		int[] a5 = new int[]{MAX_WEIGHT,MAX_WEIGHT,7,MAX_WEIGHT,3,0,MAX_WEIGHT,5,MAX_WEIGHT};
		int[] a6 = new int[]{MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,3,6,MAX_WEIGHT,0,2,7};
		int[] a7 = new int[]{MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,9,5,2,0,4};
		int[] a8 = new int[]{MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,7,4,0};

		matrix[0] = a0;
		matrix[1] = a1;
		matrix[2] = a2;
		matrix[3] = a3;
		matrix[4] = a4;
		matrix[5] = a5;
		matrix[6] = a6;
		matrix[7] = a7;
		matrix[8] = a8;
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
//		System.out.println("v0的出度：" + degree);
//		System.out.println("权值：" + graph.getWeight(0, 4));

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
