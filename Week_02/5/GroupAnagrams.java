import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 字母异位词分组:
 * https://leetcode-cn.com/problems/group-anagrams/
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
     * 使用HashMap以按字母(a-z)排序的计数组合的字符串为key, 存储字符串数组
     *
     * 时间复杂度: O(n*k)
     * 空间复杂度: O(nk)
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return Collections.emptyList();
        }

        Map<String, List<String>> map = new HashMap<>();
        int[] counts = new int[26];
        for (String s : strs) {
            Arrays.fill(counts, 0);
            for (char c : s.toCharArray()) {
                counts[c - 'a']++;
            }

            StringBuilder builder = new StringBuilder();
            for (int count : counts) {
                builder.append(count);
            }
            String key = builder.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}