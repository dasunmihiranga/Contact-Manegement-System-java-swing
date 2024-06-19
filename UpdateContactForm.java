import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class UpdateContactForm extends JFrame {
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtContactNumber;
	private JTextField txtCompany;
	private JTextField txtSalary;
	private JTextField txtBirthday;

	private JButton btnUpdate;
	private JButton btnCancel;
	private JButton btnHome;

	UpdateContactForm() {
		setSize(600, 600);
		setTitle("Update Contact Form");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		// Top Panel
		JPanel topPanel = new JPanel(new GridLayout(2, 1));
		JPanel titlePanel = new JPanel(new BorderLayout());
		JLabel titleLabel = new JLabel("UPDATE CONTACT");
		titleLabel.setFont(new Font("", Font.BOLD, 40));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titlePanel.setBackground(new Color(102, 204, 255));
		titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		titlePanel.add(titleLabel, BorderLayout.CENTER);

		JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		searchPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		JTextField searchField = new JTextField();
		searchField.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 100));
		searchField.setPreferredSize(new Dimension(300, 30)); // Set preferred size
		JButton btnSearch = new JButton("Search");

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String namepn = searchField.getText();
				int index = ContactList.search(namepn);
				if (index > -1) {
					ContactList contactList = DBConnection.getInstance().getContactList();
					Contact contact = contactList.get(index);
					

					txtId.setText(contact.getCid());
					txtName.setText(contact.getName());
					txtContactNumber.setText(contact.getPn());
					txtCompany.setText(contact.getComName());
					txtSalary.setText(String.valueOf(contact.getSalary()));
					txtBirthday.setText(contact.getBday());

				} else {
					JOptionPane.showMessageDialog(null, "Contact not found!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSearch.setBackground(new Color(128, 203, 196));

		searchPanel.add(searchField);
		searchPanel.add(btnSearch);

		topPanel.add(titlePanel);
		topPanel.add(searchPanel);

		// Left Panel
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		

		JLabel[] labels = {
				new JLabel("Contact ID"),
				new JLabel("Name"),
				new JLabel("Contact Number"),
				new JLabel("Company"),
				new JLabel("Salary"),
				new JLabel("Birthday")

		};

		for (JLabel label : labels) {
			label.setFont(new Font("", Font.BOLD, 20));
			leftPanel.add(Box.createVerticalStrut(20));
			leftPanel.add(label);
		}

		// Right Panel
		JPanel rightPanel = new JPanel(new BorderLayout());

		JPanel textPanel = new JPanel();
		textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
		textPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

		txtId = new JTextField(20);
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
		textPanel.add(Box.createVerticalStrut(20));

		JPanel finalTextPanel = new JPanel(new BorderLayout());
		finalTextPanel.add(textPanel, BorderLayout.NORTH);
		rightPanel.add(finalTextPanel, BorderLayout.CENTER);

		// Button Panel
		JPanel btnPanel = new JPanel(new BorderLayout());
		JPanel TopbtnPanel = new JPanel(new FlowLayout());
		JPanel BottombtnPanel = new JPanel();
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtId.getText();
				String name = txtName.getText();
				String contactNumber = txtContactNumber.getText();
				String company = txtCompany.getText();
				double salary = Double.parseDouble(txtSalary.getText());
				String birthday = txtBirthday.getText();

				String namepn = searchField.getText();
				int index = ContactList.search(namepn);
				if (index > -1) {
					ContactList contactList = DBConnection.getInstance().getContactList();
					Contact contact = contactList.get(index);
					contact.setCid(id);
					contact.setName(name);
					contact.setPn(contactNumber);
					contact.setComName(company);
					contact.setSalary(salary);
					contact.setBday(birthday);
					// DBConnection.getInstance().updateContact(contact);
					JOptionPane.showMessageDialog(null, "Contact updated successfully!", "Success",
							JOptionPane.INFORMATION_MESSAGE);
					// Clear all text fields
					searchField.setText("");
					txtId.setText("");
					txtName.setText("");
					txtContactNumber.setText("");
					txtCompany.setText("");
					txtSalary.setText("");
					txtBirthday.setText("");

				}
			}
		});
		btnUpdate.setBackground(new Color(76, 175, 80));
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				 // Clear all text fields
				 searchField.setText("");
				 txtName.setText("");
				 txtContactNumber.setText("");
				 txtCompany.setText("");
				 txtSalary.setText("");
				 txtBirthday.setText("");
            }
        });
		btnCancel.setBackground(new Color(244, 67, 54));
		btnHome = new JButton("Back To HomePage");
		btnHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

				dispose();
                
            }
        });
		btnHome.setBackground(Color.WHITE);
		TopbtnPanel.add(btnUpdate);
		TopbtnPanel.add(btnCancel);
		BottombtnPanel.add(btnHome);
		JPanel FinalbtnPanel = new JPanel(new GridLayout(2, 1));
		FinalbtnPanel.add(TopbtnPanel);
		FinalbtnPanel.add(BottombtnPanel);
		btnPanel.add(FinalbtnPanel, BorderLayout.EAST);
		rightPanel.add(btnPanel, BorderLayout.SOUTH);

		// Main Panel
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.add(leftPanel, BorderLayout.WEST);
		mainPanel.add(rightPanel, BorderLayout.CENTER);

		add(mainPanel);
	}

}
