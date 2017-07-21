package adress;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;


public class AdressManger extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6340148191202477108L;
	private JPanel contentPane;
	private JPanel panel_2;
	private JTable table;
	private JLabel lab[] = new JLabel[10];
	private DefaultTableModel model;
	private Object[][] obj = {
	};
	private String[] str = {
			"\u8054\u7CFB\u4EBA", "\u56FD\u5BB6", "\u57CE\u5E02", "\u7701", "\u90AE\u653F\u7F16\u7801", "\u5730\u5740", "\u7535\u8BDD\u53F7\u7801", " \u5DE5\u4F5C\u5355\u4F4D"
	};
	private JTextField textField;
	private JButton but[] = new JButton[10];
	private String[] oldfigures = new String[10];
	private String[] newfigures = new String[10];
	private int changedrow[] = new int[10];
	private int changedcolumn[] = new int[10];
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdressManger frame = new AdressManger();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public AdressManger() throws IOException {
		setTitle("\u5730\u5740\u7C3F\u7BA1\u7406");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		setResizable(false); 
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("ȫ����Ϣ", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 33, 779, 395);
		panel.add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel(obj,str);
		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(78);
		table.getColumnModel().getColumn(1).setPreferredWidth(61);
		table.getColumnModel().getColumn(1).setMinWidth(30);
		table.getColumnModel().getColumn(2).setPreferredWidth(60);
		table.getColumnModel().getColumn(3).setPreferredWidth(51);
		table.getColumnModel().getColumn(4).setPreferredWidth(88);
		table.getColumnModel().getColumn(5).setPreferredWidth(183);
		table.getColumnModel().getColumn(6).setPreferredWidth(133);
		table.getColumnModel().getColumn(7).setPreferredWidth(140);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("\u6DFB\u52A0\u8054\u7CFB\u4EBA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddNewContact newcontact = new AddNewContact();
				newcontact.setVisible(true);
				newcontact.setLocationRelativeTo(null);
			}
		});
		btnNewButton_1.setBounds(0, 2, 107, 27);
		panel.add(btnNewButton_1);
		
		JButton button = new JButton("\u5220\u9664\u8054\u7CFB\u4EBA");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					delete();
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		});
		
		button.setBounds(110, 2, 107, 27);
		panel.add(button);
		
		JButton button_1 = new JButton("\u5237\u65B0");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					read();
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		});
		button_1.setBounds(377, 2, 63, 27);
		panel.add(button_1);
		
		JButton button_2 = new JButton("\u4FDD\u5B58\u4FEE\u6539");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					modify();
					read();
				} catch (IOException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
			}
		});
		button_2.setBounds(219, 2, 93, 27);
		panel.add(button_2);
		
		JButton btnNewButton_2 = new JButton("\u8BE6\u7EC6\u641C\u7D22");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Searchindetail searchframe = new Searchindetail();
					searchframe.setVisible(true);
					searchframe.setLocationRelativeTo(null);
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton_2.setBounds(686, 3, 93, 24);
		panel.add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setBounds(504, 3, 113, 24);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u641C\u7D22");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals(""))
					try {
						read();
					} catch (IOException e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					}
				else search();
			}
		});
		btnNewButton.setBounds(620, 3, 63, 24);
		panel.add(btnNewButton);
		
		JLabel label = new JLabel("\u8054\u7CFB\u4EBA\uFF1A");
		label.setBounds(444, 6, 63, 18);
		panel.add(label);
		
		JButton btnNewButton_3 = new JButton("\u5BFC\u51FA");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					exportcsv();
				} catch (IOException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(AdressManger.this, "�ļ��ѵ�����");
			}
		});
		btnNewButton_3.setBounds(313, 2, 63, 27);
		panel.add(btnNewButton_3);
		
		panel_2 = new JPanel();
		tabbedPane.addTab("�޸ļ�¼", null, panel_2, null);
		panel_2.setLayout(null);
		
		lab[0] = new JLabel("");
		lab[0].setBounds(51, 13, 572, 28);
		panel_2.add(lab[0]);
		
		but[0] = new JButton("\u64A4\u9500");
		but[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					recall(0);
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		});
		but[0].setBounds(652, 14, 113, 27);
		
		lab[1] = new JLabel("");
		lab[1].setBounds(51, 54, 572, 28);
		panel_2.add(lab[1]);
		
		but[1] = new JButton("\u64A4\u9500");
		but[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					recall(1);
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		});
		but[1].setBounds(652, 54, 113, 27);
		
		lab[2] = new JLabel("");
		lab[2].setBounds(51, 95, 572, 28);
		panel_2.add(lab[2]);
		
		but[2] = new JButton("\u64A4\u9500");
		but[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					recall(2);
				} catch (IOException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
			}
		});
		but[2].setBounds(652, 94, 113, 27);
		
		but[3] = new JButton("\u64A4\u9500");
		but[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					recall(3);
				} catch (IOException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
			}
		});
		but[3].setBounds(652, 134, 113, 27);
		
		but[4] = new JButton("\u64A4\u9500");
		but[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					recall(4);
				} catch (IOException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
			}
		});
		but[4].setBounds(652, 174, 113, 27);
		
		but[5] = new JButton("\u64A4\u9500");
		but[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					recall(5);
				} catch (IOException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
			}
		});
		but[5].setBounds(652, 214, 113, 27);
		
		but[6] = new JButton("\u64A4\u9500");
		but[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					recall(6);
				} catch (IOException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
			}
		});
		but[6].setBounds(652, 254, 113, 27);
		
		but[7] = new JButton("\u64A4\u9500");
		but[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					recall(7);
				} catch (IOException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
			}
		});
		but[7].setBounds(652, 294, 113, 27);
		
		but[8] = new JButton("\u64A4\u9500");
		but[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					recall(8);
				} catch (IOException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
			}
		});
		but[8].setBounds(652, 334, 113, 27);
		
		but[9] = new JButton("\u64A4\u9500");
		but[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					recall(9);
				} catch (IOException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
			}
		});
		but[9].setBounds(652, 374, 113, 27);
		
		lab[3] = new JLabel("");
		lab[3].setBounds(51, 136, 572, 28);
		panel_2.add(lab[3]);
		
		lab[4] = new JLabel("");
		lab[4].setBounds(51, 178, 572, 28);
		panel_2.add(lab[4]);
		
		lab[5] = new JLabel("");
		lab[5].setBounds(51, 218, 572, 28);
		panel_2.add(lab[5]);
		
		lab[6] = new JLabel("");
		lab[6].setBounds(51, 258, 572, 28);
		panel_2.add(lab[6]);
		
		lab[7] = new JLabel("");
		lab[7].setBounds(51, 298, 572, 28);
		panel_2.add(lab[7]);
		
		lab[8] = new JLabel("");
		lab[8].setBounds(51, 338, 572, 28);
		panel_2.add(lab[8]);
		
		lab[9] = new JLabel("");
		lab[9].setBounds(51, 378, 572, 28);
		panel_2.add(lab[9]);
		
		read();
	}
	
	//���ļ��ж�ȡ���
	public void read() throws IOException{
		
		//��ȡ�ļ������ݲ�����data������
		String[][] data = new String[100][8];
		String fileName = "Address.txt";
		String line;
		int rowcount = 0;
		
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		line = in.readLine();
		while (line != null){
			for(int i = 0;i <= 7;i++){
				data[rowcount][i] = line;
				line = in.readLine();
			}
			rowcount++;
		}
		in.close();
		
		//��data�����е�����д������
		model = new DefaultTableModel(new String[rowcount][], str);
		for(int r = 0;r <= rowcount - 1;r++){
			for(int i = 0;i <= 7;i++){
				model.setValueAt(data[r][i], r, i);
			}
		}
		table.setModel(model);
	}
	
	//ɾ����ϵ��
	private void delete() throws IOException {
		// TODO �Զ����ɵķ������
		
		//��ȡ�ļ������ݲ�����data������
		String[][] data = new String[100][8];
		String fileName = "Address.txt";
		String line;
		int rowcount = 0;
		
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		line = in.readLine();
		while (line != null){
			for(int i = 0;i <= 7;i++){
				data[rowcount][i] = line;
				line = in.readLine();
			}
			rowcount++;
		}
		in.close();
		
		int numrow = table.getSelectedRows().length;//��ȡѡ����еĸ���
		int row = table.getSelectedRow(); //��ȡҪɾ�����У�û��ѡ����ֵΪ-1
		if(row == -1)
			JOptionPane.showMessageDialog(AdressManger.this, "��ѡ��Ҫɾ������ϵ�ˣ�");
		else{
			for(int k = 0;k < numrow;k++){
			//System.out.println(row);
			int newrow = table.getSelectedRow();
			model.removeRow(table.getSelectedRow());
			//System.out.println(row);
			for(int i = newrow;i <= model.getRowCount() - 1;i++){
				for(int j = 0;j <= 7;j++){
					data[i][j] = data[i+1][j];
				}
			}
			
			//��data����д���ļ�
			String fileName_0 = "Address.txt";
			FileWriter writer = new FileWriter(fileName_0);
			for(int i = 0;i <= model.getRowCount() - 1;i++){
				for(int j = 0;j <= 7;j++){
					writer.write(data[i][j] + "\r\n");
				}
			}
			writer.flush();
			writer.close();
			}
		}
		//read();
	}
	
	//�����޸ĵı��ķ���
	private void  modify() throws IOException{
		//��ȡ�ļ������ݲ�����data������
		String[][] data = new String[100][8];
		String fileName = "Address.txt";
		String line;
		int rowcount = 0;
		int errorcount = 0;
		int voidcount = 0;
				
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		line = in.readLine();
		while (line != null){
			for(int i = 0;i <= 7;i++){
				data[rowcount][i] = line;
				line = in.readLine();
			}
			rowcount++;
		}
		in.close();
		
		//��table������д���ļ�,�����������data���飨ԭ���ݣ�д��,�������޸�
		String fileName_0 = "Address.txt";
		FileWriter writer = new FileWriter(fileName_0);
		for(int i = 0;i <= model.getRowCount() - 1;i++){
			for(int j = 0;j <= 7;j++){
				if(j == 0){
					if( !data[i][j].equals((String) model.getValueAt(i, j)))
						errorcount++;
					writer.write(data[i][j] + "\r\n");
				}
				else if(j == 6){
					if(((String) model.getValueAt(i, j)).equals("")){
						voidcount++;
						writer.write(data[i][6] + "\r\n");
					}
					else {
						writer.write((String) model.getValueAt(i, j) + "\r\n");
						if(!data[i][j].equals((String) model.getValueAt(i, j))){
							record(data[i][6],(String) model.getValueAt(i, j),i,j);
						}
					}
				}
				else{
					writer.write((String) model.getValueAt(i, j) + "\r\n");
					if(!data[i][j].equals((String) model.getValueAt(i, j))){
						record(data[i][j],(String) model.getValueAt(i, j),i,j);
					}
				}
			}
		}
		writer.flush();
		writer.close();
		
		//�ж��Ƿ��޸������� ����errorcount���������ɱ����޸Ķ�������󵯳������ʾ
		if(errorcount != 0)
			JOptionPane.showMessageDialog(AdressManger.this, "���������޸ģ�");
		if(voidcount != 0)
			JOptionPane.showMessageDialog(AdressManger.this, "�绰���벻��Ϊ�գ�");
	}
	
	private void search() {
		
		String[][] data = new String[100][8];
		int row = 0;
		
		//��ȡ������ݲ�����data����
		for(int i = 0;i <= model.getRowCount() - 1;i++)
			for(int j = 0;j <= 7;j++)
				data[i][j] = (String) model.getValueAt(i, j);
		
		//�����Ϲؼ��ʵ�����ȡ���� ��
		for(int i = 0;i <= model.getRowCount() - 1;i++)
			if(data[i][0].indexOf(textField.getText()) != -1){
				for(int j = 0;j <= 7;j++)
					data[row][j] = (String) model.getValueAt(i, j);
				row++;
			}
		
		//��data������ʾ������� ��
		model = new DefaultTableModel(new String[row][], str);
		
		for(int r = 0;r <= row - 1;r++){
			for(int i = 0;i <= 7;i++){
				model.setValueAt(data[r][i], r, i);
			}
		}
		table.setModel(model);
	}
	
	private void exportcsv() throws IOException{
		
		//��ȡ�ļ������ݲ�����data������
				String[][] data = new String[100][8];
				String fileName = "Address.txt";
				String line;
				int rowcount = 0;
				
				BufferedReader in = new BufferedReader(new FileReader(fileName));
				line = in.readLine();
				while (line != null){
					for(int i = 0;i <= 7;i++){
						data[rowcount][i] = line;
						line = in.readLine();
					}
					rowcount++;
				}
				in.close();
		
		//��data������д��csv�ļ�
				String fileName_0 = "Address.csv";
				FileWriter writer = new FileWriter(fileName_0);
				for(int i = 0;i <= rowcount - 1;i++){
					for(int j = 0;j <= 7;j++){
						writer.write(data[i][j] + ","); // csv�ļ��ԡ������ָ���������
					}
					writer.write("\r\n");// �ָ���������
				}
				writer.flush();
				writer.close();
	}
	
	//����޸ļ�¼
	private void record(String olddata,String  newdata,int row,int column){
		int correctrow = row + 1;
		int correctcolumn = column + 1;
		
		//������һ����¼���м�¼�����������һ�����������һ����¼
		if(!lab[9].getText().equals("")){
			for(int j = 0;j <= 8;j++){
				lab[j].setText(lab[j+1].getText());
				oldfigures[j] = oldfigures[j+1];
				newfigures[j] = newfigures[j+1];
				changedrow[j] = changedrow[j+1];
				changedcolumn[j] = changedcolumn[j+1];
			}
			lab[9].setText("��" + correctrow + "�е�" + correctcolumn + "�е�" + olddata + "��Ϊ��" + newdata);
			oldfigures[9] = olddata;
			newfigures[9] = newdata;
			changedrow[9] = row;
			changedcolumn[9] = column;
		}
		
		//���һ����¼
		for(int i = 0;i <= 9;i++){
			if(lab[i].getText().equals("")){
				lab[i].setText("��" + correctrow + "�е�" + correctcolumn + "�е�" + olddata + "��Ϊ��" + newdata);
				panel_2.add(but[i]);
				oldfigures[i] = olddata;
				newfigures[i] = newdata;
				changedrow[i] = row;
				changedcolumn[i] = column;
				break;
			}
		}
	}
	
	//�����޸�,������ϵ����ݸ�Ϊԭ����,���޸��޸ļ�¼
	private void recall(int k) throws IOException{
		int row = model.getRowCount();
		
		//��ȡ�ļ������ݲ�����data������
		String[][] data = new String[100][8];
		String fileName = "Address.txt";
		String line;
		int rowcount = 0;
				
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		line = in.readLine();
		while (line != null){
			for(int i = 0;i <= 7;i++){
				data[rowcount][i] = line;
				line = in.readLine();
			}
			rowcount++;
		}
		in.close();
		
		//�޸�data�����ж�Ӧ�ط�������,��������������¼ҪҪ�޸ĵ����ݲ������򵯳�����
		if(newfigures[k].equals(table.getValueAt(changedrow[k], changedcolumn[k]))){
			
			data[changedrow[k]][changedcolumn[k]] = oldfigures[k];
		
			//��data����д���ļ�
			String fileName_0 = "Address.txt";
			FileWriter writer = new FileWriter(fileName_0);
			for(int i = 0;i <= model.getRowCount() - 1;i++){
				for(int j = 0;j <= 7;j++){
					writer.write(data[i][j] + "\r\n");
				}
			}
			writer.flush();
			writer.close();
			
			//��data������ʾ������� 
			model = new DefaultTableModel(new String[row][], str);
			
			for(int r = 0;r <= row - 1;r++){
				for(int i = 0;i <= 7;i++){
					model.setValueAt(data[r][i], r, i);
				}
			}
			table.setModel(model);
			
			//ɾ���������޸ļ�¼
			for(int i = k;i <= 8;i++){
				lab[i].setText(lab[i+1].getText());
				changedrow[i] = changedrow[i+1];
				changedcolumn[i] = changedcolumn[i+1];
			}
			lab[9].setText("");
			
			//
			for(int i = 0;i <= 9;i++){
				if(lab[i].getText().equals("")){
					panel_2.remove(but[i]);
					panel_2.repaint();
				}
			}
		}
		else{
			JOptionPane.showMessageDialog(AdressManger.this, "�ô��������޸ģ����ȳ����ô����ݵ��²�����");
		}
	}
}
