package a_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import a_project.DBconnect;

public class MovieJoin extends JFrame implements MouseListener, ActionListener { //회원가입

   public JPanel jp1, jp2, jp3, jp4, jp5;
   public JLabel lbl1, lblBk1, lblBk2, lblId, lblPw, lblPw2, lblName, lblPhone;
   public JButton btnOK, btn1, btn2, btn3;
   public JTextField tfId, tfName, tfPhone;
   public JPasswordField tfPw, tfPw2;
   public JLabel lblImg;
   public ImageIcon img;
   
   public static Connection conn;
   
   public MovieJoin(String title, int width, int height) {
      setTitle(title);
      setSize(width, height);
      //setLocation(1800, 300);
      setLocationRelativeTo(this); // 가운데로
      //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //모든 프레임 닫기
      
      //전체 레이아웃
      setLayout(new BorderLayout());
      
      //패널1
      jp1 = new JPanel(); jp1.setBackground(Color.WHITE);
//      jp1.setBackground(Color.pink);
      
//      img = new ImageIcon("images/movie4.png");
//      lblImg = new JLabel(img);
//      lblImg.setSize(10, 10);
      
      //lbl1 = new JLabel("                      회원가입                      ", img, 10);
      lbl1 = new JLabel("INHA CINEMA");
      lbl1.setFont(new Font("Segoe UI Black", Font.BOLD, 25));

      
      jp1.add(lbl1); //add
      //jp1.add(lblImg);
      add(jp1, BorderLayout.NORTH);
      
       //패널2
      jp2 = new JPanel(); jp2.setBackground(Color.WHITE);
      jp2.setLayout(new GridLayout(5, 1, 10, 10));
      jp2.setBorder(new EmptyBorder(20, 20, 20, 20));
      
      tfId = new JTextField();
      TextHint hint1 = new TextHint(tfId, "아이디");
      tfPw = new JPasswordField();
      TextHint hint2 = new TextHint(tfPw, "비밀번호");
      tfPw2 = new JPasswordField();
      TextHint hint3 = new TextHint(tfPw2, "비밀번호"); //비밀번호 재확인
      tfName = new JTextField();
      TextHint hint4 = new TextHint(tfName, "이름");
      tfPhone = new JTextField();
      TextHint hint5 = new TextHint(tfPhone, "휴대전화");
      
      jp2.add(tfId); //add
      jp2.add(tfPw);
      jp2.add(tfPw2);
      jp2.add(tfName);
      jp2.add(tfPhone);
      add(jp2, BorderLayout.CENTER);
      
      //패널3
      jp3 = new JPanel(); jp3.setBackground(Color.WHITE);
      
      btnOK = new JButton("가입완료");
      btnOK.addActionListener(this);
      btnOK.setFont(new Font("맑은 고딕", Font.BOLD, 12));
      Color a = new Color(255,228,225);
      btnOK.setBackground(a);
      //btnOK.setPreferredSize(new Dimension(100, 40));
      
      jp3.add(btnOK);
      add(jp3, BorderLayout.SOUTH); //add
      
      //패널4
      jp4 = new JPanel(); jp4.setBackground(Color.WHITE);
      jp4.setLayout(new GridLayout(5, 1, 10, 10));
      jp4.setBorder(new EmptyBorder(20, 20, 20, 20));
      
      btn1 = new JButton("중복확인");
      btn1.setBackground(a);
      lblBk1 = new JLabel(""); //빈칸
      btn2 = new JButton("일치");
      btn2.addActionListener(this); //일치확인
      btn2.setBackground(a);
      lblBk2 = new JLabel(""); //빈칸
      
      jp4.add(btn1);
      jp4.add(lblBk1);
      jp4.add(btn2);
      jp4.add(lblBk2);
      add(jp4, BorderLayout.EAST);
      
      //패널5
      jp5 = new JPanel(); jp5.setBackground(Color.WHITE);
      jp5.setLayout(new GridLayout(5, 1, 10, 10));
      jp5.setBorder(new EmptyBorder(20, 20, 20, 20));
      
      lblId = new JLabel("아이디");
      lblPw = new JLabel("비밀번호");
      lblPw2 = new JLabel("비밀번호 재확인");
      lblName = new JLabel("이름");
      lblPhone = new JLabel("휴대전화");
      
      jp5.add(lblId);
      jp5.add(lblPw);
      jp5.add(lblPw2);
      jp5.add(lblName);
      jp5.add(lblPhone);
      add(jp5, BorderLayout.WEST);
      
      setVisible(true);
   }
   
   public static void main(String[] args) {
      new MovieJoin("회원가입", 600, 400);

      DBconnect.DB();
//      try {
//         // 오라클 드라이버 설치
//         Class.forName("oracle.jdbc.driver.OracleDriver");
//         
//         //드라이버 매니저 연결, 정보 받아서 저장
//         conn = DriverManager.getConnection
//               ("jdbc:oracle:thin:@localhost:1521:XE",
//               "temp", "1111");
//               //("jdbc:oracle:thin:@114.71.137.174:53994:XE",
//               //      "amovie", "popcorn");
//               
         //가져오기
         //ResultSet rs = stmt.executeQuery("SELECT * FROM MEMBER");
         
         //while(rs.next()) {
         //   String id = rs.getString("ID");
         //   String pw = rs.getString("PW");
            
         //   System.out.println(id + "\t|" + pw);
         //}
         
//         System.out.println("OK!");
//         
//      } catch (ClassNotFoundException e) {
//         System.out.println("JDBC 드라이버 로드 에러");
//         e.printStackTrace();
//      } catch (SQLException e) {
//         System.out.println("DB 연결 에러 또는 쿼리 에러");
//         e.printStackTrace();
//      }
//      
   }

   @Override
   public void mouseClicked(MouseEvent e) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void mousePressed(MouseEvent e) {

   }

   @Override
   public void mouseReleased(MouseEvent e) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void mouseEntered(MouseEvent e) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void mouseExited(MouseEvent e) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      String id = tfId.getText();
      String pw = tfPw.getText();
      String pw2 = tfPw2.getText();
      String name = tfName.getText();
      String phone = tfPhone.getText();
      
      Object obj = e.getSource();
      
      if(obj == btnOK) {
      
      try {
         Statement stmt = conn.createStatement();
         
         // 회원 데이터 삽입
         String insertSQL =
                 "INSERT INTO MEMBER (ID, PW, NAME, PHONE) "
               + "VALUES('" + id + "', '" + pw + "', '" + name + "', '" + phone + "')";
         stmt.executeUpdate(insertSQL);   
         
      } catch (SQLException e1) {
         // TODO Auto-generated catch block
         e1.printStackTrace();
      }
      }
      
      if(obj == btn2) {
         if(tfPw.getText().equals(tfPw2.getText())) {
            btn2.setText("일치 √");
         } else {
            btn2.setText("일치");
         }
         
   
      }
   
}
}