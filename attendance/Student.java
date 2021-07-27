package attendance;

public class Student extends Person {
    private String regNo;
    
    public Student(){}

    public Student(String regNo, String name, String email, String phoneNo){
        this.regNo = regNo;
        this.setName(name);
        this.setEmail(email);
        this.setPhoneNo(phoneNo);
    }

    public void setRegNo(String regNo){
        this.regNo = regNo;
    }

    public String getRegNo(){
        return regNo;
    }
}
