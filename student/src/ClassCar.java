

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
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import  dao.UserDao;
import  model.Men;
import  model.MenAndHistory;
import  model.User;
import  utils.LoginConfig;

public class ClassCar extends JInternalFrame {
	//课程签退窗口
	private UserDao userDao = new UserDao();
	private JTable table;
	private JTextField NameTXT;
	private JTextField peixunTxt;
	private JTextField stimeTXT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClassCar frame = new ClassCar();
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
	public ClassCar() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u8BFE\u7A0B\u7B7E\u9000");
		setBounds(100, 100, 499, 496);

		JScrollPane scrollPane = new JScrollPane();

		JLabel label = new JLabel("\u59D3\u540D");

		NameTXT = new JTextField();
		NameTXT.setColumns(10);

		JLabel label_1 = new JLabel("\u57F9\u8BAD\u8BFE\u7A0B");

		peixunTxt = new JTextField();
		peixunTxt.setColumns(10);

		JLabel label_2 = new JLabel("\u7B7E\u5230\u65F6\u95F4");

		stimeTXT = new JTextField();
		stimeTXT.setColumns(10);

		JButton button = new JButton("\u7B7E\u9000");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 归还书籍
				ReturnBookActionformed(e);
			}
		});

		button.setIcon(null);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(label)
								.addComponent(label_2))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(NameTXT, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(stimeTXT, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(89)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(peixunTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(16, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(204, Short.MAX_VALUE)
					.addComponent(button)
					.addGap(190))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(peixunTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(NameTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label)
						.addComponent(label_1))
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(stimeTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2))
					.addGap(46)
					.addComponent(button)
					.addContainerGap(23, Short.MAX_VALUE))
		);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MyMenMousePressed(e);
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "编号", "姓名", "培训课程", "签到时间" }));
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		fillTable();
	}

	/**
	 * 归还书籍的事件处理
	 * 
	 * @param e
	 */
	/**
	 * 归还书籍的逻辑 1. 把book表中的isflag改成0
	 * 
	 * 2. 在借书表中对应插入一个还书日期
	 */

	protected void ReturnBookActionformed(ActionEvent e) {
		String Name = this.NameTXT.getText();
		Men b = userDao.selectmenid(Name);
		int menid = b.getId();
		List<String> reader = LoginConfig.reader();
		String name = reader.get(0);
		User u = userDao.selectUname(name);
		int userid = u.getId();
		int i = userDao.updateIsFlag(menid);
		if (i > 0) {
			int j = userDao.updateetime(userid, menid);
			if (j > 0) {
				JOptionPane.showMessageDialog(null, "签退成功");
				fillTable();
				reset();
			} else {
				JOptionPane.showMessageDialog(null, "签退失败");
			}
		} else {
			JOptionPane.showMessageDialog(null, "签退失败");
		}
	}

	/**
	 * 点击表格行数据显示事件处理
	 * 
	 * @param e
	 */
	protected void MyMenMousePressed(MouseEvent e) {
		int row = table.getSelectedRow();// 获得行号
		NameTXT.setText((String) table.getValueAt(row, 1));// 获取第一列的信息
		peixunTxt.setText((String) table.getValueAt(row, 2));// 获取第一列的信息
		stimeTXT.setText((String) table.getValueAt(row, 3));// 获取第一列的信息
	}

	/**
	 * 初始化表格
	 */
	public void fillTable() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);// 设置成0行
		// 查询记录
		List<String> reader = LoginConfig.reader();
		String uname = reader.get(0);
		User u = userDao.selectUname(uname);
		List<MenAndHistory> b = userDao.listMen(u.getId());
		for (MenAndHistory book2 : b) {
			Vector v = new Vector<>();
			v.add(dtm.getRowCount() + 1);
			v.add(book2.getName());
			v.add(book2.getPeixun());
			v.add(book2.getstime().toString());
			dtm.addRow(v);
		}
	}

	public void reset() {
		this.NameTXT.setText("");
		this.peixunTxt.setText("");
		this.stimeTXT.setText("");
	}
}
