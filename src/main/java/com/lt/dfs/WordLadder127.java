package com.lt.dfs;

import java.util.*;

public class WordLadder127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);//save time
        //无向图最短路径，最好用BFS而不是DFS，同时使用标记位，防止死循环
        if (wordList == null || wordList.size() == 0 || !set.contains(endWord)) return 0;

        Map<String, Integer> visitedMap = new HashMap<>();
        Deque<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visitedMap.put(beginWord, 1);

        while (!queue.isEmpty()) {
            String word = queue.poll();
            int path = visitedMap.get(word);

            for (int i = 0; i < word.length(); i++) {
                char[] chars = word.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    chars[i] = j;
                    String sub = String.valueOf(chars);
                    if (sub.equals(endWord)) {
                        return path + 1;
                    }
                    if (set.contains(sub) && !visitedMap.containsKey(sub)) {
                        visitedMap.put(sub, path + 1);
                        queue.offer(sub);
                    }
                }
            }
        }
        return 0;
    }
}
