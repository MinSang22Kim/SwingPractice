package imglist;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;

public class DetailDialog extends javax.swing.JDialog {
	String[] itemDetails;
	DetailDialog(String[] texts) {
		super(GUIMain.frame, true);
		itemDetails = texts;
	}
	void setup() {
		setTitle("사용자 상세보기");
		JPanel lpane = new JPanel(new BorderLayout());
		ImageIcon photo = new ImageIcon(itemDetails[3]);
		Image scaleImage = photo.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
		photo = new ImageIcon(scaleImage);
		String detailStr = String.format("[%s]  %s %s원",  itemDetails[0],itemDetails[1],itemDetails[2]);
		JLabel details = new JLabel(detailStr);
		details.setPreferredSize(new Dimension(200, 30));
		details.setFont(new Font("굴림", Font.PLAIN, 13));
		details.setForeground(Color.blue);
		details.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel phframe = new JLabel(photo);
		lpane.add(phframe, BorderLayout.CENTER);
		lpane.add(details, BorderLayout.PAGE_END);
		this.setMinimumSize(new Dimension(250, 240));  // 대화상자 크기 설정
		setContentPane(lpane);
	}
}
