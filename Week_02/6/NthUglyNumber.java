import java.util.*;

/**
 * 丑数:
 * https://leetcode-cn.com/problems/chou-shu-lcof/
 */
class NthUglyNumber {
    /**
     * 动态规划:
     * 将找到的丑数存到集合中
     * 遍历一个数的余数是否在集合中, 如果不在, 则非丑数; 在则为丑数
     *
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */

    /**
     * 大根堆:
     *
     * 这个问题转换为第n大的丑数
     *
     * 时间复杂度: O(log n),
     * 空间复杂度: O(n)
     */
    public int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }

        long[] primes = new long[] {2, 3, 5};
        PriorityQueue<Long> heap = new PriorityQueue<>();
        Set<Long> uglyNums = new HashSet<>();
        for (long prime : primes) {
            heap.add(prime);
            uglyNums.add(prime);
        }

        long num = 1;
        for (int i = 1; i < n; ++i) {
            num = heap.remove();
            for (long prime : primes) {
                long cur = num * prime;
                if (!uglyNums.contains(cur)) {
                    heap.add(cur);
                    uglyNums.add(cur);
                }
            }
        }
        return (int) num;
    }
}