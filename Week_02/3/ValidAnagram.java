import java.util.HashMap;
import java.util.Hashtable;

/**
 * 有效的字母异位词:
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 说明:
 * - 字母异位词是指由相同的字母出现的次数相同, 但是顺序不同的单词, 即长度相等
 * - 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * 参考:
 * - [LeetCode官方题解](https://leetcode-cn.com/problems/valid-anagram/solution/you-xiao-de-zi-mu-yi-wei-ci-by-leetcode/)
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