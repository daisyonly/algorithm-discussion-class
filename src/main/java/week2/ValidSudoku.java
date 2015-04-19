package week2;

public class ValidSudoku {
	
	private boolean check(boolean[] var, char c){
		if(c == '.') return true;
		if(var[c-'1']){
			return false;
		}
		var[c-'1'] = true;
		return true;
	}
	
	public boolean isValidSudoku(char[][] board) {
		boolean[] rowCheck;
		boolean[] columnCheck;
		boolean[] blockCheck;		
		for(int i=0; i<9; i++){
			rowCheck = new boolean[10];
			columnCheck = new boolean[10];
			blockCheck = new boolean[10];
			for(int j=0; j<9; j++){
				if(check(rowCheck,board[i][j])&&
						check(columnCheck,board[j][i])&&
							check(blockCheck,board[i/3*3+j/3][(i%3)*3+(j%3)])){
					continue;					
				}else{
					return false;
				}
			}			
		}		
		return true;       
    }
	
	public static void main(String[] args) {
		ValidSudoku cSudoku = new ValidSudoku();
		char[][] board = {{'.','8','7','6','5','4','3','2','1'},
				{'2','.','.','.','.','.','.','.','.'},
				{'3','.','.','.','.','.','.','.','.'},
				{'4','.','.','.','.','.','.','.','.'},
				{'5','.','.','.','.','.','.','.','.'},
				{'6','.','.','.','.','.','.','.','.'},
				{'7','.','.','.','.','.','.','.','.'},
				{'8','.','.','.','.','.','.','.','.'},
				{'9','.','.','.','.','.','.','.','.'}
				};

		boolean tmp = cSudoku.isValidSudoku(board);
		System.out.println(tmp);
	}

}
