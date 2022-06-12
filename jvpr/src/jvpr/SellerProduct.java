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
	    System.out.println("����");
	        
	    return conn;
	}
public ArrayList<Productbe> TotalQuery(JPanel panel, String seller_id) throws ClassNotFoundException, SQLException{ //��ü ��ǰ ����
    
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
public void Pr_insert(String pr_id,String pr_name,int pr_price,int pr_quan,String seller_id) throws ClassNotFoundException, SQLException{ //����
    
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
public void Pr_update(String pr_name,int pr_price,int pr_quan,String seller_id,String pr_id) throws ClassNotFoundException, SQLException{ //����
    
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
public void Pr_delete(String pr_id) throws ClassNotFoundException, SQLException{ //����
    
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

		setTitle("�Ǹ��� �α���");
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

        JButton btn6 = new JButton("��ǰ �߰�");
        panel.add(btn6);
        btn6.setBounds(550, 150, 150, 50);
        
        JButton btn2 = new JButton("�˻�");
        panel.add(btn2);
        btn2.setBounds(550, 250, 150, 50);


        JButton btn3 = new JButton("����");
        panel.add(btn3);
        btn3.setBounds(550, 350, 150, 50);


        JButton btn4 = new JButton("����");
        panel.add(btn4);
        btn4.setBounds(550, 450, 150, 50);


        JButton btn5 = new JButton("����");
        panel.add(btn5);
        btn5.setBounds(550, 550, 150, 50);
        setVisible(true);
        
        btn1.addActionListener(new ActionListener() { //��ü ��ǰ ���� �̺�Ʈ ó��
            public void actionPerformed(ActionEvent arg0) {         
            	try {
           		 	ArrayList<Productbe> list2 = new ArrayList<Productbe>();
           		 	ta.setText("");
                	list2 = TotalQuery(panel, id);
                	 ta.append("��ǰ �߰��ϴ� ��� ex)��ǰ��ȣ ��ǰ�̸� ��ǰ���� ��ǰ����\n");
                     ta.append("�ݵ�� ���⸦ ���ּ���\n\n\n");
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
        btn6.addActionListener(new ActionListener() { // �Է�
            public void actionPerformed(ActionEvent arg0) {         
            	String[] into = tf.getText().split(" ");
            	try {
            	Pr_insert(into[0],into[1],Integer.parseInt(into[2]),Integer.parseInt(into[3]),id);
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
            		Pr_update(into[1],Integer.parseInt(into[2]),Integer.parseInt(into[3]),id,into[0]);
            }catch(ClassNotFoundException | SQLException f) {
                	f.printStackTrace();
                }
            }
        });
        
        btn4.addActionListener(new ActionListener() { // ����
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
