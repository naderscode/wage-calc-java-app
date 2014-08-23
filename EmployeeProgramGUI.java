// Nader K
// Main GUI application using Swing

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class EmployeeProgramGUI extends JFrame 
{
     private JLabel headerLabel, nameLabel, salesLabel, rateLabel, salaryLabel, wageLabel, hoursLabel;
     private JTextField nameField,salesField, rateField, salaryField, wageField, hoursField;
     private JButton addButton, earnButton, printButton, clearButton, closeButton;
     private JRadioButton salaryRB, commissionRB, hourlyRB;
     private JPanel namePanel, salaryPanel, commissionPanel, hourlyPanel, jpRadioButtons, buttonsPanel,inputPanel, messagePanel;
     private JTextArea messageArea;
         
     private static final int WIDTH =600;
     private static final int HEIGHT = 700;
     
     private NameFieldHandler  nfHandler;
      
     private AddButtonHandler abHandler;
     private EarnButtonHandler ebHandler;
     private PrintButtonHandler pbHandler;
     private ClearButtonHandler clbHandler;
     private CloseButtonHandler cbHandler;
     
     private EventListener listener;
     private ButtonGroup rbGroup;
     
     private String name;
     
         SalariedEmployee sEmployee = new SalariedEmployee("", 0.0);
         HourlyEmployee hEmployee = new HourlyEmployee("", 0.0);
         CommissionEmployee cEmployee = new CommissionEmployee("", 0.0);


             
     public EmployeeProgramGUI()
     {
         
          // set window title
         setTitle("Employee Payroll");
         
         // get Container
         Container pane = getContentPane();
         
         setSize(WIDTH, HEIGHT);
         
         //set layout
        // pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
         pane.setLayout(new GridLayout(10, 1));
         
         headerLabel = new JLabel("First International Resource Management, Inc.", JLabel.CENTER);
         pane.add(headerLabel, BorderLayout.NORTH);
         Font headerFont = new Font("serif", Font.BOLD, 24);
         headerLabel.setFont(headerFont);
         
         namePanel = new JPanel();
         namePanel.setLayout(new GridLayout(1,3));
         pane.add(namePanel);
         
         nameLabel = new JLabel("Employee Name: ");
         nameLabel.setHorizontalAlignment(JTextField.RIGHT);
         nameLabel.setFont(new Font("serif",Font.PLAIN,18));
         namePanel.add(nameLabel);
         
         nameField = new JTextField();
         namePanel.add(nameField);
         
          // create name field handler
         nfHandler = new NameFieldHandler();
         nameField.addActionListener(nfHandler);
         nameField.addActionListener(abHandler);
         
         jpRadioButtons = new JPanel();
         jpRadioButtons.setLayout(new GridLayout(1,3));
         salaryRB = new JRadioButton("Salary");
         commissionRB = new JRadioButton("Commission");
         hourlyRB = new JRadioButton("Hourly");
         jpRadioButtons.add(salaryRB);
         jpRadioButtons.add(commissionRB);
         jpRadioButtons.add(hourlyRB);
        
         pane.add(jpRadioButtons);
         //salaryRB.setSelected(true);
         
         
         
         // create radio button group
         rbGroup = new ButtonGroup();
         rbGroup.add(salaryRB);
         rbGroup.add(commissionRB);
         rbGroup.add(hourlyRB);
         
         // set keybord mnemonic
         salaryRB.setMnemonic('S');// Alt S
         commissionRB.setMnemonic('C');//Alt C
         hourlyRB.setMnemonic('H');//Alt H
                    
          salaryPanel  = new JPanel();
          salaryPanel.setLayout(new GridLayout(1,2));
          pane.add(salaryPanel);
          
          salaryLabel = new JLabel("Weekly Salary: ");
          salaryPanel.add(salaryLabel);
          salaryField = new JTextField();
          salaryPanel.add(salaryField);
          
                 
         commissionPanel  = new JPanel();
         commissionPanel.setLayout(new GridLayout(2,2));
         pane.add(commissionPanel);
         
         salesLabel = new JLabel("Gross Sales: ");
         commissionPanel.add(salesLabel);
         salesField = new JTextField();
         commissionPanel.add(salesField);
        
         
         rateLabel = new JLabel("Comm Rate: ");
         commissionPanel.add(rateLabel);
         rateField = new JTextField();
         commissionPanel.add(rateField);
         
         hourlyPanel  = new JPanel();
         hourlyPanel.setLayout(new GridLayout(2,2));
         pane.add(hourlyPanel);
         wageLabel = new JLabel("Wage: ");
         hourlyPanel.add(wageLabel);
         wageField = new JTextField();
         hourlyPanel.add(wageField);
         hoursLabel = new JLabel("Hours: ");
         hourlyPanel.add(hoursLabel);
         hoursField = new JTextField();
         hourlyPanel.add(hoursField);
         
         //add input panel
         inputPanel = new JPanel();
         inputPanel.setLayout(new FlowLayout());
         pane.add(inputPanel);
         inputPanel.add(salaryPanel);
         inputPanel.add(commissionPanel);
         inputPanel.add(hourlyPanel);

                
         buttonsPanel = new JPanel();
         buttonsPanel.setLayout(new GridLayout(1,5));
         pane.add(buttonsPanel);
         
         addButton = new JButton("Add");
         buttonsPanel.add(addButton);
         abHandler = new AddButtonHandler();
         addButton.addActionListener(abHandler);
         
         earnButton = new JButton("Earn");
         buttonsPanel.add(earnButton);
         ebHandler = new EarnButtonHandler();
         earnButton.addActionListener(ebHandler);

         
         printButton = new JButton("Print");
         buttonsPanel.add(printButton);
         pbHandler = new PrintButtonHandler();
         printButton.addActionListener(pbHandler);

         
         clearButton = new JButton("Clear");
         buttonsPanel.add(clearButton);
         clbHandler = new ClearButtonHandler();
         clearButton.addActionListener(clbHandler);

         
         closeButton = new JButton("Close");
         buttonsPanel.add(closeButton);
         cbHandler = new CloseButtonHandler();
         closeButton.addActionListener(cbHandler);

         // add message panel
         
         messageArea = new JTextArea();
         
         messagePanel=new JPanel();
         messagePanel.setLayout(new FlowLayout());
         pane.add(messagePanel);
         messagePanel.add(messageArea);
         messageArea.setEditable(false);
         messagePanel.setSize(400,350);
         //-------------------------------------------------
         messageArea.setBounds(3, 3, 300, 350);
         Font font = new Font("Verdana", Font.BOLD, 12);
         messageArea.setFont(font);
         messageArea.setForeground(Color.BLUE);
         messageArea.setSize(400,350);
         messageArea.setBackground(Color.YELLOW);
         
         
                
         EventListener listener = new EventListener();
         salaryRB.addActionListener(listener);
         commissionRB.addActionListener(listener);
         hourlyRB.addActionListener(listener);
                
         salaryField.addActionListener(abHandler);
         salesField.addActionListener(abHandler);
         rateField.addActionListener(abHandler);
         wageField.addActionListener(abHandler);
         hoursField.addActionListener(abHandler);
        
         
         commissionPanel.setVisible(false); 
         hourlyPanel.setVisible(false); 
         salaryPanel.setVisible(false);
   
         buttonsPanel.setSize(500, 50);
             
         setSize(WIDTH, HEIGHT);
         setVisible(true);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
              
     }// end constructor
     
      private class NameFieldHandler implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
               
               name=nameField.getText();
               //make sure name field is not empty
               if(!name.isEmpty())
               {
               
                 name = (nameField.getText());
                  
                  //JOptionPane.showMessageDialog(null,"Employee Payroll",JOptionPane.INFORMATION_MESSAGE);

               }
                else
                {
                     JOptionPane.showMessageDialog(null, "Invalid entry. You must enter your name: ","EXCEPTION ",JOptionPane.ERROR_MESSAGE);
   
                }// end else
         
         }// end 
      }//end NameFieldHandler
  
        
  private class EventListener implements ActionListener
  {
   
   public void actionPerformed(ActionEvent e)
   {
            
      if(e.getSource()==salaryRB)
      {
      salaryPanel.setVisible(true);
      commissionPanel.setVisible(false); 
      hourlyPanel.setVisible(false); 
      
        
           
    }
    else  
      if(e.getSource()==commissionRB)
      {
      commissionPanel.setVisible(true); 
      hourlyPanel.setVisible(false); 
      salaryPanel.setVisible(false);  
      }
    else
      if(e.getSource()==hourlyRB)
      {
      commissionPanel.setVisible(false); 
      hourlyPanel.setVisible(true); 
      salaryPanel.setVisible(false);
      }
           
   }// end action performed

 }// end class Button Listener      
     private class AddButtonHandler implements ActionListener
    {
         public void actionPerformed(ActionEvent e)
         {
               if(!salaryField.getText().equals("")) 
               {             
                    
                    sEmployee.setWeeklySalary(Double.parseDouble(salaryField.getText()));                     
                    sEmployee.setEmpName(nameField.getText());
               }
            else 
                if((!salesField.getText().equals(""))&&(!rateField.getText().equals("")))
               {
                    cEmployee.setGrossSales(Double.parseDouble(salesField.getText()));
                    cEmployee.setCommissionRate(Double.parseDouble(rateField.getText()));
                    cEmployee.setEmpName(nameField.getText());
                   
               }
            else
               if((!wageField.getText().equals(""))&&(!hoursField.getText().equals("")))
               {

                    hEmployee.setWage(Double.parseDouble(wageField.getText()));
                    hEmployee.setHours(Double.parseDouble(hoursField.getText()));
                    hEmployee.setEmpName(nameField.getText());
                    
              } 
              
              JOptionPane.showMessageDialog(EmployeeProgramGUI.this,"Employee data added.");

     
         }//end action performed
    
    }//ButtonHandler
    
     private class EarnButtonHandler implements ActionListener
    {
         public void actionPerformed(ActionEvent e)
         { 
            
               if(!salaryField.getText().equals(""))
               {
               
               sEmployee.earnings();
               messageArea.setText(""+sEmployee.getEmpName()+"'s Earnings: $"+sEmployee.earnings());
               }
            else if ((!salesField.getText().equals(""))&&(!rateField.getText().equals("")))
               {            
               cEmployee.earnings();
               messageArea.setText(""+cEmployee.getEmpName()+"'s Earnings: $"+cEmployee.earnings());
               }
            else if((!wageField.getText().equals(""))&&(!hoursField.getText().equals(""))) 
               {
               hEmployee.earnings();
               messageArea.setText(""+hEmployee.getEmpName()+"'s Earnings: $"+hEmployee.earnings());
               }
                        
         }
    
    }//ButtonHandler
    
    private class PrintButtonHandler implements ActionListener
    {
         public void actionPerformed(ActionEvent e)
     {
       String message="";
       
       
        if(!salaryField.getText().equals(""))
        {
             message = sEmployee.tellAboutSelf();
             messageArea.setText(message);
             System.out.println(""+ message);
            // JOptionPane.showMessageDialog(EmployeeProgramGUI.this,""+ sEmployee.tellAboutSelf());

        
        }
   
         
         else  if((!salesField.getText().equals(""))&&(!rateField.getText().equals("")))
         {
            message = cEmployee.tellAboutSelf();
            messageArea.setText(message);
            System.out.println(""+ message);
            //JOptionPane.showMessageDialog(null,""+ cEmployee.tellAboutSelf());

         }
         else if((!wageField.getText().equals(""))&&(!hoursField.getText().equals(""))) 
            {
            message = hEmployee.tellAboutSelf();
            messageArea.setText(message);
            System.out.println(""+ message);
            //JOptionPane.showMessageDialog(null,""+ hEmployee.tellAboutSelf());
}
   
     }// end AP
    
    }//ButtonHandler
    
     private class ClearButtonHandler implements ActionListener
    {
         public void actionPerformed(ActionEvent e)
         {
            nameField.setText("");
            salesField.setText("");
            rateField.setText("");
            salaryField.setText("");
            wageField.setText(""); 
            hoursField.setText("");
            messageArea.setText("");
           
         }
    
    }//ButtonHandler


    private class CloseButtonHandler implements ActionListener
    {
         public void actionPerformed(ActionEvent e)
         {
            System.exit(0);
         }
    
    }// end class CloseButtonHandler

     public static void main(String[]args)
    {
      EmployeeProgramGUI exam1p = new EmployeeProgramGUI();  
    }// end main

}// end class