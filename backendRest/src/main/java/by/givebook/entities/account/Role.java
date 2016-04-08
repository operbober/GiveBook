package by.givebook.entities.account;

import by.givebook.entities.NamedEntity;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by operb_000 on 28.02.2016.
 */
@Entity
@Table(name = "role")
public class Role extends NamedEntity implements GrantedAuthority {
    @Override
    public String getAuthority() {
        return getName();
    }
}
