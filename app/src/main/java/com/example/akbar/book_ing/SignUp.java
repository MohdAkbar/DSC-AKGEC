package com.example.akbar.book_ing;

/**
 * Created by Akbar on 4/13/2018.
 */
public class SignUp {

    String username;
    String email;
    String password;
    String stream;
    String phoneNumber;
    public SignUp()
    {

    }
    public SignUp(String username, String email, String password, String stream, String phoneNumber) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.stream = stream;
        this.phoneNumber = phoneNumber;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getStream() {
        return stream;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
