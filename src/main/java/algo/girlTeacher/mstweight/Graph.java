package algo.girlTeacher.mstweight;

public class Graph {

	private final int MAX_VERTS = 20;
	private final int INFINITY = 1000000;  // 无限大，表示没有邻接线
	private Vertex[] vertexList;
	private int[][] adjMat;  // 邻接矩阵
	private int nVerts;  // 当前顶点数量
	private int currentVert;  // 当前顶点
	private PriorityQ pQ;
	private int nTree;   // 表示最小生成树算法过程中，标志已访问的顶点的数量
	
	public Graph() {
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for (int i = 0; i < MAX_VERTS; i++) {
			for (int j = 0; j < MAX_VERTS; j++) {
				adjMat[i][j] = INFINITY;
			}
		}
		
		pQ = new PriorityQ();
	}
	
	// 添加顶点
	public void addVertex(char lab) {
		vertexList[nVerts++] = new Vertex(lab);
	}
	
	// 添加一条边
	public void addEdge(int start, int end, int weight) {
		adjMat[start][end] = weight;
		adjMat[end][start] = weight;
	}
	
	// 显示某个顶点
	public void displayVertex(int v) {
		System.out.print(vertexList[v].label);
	}
	
	// 带权图的最小生成树
	public void mstweight() {
		currentVert = 0;   // 从第一个顶点开始
		while(nTree < nVerts-1) {
			vertexList[currentVert].isInTree = true;  // 访问过了
			nTree++;
			for (int i = 0; i < nVerts; i++) {
				if(i == currentVert) { // i与currentVert是指向同一个点，就终止此次循环
					continue;
				}
				if(vertexList[i].isInTree) { // 到这个点的边在队列中已加入了
					continue;
				}
				
				int distance = adjMat[currentVert][i];  // 从邻接矩阵中取出权值
				if(distance == INFINITY) {  // 如果二点之间没有连接
					continue;
				}
				putInPQ(i,distance); // i是这条边终点的位置，找到边，并放到队列中
			}
			if(this.pQ.size() == 0) {
				System.out.println("Graph no connected");
				return;
			}
			
			Edge edge = pQ.removeMin();
			int sourceVert = edge.srcVert;  // 最小边的源点
			currentVert = edge.destVert;  // 最小边的终点
			
			System.out.print(vertexList[sourceVert].label);
			System.out.print(vertexList[currentVert].label);
			System.out.print(" ");
		}
		
		// 还原是否被访问的标志为false
		for (int i = 0; i < nVerts; i++) {
			vertexList[i].isInTree = false;
		}
	}
	
	public void putInPQ(int newVert, int newDist) {
		int queueIndex = pQ.find(newVert);
		if(queueIndex != -1) { // 找到了
			Edge tempEdge = pQ.peekN(queueIndex);
			int oldDist = tempEdge.distance;
			if(oldDist > newDist) {
				pQ.removeN(queueIndex);  // 删除旧的边
				Edge edge = new Edge(currentVert, newVert, newDist);
				pQ.insert(edge);
			}
		}else { // 没有找到
			Edge edge = new Edge(currentVert, newVert, newDist);
			pQ.insert(edge);
		}
	}
}
