public class Employee {
        int empid;
	 String firstName;
	 String lastName;
    	static int count = 0; 
	int salary;
	char grade;
	int date;
	int dd, mm, yyyy;
	

public Employee(){
        
	firstName= "";
	lastName= "";
	salary= 0;
	grade= ' ';
	 

}
public Employee(String fn,String ln,int sal, char grd, int dd, int mm, int yyyy){
	this.firstName=fn;
	this.lastName=ln;
	this.salary=sal;
	this.grade=grd;
	this.dd=dd;
	this.mm=mm;
	this.yyyy=yyyy;
	
        

}
public void displayDetails(){
	count++;
	System.out.println("empid      : "+count);
	System.out.println("Firstname  : "+firstName);
	System.out.println("lastName   : "+lastName);
	System.out.println("salary     : "+salary);
	System.out.println("grade      : "+grade);
	System.out.println("Date       : "+dd+ "/" +mm+ "/" +yyyy);

	
 
	
}
public Invoice[] getInvoices(){
	return null;
}
class Invoice{
}
}	


