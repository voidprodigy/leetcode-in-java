class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        // sorting the array first 
        Arrays.sort(arr);

        // for first element should be 1 
        arr[0] = 1;

        // traverse the array
        for (int i = 1; i < arr.length; i++) {

            // current element cannot be grater than previous +1 
            // if it is larger ,decrease it 
            arr[i] = Math.min(arr[i] ,arr[i - 1] + 1 ); 
        }
        //last element will be tge maximum possible values 
        return arr[arr.length - 1];
        
    }
}