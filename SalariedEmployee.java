// Nader K
// SalariedEmployee subclass 

public class SalariedEmployee extends Employee implements Company
{
   //attribute
   private double weeklySalary;
   
   // constructor
   public SalariedEmployee(String name, double salary)
   {
      super(name);
      weeklySalary = salary; 
   }
   
   // constructor with one parameter of empName and default salary of $800
   public SalariedEmployee(String name)
   {
      super(name);
      weeklySalary = 800.0;
   }
   
   
   
   // method setWeeklySalary
   public void setWeeklySalary(double salary)
   {
      
      if(salary>=0)
      weeklySalary = salary;
      else throw new IllegalArgumentException("Salary must be greater than or equal to zeror");
        
   }

   // method getWeeklySalary
   public double getWeeklySalary()
   {
      return weeklySalary;
   
   }
   
   // override abstract method earnings in superclass Employee
   public double earnings()
   {
      return getWeeklySalary();
   
   }
   
   // override abstract interface method
   public String tellAboutSelf()
   {
      return String.format("" + super.companyName +"\n"+"Salary Based Employee\n"+ "Name: " + super.getEmpName()+"\n" + "Earnings: " + "$"+ earnings()+"\n");
   }

}