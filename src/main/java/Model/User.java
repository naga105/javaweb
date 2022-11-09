package Model;

public class User {
    private String user_id;
    private String username;
    private String userPassword;
    private String email;
    private String phone;
    private String name;
    private String avatar;
    private String role;
    private String ggid;
    private String whislistId;
    private String selfDescription;
    private String bookmarkId;

    private String bookmarkDate;

    public User(String user_id, String username, String userPassword, String email, String phone, String name, String avatar, int role, String ggid, String whislistId, String selfDescription, String bookmarkId, String bookmarkDate) {
        this.user_id = user_id;
        this.username = username;
        this.userPassword = userPassword;
        this.email = email;
        this.phone = phone;
        this.name = name;
        this.avatar = avatar;
        setRole(role);
        this.ggid = ggid;
        this.whislistId = whislistId;
        this.selfDescription = selfDescription;
        this.bookmarkId = bookmarkId;
        this.bookmarkDate = bookmarkDate;
    }

    public User() {
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGgid() {
        return ggid;
    }

    public void setGgid(String ggid) {
        this.ggid = ggid;
    }

    public String getWhislistId() {
        return whislistId;
    }

    public void setWhislistId(String whislistId) {
        this.whislistId = whislistId;
    }

    public String getSelfDescription() {
        return selfDescription;
    }

    public void setSelfDescription(String selfDescription) {
        this.selfDescription = selfDescription;
    }

    public String getBookmarkId() {
        return bookmarkId;
    }

    public void setBookmarkId(String bookmarkId) {
        this.bookmarkId = bookmarkId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setRole(int role){
        if(role==0){
            this.role="hotel hoster";
            return;
        }
        if(role==1){
            this.role="admin";
            return;
        }else{
            this.role="guest";
            return;
        }
    }
    public String getRole(){
        return role;
    }

    public String getBookmarkDate() {
        return bookmarkDate;
    }

    public void setBookmarkDate(String bookmarkDate) {
        this.bookmarkDate = bookmarkDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id='" + user_id + '\'' +
                ", username='" + username + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", ggid='" + ggid + '\'' +
                ", whislistId='" + whislistId + '\'' +
                ", selfDescription='" + selfDescription + '\'' +
                ", bookmarkId='" + bookmarkId + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
