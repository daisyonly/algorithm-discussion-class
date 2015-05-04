package fre4;

//https://leetcode.com/problems/word-search/
public class WordSearch {
	int dx[] = {-1,0,1,0};
	int dy[] = {0,1,0,-1};
	
	public boolean exist(char[][] board, String word) {
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){		
				if(board[i][j]==word.charAt(0)){
					StringBuilder tmpBuilder = new StringBuilder();
					char tmpC = board[i][j];
					tmpBuilder.append(board[i][j]);
					board[i][j] ='#';
					if(findWord(board, word, tmpBuilder,i, j))
						return true;
					board[i][j]=tmpC;
				}
			}
		}
		return false;
        
    }

	private boolean findWord(char[][] board, String word, StringBuilder tmp,int x, int y) {
		// TODO Auto-generated method stub
		if(tmp.length() == word.length()){
			return true;
		}
		for(int i=0;i<4;i++){
			int curx = x+dx[i];
			int cury = y+dy[i];
			//System.out.println(curx+"   "+ cury +"  "+tmp.length() );
			if(check(board,curx,cury) && board[curx][cury] == word.charAt(tmp.length())){
				//System.out.println(board[curx][cury]);
				char tmpC = board[curx][cury];
				board[curx][cury] ='#';
				tmp.append(tmpC);
				if(findWord(board, word, tmp, curx, cury)) return true;
				board[curx][cury] = tmpC;
				tmp.deleteCharAt(tmp.length()-1);
			}
		}
		return false;
	}

	private boolean check(char[][] board, int curx, int cury) {
		// TODO Auto-generated method stub
		if(curx>=0 && cury>=0 && curx<board.length && cury<board[0].length) return true;
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordSearch a = new WordSearch();
		/*
		char board[][]={
				{'A','B','C','E'},
		                {'S','F','C','S'},{'A','D','E','E'}};*/
		char board[][]={{'a','a'}};
		String word = "aaa";
		System.out.println(a.exist(board, word));

	}

}
