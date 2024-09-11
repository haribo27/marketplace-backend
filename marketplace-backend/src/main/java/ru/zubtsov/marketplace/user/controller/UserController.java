package ru.zubtsov.marketplace.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
@Validated
public class UserController {

   /* private final UserServiceImpl userServiceImpl;

*//*    @GetMapping
    public List<UserDto> findAll() {
        return userServiceImpl.findAll();
    }*//*

    @GetMapping("{userId}")
    public UserDto findById(@PathVariable long userId) {
        return userServiceImpl.findById(userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto saveUser(@RequestBody @Valid SignUpRequest request) {
        return userServiceImpl.saveUser(request);
    }*/
}
