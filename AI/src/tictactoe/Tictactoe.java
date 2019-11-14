package tictactoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Lớp Tictactoe là chương trình chính chạy thuật toán game, giao diện, xử lí sự kiện
 * @author Nhóm 15 
 * STT 		Tên 						MSSV 
 * 1 		Nguyễn Lê Nhật Quang 		16026501 
 * 2 		Võ Tấn Lực					16021821
 * 3 		Doãn Trần Tuấn Đạt 			16035741
 */
public class Tictactoe extends JFrame implements MouseListener, ActionListener {
	
	private static final long serialVersionUID = 1L;
	/**
	 * mảng 2 chiều các button
	 */
	private List<List<Button>> listParent = null;
	private List<Button> listChild1, listChild2, listChild3 = null;
	/**
	 * 2 icon X và O 
	 */
	private final ImageIcon iconX = new ImageIcon("pic/x.png");
	private final ImageIcon iconO = new ImageIcon("pic/o.png");
	/**
	 * turn là biến đếm số button đã đánh
	 * yourScore: số lần bạn thắng
	 * aiScore : số lần máy thắng
	 */
	private int turn, yourScore, aiScore;
	/**
	 * whose Turn là biến báo đến lượt ai đi.
	 */
	private char whoseTurn;

	private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
	private JButton btnRestart, btnThanhVien;
	private JLabel lblYourScore, lblAIScore, lblScore1, lblScore2, lblResult;

	/**
	 * Contructor giao diện trò chơi
	 */
	public Tictactoe() {
		setSize(500, 650);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Game Tic - Tac - Toe");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		listParent = new ArrayList<List<Button>>();
		listChild1 = new ArrayList<Button>();
		listChild2 = new ArrayList<Button>();
		listChild3 = new ArrayList<Button>();
		whoseTurn = 'x';
		turn = 0;

		Font font = new Font("serif", Font.PLAIN, 30);

		// ------------------------------------------------------------------------
		JPanel pNorth = new JPanel();

		pNorth.add(lblScore1 = new JLabel("Bạn: "));
		pNorth.add(lblYourScore = new JLabel("0"));
		pNorth.add(Box.createHorizontalStrut(30));
		pNorth.add(btnRestart = new JButton());
		pNorth.add(Box.createHorizontalStrut(30));
		pNorth.add(lblScore2 = new JLabel("Máy: "));
		pNorth.add(lblAIScore = new JLabel("0"));

		lblScore1.setFont(font);
		lblScore2.setFont(font);
		lblYourScore.setFont(font);
		lblAIScore.setFont(font);

		btnRestart.setIcon(new ImageIcon("pic/restart.png"));
		setJButton(btnRestart);

		add(pNorth, BorderLayout.NORTH);

		// ------------------------------------------------------------------------
		JPanel pCenter = new JPanel();
		pCenter.setLayout(new GridLayout(3, 3));

		pCenter.add(btn1 = new Button());
		pCenter.add(btn2 = new Button());
		pCenter.add(btn3 = new Button());
		listChild1.add(btn1);
		listChild1.add(btn2);
		listChild1.add(btn3);

		pCenter.add(btn4 = new Button());
		pCenter.add(btn5 = new Button());
		pCenter.add(btn6 = new Button());
		listChild2.add(btn4);
		listChild2.add(btn5);
		listChild2.add(btn6);

		pCenter.add(btn7 = new Button());
		pCenter.add(btn8 = new Button());
		pCenter.add(btn9 = new Button());
		listChild3.add(btn7);
		listChild3.add(btn8);
		listChild3.add(btn9);

		listParent.add(listChild1);
		listParent.add(listChild2);
		listParent.add(listChild3);

		setButton();
		add(pCenter, BorderLayout.CENTER);

		// ------------------------------------------------------------------------
		JPanel pSouth = new JPanel();
		pSouth.setLayout(new FlowLayout(FlowLayout.LEFT));

		pSouth.add(lblResult = new JLabel("*"));
		pSouth.add(Box.createHorizontalStrut(330));
		pSouth.add(btnThanhVien = new JButton("Thành viên nhóm"));
		btnThanhVien.setFocusPainted(false);
		lblResult.setFont(font);
		lblResult.setForeground(Color.RED);

		add(pSouth, BorderLayout.SOUTH);

		// ------------------------------------------------------------------------
		btnRestart.addMouseListener(this);

		btnThanhVien.addActionListener(this);
		btnRestart.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		btn8.addActionListener(this);
		btn9.addActionListener(this);
	}
	/**
	 * hàm làm đẹp các button
	 * @param jb: 1 button truyền vào
	 */
	private void setJButton(JButton jb) {
		jb.setOpaque(false);
		jb.setContentAreaFilled(false);
		jb.setFocusPainted(false);
		jb.setBorderPainted(false);
		jb.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
	}
	/**
	 * Hàm làm đẹp button
	 */
	private void setButton() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				listParent.get(i).get(j).setContentAreaFilled(false);
				listParent.get(i).get(j).setFocusPainted(false);
			}
		}
	}
	/**
	 * Hàm khóa và mở các button
	 * @param bool:  truyền vào true hoặc false
	 */
	private void KhoaVaMo(boolean bool) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				listParent.get(i).get(j).setEnabled(bool);
			}
		}
	}
	/**
	 * Kiểm tra bảng chơi có đầy chưa
	 * @return true or false
	 */
	private boolean isFull() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (listParent.get(i).get(j).getToken() == ' ')
					return false;
		return true;
	}
	/**
	 * Hàm kiểm tra các trường hợp thắng. 1 hàng ngang, 1 hàng dọc hoặc 1 đường chéo đều có cùng 1 kí tự token
	 * @param token: kí tự x hoặc o
	 * @return true or false
	 */
	private boolean isWon(char token) {
		for (int i = 0; i < 3; i++)
			if (listParent.get(i).get(0).getToken() == token && listParent.get(i).get(1).getToken() == token
					&& listParent.get(i).get(2).getToken() == token) {
				return true;
			}
		for (int i = 0; i < 3; i++)
			if (listParent.get(0).get(i).getToken() == token && listParent.get(1).get(i).getToken() == token
					&& listParent.get(2).get(i).getToken() == token) {
				return true;
			}
		if (listParent.get(0).get(0).getToken() == token && listParent.get(1).get(1).getToken() == token
				&& listParent.get(2).get(2).getToken() == token) {
			return true;
		}
		if (listParent.get(0).get(2).getToken() == token && listParent.get(1).get(1).getToken() == token
				&& listParent.get(2).get(0).getToken() == token) {
			return true;
		}
		return false;
	}
	/**
	 * Hàm kiểm tra kết thúc game
	 */
	private void checkEndGame() {
		if (isWon('x')) {
			lblResult.setText("X thắng");
			KhoaVaMo(false);
			yourScore++;
			lblYourScore.setText(Integer.toString(yourScore));
		} else if (isWon('o')) {
			lblResult.setText("O thắng");
			KhoaVaMo(false);
			aiScore++;
			lblAIScore.setText(Integer.toString(aiScore));
		} else if (turn == 9 && isFull()) {
			lblResult.setText("Game hòa");
			KhoaVaMo(false);
		}
	}
	/**
	 * hàm đánh dấu 1 nút để đánh
	 * @param button
	 */
	private void danhDau(Button button) {
		if (whoseTurn == 'x') {
			button.setIcon(iconX);
			button.setToken('x');
			whoseTurn = 'o';
		} else {
			button.setIcon(iconO);
			button.setToken('o');
			whoseTurn = 'x';
		}
	}
	/**
	 * Hàm thuật toán đánh giá minimax
	 * @param list : mảng 2 chiều các button
	 * @param d : độ sâu của cây trò chơi, ưu tiên độ sâu ít
	 * @param isMax: tại 1 thời điểm, nó là Max hay Min
	 * @return best: điểm đánh giá
	 */
	public int minimax(List<List<Button>> list, int d, boolean isMax) {
		if (isWon('x'))
			return 10 + d;
		if (isWon('o'))
			return -10 + d;
		if (isFull())
			return 0;
		if (isMax) {
			int best = -1000;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (list.get(i).get(j).getToken() == ' ') {
						list.get(i).get(j).setToken('x');
						best = Math.max(best, minimax(list, d + 1, !isMax));
						list.get(i).get(j).setToken(' ');
					}
				}
			}
			return best;
		} else {
			int best = 1000;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (list.get(i).get(j).getToken() == ' ') {
						list.get(i).get(j).setToken('o');
						best = Math.min(best, minimax(list, d + 1, !isMax));
						list.get(i).get(j).setToken(' ');
					}
				}
			}

			return best;
		}
	}
	/**
	 * Hàm tìm ô tiếp theo để máy đi dựa trên số điểm mà hàm minimax đánh giá
	 * @param list: mảng 2 chiều truyền vào
	 * @return nước đi tiếp theo của máy 
	 */
	public Move timDuong(List<List<Button>> list) {
		int bestVal = 1000;
		Move move = new Move();
		move.setRow(3);
		move.setCol(3);

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (list.get(i).get(j).getToken() == ' ') {
					list.get(i).get(j).setToken('o');
					int moveVal = minimax(list, 0, true);
					list.get(i).get(j).setToken(' ');
					if (moveVal < bestVal) {
						move.setRow(i);
						move.setCol(j);
						bestVal = moveVal;
					}
				}
			}
		}
		return move;
	}
	/**
	 * Hàm xác định vị trí mà máy sẽ đánh.
	 * @param list
	 */
	public void mayDanh(List<List<Button>> list) {
		Move move = timDuong(list);
		if (!isFull()) {
			danhDau(list.get(move.getRow()).get(move.getCol()));
			turn++;
		}
	}
	/**
	 * Hàm sự kiện của các button
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		if (object.equals(btnRestart)) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					listParent.get(i).get(j).setIcon(null);
					listParent.get(i).get(j).setToken(' ');
					whoseTurn = 'x';
					lblResult.setText("*");
					turn = 0;
				}
			}
			if (!btn1.isEnabled())
				KhoaVaMo(true);
		} else if (object.equals(btn1)) {
			if (btn1.getToken() == ' ') {

				turn++;
				danhDau(btn1);
				mayDanh(listParent);
				checkEndGame();

			}
		} else if (object.equals(btn2)) {
			if (btn2.getToken() == ' ') {

				turn++;
				danhDau(btn2);
				mayDanh(listParent);
				checkEndGame();

			}
		} else if (object.equals(btn3)) {
			if (btn3.getToken() == ' ') {

				turn++;
				danhDau(btn3);
				mayDanh(listParent);
				checkEndGame();

			}
		} else if (object.equals(btn4)) {

			if (btn4.getToken() == ' ') {
				turn++;
				danhDau(btn4);
				mayDanh(listParent);
				checkEndGame();

			}
		} else if (object.equals(btn5)) {
			if (btn5.getToken() == ' ') {

				turn++;
				danhDau(btn5);
				mayDanh(listParent);
				checkEndGame();

			}
		} else if (object.equals(btn6)) {
			if (btn6.getToken() == ' ') {

				turn++;
				danhDau(btn6);
				mayDanh(listParent);
				checkEndGame();

			}
		} else if (object.equals(btn7)) {
			if (btn7.getToken() == ' ') {

				turn++;
				danhDau(btn7);
				mayDanh(listParent);
				checkEndGame();

			}
		} else if (object.equals(btn8)) {
			if (btn8.getToken() == ' ') {

				turn++;
				danhDau(btn8);
				mayDanh(listParent);
				checkEndGame();

			}
		} else if (object.equals(btn9)) {
			if (btn9.getToken() == ' ') {

				turn++;
				danhDau(btn9);
				mayDanh(listParent);
				checkEndGame();

			}
		} else if (object.equals(btnThanhVien)) {

			new FrmThanhVien();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		Object object = e.getSource();
		if (object.equals(btnRestart)) {
			btnRestart.setContentAreaFilled(true);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Object object = e.getSource();
		if (object.equals(btnRestart)) {
			btnRestart.setContentAreaFilled(false);
		}
	}
}
