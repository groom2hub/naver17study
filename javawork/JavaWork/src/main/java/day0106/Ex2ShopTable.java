package day0106;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ex2ShopTable extends JFrame{
	JTextField tfSang,tfSu,tfDan;
	JButton btnAdd,btnDel,btnUpdate,btnSearch;
	DefaultTableModel tableModel;
	JTable table;
	
	ShopModel shopModel = new ShopModel();
	
	public Ex2ShopTable() {
		super("shop 관리");
		this.setBounds(300, 100, 600, 400);
		this.initDesign();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void initDesign() {
		JPanel p1 = new JPanel();
		tfSang = new JTextField(6);
		tfSu = new JTextField(3);
		tfDan = new JTextField(6);
		
		p1.add(new JLabel("상품명"));		
		p1.add(tfSang);
		p1.add(new JLabel("수량"));
		p1.add(tfSu);
		p1.add(new JLabel("단가"));
		p1.add(tfDan);
		
		this.add("North",p1);
		
		String[] title = {"인덱스", "상품명", "수량", "단가", "총금액", "입고일"};
		tableModel = new DefaultTableModel(title, 0);
		table = new JTable(tableModel);
		this.add("Center", new JScrollPane(table));
		
		this.rowSelect();
		
		btnAdd = new JButton("상품추가");
		btnDel = new JButton("상품삭제");
		btnUpdate = new JButton("상품수정");
		btnSearch = new JButton("상품검색");
		
		JPanel p2 = new JPanel();
		p2.add(btnAdd);
		p2.add(btnDel);
		p2.add(btnUpdate);
		p2.add(btnSearch);
		this.add("South",p2);
		
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String sangpum = tfSang.getText();
				if (sangpum.length() == 0) {
					JOptionPane.showMessageDialog(Ex2ShopTable.this, "상품명을 입력해주세요.");
					return;
				}
				
				String text_su = tfSu.getText();
				int su = 0;
				if (text_su.length() == 0) {
					JOptionPane.showMessageDialog(Ex2ShopTable.this, "수량을 입력해주세요.");
					return;
				} else {
					su = Integer.parseInt(text_su);
				}
				
				String text_dan = tfDan.getText();
				int danga = 0;
				if (text_dan.length() == 0) {
					JOptionPane.showMessageDialog(Ex2ShopTable.this, "단가를 입력해주세요.");
					return;
				} else {
					danga = Integer.parseInt(text_dan);
				}
				
				shopModel.insertShop(new ShopDto(sangpum, su, danga));
				rowSelect();
				tfSang.setText("");
				tfSu.setText("");
				tfDan.setText("");
			}
		});
	
		btnDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				
				System.out.println(row);
				if (row == -1) {
					JOptionPane.showMessageDialog(Ex2ShopTable.this, "삭제할 행을 먼저 선택해주세요.");
					return;
				}
				
//				int idx = Integer.parseInt(table.getValueAt(row, 0).toString()); // 방법1
				int idx = Integer.parseInt((String)table.getValueAt(row, 0)); // 방법2
				shopModel.deleteShop(idx);
				rowSelect();
			}
		});
		
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				
				System.out.println(row);
				if (row == -1) {
					JOptionPane.showMessageDialog(Ex2ShopTable.this, "수정할 행을 먼저 선택해주세요.");
					return;
				}
				
//				int idx = Integer.parseInt(table.getValueAt(row, 0).toString()); // 방법1
				int idx = Integer.parseInt((String)table.getValueAt(row, 0));//방법2
				
				String sangpum;
				int danga;
				
				sangpum = JOptionPane.showInputDialog("수정할 상품명을 입력하세요.");
				danga = Integer.parseInt(JOptionPane.showInputDialog("수정할 단가를 입력하세요."));
				
				shopModel.updateShop(idx, sangpum, danga);
				rowSelect();
			}
		});

		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String sangpum = tfSang.getText();
				
				if (sangpum.length() == 0) {
					rowSelect();
				} else {
					tableModel.setRowCount(0);
					List<Vector<String>> searchList = shopModel.getSearchData(sangpum);

					for(Vector<String> data : searchList) {
						tableModel.addRow(data);
					}
				}
			}
		});
	}
	
	public void rowSelect() {
		tableModel.setRowCount(0);
		
		List<Vector<String>> list = shopModel.getAllDatas();
		for(Vector<String> data : list) {
			tableModel.addRow(data);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex2ShopTable ex2 = new Ex2ShopTable();
	}

}









