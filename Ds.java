import java.util.*;
/* 
class Solution {
    private List<List<Integer>> graph;

    private int bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n];
        visited[0] = true;
        dist[0] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            if (node == n - 1) { 
                return dist[node];
            }
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    dist[neighbor] = dist[node] + 1;
                    q.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        return -1;
    }
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            graph.get(i).add(i + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (int[] query : queries) {
            graph.get(query[0]).add(query[1]);
            res.add(bfs(n));
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
*/
class Solution {
    private List<List<int[]>> graph;
    private int dijkstra(int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] ele = pq.poll();
            int cd = ele[0], node = ele[1];
            if (node == n - 1) return dist[n - 1];
            if (cd > dist[node]) continue;
            for (int[] neighbor : graph.get(node)) {
                int nbr = neighbor[0], wt = neighbor[1];
                if (cd + wt < dist[nbr]) {
                    dist[nbr] = cd + wt;
                    pq.offer(new int[]{cd + wt, nbr});
                }
            }
        }
        return dist[n - 1];
    }
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            graph.get(i).add(new int[]{i + 1, 1});
        }
        List<Integer> res = new ArrayList<>();
        for (int[] query : queries) {
            graph.get(query[0]).add(new int[]{query[1], 1});
            res.add(dijkstra(n));
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}