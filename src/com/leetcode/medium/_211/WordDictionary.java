package com.leetcode.medium._211;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Design a data structure that supports the following two operations:
 *
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 *
 * Example:
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 *
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 *
 * @author ZhouXu
 * @version V1.0 2018-10-15
 */
public class WordDictionary {
    // class Trie {
    //     private Trie[] children;
    //     private boolean isWord;
    //     public Trie() {
    //         children = new Trie[26];
    //         isWord = false;
    //     }
    // }
    //
    // private Trie root;
    //
    // /** Initialize your data structure here. */
    // public WordDictionary() {
    //     root = new Trie();
    // }
    //
    // /** Adds a word into the data structure. */
    // public void addWord(String word) {
    //     char[] chars = word.toCharArray();
    //     Trie p = root;
    //     for (int i = 0; i < chars.length; i++) {
    //         int index = chars[i] - 'a';
    //         if (p.children[index] == null) {
    //             p.children[index] = new Trie();
    //         }
    //         p = p.children[index];
    //     }
    //     p.isWord = true;
    // }
    //
    // /**
    //  * Returns if the word is in the data structure.
    //  * A word could contain the dot character '.' to represent any one letter.
    //  */
    // public boolean search(String word) {
    //     char[] chars = word.toCharArray();
    //     Trie p = root;
    //     return find(chars, 0, root);
    // }
    //
    // private boolean find (char[] chars, int pos, Trie p) {
    //     if (pos == chars.length) return p.isWord;
    //     if (chars[pos] == '.') {
    //         for (int i = 0; i < 26; i++) {
    //             if (p.children[i] != null
    //                     && find(chars, pos + 1, p.children[i]))
    //                 return true;
    //         }
    //     } else {
    //         return p.children[chars[pos] - 'a'] != null
    //                 && find(chars, pos + 1, p.children[chars[pos] - 'a']);
    //     }
    //     return false;
    // }

    Map<Integer, List<String>> map = new HashMap<>();

    public void addWord(String word) {
        int index = word.length();
        if (!map.containsKey(index)) {
            List<String> list = new ArrayList<>();
            list.add(word);
            map.put(index, list);
        } else {
            map.get(index).add(word);
        }
    }

    public boolean search(String word) {
        int index = word.length();
        if (!map.containsKey(index)) return false;
        List<String> list = map.get(index);
        for (String s : list) {
            if (isSame(s, word)) return true;
        }
        return false;
    }

    public boolean isSame(String s, String word) {
        for (int i = 0; i < s.length(); i++) {
            if (word.charAt(i) != '.'
                    && s.charAt(i) != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) { // unit test
        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
        System.out.println(obj.search("pad"));
        System.out.println(obj.search("bad"));
        System.out.println(obj.search(".ad"));
        System.out.println(obj.search("b.."));
    }
}
