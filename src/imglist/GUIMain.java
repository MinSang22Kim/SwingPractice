package imglist;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import facade.DataEngineImpl;
import facade.UIData;
import item.ItemMgr;

public class GUIMain {
	private static GUIMain main = null;
	private GUIMain() {}
	public static GUIMain getInstance() {
		if (main == null)
			main = new GUIMain();
		return main;
	}
    /**
     * GUI를 생성하여 보여준다. 스레드 안전을 위하여
     * 이 메소드는 이벤트 처리 스레드에서 불려져야 한다.
     */
	static JFrame frame = new JFrame();
    private void createAndShowGUI() {
        // 탭을 생성하고 두개 패널을 추가한다.
   		JPanel content = new JPanel();
   		init(content);
   		JScrollPane scroll = new JScrollPane(content);
   		scroll.setPreferredSize(new Dimension(1200, 600));

   		frame.add(scroll);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        //frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
	void init(JPanel pane) {
		pane.setLayout(new GridLayout(4, 4));
		List<?> itemlist = ItemMgr.getInstance().search("");
		for (Object o: itemlist) {
			pane.add(new ImageCell((UIData)o));
		}
	}
    public static void startGUI() {
        // 이벤트 처리 스레드를 만들고 
        // 거기서 GUI를 생성하고 보여준다.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GUIMain.getInstance().createAndShowGUI();
            }
        });
    }
	DataEngineImpl<?> engine = ItemMgr.getInstance();
	public static void main(String args[]) {
	    startGUI();
	}
}