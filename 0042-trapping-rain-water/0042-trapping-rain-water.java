class Solution {

    static int[] prefixMax(int[] arr){ //to find leftmax
        int[] prefixMax=new int[arr.length];

        prefixMax[0]=arr[0];

        for(int i=1;i<arr.length;i++){
            prefixMax[i]=Math.max(prefixMax[i-1],arr[i]);
        }
        return prefixMax;
    }

    static int[] suffixMax(int[] arr){ //to find rightmax
        int[] suffixMax = new int[arr.length];
        int n=arr.length;

        suffixMax[n-1]=arr[n-1];

        for(int i=n-2;i>=0;i--){
            suffixMax[i]=Math.max(suffixMax[i+1],arr[i]);
        }
    return suffixMax;
    }
    public int trap(int[] height) {
        
        int n=height.length;
        int total=0;
        int[] leftMax = prefixMax(height);
        int[] rightMax = suffixMax(height);

        for(int i=0;i<n;i++){
            if(height[i]<leftMax[i] && height[i]<rightMax[i]){
                total+=(Math.min(leftMax[i],rightMax[i]))-height[i];
            }
        }
        return total;
    }
}