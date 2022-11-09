package Model;

public class Account {
    private String userName;
    private String password;
    private String role;
    public String fullName;
    public static String test="test nef";
    public static String getTest(){
        return test;
    }

    public String getFullName() {
        return fullName;
    }

    public String setFullName(String fullName) {
        this.fullName = fullName;
        return fullName;
    }

    public Account(String userName, String password, String role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }
    public Account(String userName, String password,String role,String fullName) {
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.fullName = fullName;
    }
    public Account(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {

        if(role == "admin"){
            return 1;
        }
        else{return 0;}
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Account{" + "userName=" + userName + ", password=" + password + ", role=" + role + ",Fullname="+fullName+'}';
    }


}
