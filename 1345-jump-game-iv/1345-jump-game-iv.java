class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;

        if (n == 1)
            return 0;

        HashMap<Integer, List<Integer>> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            mp.putIfAbsent(arr[i], new ArrayList<>());
            mp.get(arr[i]).add(i);
        }

        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[n];

        que.offer(0);
        visited[0] = true;

        int steps = 0;

        while (!que.isEmpty()) {

            int size = que.size();

            while (size-- > 0) {

                int curr = que.poll();

                if (curr == n - 1)
                    return steps;

                int left = curr - 1;
                if (left >= 0 && !visited[left]) {
                    visited[left] = true;
                    que.offer(left);
                }

                int right = curr + 1;
                if (right < n && !visited[right]) {
                    visited[right] = true;
                    que.offer(right);
                }

                if (mp.containsKey(arr[curr])) {

                    for (int idx : mp.get(arr[curr])) {

                        if (!visited[idx]) {
                            visited[idx] = true;
                            que.offer(idx);
                        }
                    }

                    mp.remove(arr[curr]);
                }
            }

            steps++;
        }

        return -1;
    }
}