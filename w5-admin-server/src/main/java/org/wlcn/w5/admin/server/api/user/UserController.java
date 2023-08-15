package org.wlcn.w5.admin.server.api.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wlcn.w5.admin.server.facade.user.UserFacade;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserFacade userFacade;

    @GetMapping("/{id}")
    Mono<ResponseEntity<UserResponse>> findById(@PathVariable String id) {
        final var userResponse = userFacade.findById(id);
        return Mono.justOrEmpty(ResponseEntity.ok(userResponse));
    }
}
