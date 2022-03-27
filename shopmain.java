package java_project_shop;
import javax.swing.*;
import java.awt.*;

public class shopmain extends JFrame{
	
	public shopmain() {
		setTitle("¾Æ°¡¶û ¼îÇÎ¸ô");
		Container c = getContentPane();
		c.setLayout(null);
		JLabel jl = new JLabel();
		jl.setBounds(512, 76, 50, 50);
		jl.setText("¾Æ°¡¶û");
		c.add(jl);
		setSize(1024, 768);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new shopmain();
	}

}
