public class Main {
    static class Solution {
        public long solution(int cap, int n, int[] deliveries, int[] pickups) {
            int delivery_last = n - 1, pickup_last = n - 1;
            long answer = 0;
            while (delivery_last >= 0 || pickup_last >= 0) {
                while (delivery_last >= 0 && deliveries[delivery_last] == 0)
                    --delivery_last;
                while (pickup_last >= 0 && pickups[pickup_last] == 0)
                    --pickup_last;
                answer += 2 * (1 + Math.max(delivery_last, pickup_last));
                int delivery_cap = cap;
                while (delivery_last >= 0 && delivery_cap > 0) {
                    int temp = Math.min(delivery_cap, deliveries[delivery_last]);
                    delivery_cap -= temp;
                    deliveries[delivery_last] -= temp;
                    if (deliveries[delivery_last] == 0) --delivery_last;
                }
                int pickup_cap = cap;
                while (pickup_last >= 0 && pickup_cap > 0) {
                    int temp = Math.min(pickup_cap, pickups[pickup_last]);
                    pickup_cap -= temp;
                    pickups[pickup_last] -= temp;
                    if (pickups[pickup_last] == 0) --pickup_last;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        var sol = new Solution();

        int[] deliveries = new int[] { 1, 0, 3, 1, 2 };
        int[] pickups = new int[] { 0, 3, 0, 4, 0 };
        System.out.println(sol.solution(4, 5, deliveries, pickups));

        deliveries = new int[] { 1, 0, 2, 0, 1, 0, 2 };
        pickups = new int[] { 0, 2, 0, 1, 0, 2, 0 };
        System.out.println(sol.solution(2, 7, deliveries, pickups));
    }

}