package com.todolistapi.security;

import org.springframework.scheduling.annotation.Scheduled;

import com.todolistapi.business.service.TokenBlacklistService;

import java.util.Date;

public class DeleteAllExpiredTokens {

    private final TokenBlacklistService blacklistService;


    public DeleteAllExpiredTokens(TokenBlacklistService blacklistService) {
        this.blacklistService = blacklistService;
    }


    /**
     * Routinely Deletes expired tokens from the Blacklist
     */

    @Scheduled(cron = "0 0 12 * * ?")
    public void deleteExpiredTokens() {
        long now = (new Date().getTime());

        blacklistService.getBlacklistRepository().deleteAllByExpiryAtLessThan(now);
    }

}
