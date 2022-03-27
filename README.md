3주차
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
		jl.setText("아가랑");
		c.add(jl);
		setSize(1024, 768);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new shopmain();
	}

}

----------
# java2
자바 프로젝트는 안드로이드를 활용하여 쇼핑몰 앱 버전을 구현할 것입니다.
조금 진행중이긴하고 1학기내에 끝내지 못할 수 있지만 이전부터 구상해오던 프로젝트 이기 때문에 병행할겸 프로젝트를 제출하겠습니다.
기존 안드로이드로 진행중이던 제품 제출하려고했는데 4학년 1학기 때 안드로이드를 배우는데
자바 수업 때 안드로이드로 제출하는 것은 다르다고 생각해서 자바 swing으로 다시 작성하려고 합니다!!
