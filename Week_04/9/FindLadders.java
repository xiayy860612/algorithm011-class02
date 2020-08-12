import java.util.*;

class Solution {
    public List<List<String>>  ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> comboDict = generateComboDict(wordList);
        Queue<List<String>> queue = new LinkedList<>();
        queue.add(new LinkedList<>(Arrays.asList(beginWord)));

        Set<String> visited = new LinkedHashSet<>();
        visited.add(beginWord);

        List<List<String>> result = new LinkedList<>();
        boolean isFound = false;
        while (!queue.isEmpty()) {
            int count = queue.size();
            Set<String> subVisited = new LinkedHashSet<>();
            while (count-- > 0) {
                List<String> curQueue = queue.remove();
                String cur = curQueue.get(curQueue.size() - 1);
                for (int i = 0; i < cur.length(); ++i) {
                    String newCombo = getCombo(cur, i);
                    if (!comboDict.containsKey(newCombo)) {
                        continue;
                    }

                    for (String child : comboDict.get(newCombo)) {
                        if (child.equals(endWord)) {
                            isFound = true;
                            List<String> curResult = new LinkedList<>(curQueue);
                            curResult.add(child);
                            subVisited.add(child);
                            result.add(curResult);
                            continue;
                        }

                        if (!visited.contains(child)) {
                            List<String> curResult = new LinkedList<>(curQueue);
                            curResult.add(child);
                            subVisited.add(child);
                            queue.add(curResult);
                        }
                    }
                }
            }
            visited.addAll(subVisited);
            if (isFound) {
                break;
            }
        }
        return result;
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

    public static void main(String[] args) {
        new Solution().ladderLength2("red",
                "tax",
                        Arrays.asList("ted","tex","red","tax","tad","den","rex","pee"));
    }
}