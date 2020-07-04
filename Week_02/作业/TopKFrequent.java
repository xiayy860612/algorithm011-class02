import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 前 K 个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
class TopKFrequent {
    /**
     * 哈希计数 + 构建大根堆
     * 时间复杂度: O(n * log k)
     * 空间复杂度: O(n)
     */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(
                (n1, n2) -> counts.get(n1) - counts.get(n2));
        for (int n : counts.keySet()) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] result = new int[k];
        int index = k - 1;
        while (index >= 0) {
            result[index--] = heap.poll();
        }
        return result;
    }

}