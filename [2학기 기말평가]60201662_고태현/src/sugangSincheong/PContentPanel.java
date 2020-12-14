package sugangSincheong;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import constants.Constants.EConfigurations;
import valueObject.VGangjwa;
import valueObject.VUser;
import valueObject.VUserInfo;

public class PContentPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private VUser vUser;
	private VUserInfo vUserInfo;
	private PSelectionPanel pSelectionPanel;
	private PControlPanel pControlPanel1;
	private PResultPanel pMiridamgiPanel;
	private PControlPanel pControlPanel2;
	private PResultPanel pSincheongPanel;

	private ActionHandler actionHandler;
	private ListSelectionListener listSelectionHandler;

	public PContentPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		this.listSelectionHandler = new ListSelectionHandler();
		this.pSelectionPanel = new PSelectionPanel(this.listSelectionHandler);
		this.add(this.pSelectionPanel);

		this.actionHandler = new ActionHandler();
		this.pControlPanel1 = new PControlPanel(this.actionHandler);
		this.add(this.pControlPanel1);

		this.pMiridamgiPanel = new PResultPanel();
		this.add(pMiridamgiPanel);

		this.pControlPanel2 = new PControlPanel(this.actionHandler);
		this.add(this.pControlPanel2);

		this.pSincheongPanel = new PResultPanel();
		this.add(pSincheongPanel);
	}

	public void intialize(VUserInfo vUserInfo) {
		this.vUserInfo = vUserInfo;

		// 테이블에 담는 부분
		this.pMiridamgiPanel.initialize(this.vUserInfo.getId() + "M");
		this.pSincheongPanel.initialize(this.vUserInfo.getId() + "S");

		this.pSelectionPanel.initialize(this.pMiridamgiPanel, this.pSincheongPanel);
		this.pControlPanel1.initialize();
		this.pControlPanel2.initialize();

	}

//	// 미리담기 저장
//	public void saveMiridamgi() {
//		this.pMiridamgiPanel.save1(this.vUserInfo.getId());
//	}
//
//	// 수강신청 저장
//	public void saveSugangsincheong() {
//		this.pSincheongPanel.save2(this.vUserInfo.getId());
//	}

	// TEXT에 저장하는 부분
	public void finish1() {
		this.pMiridamgiPanel.save(this.vUserInfo.getId() + "M");
		this.pSincheongPanel.save(this.vUserInfo.getId() + "S");
	}

	// DB에 저장하는 부분
//	public void finish() {
//		this.pMiridamgiPanel.save1(this.vUserInfo.getId());
//		this.pSincheongPanel.save2(this.vUserInfo.getId());
//	}

	// Selection Listener: Gangjwa Table
	public void update(Object source) {
		this.pSelectionPanel.update(source);
	}

	public class ListSelectionHandler implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent event) {
			update(event.getSource());
		}
	}

	// Action Listener: Move Buttons // here
	private void moveGangjwas(PGangjwaContainer source, PGangjwaContainer target) {
		Vector<VGangjwa> vSelectedGangjwas = source.removeSelectedGangjwas();
		target.addGangjwas(vSelectedGangjwas);
	}

	public class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Object source = event.getSource();

			if (source.equals(pControlPanel1.getmoveRightButton())) {
				// 강좌에서 미리담기로
				moveGangjwas(pSelectionPanel, pMiridamgiPanel);
			} else if (source.equals(pControlPanel1.getmoveLeftButton())) {
				// 미리담기에서 강좌로
				moveGangjwas(pMiridamgiPanel, pSelectionPanel);
			} else if (source.equals(pControlPanel2.getmoveRightButton())) {
				// 미리담기에서 수강신청으로
				moveGangjwas(pMiridamgiPanel, pSincheongPanel);
			} else if (source.equals(pControlPanel2.getmoveLeftButton())) {
				// 수강신청에서 미리담기로
				moveGangjwas(pSincheongPanel, pMiridamgiPanel);
			}
		}

	}
}
