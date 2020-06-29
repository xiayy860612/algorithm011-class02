import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表:
 *
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 *
 * <a href="https://leetcode-cn.com/problems/linked-list-cycle/solution/huan-xing-lian-biao-by-leetcode/">LeetCode官方题解</a>
 */
class HasCycle {

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    /**
     * 哈希表:
     * 检查一个结点此前是否被访问过来判断链表是否为环形链表。常用的方法是使用哈希表。
     *
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    public boolean solution1(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针
     *
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    public boolean solution2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (slow == null || slow.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}