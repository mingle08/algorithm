package algo.girlTeacher.mstweight;

public class MstWeightApp {

	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addVertex('A');   // index 0
		graph.addVertex('B');   // index 1
		graph.addVertex('C');   // index 2
		graph.addVertex('D');   // index 3
		graph.addVertex('E');   // index 4
		graph.addVertex('F');   // index 5
		
		graph.addEdge(0, 1, 6);  // A B  6
		graph.addEdge(0, 3, 4);  // A D  4
		graph.addEdge(1, 2, 10);  // B C  10
		graph.addEdge(1, 3, 7);  // B D  7
		graph.addEdge(1, 4, 7);  // B E  7
		graph.addEdge(2, 3, 8);  // C D  8
		graph.addEdge(2, 4, 5);  // C E  5
		graph.addEdge(2, 5, 6);  // C F  6
		graph.addEdge(3, 4, 12);  // D E  12
		graph.addEdge(4, 5, 7);  // E F  7
		
		System.out.println("Minimum spanning tree:");
		graph.mstweight();
		System.out.println();
	}

}
