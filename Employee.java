public abstract class Employee {
    protected String employeeName;
    protected  int idNumber;
    protected String employeeJob;
    protected int employeePhoneNumber;
    protected String employeeEmail;
    protected String workProgress;

    public Employee(String en, int id, String ej, int epn, String ee) {
        employeeName = en;
        idNumber = id;
        employeeJob = ej;
        employeePhoneNumber = epn;
        employeeEmail = ee;
    }
    public abstract String notifyCompletedWorks(String wp);
    public void setProgress(String wp) {
        workProgress = wp;
    }

}
