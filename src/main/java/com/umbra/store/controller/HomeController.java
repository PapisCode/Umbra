package com.umbra.store.controller;

import com.umbra.store.repository.BrandRepository;
import com.umbra.store.repository.CategoryRepository;
import com.umbra.store.repository.ItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final ItemRepository itemRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;

    public HomeController(ItemRepository itemRepository,
                          BrandRepository brandRepository,
                          CategoryRepository categoryRepository) {
        this.itemRepository = itemRepository;
        this.brandRepository = brandRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("totalItems", itemRepository.count());
        model.addAttribute("totalBrands", brandRepository.count());
        model.addAttribute("totalCategories", categoryRepository.count());
        model.addAttribute("recentItems", itemRepository.findAll().stream().limit(5).toList());
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}