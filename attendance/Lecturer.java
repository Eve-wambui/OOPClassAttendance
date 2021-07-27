package attendance;

public class Lecturer extends Person {
    private String staffId;
    
    public Lecturer(){}

    public Lecturer(String staffId, String name, String email, String phoneNo){
        this.staffId = staffId;
        this.setName(name);
        this.setEmail(email);
        this.setPhoneNo(phoneNo);
    }

    public void setStaffId(String staffId){
        this.staffId = staffId;
    }

    public String getRegNo(){
        return staffId;
    }
}
