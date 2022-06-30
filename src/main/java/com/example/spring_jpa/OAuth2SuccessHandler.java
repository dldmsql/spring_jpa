package com.example.spring_jpa;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@RequiredArgsConstructor
@Component
public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
  private final TokenService tokenService;
  private final UserRequestMapper userRequestMapper;
  private final ObjectMapper objectMapper;

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
      throws IOException, ServletException {
    OAuth2User oAuth2User = (OAuth2User)authentication.getPrincipal();
    UserDto userDto = userRequestMapper.toDto(oAuth2User);

    String targetUrl;
    Token token = tokenService.generateToken(userDto.getEmail(), "USER");

    targetUrl = UriComponentsBuilder.fromUriString("/api/main/signUp")
        .queryParam("token", "token")
        .build().toUriString();
    getRedirectStrategy().sendRedirect(request, response, targetUrl);
  }
}
