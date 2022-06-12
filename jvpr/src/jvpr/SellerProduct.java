package jvpr;
//본인 물품만 검색이 가능합니다.
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SellerProduct extends JFrame{   
public static Connection getConnection() throws ClassNotFoundException, SQLException  {
	    
	    String url = "jdbc:mysql://localhost:3306/sampledb";
	    String user = "root";
	    String pwd = "1234";
	    Connection conn = null;
	    
	    Class.forName("com.mysql.jdbc.Driver");
	    conn = DriverManager.getConnection(url, user, pwd);
	    System.out.println("접속");
	        
	    return conn;
	}
public ArrayList<Productbe> TotalQuery(JPanel panel, String seller_id) throws ClassNotFoundException, SQLException{ //전체 상품 보기
    
	Connection conn = getConnection();
	 String sql = "select * from product where seller_id = ?";
	 PreparedStatement pstmt = conn.prepareStatement(sql);
	 pstmt = conn.prepareStatement(sql);
	 pstmt.setString(1,seller_id);
	 ResultSet rs = pstmt.executeQuery();
	 ArrayList<Productbe> list = new ArrayList<Productbe>();
	 while(rs.next()) {
		 	Productbe bean = new Productbe();
		 	System.out.print(rs.getString("pr_id"));
			bean.setpr_id(rs.getString("pr_id"));
			bean.setpr_name(rs.getString("pr_name"));
			bean.setpr_price(rs.getInt("pr_price"));
			bean.setpr_quan(rs.getInt("pr_quan"));
			bean.setseller_id(rs.getString("seller_id"));		
			list.add(bean);
	 }
	 return list;				
}
public void Pr_insert(String pr_id,String pr_name,int pr_price,int pr_quan,String seller_id) throws ClassNotFoundException, SQLException{ //삽입
    
	Connection conn = getConnection();
    String sql = "insert into product values (?,?,?,?,?)";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, pr_id);
    pstmt.setString(2, pr_name);
    pstmt.setInt(3, pr_price);
    pstmt.setInt(4, pr_quan);
    pstmt.setString(5, seller_id); 
    int res = pstmt.executeUpdate();
     
    if(pstmt != null) 
		pstmt.close();
    if(conn != null) 
		conn.close();			
}
public ArrayList<Productbe> Any_Query(JPanel panel, String pr_id) throws ClassNotFoundException, SQLException{ //검색문
    
	Connection conn = getConnection();
	 String sql = "select * from product where pr_id = ? or pr_name = ?";
	 PreparedStatement pstmt = conn.prepareStatement(sql);
	 pstmt = conn.prepareStatement(sql);
	 pstmt.setString(1,pr_id);
	 pstmt.setString(2,pr_id);
	 ResultSet rs = pstmt.executeQuery();
	 ArrayList<Productbe> list = new ArrayList<Productbe>();
	 while(rs.next()) {
		 	Productbe bean = new Productbe();
		 	System.out.print(rs.getString("pr_id"));
			bean.setpr_id(rs.getString("pr_id"));
			bean.setpr_name(rs.getString("pr_name"));
			bean.setpr_price(rs.getInt("pr_price"));
			bean.setpr_quan(rs.getInt("pr_quan"));
			bean.setseller_id(rs.getString("seller_id"));		
			list.add(bean);
	 }
	 return list;				
}
public void Pr_update(String pr_name,int pr_price,int pr_quan,String seller_id,String pr_id) throws ClassNotFoundException, SQLException{ //수정
    
	Connection conn = getConnection();
    String sql = "update product set pr_name = ?, pr_price = ?, pr_quan =? ,seller_id = ? where pr_id = ?";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, pr_name);
    pstmt.setInt(2, pr_price);
    pstmt.setInt(3, pr_quan);
    pstmt.setString(4, seller_id); 
    pstmt.setString(5, pr_id);
    int res = pstmt.executeUpdate();
     
    if(pstmt != null) 
		pstmt.close();
    if(conn != null) 
		conn.close();			
}
public void Pr_delete(String pr_id) throws ClassNotFoundException, SQLException{ //삭제
    
	Connection conn = getConnection();
    String sql = "delete from product where pr_id =?";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, pr_id); 
    int res = pstmt.executeUpdate();
     
    if(pstmt != null) 
		pstmt.close();
    if(conn != null) 
		conn.close();			
}

	public void ShowFrame(String id){

		setTitle("판매자 로그인");
        setSize(750, 700);
        setLocation(450, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       
        JPanel panel = new JPanel();
        panel.setLayout(null);
        add(panel);
        

        JTextField tf = new JTextField(); 
        tf.setBounds(5, 5, 500, 25);
        panel.add(tf);
        
        JTextArea ta = new JTextArea(); 
        ta.setBounds(5, 45, 500, 600);
        panel.add(ta);
        
        ta.setText("검색은 상품 id 또는 상품 이름으로 검색해야 합니다.\n");
        ta.append("검색을 하실 때는 위 텍스트 칸에 적은 후 검색 버튼을 눌러주세요\n\n");
        ta.append("상품 추가하는 방법 ex)물품번호 물품이름 물품가격 물품수량\n");
        ta.append("반드시 띄어쓰기를 해주세요\n\n");
        ta.append("상품 수정은 물품 번호를 제외하고 변경하거나 유지해야 합니다.\n");
        ta.append("입력 예)물품번호 수정이름 수정가격 수정수량 \n");
        ta.append("반드씨 띄어쓰기를 해주세요\n\n");
        ta.append("상품을 삭제할 때는 반드시 상품번호를 입력 후 삭제 버튼을 눌러주세요\n\n");
        
   
        JButton btn1 = new JButton("전체 상품 보기");
        panel.add(btn1);
        btn1.setBounds(550, 50, 150, 50);

        JButton btn6 = new JButton("상품 추가");
        panel.add(btn6);
        btn6.setBounds(550, 150, 150, 50);
        
        JButton btn2 = new JButton("검색");
        panel.add(btn2);
        btn2.setBounds(550, 250, 150, 50);


        JButton btn3 = new JButton("수정");
        panel.add(btn3);
        btn3.setBounds(550, 350, 150, 50);


        JButton btn4 = new JButton("삭제");
        panel.add(btn4);
        btn4.setBounds(550, 450, 150, 50);


        JButton btn5 = new JButton("종료");
        panel.add(btn5);
        btn5.setBounds(550, 550, 150, 50);
        setVisible(true);
        
        btn1.addActionListener(new ActionListener() { //전체 상품 보기 이벤트 처리
            public void actionPerformed(ActionEvent arg0) {         
            	try {
           		 	ArrayList<Productbe> list2 = new ArrayList<Productbe>();
           		 	ta.setText("");
                	list2 = TotalQuery(panel, id);
                	 ta.append("상품 추가하는 방법 ex)물품번호 물품이름 물품가격 물품수량\n");
                     ta.append("반드시 띄어쓰기를 해주세요\n\n\n");
                	ta.append("물품 번호	" + " 물품 이름	" + " 물품 가격	" + " 물품 수량	" + " 물품 판매자 아이디 \n");
                	for(int i=0;i<list2.size();i++) {
                		ta.append(list2.get(i).getpr_id() + "	");
                		ta.append(list2.get(i).getpr_name()+ "	");
                		ta.append(Integer.toString(list2.get(i).getpr_price())+ "	");
                		ta.append(Integer.toString(list2.get(i).getpr_quan())+ "	");
                		ta.append(list2.get(i).getseller_id() + "\n");
                	}    
                }catch(ClassNotFoundException | SQLException f) {
                	f.printStackTrace();
                }
            }
        });
        btn6.addActionListener(new ActionListener() { // 입력
            public void actionPerformed(ActionEvent arg0) {         
            	String[] into = tf.getText().split(" ");
            	try {
            	Pr_insert(into[0],into[1],Integer.parseInt(into[2]),Integer.parseInt(into[3]),id);
            }catch(ClassNotFoundException | SQLException f) {
                	f.printStackTrace();
                }
            }
        });
        
        btn2.addActionListener(new ActionListener() { // 검색 이벤트 처리
            public void actionPerformed(ActionEvent arg0) {         
            	try {
           		 	ArrayList<Productbe> list2 = new ArrayList<Productbe>();
           		 	ta.setText("");
           		 	ta.append("검색을 하실 때는 위 텍스트 칸에 적은 후 검색 버튼을 눌러주세요\n\n");
           		 	String p_id = tf.getText();
                	list2 = Any_Query(panel, p_id);
                	ta.append("물품 번호	" + " 물품 이름	" + " 물품 가격	" + " 물품 수량	" + " 물품 판매자 아이디 \n");
                	for(int i=0;i<list2.size();i++) {
                		ta.append(list2.get(i).getpr_id() + "	");
                		ta.append(list2.get(i).getpr_name()+ "	");
                		ta.append(Integer.toString(list2.get(i).getpr_price())+ "	");
                		ta.append(Integer.toString(list2.get(i).getpr_quan())+ "	");
                		ta.append(list2.get(i).getseller_id() + "\n");
                	}    
                }catch(ClassNotFoundException | SQLException f) {
                	f.printStackTrace();
                }
            }
        });
        btn3.addActionListener(new ActionListener() { // 수정
            public void actionPerformed(ActionEvent arg0) { 
            	String[] into = tf.getText().split(" ");
            	try {
            		Pr_update(into[1],Integer.parseInt(into[2]),Integer.parseInt(into[3]),id,into[0]);
            }catch(ClassNotFoundException | SQLException f) {
                	f.printStackTrace();
                }
            }
        });
        
        btn4.addActionListener(new ActionListener() { // 삭제
            public void actionPerformed(ActionEvent arg0) {         
            	try {
            	Pr_delete(tf.getText());
            }catch(ClassNotFoundException | SQLException f) {
                	f.printStackTrace();
                }
            }
        });
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });
    }
}
