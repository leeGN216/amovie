package a_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class SeatSelection extends JFrame implements MouseListener, ActionListener {
	JLabel Ala[] = new JLabel[25];
	private int Aseat[] = new int[25];
	private int Bseat[] = new int[25];
	private int Cseat[] = new int[25];
	JLabel Bla[] = new JLabel[25];
	JLabel Cla[] = new JLabel[25];
	//DBconnect db = new DBconnect();
	Font font = new Font("맑은 고딕", Font.PLAIN, 20);
	private JPanel main;
	private JButton tiketing;

	public SeatSelection(String Title, int width, int height) {
		this.setTitle(Title);
		setSize(width, height);
		// setLocation(900, 400);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Font lafont = new Font("맑은 고딕", Font.PLAIN, 15);

		JPanel p1 = new JPanel();
		JLabel la = new JLabel("좌석선택    ");
		JLabel selmovie = new JLabel("선택한영화제목    ");
		JLabel time = new JLabel("상영시간");
		la.setFont(lafont);
		selmovie.setFont(lafont);
		time.setFont(lafont);
		p1.add(la);
		p1.add(selmovie);
		p1.add(time);
		// .setPreferredSize(new Dimension(100, 100);

		JPanel mo = new JPanel();
		mo.setLayout(null);
		mo.setBorder(new TitledBorder(new LineBorder(Color.black, 1)));
		main = new JPanel();
		main.setLayout(new GridLayout());
		main.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0));
		main.setBorder(new TitledBorder(new LineBorder(Color.black, 3)));
		// main.setPreferredSize(new Dimension(50, 300));
		main.setBounds(20, 15, 745, 370);
		// main.setPreferredSize(new Dimension(800, 300));
		mo.setBackground(Color.pink);

		JPanel p3 = new JPanel();
		tiketing = new JButton("예매");
		tiketing.addActionListener(this);

		p3.add(tiketing);
		mo.add(main);
		creatseat();
		seatcheck();

		add(p1, BorderLayout.NORTH);
		add(mo, BorderLayout.CENTER);
		add(p3, BorderLayout.SOUTH);

		setVisible(true);
	}

	private void seatcheck() {
//		System.out.println("들어옴");
		String checkA[] = null;
		String checkB[] = null;
		String checkC[] = null;
		try {
			ResultSet re = DBconnect.getResultSet("select * from seat");
			//ResultSet re = db.getStat().executeQuery("select * from movie");
			while (re.next()) {
				if (re.getString("A") != null)
					checkA = re.getString("A").split(",");
				if (re.getString("B") != null)
					checkB = re.getString("B").split(",");
				if (re.getString("C") != null)
					checkC = re.getString("C").split(",");
				if (re.getString("A") != null) {
					for (int i = 0; i < checkA.length; i++) {
//						System.out.println(checkA[i]);
						Ala[Integer.parseInt(checkA[i]) - 1].setForeground(Color.RED);
						Aseat[Integer.parseInt(checkA[i]) - 1] = 2;
					}
				}
				if (re.getString("B") != null) {
					for (int i = 0; i < checkB.length; i++) {
						//System.out.println(checkB[i]);
						Bla[Integer.parseInt(checkB[i]) - 1].setForeground(Color.RED);
						Bseat[Integer.parseInt(checkB[i]) - 1] = 2;
					}
				}
				if (re.getString("C") != null) {
					for (int i = 0; i < checkC.length; i++) {
						//System.out.println(checkC[i]);
						Cla[Integer.parseInt(checkC[i]) - 1].setForeground(Color.RED);
						Cseat[Integer.parseInt(checkC[i]) - 1] = 2;
					}
				}
			}

		} catch (SQLException e) {
			System.out.println("무야호");
			e.printStackTrace();
		}
	}

	private void creatseat() {
		JPanel A = new JPanel();
		A.setLayout(new GridLayout(5, 5, 10, 10));
		for (int i = 0; i < Ala.length; i++) {
			Ala[i] = new JLabel("A" + Integer.toString(i + 1));
			//Ala[i].setOpaque(true); 
			//Ala[i].setBackground(Color.white);
			Ala[i].addMouseListener(this);
			Ala[i].setFont(font);
			// Ala[i].setSize(100,100);
			A.add(Ala[i]);
		}
		JPanel B = new JPanel();
		B.setLayout(new GridLayout(5, 5));
		for (int i = 0; i < Bla.length; i++) {
			Bla[i] = new JLabel("B" + Integer.toString(i + 1));
			Bla[i].addMouseListener(this);
			Bla[i].setFont(font);
			B.add(Bla[i]);
		}
		JPanel C = new JPanel();
		C.setLayout(new GridLayout(5, 5));
		for (int i = 0; i < Cla.length; i++) {
			Cla[i] = new JLabel("C" + Integer.toString(i + 1));
			Cla[i].addMouseListener(this);
			Cla[i].setFont(font);
			C.add(Cla[i]);
		}
		main.add(A);
		main.add(B);
		main.add(C);
	}

	public static void main(String[] args) {
		DBconnect.DB();
		new SeatSelection("좌석선택", 800, 500);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		String saveA = "";
		String saveB = "";
		String saveC = "";
		if (ob == tiketing) {
			for (int i = 0; i < 25; i++) {
				if (Aseat[i] == 1) {
					Ala[i].setForeground(Color.red);
					saveA += Integer.toString(i + 1) + ",";
					Aseat[i] = 2;
				}
			}
			for (int i = 0; i < 25; i++) {
				if (Bseat[i] == 1) {
					Bla[i].setForeground(Color.red);
					saveB += Integer.toString(i + 1) + ",";
					Bseat[i] = 2;
				}
			}
			for (int i = 0; i < 25; i++) {
				if (Cseat[i] == 1) {
					Cla[i].setForeground(Color.red);
					saveC += Integer.toString(i + 1) + ",";
					Cseat[i] = 2;
				}
			}
			String sql = "INSERT INTO seat (A, B, C)" + " VALUES('" + saveA + "', '" + saveB + "', '" + saveC
					+ "')";
//			System.out.println(sql);
			DBconnect.getupdate(sql);
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object ob = e.getSource();
		for (int i = 0; i < 25; i++) {
			if (ob == Ala[i]) {
				if (Aseat[i] == 0) {
					Ala[i].setForeground(Color.CYAN);
					Aseat[i] = 1;
				} else if (Aseat[i] == 1) {
					Ala[i].setForeground(Color.black);
					Aseat[i] = 0;
				}
			} else if (ob == Bla[i]) {
				if (Bseat[i] == 0) {
					Bla[i].setForeground(Color.CYAN);
					Bseat[i] = 1;
				} else if (Bseat[i] == 1) {
					Bla[i].setForeground(Color.black);
					Bseat[i] = 0;
				}
			} else if (ob == Cla[i]) {
				if (Cseat[i] == 0) {
					Cla[i].setForeground(Color.CYAN);
					Cseat[i] = 1;
				} else if (Cseat[i] == 1) {
					Cla[i].setForeground(Color.black);
					Cseat[i] = 0;
				}
			}
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
}
