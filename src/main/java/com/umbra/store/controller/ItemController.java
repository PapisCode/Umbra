package com.umbra.store.controller;

import com.umbra.store.entity.Item;
import com.umbra.store.form.ItemForm;
import com.umbra.store.repository.BrandRepository;
import com.umbra.store.repository.CategoryRepository;
import com.umbra.store.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;

    public ItemController(ItemService itemService,
                          BrandRepository brandRepository,
                          CategoryRepository categoryRepository) {
        this.itemService = itemService;
        this.brandRepository = brandRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public String listItems(
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(required = false) Long brandId,
            @RequestParam(required = false) Long categoryId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sortField,
            @RequestParam(defaultValue = "asc") String sortDir,
            Model model) {

        Page<Item> itemPage = itemService.getFilteredItems(
                keyword, brandId, categoryId, page, size, sortField, sortDir
        );

        model.addAttribute("itemPage", itemPage);
        model.addAttribute("items", itemPage.getContent());
        model.addAttribute("brands", brandRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());

        model.addAttribute("keyword", keyword);
        model.addAttribute("brandId", brandId);
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", size);

        return "items";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("itemForm", new ItemForm());
        model.addAttribute("brands", brandRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
        return "item-form";
    }

    @PostMapping("/save")
    public String saveItem(@Valid @ModelAttribute("itemForm") ItemForm itemForm,
                           BindingResult result,
                           Model model) {

        if (itemForm.getSku() != null && itemService.skuExists(itemForm.getSku())) {
            result.rejectValue("sku", "error.itemForm", "SKU must be unique.");
        }

        if (result.hasErrors()) {
            model.addAttribute("brands", brandRepository.findAll());
            model.addAttribute("categories", categoryRepository.findAll());
            return "item-form";
        }

        itemService.saveItem(itemForm);
        return "redirect:/items";
    }
}