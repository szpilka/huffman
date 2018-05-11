package huffman;

import huffman.tree.Leaf;
import huffman.tree.Node;
import huffman.tree.TreeGenerator;

import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class Decomposer {
    public static Node decompose(String value) {
        Map<Character, Integer> characterOccurrencesCount = new HashMap<>();
        for (int i = 0; i < value.length(); i++) {
            characterOccurrencesCount.compute(value.charAt(i), (c, count) -> (count == null) ? 1 : count + 1);
        }
        return TreeGenerator.generateTree(
                characterOccurrencesCount.entrySet()
                        .stream()
                        .map(entry -> new Leaf(entry.getValue(), entry.getKey()))
                        .collect(toList()));
    }
}
