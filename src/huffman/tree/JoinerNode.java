package huffman.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static java.lang.String.format;

public class JoinerNode extends Node {
    private final Node left;
    private final Node right;

    public JoinerNode(int count, Node left, Node right) {
        super(count);
        this.left = left;
        this.right = right;
    }

    @Override
    public List<Node> children() {
        List<Node> children = new ArrayList<>(2);
        children.add(left);
        children.add(right);
        return children;
    }

    @Override
    public String toString() {
        return format("[%d %s %s]", count(), left, right);
    }

    @Override
    public void setCoding(String coding) {
        left.setCoding(coding + "0");
        right.setCoding(coding + "1");
    }

    @Override
    public void forEachLeaf(Consumer<Leaf> leavesConsumer) {
        left.forEachLeaf(leavesConsumer);
        right.forEachLeaf(leavesConsumer);
    }
}
