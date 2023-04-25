package com.concungshop.controller;

import com.concungshop.dto.RoleDto;
import com.concungshop.dto.UserDto;
import com.concungshop.entity.Role;
import com.concungshop.entity.RoleName;
import com.concungshop.service.CategoryService;
import com.concungshop.service.ProductService;
import com.concungshop.service.RoleService;
import com.concungshop.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/user")
public class UserController<Object> {
    private final UserService userService;
    private final ProductService productService;
    private final CategoryService categoryService;
    private final RoleService roleService;

    public UserController(UserService userService, ProductService productService, CategoryService categoryService, RoleService roleService) {
        this.userService = userService;
        this.productService = productService;
        this.categoryService = categoryService;
        this.roleService = roleService;
    }
    private void setNavView(ModelAndView modelAndView) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)principal).getUsername();
        modelAndView.addObject("userPrincipal", userService.findByUsername(username).get());
        modelAndView.addObject("categoryList", categoryService.findAll());
        modelAndView.addObject("productList", productService.findAll());
        modelAndView.addObject("roleList", roleService.findAll());
    }
    @GetMapping("/list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView("/user/list");
        setNavView(modelAndView);
        modelAndView.addObject("userList", userService.findAll());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("/user/create");
        setNavView(modelAndView);
        modelAndView.addObject("user", new UserDto());
        return modelAndView;
    }
    @PostMapping ("/create")
    public ModelAndView createSuccess(UserDto userDto, @RequestParam("roleName") String roleName) {
        MultipartFile path = userDto.getPath();
        String fileName = path.getOriginalFilename();
        userDto.setAvatar(fileName);

        userDto.setActivated(true);

        userService.save(userDto);

        ModelAndView modelAndView = new ModelAndView("redirect:/user/list");
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView view(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/user/detail");
        setNavView(modelAndView);
        UserDto userDto = userService.findById(id).get();
        modelAndView.addObject("user", userDto);
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id){
        UserDto userDto = userService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("/user/edit");
        setNavView(modelAndView);
        modelAndView.addObject("newUserDto", userDto);
        return modelAndView;
    }


    @PostMapping("/edit")
    public ModelAndView editSuccess(@ModelAttribute("newUserDto") UserDto userDto)  {
        if(userDto.getPath() != null) {
            MultipartFile multipartFile = userDto.getPath();
            String fileName = multipartFile.getOriginalFilename();
            userDto.setAvatar(fileName);
        }
        userService.save(userDto);
        ModelAndView modelAndView = new ModelAndView("redirect:/user/edit/{id}");
        return modelAndView;
    }



    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable Long id){
        userService.remove(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/user/list");
        return modelAndView;
    }

    @GetMapping("/layoff/{id}")
    public ModelAndView layoff(@PathVariable Long id){
        userService.remove(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/user/list");
        return modelAndView;
    }


    @GetMapping("/update/{id}")
    public ModelAndView update(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/user/update-role");
        setNavView(modelAndView);
        modelAndView.addObject("user", userService.findById(id).get());
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView updateSuccess(@ModelAttribute("user") UserDto userDto)  {
        userService.updateRole(userDto);
        ModelAndView modelAndView = new ModelAndView("redirect:/user/edit/{id}");
        return modelAndView;
    }


    @GetMapping("/search")
    public ModelAndView searchName(@RequestParam String name){
        Iterable<UserDto> userDtos = userService.findByFullNameContainingAndActivated(name, true);
        ModelAndView modelAndView = new ModelAndView("/user/search");
        modelAndView.addObject("userList", userDtos);
        setNavView(modelAndView);
        return modelAndView;
    }

    @GetMapping("/search/{name}")
    public ModelAndView search(@PathVariable RoleName name){
        RoleDto roleDto = roleService.findByName(name).get();
        Iterable<UserDto> userDtos = userService.findByActivatedAndRole(true, roleDto);
        ModelAndView modelAndView = new ModelAndView("/user/search");
        modelAndView.addObject("userList", userDtos);
        setNavView(modelAndView);
        return modelAndView;
    }


    @PostMapping("/reset-password")
    public ModelAndView resetPassword(UserDto userDto)  {
        userService.updatePassword(userDto);
        ModelAndView modelAndView = new ModelAndView("redirect:/logout");
        return modelAndView;
    }
}
