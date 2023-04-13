package eDev.br.md.infostoreapi.services;

import eDev.br.md.infostoreapi.dtos.UserDto;
import eDev.br.md.infostoreapi.models.UserModel;
import eDev.br.md.infostoreapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(UserDto userDto) {

        UserModel userModel = new UserModel();

        userModel.setLogin(userDto.getLogin());
        userModel.setPassword(userDto.getPassword());
        userModel.setDateTime(LocalDateTime.now());

        userRepository.save(userModel);
    }
}
