package ua.com.alevel.web.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.com.alevel.persistence.entity.User;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class UserData {

    private Integer id;
    private String firstName;
    private String lastName;
    private String fullName;
    private String email;
    private Date created;
    private Date updated;

    public UserData(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.fullName = user.getFullName();
        this.email = user.getEmail();
        this.created = user.getCreated();
        this.updated = user.getUpdated();
    }
}
