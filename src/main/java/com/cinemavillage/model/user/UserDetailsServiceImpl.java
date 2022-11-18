package com.cinemavillage.model.user;

import com.cinemavillage.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByUserEmailIgnoreCase(email)
                .orElseThrow(() -> new UsernameNotFoundException("User with email: " + email + " not found!"));
        return new UserDetailsImpl(user);
    }
}
