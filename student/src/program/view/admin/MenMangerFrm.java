package  view.admin;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;

import  dao.AdminDao;
import  model.MenAndBumen;
import  model.Men;
import  model.Bumen;
import java.awt.Font;

public class MenMangerFrm extends JInternalFrame {
	//��Աά��������ѯ���޸ġ�ɾ��Ա��
	private JTextField Name;
	private JTextField peixun;
	private JTable table;
	private JTextField menid;
	private JTextField Name2;
	private JTextField gongzi;
	private JTextField peixun2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox bumenName;
	private AdminDao adminDao = new AdminDao();
	private JRadioButton nan;
	private JRadioButton nv;
	private JTextArea mmDesc;
	private JComboBox bumenNameJcb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenMangerFrm frame = new MenMangerFrm();
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
	public MenMangerFrm() {
		getContentPane().setFont(new Font("SimSun", Font.PLAIN, 18));
		setClosable(true);
		setIconifiable(true);
		setTitle("\u4EBA\u5458\u7EF4\u62A4");
		setBounds(100, 100, 879, 664);


		JLabel label = new JLabel("Ա������");
		

		Name = new JTextField();
		Name.setFont(new Font("SimSun", Font.PLAIN, 18));
		Name.setColumns(10);

		JLabel label_1 = new JLabel("��ѵ�ƻ�");

		peixun = new JTextField();
		peixun.setColumns(10);

		JLabel lblNewLabel = new JLabel("����");

		bumenName = new JComboBox();

		JScrollPane scrollPane = new JScrollPane();

		JLabel label_2 = new JLabel("���");

		menid = new JTextField();
		menid.setEditable(false);
		menid.setColumns(10);

		JLabel label_3 = new JLabel("Ա������");

		Name2 = new JTextField();
		Name2.setColumns(10);

		JLabel label_4 = new JLabel("�Ա�");

		nan = new JRadioButton("\u7537");
		nan.setSelected(true);
		buttonGroup.add(nan);

		JLabel label_5 = new JLabel("\u5DE5\u8D44");

		gongzi = new JTextField();
		gongzi.setColumns(10);

		JLabel label_6 = new JLabel("\u57F9\u8BAD\u8BA1\u5212");

		peixun2 = new JTextField();
		peixun2.setColumns(10);

		JLabel label_7 = new JLabel("\u90E8\u95E8");

		bumenNameJcb = new JComboBox();

		JLabel label_8 = new JLabel("\u5458\u5DE5\u63CF\u8FF0");

		mmDesc = new JTextArea();

		nv = new JRadioButton("\u5973");
		buttonGroup.add(nv);

		JButton button = new JButton("����");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectMenActionPerformed(e);
			}
		});


		JButton button_1 = new JButton("\u4FEE\u6539");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateMenActionPerformed(e);
			}
		});


		JButton button_2 = new JButton("\u5220\u9664");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DleteMenActionPerformed(e);
			}
		});

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 800, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_8)
								.addComponent(label_2)
								.addComponent(label)
								.addComponent(label_4))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(menid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(13)
											.addComponent(Name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(nan)
											.addGap(10)
											.addComponent(nv)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(44)
											.addComponent(label_1)
											.addGap(18)
											.addComponent(peixun, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(26)
											.addComponent(lblNewLabel)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(bumenName, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
											.addGap(48)
											.addComponent(button))
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addGap(45)
													.addComponent(label_3)
													.addGap(18))
												.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
													.addComponent(label_5)
													.addGap(31)))
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(gongzi, Alignment.LEADING)
												.addComponent(Name2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
											.addGap(49)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(label_6)
												.addGroup(groupLayout.createSequentialGroup()
													.addGap(20)
													.addComponent(label_7)))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(bumenNameJcb, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(peixun2, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)))))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(140)
									.addComponent(button_1)
									.addGap(154)
									.addComponent(button_2))
								.addComponent(mmDesc, GroupLayout.PREFERRED_SIZE, 632, GroupLayout.PREFERRED_SIZE))))
					.addGap(58))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(Name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(peixun, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(bumenName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addGap(24)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addGap(57)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(menid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(label_3)
						.addComponent(Name2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_6)
						.addComponent(peixun2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(bumenNameJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(gongzi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(nan)
						.addComponent(nv)
						.addComponent(label_7)
						.addComponent(label_5))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_8)
						.addComponent(mmDesc, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button_2))
					.addContainerGap())
		);

		table = new JTable();
		table.setRowHeight(25);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MenMousePressed(e);
			}
		});

		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u5458\u5DE5\u59D3\u540D", "\u57F9\u8BAD\u8BA1\u5212", "\u6027\u522B", "\u5DE5\u8D44", "\u5458\u5DE5\u63CF\u8FF0", "\u90E8\u95E8", "\u662F\u5426\u5F00\u59CB\u8BFE\u7A0B"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(54);
		table.getColumnModel().getColumn(0).setMinWidth(50);
		table.getColumnModel().getColumn(0).setMaxWidth(2147483639);
		table.getColumnModel().getColumn(1).setPreferredWidth(89);
		table.getColumnModel().getColumn(1).setMinWidth(20);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(53);
		table.getColumnModel().getColumn(4).setPreferredWidth(70);
		table.getColumnModel().getColumn(4).setMinWidth(29);
		table.getColumnModel().getColumn(5).setPreferredWidth(93);
		table.getColumnModel().getColumn(6).setPreferredWidth(80);
		table.getColumnModel().getColumn(7).setPreferredWidth(130);
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		fill();
		fillTable("", "", "");
	}


	protected void DleteMenActionPerformed(ActionEvent e) {
		String id = this.menid.getText();
		int menid = Integer.parseInt(id);
		int i = adminDao.deleteMen2(menid);
		if (i > 0) {
			JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
			reset();
			fillTable("", "", "");// ���±��
		} else {
			JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
			reset();
		}
	}

	protected void updateMenActionPerformed(ActionEvent e) {
		String id = this.menid.getText();
		String Name = this.Name2.getText();
		String peixun = this.peixun2.getText();
		String gongzi = this.gongzi.getText();
		String mmDesc = this.mmDesc.getText();
		// �õ�ѡ��ť
		String sex = "";
		if (nan.isSelected()) {
			sex = "��";
		} else {
			sex = "Ů";
		}
		// ���������ֵ
		Bumen b = (Bumen) bumenNameJcb.getSelectedItem();
		int bumenId = b.getId();
		Men men = new Men(Integer.parseInt(id), Name, peixun, Float.parseFloat(gongzi), mmDesc, sex, bumenId);
		int i = adminDao.updateMen(men);
		if (i > 0) {
			JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
			reset();
			fillTable("", "", "");// ���±��
		} else {
			JOptionPane.showMessageDialog(null, "�޸�ʧ��");
			reset();
		}
	}

	private void reset() {
		this.menid.setText("");
		this.Name2.setText("");
		this.peixun2.setText("");
		this.gongzi.setText("");
		this.mmDesc.setText("");
	}

	protected void MenMousePressed(MouseEvent e) {
		int row = table.getSelectedRow();// ����к�
		menid.setText(String.valueOf(table.getValueAt(row, 0)));// ��ȡ��һ�е���Ϣ
		Name2.setText((String) table.getValueAt(row, 1));// ��ȡ��һ�е���Ϣ
		peixun2.setText((String) table.getValueAt(row, 2));// ��ȡ��һ�е���Ϣ
		// �Ա�
		String sex = (String) table.getValueAt(row, 3);
		if ("��".equals(sex)) {
			nan.setSelected(true);
		} else {
			nv.setSelected(true);
		}
		gongzi.setText(String.valueOf(table.getValueAt(row, 4)));// ��ȡ��һ�е���Ϣ
		mmDesc.setText((String) table.getValueAt(row, 5));// ��ȡ��һ�е���Ϣ
		// ���
		String bumenNamejcb = (String) table.getValueAt(row, 6);
		int n = this.bumenNameJcb.getItemCount();
		for (int i = 0; i < n; i++) {
			Bumen b = (Bumen) this.bumenNameJcb.getItemAt(i);
			if (b.getBumenName().equals(bumenNamejcb)) {
				this.bumenNameJcb.setSelectedIndex(i);
			}
		}
	}

	protected void SelectMenActionPerformed(ActionEvent e) {
		String Name = this.Name.getText();
		String peixun = this.peixun.getText();
		Bumen bumen = (Bumen) this.bumenName.getSelectedItem();
		String bumenName2 = bumen.getBumenName();
		fillTable(Name, peixun, bumenName2);
	}

	public void fillTable(String Name, String peixun, String bumenName) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);// ���ó�0��
		List<MenAndBumen> b = adminDao.listMen(Name, peixun, bumenName);
		for (MenAndBumen men2 : b) {
			Vector v = new Vector<>();
			v.add(men2.getId());
			v.add(men2.getName());
			v.add(men2.getPeixun());
			v.add(men2.getSex());
			v.add(men2.getGongzi());
			v.add(men2.getmmDesc());
			v.add(men2.getBumenName());
			if (men2.getIsflag() == 0) {
				v.add("δ��ʼ");
			} else {
				v.add("�ѿ�ʼ");
			}
			dtm.addRow(v);
		}
	}

	/**
	 * ��ʼ��������
	 */
	public void fill() {
		List<Bumen> listBumen = adminDao.listBumen("");
		for (Bumen bumen : listBumen) {
			String bumenName = bumen.getBumenName();
			int id = bumen.getId();
			Bumen b = new Bumen(bumenName, id);
			this.bumenName.addItem(b);
			this.bumenNameJcb.addItem(b);

		}
	}
}
