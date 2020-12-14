package mainFrame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import constants.Constants.EMenuPersonalInfo;
import mainFrame.PFileMenu.ActionHandler;
import valueObject.VUserInfo;

public class PMenuPersonalInfo extends JFrame {
	private static final long serialVersionUID = 1L;

	private JLabel namela;
	private JLabel stnumla;
	private JLabel campusla;
	private JLabel idla;
	private JLabel pwla;
	private JButton exitbtn;
	private JButton pwcheckbtn;
	private JTextField nametxt;
	private JTextField numbertxt;
	private JTextField campustxt;
	private JTextField idtxt;
	private JPasswordField pwtxt;
	private JLabel iamgela;
	private JLabel emailla;
	private JTextField emailtxt;
	private JButton pwchangeBtn;

	public PMenuPersonalInfo(VUserInfo vUserInfo, ActionHandler actionHandler) {

		this.setSize(EMenuPersonalInfo.width.getInt(), EMenuPersonalInfo.height.getInt());
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle(EMenuPersonalInfo.title.getText());

		JPanel line = new JPanel();

		line.setBackground(Color.white);
		this.setContentPane(line);
		this.setLayout(null);

		this.namela = new JLabel(EMenuPersonalInfo.nameLabel.getText());
		this.namela.setFont(new Font("±¼¸²", Font.PLAIN, 13));
		line.add(this.namela);
		this.namela.setBounds(111, 135, 47, 15);

		this.stnumla = new JLabel(EMenuPersonalInfo.stNumeLabel.getText());
		this.stnumla.setFont(new Font("±¼¸²", Font.PLAIN, 13));
		line.add(this.stnumla);
		this.stnumla.setBounds(111, 181, 47, 15);

		this.campusla = new JLabel(EMenuPersonalInfo.campusLabel.getText());
		campusla.setFont(new Font("±¼¸²", Font.PLAIN, 13));
		line.add(campusla);
		campusla.setBounds(67, 228, 91, 15);

		this.idla = new JLabel(EMenuPersonalInfo.idLabel.getText());
		idla.setFont(new Font("±¼¸²", Font.PLAIN, 13));
		line.add(idla);
		idla.setBounds(96, 272, 58, 15);

		this.pwla = new JLabel(EMenuPersonalInfo.passwordLabel.getText());
		pwla.setFont(new Font("±¼¸²", Font.PLAIN, 13));
		line.add(pwla);
		pwla.setBounds(82, 318, 68, 15);

		this.emailla = new JLabel(EMenuPersonalInfo.emailLabel.getText());
		this.emailla.setFont(new Font("±¼¸²", Font.PLAIN, 13));
		line.add(this.emailla);
		this.emailla.setBounds(85, 375, 91, 15);

		this.exitbtn = new JButton(EMenuPersonalInfo.cancelButtonLabel.getText());
		this.exitbtn.addActionListener(actionHandler);
		line.add(exitbtn);
		exitbtn.setBounds(257, 500, 97, 23);

		this.pwcheckbtn = new JButton(EMenuPersonalInfo.pwConfirmBtnLabel.getText());
		this.pwcheckbtn.addActionListener(actionHandler);
		line.add(pwcheckbtn);
		pwcheckbtn.setBounds(111, 500, 121, 23);

		this.pwchangeBtn = new JButton(EMenuPersonalInfo.pwChangeBtnLabel.getText());
		this.pwchangeBtn.addActionListener(actionHandler);
		line.add(this.pwchangeBtn);
		this.pwchangeBtn.setBounds(111, 460, 110, 23);

		this.nametxt = new JTextField();
		line.add(nametxt);
		nametxt.setBounds(152, 132, 116, 21);
		nametxt.setColumns(EMenuPersonalInfo.sizeidText.getInt());
		nametxt.setText(vUserInfo.getName());
		nametxt.setEditable(false);

		this.numbertxt = new JTextField();
		line.add(numbertxt);
		numbertxt.setBounds(152, 178, 116, 21);
		numbertxt.setColumns(EMenuPersonalInfo.sizeidText.getInt());
		numbertxt.setText(vUserInfo.getStNum());
		numbertxt.setEditable(false);

		this.campustxt = new JTextField();
		line.add(campustxt);
		this.campustxt.setBounds(152, 225, 116, 21);
		this.campustxt.setColumns(EMenuPersonalInfo.sizeidText.getInt());
		if (vUserInfo.getYonginBtn().equals("¿ëÀÎÄ·ÆÛ½º")) {
			campustxt.setText(vUserInfo.getYonginBtn());
		} else if (vUserInfo.getSeoulBtn().equals("¼­¿ïÄ·ÆÛ½º")) {
			campustxt.setText(vUserInfo.getSeoulBtn());
		}
		campustxt.setEditable(false);

		this.idtxt = new JTextField();
		line.add(idtxt);
		idtxt.setBounds(152, 269, 116, 21);
		idtxt.setColumns(EMenuPersonalInfo.sizeidText.getInt());
		idtxt.setText(vUserInfo.getId());
		idtxt.setEditable(false);

		this.pwtxt = new JPasswordField();
		line.add(pwtxt);
		pwtxt.setBounds(152, 315, 116, 21);
		pwtxt.setText(vUserInfo.getPw());
		pwtxt.setEditable(false);

		this.emailtxt = new JTextField();
		line.add(emailtxt);
		this.emailtxt.setBounds(152, 370, 116, 21);
		this.emailtxt.setColumns(EMenuPersonalInfo.sizeidText.getInt());
		this.emailtxt.setText(vUserInfo.getEmail());
		this.emailtxt.setEditable(false);

		this.iamgela = new JLabel("");
		iamgela.setIcon(new ImageIcon("myinfo.gif"));
		line.add(iamgela);
		iamgela.setBounds(28, 29, 326, 79);

	}

	// µÚ·Î°¡±â ¹öÆ°
	public boolean back(Object eventSource) {
		boolean yes = false;
		if (eventSource.equals(this.exitbtn)) {
			yes = true;
		}
		return yes;
	}

	// ºñ¹Ð¹øÈ£ È®ÀÎ
	public boolean confirm(Object eventSource) {
		boolean yes = false;
		if (eventSource.equals(this.pwcheckbtn)) {
			yes = true;
		}
		return yes;
	}

	// ºñ¹Ð¹øÈ£ ¼öÁ¤
	public boolean change(Object eventSource) {
		boolean yes = false;
		if (eventSource.equals(this.pwchangeBtn)) {
			yes = true;
		}
		return yes;
	}
}
