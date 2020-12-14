package sugangSincheong;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("unused")
public class PFooterPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton saveBtn;
	private JButton chincheongBtn;
	private JButton mridamgiBtn;
	private JButton captureBtn;
	private JButton homepageBtn;

	public PFooterPanel(sugangSincheong.PSugangSincheongPanel.ActionHandler actionHandler) {
		MyMouseListener listener = new MyMouseListener();

		// 저장 버튼
		this.saveBtn = new JButton("서버에 저장하기");
		this.saveBtn.addActionListener(actionHandler);
		this.add(saveBtn);

		this.captureBtn = new JButton("캡 쳐");
		this.captureBtn.addActionListener(actionHandler);
		this.add(this.captureBtn);

		this.mridamgiBtn = new JButton("미리담기 학점 확인");
		this.mridamgiBtn.addActionListener(actionHandler);
		this.add(this.mridamgiBtn);

		this.chincheongBtn = new JButton("수강신청 학점 확인");
		this.chincheongBtn.addActionListener(actionHandler);
		this.add(this.chincheongBtn);

		ImageIcon img = new ImageIcon("111.png");
		this.homepageBtn = new JButton(img);
		this.homepageBtn.addMouseListener(listener);

		this.add(this.homepageBtn);

	}

	class MyMouseListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			if (Desktop.isDesktopSupported()) {
				Desktop desktop = Desktop.getDesktop();
				try {
					URI uri = new URI("https://www.mju.ac.kr/sites/mjukr/intro/intro.html");
					desktop.browse(uri);
				} catch (IOException ex) {
					ex.printStackTrace();
				} catch (URISyntaxException ex) {
					ex.printStackTrace();
				}
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			JButton homepageBtn = (JButton) e.getSource();
			ImageIcon img1 = new ImageIcon("222.png");
			homepageBtn.setIcon(img1);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			JButton homepageBtn = (JButton) e.getSource();
			ImageIcon img = new ImageIcon("111.png");
			homepageBtn.setIcon(img);
		}

	}

	public void intialize() {

	}

	public boolean save(Object eventSource) {
		boolean yes = false;
		if (eventSource.equals(this.saveBtn)) {
			yes = true;
		}
		return yes;
	}

	public boolean chincheongCredit(Object eventSource) {
		boolean yes = false;
		if (eventSource.equals(this.chincheongBtn)) {
			yes = true;
		}
		return yes;
	}

	public boolean miridamgiCredit(Object eventSource) {
		boolean yes = false;
		if (eventSource.equals(this.mridamgiBtn)) {
			yes = true;
		}
		return yes;
	}

	public boolean captureBtn(Object eventSource) {
		boolean yes = false;
		if (eventSource.equals(this.captureBtn)) {
			yes = true;
		}
		return yes;
	}

}
