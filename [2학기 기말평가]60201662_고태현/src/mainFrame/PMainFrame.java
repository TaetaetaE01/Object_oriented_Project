package mainFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import constants.Constants;
import constants.Constants.ELoginDialog;
import constants.Constants.EMainFrame;
import mainFrame.Main.ActionHandler;
import sugangSincheong.PPlan;
import sugangSincheong.PSugangSincheongPanel;
import valueObject.VUser;
import valueObject.VUserInfo;

public class PMainFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	// components
	private PMenuBar pMenuBar;
	private PToolBar pToolBar;
	private PSugangSincheongPanel pSugangSincheongPanel;

	// utility
	private WindowsHandler windowsHandler;

	// ValueObject
	private VUserInfo vUserInfo;

	// constructor
	public PMainFrame() {
		// attributes
		this.setSize(EMainFrame.width.getInt(), EMainFrame.height.getInt());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.setLayout(new BorderLayout());

		// utility
		this.windowsHandler = new WindowsHandler();
		this.addWindowListener(this.windowsHandler);

		// components
		this.pMenuBar = new PMenuBar();
		this.setJMenuBar(this.pMenuBar);

		this.pToolBar = new PToolBar(new ActionHandler());
		this.add(this.pToolBar, BorderLayout.NORTH);

		this.pSugangSincheongPanel = new PSugangSincheongPanel();
		this.add(this.pSugangSincheongPanel, BorderLayout.CENTER);
	}

	public void initialize(VUserInfo vUserInfo) {
		this.vUserInfo = vUserInfo;

		this.setVisible(true);

		this.pMenuBar.initialize(this.vUserInfo);
		this.pToolBar.initialize(this.vUserInfo);
		this.pSugangSincheongPanel.initialize(this.vUserInfo);

	}

	// 저장
	private void finish() {
		this.pSugangSincheongPanel.finish();
	}

	// 강의 계획서 버튼 -> 여기 디스포즈 어케시키누,,
	private void actionPlan(Object source) {
		boolean yes = pToolBar.actionPlan(source);
		if (yes == true) {
			PPlan pPlan = new PPlan();
			pPlan.setVisible(true);
		}
	}

	public class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			actionPlan(event.getSource());
		}
	}

	private class WindowsHandler implements WindowListener {

		@Override
		public void windowOpened(WindowEvent e) {

		}

		@Override
		public void windowClosing(WindowEvent e) {
//			finish();
		}

		@Override
		public void windowClosed(WindowEvent e) {

		}

		@Override
		public void windowIconified(WindowEvent e) {

		}

		@Override
		public void windowDeiconified(WindowEvent e) {

		}

		@Override
		public void windowActivated(WindowEvent e) {

		}

		@Override
		public void windowDeactivated(WindowEvent e) {

		}

	}
}
