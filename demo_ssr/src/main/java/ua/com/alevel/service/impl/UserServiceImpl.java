package ua.com.alevel.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ua.com.alevel.persistence.entity.User;
import ua.com.alevel.persistence.repository.UserRepository;
import ua.com.alevel.service.UserService;

import java.util.Map;

import static ua.com.alevel.util.WebRequestUtil.*;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(User user) {
        if (!userRepository.existsByEmail(user.getEmail())) {
            userRepository.save(user);
        }
    }

    @Override
    public void update(User user) {
        if (userRepository.existsById(user.getId())) {
            if (!userRepository.existsByEmail(user.getEmail())) {
                userRepository.save(user);
            }
        }
    }

    @Override
    public void delete(Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }

    @Override
    public User find(Integer id) {
        if (userRepository.existsById(id)) {
            return userRepository.getById(id);
        }
        throw  new RuntimeException("user not found");
    }

    @Override
    public Page<User> find(Map<String, String> params) {
        int page = Integer.parseInt(params.get(PAGE_PARAM));
        int size = Integer.parseInt(params.get(SIZE_PARAM));
        String order = params.get(ORDER_PARAM);
        String sort = params.get(SORT_PARAM);
        if (order.equals(DEFAULT_ORDER_PARAM_VALUE)) {
            return userRepository.findAll(PageRequest.of(page - 1, size, Sort.by(Sort.Order.desc(sort))));
        }
        return userRepository.findAll(PageRequest.of(page - 1, size, Sort.by(Sort.Order.asc(sort))));
    }
}
