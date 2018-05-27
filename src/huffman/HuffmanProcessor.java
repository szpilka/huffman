package huffman;

import huffman.tree.Leaf;
import huffman.tree.Node;
import huffman.tree.TreeGenerator;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;
import static java.util.Map.Entry.comparingByKey;
import static java.util.stream.Collectors.toList;

public class HuffmanProcessor {
    public static Node decomposeToTree(String value) {
        Map<Character, Integer> characterOccurrencesCount = new HashMap<>();
        for (int i = 0; i < value.length(); i++) {
            char character = value.charAt(i);
            if (characterOccurrencesCount.containsKey(character)) {
                characterOccurrencesCount.put(character, characterOccurrencesCount.get(character) + 1);
            } else {
                characterOccurrencesCount.put(character, 1);
            }
        }

        List<Leaf> leaves = characterOccurrencesCount.entrySet().stream()
                .map(entry -> new Leaf(entry.getValue(), entry.getKey()))
                .collect(toList());
        return TreeGenerator.generateTree(
                leaves);
    }

    public static Map<Character, String> treeToCodeMap(Node root) {
        Map<Character, String> result = new HashMap<>();
        root.forEachLeaf(leaf -> result.put(leaf.value(), leaf.coding()));
        return result;
    }

    public static void printCodeMap(Map<Character, String> codeMap, PrintStream printer) {
        printer.println("Znak    Kod");
        codeMap.entrySet().stream()
                .sorted(comparingByKey())
                .forEach(codeEntry -> printer.println(format("'%c'     %s", codeEntry.getKey(), codeEntry.getValue())));
    }

    public static String encodeText(String text, Map<Character, String> codeMap) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            if (!result.isEmpty()) {
                result += " ";
            }
            result += codeMap.get(text.charAt(i));
        }
        return result;
    }
}
