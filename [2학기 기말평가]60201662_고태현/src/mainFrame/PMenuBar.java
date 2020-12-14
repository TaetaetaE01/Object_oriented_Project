package mainFrame;

import javax.swing.JMenuBar;

import valueObject.VUserInfo;

public class PMenuBar extends JMenuBar {
	private static final long serialVersionUID = 1L;

	private PFileMenu pFileMenu;
	private VUserInfo vUserInfo;

	public PMenuBar() {

	}

	public void initialize(VUserInfo vUserInfo) {
		this.vUserInfo = vUserInfo;

		this.pFileMenu = new PFileMenu(this.vUserInfo);
		this.add(this.pFileMenu);
	}
}
