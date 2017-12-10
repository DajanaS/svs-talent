import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.*;

public class ImprovedWordCounter {
    public static void main(String[] args) {
        String fileName = args[0];
        Map<String, Integer> map = new HashMap<String, Integer>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileInputStream(fileName));
            while (scanner.hasNextLine()) {
                String[] words = scanner.nextLine().split(" ");
                for (String word : words) {
                    word = StringUtils.lowerCase(word);
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