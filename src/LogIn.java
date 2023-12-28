import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

// JFrame은 기본 제공
public class LogIn extends JFrame {
	public LogIn() {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("ID : ");
		JLabel pswrd = new JLabel("Password : ");
		JTextField txtID = new JTextField(10); // 아이디 필드 최대 10자
		JPasswordField txtPass = new JPasswordField(10); // JpwField는 암호화된 것처럼 보여줌
		JButton logBtn = new JButton("Log In");

		panel.add(label);
		panel.add(txtID);
		panel.add(pswrd);
		panel.add(txtPass);
		panel.add(logBtn);

		logBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = "ms0217";
				String pass = "1234";

				if (id.equals(txtID.getText()) && pass.equals(txtPass.getText())) {
					JOptionPane.showMessageDialog(null, "You have logged in Successfully!");
				}
			}

		});

		add(panel);

		setVisible(true); // 상단 프레임을 볼 수 있게 해줌
		setSize(600, 400); // 화면 크기 설정
		setLocationRelativeTo(null); // 실행창 가운데에서 실행
		setResizable(false); // 화면 크기 조정 불가
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 화면 종료 시 실행도 같이 꺼지게

	}

	public static void main(String[] args) {
		new LogIn();
	}
}