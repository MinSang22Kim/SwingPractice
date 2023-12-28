import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

// Design - Layouts - AbsouluteLayout으로 자유롭게 크기 지정
public class Designprc {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Designprc window = new Designprc();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the application.
	 */
	public Designprc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	// 사이즈 제한, 화면 가운데 발생 등은 코드로
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 471, 347); // x좌표 y좌표 x크기 y크기
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(330, 41, 123, 213);
		frame.getContentPane().add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 41, 158, 28);
		frame.getContentPane().add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(143, 42, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
