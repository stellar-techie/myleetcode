class Solution {

    public int longestOnes(int[] nums, int k) {
        
        int n=nums.length;
        int l=0;
        int r=0;

        int zeroes=0;
        int count=0;
        int maxCount=0;

        while(r<n){

            if(nums[r]==0){
                zeroes+=1;
                if(zeroes<=k){
                    count+=1;
                    maxCount = Math.max(count,maxCount);
                    r++;
                }
                else{
                    maxCount = Math.max(count,maxCount);
                    l++;
                    r=l;
                    count=0;
                    zeroes=0;
                }
            }
            else{
                count+=1;
                maxCount = Math.max(count,maxCount);
                r++;
            }
        }
    return maxCount;
    }
}