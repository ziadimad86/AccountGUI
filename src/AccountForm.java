import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AccountForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtAccNo;
	private JTextField textAccName;
	private JTextField txtAccAmount;
	private JTextField txtAmountDeposite;
	private JTextField txtAmountWithdraw;
	Account a1 = new TbiAccount();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountForm frame = new AccountForm();
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
	public AccountForm() {
		setTitle("Account Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAccountNumber = new JLabel("Account Number");
		lblAccountNumber.setBounds(10, 29, 105, 14);
		contentPane.add(lblAccountNumber);
		
		txtAccNo = new JTextField();
		txtAccNo.setBounds(10, 51, 86, 20);
		contentPane.add(txtAccNo);
		txtAccNo.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(108, 29, 88, 14);
		contentPane.add(lblName);
		
		textAccName = new JTextField();
		textAccName.setColumns(10);
		textAccName.setBounds(108, 51, 86, 20);
		contentPane.add(textAccName);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmount.setBounds(206, 29, 88, 14);
		contentPane.add(lblAmount);
		
		txtAccAmount = new JTextField();
		txtAccAmount.setColumns(10);
		txtAccAmount.setBounds(206, 51, 86, 20);
		contentPane.add(txtAccAmount);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				a1.insert(Integer.parseInt(txtAccNo.getText()), textAccName.getText(), Integer.parseInt(txtAccAmount.getText()));
				JOptionPane.showMessageDialog(AccountForm.this,"Account Inserted Sucessfully");
				txtAccNo.setText("");
				textAccName.setText("");
				txtAccAmount.setText("");
			}
		});
		btnInsert.setBounds(310, 50, 89, 23);
		contentPane.add(btnInsert);
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StringBuilder str=new StringBuilder("");
				str.append("Account Number : ").append(a1.acc_no)
				.append("\n Name : ").append(a1.name)
				.append("\n Amount : ").append(a1.amount);
				JOptionPane.showMessageDialog(AccountForm.this,str);
			}
		});
		btnDisplay.setBounds(26, 111, 89, 23);
		contentPane.add(btnDisplay);
		
		JButton btnCheckBalance = new JButton("Check Balance");
		btnCheckBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(AccountForm.this,"Amount : "+a1.amount);
			}
		});
		btnCheckBalance.setBounds(137, 111, 133, 23);
		contentPane.add(btnCheckBalance);
		
		JButton btnDeposite = new JButton("Deposite");
		btnDeposite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				a1.deposit(Integer.parseInt(txtAmountDeposite.getText()));
				JOptionPane.showMessageDialog(AccountForm.this, "Deposite Sucessfully");
				txtAmountDeposite.setText("");
			}
		});
		btnDeposite.setBounds(222, 168, 89, 23);
		contentPane.add(btnDeposite);
		
		JLabel label_2 = new JLabel("Amount");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(27, 172, 88, 14);
		contentPane.add(label_2);
		
		txtAmountDeposite = new JTextField();
		txtAmountDeposite.setColumns(10);
		txtAmountDeposite.setBounds(110, 169, 86, 20);
		contentPane.add(txtAmountDeposite);
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				a1.withdraw(Integer.parseInt(txtAmountWithdraw.getText()));
				JOptionPane.showMessageDialog(AccountForm.this, "Withdraw Sucessfully");
				txtAmountWithdraw.setText("");
			}
		});
		btnWithdraw.setBounds(222, 207, 89, 23);
		contentPane.add(btnWithdraw);
		
		JLabel label_3 = new JLabel("Amount");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(26, 211, 88, 14);
		contentPane.add(label_3);
		
		txtAmountWithdraw = new JTextField();
		txtAmountWithdraw.setColumns(10);
		txtAmountWithdraw.setBounds(110, 208, 86, 20);
		contentPane.add(txtAmountWithdraw);
	}
}
