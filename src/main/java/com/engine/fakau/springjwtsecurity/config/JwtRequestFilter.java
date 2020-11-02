package com.engine.fakau.springjwtsecurity.config;

import com.engine.fakau.springjwtsecurity.domaine.User;
import com.engine.fakau.springjwtsecurity.domaine.enumeation.NomRole;
import com.engine.fakau.springjwtsecurity.exception.UserNotFoundException;
import com.engine.fakau.springjwtsecurity.repository.UserRepository;
import com.engine.fakau.springjwtsecurity.sercice.serviceImpl.UserServiceImpl;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
          try {
              final String requestTokenHeader = request.getHeader("Authorization");
              String login = null;
              String jwtToken = null;
              if (!Strings.isNullOrEmpty(requestTokenHeader) || requestTokenHeader.startsWith("Bearer ")) {
                  jwtToken = requestTokenHeader.replace("Bearer ", "");
                  login = jwtTokenUtil.getLogin(jwtToken);
              }
              if (login != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                  UserDetails userDetails = this.userService.loadUserByUsername(login);
                  if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
                      UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                              new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                      usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                      SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                  }
              }
          }catch (Exception ex){
              System.out.println("One error where found :"+ex.getMessage());
          }
        chain.doFilter(request, response);
    }

}