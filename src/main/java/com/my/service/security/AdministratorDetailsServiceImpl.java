package com.my.service.security;

import com.my.model.Administrator;
import com.my.repository.basic.AdministratorRepository;
import com.my.repository.jpa.JpaAdministratorRepository;
import com.my.service.administrator.AdministratorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AdministratorDetailsServiceImpl implements UserDetailsService {
    private final AdministratorRepository administratorRepository;

    @Autowired
    public AdministratorDetailsServiceImpl(JpaAdministratorRepository jpaAdministratorRepository) {
        administratorRepository = jpaAdministratorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Administrator administrator = administratorRepository.findByEmail(s);
        if (administrator == null) throw new UsernameNotFoundException(s);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        return new org.springframework.security.core.userdetails.User(
                administrator.getEmail(),
                administrator.getPassword(),
                grantedAuthorities);
    }
}
