package eDev.br.md.infostoreapi.repository;

import eDev.br.md.infostoreapi.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {

    UserModel findByLogin(String login);
}
