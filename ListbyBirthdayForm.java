import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

class ListbyBirthdayForm extends JFrame {
    private JPanel MainPanel;
    private JTable tblCustomerDetails;
    private DefaultTableModel dtm;
    private JButton btnHome;
    private JButton btnReload;

    ListbyBirthdayForm() {
        setSize(600, 400);
        setTitle("View Birthday List Form");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel topPanel = new JPanel(new BorderLayout());
        JLabel titLabel = new JLabel("LIST CONTACTS BY BIRTHDAY");
        titLabel.setFont(new Font("", Font.BOLD, 40));
        titLabel.setHorizontalAlignment(JLabel.CENTER);
        topPanel.setBackground(new Color(102, 204, 255));
        topPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        topPanel.add(titLabel, BorderLayout.CENTER);

        String[] columnNames = {"Contact ID", "Name", "Contact Number", "Company", "Salary", "Birthday"};
        dtm = new DefaultTableModel(columnNames, 10);
        tblCustomerDetails = new JTable(dtm);
        JScrollPane tablePane = new JScrollPane(tblCustomerDetails);
        tablePane.setPreferredSize(new Dimension(500, 150));
        JPanel reloadPanel = new JPanel(new FlowLayout());
        btnReload = new JButton("Reload");
        //btnReload.setBackground(new Color(76, 175, 80));
        btnReload.setFont(new Font("", Font.BOLD, 20));
        btnReload.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dtm.setRowCount(0);
                ContactList.SortBirthday();
                
                ContactList.SortBirthday();
                                
                ContactList contactList = DBConnection.getInstance().getContactList();
                for (int i = 0; i < contactList.size(); i++) {
                   
                    Contact contact = contactList.get(i);
                    Object[] rowData = {
                        contact.getCid(),
                        contact.getName(),
                        contact.getPn(),
                        contact.getComName(),
                        contact.getSalary(),
                        contact.getBday()
                    };
                    dtm.addRow(rowData);
                }
				
			}
		});

        // Sorting the contact list by name
       
        JPanel bottomPanel=new JPanel(new FlowLayout());
        btnHome = new JButton("Back To Home");
        btnReload.setBackground(Color.WHITE);
        btnHome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
		
		});        
       
        reloadPanel.add(btnReload);
        bottomPanel.add(reloadPanel);
        bottomPanel.add(btnHome);

        JPanel tablePanel = new JPanel(new FlowLayout());
        tablePanel.add(tablePane, BorderLayout.CENTER);

        MainPanel = new JPanel(new BorderLayout());
        MainPanel.add(topPanel, BorderLayout.NORTH);
        MainPanel.add(tablePanel, BorderLayout.CENTER);
        MainPanel.add(bottomPanel, BorderLayout.SOUTH);


        add(MainPanel);
    }
}