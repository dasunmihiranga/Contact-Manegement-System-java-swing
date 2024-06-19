import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ContatctListForm extends JFrame{
    private JPanel MainPanel;
    private JButton btnlistName;
    private JButton btnlistSalary;
    private JButton btnlistBirthday;
    private JButton[] btnArray;
    private JButton btnExit;

    private ListbyNameForm listbyNameForm;
    private ListbySalaryForm listbySalaryForm;
    ContatctListForm(){
        setSize(500, 500);
        setTitle("Contact List Form");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        //setResizable(false);

         // Top Panel
         JPanel topPanel = new JPanel(new GridLayout(2, 1));
         JPanel titlePanel = new JPanel(new BorderLayout());
         JLabel titleLabel = new JLabel("CONTACT LIST");
         titleLabel.setFont(new Font("", Font.BOLD, 40));
         titleLabel.setHorizontalAlignment(JLabel.CENTER);
         titlePanel.setBackground(new Color(102, 204, 255));
         titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
         titlePanel.add(titleLabel, BorderLayout.CENTER);
         topPanel.add(titlePanel);

         // Buttons
        btnArray = new JButton[3];
        String[] buttonName = {"List by Name","List by Salary","List by Birthday"};
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBounds(200, 130, 300, 40);

        for (int i = 0; i < 3; i++) {
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
				if(listbyNameForm==null){
					listbyNameForm=new ListbyNameForm();
				}
				listbyNameForm.setVisible(true);
			}
		});
        btnArray[1].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(listbySalaryForm==null){
					listbySalaryForm=new ListbySalaryForm();
				}
				listbySalaryForm.setVisible(true);
			}
		});
        btnArray[2].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(listbyNameForm==null){
					listbyNameForm=new ListbyNameForm();
				}
				listbyNameForm.setVisible(true);
			}
		});

        btnExit = new JButton("Cancel");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

				dispose();
                
            }
        });
        btnExit.setFont(new Font("", Font.BOLD, 20));
        btnExit.setAlignmentX(Component.LEFT_ALIGNMENT); // Align to the right
        btnExit.setMaximumSize(new Dimension(120, 35)); // Optional: Fix button size
        btnExit.setBackground(Color.WHITE);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 30))); // Add spacing before the "Exit" button
        buttonPanel.add(btnExit);

         MainPanel=new JPanel(new BorderLayout());
         MainPanel.add("North",topPanel);
         MainPanel.add("Center",buttonPanel);

         add(MainPanel, BorderLayout.CENTER);
    }
}
