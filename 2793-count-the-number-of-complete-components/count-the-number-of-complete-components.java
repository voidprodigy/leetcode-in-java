import java.util.*;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();

        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        boolean[] vis = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;

            int nodes = 0, degree = 0;
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            vis[i] = true;

            while (!q.isEmpty()) {
                int u = q.poll();
                nodes++;
                degree += g[u].size();

                for (int v : g[u]) {
                    if (!vis[v]) {
                        vis[v] = true;
                        q.offer(v);
                    }
                }
            }

            if (degree == nodes * (nodes - 1))
                ans++;
        }

        return ans;
    }
}