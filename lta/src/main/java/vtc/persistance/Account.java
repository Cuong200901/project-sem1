package vtc.persistance;

public class Account {
    private int accountId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String birthday;
    private int phoneNumber;
    private String email;
    private String position;
    private String startTime;

  

    public int getaccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public String getuserpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public String getfirstname() {
        return firstName;
    }

    public void setfirstname(String firstname) {
        this.firstName = firstname;
    }

    public String getlastname() {
        return lastName;
    }

    public void setlastname(String lastname) {
        this.lastName = lastname;
    }

    public String getbirthday() {
        return birthday;
    }

    public void setbirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getphonenumber() {
        return phoneNumber;
    }

    public void setphonenumber(int phonenumber) {
        this.phoneNumber = phonenumber;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getposition() {
        return position;
    }

    public void setposition(String position) {
        this.position = position;
    }

    public String getstarttime() {
        return startTime;
    }

    public void setstarttime(String starttime) {
        this.startTime = starttime;
    }

}
