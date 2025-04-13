package coursehive.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "users") // optional: to explicitly name your table
public class User {

    @Id
    @GeneratedValue()
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Email(message = "Invalid email format")
    @NotNull(message = "Email is required")
    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String fullName;

    private String profilePicUrl;

    private LocalDateTime createdAt = LocalDateTime.now();

    // Constructors
    public User() {
    }

    public User(String username, String password, String email, String fullName, String profilePicUrl) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.profilePicUrl = profilePicUrl;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getFullName() {
        return fullName;
    }

    public String getProfilePicUrl() {
        return profilePicUrl;
    }

    // Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setProfilePicUrl(String profilePicUrl) {
        this.profilePicUrl = profilePicUrl;
    }

}
