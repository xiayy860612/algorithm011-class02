
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Solution {

    /**
     * 时间复杂度: O(n)
     */
    public int fib(int N) {
        if (N <= 1){
            return N;
        }

        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= N; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    public static void main(String[] args) {
    }
}