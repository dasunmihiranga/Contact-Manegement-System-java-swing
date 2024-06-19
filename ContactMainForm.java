import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
class ContactMainForm extends JFrame {


    private JLabel pic;
    private JButton btnArray[];
    private JPanel MainPanel;
    private AddCustomerForm addCustomerForm;
    private UpdateContactForm updateContactForm;
    private SearchContactForm searchContactForm;
    private DeleteContactForm deleteContactForm;
    private ContatctListForm contatctListForm;

    ContactMainForm() {
		
        setSize(1000, 600);
        setTitle("Home Page");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setBackground(new Color(102, 204, 255));
        setResizable(false);

        // Buttons
        btnArray = new JButton[5];
        String[] buttonName = {"Add New Contact", "Update Contact", "Search Contact", "Delete Contact", "View Contact"};
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBackground(new Color(102, 204, 255));

        for (int i = 0; i < 5; i++) {
            btnArray[i] = new JButton(buttonName[i]);
            btnArray[i].setFont(new Font("", Font.BOLD, 20));
            btnArray[i].setAlignmentX(Component.CENTER_ALIGNMENT); // Center-align buttons horizontally
			btnArray[i].setMaximumSize(new Dimension(300, 35)); // Optional: Fix button size
			btnArray[i].setBackground(Color.WHITE);
            //btnArray[i].setPreferredSize(new Dimension(300, 30));
            buttonPanel.add(Box.createVerticalStrut(30)); // Add spacing between buttons
            buttonPanel.add(btnArray[i]);
            
        }
        btnArray[0].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(addCustomerForm==null){
					addCustomerForm=new AddCustomerForm();
				}
				addCustomerForm.setVisible(true);
			}
		});
		btnArray[1].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(updateContactForm==null){
					updateContactForm=new UpdateContactForm();
				}
				updateContactForm.setVisible(true);
			}
		});
        btnArray[2].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(searchContactForm==null){
					searchContactForm=new SearchContactForm();
				}
				searchContactForm.setVisible(true);
			}
		});
        btnArray[3].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(deleteContactForm==null){
					deleteContactForm=new DeleteContactForm();
				}
				deleteContactForm.setVisible(true);
			}
		});
        btnArray[4].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(contatctListForm==null){
					contatctListForm=new ContatctListForm();
				}
				contatctListForm.setVisible(true);
			}
		});

		
		
		// Add a rigid area to push the "Exit" button to the right
		buttonPanel.add(Box.createRigidArea(new Dimension(0, 30))); // Add spacing before the "Exit" button
		JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Terminate the code
            }
        });
		btnExit.setFont(new Font("", Font.BOLD, 20));
		btnExit.setAlignmentX(Component.LEFT_ALIGNMENT); // Align to the right
		btnExit.setMaximumSize(new Dimension(120, 35)); // Optional: Fix button size
		btnExit.setBackground(Color.WHITE);
		buttonPanel.add(btnExit);

		buttonPanel.add(Box.createVerticalStrut(20)); // Add spacing below the last button

        // Image   
        ImageIcon Homeimg = new ImageIcon("Homepage.png");
        Image img = Homeimg.getImage();
        Image resizedImg = img.getScaledInstance(500, 500, Image.SCALE_SMOOTH); // Adjust the width and height as needed
        ImageIcon resizedIcon = new ImageIcon(resizedImg); // Set the resized image icon to the JLabel
        pic = new JLabel(resizedIcon);

        // Labels
        JLabel titleLabel1 = new JLabel("iFREND");
        titleLabel1.setFont(new Font("", Font.BOLD, 50));
        titleLabel1.setHorizontalAlignment(JLabel.CENTER);
        
        JLabel titleLabel2 = new JLabel("Contact Manager");
        titleLabel2.setFont(new Font("", Font.BOLD, 50));
        titleLabel2.setHorizontalAlignment(JLabel.CENTER);

        JLabel titleLabel3 = new JLabel("Home Page");
        titleLabel3.setFont(new Font("", Font.BOLD, 40));
        titleLabel3.setHorizontalAlignment(JLabel.CENTER);
		titleLabel3.add(Box.createVerticalStrut(100)); // Add spacing below the last button

        // Label Panel
        JPanel labelPanel = new JPanel(new GridLayout(2, 1));
        labelPanel.add(titleLabel1);
        labelPanel.add(titleLabel2);

        // Left Panel
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(labelPanel, BorderLayout.NORTH);
        leftPanel.add(pic, BorderLayout.CENTER);
		



        // Right Panel
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(new Color(102, 204, 255));
        rightPanel.add(titleLabel3, BorderLayout.NORTH);
        rightPanel.add(buttonPanel, BorderLayout.CENTER);

        // Main Panel
        MainPanel = new JPanel(new BorderLayout());
        MainPanel.add(rightPanel, BorderLayout.CENTER);
        MainPanel.add(leftPanel, BorderLayout.WEST);
        add(MainPanel);
    }

    public static void main(String args[]){
		new ContactMainForm().setVisible(true);
	}
}
