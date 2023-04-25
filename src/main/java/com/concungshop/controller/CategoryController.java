package com.concungshop.controller;

import com.concungshop.dto.CategoryDto;
import com.concungshop.service.CategoryService;
import com.concungshop.service.ProductService;
import com.concungshop.service.RoleService;
import com.concungshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/category")
public class CategoryController {

    private final UserService userService;

    private final ProductService productService;

    private final CategoryService categoryService;

    private final RoleService roleService;


    public CategoryController(UserService userService, ProductService productService, CategoryService categoryService, RoleService roleService) {
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
        ModelAndView modelAndView = new ModelAndView("/category/list");
        setNavView(modelAndView);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView modelAndView = new ModelAndView("/category/create");
        setNavView(modelAndView);
        modelAndView.addObject("category", new CategoryDto());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView createSuccess(@ModelAttribute("category") CategoryDto categoryDto) {
        categoryDto.setActivated(true);
        categoryService.save(categoryDto);
        ModelAndView modelAndView = new ModelAndView("redirect:/category/list");
        setNavView(modelAndView);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id){
        CategoryDto categoryDto = categoryService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("/category/edit");
        setNavView(modelAndView);
        modelAndView.addObject("category", categoryDto);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editSuccess(CategoryDto categoryDto){
        categoryService.save(categoryDto);
        ModelAndView modelAndView = new ModelAndView("redirect:/category/list");
        setNavView(modelAndView);
        return modelAndView;
    }

    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable Long id){
        CategoryDto categoryDto = categoryService.findById(id).get();
        categoryService.remove(id);
        productService.deleteByCategory(categoryDto);
        ModelAndView modelAndView = new ModelAndView("redirect:/category/list");
        setNavView(modelAndView);
        return modelAndView;
    }

}
