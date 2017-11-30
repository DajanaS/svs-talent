import java.io.*;
import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
        String fileName = args[0];
        Map<String, Integer> map = new HashMap<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileInputStream(fileName));
            while (scanner.hasNextLine()) {
                String[] words = scanner.nextLine().split(" ");
                for (String word : words) {
                    if (!map.containsKey(word))
                        map.put(word, 1);
                    else
                        map.put(word, map.get(word) + 1);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (String key : map.keySet()) {
                sb.append(key + ": " + map.get(key) + "\n");
            }
            System.out.println(sb.toString());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}