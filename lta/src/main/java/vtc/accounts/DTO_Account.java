package vtc.accounts;

public class DTO_Account {
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String birthday;
    private int phonenumber;
    private String email;
    private String position;
    private String starttime;
    private String shitf;

    public DTO_Account() {
    }

    public DTO_Account(String username, String password, String firstname, String lastname, String birthday,
            int phonenumber, String email, String position, String starttime, String shitf) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.phonenumber = phonenumber;
        this.email = email;
        this.position = position;
        this.starttime = starttime;
        this.shitf = shitf;
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
        return firstname;
    }

    public void setfirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getlastname() {
        return lastname;
    }

    public void setlastname(String lastname) {
        this.lastname = lastname;
    }

    public String getbirthday() {
        return birthday;
    }

    public void setbirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getphonenumber() {
        return phonenumber;
    }

    public void setphonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
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
        return starttime;
    }

    public void setstarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getshitf() {
        return shitf;
    }

    public void setshitf(String shitf) {
        this.shitf = shitf;
    }
}
