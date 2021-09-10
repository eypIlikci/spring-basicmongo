package com.basicmongo.security;

import com.basicmongo.domain.model.convert.Convertor;
import com.basicmongo.domain.model.request.UserCreateRequest;
import com.basicmongo.domain.model.response.UserResponse;
import com.basicmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.security.Key;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LoginAttemptService loginAttemptService;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private Convertor  convertor;
    public UserResponse register(UserCreateRequest request){
      return  convertor.convert(userRepository.save(convertor.convert(request)));
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String key=getClientIP();
        if (loginAttemptService.isBlocked(key)) {
            throw new IllegalArgumentException();//Blocked
        }
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found!"));
    }
    private String getClientIP() {
        String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null){
            return request.getRemoteAddr();
        }
        return xfHeader.split(",")[0];
    }
}
