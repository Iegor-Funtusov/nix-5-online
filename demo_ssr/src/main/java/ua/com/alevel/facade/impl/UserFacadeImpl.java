package ua.com.alevel.facade.impl;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;

import ua.com.alevel.facade.UserFacade;
import ua.com.alevel.persistence.entity.User;
import ua.com.alevel.service.UserService;
import ua.com.alevel.util.WebRequestUtil;
import ua.com.alevel.web.data.PageData;
import ua.com.alevel.web.data.UserData;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static ua.com.alevel.util.WebRequestUtil.*;

@Service
public class UserFacadeImpl implements UserFacade {

    private final UserService userService;

    public UserFacadeImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void create(UserData userData) {
        User user = new User();
        copyUserProperties(userData, user);
        userService.create(user);
    }

    @Override
    public void update(UserData userData) {
        if (userData.getId() != null) {
            User user = userService.find(userData.getId());
            copyUserProperties(userData, user);
            userService.update(user);
        }
    }

    @Override
    public void delete(Integer id) {
        userService.delete(id);
    }

    @Override
    public UserData find(Integer id) {
        return new UserData(userService.find(id));
    }

    @Override
    public PageData<UserData> find(WebRequest request) {
        Map<String, String> params = WebRequestUtil.getParametersMap(request);
        PageData<UserData> pageData = new PageData<>();
        pageData.setSort(params.get(SORT_PARAM));
        pageData.setOrder(params.get(ORDER_PARAM));
        pageData.setCurrentPage(Integer.parseInt(params.get(PAGE_PARAM)));
        pageData.setPageSize(Integer.parseInt(params.get(SIZE_PARAM)));
        Page<User> users = userService.find(params);
        pageData.setTotalElements(users.getTotalElements());
        pageData.setTotalPages(users.getTotalPages());
        if (CollectionUtils.isNotEmpty(users.getContent())) {
            List<UserData> list = users.getContent().stream().map(UserData::new).collect(Collectors.toList());
            pageData.setItems(list);
        }
        pageData.initPaginationState(pageData.getCurrentPage());
        return pageData;
    }

    private void copyUserProperties(UserData userData, User user) {
        user.setEmail(userData.getEmail());
        user.setFirstName(userData.getFirstName());
        user.setLastName(userData.getLastName());
    }
}
