public class Employee {
    private long employeeNum;
    private String employeeName;


    public boolean checkPermission() {
        return false;
    }

    public long getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(long employeeNum) {
        this.employeeNum = employeeNum;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
}