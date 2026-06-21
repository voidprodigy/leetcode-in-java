class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Map<String, List<String>> memo = new HashMap<>();

        return dfs(s, dict, memo);
    }

    private List<String> dfs(String s, Set<String> dict,
                             Map<String, List<String>> memo) {

        if (memo.containsKey(s))
            return memo.get(s);

        List<String> result = new ArrayList<>();

        if (s.length() == 0) {
            result.add("");
            return result;
        }

        for (String word : dict) {
            if (s.startsWith(word)) {

                List<String> suffixWays =
                        dfs(s.substring(word.length()), dict, memo);

                for (String suffix : suffixWays) {
                    if (suffix.isEmpty())
                        result.add(word);
                    else
                        result.add(word + " " + suffix);
                }
            }
        }

        memo.put(s, result);
        return result;
    }
}