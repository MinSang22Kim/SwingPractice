import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

class ImagePanel extends JPanel {
	private Image img;

	public ImagePanel(Image img) {
		this.img = img;
		setSize(new Dimension(img.getWidth(null), img.getHeight(null))); // 최대값으로 설정
		setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setLayout(null); // 원하는대로 조정가능
	}

	// 패널 열었을 때 자동으로 이미지를 보여줌
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null); // x시작 y시작 null
	}

}

//실질적인 이미지 보여주게 하는 클래스
// New Source Folder로 image 넣는 파잉ㄹ 생성 후 이미지 저장
public class ImagePractice {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Image");
		frame.setSize(640, 480);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		ImagePanel panel = new ImagePanel(new ImageIcon("./image/NewJeans.jpg").getImage());
		File f = new File("./image/NewJeans.jpg");
		System.out.println(f.exists() ? "Exists" : "not Exists");
		frame.add(panel);
		frame.pack(); // 이미지 사이즈에 맞게 패널 조정

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}