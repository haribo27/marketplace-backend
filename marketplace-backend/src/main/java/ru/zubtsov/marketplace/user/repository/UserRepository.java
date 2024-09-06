package ru.zubtsov.marketplace.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zubtsov.marketplace.user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
