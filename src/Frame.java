import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Frame {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JLabel label = new JLabel("MinSang");
		JButton btn1 = new JButton("Click me!");
		JButton btn2 = new JButton("Exit"); // 프로그램 종료 버튼
		JTextArea txtArea = new JTextArea(); // 한줄이상의 많은 글씨에 사
		JPanel btnPanel = new JPanel();
		panel.setLayout(new BorderLayout());

		btnPanel.add(btn1);
		btnPanel.add(btn2);
		panel.add(label, BorderLayout.NORTH);
		panel.add(btnPanel, BorderLayout.WEST); // 왼쪽에 버튼 추가
		panel.add(txtArea, BorderLayout.CENTER); // 많은 글씨니까 가운데 추가

		// 버튼1의 기능 추가
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				label.setText(txtArea.getText()); // 라벨로 txtarea에 텍스트 추가
				// txtArea.append("You are amazing!\n"); // 클릭시 글을 추가
			}

		});

		// 버튼2의 기능 추가
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0); // 종료
			}

		});

		frame.add(panel);

		frame.setResizable(false); // 화면 크기 수정 불가
		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(840, 840 / 12 * 9));
		frame.setSize(840, 840 / 12 * 9);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}