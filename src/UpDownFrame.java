import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpDownFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	final String labelPrefix = "<html><body><h1>";
	JTextField input = new JTextField("0", 20);
	JLabel bottomLabel = new JLabel(labelPrefix);

	// GUI 구성 요소를 프레임에 추가하는 메서드
	public void addComponentsToPane() {
		setTitle("Up Down Test");
		Container pane = getContentPane();

		// 입력 필드 및 버튼이 있는 상단 패널
		JPanel top = new JPanel();
		JButton up = new JButton("UP");
		JButton down = new JButton("DOWN");
		JButton reset = new JButton("RESET");
		JButton record = new JButton("RECORD");
		top.setPreferredSize(new Dimension(300, 40));
		top.add(input);
		pane.add(top, BorderLayout.PAGE_START);

		// UP, DOWN, RESET 버튼이 있는 중앙 패널
		JPanel center = new JPanel(new GridLayout(1, 2));
		center.add(down, BorderLayout.CENTER);
		center.add(reset, BorderLayout.CENTER);

		// 컴포넌트를 프레임에 추가
		pane.add(up, BorderLayout.LINE_START);
		pane.add(center, BorderLayout.CENTER);
		pane.add(record, BorderLayout.LINE_END);

		// 버튼에 대한 액션 리스너 추가
		ActionListener listener = new ButtonListener();
		up.addActionListener(listener);
		down.addActionListener(listener);
		record.addActionListener(listener);
		reset.addActionListener(listener);

		// 레코드를 표시하는 하단 패널
		bottom.add(bottomLabel);
		bottom.setPreferredSize(new Dimension(300, 200));
		pane.add(bottom, BorderLayout.PAGE_END);
	}

	JPanel bottom = new JPanel();
	int count = 1;
	int last = 0;

	// GUI를 초기화하고 표시하는 메서드
	private void createAndShowGUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addComponentsToPane();
		setPreferredSize(new Dimension(300, 300));
		pack();
		setVisible(true);
	}

	// 애플리케이션을 실행하는 주요 메서드
	public static void main(String[] args) {
		UpDownFrame frame = new UpDownFrame();
		frame.createAndShowGUI();
	}

	// 버튼 클릭에 대한 ActionListener
	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String buttonName = e.getActionCommand();
			int result = Integer.parseInt(input.getText());

			// 버튼 클릭에 따라 동작을 수행하는 switch 문
			switch (buttonName) {
			case "UP":
				result++;
				break;
			case "DOWN":
				result--;
				break;
			case "RESET":
				result = 0;
				bottomLabel.setText(labelPrefix);
				bottom.setBackground(Color.white);
				break;
			case "RECORD":
				int gap = result - last;
				String line = String.format("[%d] %d (%+d)<br/>", count, result, gap);
				count++;
				last = result;
				String showValue = bottomLabel.getText() + line;
				bottomLabel.setText(showValue);
				bottom.setBackground(getRandomColor());
			}
			input.setText("" + result);
		}
	}

	Random rand = new Random();

	// 무작위 색상을 생성하는 메서드
	private Color getRandomColor() {
		return new Color(rand.nextInt(125, 256), rand.nextInt(125, 256), rand.nextInt(125, 256));
	}
}
