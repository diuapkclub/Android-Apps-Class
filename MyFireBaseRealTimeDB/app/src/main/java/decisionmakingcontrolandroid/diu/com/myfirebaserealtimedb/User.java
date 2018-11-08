package decisionmakingcontrolandroid.diu.com.myfirebaserealtimedb;

public class User {

    private String userName;
    private String userEmail;
    private String userContact;

    public User(String userName, String userEmail, String userContact) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userContact = userContact;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserContact() {
        return userContact;
    }

    public void setUserContact(String userContact) {
        this.userContact = userContact;
    }
}
