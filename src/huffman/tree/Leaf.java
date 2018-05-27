package huffman.tree;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

import static java.lang.String.format;

public class Leaf extends Node {
    private final char value;
    private String coding;

    public Leaf(int count, char value) {
        super(count);
        this.value = value;
    }

    public char value() {
        return value;
    }

    @Override
    public List<Node> children() {
        return Collections.emptyList();
    }

    @Override
    public boolean hasChildren() {
        return false;
    }

    @Override
    public void setCoding(String coding) {
        this.coding = coding;
    }

    public String coding() {
        return coding;
    }

    @Override
    public String toString() {
        return format("[%d '%c']", count(), value);
    }

    @Override
    public void forEachLeaf(Consumer<Leaf> leavesConsumer) {
        leavesConsumer.accept(this);
    }
}
