package mainFrame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import constants.Constants.EIdFind;
import constants.Constants.EPwFind;
import mainFrame.Main.ActionHandler;
import valueObject.VFind;
import valueObject.VFind1;

public class PPwFind extends JFrame {
	private static final long serialVersionUID = 1L;

	private JLabel namelabel;
	private JTextField nametext;
	private JLabel stNumlabel;
	private JTextField stNumtext;
	private JButton backBtn;
	private JButton pwFindBtn;

	public PPwFind(ActionHandler actionHandler) {

		this.setSize(EPwFind.width.getInt(), EPwFind.height.getInt());
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle(EPwFind.title.getText());

		JPanel line = new JPanel();

		line.setBackground(Color.white);
		this.setContentPane(line);

		this.setLayout(null);

		// 이름
		this.namelabel = new JLabel(EPwFind.idLabel.getText());
		this.namelabel.setFont(new Font("굴림", Font.PLAIN, 13));
		this.namelabel.setBounds(89, 49, 43, 22);
		line.add(this.namelabel);

		this.nametext = new JTextField();
		this.nametext.setBounds(143, 47, 147, 28);
		line.add(this.nametext);
		this.nametext.setColumns(EPwFind.sizeNameText.getInt());

		// 학번
		this.stNumlabel = new JLabel(EPwFind.stnumLabel.getText());
		this.stNumlabel.setFont(new Font("굴림", Font.PLAIN, 13));
		this.stNumlabel.setBounds(89, 100, 43, 22);
		line.add(this.stNumlabel);

		this.stNumtext = new JTextField();
		this.stNumtext.setBounds(143, 98, 147, 28);
		line.add(this.stNumtext);
		this.stNumtext.setColumns(EPwFind.sizestnumText.getInt());

		// 뒤로 가기 버튼
		this.backBtn = new JButton(EPwFind.backButtonLabel.getText());
		this.backBtn.addActionListener(actionHandler);
		this.backBtn.setBounds(155, 202, 109, 28);
		line.add(this.backBtn);

		// 아이디 찾기 버튼
		this.pwFindBtn = new JButton(EPwFind.idFnButtonLable.getText());
		this.pwFindBtn.addActionListener(actionHandler);
		this.pwFindBtn.setBounds(276, 203, 105, 26);
		line.add(this.pwFindBtn);
	}

	public void initialize() {
		this.setVisible(true);
	}

	// 뒤로 가기 버튼
	public boolean back(Object eventSource) {
		boolean yes = false;
		if (eventSource.equals(this.backBtn)) {
			yes = true;
		}
		return yes;
	}

	// 비밀번호 찾기
	public VFind1 pwFind(Object eventSource) {
		VFind1 vFind1 = new VFind1();
		if (eventSource.equals(this.pwFindBtn)) {
			vFind1.setId(nametext.getText());
			vFind1.setStnum(stNumtext.getText());
			return vFind1;
		}
		return null;
	}
}
