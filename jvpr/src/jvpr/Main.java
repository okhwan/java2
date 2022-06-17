package jvpr;

import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Main extends JFrame{

    sellerLogin seller;
    userLogin user;
    Main marin;
    private JButton JB1, JB2;
    JPanel JP1, JP2;
   
    
    public void chooseone(JPanel panel){
    
        JB2 = new JButton("판매자 로그인");
        JB2.setBounds(300, 80, 200, 70);
        panel.add(JB2);
        JB2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	sellLoginMonitor();
            	marin.dispose();
            }
        });
        
        JB1 = new JButton("구매자 로그인");
        JB1.setBounds(50, 80, 200, 70);
        panel.add(JB1);
        JB1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	userLoginMonitor();
            	marin.dispose();
            }
        });
    }
    
    public void sellLoginMonitor(){
    	seller = new sellerLogin();
    	seller.ShowFrame(seller);
    }
    
    public void userLoginMonitor(){
    	user = new userLogin();
    	user.ShowFrame(user);
    }
    
    public Main() {
    	setTitle("판매자");
        setSize(550, 250);
        setLocation(650, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       
        JPanel panel = new JPanel();
        panel.setLayout(null);
        chooseone(panel);   
        add(panel);
        setVisible(true);
    }
    public void setMain(Main main) {
        marin = main;
    }
    
    
    public static void main(String[] args) {
        
        Main main = new Main();
        main.setMain(main);
        
        
    }
   
}