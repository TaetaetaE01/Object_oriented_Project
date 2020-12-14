package sugangSincheong;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import constants.Constants.EPlan;
import control.CPlan;
import valueObject.VLecture;
import valueObject.VPlan;
import valueObject.VPlanWord;

public class PPlan extends JFrame {
	private static final long serialVersionUID = 1L;

	private JTable table;
	private JLabel campusLa;
	private JComboBox camopusComboBox;
	private JLabel nameLA;
	private JTextField nameTxt;
	private JLabel professorLa;
	private JTextField professorTxt;
	private JLabel creditLa;
	private JTextField creditTxt;
	private JButton planBtn;
	private JButton SEARCHBTN;
	private JButton EXITBTN;
	private JScrollPane scoll;
	String code, name, location, personnel, grade, professor, campuses, time = null;

	String[] campus = { "인문캠퍼스", "자연캠퍼스" };

	public PPlan() {

		this.setSize(EPlan.width.getInt(), EPlan.height.getInt());
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle(EPlan.title.getText());

		JPanel line = new JPanel();

		line.setBackground(Color.white);
		this.setContentPane(line);
		this.setLayout(null);

		// 캠퍼스
		this.campusLa = new JLabel(EPlan.campusLabel.getText());
		this.campusLa.setFont(new Font("굴림", Font.PLAIN, 16));
		campusLa.setBounds(154, 49, 58, 25);
		line.add(this.campusLa);

		this.camopusComboBox = new JComboBox(campus);
		this.camopusComboBox.setFont(new Font("굴림", Font.PLAIN, 13));
		this.camopusComboBox.setBounds(208, 50, 138, 25);
		line.add(this.camopusComboBox);

//		this.camopusComboBox.setSelectedIndex(1);

		// 강의명
		this.nameLA = new JLabel(EPlan.nameLabel.getText());
		this.nameLA.setFont(new Font("굴림", Font.PLAIN, 16));
		this.nameLA.setBounds(358, 49, 48, 25);
		line.add(this.nameLA);

		this.nameTxt = new JTextField();
		this.nameTxt.setBounds(418, 50, 161, 25);
		line.add(this.nameTxt);
		this.nameTxt.setColumns(EPlan.sizeNameText.getInt());

		// 교수명
		this.professorLa = new JLabel(EPlan.professorLabel.getText());
		this.professorLa.setFont(new Font("굴림", Font.PLAIN, 16));
		this.professorLa.setBounds(338, 96, 74, 25);
		line.add(this.professorLa);

		this.professorTxt = new JTextField();
		this.professorTxt.setBounds(418, 97, 161, 25);
		line.add(this.professorTxt);
		this.professorTxt.setColumns(EPlan.sizeNameText.getInt());

		// 학점
		this.creditLa = new JLabel(EPlan.creditLabel.getText());
		this.creditLa.setFont(new Font("굴림", Font.PLAIN, 16));
		this.creditLa.setBounds(591, 51, 48, 21);
		line.add(this.creditLa);

		this.creditTxt = new JTextField();
		this.creditTxt.setBounds(634, 50, 116, 25);
		line.add(this.creditTxt);
		this.creditTxt.setColumns(EPlan.sizeNameText.getInt());

		// 강의 계획서 버튼
		this.planBtn = new JButton(EPlan.resetButtonLable.getText());
		this.planBtn.setBounds(601, 97, 116, 25);
		line.add(this.planBtn);

		// 검색 버튼
		this.SEARCHBTN = new JButton(EPlan.searchButtonLable.getText());
		this.SEARCHBTN.setBounds(730, 96, 107, 25);
		line.add(this.SEARCHBTN);

		// 뒤로가기 버튼 (탈출)
		this.EXITBTN = new JButton(EPlan.backButtonLabel.getText());
		this.EXITBTN.setBounds(26, 506, 117, 25);
		line.add(this.EXITBTN);

		// 테이블
		this.table = new JTable();
		this.scoll = new JScrollPane(this.table);

		this.scoll.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.scoll.setBounds(154, 142, 718, 389);
		line.add(this.scoll);

		planBtn.setEnabled(false);

		// 뒤로가기 버튼 액션
		this.EXITBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		// 검색 버튼 액션
		this.SEARCHBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				planBtn.setEnabled(true);

				Vector<VPlan> vPlans = new Vector<VPlan>();

				String campus = camopusComboBox.getSelectedItem().toString();
				String name = nameTxt.getText();
				String credit = creditTxt.getText();
				String professor = professorTxt.getText();

				CPlan cPlan = new CPlan();
				vPlans = cPlan.planRead(campus, name, professor, credit);

				nameTxt.setText("");
				creditTxt.setText("");
				professorTxt.setText("");

				Vector<String> m = new Vector<String>();
				m.addElement("강의 번호");
				m.addElement("강의명");
				m.addElement("장 소");
				m.addElement("인원수");
				m.addElement("학 점");
				m.addElement("교 수");
				m.addElement("캠퍼스");
				m.addElement("시 간");

				DefaultTableModel model = new DefaultTableModel(m, 0) { // (데이터, // 맨위에)
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};

				model.getDataVector().removeAllElements();

				for (VPlan vPlan : vPlans) {
					@SuppressWarnings("rawtypes")

					Vector<String> row = new Vector<String>();
					System.out.println(vPlan.getCode() + "뭐꼬");
					row.add(vPlan.getCode());
					row.add(vPlan.getName());
					row.add(vPlan.getLocation());
					row.add(vPlan.getPersonnel());
					row.add(vPlan.getGrades());
					row.add(vPlan.getProfessor());
					row.add(vPlan.getCampus());
					row.add(vPlan.getTime());

					model.addRow(row);
					table.setModel(model);
				}

			}
		});

		// 테이블 클릭 액션
		this.table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {

				// 마우스 클릭한 행의 인덱스 값
				int idx = table.getSelectedRow();

				// 테이블.getValueAt(행의 인덱스 , 컬럼의 인덱스)
				code = table.getValueAt(idx, 0) + "";
				name = table.getValueAt(idx, 1) + "";
				location = table.getValueAt(idx, 2) + "";
				personnel = table.getValueAt(idx, 3) + "";
				grade = table.getValueAt(idx, 4) + "";
				professor = table.getValueAt(idx, 5) + "";
				campuses = table.getValueAt(idx, 6) + "";
				time = table.getValueAt(idx, 7) + "";

			}
		});

		// 강의 계획서 버튼
		this.planBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VPlanWord vPlanWord = new VPlanWord();
				vPlanWord.setCode(code);
				vPlanWord.setName(name);
				vPlanWord.setLocation(location);
				vPlanWord.setPersonnel(personnel);
				vPlanWord.setGrades(grade);
				vPlanWord.setProfessor(professor);
				vPlanWord.setCampus(campuses);
				vPlanWord.setTime(time);

				PPlanWord pPlanWord = new PPlanWord(vPlanWord);
				pPlanWord.setVisible(true);
			}
		});
	}

}
