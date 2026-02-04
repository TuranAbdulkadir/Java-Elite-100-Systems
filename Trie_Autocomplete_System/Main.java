package Trie_Autocomplete_System;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("application");
        trie.insert("bat");
        
        System.out.println("[TRIE] inserted: apple, app, application, bat");
        System.out.println("Search 'app': " + trie.search("app"));
        System.out.println("Starts with 'app': " + trie.startsWith("app"));
        System.out.println("Starts with 'ban': " + trie.startsWith("ban"));
    }
}

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord = false;
}

class Trie {
    private TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode current = root;
        for (char l : word.toCharArray()) {
            current = current.children.computeIfAbsent(l, c -> new TrieNode());
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = getNode(word);
        return node != null && node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        return getNode(prefix) != null;
    }

    private TrieNode getNode(String word) {
        TrieNode current = root;
        for (char l : word.toCharArray()) {
            current = current.children.get(l);
            if (current == null) return null;
        }
        return current;
    }
}