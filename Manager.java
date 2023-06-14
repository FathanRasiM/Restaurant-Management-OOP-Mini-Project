public class Manager {
    private String managerName;
    private int managerPhoneNumber;
    private String managerEmail;
    private Table tableInformation;

    public Manager(String m, int mp, String me) {
        managerName = m;
        managerPhoneNumber = mp;
        managerEmail = me;
    }
    public void customerFeedback() {
        System.out.println(tableInformation.getFeedback());
    }
    public static void main(String[] args) {
        
    }
}
