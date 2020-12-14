package sugangSincheong;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import constants.Constants.EPGangjwaSelectionPanel;
import constants.Constants.EPResultPanel;
import control.CResult;
import valueObject.VGangjwa;
import valueObject.VUserInfo;

public class PResultPanel extends PGangjwaContainer {
	private static final long serialVersionUID = 1L;

	private Vector<VGangjwa> vGangjwas;
	private JTable table;
	private DefaultTableModel tableModel;

	public PResultPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.table = new JTable();
		JScrollPane scrollpane = new JScrollPane();
		scrollpane.setViewportView(this.table);
		this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.add(scrollpane);

		Vector<String> header = new Vector<String>();
		for (EPResultPanel ePResultPanel : EPResultPanel.values()) {
			header.addElement(ePResultPanel.getText());
		}

//		this.tableModel = new DefaultTableModel(header, 0);

		this.tableModel = new DefaultTableModel(header, 0) { // (데이터, // 맨위에)
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		this.table.setModel(tableModel);

	}

	// HERE -> 저장된 정보 불러오기
	public void initialize(String fileName) {
		CResult cResult = new CResult();
		cResult.create(fileName);
//		this.vGangjwas = cResult.get(fileName);

		this.vGangjwas = cResult.get1(fileName);

		this.updateTableContents();

	}

	// 기존 저장
	public void save(String fileName) {
		CResult cResult = new CResult();
		cResult.save1(fileName, vGangjwas);
//		cResult.save(fileName, vGangjwas);
	}

	// 미리담기 저장
//	public void save1(String ID) {
//		CResult cResult = new CResult();
//		cResult.save1(ID, vGangjwas);
//	}
//
//	// 수강신청 저장
//	public void save2(String ID) {
//		CResult cResult = new CResult();
//		cResult.save2(ID, vGangjwas);
//	}

	public Vector<VGangjwa> getGangjwas() {
		return this.vGangjwas;
	}

	public Vector<VGangjwa> cheakDuplicated(Vector<VGangjwa> vSelectedGangjwas) {
		for (int i = vSelectedGangjwas.size() - 1; i >= 0; i--) {
			boolean found = false;
			for (VGangjwa vGangjwa : this.vGangjwas) {
				if (vGangjwa.getId().equals(vSelectedGangjwas.get(i).getId())) {
					found = true;
					// 팝업창 ㅎㅎ
					break;
				}
			}
			if (found) {
				vSelectedGangjwas.remove(i);
			}
		}
		return vSelectedGangjwas;
	}

	public void addGangjwas(Vector<VGangjwa> vSelectedGangjwas) {
		this.vGangjwas.addAll(vSelectedGangjwas);
		this.updateTableContents();
	}

	public Vector<VGangjwa> removeSelectedGangjwas() {
		Vector<VGangjwa> removeGangjwas = new Vector<VGangjwa>();
		int[] indices = this.table.getSelectedRows();
		for (int i = indices.length - 1; i >= 0; i--) {
			VGangjwa removeGangjwa = this.vGangjwas.remove(indices[i]);
			removeGangjwas.add(removeGangjwa);
		}
		this.updateTableContents();
		return removeGangjwas;
	}

	private void updateTableContents() {
		this.tableModel.setRowCount(0);
		for (VGangjwa vGangjwa : this.vGangjwas) {
			Vector<String> row = new Vector<String>();
			row.add(vGangjwa.getId());
			row.add(vGangjwa.getName());
			row.add(vGangjwa.getCredit());
			this.tableModel.addRow(row);
		}
		if (vGangjwas.size() > 0) {
			this.table.setRowSelectionInterval(0, 0);
		}

	}

}
