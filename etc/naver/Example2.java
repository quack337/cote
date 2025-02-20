package net.skhu.naver;

class Solution {
    public int solution(String S) {
        int maxWordCount = 0;
        int currentWordCount = 0;
        boolean readingWord = false;
        for (char c : S.toCharArray()) {
            if (readingWord) {
                if (!Character.isAlphabetic(c)) {
                    ++currentWordCount;
                    readingWord = false;
                }
            } else {
                if (Character.isAlphabetic(c))
                    readingWord = true;
            }
            if (c == '.' || c == '?' || c == '!') {
                if (currentWordCount > maxWordCount) {
                    maxWordCount = currentWordCount;
                    currentWordCount = 0;
                }
            }
        }
        if (readingWord) ++currentWordCount;
        if (currentWordCount > maxWordCount) {
            maxWordCount = currentWordCount;
            currentWordCount = 0;
        }
        return maxWordCount;
    }
}

public class Example2 {


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("a b. a b c?a b c d"));
    }
}

