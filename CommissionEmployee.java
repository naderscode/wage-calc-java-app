// Nader K
// CommissionEmployee subclass

public class CommissionEmployee extends Employee implements Company
{ 
   private double grossSales;
   private double commissionRate;
   
   // construtor with 3 parameters
   public CommissionEmployee(String name, double sales, double rate)
   {
      super(name);
      grossSales = sales;
      commissionRate = rate;
   }
   
   // constructor with 2 parameters
   public CommissionEmployee(String name, double sales)
   {
      super(name);
      grossSales = sales;
      commissionRate = 0.05;
   
   }
   
   
   // set grossSales
   public void setGrossSales(double sales)
   {
      if(sales>=0.0)
      grossSales = sales;
       else throw new IllegalArgumentException("Wage must be greater than or equal to zero");
   }
   
   // get grossSales
   public double getGrossSales()
   {
      return grossSales;
   }
   
   // set commissionRate
   public void setCommissionRate(double rate)
   {
     if(rate >=0.0 && rate < 1.00)
      commissionRate = rate;
       else throw new IllegalArgumentException("rate must be between zero and one");
   }
   
   // get commissionRate
   public double getCommissionRate()
   {
      return commissionRate;
   
   }
   
   // override abstract earning method of superclass
   public double earnings()
   {
      return grossSales * commissionRate;
   
   } 
   
    public String tellAboutSelf()
    {
      return String.format("" + super.companyName +"\n"+"Commision Based Employee\n"+ "Name: " + super.getEmpName()+"\n" + "Earnings: " + "$"+ earnings()+"\n");   
    }
  
}// end class CommissionEmployee