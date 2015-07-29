package july_1;

class TrieNode {
    // Initialize your data structure here.
	TrieNode node[];
	boolean isword;
    public TrieNode() {
    	node=new TrieNode[26];
    	isword=false;     
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
    	TrieNode curNode=root;
        for(int i=0;i<word.length();i++){
        	int tmp=word.charAt(i)-'a';
        	if(curNode.node[tmp]==null){
        		curNode.node[tmp]=new TrieNode();
        	}
        	curNode=curNode.node[tmp];
        }
        curNode.isword=true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
    	TrieNode curNode=root;
        for(int i=0;i<word.length();i++){
        	int tmp=word.charAt(i)-'a';
        	if(curNode.node[tmp]!=null){
        		curNode=curNode.node[tmp];
        	}else {
				return false;
			}
        }
    	return curNode.isword;
        
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	TrieNode curNode=root;
        for(int i=0;i<prefix.length();i++){
        	int tmp=prefix.charAt(i)-'a';
        	if(curNode.node[tmp]!=null){
        		curNode=curNode.node[tmp];
        	}else {
				return false;
			}
        }
    	return true;       
    }
    public static void main(String[] args) {
    	Trie trie = new Trie();
    	trie.insert("somestring");
    	System.out.print(trie.startsWith("somestri"));
		
	}
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");

