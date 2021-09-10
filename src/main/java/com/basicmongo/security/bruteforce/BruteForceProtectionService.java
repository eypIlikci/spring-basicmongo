package com.basicmongo.security.bruteforce;

public interface BruteForceProtectionService {
    void registerFailer(String username);
    void resetBruteForceCounter(String username);
    boolean isBruteFroceAttack(String username);
}
