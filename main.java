public class main {
	public static void main(String[] args) {
		int w = Integer.parseInt(args[0]);
		int h = Integer.parseInt(args[1]);
		//Graph g = new Graph(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		Graph g = new Graph(w, h);
		g.traverse();
	}
}
