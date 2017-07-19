package adress;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Searchindetail extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -393135606238561256L;
	private JPanel contentPane;
	private JTable table[] = new JTable[8];
	private DefaultTableModel model;
	private Object[][] obj = {
	};
	private String[] str = {
			"\u8054\u7CFB\u4EBA", "\u56FD\u5BB6", "\u57CE\u5E02", "\u7701", "\u90AE\u653F\u7F16\u7801", "\u5730\u5740", "\u7535\u8BDD\u53F7\u7801", " \u5DE5\u4F5C\u5355\u4F4D"
	};
	private JTextField textfield[] = new JTextField[8];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Searchindetail frame = new Searchindetail();
					frame.setVisible(true);
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
	public Searchindetail() throws IOException {
		setTitle("\u8BE6\u7EC6\u641C\u7D22");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 701, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 687, 355);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("联系人", null, panel, null);
		panel.setLayout(null);
		
		textfield[0] = new JTextField();
		textfield[0].setBounds(500, 3, 86, 24);
		panel.add(textfield[0]);
		textfield[0].setColumns(10);
		
		JButton btnNewButton = new JButton("\u641C\u7D22");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textfield[0].getText().equals(""))
					try {
						read(0);
					} catch (IOException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				else search(0);
			}
		});
		btnNewButton.setBounds(600, 3, 76, 24);
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 29, 682, 294);
		panel.add(scrollPane);
		
		table[0] = new JTable();
		model = new DefaultTableModel(obj,str);
		table[0].setModel(model);
		table[0].getColumnModel().getColumn(0).setPreferredWidth(78);
		table[0].getColumnModel().getColumn(1).setPreferredWidth(61);
		table[0].getColumnModel().getColumn(1).setMinWidth(30);
		table[0].getColumnModel().getColumn(2).setPreferredWidth(60);
		table[0].getColumnModel().getColumn(3).setPreferredWidth(51);
		table[0].getColumnModel().getColumn(4).setPreferredWidth(88);
		table[0].getColumnModel().getColumn(5).setPreferredWidth(183);
		table[0].getColumnModel().getColumn(6).setPreferredWidth(133);
		table[0].getColumnModel().getColumn(7).setPreferredWidth(140);
		scrollPane.setViewportView(table[0]);
		
		JButton button = new JButton("\u663E\u793A\u5168\u90E8");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					read(0);
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(365, 2, 113, 25);
		panel.add(button);
		
		read(0);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("国家", null, panel_1, null);
		panel_1.setLayout(null);
		
		textfield[1] = new JTextField();
		textfield[1].setBounds(500, 3, 86, 24);
		panel_1.add(textfield[1]);
		textfield[1].setColumns(10);
		
		JButton btnNewButton1 = new JButton("\u641C\u7D22");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textfield[1].getText().equals(""))
					try {
						read(1);
					} catch (IOException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				else search(1);
			}
		});
		btnNewButton1.setBounds(600, 3, 76, 24);
		panel_1.add(btnNewButton1);
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(0, 29, 682, 294);
		panel_1.add(scrollPane1);
		
		table[1] = new JTable();
		model = new DefaultTableModel(obj,str);
		table[1].setModel(model);
		table[1].getColumnModel().getColumn(0).setPreferredWidth(78);
		table[1].getColumnModel().getColumn(1).setPreferredWidth(61);
		table[1].getColumnModel().getColumn(1).setMinWidth(30);
		table[1].getColumnModel().getColumn(2).setPreferredWidth(60);
		table[1].getColumnModel().getColumn(3).setPreferredWidth(51);
		table[1].getColumnModel().getColumn(4).setPreferredWidth(88);
		table[1].getColumnModel().getColumn(5).setPreferredWidth(183);
		table[1].getColumnModel().getColumn(6).setPreferredWidth(133);
		table[1].getColumnModel().getColumn(7).setPreferredWidth(140);
		scrollPane1.setViewportView(table[1]);
		
		JButton button1 = new JButton("\u663E\u793A\u5168\u90E8");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					read(1);
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		button1.setBounds(365, 2, 113, 25);
		panel_1.add(button1);
		
		read(1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("城市", null, panel_2, null);
		panel_2.setLayout(null);
		
		textfield[2] = new JTextField();
		textfield[2].setBounds(500, 3, 86, 24);
		panel_2.add(textfield[2]);
		textfield[2].setColumns(10);
		
		JButton btnNewButton2 = new JButton("\u641C\u7D22");
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textfield[2].getText().equals(""))
					try {
						read(2);
					} catch (IOException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				else search(2);
			}
		});
		btnNewButton2.setBounds(600, 3, 76, 24);
		panel_2.add(btnNewButton2);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(0, 29, 682, 294);
		panel_2.add(scrollPane2);
		
		table[2] = new JTable();
		model = new DefaultTableModel(obj,str);
		table[2].setModel(model);
		table[2].getColumnModel().getColumn(0).setPreferredWidth(78);
		table[2].getColumnModel().getColumn(1).setPreferredWidth(61);
		table[2].getColumnModel().getColumn(1).setMinWidth(30);
		table[2].getColumnModel().getColumn(2).setPreferredWidth(60);
		table[2].getColumnModel().getColumn(3).setPreferredWidth(51);
		table[2].getColumnModel().getColumn(4).setPreferredWidth(88);
		table[2].getColumnModel().getColumn(5).setPreferredWidth(183);
		table[2].getColumnModel().getColumn(6).setPreferredWidth(133);
		table[2].getColumnModel().getColumn(7).setPreferredWidth(140);
		scrollPane2.setViewportView(table[2]);
		
		JButton button2 = new JButton("\u663E\u793A\u5168\u90E8");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					read(2);
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		button2.setBounds(365, 2, 113, 25);
		panel_2.add(button2);
		
		read(2);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("省", null, panel_3, null);
		panel_3.setLayout(null);
		
		textfield[3] = new JTextField();
		textfield[3].setBounds(500, 3, 86, 24);
		panel_3.add(textfield[3]);
		textfield[3].setColumns(10);
		
		JButton btnNewButton3 = new JButton("\u641C\u7D22");
		btnNewButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textfield[3].getText().equals(""))
					try {
						read(3);
					} catch (IOException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				else search(3);
			}
		});
		btnNewButton3.setBounds(600, 3, 76, 24);
		panel_3.add(btnNewButton3);
		
		JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.setBounds(0, 29, 682, 294);
		panel_3.add(scrollPane3);
		
		table[3] = new JTable();
		model = new DefaultTableModel(obj,str);
		table[3].setModel(model);
		table[3].getColumnModel().getColumn(0).setPreferredWidth(78);
		table[3].getColumnModel().getColumn(1).setPreferredWidth(61);
		table[3].getColumnModel().getColumn(1).setMinWidth(30);
		table[3].getColumnModel().getColumn(2).setPreferredWidth(60);
		table[3].getColumnModel().getColumn(3).setPreferredWidth(51);
		table[3].getColumnModel().getColumn(4).setPreferredWidth(88);
		table[3].getColumnModel().getColumn(5).setPreferredWidth(183);
		table[3].getColumnModel().getColumn(6).setPreferredWidth(133);
		table[3].getColumnModel().getColumn(7).setPreferredWidth(140);
		scrollPane3.setViewportView(table[3]);
		
		JButton button3 = new JButton("\u663E\u793A\u5168\u90E8");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					read(3);
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		button3.setBounds(365, 2, 113, 25);
		panel_3.add(button3);
		
		read(3);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("邮政编码", null, panel_4, null);
		panel_4.setLayout(null);
		
		textfield[4] = new JTextField();
		textfield[4].setBounds(500, 3, 86, 24);
		panel_4.add(textfield[4]);
		textfield[4].setColumns(10);
		
		JButton btnNewButton4 = new JButton("\u641C\u7D22");
		btnNewButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textfield[4].getText().equals(""))
					try {
						read(4);
					} catch (IOException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				else search(4);
			}
		});
		btnNewButton4.setBounds(600, 3, 76, 24);
		panel_4.add(btnNewButton4);
		
		JScrollPane scrollPane4 = new JScrollPane();
		scrollPane4.setBounds(0, 29, 682, 294);
		panel_4.add(scrollPane4);
		
		table[4] = new JTable();
		model = new DefaultTableModel(obj,str);
		table[4].setModel(model);
		table[4].getColumnModel().getColumn(0).setPreferredWidth(78);
		table[4].getColumnModel().getColumn(1).setPreferredWidth(61);
		table[4].getColumnModel().getColumn(1).setMinWidth(30);
		table[4].getColumnModel().getColumn(2).setPreferredWidth(60);
		table[4].getColumnModel().getColumn(3).setPreferredWidth(51);
		table[4].getColumnModel().getColumn(4).setPreferredWidth(88);
		table[4].getColumnModel().getColumn(5).setPreferredWidth(183);
		table[4].getColumnModel().getColumn(6).setPreferredWidth(133);
		table[4].getColumnModel().getColumn(7).setPreferredWidth(140);
		scrollPane4.setViewportView(table[4]);
		
		JButton button4 = new JButton("\u663E\u793A\u5168\u90E8");
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					read(4);
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		button4.setBounds(365, 2, 113, 25);
		panel_4.add(button4);
		
		read(4);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("地址", null, panel_5, null);
		panel_5.setLayout(null);
		
		textfield[5] = new JTextField();
		textfield[5].setBounds(500, 3, 86, 24);
		panel_5.add(textfield[5]);
		textfield[5].setColumns(10);
		
		JButton btnNewButton5 = new JButton("\u641C\u7D22");
		btnNewButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textfield[5].getText().equals(""))
					try {
						read(5);
					} catch (IOException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				else search(5);
			}
		});
		btnNewButton5.setBounds(600, 3, 76, 24);
		panel_5.add(btnNewButton5);
		
		JScrollPane scrollPane5 = new JScrollPane();
		scrollPane5.setBounds(0, 29, 682, 294);
		panel_5.add(scrollPane5);
		
		table[5] = new JTable();
		model = new DefaultTableModel(obj,str);
		table[5].setModel(model);
		table[5].getColumnModel().getColumn(0).setPreferredWidth(78);
		table[5].getColumnModel().getColumn(1).setPreferredWidth(61);
		table[5].getColumnModel().getColumn(1).setMinWidth(30);
		table[5].getColumnModel().getColumn(2).setPreferredWidth(60);
		table[5].getColumnModel().getColumn(3).setPreferredWidth(51);
		table[5].getColumnModel().getColumn(4).setPreferredWidth(88);
		table[5].getColumnModel().getColumn(5).setPreferredWidth(183);
		table[5].getColumnModel().getColumn(6).setPreferredWidth(133);
		table[5].getColumnModel().getColumn(7).setPreferredWidth(140);
		scrollPane5.setViewportView(table[5]);
		
		JButton button5 = new JButton("\u663E\u793A\u5168\u90E8");
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					read(5);
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		button5.setBounds(365, 2, 113, 25);
		panel_5.add(button5);
		
		read(5);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("电话号码", null, panel_6, null);
		panel_6.setLayout(null);
		
		textfield[6] = new JTextField();
		textfield[6].setBounds(500, 3, 86, 24);
		panel_6.add(textfield[6]);
		textfield[6].setColumns(10);
		
		JButton btnNewButton6 = new JButton("\u641C\u7D22");
		btnNewButton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textfield[6].getText().equals(""))
					try {
						read(6);
					} catch (IOException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				else search(6);
			}
		});
		btnNewButton6.setBounds(600, 3, 76, 24);
		panel_6.add(btnNewButton6);
		
		JScrollPane scrollPane6 = new JScrollPane();
		scrollPane6.setBounds(0, 29, 682, 294);
		panel_6.add(scrollPane6);
		
		table[6] = new JTable();
		model = new DefaultTableModel(obj,str);
		table[6].setModel(model);
		table[6].getColumnModel().getColumn(0).setPreferredWidth(78);
		table[6].getColumnModel().getColumn(1).setPreferredWidth(61);
		table[6].getColumnModel().getColumn(1).setMinWidth(30);
		table[6].getColumnModel().getColumn(2).setPreferredWidth(60);
		table[6].getColumnModel().getColumn(3).setPreferredWidth(51);
		table[6].getColumnModel().getColumn(4).setPreferredWidth(88);
		table[6].getColumnModel().getColumn(5).setPreferredWidth(183);
		table[6].getColumnModel().getColumn(6).setPreferredWidth(133);
		table[6].getColumnModel().getColumn(7).setPreferredWidth(140);
		scrollPane6.setViewportView(table[6]);
		
		JButton button6 = new JButton("\u663E\u793A\u5168\u90E8");
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					read(6);
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		button6.setBounds(365, 2, 113, 25);
		panel_6.add(button6);
		
		read(6);
		
		JPanel panel_7 = new JPanel();
		tabbedPane.addTab("工作单位", null, panel_7, null);
		panel_7.setLayout(null);
		
		textfield[7] = new JTextField();
		textfield[7].setBounds(500, 3, 86, 24);
		panel_7.add(textfield[7]);
		textfield[7].setColumns(10);
		
		JButton btnNewButton7 = new JButton("\u641C\u7D22");
		btnNewButton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textfield[7].getText().equals(""))
					try {
						read(7);
					} catch (IOException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				else search(7);
			}
		});
		btnNewButton7.setBounds(600, 3, 76, 24);
		panel_7.add(btnNewButton7);
		
		JScrollPane scrollPane7 = new JScrollPane();
		scrollPane7.setBounds(0, 29, 682, 294);
		panel_7.add(scrollPane7);
		
		table[7] = new JTable();
		model = new DefaultTableModel(obj,str);
		table[7].setModel(model);
		table[7].getColumnModel().getColumn(0).setPreferredWidth(78);
		table[7].getColumnModel().getColumn(1).setPreferredWidth(61);
		table[7].getColumnModel().getColumn(1).setMinWidth(30);
		table[7].getColumnModel().getColumn(2).setPreferredWidth(60);
		table[7].getColumnModel().getColumn(3).setPreferredWidth(51);
		table[7].getColumnModel().getColumn(4).setPreferredWidth(88);
		table[7].getColumnModel().getColumn(5).setPreferredWidth(183);
		table[7].getColumnModel().getColumn(6).setPreferredWidth(133);
		table[7].getColumnModel().getColumn(7).setPreferredWidth(140);
		scrollPane7.setViewportView(table[7]);
		
		JButton button7 = new JButton("\u663E\u793A\u5168\u90E8");
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					read(7);
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		button7.setBounds(365, 2, 113, 25);
		panel_7.add(button7);
		
		read(7);
	}
	
public void read(int t) throws IOException{
		
		//读取文件中数据并存入data数组中
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
		
		//将data数组中的数据写入表格中
		model = new DefaultTableModel(new String[rowcount][], str);
		for(int r = 0;r <= rowcount - 1;r++){
			for(int i = 0;i <= 7;i++){
				model.setValueAt(data[r][i], r, i);
			}
		}
		table[t].setModel(model);
	}

private void search(int t) {
		
		String[][] data = new String[100][8];
		int row = 0;
		
		//读取表格数据并存入data数组
		for(int i = 0;i <= model.getRowCount() - 1;i++)
			for(int j = 0;j <= 7;j++)
				data[i][j] = (String) model.getValueAt(i, j);
		
		//将符合关键词的行提取出来 √
		for(int i = 0;i <= model.getRowCount() - 1;i++)
			if(data[i][t].indexOf(textfield[t].getText()) != -1){
				for(int j = 0;j <= 7;j++)
					data[row][j] = (String) model.getValueAt(i, j);
				row++;
			}
		
		//将data数组显示到表格上 √
		model = new DefaultTableModel(new String[row][], str);
		
		for(int r = 0;r <= row - 1;r++){
			for(int i = 0;i <= 7;i++){
				model.setValueAt(data[r][i], r, i);
			}
		}
		table[t].setModel(model);
	}
}
