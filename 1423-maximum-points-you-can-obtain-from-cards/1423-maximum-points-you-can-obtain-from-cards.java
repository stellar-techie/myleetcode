class Solution {

    public int maxScore(int[] cardPoints, int k) {
        
        int n=cardPoints.length;
        int k1=(n-k);
        int l=0;
        int r=k1-1;
        int sum=0;
        int arraySum=0;
        int minSum=0;

        //sum of total array....
        for(int i=0;i<n;i++){
            arraySum+=cardPoints[i];
        }

        if(k==n){
            return arraySum;
        }

        //finding the minimum sum to leave behind
        for(int j=l;j<=r;j++){
            sum+=cardPoints[j];
        }
        minSum=sum;

        while(r<n-1){
            sum=sum-cardPoints[l];
            l++;
            r++;
            sum+=cardPoints[r];
            minSum=Math.min(minSum,sum);
        }
    return arraySum-minSum;
    }
}