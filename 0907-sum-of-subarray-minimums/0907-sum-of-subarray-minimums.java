class Solution {

    static int[] findNse(int[] arr){ //keeping track of indices only

        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                nse[i]=n;
            }
            else{
                nse[i]=stack.peek();
            }

            stack.push(i);
        }
        return nse;
    }

    static int[] findPsee(int[] arr){

        int n=arr.length;
        int[] psee = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                psee[i]=-1;
            }
            else{
                psee[i]=stack.peek();
            }

            stack.push(i);
        }
        return psee;
    }

    public int sumSubarrayMins(int[] arr) {
        
        int[] nse = findNse(arr);
        int[] psee = findPsee(arr);
        long total=0;
        long mod=10_00_00_00_07;

        for(int i=0;i<arr.length;i++){
            long left = i-psee[i];
            long right = nse[i]-i;
            long subarray = ((left*right)*arr[i])%mod;
            total = (total+subarray)%mod;
        }
    return (int)total;
    }
}