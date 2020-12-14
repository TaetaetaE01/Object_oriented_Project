package mainFrame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import constants.Constants.ERegister;
import control.CRegister;
import mainFrame.Main.ActionHandler;
import valueObject.VRegister;
import valueObject.VUser;

public class PRegister extends JFrame {
	private static final long serialVersionUID = 1L;

	private boolean click = false;

	private JLabel idLabel;
	private JTextField idText1;
	private JLabel passwordLabel;
	private JPasswordField passwordField;
	private JLabel pwConfirmLabel;
	private JPasswordField pwConfirmField;
	private JLabel nameLabel;
	private JTextField nameText;
	private JLabel stNumLabel;
	private JTextField stNumText;
	private JLabel emailLabel;
	private JTextField emailText;
	private JLabel telLabel;
	private JTextField telText;
	private JLabel birthLabel;
	private JTextField birthText;
	private JLabel telMessage;
	private JLabel birthMessage;
	private JButton backBtn;
	private JButton registerBtn;
	private JButton idConfirmBtn;
	private JLabel imagelabel;
	private JRadioButton seoulRadio;
	private JRadioButton yoninRadio;
	private JCheckBox infoConfirmCheck;
	private ButtonGroup group;

	public PRegister(ActionHandler actionHandler) {

		this.setSize(ERegister.width.getInt(), ERegister.height.getInt());
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle(ERegister.title.getText());
		
		JPanel line = new JPanel();

		line.setBackground(Color.white);
		this.setContentPane(line);
		this.setLayout(null);

		// 아이디
		this.idLabel = new JLabel(ERegister.idLabel.getText());
		this.idLabel.setFont(new Font("굴림", Font.PLAIN, 13));
		line.add(this.idLabel);
		this.idLabel.setBounds(109, 148, 24, 37);

		this.idText1 = new JTextField();
		this.idText1.setBounds(158, 153, 148, 27);
		line.add(this.idText1);
		this.idText1.setColumns(ERegister.sizeNameText.getInt());

		// 비밀번호
		this.passwordLabel = new JLabel(ERegister.passwordLabel.getText());
		line.add(this.passwordLabel);
		this.passwordLabel.setFont(new Font("굴림", Font.PLAIN, 13));
		this.passwordLabel.setBounds(98, 212, 47, 27);

		this.passwordField = new JPasswordField();
		this.passwordField.setColumns(ERegister.sizePasswordText.getInt());
		line.add(this.passwordField);
		this.passwordField.setBounds(158, 208, 148, 27);

		// 비밀번호 확인
		this.pwConfirmLabel = new JLabel(ERegister.passwordConfirmLabel.getText());
		line.add(this.pwConfirmLabel);
		this.pwConfirmLabel.setFont(new Font("굴림", Font.PLAIN, 13));
		this.pwConfirmLabel.setBounds(68, 264, 73, 21);

		this.pwConfirmField = new JPasswordField();
		this.pwConfirmField.setColumns(ERegister.sizePasswordText.getInt());
		line.add(this.pwConfirmField);
		this.pwConfirmField.setBounds(158, 261, 148, 27);

		// 이름
		this.nameLabel = new JLabel(ERegister.nameLabel.getText());
		line.add(this.nameLabel);
		this.nameLabel.setFont(new Font("굴림", Font.PLAIN, 13));
		this.nameLabel.setBounds(85, 308, 72, 27);

		this.nameText = new JTextField();
		this.nameText.setColumns(ERegister.sizeNameText.getInt());
		line.add(this.nameText);
		this.nameText.setBounds(158, 308, 148, 27);

		// 학번
		this.stNumLabel = new JLabel(ERegister.stNumLabel.getText());
		line.add(this.stNumLabel);
		this.stNumLabel.setFont(new Font("굴림", Font.PLAIN, 13));
		this.stNumLabel.setBounds(98, 358, 57, 27);

		this.stNumText = new JTextField();
		this.stNumText.setColumns(ERegister.sizeNameText.getInt());
		line.add(this.stNumText);
		this.stNumText.setBounds(158, 358, 148, 27);

		// 이메일
		this.emailLabel = new JLabel(ERegister.emailLabel.getText());
		line.add(this.emailLabel);
		this.emailLabel.setFont(new Font("굴림", Font.PLAIN, 13));
		this.emailLabel.setBounds(85, 416, 61, 21);

		this.emailText = new JTextField();
		this.emailText.setColumns(ERegister.sizeNameText.getInt());
		line.add(this.emailText);
		this.emailText.setBounds(158, 413, 148, 27);

		// 전화번호
		this.telLabel = new JLabel(ERegister.telLabel.getText());
		line.add(this.telLabel);
		this.telLabel.setFont(new Font("굴림", Font.PLAIN, 13));
		this.telLabel.setBounds(74, 460, 72, 27);

		this.telText = new JTextField();
		this.telText.setColumns(ERegister.sizeNameText.getInt());
		line.add(this.telText);
		this.telText.setBounds(158, 460, 148, 27);

		// 생년월일
		this.birthLabel = new JLabel(ERegister.birthLabel.getText());
		line.add(this.birthLabel);
		this.birthLabel.setFont(new Font("굴림", Font.PLAIN, 13));
		this.birthLabel.setBounds(74, 509, 72, 27);

		this.birthText = new JTextField();
		this.birthText.setColumns(ERegister.sizeNameText.getInt());
		line.add(this.birthText);
		this.birthText.setBounds(158, 509, 148, 27);

		// 생일 메세지
		this.birthMessage = new JLabel(ERegister.birthMessage.getText());
		line.add(this.birthMessage);
		this.birthMessage.setBounds(318, 515, 101, 15);

		// 전화번호 메세지
		this.telMessage = new JLabel(ERegister.telMessage.getText());
		line.add(this.telMessage);
		this.telMessage.setBounds(318, 466, 101, 15);

		// 뒤로가기 버튼
		this.backBtn = new JButton(ERegister.backButtonLabel.getText());
		this.backBtn.addActionListener(actionHandler);
		line.add(this.backBtn);
		this.backBtn.setBounds(110, 620, 112, 27);

		// 회원 가입 버튼
		this.registerBtn = new JButton(ERegister.registerButtonLabel.getText());
		this.registerBtn.addActionListener(actionHandler);
		line.add(this.registerBtn);
		this.registerBtn.setBounds(245, 620, 115, 27);

		// ID 중복확인 버튼
		this.idConfirmBtn = new JButton(ERegister.idConfrimButtonLabel.getText());
		this.idConfirmBtn.addActionListener(actionHandler);
		line.add(this.idConfirmBtn);
		this.idConfirmBtn.setBounds(332, 151, 101, 27);

		// 이미지 라벨
		this.imagelabel = new JLabel(" ");
		imagelabel.setIcon(new ImageIcon("회원가입이미지.gif"));
		line.add(imagelabel);
		imagelabel.setBounds(52, 10, 404, 110);

		// 서울 라디오 버튼
		this.seoulRadio = new JRadioButton(ERegister.seoulRadio.getText());
		this.seoulRadio.setBackground(Color.white);
		seoulRadio.setFont(new Font("굴림", Font.PLAIN, 13));
		line.add(seoulRadio);
		seoulRadio.setBounds(126, 555, 121, 23);

		// 용인 라디오 버튼
		this.yoninRadio = new JRadioButton(ERegister.yonginRadio.getText());
		this.yoninRadio.setBackground(Color.white);
		yoninRadio.setFont(new Font("굴림", Font.PLAIN, 13));
		line.add(yoninRadio);
		yoninRadio.setBounds(249, 555, 121, 23);

		// 라디오 버튼 그룹핑
		this.group = new ButtonGroup();
		this.group.add(seoulRadio);
		this.group.add(yoninRadio);

		this.seoulRadio.setSelected(true);

		// 개인정보 수집 동의 체크 박스
		this.infoConfirmCheck = new JCheckBox(ERegister.informationCheck.getText());
		this.infoConfirmCheck.setBackground(Color.white);
		infoConfirmCheck.setBounds(170, 580, 136, 23);
		line.add(infoConfirmCheck);

	}

	public void initialize() {
		this.setVisible(true);
	}

	public boolean checkInput(String textInput) {

		char chrInput;

		for (int i = 0; i < textInput.length(); i++) {

			chrInput = textInput.charAt(i); // 입력받은 텍스트에서 문자 하나하나 가져와서 체크

			if (chrInput >= 0x61 && chrInput <= 0x7A) {
				// 영문(소문자) OK!
			} else if (chrInput >= 0x41 && chrInput <= 0x5A) {
				// 영문(대문자) OK!
			} else if (chrInput >= 0x30 && chrInput <= 0x39) {

				// 숫자 OK!
			} else {
				return false; // 영문자도 아니고 숫자도 아님!
			}
		}
		return true;
	}

	// 뒤로가기 버튼
	public boolean back(Object eventSource) {
		boolean yes = false;
		if (eventSource.equals(this.backBtn)) {
			yes = true;
		}
		return yes;
	}

	// 아이디 중복확인 버튼
	public void idConfirm(Object eventSource) {

		if (eventSource.equals(this.idConfirmBtn)) {
			if (this.idText1.getText() != null) {
				VRegister vRegister = new VRegister();
				vRegister.setConfirmId(this.idText1.getText());

				CRegister cRegister = new CRegister();
				int outcome = cRegister.confirm(vRegister);
				if (outcome == 0) {
					// 아이디 사용 가능
					JOptionPane.showMessageDialog(null, ERegister.idConfirmAble.getText());
					click = true;
				} else {
					// 아이디 사용 불 가능
					JOptionPane.showMessageDialog(null, ERegister.idConfirmUnable.getText());
					click = false;
				}
			}
		}
	}

	// 회원가입 버튼
	public boolean register(Object eventSource) {

		boolean hehe = false;

		VRegister vRegister = new VRegister();

		if (eventSource.equals(this.registerBtn)) {
			System.out.println("야 돌아가");

			String chr = this.idText1.getText();
			boolean result = this.checkInput(chr);
			// 한글이 아닐 때
			if (result == true) {

				vRegister.setId(this.idText1.getText());
				vRegister.setPw(this.passwordField.getText());
				vRegister.setName(this.nameText.getText());
				vRegister.setStNum(this.stNumText.getText());
				vRegister.setEmail(this.emailText.getText());
				vRegister.setTel(this.telText.getText());
				vRegister.setBirth(this.birthText.getText());

				String yongin, seoul;
				if (this.yoninRadio.isSelected()) {
					yongin = "용인캠퍼스";
				} else {
					yongin = "용인아님";
				}
				if (this.seoulRadio.isSelected()) {
					seoul = "서울캠퍼스";
				} else {
					seoul = "서울아님";
				}
				vRegister.setSeoulBtn(seoul);
				vRegister.setYonginBtn(yongin);

				boolean checkP = false;
				checkP = infoConfirmCheck.isSelected();

				if (this.idText1.getText().equals("") || this.passwordField.getText().equals("")
						|| this.nameText.getText().equals("")
						|| (this.stNumText.getText().equals("") || this.emailText.getText().equals("")
								|| this.telText.getText().equals("") || this.birthText.getText().equals(""))) {
					// 회원가입 비정상
					JOptionPane.showMessageDialog(null, ERegister.registerError.getText());
					hehe = false;
				} else if (!passwordField.getText().equals(pwConfirmField.getText())) {
					// PW 확인
					JOptionPane.showMessageDialog(null, ERegister.registerPwCheck.getText());
					hehe = false;
				} else if (click == false) {
					// 아이디 중복확인 안 누름
					JOptionPane.showMessageDialog(null, ERegister.regitserDuplication.getText());
					hehe = false;
				} else if (checkP == false) {
					// 개인정보 동의 체크박스 체크 안 함
					JOptionPane.showMessageDialog(null, ERegister.registerCheckBox.getText());
					hehe = false;
				} else {
					// 회원가입 정상 퓨슝! 이러면 씬나는 거지 !~~~~
					JOptionPane.showMessageDialog(null, ERegister.registerSuccess.getText());
					hehe = true;
					CRegister cRegister = new CRegister();
					cRegister.write(vRegister);
				}
			} else {
				// 아이디는 영어로 입력
				JOptionPane.showMessageDialog(null, ERegister.registerIdEnglish.getText());
			}
		}
		return hehe;

	}

}
