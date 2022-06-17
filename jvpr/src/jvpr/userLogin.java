package jvpr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField; 



public class userLogin extends JFrame {
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
	
	private JButton login_button;
    private JPasswordField pw_text;
    private JButton in_button; 
    private JTextField id_text;
    userProduct product;
    userLogin user;
    


	public void setuser(userLogin user) {
		this.user = user;
	}
	public void ShowFrame(userLogin user) {
		setuser(user);
    	setTitle("구매자 로그인");
        setSize(550, 250);
        setLocation(650, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       
        JPanel panel = new JPanel(); 
        userLoginPanel(panel);
        add(panel);
        setVisible(true);
 
    }
	public void userLoginCheck() throws ClassNotFoundException, SQLException{
		 Connection conn = getConnection();
		 String sql = "select * from user where id =? and pw = ?";
		 PreparedStatement pstmt = conn.prepareStatement(sql);
		 pstmt = conn.prepareStatement(sql);
		 pstmt.setString(1,id_text.getText());
		 pstmt.setString(2,pw_text.getText());
		 ResultSet rs = pstmt.executeQuery();
		 if(rs.next()) {
			 product = new userProduct();
			 product.ShowFrame(rs.getString("id"));
			 user.dispose();
		 }
		 
	 }
	
	 public void userLoginPanel(JPanel panel){
	        panel.setLayout(null);     
	        JLabel idlabel = new JLabel("ID :");
	        idlabel.setBounds(170, 20, 80, 25);
	        panel.add(idlabel);
	        
	        id_text = new JTextField(20);
	        id_text.setBounds(220, 20, 160, 25);
	        panel.add(id_text);
	       
	        JLabel pwlabel = new JLabel("PW :");
	        pwlabel.setBounds(170, 65, 80, 25);
	        panel.add(pwlabel);
	        
	        pw_text = new JPasswordField(20);
	        pw_text.setBounds(220, 65, 160, 25);
	        panel.add(pw_text);
	        
	        login_button = new JButton("로그인");
	        login_button.setBounds(230, 120, 100, 20);
	        panel.add(login_button);
	        login_button.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e){
	            	try {
	            	userLoginCheck();
	            	}catch(ClassNotFoundException | SQLException f) {
	            		f.printStackTrace();
	            	}
     
	        }	            	 
	        });
	
	 }
	 
}
