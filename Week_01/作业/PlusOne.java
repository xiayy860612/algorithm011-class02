/**
 * 加一:
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 只有2中场景:
 * - 除 9 之外的数字加一
 * - 9的话进位
 *
 * - [优解](https://leetcode-cn.com/problems/plus-one/solution/java-shu-xue-jie-ti-by-yhhzw/)
 */
class PlusOne {

    /**
     * 数组合并成一个整数后加1, 然后再分解为数组
     *
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */

    /**
     * 从数组最后面的整数开始加1, 如果发生进位,
     * 则当前位置则为0, 并且往前一位继续加1, 直到没有进位
     *
     * 时间复杂度: O(n)
     * 空间复杂度: O(1), 最坏情况O(n)
     */
    public int[] solution1(int[] digits) {
        for (int i = digits.length - 1; i >= 0; --i) {
            digits[i] = (digits[i] + 1) % 10;
            if (digits[i] == 0) {
                continue;
            }
            return digits;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}