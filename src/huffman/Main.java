package huffman;

import huffman.tree.Node;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Wpisz tekst:");
            String text = scanner.nextLine();
            Node decomposedTree = HuffmanProcessor.decomposeToTree(text);
            Map<Character, String> codeMap = HuffmanProcessor.treeToCodeMap(decomposedTree);

            HuffmanProcessor.printCodeMap(codeMap, System.out);

            String encodedText = HuffmanProcessor.encodeText(text, codeMap);
            System.out.println("Zakodowany tekst:");
            System.out.println(encodedText);
        }
    }
}
