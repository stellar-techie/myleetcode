class Solution {

    static double power(double x, long n){

            if(n==0){
                return 1;
            }
            
            double half = power(x,n/2);

            if(n%2==1){
                return x*half*half;
            }

            return half*half;
            
    }

    public double myPow(double x, int n) {
        
            long N=n; //if n is neg max value then its +ve will overflow int
            if(n<0){
                x=1/x;
                N=-N; 
            }
            return power(x,N);     
    }
}