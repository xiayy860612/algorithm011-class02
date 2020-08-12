import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Collection<Character> replaces = Arrays.asList('A', 'C', 'G', 'T');
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        Queue<String> queue = new LinkedList<>();
        queue.add(start);

        int step = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count-- > 0) {
                String cur = queue.remove();
                if (cur.equals(end)) {
                    return step;
                }

                char[] chars = cur.toCharArray();
                for (int i = 0; i < cur.length(); ++i) {
                    char tmp = chars[i];
                    for (Character replace : replaces) {
                        chars[i] = replace;
                        String change = new String(chars);
                        if (bankSet.remove(change)) {
                            queue.add(change);
                        }
                    }
                    chars[i] = tmp;
                }
            }
            ++step;
        }
        return -1;
    }

    public static void main(String[] args) {
        new Solution().minMutation("AACCGGTT",
            "AACCGGTA",
                new String[]{"AACCGGTA"});
    }
}