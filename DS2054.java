class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        pq.offer(events[0]);
        int max = 0;
        int ans = 0;

        for(int i = 0; i < events.length; i++) {
            while(!pq.isEmpty() && pq.peek()[1] < events[i][0]) {
                max = Math.max(max, pq.poll()[2]);
            }

            ans = Math.max(ans, max + events[i][2]);
            pq.offer(events[i]);
        }

        return ans;
    } 
    ublic int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        pq.offer(events[0]);
        int max = 0;
        int ans = 0;

        for(int i = 0; i < events.length; i++) {
            while(!pq.isEmpty() && pq.peek()[1] < events[i][0]) {
                max = Math.max(max, pq.poll()[2]);
            }

            ans = Math.max(ans, max + events[i][2]);
            pq.offer(events[i]);
        }

        return ans;
    } 
}
