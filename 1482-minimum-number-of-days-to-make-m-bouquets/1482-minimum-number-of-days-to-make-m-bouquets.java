class Solution {

    static int max(int[] arr){

        int n=arr.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
    return max;
    } 

    static int min(int[] arr){

        int n=arr.length;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i]<min){
                min=arr[i];
            }
        }
    return min;
    }

    static boolean possible(int[] arr,int m,int k, int day){
        //possible range of days: [min value,max value]

        int consecutive=0;
        int bouquets=0;
        int n=arr.length;
            for(int i=0;i<n;i++){
                if(arr[i]<=day){
                    consecutive++;
                }
                else{
                    bouquets+=consecutive/k; //(no of bouquets)
                    consecutive=0;
                }
            }
            bouquets+=consecutive/k; //leftover values
        if(bouquets>=m){
        return true;
        }
        return false;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        
        int n=bloomDay.length;
        long flowers=(long)m*k;
        int low=min(bloomDay);
        int high=max(bloomDay);
        int ans=high;

        if(n<flowers){
            return -1;
        }

        while(low<=high){

            int mid=low+(high-low)/2;
            if(possible(bloomDay,m,k,mid)==true){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
    return ans; //possible ans will be pointed by low only
    }
}