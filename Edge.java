/* Edge methods */
interface EdgeInterface {
    public int getKey();
    public Edge getNext();
    public void setNext(Edge next);
}

/* Edge ADT */
class Edge implements EdgeInterface {
    private int key;
    private Edge next;

    /* constructor */
    public Edge(int key, Edge next) {
        this.key = key;
        this.next = next;
    }
    
    /* return key */
    public int getKey() {
        return key;
    }

    /* return next Edge in AdjacencyList */
    public Edge getNext() {
        return next;
    }

    /* set next Edge in AdjacencyList */
    public void setNext(Edge next) {
        this.next = next;
    }
}
