import java.util.*;

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int row = board.length;
        if (row == 0) {
            return Collections.emptyList();
        }

        Trie trie = createTrie(words);
        Set<String> result = new HashSet<>();
        int col = board[row - 1].length;
        for (int r = 0; r < row; ++r) {
            for (int c = 0; c < col; ++c) {
                lookupBoard(board, r, c, trie, result);
            }
        }
        return new ArrayList<>(result);
    }

    private void lookupBoard(char[][] board, int r, int c, Trie parent, Set<String> result) {
        if (r < 0 || c < 0) {
            return;
        }

        if (r == board.length || c == board[r].length) {
            return;
        }

        char a = board[r][c];
        if (a == '#') {
            return;
        }

        Trie next = parent.getNext(a);
        if (next == null) {
            return;
        }

        if (next.getWord() != null) {
            result.add(next.getWord());
        }

        board[r][c] = '#';
        int[][] directs = new int[][] {
                {0, 1},
                {0, -1},
                {-1, 0},
                {1, 0},
        };
        for (int[] direct : directs) {
            lookupBoard(board, r + direct[1], c + direct[0], next, result);
        }
        board[r][c] = a;
    }

    private Trie createTrie(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        return trie;
    }

    public static class Trie {
        private String word;
        private Trie[] next;

        /** Initialize your data structure here. */
        public Trie() {
            word = null;
            next = new Trie[26];
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            if (word == null || word.length() == 0) return;
            Trie curr = this;
            for(char c : word.toCharArray()) {
                int n = c - 'a';
                if (curr.next[n] == null)
                    curr.next[n] = new Trie();
                curr = curr.next[n];
            }
            curr.word = word;
        }

        public Trie getNext(char c) {
            return this.next[c - 'a'];
        }

        public String getWord() {
            return this.word;
        }

        private Trie searchPrefix(String word) {
            Trie node = this;
            for(char c : word.toCharArray()) {
                node = node.next[c - 'a'];
                if (node == null)
                    return null;
            }
            return node;
        }
    }

    public static void main(String[] args) {
        char[][] boards = new char[][] {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String[] words = new String[] {
                "oath","pea","eat","rain"
        };
        new Solution().findWords(boards, words);
    }
}