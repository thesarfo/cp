class Solution{
    static int evenlyDivides(int N){
        int count=0;
        int temp=N;

        while(N>0)
        {
            int rem= N%10;
            if(rem>0 && temp%rem==0 )
                count++;
            N=N/10;
        }

        return count;
    }
}