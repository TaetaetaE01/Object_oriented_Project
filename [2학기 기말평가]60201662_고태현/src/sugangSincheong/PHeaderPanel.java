package sugangSincheong;

import javax.swing.JLabel;
import javax.swing.JPanel;

import valueObject.VUser;
import valueObject.VUserInfo;

public class PHeaderPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private JLabel wecomeLabel;

	public PHeaderPanel() {
		this.wecomeLabel = new JLabel();
		this.add(this.wecomeLabel);
	}

	public void intialize(VUserInfo vUserInfo) {
		this.wecomeLabel.setText(vUserInfo.getName() + "님 환영합니다.");
	}
}
