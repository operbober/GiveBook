package by.givebook.entities;

import by.givebook.entities.superEntity.IdEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by operb_000 on 09.10.2015.
 */
@Entity
@Table(name = "user")
public class User extends IdEntity{
    private String login;
    private String password;

    public String getUsername() {
        return login;
    }

    public void setUsername(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
