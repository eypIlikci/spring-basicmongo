package com.basicmongo.security.bruteforce;

import com.basicmongo.domain.User;
import com.basicmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class BruteForceProtectionServiceImpl implements BruteForceProtectionService{

    private int maxFailed=20;
    private int cacheMaxLimit=20;
    @Autowired
    private UserRepository userRepository;

    private final ConcurrentHashMap<String, FailedLogin> cache;
    public BruteForceProtectionServiceImpl() {
        this.cache = new ConcurrentHashMap<>(cacheMaxLimit);
    }
    @Override
    public void registerFailer(String username) {
        User user =userRepository.findByUsername(username).orElse(null);
        if(user!=null && !user.isLoginDisabled()){
            int failedCounter = user.getFailedLoginAttempts();
            if(maxFailedLogins < failedCounter+1){
                user.setLoginDisabled(true); //disabling the account
            }
            else{
                //let's update the counter
                user.setFailedLoginAttempts(failedCounter+1);
            }
            userRepository.save(user);
    }

    @Override
    public void resetBruteForceCounter(String username) {

    }

    @Override
    public boolean isBruteFroceAttack(String username) {
        return false;
    }
}
