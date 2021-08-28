package pojo;

public class UserAccount {
    private String email;
    private String password;
    private boolean validAccount;
    private String firstName;
    private String lastName;
    private String telephone;


    public UserAccount(String email, String password, boolean validAccount){
        this.setEmail(email);
        this.setPassword(password);
        this.setValidAccount(validAccount);
    }
    public UserAccount(String firstName, String lastName, String email, String telephone, String password){
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEmail(email);
        this.setTelephone(telephone);
        this.setPassword(password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isValidAccount() {
        return validAccount;
    }

    public void setValidAccount(boolean validAccount) {
        this.validAccount = validAccount;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}