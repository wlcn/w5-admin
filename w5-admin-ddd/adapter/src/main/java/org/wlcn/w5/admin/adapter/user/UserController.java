package org.wlcn.w5.admin.adapter.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.wlcn.w5.admin.application.user.UserService;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Mono<ResponseEntity<UserResponse>> save(@RequestBody @Validated(UserCommandRequest.SaveGroup.class) UserCommandRequest userCommandRequest) {
        final var userInfo = UserConvertMapper.INSTANCE.userCommandRequestToUserInfo(userCommandRequest);
        final var saved = userService.save(userInfo);
        final var userResponse = UserConvertMapper.INSTANCE.userInfoToUserResponse(saved);
        return Mono.justOrEmpty(ResponseEntity.ok(userResponse));
    }

    @PutMapping
    Mono<ResponseEntity<UserResponse>> update(@RequestBody @Validated(UserCommandRequest.UpdateGroup.class) UserCommandRequest userCommandRequest) {
        final var userInfo = UserConvertMapper.INSTANCE.userCommandRequestToUserInfo(userCommandRequest);
        final var updated = userService.update(userInfo);
        final var userResponse = UserConvertMapper.INSTANCE.userInfoToUserResponse(updated);
        return Mono.justOrEmpty(ResponseEntity.ok(userResponse));
    }

    @DeleteMapping("/{id}")
    Mono<ResponseEntity<UserResponse>> deleteById(@PathVariable Integer id) {
        final var deleted = userService.deleteById(id);
        log.info("delete by id {}", id);
        final var userResponse = UserConvertMapper.INSTANCE.userInfoToUserResponse(deleted);
        return Mono.justOrEmpty(ResponseEntity.ok(userResponse));
    }

    @GetMapping("/{id}")
    Mono<ResponseEntity<UserResponse>> findById(@PathVariable Integer id) {
        final var existed = userService.findById(id);
        log.info("find by id {}", id);
        final var userResponse = UserConvertMapper.INSTANCE.userInfoToUserResponse(existed);
        return Mono.justOrEmpty(ResponseEntity.ok(userResponse));
    }

    @PostMapping("/find")
    Mono<ResponseEntity<List<UserResponse>>> find(@RequestBody @Valid UserQueryRequest userQueryRequest) {
        final var userInfo = UserConvertMapper.INSTANCE.userQueryRequestToUserInfo(userQueryRequest);
        final var foundList = userService.find(userInfo);
        final var userResponseList = UserConvertMapper.INSTANCE.userInfoListToUserResponseList(foundList);
        return Mono.justOrEmpty(ResponseEntity.ok(userResponseList));
    }
}
