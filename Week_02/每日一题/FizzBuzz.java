import java.util.*;

/**
 * https://leetcode-cn.com/problems/fizz-buzz/
 *
 *
 */
class FizzBuzz {

    /**
     * 模拟法, 判断每个数
     *
     * if n % 3 == 0 && n % 5 == 0: FizzBuzz
     * elif n % 3 == 0: Fizz
     * elif n % 5 == 0: Buzz
     * else n
     */

    /**
     * 哈希表
     * 时间复杂度: O(n * K)
     * 空间复杂度: O(1)
     */
    public List<String> fizzBuzz(int n) {
        Map<Integer, String> map = new HashMap<>() {{
            put(3, "Fizz");
            put(5, "Buzz");
        }};
        List<String> result = new LinkedList<>();
        for (int i = 1; i <= n; ++i) {
            String ans = "";
            for (Integer key : map.keySet()) {
                if (i % key == 0) {
                    ans += map.get(key);
                }
            }
            if (ans.isBlank()) {
                ans = String.valueOf(i);
            }
            result.add(ans);
        }
        return result;
    }
}