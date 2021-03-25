package com.bluepa.backend.global.security.dto;

import com.bluepa.backend.user.domain.User;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class OAuthAttributes {

    private final Map<String, Object> attributes;
    private final String nameAttributeKey;
    private final String nickname;
    private final String email;
    private final String picture;

    public static OAuthAttributes of(String registrationId, String userNameAttributeName,
        Map<String, Object> attributes) {
        if ("naver".equals(registrationId)) {
            return ofNaver(userNameAttributeName, attributes);
        } else if ("kakao".equals(registrationId)) {
            return ofKakao(userNameAttributeName, attributes);
        }
        return ofGoogle(userNameAttributeName, attributes);
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName,
        Map<String, Object> attributes) {
        return OAuthAttributes.builder()
            .nickname((String) attributes.get("name"))
            .email((String) attributes.get("email"))
            .picture((String) attributes.get("picture"))
            .attributes(attributes)
            .nameAttributeKey(userNameAttributeName)
            .build();
    }

    private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");

        return OAuthAttributes.builder()
            .nickname((String) response.get("name"))
            .email((String) response.get("email"))
            .picture((String) response.get("profile_image"))
            .attributes(attributes)
            .nameAttributeKey(userNameAttributeName)
            .build();
    }

    private static OAuthAttributes ofKakao(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> response = (Map<String, Object>) attributes.get("kakao_account");
        Map<String, Object> profile = (Map<String, Object>) response.get("profile");

        return OAuthAttributes.builder()
            .nickname((String) profile.get("nickname"))
            .email((String) response.get("email"))
            .picture((String) profile.get("profile_image_url"))
            .attributes(attributes)
            .nameAttributeKey(userNameAttributeName)
            .build();
    }

    public User toEntity() {
        return User.builder()
            .email(email)
            .nickname(nickname)
            .picture(picture)
            .role("ROLE_USER")
            .build();
    }
}
