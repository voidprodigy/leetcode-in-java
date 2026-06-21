class Solution {
    public int maxPoints(int[][] points) {
        
        int p = points.length;
        if ( p  <= 2) {
            return p;
        }
        int result = 0;
        for (int s = 0; s < p; s++) {

            HashMap<String, Integer> map = new HashMap<>();
            int max = 0;

            for (int j = s + 1; j < p; j++) {
                int dx = points[j][0] - points [s][0];
                int dy = points[j][1] - points[s][1];

                int g = gcd(dx, dy);

                dx /= g;
                dy /= g;

                // normalize sign
                if (dx == 0) {
                    dy = 1;
                } else if (dy == 0) {
                    dx = 1;
                } else if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                }


                
                String slope = dy + "/" +dx;
                map.put(slope, map.getOrDefault(slope, 0) + 1);

                max = Math.max(max, map.get(slope));
            }
            result = Math.max(result, max + 1);
        }
        return result;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return gcd(b, a % b);
    }

}