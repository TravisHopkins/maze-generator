public class Graph {
	private int size, width, height;
	AdjacencyList[] vertices;
	
	/* constructor */
	public Graph(int width, int height) {
		this.width = width;
		this.height = height;
		this.size = width * height;
		vertices = new AdjacencyList[size];
		for (int i=0; i<size; i++) {
			vertices[i] = new AdjacencyList();
		}
		vertices[0].addEdge(1); // top left corner
		vertices[0].addEdge(width);
		for (int i=1; i<width-1; i++) { // top side
			vertices[i].addEdge(i-1);
			vertices[i].addEdge(i+width);
			vertices[i].addEdge(i+1);
		}
		vertices[width-1].addEdge(width-2); // top right corner
		vertices[width-1].addEdge(2*width-1);
		for (int i=width; i<size-width; i+=width) { // left side
			vertices[i].addEdge(i-width);
			vertices[i].addEdge(i+width);
			vertices[i].addEdge(i+1);
		}
		for (int i=2*width-1; i<size-1; i+=width) { // right side
			vertices[i].addEdge(i-width);
			vertices[i].addEdge(i-1);
			vertices[i].addEdge(i+width);
		}
		vertices[size-width].addEdge(size-2*width); // bottom left corner
		vertices[size-width].addEdge(size-width+1);
		for (int i=size-width+1; i<size-1; i++) { // bottom side
			vertices[i].addEdge(i-1);
			vertices[i].addEdge(i-width);
			vertices[i].addEdge(i+1);
		}
		vertices[size-1].addEdge(size-2); // bottom right corner
		vertices[size-1].addEdge(size-1-width);
		for (int i=width+1; i<size-width-1; i++) { // center
			if (vertices[i].empty()) {
				vertices[i].addEdge(i-1);
				vertices[i].addEdge(i+1);
				vertices[i].addEdge(i-width);
				vertices[i].addEdge(i+width);
			}
		}
	}

	/* add Edge between Vertices 1 and 2 */
	public void addEdge(int v1, int v2) {
		vertices[v1].addEdge(v2);
	}

	/* delete Edge between Vertices 1 and 2 */
	public void deleteEdge(int v1, int v2) {
		// v1's AdjacencyList should cover nonexistent Edges
		//System.out.println("DELETING"); // remove later, for testing purposes
		vertices[v1].deleteEdge(v2);
	}

	/* return number of Vertices in Graph */
	public int numVertices() {
		return size;
	}

	/* return number of Edges in Graph */
	public int numEdges() {
		int total = 0;
		for (AdjacencyList adj : vertices) {
			total += adj.numEdges();
		}
		return total;
	}

	/* traverse every Adjacencylist in the Graph */
	public void traverse() {
		for (int i=0; i<size; i++) {
			System.out.print(i + ": ");
			vertices[i].traverse();
			System.out.println();
		}
		/*
		for (AdjacencyList adj : vertices) {
			adj.traverse(); // TODO: add Vertex key itself?
			System.out.println();
		}
		*/
	}

	public boolean hasEdge(int v1, int v2) {
		return vertices[v1].search(v2);
	}
}
