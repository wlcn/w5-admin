package org.wlcn.w5.admin.adapter.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wlcn.w5.admin.application.user.UserService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    Mono<ResponseEntity<UserResponse>> findById(@PathVariable String id) {
        final var userInfo = userService.findById(id);
        log.info("user find by id {}", id);
        final var userResponse = UserConvertMapper.INSTANCE.userInfoToUserResponse(userInfo);
        return Mono.justOrEmpty(ResponseEntity.ok(userResponse));
    }
}
