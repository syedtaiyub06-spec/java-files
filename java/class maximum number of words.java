class Solution {
    public int mostWordsFound(String[] sentences) {
        int max = 0;

        for (String sentence : sentences) {
            int words = 1;

            for (int i = 0; i < sentence.length(); i++) {
                if (sentence.charAt(i) == ' ') {
                    words++;
                }
            }

            if (words > max) {
                max = words;
            }
        }

        return max;
    }
}