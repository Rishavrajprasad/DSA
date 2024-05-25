class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        String curr = "";
        HashSet<String> word = new HashSet<>();
        for(String words: wordDict)
        {
            word.add(words);
        }
        List<String> res = new ArrayList<>();
        solve(0,curr,s, res, word);
        return res;
   }
   private void solve(int i, String curr, String s, List<String> res, HashSet<String> word)
   {
    if(i>=s.length())
    {
        res.add(curr);
        return;
    }


    for(int j =i; j<s.length();j++)
    {
        String temp = s.substring(i,j+1);
        if(word.contains(temp))
        {
            String tempSentance = curr;
            if(!curr.isEmpty())
            {
                curr+=" ";
            }
            curr +=temp;
            solve(j+1,curr,s,res,word);
            curr = tempSentance;
        }
    }
   }
}
