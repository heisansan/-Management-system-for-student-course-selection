package  view.admin;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import  dao.AdminDao;
import  model.Bumen;
import  utils.StringUtil;
import java.awt.Font;

public class BumenAddFrm extends JInternalFrame {
	//部门添加
	private JTextField bumenName;
	private JTextArea bumenDesc;
	private AdminDao adminDao = new AdminDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BumenAddFrm frame = new BumenAddFrm();
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
	public BumenAddFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u90E8\u95E8\u6DFB\u52A0");
		setBounds(100, 100, 473, 331);

		JLabel label = new JLabel("\u90E8\u95E8\u540D\u79F0");
		label.setFont(new Font("宋体", Font.PLAIN, 18));

		bumenName = new JTextField();
		bumenName.setColumns(10);

		JLabel label_1 = new JLabel("\u90E8\u95E8\u63CF\u8FF0");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));

		bumenDesc = new JTextArea();

		JButton button = new JButton("\u6DFB\u52A0");
		button.setFont(new Font("宋体", Font.PLAIN, 18));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BumenAddActionPerformed(e);
			}
		});

		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.setFont(new Font("宋体", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(79)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(button)
							.addPreferredGap(ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
							.addComponent(button_1)
							.addGap(44))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_1)
								.addComponent(label))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(bumenDesc, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
								.addComponent(bumenName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(99, Short.MAX_VALUE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(bumenName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(bumenDesc, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button))
					.addGap(27))
		);
		getContentPane().setLayout(groupLayout);

	}

	/**
	 * 部门添加的事件处理
	 * 
	 * @param e
	 */
	protected void BumenAddActionPerformed(ActionEvent e) {
		String bumenName = this.bumenName.getText();
		String bumenDesc = this.bumenDesc.getText();
		if (StringUtil.isEmpty(bumenName)) {
			JOptionPane.showMessageDialog(null, "部门名称不能为空");
			return;
		}
		if (StringUtil.isEmpty(bumenDesc)) {
			JOptionPane.showMessageDialog(null, "部门描叙不能为空");
			return;
		}
		Bumen b = adminDao.SelectBumenName(bumenName);
		if (b != null) {
			JOptionPane.showMessageDialog(null, "此部门已经添加,请重新添加");
			reset();
		} else {
			int i = adminDao.AddBumen(bumenName, bumenDesc);
			if (i > 0) {
				JOptionPane.showMessageDialog(null, "添加成功");
				reset();
			} else {
				JOptionPane.showMessageDialog(null, "添加失败");
			}
		}
	}

	/**
	 * 重置事件的处理
	 */
	private void reset() {
		this.bumenName.setText("");
		this.bumenDesc.setText("");
	}
}
