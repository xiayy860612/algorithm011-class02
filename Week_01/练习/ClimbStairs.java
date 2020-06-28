/**
 * 爬楼梯:
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 * @see <a href="https://leetcode-cn.com/problems/climbing-stairs/">爬楼梯</a>
 *
 * f(n) = f(n-1) + f(n-2)
 *
 * 优解参考:
 * - <a href="https://leetcode-cn.com/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode-solution/">爬楼梯官方题解</a>
 */
class ClimbStairs {

    /**
     * 动态规划解法
     *
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    public int solution1(int n) {
        if (n < 0) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }

        int[] rst = new int[n] {0};
        rst[0] = 0;
        rst[1] = 1;
        rst[2] = 2;

        for (int i = 3; i < n; ++i) {
            rst[i] = rst[i - 1] + rst[i - 2];
        }

        return rst[n - 1] + rst[n - 2];
    }

    /**
     * 推荐
     * 动态规划解法
     *
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    public int solution2(int n) {
        if (n < 0) {
            return 0;
        }

        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }

        return r;
    }

    /**
     * 推荐
     * 斐波那契数列的公式
     *
     * 只要符合斐波那契数列的递推公式f(n) = f(n-1) + f(n+2),
     * 就可以直接使用斐波那契数列的通式来计算
     *
     * 时间复杂度: O(log n)
     * 空间复杂度: O(1)
     */
    public int solution3(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int)(fibn / sqrt5);
    }

    public static void main(String[] args) {
        System.out.println("climbStairs");
    }
}