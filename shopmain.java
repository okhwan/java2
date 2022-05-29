package java_project_shop;
import javax.swing.*;
import java.awt.*;

public class shopmain extends JFrame{
	
	public shopmain() {
		setTitle("아가랑 쇼핑몰");
		Container c = getContentPane();
		c.setLayout(null);
		JLabel jl = new JLabel();
		jl.setBounds(512, 76, 50, 50);
		jl.setText("아가랑 회원");
		c.add(jl);
		setSize(1024, 768);
		JButton b = new JButton("회원가입");
		b.setLocation(100,50);
		b.setSize(200,100);
		c.add(b);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new shopmain();
	}

}
