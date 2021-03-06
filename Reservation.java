package a_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Reservation extends JFrame {
	
	private JPanel panel1, panel2, panel3, panel4, panel5;
	private JLabel lblcheck;
	private JLabel lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, movieName, lbldb2, movietime, movieSeat, moviePay, movieGrade;
	private JButton btn1;

	public Reservation(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
//		setLocation(800, 300);
		setLocationRelativeTo(this); //모니터 가운데 위치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창에서 닫기 버튼 누르면 콘솔 종료
		setLayout(new BorderLayout());
		
		
			//로고
			panel1 = new JPanel();
			panel1.setBackground(Color.pink);
			lblcheck = new JLabel("예매 확인");
			lblcheck.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			
			panel1.add(lblcheck);
			
			//예매 정보
			
			panel2 = new JPanel();
			panel2.setLayout(new GridLayout(6, 1, 10, 10));
			panel2.setBorder(new EmptyBorder(20, 20, 20, 20));
			
			lbl1 = new JLabel("예매 영화");
			lbl2 = new JLabel("예매 극장");
			lbl3 = new JLabel("관람일자");
			lbl4 = new JLabel("예매좌석");
			lbl5 = new JLabel("결제 금액");
			lbl6 = new JLabel("회원 등급");
			
			lbl1.setForeground(Color.gray);
			lbl1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			
			lbl2.setForeground(Color.gray);
			lbl2.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			
			lbl3.setForeground(Color.gray);
			lbl3.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			
			lbl4.setForeground(Color.gray);
			lbl4.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			
			lbl5.setForeground(Color.gray);
			lbl5.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			
			lbl6.setForeground(Color.gray);
			lbl6.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			
			

			panel2.add(lbl1);
			panel2.add(lbl2);
			panel2.add(lbl3);
			panel2.add(lbl4);
			panel2.add(lbl5);
			panel2.add(lbl6);
			
			// 가운데
			panel3 = new JPanel();
			panel3.setLayout(new GridLayout(6, 1, 10, 10));
			panel3.setBorder(new EmptyBorder(20, 20, 20, 20));
			
			movieName = new JLabel("귀멸의 칼날");
			lbldb2 = new JLabel("인하극장");
			movietime = new JLabel("2021년 10월 1일");
			movieSeat = new JLabel("J열 11번");
			moviePay = new JLabel("13,000원");
			movieGrade = new JLabel("VVIP");
			
			panel3.add(movieName);
			panel3.add(lbldb2);
			panel3.add(movietime);
			panel3.add(movieSeat);
			panel3.add(moviePay);
			panel3.add(movieGrade);
			
			//오른쪽 공백
			panel4 = new JPanel();
			panel4.setLayout(new GridLayout(6, 1, 10, 10));
			panel4.setBorder(new EmptyBorder(20, 20, 20, 20));
			
			
			//버튼
			panel5 = new JPanel();
			btn1 = new JButton("예매확인 완료");
			panel5.add(btn1);
			Color a = new Color(255, 228, 225);
			btn1.setBackground(a);
			
			
			add(panel1, BorderLayout.NORTH);
			add(panel2, BorderLayout.WEST);
			add(panel3, BorderLayout.CENTER);
			add(panel4, BorderLayout.EAST);
			add(panel5, BorderLayout.SOUTH);
			
		setVisible(true); // 이게 없으면 창이 뜨지 않음 
	}

	public static void main(String[] args) {
		DBconnect.DB();
		new Reservation("예매 확인", 400, 400); // title, width, height
	}

}