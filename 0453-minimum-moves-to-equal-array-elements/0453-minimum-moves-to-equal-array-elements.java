class Solution {
    public int minMoves(int[] nums) {
        int n=nums.length;
        
        int smallest=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(nums[i]<smallest){
                smallest=nums[i];
            }
        }

        int sum=0;
        for(int i=0;i<n;i++){
            int rem=nums[i]-smallest;
            sum+=rem;
        }
    return sum;
    }
}