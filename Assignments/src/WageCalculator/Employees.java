package WageCalculator;
//array list of <Employee>
import java.util.ArrayList;

public class Employees{
	private ArrayList<String> employees;
	
	public Employees() {
		this.employees = new ArrayList<>();;
	}

    // Method to add an employee
    public void addEmployee(String employee) {
        employees.add(employee);
    }

    // Method to get the list of employees
    public ArrayList<String> getEmployees() {
        return employees;
    }
   
}
