class Solution {

    static boolean isVowel(char ch){

        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
            return true;
        }
        return false;
    }

    public int maxVowels(String s, int k) {

        char[] arr = s.toCharArray();
        int n=arr.length;

        int vowel=0;
        int maxVowel=0;
        
        int l=0;
        int r=0;

        while(r<n){
            if(isVowel(arr[r])){
                vowel++;
            }

            if(r-l+1 == k){
                maxVowel=Math.max(vowel,maxVowel);

                if (isVowel(arr[l])) {
                    vowel--;
                }

                l++;
            }
                r++;
            }
    return maxVowel;
    }
}