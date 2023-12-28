import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class QuizApp {

	private JFrame frame;
	private JTextField answer;
	int lifeRemaining = 5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// 애플리케이션을 실행하는 메인 메소드
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuizApp window = new QuizApp();
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
	public QuizApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// 게임 초기화 메소드
		int randomNumber = (int) (Math.random() * 30) + 1; // 1에서 30까지의 랜덤한 숫자 생성
		System.out.println(randomNumber);
		frame = new JFrame();
		frame.setBounds(100, 100, 1044, 621);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1026, 574);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel life = new JLabel("Life : " + lifeRemaining); // 남은 목숨을 나타내는 라벨
		life.setFont(new Font("Tahoma", Font.PLAIN, 40));
		life.setBounds(34, 23, 213, 46);
		panel.add(life);

		JLabel lblPickANumber = new JLabel("Pick A number from 1 - 30"); // 사용자에게 안내하는 라벨
		lblPickANumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblPickANumber.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblPickANumber.setBounds(162, 103, 715, 46);
		panel.add(lblPickANumber);

		answer = new JTextField(); // 사용자의 입력을 받는 텍스트 필드
		answer.setHorizontalAlignment(SwingConstants.CENTER);
		answer.setFont(new Font("Tahoma", Font.PLAIN, 42));
		answer.setBounds(162, 272, 721, 63);
		panel.add(answer);
		answer.setColumns(10);

		JButton guess = new JButton("G U E S S"); // 숫자를 맞추기 위한 버튼
		guess.setFont(new Font("Tahoma", Font.PLAIN, 50));
		guess.setBounds(162, 364, 721, 63);
		panel.add(guess);

		JLabel res = new JLabel("Good Luck!"); // 결과를 표시하는 라벨
		res.setForeground(Color.BLUE);
		res.setFont(new Font("Tahoma", Font.PLAIN, 42));
		res.setHorizontalAlignment(SwingConstants.CENTER);
		res.setBounds(162, 469, 721, 57);
		panel.add(res);

		guess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int ans = Integer.parseInt(answer.getText()); // 사용자가 입력한 숫자
				if (lifeRemaining <= 0) {
					res.setText("You lost"); // 목숨이 0이면 게임 종료
					return;
				}
				if (ans == randomNumber) {
					System.out.println("You got it right"); // 정답을 맞추면 게임 종료
					System.exit(0);
				}
				life.setText("Life : " + --lifeRemaining); // 남은 목숨 감소
				res.setForeground(Color.RED);
				if (ans > randomNumber) {
					res.setText("Too much"); // 입력한 숫자가 정답보다 크면 안내
				} else {
					res.setText("Too little"); // 입력한 숫자가 정답보다 작으면 안내
				}
			}
		});
	}
}
