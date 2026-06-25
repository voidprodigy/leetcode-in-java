import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());

        int[] indegree = new int[numCourses];

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];

            graph.get(prereq).add(course);
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }

        int[] ans = new int[numCourses];
        int idx = 0;

        while (!q.isEmpty()) {

            int curr = q.poll();
            ans[idx++] = curr;

            for (int next : graph.get(curr)) {

                indegree[next]--;

                if (indegree[next] == 0)
                    q.offer(next);
            }
        }

        if (idx == numCourses)
            return ans;

        return new int[0];
    }
}