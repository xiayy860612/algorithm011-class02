import java.util.Deque;
import java.util.LinkedList;

class DequeDemo {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
//        deque.push("a");
//        deque.push("b");
//        deque.push("c");
        deque.addFirst("b");
        deque.addLast("a");
        deque.addFirst("c");
        System.out.println(deque);

//        String str = deque.peek();
//        String str = deque.getFirst();
        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size() > 0) {
//            System.out.println(deque.pop());
            System.out.println(deque.removeFirst());
        }
        System.out.println(deque);
    }
}