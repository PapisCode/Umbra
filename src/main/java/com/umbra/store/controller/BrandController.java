package com.umbra.store.controller;

import com.umbra.store.repository.BrandRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BrandController {

    private final BrandRepository brandRepository;

    public BrandController(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @GetMapping("/brands")
    public String brands(Model model) {
        model.addAttribute("brands", brandRepository.findAll());
        return "brands";
    }
}