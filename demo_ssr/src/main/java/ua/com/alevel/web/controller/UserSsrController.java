package ua.com.alevel.web.controller;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import ua.com.alevel.facade.UserFacade;
import ua.com.alevel.web.data.PageData;
import ua.com.alevel.web.data.UserData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static ua.com.alevel.util.WebRequestUtil.DEFAULT_ORDER_PARAM_VALUE;

@Controller
@RequestMapping(path = "/users")
public class UserSsrController {

    public final UserFacade userFacade;

    public UserSsrController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @GetMapping
    public String findAll(WebRequest request, Model model) {
        PageData<UserData> personalPageData = userFacade.find(request);
        String[] columnNames = new String[] { "#", "id", "created", "email", "name", "details", "delete"};
        List<HeaderData> headerDataList = new ArrayList<>();
        for (String column : columnNames) {
            HeaderData data = new HeaderData();
            data.setHeaderName(column);
            if (column.equals("#") || column.equals("details")) {
                data.setSortable(false);
            } else {
                data.setSortable(true);
                data.setSort(column);
                if (personalPageData.getSort().equals(column)) {
                    data.setActive(true);
                    data.setOrder(personalPageData.getOrder());
                } else {
                    data.setActive(false);
                    data.setOrder(DEFAULT_ORDER_PARAM_VALUE);
                }
            }
            headerDataList.add(data);
        }
        model.addAttribute("pageData", personalPageData);
        model.addAttribute("headerDataList", headerDataList);
        return "users";
    }

    @PostMapping
    public ModelAndView findAllRedirect(WebRequest request, ModelMap model) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        if (MapUtils.isNotEmpty(parameterMap)) {
            parameterMap.forEach(model::addAttribute);
        }
        return new ModelAndView("redirect:/users", model);
    }

    @GetMapping("/{id}")
    public String findById(Model model, @PathVariable Integer id) {
        model.addAttribute("user", userFacade.find(id));
        return "user_details";
    }

    @GetMapping("/new")
    public String redirectToNewPage(Model model) {
        model.addAttribute("userForm", new UserData());
        return "user_new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("userForm") UserData data) {
        userFacade.create(data);
        return "redirect:/users";
    }

    @GetMapping("/{id}/update")
    public String redirectToUpdatePage(@PathVariable Integer id, Model model) {
        model.addAttribute("userForm", userFacade.find(id));
        return "user_update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("userForm") UserData data, @RequestParam Integer id) {
        data.setId(id);
        userFacade.update(data);
        return "redirect:/users";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Integer id) {
        userFacade.delete(id);
        return "redirect:/users";
    }

    @Getter
    @Setter
    public static class HeaderData {

        private String headerName;
        private boolean active;
        private boolean sortable;
        private String sort;
        private String order;
    }
}
