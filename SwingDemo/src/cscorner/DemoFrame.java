package cscorner;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DemoFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textName;
	private JTextField textAge;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DemoFrame frame = new DemoFrame();
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
	public DemoFrame() {
		setTitle("Demo Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Name");
		lblNewLabel.setBounds(85, 44, 70, 14);
		contentPane.add(lblNewLabel);
		
		textName = new JTextField();
		textName.setBounds(191, 41, 129, 20);
		contentPane.add(textName);
		textName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Age");
		lblNewLabel_1.setBounds(85, 91, 70, 14);
		contentPane.add(lblNewLabel_1);
		
		textAge = new JTextField();
		textAge.setBounds(191, 88, 129, 20);
		contentPane.add(textAge);
		textAge.setColumns(10);
		
		JLabel lblResult = new JLabel("");
		lblResult.setBounds(50, 216, 336, 34);
		contentPane.add(lblResult);
		
		JButton btnOkay = new JButton("Okay");
		btnOkay.setBounds(115, 167, 70, 23);
		btnOkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textName.getText();
				int age = Integer.parseInt(textAge.getText());
				if (age >= 18) {
					lblResult.setText(name + "You are eligible to Vote");
				} else {
					lblResult.setText(name + " You are NOT eligible to Vote");
				}
			}
		});
		contentPane.add(btnOkay);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textName.setText("");
				textAge.setText("");
				lblResult.setText("");
			}
		});
		btnReset.setBounds(210, 167, 89, 23);
		contentPane.add(btnReset);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 191, 67, 59);
		contentPane.add(panel);
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
	}
}
