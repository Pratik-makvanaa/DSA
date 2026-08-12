class Solution {
    public int searchInsert(int[] nums, int target) {
        int low= 0;
        int high = nums.length-1;
        int answer = nums.length;

        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] >= target){
                high = mid - 1;
                answer = mid;
                
            }
            else{
                low = mid + 1;
            }
        }
        return answer;
    }
}