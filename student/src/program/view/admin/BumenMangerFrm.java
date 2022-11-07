package  view.admin;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import  dao.AdminDao;
import  model.Bumen;
import  utils.StringUtil;
import java.awt.Font;

public class BumenMangerFrm extends JInternalFrame {
	//部门维护窗口——查询、修改、删除部门
	private JTextField bumenName;
	private JTable table;
	private JTextField bumenId;
	private JTextField bumenName2;
	private AdminDao adminDao = new AdminDao();
	private JTextArea bumenDesc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BumenMangerFrm frame = new BumenMangerFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BumenMangerFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u90E8\u95E8\u7EF4\u62A4");
		setBounds(100, 100, 482, 544);

		JLabel label = new JLabel("\u90E8\u95E8\u540D\u79F0");
		label.setFont(new Font("宋体", Font.PLAIN, 18));

		bumenName = new JTextField();
		bumenName.setFont(new Font("SimSun", Font.PLAIN, 18));
		bumenName.setColumns(10);

		JButton button = new JButton("\u67E5\u8BE2");
		button.setFont(new Font("宋体", Font.PLAIN, 18));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectBumenActionPerformed(e);
			}
		});

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblNewLabel = new JLabel("\u7F16\u53F7");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));

		bumenId = new JTextField();
		bumenId.setFont(new Font("SimSun", Font.PLAIN, 18));
		bumenId.setEditable(false);
		bumenId.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\u90E8\u95E8\u540D\u79F0");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));

		bumenName2 = new JTextField();
		bumenName2.setFont(new Font("SimSun", Font.PLAIN, 18));
		bumenName2.setColumns(10);

		JLabel label_1 = new JLabel("\u63CF\u53D9");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));

		bumenDesc = new JTextArea();

		JButton button_1 = new JButton("\u4FEE\u6539");
		button_1.setFont(new Font("宋体", Font.PLAIN, 18));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateBumenActionPerformed(e);
			}
		});


		JButton button_2 = new JButton("\u5220\u9664");
		button_2.setFont(new Font("宋体", Font.PLAIN, 18));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteBumenActionPerformed(e);
			}
		});

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(bumenName, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
							.addComponent(button)
							.addGap(52))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(bumenDesc, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(bumenId, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
									.addGap(67)
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(bumenName2, 0, 0, Short.MAX_VALUE))
								.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE))
							.addGap(37))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addComponent(button_1)
							.addPreferredGap(ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
							.addComponent(button_2)
							.addGap(92))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(bumenName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addGap(29)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(bumenId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(bumenName2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(bumenDesc, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button_2))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		table = new JTable();
		table.setRowHeight(25);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				BumenTableMousePressed(e);
			}
		});

		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "编号",
				"部门名称", "部门描述" }));
		table.getColumnModel().getColumn(1).setPreferredWidth(124);
		table.getColumnModel().getColumn(2).setPreferredWidth(146);
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		fillTable("");
	}

	protected void DeleteBumenActionPerformed(ActionEvent e) {
		String id = this.bumenId.getText();
		int bumenid = Integer.parseInt(id);
		// 首先要删除部门表中对应的部门id的人员
		int i = adminDao.deleteMen(bumenid);
		int j = adminDao.deleteBumen(bumenid);
		if (j > 0) {
			JOptionPane.showMessageDialog(null, "删除成功");
			reset();
			fillTable("");
		} else {
			JOptionPane.showMessageDialog(null, "删除失败");
			reset();
		}
	}

	protected void UpdateBumenActionPerformed(ActionEvent e) {
		String bumenName = this.bumenName2.getText();
		String bumenDesc = this.bumenDesc.getText();
		String id = bumenId.getText();
		int btid = Integer.parseInt(id);
		if (StringUtil.isEmpty(bumenName)) {
			JOptionPane.showMessageDialog(null, "部门名称不能为空");
			return;
		}
		if (StringUtil.isEmpty(bumenDesc)) {
			JOptionPane.showMessageDialog(null, "部门描述不能为空");
			return;
		}
		int i = adminDao.udpateBumen(bumenName, bumenDesc, btid);
		if (i > 0) {
			JOptionPane.showMessageDialog(null, "修改成功");
			reset();
			fillTable("");
		} else {
			JOptionPane.showMessageDialog(null, "修改失败");
			reset();
		}
	}

	protected void BumenTableMousePressed(MouseEvent e) {
		int row = table.getSelectedRow();// 获得行号
		bumenId.setText(String.valueOf(table.getValueAt(row, 0)));// 获取第一列的信息
		bumenName2.setText((String) table.getValueAt(row, 1));// 获取第一列的信息
		bumenDesc.setText((String) table.getValueAt(row, 2));// 获取第一列的信息
	}

	protected void SelectBumenActionPerformed(ActionEvent e) {
		String bumenName = this.bumenName.getText();
		fillTable(bumenName);
	}

	public void fillTable(String bumenName) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);// 设置成0行
		// 查询记录
		List<Bumen> b = adminDao.listBumen(bumenName);
		System.out.println(b);
		for (Bumen men2 : b) {
			Vector v = new Vector<>();
			v.add(men2.getId());
			v.add(men2.getBumenName());
			v.add(men2.getbumenDesc());
			dtm.addRow(v);
		}
	}

	public void reset() {
		this.bumenId.setText("");
		this.bumenName2.setText("");
		this.bumenDesc.setText("");
	}
}
