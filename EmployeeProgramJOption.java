// Nader K
// Test JOption Pane, using JOption Pane Dialogs
// Purpose: to test the workability of the methods, class relationships and polymorphic implementation.


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class EmployeeProgramJOption
{ 
           
      
   public static void main(String[]args)
   {
      SalariedEmployee sEmployee = new SalariedEmployee("",0.0);
      HourlyEmployee hEmployee = new HourlyEmployee("", 0.0);
      CommissionEmployee cEmployee = new CommissionEmployee("",0.0);
      
      String selection = "";
      boolean done=false;



        // get user input
         String name = JOptionPane.showInputDialog(null, "Enter Employee Name");
          
          if(!name.isEmpty())
          {
           selection = JOptionPane.showInputDialog( "Enter Corresponding Letter:\n"+ "H-Hourly\n"+"C-Commission\n"+"S-Salary");
           
          }
          else
            {
            JOptionPane.showMessageDialog(null, "Invalid entry. You must enter employee name: ","EXCEPTION ",JOptionPane.ERROR_MESSAGE);
            }
           
      
            
      if((selection.equals("S"))||(selection.equals("s")))
      {
         sEmployee.setEmpName(name);
         
         
         do
         {         
         try
         {
         sEmployee.setWeeklySalary(Double.parseDouble(JOptionPane.showInputDialog(null, "Enter Weekly Salary")));
         done=true;
         }//end try
         catch (NumberFormatException exception)
         {
          JOptionPane.showMessageDialog(null, "Please enter a positive NUMBER for salary\n"+ exception.toString(),"Input Mismatch Exception ",JOptionPane.ERROR_MESSAGE);
         }
         catch(IllegalArgumentException iae)
         {
            JOptionPane.showMessageDialog(null, "Please enter a  NUMBER >= 0.0 for salary\n","Input Mismatch Exception ",JOptionPane.ERROR_MESSAGE);

         } 
      }//end do while
      while(!done);
      
           JOptionPane.showMessageDialog(null,""+ sEmployee.tellAboutSelf());
         }// end if
         
         else
         
         if((selection.equals("C"))||(selection.equals("c")))
         {
             cEmployee.setEmpName(name);
        
        do
        {
        try
        {
        cEmployee.setGrossSales(Double.parseDouble(JOptionPane.showInputDialog(null, "Enter Gross Sales")));
        done=true;
        }// end try
         catch (NumberFormatException exception)
         {
          JOptionPane.showMessageDialog(null, "Please enter a positive NUMBER for sales\n"+ exception.toString(),"Input Mismatch Exception ",JOptionPane.ERROR_MESSAGE);
         } // end catch 
         catch(IllegalArgumentException iae)
         {
            JOptionPane.showMessageDialog(null, "Please enter a  NUMBER >= 0.0 for sales\n","Input Mismatch Exception ",JOptionPane.ERROR_MESSAGE);

         } 

         }// end do while
        while(!done);
         do
         {
         try
         {
           cEmployee.setCommissionRate(Double.parseDouble(JOptionPane.showInputDialog(null, "Enter Commission rate")));
           done=true;
         }
         catch (NumberFormatException exception)
         {
          JOptionPane.showMessageDialog(null, "Please enter a positive NUMBER for rate\n"+ exception.toString(),"Input Mismatch Exception ",JOptionPane.ERROR_MESSAGE);
         } // end catch
         catch(IllegalArgumentException iae)
         {
            JOptionPane.showMessageDialog(null, "rate must be between zero and one\n","Input Mismatch Exception ",JOptionPane.ERROR_MESSAGE);

         } 
 
         }
        while(!done);
       
        JOptionPane.showMessageDialog(null,""+ cEmployee.tellAboutSelf());
         
         }
         
         else if ((selection.equals("H"))||(selection.equals("h")))
         {
         hEmployee.setEmpName(name);
         
         do
         {
         try
         {
         hEmployee.setWage(Double.parseDouble(JOptionPane.showInputDialog(null, "Enter Wage")));
         done=true;
         }
          catch (NumberFormatException exception)
         {
          JOptionPane.showMessageDialog(null, "Please enter a positive NUMBER for wage\n"+ exception.toString(),"Input Mismatch Exception ",JOptionPane.ERROR_MESSAGE);
         } // end catch
         catch(IllegalArgumentException iae)
         {
            JOptionPane.showMessageDialog(null, "Wage must be greater than or equal to zero","Input Mismatch Exception ",JOptionPane.ERROR_MESSAGE);

         } 
 
         }
        while(!done);

         do
         {
         try
         {
         hEmployee.setHours(Double.parseDouble(JOptionPane.showInputDialog(null, "Enter Hours")));
         done=true;
         }
         catch (NumberFormatException exception)
         {
          JOptionPane.showMessageDialog(null, "Please enter a positive NUMBER for hours\n","Input Mismatch Exception ",JOptionPane.ERROR_MESSAGE);
         } // end catch 
         catch(IllegalArgumentException iae)
         {
            JOptionPane.showMessageDialog(null, "Hours must be between zero and 168\n","Input Mismatch Exception",JOptionPane.ERROR_MESSAGE);

         } 

         }
         while(!done);

          JOptionPane.showMessageDialog(null,""+ hEmployee.tellAboutSelf());

      }
     
  }
  
}  
