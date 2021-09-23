package com.school.system.schoolsystem.security.jwt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JwtProvider {

    @Autowired
    private LoggedOutJwtTokenCache loggedOutJwtTokenCache;
}
