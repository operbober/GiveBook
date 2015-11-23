package by.givebook.services;

import by.givebook.entities.Role;
import by.givebook.entities.User;
import by.givebook.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by operb_000 on 23.11.2015.
 */
@Service
@Qualifier("customUserDetailService")
public class CustomUserDetailService implements UserDetailsService{

    @Autowired
    UsersRepository usersRepository;

    @Transactional(readOnly=true)
    @Override
    public UserDetails loadUserByUsername(final String username)
            throws UsernameNotFoundException {

        User user = usersRepository.findByUsername(username);
        List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());

        return buildUserForAuthentication(user, authorities);

    }

    private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user,
                                            List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(List<Role> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // Build user's authorities
        for (Role userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
        }

        return new ArrayList<GrantedAuthority>(setAuths);
    }

}
