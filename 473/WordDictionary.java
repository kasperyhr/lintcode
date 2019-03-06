public class WordDictionary {
    TrieNode root = new TrieNode();
    
    /*
     * @param word: Adds a word into the data structure.
     * @return: nothing
     */
    public void addWord(String word) {
        // write your code here
        TrieNode p = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            int val = (int)(c - 'a');
            if(p.children[val] == null){
                p.children[val] = new TrieNode();
            }
            p = p.children[val];
        }
        p.hasWord = true;
    }

    /*
     * @param word: A word could contain the dot character '.' to represent any one letter.
     * @return: if the word is in the data structure.
     */
    public boolean search(String word) {
        // write your code here
        return find(word, 0, root);
    }
    
    private boolean find(String word, int idx, TrieNode curr){
        if(idx == word.length()){
            return curr.hasWord;
        } 
        char c = word.charAt(idx);
        if(c == '.'){
            boolean ret = false;
            for(int i = 0; i < 26 && (!ret); i++){
                if(curr.children[i] != null){
                    ret = find(word, idx + 1, curr.children[i]);
                }
            }
            return ret;
        } else {
            int v = (int)(c - 'a');
            if(curr.children[v] == null) return false;
            return find(word, idx + 1, curr.children[v]);
        }
    }
}

class TrieNode{
    TrieNode[] children;
    boolean hasWord;
    
    public TrieNode(){
        children = new TrieNode[26];
        for(int i = 0; i < 26; i++){
            children[i] = null;
        }
    }
}