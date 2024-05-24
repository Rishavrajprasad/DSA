class Solution {
    int n;
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        n = s.length();
        List<String> curr = new ArrayList<>();
        backtrack(s,0,curr,result);
        return result;
    }
    private void backtrack(String s, int idx, List<String> curr, List<List<String>> result)
    {
        if(idx == n)
        {
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i = idx; i<n;i++)
        {
            if(isPalindrome(s,idx,i))
            {
                curr.add(s.substring(idx, i+1));
                backtrack(s,i+1,curr,result);
                curr.remove(curr.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s, int l, int r)
    {
        while(l<r)
        {
            if(s.charAt(l) != s.charAt(r))
            {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
