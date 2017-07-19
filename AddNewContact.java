package adress;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class AddNewContact extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5432081529177319718L;
	private JPanel contentPane;
	private JTextField textField_0;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewContact frame = new AddNewContact();
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
	 */
	public AddNewContact() {
		setTitle("\u6DFB\u52A0\u8054\u7CFB\u4EBA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 165);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JLabel lblNewLabel = new JLabel("*\u59D3\u540D\uFF1A");
		lblNewLabel.setBounds(14, 13, 53, 24);
		contentPane.add(lblNewLabel);
		
		textField_0 = new JTextField();
		textField_0.setBounds(64, 13, 76, 24);
		contentPane.add(textField_0);
		textField_0.setColumns(10);
		
		JLabel label = new JLabel("\u56FD\u5BB6\uFF1A");
		label.setBounds(153, 13, 53, 24);
		contentPane.add(label);
		
		textField_1 = new JTextField();
		textField_1.setBounds(203, 13, 42, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("\u57CE\u5E02\uFF1A");
		label_1.setBounds(256, 16, 45, 18);
		contentPane.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(305, 13, 53, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_2 = new JLabel("\u7701\uFF1A");
		label_2.setBounds(368, 16, 42, 18);
		contentPane.add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(403, 13, 63, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_3 = new JLabel("\u90AE\u653F\u7F16\u7801\uFF1A");
		label_3.setBounds(480, 15, 83, 21);
		contentPane.add(label_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(560, 13, 86, 24);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label_4 = new JLabel(" \u5730\u5740\uFF1A");
		label_4.setBounds(14, 63, 53, 18);
		contentPane.add(label_4);
		
		textField_5 = new JTextField();
		textField_5.setBounds(64, 60, 177, 24);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel label_5 = new JLabel("*\u7535\u8BDD\u53F7\u7801\uFF1A");
		label_5.setBounds(248, 63, 93, 18);
		contentPane.add(label_5);
		
		textField_6 = new JTextField();
		textField_6.setBounds(332, 60, 103, 24);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel label_6 = new JLabel("\u5DE5\u4F5C\u5355\u4F4D\uFF1A");
		label_6.setBounds(445, 63, 83, 18);
		contentPane.add(label_6);
		
		textField_7 = new JTextField();
		textField_7.setBounds(519, 60, 161, 24);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel label_7 = new JLabel("\uFF08\u5E26*\u53F7\u4E3A\u5FC5\u586B\u9879\uFF09");
		label_7.setBounds(430, 100, 128, 18);
		contentPane.add(label_7);
		
		JButton button = new JButton("\u63D0\u4EA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					save();//写入文件中
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		});
		button.setBounds(567, 97, 113, 24);
		contentPane.add(button);
	}
	public void save() throws IOException{
		String fileName = "Address.txt";
		FileWriter writer = new FileWriter(fileName,true);
		if(textField_0.getText().equals("") || textField_6.getText().equals("")){
			Toolkit.getDefaultToolkit().beep(); //未填写必填项会发出声音
			JOptionPane.showMessageDialog(AddNewContact.this, "请填写带*内容！");
		}
		else{
			writer.write(textField_0.getText() + "\r\n");
			writer.write(textField_1.getText() + "\r\n");
			writer.write(textField_2.getText() + "\r\n");
			writer.write(textField_3.getText() + "\r\n");
			writer.write(textField_4.getText() + "\r\n");
			writer.write(textField_5.getText() + "\r\n");
			writer.write(textField_6.getText() + "\r\n");
			writer.write(textField_7.getText() + "\r\n");
			
			textField_0.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
			textField_5.setText("");
			textField_6.setText("");
			textField_7.setText("");
		}
		writer.flush();
		writer.close();
	}
}
