class Solution {

    public List<List<String>> findLadders(String beginWord,
                                          String endWord,
                                          List<String> wordList) {

        List<List<String>> result = new ArrayList<>();

        Set<String> dict = new HashSet<>(wordList);

        if (!dict.contains(endWord)) {
            return result;
        }

        Map<String, List<String>> parents = new HashMap<>();

        Set<String> currentLevel = new HashSet<>();
        currentLevel.add(beginWord);

        boolean found = false;

        while (!currentLevel.isEmpty() && !found) {

            dict.removeAll(currentLevel);

            Set<String> nextLevel = new HashSet<>();

            for (String word : currentLevel) {

                char[] arr = word.toCharArray();

                for (int i = 0; i < arr.length; i++) {

                    char original = arr[i];

                    for (char c = 'a'; c <= 'z'; c++) {

                        arr[i] = c;

                        String nextWord = new String(arr);

                        if (!dict.contains(nextWord)) {
                            continue;
                        }

                        nextLevel.add(nextWord);

                        parents
                            .computeIfAbsent(nextWord,
                                             k -> new ArrayList<>())
                            .add(word);

                        if (nextWord.equals(endWord)) {
                            found = true;
                        }
                    }

                    arr[i] = original;
                }
            }

            currentLevel = nextLevel;
        }

        if (!found) {
            return result;
        }

        List<String> path = new ArrayList<>();
        path.add(endWord);

        dfs(endWord,
            beginWord,
            parents,
            path,
            result);

        return result;
    }

    private void dfs(String word,
                     String beginWord,
                     Map<String, List<String>> parents,
                     List<String> path,
                     List<List<String>> result) {

        if (word.equals(beginWord)) {

            List<String> temp = new ArrayList<>(path);

            Collections.reverse(temp);

            result.add(temp);

            return;
        }

        if (!parents.containsKey(word)) {
            return;
        }

        for (String parent : parents.get(word)) {

            path.add(parent);

            dfs(parent,
                beginWord,
                parents,
                path,
                result);

            path.remove(path.size() - 1);
        }
    }
}