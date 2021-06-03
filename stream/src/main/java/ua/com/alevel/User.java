package ua.com.alevel;

import java.util.Optional;

public class User {

    private Optional<String> firstName;
    private Optional<String> lastName;
    private Optional<Profile> profile;
    private Optional<Balance> balance;

    public Optional<String> getFirstName() {
        return firstName;
    }

    public void setFirstName(Optional<String> firstName) {
        this.firstName = firstName;
    }

    public Optional<String> getLastName() {
        return lastName;
    }

    public void setLastName(Optional<String> lastName) {
        this.lastName = lastName;
    }

    public Optional<Profile> getProfile() {
        return profile;
    }

    public void setProfile(Optional<Profile> profile) {
        this.profile = profile;
    }

    public Optional<Balance> getBalance() {
        return balance;
    }

    public void setBalance(Optional<Balance> balance) {
        this.balance = balance;
    }
}
