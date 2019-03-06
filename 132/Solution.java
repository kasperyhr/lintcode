public class Solution {
    TrieNode root = new TrieNode();
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public List<String> wordSearchII(char[][] board, List<String> words) {
        // write your code here
        Set<String> ret = new HashSet<String>();
        
        for(String word: words){
            root.insert(word);
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                search(board, i, j, ret, root);
            }
        }
        return new ArrayList<String>(ret);
    }
    
    public void search(char[][] board, int i, int j, Set<String> ret, TrieNode root){
        int[] x = {0,0,1,-1};
        int[] y = {1,-1,0,0};
        if(i < 0 || i >= board.length) return;
        if(j < 0 || j >= board[0].length) return;
        if(!root.children.containsKey(board[i][j])) return;
        
        TrieNode child = root.children.get(board[i][j]);
        if(child.word != null) ret.add(child.word);
        char tmp = board[i][j];
        board[i][j] = 0;
        
        for(int k = 0; k < 4; k++){
            int i1 = i + x[k];
            int j1 = j + y[k];
            search(board, i1, j1, ret, child);
        }
        board[i][j] = tmp;
        
    }
}

class TrieNode{
    Map<Character, TrieNode> children;
    String word;
    
    public TrieNode(){
        children = new HashMap<Character, TrieNode>();
        word = null;
    }
    
    public void insert(String word){
        TrieNode p = this;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!p.children.containsKey(c)){
                p.children.put(c, new TrieNode());
            }
            p = p.children.get(c);
        }
        p.word = word;
    }
}