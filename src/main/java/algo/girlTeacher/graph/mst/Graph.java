package algo.girlTeacher.graph.mst;

public class Graph {

	private final int MAX_VERTS = 20;
	private Vertex vertexList[];  // 顶点数组
	private int[][] adjMat;  // 邻接矩阵
	private int nVerts;  // 当前顶点数
	private StackX stackX;
	
	public Graph() {
		vertexList  =  new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for (int i = 0; i < MAX_VERTS; i++) {
			for (int j = 0; j < MAX_VERTS; j++) {
				adjMat[i][j] = 0;
			}
		}
		
		stackX = new StackX();
	}
	
	public void addVertex(char lab) {// 添加顶点
		vertexList[nVerts++] = new Vertex(lab);
	}
	
	public void addEdge(int start, int end) {// 添加一个边
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}
	
	public void displayVertex(int v) {
		System.out.print(vertexList[v].label);
	}
	
	/**
	 * 最小生成树
	 */
	public void mst() {
		vertexList[0].isVisited = true;
		stackX.push(0);
		while(!stackX.isEmpty()) {
			int currentVertex = stackX.peek();
			int v = getAdjUnvisitedVertex(currentVertex);
			if(v == -1) {// 没有找到邻接的，没有访问过的顶点
				stackX.pop();
			}else {
				vertexList[v].isVisited = true;
				stackX.push(v);
				displayVertex(currentVertex);
				displayVertex(v);
				System.out.print(" ");
			}
		}
		
		// 还原访问标志为false
		for (int i = 0; i < nVerts; i++) {
			vertexList[i].isVisited = false;
		}
	}
	
	public int getAdjUnvisitedVertex(int vertex) {
		for (int i = 0; i < nVerts; i++) {
			if(adjMat[vertex][i] == 1 && !vertexList[i].isVisited) {
				return i;
			}
			
		}
		return -1;
	}
}
