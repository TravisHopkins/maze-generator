interface AdjacencyListInterface {
	public void addEdge(int key); // create a new Edge
	public void deleteEdge(int key); // delete an Edge
	public int numEdges(); // return the number of Edges
	public boolean empty(); // return true if empty
	public boolean search(int key); // return true if Edge exists
	//public Edge chooseRandomEdge(); // should be in Graph ADT instead? idk
}

public class AdjacencyList implements AdjacencyListInterface {
	private Edge head;
	
	/* constructor */
	public void AdjacencyList() {
		head = null;
	}
	
	/* create a new Edge */
	public void addEdge(int key) { // add case to prevent duplicate Edges?
		Edge newHead = new Edge(key, head);
		head = newHead;
	}
	
	/* return the number of Edges */
	public int numEdges() {
		int count = 0;
		Edge tmp = head;
		while (tmp != null) { // from head to tail, increment
			count++;
			tmp = tmp.getNext();
		}
		return count;
	}
	
	/* return true if empty */
	public boolean empty() {
		return (head == null);
	}
	
	/* return true if Edge */
	public boolean search(int key) {
		boolean result = false; // TODO: return error if 404 instead?
		Edge tmp = head;
		while (tmp != null) { // for each while not done, head to tail
			if (tmp.getKey() == key) {
				result = true;
				return result;
			} else {
				tmp = tmp.getNext(); // try the next one
			}
		}
		return result;
	}

	/* delete an Edge */
	public void deleteEdge(int key) {
		Edge tmp = head;
		Edge prev = null;
		if (tmp == null) { // if empty
			return; // exits
		}
		if (tmp != null && tmp.getKey() == key) { // if head matches key
			head = tmp.getNext();
			return; // exits
		}
		while (tmp != null && tmp.getKey() != key) {
			prev = tmp;
			tmp = tmp.getNext();
		}
		if (tmp == null) { // not found. TODO: Throw error?
			return; // exits
		}
		prev.setNext(tmp.getNext()); // update previous node's pointer
	}

	/* print all the Edges in this AdjacencyList */
	public void traverse() {
		Edge tmp = head;
		while (tmp != null) { // for each, head to tail (like Stack)
			System.out.print(tmp.getKey() + " ");
			tmp = tmp.getNext();
		}
	}
}
