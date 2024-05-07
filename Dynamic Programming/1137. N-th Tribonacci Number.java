class Solution {
    public int tribonacci(int n) {
        if(n <1)
        return 0;
        if(n ==1 || n == 2 )
        return 1;

        int a=0;
        int b = 1;
        int c = 1;
        int d =0;
        for(int i =3;i<=n;i++)
        {
            d = a + b + c;
            int temp = d;
            a=b;
            b=c;
            c= temp;
        }

        return d;
    }
}
