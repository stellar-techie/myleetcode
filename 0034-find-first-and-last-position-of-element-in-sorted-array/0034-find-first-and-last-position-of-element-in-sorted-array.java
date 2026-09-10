class Solution {

    public int[] searchRange(int[] nums, int target) {
        
        int n=nums.length;
        int low=0;
        int high=n-1;
        int[] ans = new int[2]; //starting and ending position only
        Arrays.fill(ans,-1);

        while(low<=high){

            int mid=low+(high-low)/2;

            if(nums[mid]==target){
                ans[0]=mid;
                high=mid-1; //check for another occurence on the left
            }
            else if(nums[mid]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }

        }

        low=0; //for last occurence
        high=n-1;

        while(low<=high){

            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                ans[1]=mid;
                low=mid+1; //checking for another in the right
            }
            else if(nums[mid]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
    return ans;
    }
}