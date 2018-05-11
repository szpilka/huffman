package huffman.tree;

import java.util.List;

public abstract class Node {
    private final int count;

    protected Node(int count) {
        this.count = count;
    }

    public int count() {
        return count;
    }

    public abstract List<Node> children();

    public boolean hasChildren() {
        return !children().isEmpty();
    }
}
