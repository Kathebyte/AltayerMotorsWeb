
package backend;

import java.util.List;

public class EmployeeComision {
    
    int employeeId;
    List<Integer> employeeArrays;
    

    public EmployeeComision(int employeeId, List<Integer> employeeArrays) {
        this.employeeId = employeeId;
        this.employeeArrays = employeeArrays;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public List<Integer> getEmployeeArrays() {
        return employeeArrays;
    }

    public void setEmployeeArrays(List<Integer> employeeArrays) {
        this.employeeArrays = employeeArrays;
    }
     
    
    
}
