// Richard Murray CISC181-011
package retirement;

import java.util.Scanner;
import java.lang.Math;
public class Retirment_plan {
	
	public static void main(String[] args ){
		
		Scanner input= new Scanner(System.in);
		
		System.out.println("How many years will you be working for?");
		double years_worked=input.nextDouble();
		System.out.println("What will your annual return be while working? (%)");
		double annual_return1=input.nextDouble();
		System.out.println("How many years will you be retired?");
		double years_retired=input.nextDouble();
		System.out.println("What will your annual return be while retired? (%)");
		double annual_return2=input.nextDouble();
		System.out.println("What is your required monthly income while retired? ($)");
		double monthly_income=input.nextDouble();
		System.out.println("What is your expected monthly SSI? ($)");
		double monthly_SSI=input.nextDouble();
		
		
		int months_retired = (int) (12*years_retired);
		double withdraw = monthly_income-monthly_SSI;
		double reverse_monthly_interest= (1/(1+(annual_return2/1200)));
		double annuity_balance=withdraw;
		for (int i = 2; i<=months_retired;i++){
			annuity_balance=(annuity_balance+withdraw)*reverse_monthly_interest;
		}
		System.out.format("%nBalance of annuity at retirement: $%,.2f %n" ,annuity_balance);
		
		
		int months_worked = (int)(12*years_worked);
		// actual interest summation for working period 
		double actual_interest1 = 0 ;
		for (int i=0; i<months_worked;i++){
			actual_interest1 = actual_interest1 + Math.pow((1+annual_return1/1200),i);
			}
		double monthly_save = annuity_balance/actual_interest1;		
		System.out.format("You should save $%,.2f per month while you are working. %n", monthly_save);
		
	}
}