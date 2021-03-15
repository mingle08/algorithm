package algo.girlTeacher.graph.bfs;

public class BfsApp {

	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addVertex('A');   // 数组中， A的索引是0
		graph.addVertex('B');   // 数组中， B的索引是1
		graph.addVertex('C');   // 数组中， C的索引是2
		graph.addVertex('D');   // 数组中， D的索引是3
		graph.addVertex('E');   // 数组中， E的索引是4
		graph.addEdge(0, 1);  // A（索引为0） --- B（索引为1）
		graph.addEdge(0, 2);  // A（索引为0） --- C（索引为2）
		graph.addEdge(0, 3);  // A（索引为0） --- D（索引为3）
		graph.addEdge(1, 3);  // B（索引为1） --- D（索引为3）
		graph.addEdge(3, 4);  // D（索引为3） --- E（索引为4）

		System.out.print("Visits: ");
		graph.bfs();
		System.out.println();
	}

}
