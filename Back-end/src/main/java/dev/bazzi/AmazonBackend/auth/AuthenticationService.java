package dev.bazzi.AmazonBackend.auth;

import dev.bazzi.AmazonBackend.config.JwtService;
import dev.bazzi.AmazonBackend.user.User;
import dev.bazzi.AmazonBackend.user.UserRepository;
import dev.bazzi.AmazonBackend.user.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    @Autowired
    private final UserRepository repository;
    private final JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(UserRole.USER)
                .build();
        repository.save(user);
        var jwtToken=jwtService.generateToken(user);

        return AuthenticationResponse.builder().Token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(
        request.getEmail(),
        request.getPassword()
));
var user= repository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken=jwtService.generateToken(user);
        return AuthenticationResponse.builder().Token(jwtToken).build();
    }

    public void deleteUserById( Long id) {
        repository.deleteById(id);


    }
}
