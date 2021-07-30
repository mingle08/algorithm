package algo.girlTeacher.graph.dfs;

public class Graph {

    private final int MAX_VERTS = 20;
    /**
     * 存放顶点的数组
     */
    private Vertex[] vertexList;
    /**
     * 邻接矩阵
     */
    private int[][] adjMat;

    /**
     * 当前的顶点数
     */
    private int nVerts;

    /**
     * 深度优先搜索用栈
     */
    private StackX stackX;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }

        stackX = new StackX();
    }

    /**
     * 添加顶点
     */
    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    /**
     * 添加边:邻接矩阵中，如果A和B是相连的，那边从A到B是1，从B到A也是1
     */
    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    /**
     * 深度优先搜索
     */
    public void dfs() {
        // 第一个顶点，标记已访问过
        vertexList[0].isVisited = true;
        // 显示被访问的顶点
        displayVertex(0);
        stackX.push(0);
        while (!stackX.isEmpty()) {
            int v = getAdjUnvisitedVertex(stackX.peek());
            if (v == -1) {
                stackX.pop();
            } else {
                vertexList[v].isVisited = true;
                displayVertex(v);
                stackX.push(v);
            }
        }

        // 还原为初始状态
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].isVisited = false;
        }
    }

    public int getAdjUnvisitedVertex(int v) {
        for (int i = 0; i < nVerts; i++) {
            // == 1表示二个点是连通的
            if (adjMat[v][i] == 1 && !vertexList[i].isVisited) {
                // 找到了一个与v顶点相邻接的未访问的顶点数量
                return i;
            }
        }
        // 未找到
        return -1;
    }
}
