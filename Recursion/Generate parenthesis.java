class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        String curr ="";
        solve(curr,0,0,n); // starting mein open aur close dono 0 hoga
        return result;
    }
    private void solve(String curr, int open, int close, int n)
    {
        if(curr.length() == 2*n)
        {
            result.add(curr);
            return;
        }

        if(open<n){ // Add open parenthesis if we can
            curr+="(";
            solve(curr,open+1,close,n);
            curr = curr.substring(0,curr.length()-1);
        }
        if(close<open){ // Add close parenthesis if we can
            curr+=")";
            solve(curr,open,close+1,n);
            curr = curr.substring(0,curr.length()-1);
        }
    }
}
