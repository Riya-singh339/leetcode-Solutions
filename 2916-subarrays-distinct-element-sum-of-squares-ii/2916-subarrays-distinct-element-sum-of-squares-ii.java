class Solution {
    static final int MOD = 1_000_000_007;

    public int sumCounts(int[] nums) {
        int n = nums.length;

        long[] sum = new long[4 * n];
        long[] square = new long[4 * n];
        long[] lazy = new long[4 * n];

        int[] last = new int[100001];
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int prev = last[nums[i]];

            update(1, 0, n - 1, prev, i, sum, square, lazy);

            ans = (ans + square[1]) % MOD;
            last[nums[i]] = i + 1;
        }

        return (int) ans;
    }

    private void update(int node, int l, int r, int ql, int qr,
                        long[] sum, long[] square, long[] lazy) {
        if (ql > r || qr < l) return;

        if (ql <= l && r <= qr) {
            square[node] = (square[node] + 2 * sum[node] + (r - l + 1)) % MOD;
            sum[node] = (sum[node] + (r - l + 1)) % MOD;
            lazy[node]++;
            return;
        }

        int mid = (l + r) / 2;
        push(node, l, r, mid, sum, square, lazy);

        update(node * 2, l, mid, ql, qr, sum, square, lazy);
        update(node * 2 + 1, mid + 1, r, ql, qr, sum, square, lazy);

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
        square[node] = (square[node * 2] + square[node * 2 + 1]) % MOD;
    }

    private void push(int node, int l, int r, int mid,
                      long[] sum, long[] square, long[] lazy) {
        long v = lazy[node];
        if (v == 0 || l == r) return;

        apply(node * 2, l, mid, v, sum, square, lazy);
        apply(node * 2 + 1, mid + 1, r, v, sum, square, lazy);
        lazy[node] = 0;
    }

    private void apply(int node, int l, int r, long v,
                       long[] sum, long[] square, long[] lazy) {
        long len = r - l + 1L;
        square[node] = (square[node] + 2 * v % MOD * sum[node] % MOD
                        + v * v % MOD * len) % MOD;
        sum[node] = (sum[node] + v * len) % MOD;
        lazy[node] = (lazy[node] + v) % MOD;
    }
}