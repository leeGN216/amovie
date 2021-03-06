package a_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Closeable;
import java.sql.Statement;

import javax.print.attribute.AttributeSet;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class Payment extends JFrame implements ActionListener {
	
	JComboBox<String> cbbox;
	JLabel pay;
	JLabel discountPay;
	JComboBox<String> monCombo;
	JComboBox<String> yearCombo;
	int grade;
	JButton jbOk;
	JButton jbCancle;
	JPasswordField jpwf;
	public static final int ipay =12000;
	int iPay;
	JTextField tf1,tf2,tf3,tf4;
	String sMonth, sYear, jpw;
	
	public Payment(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocation(400, 200);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());
		
		northPan();
		eastPan();
		centerPan();
		westPan();
		southPan();

		setVisible(true);
	}

	private void westPan() {
		JPanel wp = new JPanel();
		wp.setLayout(new GridLayout(6, 1, 10, 10));
		wp.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		JLabel wplb1 = new JLabel("결제 금액 :");
		wplb1.setPreferredSize(new Dimension(120, 40));
		wplb1.setFont(wplb1.getFont().deriveFont(15.0f));
		wp.add(wplb1);

		JLabel wplb2 = new JLabel("회원 할인 :");
		wplb2.setPreferredSize(new Dimension(120, 40));
		wplb2.setFont(wplb2.getFont().deriveFont(15.0f));
		wp.add(wplb2);

		JLabel wplb3= new JLabel("최종 금액 :");
		wplb3.setPreferredSize(new Dimension(120, 40));
		wplb3.setFont(wplb3.getFont().deriveFont(15.0f));
		wp.add(wplb3);

		JLabel wplb4 = new JLabel("카드 번호 :");
		wplb4.setPreferredSize(new Dimension(120, 40));
		wplb4.setFont(wplb4.getFont().deriveFont(15.0f));
		wp.add(wplb4);
		
		JLabel wplb6 = new JLabel("유효기간  :");
		wplb6.setPreferredSize(new Dimension(50, 40));
		wplb6.setFont(wplb6.getFont().deriveFont(15.0f));
		wp.add(wplb6);
		
		JLabel wplb5 = new JLabel("비밀 번호 : ");
		wplb5.setPreferredSize(new Dimension(120, 40));
		wplb5.setFont(wplb5.getFont().deriveFont(15.0f));
		wp.add(wplb5);


		add(wp, BorderLayout.WEST);
	}

	private void eastPan() {

	}



	private void centerPan() {

		JPanel cp = new JPanel();
		cp.setLayout(new GridLayout(6, 1, 10, 10));
		cp.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		pay = new JLabel("20000");
		pay.setPreferredSize(new Dimension(120, 40));
		pay.setFont(pay.getFont().deriveFont(15.0f));
		cp.add(pay);

		String[] discount = { "일반회원", "실버맴버(20%)", "골드 맴버(30%)", "VIP할인(40%)" };
		cbbox = new JComboBox<String>(discount);
		cbbox.setFont(cbbox.getFont().deriveFont(15.0f));
		cbbox.setPreferredSize(new Dimension(160, 30));
		cbbox.addActionListener(this);
		cp.add(cbbox);

		discountPay = new JLabel("20000");
		discountPay.setPreferredSize(new Dimension(150, 40));
		discountPay.setFont(discountPay.getFont().deriveFont(15.0f));
		cp.add(discountPay);
		
//		JLabel cplb2 = new JLabel("카드 번호 : ");
//		cplb2.setPreferredSize(new Dimension(80, 40));
//		cplb2.setFont(cplb2.getFont().deriveFont(15.0f));
//		cp.add(cplb2);
		
		
		JPanel cardPan = new JPanel();
		cardPan.setLayout(new GridLayout(1, 4,5,5));
		cardPan.setBorder(BorderFactory.createEmptyBorder(5,0,10,0));
		tf1 = new JTextField(3);
		tf1.setDocument(new JTextFieldLimit(4));
		tf2 = new JPasswordField(3);
		tf2.setDocument(new JTextFieldLimit(4));
		tf3 = new JPasswordField(3);
		tf3.setDocument(new JTextFieldLimit(4));
		tf4 = new JTextField(3);
		tf4.setDocument(new JTextFieldLimit(4));
		
		cardPan.add(tf1);
		cardPan.add(tf2);
		cardPan.add(tf3);
		cardPan.add(tf4);
		cp.add(cardPan);
		
		JPanel timePan = new JPanel();
		timePan.setLayout(new FlowLayout(FlowLayout.LEFT));
		String[] month = { "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월" };
		monCombo = new JComboBox<String>(month);
		monCombo.setPreferredSize(new Dimension(70, 20));
		monCombo.setFont(monCombo.getFont().deriveFont(15.0f));
		monCombo.addActionListener(this);
		timePan.add(monCombo);
		
		String[] year = {"2022", "2023", "2024", "2025", "2026" };
		yearCombo = new JComboBox<String>(year);
		yearCombo.setPreferredSize(new Dimension(70, 20));
		yearCombo.setFont(yearCombo.getFont().deriveFont(15.0f));
		yearCombo.addActionListener(this);
		timePan.add(yearCombo);
		cp.add(timePan);
		
		JPanel pwPan = new JPanel() ;
		pwPan.setLayout(new FlowLayout(FlowLayout.LEFT));
//		pwPan.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
		jpwf = new JPasswordField(16);
//		jpw.setPreferredSize(new Dimension(70,20));
		pwPan.add(jpwf);
		cp.add(pwPan);
		
		add(cp);
	}

	private void northPan() {
		String movieTime = " ";// 무비 타임 추가
		String seat = "";// 좌석 추가

		JPanel np = new JPanel();
//		np.setLayout(new BorderLayout());
		ImageIcon img = new ImageIcon("imgs/movie.png");// ? 왜안되지
		JLabel imglb = new JLabel(img);
		np.add(imglb);

		JLabel nplb = new JLabel("결제창입니다.");
		np.setBackground(Color.pink);
		np.setSize(new Dimension(70, 70));
		nplb.setForeground(Color.black);
		Font font = new Font("굴림", Font.PLAIN, 36);
		JLabel tkInfo = new JLabel("상영시간 :  " + movieTime + "좌석 : " + seat);

		nplb.setFont(font);
//		nplb.setSize(new Dimension(80,40));
//		nplb.setFont(nplb.getFont().deriveFont(20.0f));//폰트 사이즈
		nplb.setHorizontalAlignment(JLabel.CENTER);
		np.setPreferredSize(new Dimension(40, 90));
		np.setBorder(BorderFactory.createEmptyBorder(5, 20, 10, 10));
		np.add(nplb);
		np.add(tkInfo);

		add(np, BorderLayout.NORTH);
	}
	
	private void southPan() {
		JPanel sp = new JPanel();
		jbOk = new JButton("완료");
		jbOk.addActionListener(this);
		sp.add(jbOk);
		
		jbCancle = new JButton("취소");
		jbCancle.addActionListener(this);
		sp.add(jbCancle);

		add(sp, BorderLayout.SOUTH);

	}

	public static void main(String[] args) {
		DBconnect.DB();
		
		new Payment("결제 ", 400, 500);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj ==cbbox) {
			grade = cbbox.getSelectedIndex();
			double dPay = Double.parseDouble(pay.getText());
			switch (grade) {
			case 0: dPay = dPay* 1;
				
			case 1 : dPay = dPay* 0.8;
			break;
			
			case 2 : dPay = dPay * 0.7;
			break;
			
			case 3 : dPay = dPay * 0.6;
			break;

			default:
				throw new IllegalArgumentException("Unexpected value: " + grade);
			}
			discountPay.setText((int)dPay+"원");
			iPay=(int)dPay;
		}		
		else if(obj==monCombo) {
			int iMonth = monCombo.getSelectedIndex();
			
			switch (iMonth) {
			case 0: 
				sMonth = "1월";
				break;
			case 1: 
				sMonth = "2월";
				break;
			case 2: 
				sMonth = "3월";
				break;
			case 3: 
				sMonth = "4월";
				break;
			case 4: 
				sMonth = "5월";
				break;
			case 5: 
				sMonth = "6월";
				break;
			case 6:
				sMonth = "7월";
				break;
			case 7:
				sMonth = "8월";
				break;
			case 8: 
				sMonth = "9월";
				break;
			case 9: 
				sMonth = "10월";
				break;
			case 10: 
				sMonth = "11월";
				break;
			case 11: 
				sMonth = "12월";
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + iMonth);
			}
		}else if(obj==yearCombo) {
			int iYear = monCombo.getSelectedIndex();
			
			switch (iYear) {
			case 0: 
				sYear = "2022년";
				break;
			case 1: 
				sYear = "2023년";
				break;
			case 2: 
				sYear = "2024년";
				break;
			case 3: 
				sYear = "2025년";
				break;
			case 4: 
				sYear = "2026년";
				break;
				
			default:
				throw new IllegalArgumentException("Unexpected value: " + iYear);
			}
		}else if (obj==jbOk) {
			//결제 완료 페이지 
			//최종가격 = dPay , 카드 유효기간 sMonth , sYear
			//회원등급 int grade  0 = 일반,  1 = 실버,  2 = 골드,  3 = vip 
			//비밀번호 jpw.gettext()
			String cardNum = tf1.getText()+tf2.getText()+tf3.getText()+tf4.getText();
			jpw = jpwf.getText();
			String insertSQL = 
					"INSERT INTO TEMP.RESERVATION(RES_CARDNUM,RES_CARDPASSWORD,RES_PAY,CARD_MONTH,CARDYEAR,RES_NUM,ID,MOVIE_NAME)"//공백부분 신경써야함 
					+"VALUES('"+cardNum+"','"+ jpw 
					+"','"+iPay+"','"+sMonth
					+"', '"+ sYear+"','1','admin','아이즈 온 미 : 더 무비')"; //벨류 부분은 무조건 떨어뜨려놓아야 인식을 한다.
			System.out.println(insertSQL);
			DBconnect.getupdate(insertSQL);
		
			
			
			
		}else if (obj==jbCancle) {
			System.exit(0);
		}
	}
}
