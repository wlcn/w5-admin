package org.wlcn.w5.admin.domain.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDomainService {

    private final UserRepository userRepository;

    User save(User user) {
        return userRepository.save(user);
    }

    User update(User user) {
        return userRepository.update(user);
    }

    Integer delete(User user) {
        return userRepository.delete(user);
    }

    User findById(Serializable id) {
        return userRepository.findById(id);
    }

    User deleteById(Serializable id) {
        return userRepository.deleteById(id);
    }
}
