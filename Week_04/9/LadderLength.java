import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.isBlank() || !wordList.contains(endWord)) {
            return 0;
        }

        char[] replaces = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        Set<String> words = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int step = 1;
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count-- > 0) {
                String cur = queue.remove();
                char[] chars = cur.toCharArray();
                for (int i = 0; i < cur.length(); ++i) {
                    char old = chars[i];
                    for (char replace : replaces) {
                        chars[i] = replace;
                        String newStr = new String(chars);
                        if (words.remove(newStr)) {
                            if (newStr.equals(endWord)) {
                                return step + 1;
                            }

                            queue.add(newStr);
                        }
                    }
                    chars[i] = old;
                }
            }
            ++step;
        }
        return 0;
    }

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> comboDict = generateComboDict(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        Set<String> visited = new LinkedHashSet<>();
        visited.add(beginWord);

        int step = 1;
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count-- > 0) {
                String cur = queue.remove();
                for (int i = 0; i < cur.length(); ++i) {
                    String newCombo = getCombo(cur, i);
                    if (!comboDict.containsKey(newCombo)) {
                        continue;
                    }

                    for (String child : comboDict.get(newCombo)) {
                        if (child.equals(endWord)) {
                            return step + 1;
                        }

                        if (!visited.contains(child)) {
                            visited.add(child);
                            queue.add(child);
                        }
                    }
                }
            }
            ++step;
        }
        return 0;
    }

    private Map<String, List<String>> generateComboDict(List<String> wordList) {
        Map<String, List<String>> map = new LinkedHashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < word.length(); ++i) {
                String combo = getCombo(word, i);
                List<String> children = map.getOrDefault(combo, new LinkedList<>());
                children.add(word);
                map.put(combo, children);
            }
        }
        return map;
    }

    private String getCombo(String cur, int i) {
        return cur.substring(0, i) + "*" + cur.substring(i+1);
    }
}