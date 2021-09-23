package com.school.system.schoolsystem.security.jwt;

import com.school.system.schoolsystem.security.event.OnUserLogoutSuccessEvent;
import net.jodah.expiringmap.ExpiringMap;

public class LoggedOutJwtTokenCache {

    private ExpiringMap<String, OnUserLogoutSuccessEvent> tokenEventMap;
    private JwtProvider tokenProvider;
}
