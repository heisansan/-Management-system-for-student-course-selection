

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
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

import  dao.UserDao;
import  model.MenAndBumen;
import  model.Men;
import  model.User;
import  utils.LoginConfig;

public class KaoqinFrm extends JInternalFrame {
	//考勤窗口
	private JTable table;
	private JTextField menid;
	private JTextField Name;
	private JTextField peixun;
	private JTextField gongzi;
	private UserDao userDao = new UserDao();
	private JTextArea desc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KaoqinFrm frame = new KaoqinFrm();
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
	public KaoqinFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u8003\u52E4");
		setBounds(100, 100, 538, 528);

		JScrollPane scrollPane = new JScrollPane();

		JLabel label = new JLabel("\u7F16\u53F7");

		menid = new JTextField();
		menid.setEditable(false);
		menid.setColumns(10);

		JLabel label_1 = new JLabel("\u4EBA\u5458\u540D\u79F0");

		Name = new JTextField();
		Name.setColumns(10);

		JLabel lblNewLabel = new JLabel("\u57F9\u8BAD\u8BFE\u7A0B");

		peixun = new JTextField();
		peixun.setColumns(10);

		JLabel label_2 = new JLabel("\u5DE5\u8D44");

		gongzi = new JTextField();
		gongzi.setColumns(10);

		JLabel label_3 = new JLabel("\u7B80\u4ECB");

		desc = new JTextArea();

		JButton button = new JButton("\u7B7E\u5230");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenYJActionPerformed(e);
			}
		});

		JButton button_1 = new JButton("\u53D6\u6D88");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 478, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(label_3)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(desc))
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblNewLabel)
									.addComponent(label))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(menid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(peixun, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(114)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(label_1)
									.addComponent(label_2))
								.addGap(18)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(gongzi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(Name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(29, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addComponent(button)
					.addPreferredGap(ComponentPlacement.RELATED, 277, Short.MAX_VALUE)
					.addComponent(button_1)
					.addGap(75))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(menid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(peixun, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(gongzi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(desc, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(31))
		);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				BookyjMousePressed(e);
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "编号", "姓名", "培训课程",
						"工资", "简介" }));
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		fillTable();
	}

	protected void MenYJActionPerformed(ActionEvent e) {
		int menid = Integer.parseInt(this.menid.getText());
		String Name = this.Name.getText();
		String peixun = this.peixun.getText();
		Float gongzi = Float.parseFloat(this.gongzi.getText());
		String Desc = this.desc.getText();
		// 是否签到
		Men men = userDao.SelectBook(menid);
		if (men != null) {// 该员工已经签到了
			JOptionPane.showMessageDialog(null, "已经签到过了");
			reset();
		} else {// 没有签到，可以进行签到
			int i = userDao.borrowBook(menid);
			if (i > 0) {
				List<String> reader = LoginConfig.reader();
				String name = reader.get(0);
				User u = userDao.selectUname(name);
				int id = u.getId();
				int j = userDao.insertBorrow(id, menid);
				if (j > 0) {
					JOptionPane.showMessageDialog(null, "签到成功");
					fillTable();
					reset();
				}
			}
		}
	}

	protected void BookyjMousePressed(MouseEvent e) {
		int row = table.getSelectedRow();// 获得行号
		menid.setText(String.valueOf(table.getValueAt(row, 0)));// 获取第一列的信息
		Name.setText((String) table.getValueAt(row, 1));// 获取第一列的信息
		peixun.setText((String) table.getValueAt(row, 2));// 获取第一列的信息
		gongzi.setText(String.valueOf(table.getValueAt(row, 3)));// 获取第一列的信息
		desc.setText((String) table.getValueAt(row, 4));// 获取第一列的信息
	}

	public void fillTable() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);// 设置成0行
		// 查询出书籍
		List<MenAndBumen> b = userDao.listMen2();
		System.out.println(b);
		for (MenAndBumen men2 : b) {
			Vector v = new Vector<>();
			v.add(men2.getId());
			v.add(men2.getName());
			v.add(men2.getPeixun());
			v.add(men2.getGongzi());
			v.add(men2.getDesc());
			dtm.addRow(v);
		}
	}

	public void reset() {
		menid.setText("");
		Name.setText("");
		peixun.setText("");
		gongzi.setText("");
		desc.setText("");
	}
}
