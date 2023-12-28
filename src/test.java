import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class test extends JPanel {

	private JFrame frame;

	private int index; // 현재 인덱스 저장용
	private static final String[] IMAGES = { // 이미지 경로 문자열로 저장
			"image/NewJeans.jpg" };

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public test() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		Font font = new Font("굴림", Font.BOLD, 48);

		JLabel lblImage = new JLabel();
		lblImage.setBounds(93, 10, 256, 256);
		frame.getContentPane().add(lblImage);

		JButton btnPrev = new JButton("이전");
		btnPrev.setFont(font);
		btnPrev.setBounds(56, 321, 141, 80);
		frame.getContentPane().add(btnPrev);

		JButton btnNext = new JButton("다음");
		btnNext.setFont(font);
		btnNext.setBounds(245, 321, 141, 80);
		frame.getContentPane().add(btnNext);
	}

}