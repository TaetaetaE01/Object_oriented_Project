package mainFrame;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import constants.Constants.EMainClock;
import constants.Constants.ERegister;
import control.CFind;
import valueObject.VFind;
import valueObject.VFind1;
import valueObject.VRegister;
import valueObject.VUser;
import valueObject.VUserInfo;

public class Main extends JFrame implements Runnable {

	private PLoginDialog pLoginDialog;
	private PMainFrame pMainFrame = new PMainFrame();
	private PRegister pRegister;
	private PIdFind pIdFind;
	private PPwFind pPwFind;

	private Thread thread;
	private JLabel label;

	public Main() {
		this.pLoginDialog = new PLoginDialog(new ActionHandler());
		this.pLoginDialog.initialize();

		this.pRegister = new PRegister(new ActionHandler());

		this.pIdFind = new PIdFind(new ActionHandler());
		this.pPwFind = new PPwFind(new ActionHandler());

		setTitle(EMainClock.title.getText());
		setLayout(new FlowLayout());
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		label = new JLabel();
		label.setFont(new Font("Daum", Font.PLAIN, 20));
		if (thread == null) {

			thread = new Thread(this);
			thread.start();
		}
		add(label);
		setBounds(790, 10, 400, 80);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void intialize() {

	}

	// 다이어로그 로그인 버튼
	private void validateUser(Object source) {
		VUserInfo vUserInfo = this.pLoginDialog.validateUser1(source);

		if (vUserInfo != null) {
//			PMainFrame pMainFrame = new PMainFrame();
			this.pMainFrame.initialize(vUserInfo);
			this.pLoginDialog.dispose();
		}
	}

	// 다이어로그 회원가입 버튼
	private void Register(Object source) {
		boolean check = this.pLoginDialog.regiActionBtn(source);
		if (check == true) {
			this.pRegister.initialize();
		}
	}

	// 다이어로그 아이디 찾기 버튼
	private void idFind(Object source) {
		boolean check = this.pLoginDialog.idFindActionBtn(source);
		if (check == true) {
			this.pIdFind.initialize();
		}
	}

	// 다이어로그 비밀번호 찾기 버튼
	private void pwFind(Object source) {
		boolean check = this.pLoginDialog.pwFindActionBtn(source);
		if (check == true) {
			this.pPwFind.initialize();
		}
	}

	// 회원가입 회원가입 버튼
	private void Register1(Object source) {
		boolean hehe = this.pRegister.register(source);
		if (hehe == true) {
			this.pRegister.dispose();
			this.pLoginDialog.setVisible(true);
		}
	}

	// 회원가입 아이디 중복확인 버튼
	private void idConfirm(Object source) {
		this.pRegister.idConfirm(source);
	}

	// 회원가입 뒤로가기 버튼
	private void regiback(Object source) {
		boolean yes = pRegister.back(source);
		if (yes == true) {
			this.pRegister.dispose();
			this.pLoginDialog.setVisible(true);
		}
	}

	// 아이디 찾기 뒤로가기 버튼
	private void idFindback(Object source) {
		boolean yes = pIdFind.back(source);
		if (yes == true) {
			this.pIdFind.dispose();
			this.pLoginDialog.setVisible(true);
		}
	}

	// 아이디 찾기 찾기!
	private void idFind1(Object source) {
		VFind1 vFind1 = new VFind1();
		vFind1 = pIdFind.idFind(source);

		if (vFind1 != null) {
			CFind cFind = new CFind();
			VFind vFind = cFind.idFind(vFind1.getName(), vFind1.getStnum());
			if (vFind.getId() == null) {
				JOptionPane.showMessageDialog(null, "회원정보가 없습니다");
			} else {
				JOptionPane.showMessageDialog(null, "아이디는 " + vFind.getId() + " 입니다!");
			}
		}
	}

	// 비밀번호 찾기 뒤로가기 버튼
	private void pwFindback(Object source) {
		boolean yes = pPwFind.back(source);
		if (yes == true) {
			this.pPwFind.dispose();
			this.pLoginDialog.setVisible(true);
		}
	}

	// 비밀번호 찾기 찾기!
	private void pwFind1(Object source) {
		VFind1 vFind1 = new VFind1();
		vFind1 = pPwFind.pwFind(source);
		if (vFind1 != null) {
			CFind cFind = new CFind();
			VFind vFind = cFind.pwFind(vFind1.getId(), vFind1.getStnum());
			if (vFind.getPw() == null) {
				JOptionPane.showMessageDialog(null, "회원정보가 없습니다");
			} else {
				JOptionPane.showMessageDialog(null, "비밀번호는 " + vFind.getPw() + " 입니다!");
			}
		}
	}

	public class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			// 다이어로그 로그인 버튼
			validateUser(event.getSource());
			// 다이어로그 회원가입 버튼
			Register(event.getSource());
			// 다이어로그 아이디 찾기 버튼
			idFind(event.getSource());
			// 다이어로그 비밀번호 찾기 버튼
			pwFind(event.getSource());

			///////////////////////////////////////////////
			// 회원가입 회원가입 버튼
			Register1(event.getSource());
			// 회원가입 뒤로가기 버튼
			regiback(event.getSource());
			// 회원가입 ID 중복확인 버튼
			idConfirm(event.getSource());

			////////////////////////////////////////////////
			// 아이디 찾기 뒤로가기 버튼
			idFindback(event.getSource());
			// 아이디 찾기 찾기!
			idFind1(event.getSource());

			/////////////////////////////////////////////////
			// 비밀번호 찾기 뒤로가기 버튼
			pwFindback(event.getSource());
			// 비밀번호 찾기 찾기!
			pwFind1(event.getSource());
		}
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.intialize();
	}

	public void PCanlender() {
		run();
	}

	public void run() {
		while (true) {
			Calendar cal = Calendar.getInstance();
			String now = cal.get(Calendar.YEAR) + "년 " + (cal.get(Calendar.MONTH) + 1) + "월 " + cal.get(Calendar.DATE)
					+ "일 " + cal.get(Calendar.HOUR) + "시 " + cal.get(Calendar.MINUTE) + "분 " + cal.get(Calendar.SECOND)
					+ "초";
			label.setText(now);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
