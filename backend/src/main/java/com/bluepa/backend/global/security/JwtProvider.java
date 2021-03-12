package com.bluepa.backend.global.security;

import com.bluepa.backend.user.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Base64;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtProvider {

    private final UserDetailsService userDetailsService;

    @Value("app.jwt.secret")
    private String secretKey;

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(User user) {
        Claims claims = Jwts.claims().setSubject(user.getEmail());
        claims.put("id", user.getId());
        claims.put("role", user.getRole());
        Date now = new Date();

        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(now)
            .setExpiration(new Date(now.getTime() + JwtProperties.EXPIRATION_TIME))
            .signWith(SignatureAlgorithm.HS256, secretKey)
            .compact();
    }

    public Long getId(String token) {
        return Long.valueOf((Integer) getBody(token).get("id"));
    }

    public String getEmail(String token) {
        return getBody(token).getSubject();
    }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(getEmail(token));
        return new UsernamePasswordAuthenticationToken(userDetails,
            "", userDetails.getAuthorities());
    }

    public String resolveToken(HttpServletRequest request) {
        return request.getHeader(JwtProperties.HEADER);
    }

    public boolean isValidateToken(String token) {
        try {
            return !getBody(token).getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    private Claims getBody(String token) {
        if (!checkType(token)) {
            throw new IllegalArgumentException();
        }

        return Jwts.parser()
            .setSigningKey(secretKey)
            .parseClaimsJws(token.split(" ")[1])
            .getBody();
    }

    private boolean checkType(String token) {
        String[] s = token.split(" ");
        return s.length == 2 && s[0].equals(JwtProperties.TYPE);
    }
}
