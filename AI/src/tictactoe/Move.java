package tictactoe;
/**
 * Đối tượng Move chứa hàng và cột, phục vụ cho việc xác định vị trí ô
 * @author Nhóm 15 
 * STT 		Tên 						MSSV 
 * 1 		Nguyễn Lê Nhật Quang 		16026501 
 * 2 		Võ Tấn Lực					16021821
 * 3 		Doãn Trần Tuấn Đạt 			16035741
 */
public class Move {
	private int row;
	private int col;
	public Move(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}
	public Move() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	@Override
	public String toString() {
		return "Move [row=" + row + ", col=" + col + "]";
	}
	
}
