package attendance;

public class Person {
    protected String name;
    protected String phoneNo;
    protected String email;

    protected Person(String name, String phoneNo, String email){
        this.name = name;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    protected Person(){}

    protected void setName(String name){
        this.name = name;
    }

    protected void setPhoneNo(String phoneNo){
        this.phoneNo = phoneNo;
    }

    protected void setEmail(String email){
        this.email = email;
    }

    protected String getName(){
        return name;
    }

    protected String getEmail(){
        return email;
    }

    protected String getPhoneNo(){
        return phoneNo;
    }
}
