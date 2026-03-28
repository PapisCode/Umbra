package com.umbra.store.controller;

import com.umbra.store.repository.BrandRepository;
import com.umbra.store.repository.CategoryRepository;
import com.umbra.store.repository.ItemRepository;
import com.umbra.store.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    private final ItemRepository itemRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public AdminController(ItemRepository itemRepository,
                           BrandRepository brandRepository,
                           CategoryRepository categoryRepository,
                           UserRepository userRepository) {
        this.itemRepository = itemRepository;
        this.brandRepository = brandRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/admin")
    public String adminDashboard(Model model) {
        model.addAttribute("totalItems", itemRepository.count());
        model.addAttribute("totalBrands", brandRepository.count());
        model.addAttribute("totalCategories", categoryRepository.count());
        model.addAttribute("totalUsers", userRepository.count());
        model.addAttribute("items", itemRepository.findAll());
        model.addAttribute("users", userRepository.findAll());
        return "admin";
    }
}