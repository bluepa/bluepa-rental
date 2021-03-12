package com.bluepa.backend.global.security;

import java.io.IOException;
import java.util.Optional;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends GenericFilterBean {

    private final JwtProvider provider;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        Optional<String> token = Optional.of(provider.resolveToken((HttpServletRequest) request));

        if (token.map(provider::isValidateToken).orElse(false)) {
            SecurityContextHolder.getContext()
                .setAuthentication(provider.getAuthentication(token.get()));
        }

        chain.doFilter(request, response);
    }
}
