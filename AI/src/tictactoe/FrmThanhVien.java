package tictactoe;

import java.awt.Font;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 * lớp FrmThanhVien: Giao diện danh sách thành viên nhóm
 * @author Nhóm 15 
 * STT		Tên 						MSSV 
 * 1 		Nguyễn Lê Nhật Quang 		16026501 
 * 2 		Võ Tấn Lực					16021821
 * 3 		Doãn Trần Tuấn Đạt 			16035741
 */
public class FrmThanhVien extends JFrame {

	
	private static final long serialVersionUID = 1L;
	
	private Box b_lbl_Quang;
	private Box b_lbl_Luc;
	private Box b_lbl_Dat;

	public FrmThanhVien() {
		setVisible(true);
		setSize(700, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Thành viên nhóm");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		Font font = new Font("Times New Roman", Font.PLAIN, 30);

		Box b_lbl = Box.createVerticalBox();
		JLabel ten1, mssv1, ten2, mssv2;

		b_lbl_Quang = Box.createHorizontalBox();
		ten1 = new JLabel("1. Nguyễn Lê Nhật Quang");
		ten1.setFont(font);
		mssv1 = new JLabel("16026501");
		mssv1.setFont(font);
		b_lbl_Quang.add(ten1);
		b_lbl_Quang.add(Box.createHorizontalStrut(30));
		b_lbl_Quang.add(mssv1);
		b_lbl.add(b_lbl_Quang);

		b_lbl.add(Box.createVerticalStrut(-200));

		b_lbl_Luc = Box.createHorizontalBox();
		ten2 = new JLabel("2. Võ Tấn Lực");
		ten2.setFont(font);
		mssv2 = new JLabel("16021821");
		mssv2.setFont(font);
		b_lbl_Luc.add(ten2);
		b_lbl_Luc.add(Box.createHorizontalStrut(170));
		b_lbl_Luc.add(mssv2);
		b_lbl.add(b_lbl_Luc);

		b_lbl.add(Box.createVerticalStrut(-200));

		b_lbl_Dat = Box.createHorizontalBox();
		JLabel ten3 = new JLabel("3. Doãn Trần Tuấn Đạt");
		ten3.setFont(font);
		JLabel mssv3 = new JLabel("16035741");
		mssv3.setFont(font);
		b_lbl_Dat.add(ten3);
		b_lbl_Dat.add(Box.createHorizontalStrut(70));
		b_lbl_Dat.add(mssv3);
		b_lbl.add(b_lbl_Dat);

		add(b_lbl);
	}
}
