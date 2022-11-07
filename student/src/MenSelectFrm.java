

import java.awt.Color;
import java.awt.EventQueue;
import java.util.List;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import  dao.UserDao;
import  model.MenAndBumen;

public class MenSelectFrm extends JInternalFrame {
	//人员查询窗口
	private JTable table;
	private UserDao userDao = new UserDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenSelectFrm frame = new MenSelectFrm();
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
	public MenSelectFrm() {
		getContentPane().setForeground(Color.WHITE);
		setClosable(true);
		setIconifiable(true);
		setTitle("\u4EBA\u5458\u67E5\u8BE2");
		setBounds(100, 100, 634, 403);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 27, 564, 309);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "编号", "姓名", "部门",
						"培训课程", "工资", "简介" }));
		scrollPane.setViewportView(table);
		fillTable();
	}

	public void fillTable() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);// 设置成0行
		// 查询出员工
		List<MenAndBumen> b = userDao.listMen2();
		System.out.println(b);
		for (MenAndBumen men2 : b) {
			Vector v = new Vector<>();
			v.add(men2.getId());
			v.add(men2.getName());
			v.add(men2.getBumenName());
			v.add(men2.getPeixun());
			v.add(men2.getGongzi());
			v.add(men2.getDesc());
			dtm.addRow(v);
		}
	}
}
