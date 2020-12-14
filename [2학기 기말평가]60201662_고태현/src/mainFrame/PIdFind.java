package mainFrame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import constants.Constants.EIdFind;
import mainFrame.Main.ActionHandler;
import valueObject.VFind;
import valueObject.VFind1;

public class PIdFind extends JFrame {
	private static final long serialVersionUID = 1L;

	private JLabel idlabel;
	private JTextField idtext;
	private JLabel stNumlabel;
	private JTextField stNumtext;
	private JButton backBtn;
	private JButton idFindBtn;

	public PIdFind(ActionHandler actionHandler) {

		this.setSize(EIdFind.width.getInt(), EIdFind.height.getInt());
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle(EIdFind.title.getText());

		JPanel line = new JPanel();

		line.setBackground(Color.white);
		this.setContentPane(line);

		this.setLayout(null);

		// 이름
		this.idlabel = new JLabel(EIdFind.idLabel.getText());
		this.idlabel.setFont(new Font("굴림", Font.PLAIN, 13));
		this.idlabel.setBounds(89, 49, 43, 22);
		line.add(this.idlabel);

		this.idtext = new JTextField();
		this.idtext.setBounds(143, 47, 147, 28);
		line.add(this.idtext);
		this.idtext.setColumns(EIdFind.sizeNameText.getInt());

		// 학번
		this.stNumlabel = new JLabel(EIdFind.stnumLabel.getText());
		this.stNumlabel.setFont(new Font("굴림", Font.PLAIN, 13));
		this.stNumlabel.setBounds(89, 100, 43, 22);
		line.add(this.stNumlabel);

		this.stNumtext = new JTextField();
		this.stNumtext.setBounds(143, 98, 147, 28);
		line.add(this.stNumtext);
		this.stNumtext.setColumns(EIdFind.sizestnumText.getInt());

		// 뒤로 가기 버튼
		this.backBtn = new JButton(EIdFind.backButtonLabel.getText());
		this.backBtn.addActionListener(actionHandler);
		this.backBtn.setBounds(155, 202, 109, 28);
		line.add(this.backBtn);

		// 아이디 찾기 버튼
		this.idFindBtn = new JButton(EIdFind.idFnButtonLable.getText());
		this.idFindBtn.addActionListener(actionHandler);
		this.idFindBtn.setBounds(276, 203, 105, 26);
		line.add(this.idFindBtn);
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

	// 아이디 찾기 버튼
	public VFind1 idFind(Object eventSource) {
		VFind1 vFind1 = new VFind1();
		if (eventSource.equals(this.idFindBtn)) {
			vFind1.setName(idtext.getText());
			vFind1.setStnum(stNumtext.getText());
			return vFind1;
		}
		return null;
	}
}
