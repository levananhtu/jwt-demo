package lvat.jwtdemo.model;

public class AccountCredential {
    private String username;
    private String password;

    public AccountCredential(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public AccountCredential() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
