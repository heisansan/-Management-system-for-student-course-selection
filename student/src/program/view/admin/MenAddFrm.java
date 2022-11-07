package  view.admin;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import  dao.AdminDao;
import  model.Bumen;
import  utils.StringUtil;
import java.awt.Font;

public class MenAddFrm extends JInternalFrame {
	//���Ա��
	private JTextField Name;
	private JTextField peixun;
	private JTextField gongzi;
	private AdminDao adminDao = new AdminDao();
	private JComboBox bumenNameJcb;
	private JTextArea mmDesc;
	private JRadioButton nan;
	private JRadioButton nv;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenAddFrm frame = new MenAddFrm();
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
	public MenAddFrm() {
		getContentPane().setFont(new Font("SimSun", Font.PLAIN, 18));
		setClosable(true);
		setIconifiable(true);
		setTitle("��Ա���");
		setBounds(100, 100, 450, 402);

		JLabel label = new JLabel("����");
		label.setFont(new Font("SimSun", Font.PLAIN, 18));

		Name = new JTextField();
		Name.setFont(new Font("SimSun", Font.PLAIN, 18));
		Name.setColumns(10);

		JLabel label_1 = new JLabel("��ѵ�ƻ�");
		label_1.setFont(new Font("SimSun", Font.PLAIN, 18));

		peixun = new JTextField();
		peixun.setFont(new Font("SimSun", Font.PLAIN, 18));
		peixun.setColumns(10);

		JLabel lblNewLabel = new JLabel("�Ա�");
		lblNewLabel.setFont(new Font("SimSun", Font.PLAIN, 18));

		nan = new JRadioButton("��");
		nan.setFont(new Font("SimSun", Font.PLAIN, 18));
		buttonGroup.add(nan);
		nan.setSelected(true);

		nv = new JRadioButton("Ů");
		nv.setFont(new Font("SimSun", Font.PLAIN, 18));
		buttonGroup.add(nv);

		JLabel label_2 = new JLabel("����");
		label_2.setFont(new Font("SimSun", Font.PLAIN, 18));

		gongzi = new JTextField();
		gongzi.setFont(new Font("SimSun", Font.PLAIN, 18));
		gongzi.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("����");
		lblNewLabel_1.setFont(new Font("SimSun", Font.PLAIN, 18));

		bumenNameJcb = new JComboBox();
		bumenNameJcb.setFont(new Font("SimSun", Font.PLAIN, 18));

		JLabel label_3 = new JLabel("��Ա����");
		label_3.setFont(new Font("SimSun", Font.PLAIN, 18));

		mmDesc = new JTextArea();

		JButton button = new JButton("���");
		button.setFont(new Font("SimSun", Font.PLAIN, 18));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenAddActionPerformed(e);
			}
		});

		JButton button_1 = new JButton("����");
		button_1.setFont(new Font("SimSun", Font.PLAIN, 18));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel)
								.addComponent(label)
								.addComponent(lblNewLabel_1))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(nan)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(nv))
										.addComponent(Name, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
									.addGap(43)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_1)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(peixun, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(30)
											.addComponent(label_2)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(gongzi))))
								.addComponent(bumenNameJcb, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(label_3)
							.addGap(18)
							.addComponent(mmDesc, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(59)
					.addComponent(button)
					.addPreferredGap(ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
					.addComponent(button_1)
					.addGap(76))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(Name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(peixun, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(gongzi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(nv)
						.addComponent(nan)
						.addComponent(lblNewLabel)
						.addComponent(label_2))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(bumenNameJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(mmDesc, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button))
					.addGap(29))
		);
		getContentPane().setLayout(groupLayout);
		fillBumen();

	}

	protected void MenAddActionPerformed(ActionEvent e) {
		// ȡֵ
		String Name = this.Name.getText();
		String peixun = this.peixun.getText();
		//Float gongzi1 =  Float.parseFloat(this.gongzi.getText());  //��string����ת��Ϊfloat����
		float gongzi1 = 2500;
		//String gongzi = this.gongzi.getText();
		String mmDesc = this.mmDesc.getText();
		if (StringUtil.isEmpty(Name)) {
			JOptionPane.showMessageDialog(null, "��������Ϊ��");
			return;
		}
		if (StringUtil.isEmpty(peixun)) {
			JOptionPane.showMessageDialog(null, "��ѵ�ƻ�����Ϊ��");
			return;
		}
		if (StringUtil.isEmpty(this.gongzi.getText())) {
			JOptionPane.showMessageDialog(null, "�������ʲ���Ϊ��");
			return;
		}
		if (StringUtil.isEmpty(mmDesc)) {
			JOptionPane.showMessageDialog(null, "��Ա������Ϊ��");
			return;
		}
		// ȡ��ѡ��ť��ֵ
		String sex = "";
		if (nan.isSelected()) {
			sex = "��";
		} else {
			sex = "Ů";
		}
		// ȡ�������ֵ
		Bumen b = (Bumen) bumenNameJcb.getSelectedItem();
		int id = b.getId();
		int j = adminDao.addMen(Name, peixun, gongzi1, mmDesc, sex, id);
		if (j > 0) {
			JOptionPane.showMessageDialog(null, "��ӳɹ�");
			reset();
		} else {
			JOptionPane.showMessageDialog(null, "���ʧ��");
		}
	}

	private void reset() {
		this.Name.setText("");
		this.mmDesc.setText("");
		this.gongzi.setText("");
		this.peixun.setText("");
	}

	public void fillBumen() {
		List<Bumen> listBumen = adminDao.listBumen("");
		for (Bumen bumen : listBumen) {
			String bumenName = bumen.getBumenName();
			int id = bumen.getId();
			Bumen b = new Bumen(bumenName, id);
			this.bumenNameJcb.addItem(b);
		}
	}
}

