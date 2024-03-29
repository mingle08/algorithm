package algorithm.dijkstra;

public class GraphDijkstra {
	private final static int MAXVEX = 9;
	private final static int MAXWEIGHT = 65535;
	private int[] shortTablePath = new int[MAXVEX];// 记录的是v0到某顶点的最短路径和

	/**
	 * 获取一个图的最短路径
	 */
	public void shortestPathDijkstra(Graph graph) {
		int min;
		int k = 0;  // 记录下标
		boolean[] isGetPath = new boolean[MAXVEX];
		for(int v = 0; v < graph.getVertexSize(); v++) {
			shortTablePath[v] = graph.getMatrix()[0][v];// 获取v0这一行的权值数组
		}
		shortTablePath[0] = 0;
		isGetPath[0] = true;
		for(int v = 1; v < graph.getVertexSize(); v++) {
			min = MAXWEIGHT;
			for(int w = 0; w < graph.getVertexSize(); w++) {
				if(!isGetPath[w] && shortTablePath[w] < min) {
					k = w;
					min = shortTablePath[w];
				}
			}
			isGetPath[k] = true;
			for(int j = 0; j < graph.getVertexSize(); j++) {
				if(! isGetPath[j] && (min + graph.getMatrix()[k][j] < shortTablePath[j])) {
					shortTablePath[j] = min + graph.getMatrix()[k][j];
				}
			}
		}
		for(int i = 0; i < shortTablePath.length; i++) {
			System.out.println("V0到V"+i+"的最短路径为:"+shortTablePath[i]+"\n");
		}
	}

	public static void main(String[] args) {
		Graph graph = new Graph(MAXVEX);
		graph.createGraph();
		GraphDijkstra dijkstra = new GraphDijkstra();
		dijkstra.shortestPathDijkstra(graph);
	}
}
