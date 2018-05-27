package huffman.tree;

import java.util.function.Consumer;

public abstract class Node {
    private final int count;

    protected Node(int count) {
        this.count = count;
    }

    public int count() {
        return count;
    }

    public abstract void setCoding(String coding);

    public abstract void forEachLeaf(Consumer<Leaf> leavesConsumer);
}
