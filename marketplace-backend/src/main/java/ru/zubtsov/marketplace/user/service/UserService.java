package ru.zubtsov.marketplace.user.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.zubtsov.marketplace.exception.EntityNotFound;
import ru.zubtsov.marketplace.user.User;
import ru.zubtsov.marketplace.user.repository.RoleRepository;
import ru.zubtsov.marketplace.user.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
                String.format("Пользователь '%s' не найден", username)
        ));
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getRoles().stream()
                        .map(role -> new SimpleGrantedAuthority(role.getName())).toList()
        );
    }

    public void createUser(User user) {
        user.setRoles(List.of(
                roleRepository.findByName("ROLE_USER")
                        .orElseThrow(()-> new EntityNotFound("Роль с таким именем не найдена"))));
        userRepository.save(user);
    }
}
