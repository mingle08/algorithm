package algo.girlTeacher.graph.bfs;

public class Graph {

	private final int MAX_VERTS = 20;
	private Vertex[] vertexList;   // 存放顶点的数组
	private int[][] adjMat;  // 邻接矩阵
	private int nVerts;   // 当前的顶点数
//	private StackX stackX;  // 深度优先搜索使用的容器
	private Queue queue;  // 广度优先搜索用的队列
	public Graph() {
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for (int i = 0; i < MAX_VERTS; i++) {
			for (int j = 0; j < MAX_VERTS; j++) {
				adjMat[i][j] = 0;
			}
		}
		
//		stackX = new StackX();
		queue = new Queue();
	}
	
	// 添加顶点
	public void addVertex(char lab) {
		vertexList[nVerts++] = new Vertex(lab);
	}
	
	// 添加边:邻接矩阵中，如果A和B是相连的，那边从A到B是1，从B到A也是1
	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}
	
	public void displayVertex(int v) {
		System.out.print(vertexList[v].label);
	}
	
	// 深度优先搜索
	/*public void dfs() {
		vertexList[0].isVisited = true;   // 第一个顶点，标记已访问过
		displayVertex(0);  // 显示被访问的顶点
		stackX.push(0);
		while(!stackX.isEmpty()) {
			int v = getAdjUnvisitedVertex(stackX.peek());
			if(v == -1) {
				stackX.pop();
			}else {
				vertexList[v].isVisited = true;
				displayVertex(v);
				stackX.push(v);
			}
		}
		
		// 还原为初始状态
		for (int i = 0; i < nVerts; i++) {
			vertexList[i].isVisited = false;
		}
	}*/
	
	public int getAdjUnvisitedVertex(int v) {
		for (int i = 0; i < nVerts; i++) {
			if(adjMat[v][i] == 1 && !vertexList[i].isVisited) {// == 1表示二个点是连通的
				return i;  // 找到了一个与v顶点相邻接的未访问的顶点数量
			}
		}
		return -1;   // 未找到
	}
	
	// 广度优先搜索
	public void bfs() {
		vertexList[0].isVisited = true;
		displayVertex(0);
		queue.insert(0);
		int v2;
		
		while(!queue.isEmpty()) {
			int v1 = queue.remove();  // 从队列头部取出第一个顶点
			while((v2=getAdjUnvisitedVertex(v1)) != -1) {// v2有多个
				vertexList[v2].isVisited = true;
				displayVertex(v2);
				queue.insert(v2);
			}
		}
	}
}
