import java.util.Scanner;

class employee{
	protected float rate = 300.0f, work=10.0f;
			  int hour;
	float calOT(){
		return hour*rate/work;
	}
}
class daily_emp extends employee{

}

class monthly_emp extends employee{
	float pay, bonus;
	float calOT(){
		pay = hour*rate/work;
		if(hour>100)
			pay += bonus;
		return pay;
	}
}

public class InheritOverRideTest{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter total OT hour : ");
		employee emp1 = new employee();
		emp1.hour = scan.nextInt();
		System.out.println("\"Employee\"\nTotal OT Pay = (" + emp1.rate+
			" * " + emp1.hour + ") = " + emp1.calOT()+" BAHT");

		daily_emp emp2 = new daily_emp();
		emp2.hour = emp1.hour;
		System.out.print("\"Daily Employee\"\nRate per Day = ");
		emp2.rate = scan.nextFloat();
		System.out.print("Total OT Pay = (" + emp2.rate + " * "+
			emp2.hour +") = " + emp2.calOT()+ " BAHT");
		monthly_emp emp3 = new monthly_emp();
		emp3.hour = emp1.hour;
		System.out.print("\"Monthly Employee\"\nEnter Salary =  ");
		emp3.rate = scan.nextFloat()/30;
		System.out.print("Enter Bonus = ");
		emp3.bonus = scan.nextFloat();
		System.out.println("Total OT Pay = (" + emp3.rate + "*" +
		emp3.hour + ") + " + emp3.bonus + " = "+emp3.calOT() + "BAHT");
	}
}