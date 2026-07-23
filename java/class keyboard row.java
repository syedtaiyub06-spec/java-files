import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String[] findWords(String[] words) {
        int[] rowMap = new int[26];
        String r1 = "qwertyuiop";
        String r2 = "asdfghjkl";
        String r3 = "zxcvbnm";

        for (char c : r1.toCharArray()) rowMap[c - 'a'] = 1;
        for (char c : r2.toCharArray()) rowMap[c - 'a'] = 2;
        for (char c : r3.toCharArray()) rowMap[c - 'a'] = 3;

        List<String> result = new ArrayList<>();

        for (String word : words) {
            String lower = word.toLowerCase();
            int targetRow = rowMap[lower.charAt(0) - 'a'];
            boolean isValid = true;

            for (int i = 1; i < lower.length(); i++) {
                if (rowMap[lower.charAt(i) - 'a'] != targetRow) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);
    }
}