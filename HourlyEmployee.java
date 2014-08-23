// Nader K
// HourlyEmployee subclass


public class HourlyEmployee extends Employee implements Company
{
   private double wage;
   private double hours;

   // constructor
   public HourlyEmployee(String name, double heWage, double heHours)
   {
      super(name);
      wage = heWage;
      hours = heHours;
   }

   // constructor with default wage
   public HourlyEmployee(String name, double heHours)
   {
   
      super(name);
      hours = heHours;
      wage = 8.0;
   
    }
    
    // set wage
    public void setWage(double heWage)
    {
      if(heWage>=0.0)
         wage = heWage;
         else throw new IllegalArgumentException("Wage must be greater than or equal to zero");
    }
    
    // get wage
    public double getWage()
    {
      return wage;
    }
    
    
    // set hours
    public void setHours(double heHours)
    {
      if((heHours>=0.0)&& (heHours<=168))
      hours = heHours;
      else throw new IllegalArgumentException("Hours must be between zero and 168");
    
    }
    // get hours
    public double getHours()
    {
      return hours;
    }
    
    
    // override the earning method in superclass
    public double earnings()
    {
      if(getHours() <= 40.0)// regular wage
         return getHours() * getWage();
      else
         return getWage() * 40.0 + getWage() * 1.5 * (getHours() - 40.0); // calculate regular wage plus over time 
    }
   
    public String tellAboutSelf()
    {
      return String.format("" + super.companyName +"\n"+"Hourly Based Employee\n"+ "Name: " + super.getEmpName()+"\n" + "Earnings: " + "$"+ earnings()+"\n");   
    }

   
}// end class HourlEmployee