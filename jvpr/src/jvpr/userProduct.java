package jvpr;
//���� ��ǰ�� �˻��� �����մϴ�.
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class userProduct extends JFrame{   
public static Connection getConnection() throws ClassNotFoundException, SQLException  {
	    
	    String url = "jdbc:mysql://localhost:3306/sampledb";
	    String user = "root";
	    String pwd = "1234";
	    Connection conn = null;
	    
	    Class.forName("com.mysql.jdbc.Driver");
	    conn = DriverManager.getConnection(url, user, pwd);
	    System.out.println("����");
	        
	    return conn;
	}
public ArrayList<Productbe> TotalQuery(JPanel panel, String seller_id) throws ClassNotFoundException, SQLException{ //��ü ��ǰ ����
    
	Connection conn = getConnection();
	 String sql = "select * from product";
	 PreparedStatement pstmt = conn.prepareStatement(sql);
	 pstmt = conn.prepareStatement(sql);
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
public ArrayList<Productbe> user_money(String id) throws ClassNotFoundException, SQLException{ //�ݾ�Ȯ��
    
	Connection conn = getConnection();
	 String sql = "select * from user where id = ?";
	 PreparedStatement pstmt = conn.prepareStatement(sql);
	 pstmt = conn.prepareStatement(sql);
	 pstmt.setString(1,id);
	 ResultSet rs = pstmt.executeQuery();
	 ArrayList<Productbe> list = new ArrayList<Productbe>();
	 
	 while(rs.next()) {
		 	Productbe bean = new Productbe();
			bean.setwallet(rs.getInt("wallet"));
			list.add(bean);
	 }
	 return list;			
}
public ArrayList<Productbe> Any_Query(JPanel panel, String pr_id) throws ClassNotFoundException, SQLException{ //�˻���
    
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

public ArrayList<Productbe> pr_Query(String id) throws ClassNotFoundException, SQLException{ //�˻���
    
	 Connection conn = getConnection();
	 String sql = "select * from user_product where user_id = ?";
	 PreparedStatement pstmt = conn.prepareStatement(sql);
	 pstmt = conn.prepareStatement(sql);
	 pstmt.setString(1,id);
	 ResultSet rs = pstmt.executeQuery();
	 ArrayList<Productbe> list = new ArrayList<Productbe>();
	 while(rs.next()) {
		 	Productbe bean = new Productbe();
			bean.setuser_pr_id(rs.getString("user_pr_id"));
			bean.setuser_pr_quan(rs.getInt("user_pr_quan"));
			bean.setuser_id(rs.getString("user_id"));		
			list.add(bean);
	 }
	 return list;				
}

public void user_charge(int wallet_price, String id) throws ClassNotFoundException, SQLException{ //����
    
	Connection conn = getConnection();
    String sql = "update user set wallet = wallet + ? where id = ?";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setInt(1, wallet_price);
    pstmt.setString(2, id);
    
    int res = pstmt.executeUpdate();
    
    if(res == 0) {
    	JOptionPane.showMessageDialog(null, "�ݾ��� ���� ���� �ʾҽ��ϴ� ����� Ȯ�����ּ���");
    }
    else {
    	JOptionPane.showMessageDialog(null, "���������� �����Ǿ����ϴ�.");
    }
     
    if(pstmt != null) 
		pstmt.close();
    if(conn != null) 
		conn.close();			
}
public void user_buy(String pr_id,String id) throws ClassNotFoundException, SQLException{ //����
	
    
	Connection conn = getConnection();
    String sql = "insert into user_product values (?,1,?)";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, pr_id);
    pstmt.setString(2, id);
    int res = pstmt.executeUpdate();
    
    String sql2 = "select * from product where pr_id = ?";
	 PreparedStatement pstmt2 = conn.prepareStatement(sql2);
	 pstmt2 = conn.prepareStatement(sql2);
	 pstmt2.setString(1,pr_id);
	 ResultSet rs = pstmt2.executeQuery();
	 int real = 0;
	 while(rs.next()) {
		 	Productbe bean = new Productbe();
			real = rs.getInt("pr_price");
	 }
    
    
    String sql1 = "update user set wallet = wallet - ?";
    PreparedStatement pstmt1 = conn.prepareStatement(sql1);
    pstmt1.setInt(1, real);
    int res1 = pstmt1.executeUpdate();
    
    if(res == 0 && res1 == 0) {
    	JOptionPane.showMessageDialog(null, "������ ���� �ʾҽ��ϴ� ����� Ȯ�����ּ���");
    }
    else {
    	JOptionPane.showMessageDialog(null, "���������� ���ŵǾ����ϴ�.");
    }
    
    if(pstmt != null) 
		pstmt.close();
    if(conn != null) 
		conn.close();				
}

	public void ShowFrame(String id){

		setTitle("������ â");
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
        
        ta.setText("�˻��� ��ǰ id �Ǵ� ��ǰ �̸����� �˻��ؾ� �մϴ�.\n");
        ta.append("�˻��� �Ͻ� ���� �� �ؽ�Ʈ ĭ�� ���� �� �˻� ��ư�� �����ּ���\n\n");
        ta.append("��ǰ �߰��ϴ� ��� ex)��ǰ��ȣ ��ǰ�̸� ��ǰ���� ��ǰ����\n");
        ta.append("�ݵ�� ���⸦ ���ּ���\n\n");
        ta.append("��ǰ ������ ��ǰ ��ȣ�� �����ϰ� �����ϰų� �����ؾ� �մϴ�.\n");
        ta.append("�Է� ��)��ǰ��ȣ �����̸� �������� �������� \n");
        ta.append("�ݵ徾 ���⸦ ���ּ���\n\n");
        ta.append("��ǰ�� ������ ���� �ݵ�� ��ǰ��ȣ�� �Է� �� ���� ��ư�� �����ּ���\n\n");
        
   
        JButton btn1 = new JButton("��ü ��ǰ ����");
        panel.add(btn1);
        btn1.setBounds(550, 50, 150, 50);

        JButton btn6 = new JButton("���� �ݾ�");
        panel.add(btn6);
        btn6.setBounds(550, 150, 150, 50);
        
        JButton btn2 = new JButton("�˻�");
        panel.add(btn2);
        btn2.setBounds(550, 250, 150, 50);


        JButton btn3 = new JButton("�ݾ� ����");
        panel.add(btn3);
        btn3.setBounds(550, 350, 150, 50);


        JButton btn4 = new JButton("���� �ϱ�");
        panel.add(btn4);
        btn4.setBounds(550, 450, 150, 50);
        
        JButton btn8 = new JButton("���� ���");
        panel.add(btn8);
        btn8.setBounds(550, 550, 150, 50);


        JButton btn5 = new JButton("����");
        panel.add(btn5);
        btn5.setBounds(550, 620, 150, 30);
        setVisible(true);
        
        btn1.addActionListener(new ActionListener() { //��ü ��ǰ ���� �̺�Ʈ ó��
            public void actionPerformed(ActionEvent arg0) {         
            	try {
           		 	ArrayList<Productbe> list2 = new ArrayList<Productbe>();
           		 	ta.setText("");
                	list2 = TotalQuery(panel, id);
                	 ta.append("��ǰ ���Ž� ��ǰ ��ȣ�� ���� �����ϱ� ��ư�� �����ּ���\n\n\n");
                	ta.append("��ǰ ��ȣ	" + " ��ǰ �̸�	" + " ��ǰ ����	" + " ��ǰ ����	" + " ��ǰ �Ǹ��� ���̵� \n");
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
        
        btn8.addActionListener(new ActionListener() { //��ü ��ǰ ���� �̺�Ʈ ó��
            public void actionPerformed(ActionEvent arg0) {         
            	try {
           		 	ArrayList<Productbe> list2 = new ArrayList<Productbe>();
           		 	ta.setText("");
                	list2 = pr_Query(id);
                	ta.append("��ǰ ��ȣ	" + " ��ǰ ����	" + " ������ ���̵�	" + "\n");
                	for(int i=0;i<list2.size();i++) {
                		ta.append(list2.get(i).getuser_pr_id() + "	");
                		ta.append(Integer.toString(list2.get(i).getuser_pr_quan())+ "	");
                		ta.append(list2.get(i).getuser_id() + "\n");
                	}    
                }catch(ClassNotFoundException | SQLException f) {
                	f.printStackTrace();
                }
            }
        });
        
        btn6.addActionListener(new ActionListener() { // �ݾ�Ȯ��
            public void actionPerformed(ActionEvent arg0) {         
            	String[] into = tf.getText().split(" ");
            	try {
            		ArrayList<Productbe> list2 = new ArrayList<Productbe>();
           		 	ta.setText("");
                	list2 = user_money(id);       
                	ta.append("���� ���� �ݾ� \n");
                	for(int i=0;i<list2.size();i++) {               		
                		ta.append(Integer.toString(list2.get(i).getwallet())+ "	");  
                	}
            }catch(ClassNotFoundException | SQLException f) {
                	f.printStackTrace();
                }
            }
        });
        
        btn2.addActionListener(new ActionListener() { // �˻� �̺�Ʈ ó��
            public void actionPerformed(ActionEvent arg0) {         
            	try {
           		 	ArrayList<Productbe> list2 = new ArrayList<Productbe>();
           		 	ta.setText("");
           		 	ta.append("�˻��� �Ͻ� ���� �� �ؽ�Ʈ ĭ�� ���� �� �˻� ��ư�� �����ּ���\n\n");
           		 	String p_id = tf.getText();
                	list2 = Any_Query(panel, p_id);
                	ta.append("��ǰ ��ȣ	" + " ��ǰ �̸�	" + " ��ǰ ����	" + " ��ǰ ����	" + " ��ǰ �Ǹ��� ���̵� \n");
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
        btn3.addActionListener(new ActionListener() { // ����
            public void actionPerformed(ActionEvent arg0) { 
            	String[] into = tf.getText().split(" ");
            	try {
            		user_charge(Integer.parseInt(into[0]),id);
            }catch(ClassNotFoundException | SQLException f) {
                	f.printStackTrace();
                }
            }
        });
        
        btn4.addActionListener(new ActionListener() { // ����
            public void actionPerformed(ActionEvent arg0) {         
            	try {
            	user_buy(tf.getText(),id);
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
