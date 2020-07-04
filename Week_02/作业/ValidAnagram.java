import java.util.HashMap;
import java.util.Hashtable;

/**
 * 有效的字母异位词:
 * https://leetcode-cn.com/problems/valid-anagram/
 */
class ValidAnagram {
    /**
     * 不推荐
     * 对两个字符串进行排序后比较
     *
     * 时间复杂度: O(nlog n)
     * 空间复杂度: O(1)
     */

    /**
     * 推荐:
     * 使用哈希表存储每个字母出现的次数, 最后用比较.
     * 可适用于unicode
     *
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    public boolean solution1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> hash = new HashMap<>();
        for (char c : s.toCharArray()) {
            hash.put(c, hash.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!hash.containsKey(c)) {
                return false;
            }

            int count = hash.get(c) - 1;
            if (count == 0) {
                hash.remove(c);
            }
            hash.put(c, count);
        }
        return hash.isEmpty();
    }
}