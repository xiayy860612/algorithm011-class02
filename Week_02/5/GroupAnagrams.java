import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 字母异位词分组:
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 说明：
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * 参考:
 * - [LeetCode官方题解](https://leetcode-cn.com/problems/group-anagrams/solution/zi-mu-yi-wei-ci-fen-zu-by-leetcode/)
 */
class GroupAnagrams {
    /**
     * 排序分类
     * 使用HashMap以排序后的数组为key, 存储字符串数组
     * for (str : arr):
     *  key = sort(str)
     *  hashMap[key].add(str)
     *
     * 时间复杂度: O(n*k*log k)
     * 空间复杂度: O(nk)
     */

    /**
     * 按计数分类
     * 使用HashMap以字母计数组合的字符串(a2b3d5...)为key, 存储字符串数组
     *
     * 时间复杂度: O(n*k)
     * 空间复杂度: O(nk)
     */
    public List<List<String>> solution1(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = getKey(str);
            if (!map.containsKey(key)) {
                map.put(key, new LinkedList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private String getKey(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map.entrySet().stream()
            .sorted((l, r) -> {
                if (l.getKey() == r.getKey()) {
                    return 0;
                }
                return l.getKey() > r.getKey() ? 1 : -1;
            })
            .map(entry -> String.format("%s%s", entry.getKey(), entry.getValue()))
            .collect(Collectors.joining());
    }

    public List<List<String>> solution2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray()) {
                ca[c - 'a']++;
            }
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<>());
            }
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }
}