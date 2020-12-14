package mainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import constants.Constants;
import constants.Constants.EFileMenu;
import mainFrame.Main.ActionHandler;
import valueObject.VUserInfo;

public class PFileMenu extends JMenu implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JMenuItem logoutItem;
	private JMenuItem personalInfoItem;
	private VUserInfo vUserInfo;

	private PMenuPersonalInfo pMenuPersonalInfo;

	public PFileMenu(VUserInfo vUserInfo) {
		this.vUserInfo = vUserInfo;

		// attributes
		this.setText(Constants.EMenuBar.eFile.getText());

		// components
		this.personalInfoItem = new JMenuItem(EFileMenu.ePersonalInfo.getText());
		this.personalInfoItem.addActionListener(this);
		this.add(this.personalInfoItem);

		this.logoutItem = new JMenuItem(EFileMenu.eLogiout.getText());
		this.logoutItem.addActionListener(this);
		this.add(this.logoutItem);

	}

	private void change(Object source) {
		boolean yes = pMenuPersonalInfo.change(source);
		if (yes == true) {
			this.pMenuPersonalInfo.dispose();

			PChangePw pChangePw = new PChangePw(vUserInfo);
			pChangePw.setVisible(true);
		}
	}

	private void confirm(Object source) {
		boolean yes = pMenuPersonalInfo.confirm(source);
		if (yes == true) {
			this.pMenuPersonalInfo.dispose();
			PConfirmPw pConfirmPw = new PConfirmPw(vUserInfo);
			pConfirmPw.setVisible(true);
		}
	}

	private void back(Object source) {
		boolean yes = pMenuPersonalInfo.back(source);
		if (yes == true) {
			this.pMenuPersonalInfo.dispose();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean yes = false;
		// 개인정보
		if (e.getSource() == personalInfoItem) {
			this.pMenuPersonalInfo = new PMenuPersonalInfo(this.vUserInfo, new ActionHandler());
			this.pMenuPersonalInfo.setVisible(true);
		} else if (e.getSource() == logoutItem) {
			yes = true;
//			Main main = new Main();
//			main.yes(yes);
		}
	}

	public class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			back(event.getSource());
			confirm(event.getSource());
			change(event.getSource());
		}
	}

}
