import java.util.ArrayList;
import java.util.HashMap;

/**
 * 两个数组的交集 II:
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 *
 * 进阶:
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * 关键点:
 * 对长度小的数组做hash, 长度长的用于比较
 *
 * 参考:
 * - [LeetCode官方题解](https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/solution/liang-ge-shu-zu-de-jiao-ji-ii-by-leetcode/)
 */
class IntersectionOfTwoArraysII {

    /**
     * 排序后双指针比较
     * {@code
     * sort(arr1)
     * sort(arr2)
     * rst = []
     * while (i < arr1.length && j < arr2.length) {
     *     if arr1[i] == arr2[j]:
     *          rst.add(arr1[i])
     *          ++i;
     *          ++j;
     *     elif arr1[i] > arr2[j]:
     *          ++j;
     *     else:
     *          ++i;
     * }
     * }
     *
     * 时间复杂度: O(nlog n)
     * 时间复杂度: O(n)
     */

    /**
     * 哈希表计数分组
     * {@code
     *  for e in arr1:
     *      hash[e]++
     *  rst = []
     *  for e in arr2:
     *      if e in hash:
     *          rst.add(e)
     *          hash[e]--
     *          if hash[e] == 0:
     *              hash.rm(e)
     * }
     *
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    public int[] solution1(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        int[] hashNums;
        int[] compareNums;
        if (nums1.length <= nums2.length) {
            hashNums = nums1;
            compareNums = nums2;
        } else {
            hashNums = nums2;
            compareNums = nums1;
        }

        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int num : hashNums) {
            hash.put(num, hash.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int num : compareNums) {
            if (hash.containsKey(num)) {
                result.add(num);
                int amount = hash.get(num) - 1;
                if (amount == 0) {
                    hash.remove(num);
                } else {
                    hash.put(num, amount);
                }
            }
        }
        int[] rst = new int[result.size()];
        for (int i = 0; i < result.size(); ++i) {
            rst[i] = result.get(i);
        }
        return rst;
    }
}