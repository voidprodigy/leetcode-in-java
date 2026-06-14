class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        ArrayList<int[]> list = new ArrayList<>();

        int k = 0;

        while(k < intervals.length){
            if(intervals[k][1] < newInterval[0]){
                list.add(intervals[k]);
            }
            else if(intervals[k][0] > newInterval[1]){
                break;
            }
            else{
                newInterval[0] = Math.min(newInterval[0], intervals[k][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[k][1]);
            }
            k++;
        }

        list.add(newInterval);

        while(k < intervals.length){
            list.add(intervals[k]);
            k++;
        }

        return list.toArray(new int[list.size()][]);
    }
}