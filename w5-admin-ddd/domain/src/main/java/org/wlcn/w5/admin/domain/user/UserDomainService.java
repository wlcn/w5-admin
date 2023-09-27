package org.wlcn.w5.admin.domain.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDomainService {

    private final UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(User user) {
        return userRepository.update(user);
    }

    public Integer delete(User user) {
        return userRepository.delete(user);
    }

    public User deleteById(Serializable id) {
        return userRepository.deleteById(id);
    }

    public User findById(Serializable id) {
        return userRepository.findById(id);
    }

    public List<User> find(User user) {
        return userRepository.find(user);
    }


}
