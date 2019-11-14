package tictactoe;

import javax.swing.JButton;
/**
 * Đối tượng Button đại diện cho mỗi ô trong bảng game, trong đó mỗi nút chứa 1 kí tự (token) đặc trưng.
 * @author Nhóm 15 
 * STT 		Tên 						MSSV 
 * 1 		Nguyễn Lê Nhật Quang 		16026501 
 * 2 		Võ Tấn Lực					16021821
 * 3 		Doãn Trần Tuấn Đạt 			16035741
 */
public class Button extends JButton {

	private static final long serialVersionUID = 1L;
	private char token;

	public Button() {
		this.token = ' ';
	}

	public Button(char token) {
		this.token = token;
	}

	public char getToken() {
		return token;
	}

	public void setToken(char token) {
		this.token = token;
	}

}
