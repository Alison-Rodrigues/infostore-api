package eDev.br.md.infostoreapi.controllers;


import eDev.br.md.infostoreapi.dtos.UserDto;
import eDev.br.md.infostoreapi.models.UserModel;
import eDev.br.md.infostoreapi.repository.UserRepository;
import eDev.br.md.infostoreapi.services.TokenService;
import eDev.br.md.infostoreapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;

    private final PasswordEncoder encoder;

    public UserController(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @PostMapping("/createUser")
    private void save(@RequestBody UserDto userDto) {
        userDto.setPassword(encoder.encode(userDto.getPassword()));
        userService.save(userDto);
    }

    @PostMapping("/login")
    private String login(@RequestBody UserDto userDto) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(userDto.getLogin(),
                        userDto.getPassword());

        Authentication authenticate = this.authenticationManager
                .authenticate(usernamePasswordAuthenticationToken);

        var user = (UserModel) authenticate.getPrincipal();

        return tokenService.generateToken(user);
    }
}
