import java.util.*;
class Solution {
    public int slidingPuzzle(int[][] board) {
        int m = 2, n = 3;
        String target = "123450";
        Set<String> visited = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]);
            }
        }
        String start = sb.toString();
        visited.add(start);

        Queue<String> q = new LinkedList<>();
        q.offer(start);

        // index at 0 can swap with index at 1 and 3
        int[][] swaps = new int[][] {
            {1, 3}, 
            {0, 2, 4},
            {1, 5},
            {0, 4},
            {1, 3, 5},
            {2, 4}
        };

        int step = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(target)) {
                    return step;
                }
                int index = cur.indexOf('0');
                for (int j : swaps[index]) {
                    String next = swap(cur.toCharArray(), index, j);
                    if (visited.contains(next)) {
                        continue;
                    }
                    visited.add(next);
                    q.offer(next);
                }
            }

            step++;
        }
        return -1;
    }
    private String swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;

        return new String(ch);
    }
}