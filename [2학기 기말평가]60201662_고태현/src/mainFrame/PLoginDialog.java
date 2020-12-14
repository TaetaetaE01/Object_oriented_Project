package mainFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import constants.Constants.ELoginDialog;
import control.CLogin;
import control.CUser;
import mainFrame.Main.ActionHandler;
import valueObject.VLogin;
import valueObject.VUser;
import valueObject.VUserInfo;

public class PLoginDialog extends JFrame {
	private static final long serialVersionUID = 1L;

	int count = 0;
	int count2 = 2;

	// components
	private JLabel nameLabel;
	private JTextField nameText;
	private JLabel passwordLabel;
	private JPasswordField passwordText;
	private JButton okButton;
	private JButton cancelButton;
	private JButton registerPerBtn;
	private JButton idFnBtn;
	private JButton pwFnBtn;
	private JLabel imagelabel;

	// control
	private CLogin cLogin;
	private CUser cUser;

	public PLoginDialog(ActionHandler actionHandler) {
		this.setSize(ELoginDialog.width.getInt(), ELoginDialog.height.getInt());
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle(ELoginDialog.title.getText());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setBackground(Color.white);

		JPanel line = new JPanel();

		line.setBackground(Color.white);
		this.setContentPane(line);
		this.setLayout(null);

		this.nameLabel = new JLabel(ELoginDialog.nameLabel.getText());
		line.add(this.nameLabel);
		this.nameLabel.setBounds(301, 102, 30, 28);

		this.nameText = new JTextField();
		this.nameText.setColumns(ELoginDialog.sizeNameText.getInt());
		line.add(this.nameText);
		this.nameText.setBounds(336, 96, 154, 41);

		this.passwordLabel = new JLabel(ELoginDialog.passwordLabel.getText());
		line.add(this.passwordLabel);
		this.passwordLabel.setBounds(270, 153, 89, 28);

		this.passwordText = new JPasswordField();
		this.passwordText.setColumns(ELoginDialog.sizePasswordText.getInt());
		line.add(this.passwordText);
		this.passwordText.setBounds(336, 147, 154, 41);

		this.okButton = new JButton(ELoginDialog.okButtonLabel.getText());
		this.okButton.addActionListener(actionHandler);
		this.getRootPane().setDefaultButton(this.okButton);
		line.add(this.okButton);
		this.okButton.setBounds(235, 230, 127, 32);

		// 회원가입 버튼
		this.registerPerBtn = new JButton(ELoginDialog.registerButtonLabel.getText());
		this.registerPerBtn.addActionListener(actionHandler);
		line.add(this.registerPerBtn);
		this.registerPerBtn.setBounds(374, 230, 127, 32);

		this.idFnBtn = new JButton(ELoginDialog.idFnButtonLable.getText());
		this.idFnBtn.addActionListener(actionHandler);
		line.add(this.idFnBtn);
		this.idFnBtn.setBounds(235, 272, 127, 23);

		this.pwFnBtn = new JButton(ELoginDialog.pwFnButtonLable.getText());
		this.pwFnBtn.addActionListener(actionHandler);
		line.add(this.pwFnBtn);
		this.pwFnBtn.setBounds(374, 272, 127, 23);

		// 다이어로그 이미지 라벨
		this.imagelabel = new JLabel(" ");
		imagelabel.setIcon(new ImageIcon("loginimage.gif"));
		line.add(imagelabel);
		imagelabel.setBounds(43, 53, 192, 194);

//      this.cancelButton = new JButton(ELoginDialog.cancelButtonLabel.getText());
//		this.cancelButton.addActionListener(actionHandler);
//		line.add(this.cancelButton);

//		this.add(line, BorderLayout.SOUTH);

		this.cLogin = new CLogin();
		this.cUser = new CUser();
	}

	public void initialize() {
		this.setVisible(true);
	}

	// 로그인 버튼
	public VUserInfo validateUser1(Object eventSource) {

		VLogin vLogin = new VLogin();
		VUserInfo vUserInfo = null;

		vLogin.setUserId(this.nameText.getText());
		vLogin.setPassword(this.passwordText.getText());

		if (eventSource.equals(this.okButton)) {
			CLogin cLogin = new CLogin();

			if (vLogin.getUserId().equals("") || vLogin.getPassword().equals("")) {
				// 로그인 정보에 빈칸
				JOptionPane.showMessageDialog(null, ELoginDialog.lginFailed3.getText());
			} else {

				int check = cLogin.validateUser2(vLogin);

				if (check == 1) {
					// 로그인 정상 작동
					vUserInfo = cLogin.validateUser1(vLogin);
					JOptionPane.showMessageDialog(null, vUserInfo.getName() + ELoginDialog.lginSuccess.getText());
				} else if (count > 2) {
					JOptionPane.showMessageDialog(null, ELoginDialog.error.getText());
					count2 = 2;

					PFailure pFailure = new PFailure();
					pFailure.PFailure();

					System.exit(0);
				} else if (check == 2) {
					// 아이디와 패스워드가 틀림
					JOptionPane.showMessageDialog(this, ELoginDialog.lginFailed1.getText());
					count++;
					count2--;
				} else {
					// 사용자 정보가 존재 하지 않는 것
					JOptionPane.showMessageDialog(this, ELoginDialog.lginFailed2.getText());
					count++;
					count2--;
				}
			}
		}
		return vUserInfo;
	}

	// 회원가입 버튼
	public boolean regiActionBtn(Object eventSource) {
		boolean check = false;
		if (eventSource.equals(this.registerPerBtn)) {
			check = true;
		}
		return check;
	}

	// 아이디 찾기 버튼
	public boolean idFindActionBtn(Object eventSource) {
		boolean check = false;
		if (eventSource.equals(this.idFnBtn)) {
			check = true;
		}
		return check;
	}

	// 비밀번호 찾기 버튼
	public boolean pwFindActionBtn(Object eventSource) {
		boolean check = false;
		if (eventSource.equals(this.pwFnBtn)) {
			check = true;
		}
		return check;
	}

}
