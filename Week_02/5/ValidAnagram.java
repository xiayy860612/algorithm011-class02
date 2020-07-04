import java.util.HashMap;
import java.util.Hashtable;

/**
 * 有效的字母异位词:
 * https://leetcode-cn.com/problems/valid-anagram/
 */
class ValidAnagram {
    /**
     * 哈希计数
     *
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    public boolean solution1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }

            int amount = map.get(c) - 1;
            if (amount == 0) {
                map.remove(c);
                continue;
            }
            map.put(c, amount);
        }
        return map.isEmpty();
    }
}