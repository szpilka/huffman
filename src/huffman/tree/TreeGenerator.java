package huffman.tree;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;

public class TreeGenerator {
    public static Node generateTree(List<Leaf> leaves) {
        if (leaves.isEmpty()) {
            throw new IllegalArgumentException();
        }

        List<Node> result = new ArrayList<>(leaves);
        while (result.size() > 1) {
            result.sort(comparing(Node::count));
            Node first = result.remove(0);
            Node second = result.remove(0);
            result.add(new JoinerNode(first.count() + second.count(), first, second));
        }
        return result.get(0);
    }
}
