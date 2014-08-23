// Nader K
// Employee abstract superclass


public abstract class Employee implements Company
{
   private String empName;
   
   
   // constructor with one parameter of employee name
   public Employee(String name)
   {
      empName = name;
   }

   // set name method
   public void setEmpName(String name)
   {
      empName = name;
   }
   
   // get name method
   public String getEmpName()
   {
      return empName;
   }
   
   // abstract method earnings
   public abstract double earnings();
   
}// end class Employee