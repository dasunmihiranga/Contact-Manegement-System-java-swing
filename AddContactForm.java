import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AddCustomerForm extends JFrame {
	private JButton btnAddContact;
	private JButton btnCancel;
	private JButton btnHome;

	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtContactNumber;
	private JTextField txtCompany;
	private JTextField txtSalary;
	private JTextField txtBirthday;
	private JPanel MainPanel;

	AddCustomerForm() {
		setSize(600, 550);
		setTitle("Add Contact Form");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		// Title Panel
		JPanel labelpanel = new JPanel(new BorderLayout());
		JPanel titlelabelpanel = new JPanel(new BorderLayout());
		JLabel titleLabel1 = new JLabel("ADD CONTACT");
		titleLabel1.setFont(new Font("", Font.BOLD, 40));
		titleLabel1.setHorizontalAlignment(JLabel.CENTER);
		titlelabelpanel.setBackground(new Color(102, 204, 255));
		titlelabelpanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // Add padding
		titlelabelpanel.add(titleLabel1, BorderLayout.CENTER);

		
		labelpanel.add(titlelabelpanel, BorderLayout.NORTH);

		// Left Panel
		JPanel leftPanel = new JPanel();

		// Right Panel
		JPanel rightPanel = new JPanel(new BorderLayout());

		// Labels Panel
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
		labelPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

		JLabel lblId = new JLabel("Contact ID " );
		lblId.setFont(new Font("", Font.BOLD, 20));
		labelPanel.add(lblId);
		labelPanel.add(Box.createVerticalStrut(20));

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("", Font.BOLD, 20));
		labelPanel.add(lblName);

		labelPanel.add(Box.createVerticalStrut(20)); // Add spacing

		JLabel lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setFont(new Font("", Font.BOLD, 20));
		labelPanel.add(lblContactNumber);

		labelPanel.add(Box.createVerticalStrut(20)); // Add spacing

		JLabel lblCompany = new JLabel("Company");
		lblCompany.setFont(new Font("", Font.BOLD, 20));
		labelPanel.add(lblCompany);

		labelPanel.add(Box.createVerticalStrut(20)); // Add spacing

		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("", Font.BOLD, 20));
		labelPanel.add(lblSalary);

		labelPanel.add(Box.createVerticalStrut(20)); // Add spacing

		JLabel lblBirthday = new JLabel("Birthday");
		lblBirthday.setFont(new Font("", Font.BOLD, 20));
		labelPanel.add(lblBirthday);

		leftPanel.add(labelPanel);

		// Text Fields Panel
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
		textPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

		txtId = new JTextField(20);
		txtId.setText(ContactList.generateContactId());
		txtId.setFont(new Font("", Font.PLAIN, 20));
		textPanel.add(txtId);

		textPanel.add(Box.createVerticalStrut(20));

		txtName = new JTextField(20);
		txtName.setFont(new Font("", Font.PLAIN, 20));
		textPanel.add(txtName);

		textPanel.add(Box.createVerticalStrut(20)); // Add spacing

		txtContactNumber = new JTextField(20);
		txtContactNumber.setFont(new Font("", Font.PLAIN, 20));
		textPanel.add(txtContactNumber);

		textPanel.add(Box.createVerticalStrut(20)); // Add spacing

		txtCompany = new JTextField(20);
		txtCompany.setFont(new Font("", Font.PLAIN, 20));
		textPanel.add(txtCompany);

		textPanel.add(Box.createVerticalStrut(20)); // Add spacing

		txtSalary = new JTextField(15);
		txtSalary.setFont(new Font("", Font.PLAIN, 20));
		textPanel.add(txtSalary);

		textPanel.add(Box.createVerticalStrut(20)); // Add spacing

		txtBirthday = new JTextField(15);
		txtBirthday.setFont(new Font("", Font.PLAIN, 20));
		textPanel.add(txtBirthday);

		JPanel finaltextPanel = new JPanel(new BorderLayout());
		finaltextPanel.add(textPanel, BorderLayout.NORTH);

		// Button Panel
		JPanel btnPanel = new JPanel(new BorderLayout());

		// validation
		

		JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
		btnAddContact = new JButton("ADD Contact");
		btnAddContact.setBackground(new Color(76, 175, 80));
		btnAddContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

				String id = txtId.getText();
				String name = txtName.getText();
				String contactNumber = txtContactNumber.getText();
				String company = txtCompany.getText();
				double salary = Double.parseDouble(txtSalary.getText());
				String birthday = txtBirthday.getText();

				boolean numberValid = ContactList.numberCheck(contactNumber);
				boolean checkSalary= ContactList.checkSalary(salary);
				boolean checkBirthday = ContactList.checkBirthday(birthday);
				if (numberValid) {
                    int option = JOptionPane.showConfirmDialog(null, "Invalid Phone Number. Do you want to correct it?", "Invalid Phone Number", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        txtContactNumber.setText("");
                        txtContactNumber.requestFocus();
                        return; 
                    } else {
                        
                        return;
                    }
                }

                if (checkSalary) {
                    JOptionPane.showMessageDialog(null, "Invalid Salary format. Please correct it.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                    txtSalary.setText("");
                    txtSalary.requestFocus();
                    return;
                }

                if (checkBirthday) {
                    JOptionPane.showMessageDialog(null, "Invalid Birthday format. Please correct it.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                    txtBirthday.setText("");
                    txtBirthday.requestFocus();
                    return;
                }

                // If all validations pass
                Contact contact = new Contact(id, name, contactNumber, company, salary, birthday);
                ContactList contactList = DBConnection.getInstance().getContactList();
                contactList.add(contact);
				
                // Reset fields after successful addition
                
                txtId.setText(ContactList.generateContactId());
                txtName.setText("");
                txtContactNumber.setText("");
                txtCompany.setText("");
                txtSalary.setText("");
                txtBirthday.setText("");

                JOptionPane.showMessageDialog(null, "Contact added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

				
			}
		});

		btnCancel = new JButton("Cancel");
		btnCancel.setBackground(new Color(244, 67, 54));
		btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				 // Clear all text fields
				 txtName.setText("");
				 txtContactNumber.setText("");
				 txtCompany.setText("");
				 txtSalary.setText("");
				 txtBirthday.setText("");
            }
        });
		topPanel.add(btnAddContact);
		topPanel.add(btnCancel);

		JPanel downPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnHome = new JButton("Back To HomePage");
		btnHome.setBackground(Color.WHITE);
		btnHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

				dispose();
                
            }
        });
		downPanel.add(btnHome);

		btnPanel.add(topPanel, BorderLayout.NORTH);
		btnPanel.add(downPanel, BorderLayout.SOUTH);

		rightPanel.add(finaltextPanel, BorderLayout.CENTER);
		rightPanel.add(btnPanel, BorderLayout.SOUTH);

		// Main Panel
		MainPanel = new JPanel(new BorderLayout());

		MainPanel.add(labelpanel, BorderLayout.NORTH);
		MainPanel.add(rightPanel, BorderLayout.CENTER);
		MainPanel.add(leftPanel, BorderLayout.WEST);

		add(MainPanel);
	}

}
