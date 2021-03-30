package com.bluepa.backend.global.security;

public class JwtProperties {

    public static final Long EXPIRATION_TIME = 1000 * 60 * 60 * 24 * 30L;
    public static final String TYPE = "Bearer";
    public static final String HEADER = "Authorization";
}
