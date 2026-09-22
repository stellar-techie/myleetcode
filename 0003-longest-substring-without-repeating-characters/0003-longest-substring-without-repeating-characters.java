class Solution {

    public int lengthOfLongestSubstring(String s) {

        int[] hash=new int[256]; //ascii char a-z and A-Z

        for(int i=0;i<256;i++){
            hash[i]=-1;
        }

        int l=0;
        int r=0;
        int len=0;
        int maxLen=0;

        while(r<s.length()){

            char ch=s.charAt(r);

            //check if already present n inside the current window
            if(hash[ch]!=-1 && hash[ch]>=l){
                l=hash[ch]+1;
            }

            len=r-l+1;
            maxLen=Math.max(len,maxLen);
            hash[ch]=r; //latest index of char
            r++;
        }
    return maxLen;
    }
}