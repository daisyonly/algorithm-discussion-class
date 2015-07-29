package july_1;

public class WordDictionary {
	class TrieNode{
		boolean isword;
		TrieNode node[];
		TrieNode() {
			isword=false;
			node=new TrieNode[26];
		}
	}
	private TrieNode root;
	public WordDictionary(){
		root= new TrieNode();
	}

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode curNode=root;
        for(int i=0;i<word.length();i++){
        	int index=word.charAt(i)-'a';
        	if(curNode.node[index]==null){
        		curNode.node[index]=new TrieNode();
        	}
        	curNode=curNode.node[index];
        }
        curNode.isword=true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {		
    	TrieNode cuNode=root;
    	char c[]=word.toCharArray();   	
    	return search(c,0,cuNode);
        
    }

	private boolean search(char[] c, int index, TrieNode cuNode) {
		// TODO Auto-generated method stub
		if(cuNode==null) return false;
		if(index==c.length){
			return cuNode.isword;
		}
		if(c[index]=='.'){
			for(int i=0;i<26;i++){
				boolean flag=search(c, index+1, cuNode.node[i]);
				if(flag) return true;
			}
		}else{
			if(cuNode.node[c[index]-'a']!=null){
				boolean flag=search(c, index+1, cuNode.node[c[index]-'a']);
				if(flag) return true;
			} 
		}
		return false;
	}
	public static void main(String[] args) {
		WordDictionary wordDictionary = new WordDictionary();
		//wordDictionary.addWord("word");
		//boolean flag=wordDictionary.search("wor.");
		//System.out.println(flag);
		wordDictionary.addWord("a");
		wordDictionary.addWord("a");
		wordDictionary.search(".");
		wordDictionary.search("a");
		wordDictionary.search("aa");
		wordDictionary.search("a");
		wordDictionary.search(".a");
		wordDictionary.search("a.");
		
	}
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");