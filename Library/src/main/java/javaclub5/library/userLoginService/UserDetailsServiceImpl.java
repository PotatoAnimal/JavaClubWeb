package javaclub5.library.userLoginService;

import javaclub5.library.dao.UserDao;
import javaclub5.library.models.Role;
import javaclub5.library.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    //    @Override
//    @Transactional(readOnly = true)
//    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
//        User user = userDao.findByLogin(login);
//        if (user == null) throw new UsernameNotFoundException(login);
//
//        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
//
//        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), grantedAuthorities);
//    }
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) {
        User user = userDao.findByLogin(login);
        if (user != null) {
            String password = user.getPassword();

            Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();

            grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getName()));

            org.springframework.security.core.userdetails.User securedUser = new org.springframework.security.core.userdetails.User(
                    login, password, grantedAuthorities);
            return securedUser;
        } else {
            throw new UsernameNotFoundException(
                    "Unable to find user with username provided!!");
        }
    }
}
