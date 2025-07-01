package com.ecom.cartify.service.impl;

import com.ecom.cartify.JWT.JwtService;
import com.ecom.cartify.config.CustomUserDetailsService;
import com.ecom.cartify.repositry.RoleRepository;
import com.ecom.cartify.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.model.AuthResponseDTO;
import org.openapitools.model.LoginForm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final AuthenticationManager authenticationManager;
    private final RoleRepository roleRepository;
    private final JwtService jwtService;
    private final CustomUserDetailsService myUserDetailService;


    @Override
    public AuthResponseDTO doAuthenticate(LoginForm loginForm) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginForm.getEmail(), loginForm.getPassword()));

            var user = roleRepository.findByEmail(loginForm.getEmail())
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));

            String token = jwtService.generateToken(myUserDetailService.loadUserByUsername(user.getEmail()),
                    user.getRoleId(),
                    user.getRole().name());

            return new AuthResponseDTO( "Login successful" , token);

        } catch (BadCredentialsException e) {
            log.warn("Invalid login credentials for email: {}", loginForm.getEmail());
            throw new RuntimeException("Invalid email or password");
        } catch (UsernameNotFoundException e) {
            log.warn("User not found for email: {}", loginForm.getEmail());
            throw new RuntimeException("User not found");
        } catch (AuthenticationException e) {
            log.error("Authentication error: {}", e.getMessage());
            throw new RuntimeException("Authentication failed");
        }
    }


}