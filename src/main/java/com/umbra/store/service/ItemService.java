package com.umbra.store.service;

import com.umbra.store.entity.Brand;
import com.umbra.store.entity.Category;
import com.umbra.store.entity.Item;
import com.umbra.store.form.ItemForm;
import com.umbra.store.repository.BrandRepository;
import com.umbra.store.repository.CategoryRepository;
import com.umbra.store.repository.ItemRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;

    public ItemService(ItemRepository itemRepository,
                       BrandRepository brandRepository,
                       CategoryRepository categoryRepository) {
        this.itemRepository = itemRepository;
        this.brandRepository = brandRepository;
        this.categoryRepository = categoryRepository;
    }

    public Page<Item> getFilteredItems(String keyword,
                                       Long brandId,
                                       Long categoryId,
                                       int page,
                                       int size,
                                       String sortField,
                                       String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase("desc")
                ? Sort.by(sortField).descending()
                : Sort.by(sortField).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return itemRepository.searchItems(keyword, brandId, categoryId, pageable);
    }

    public void saveItem(ItemForm form) {
        Brand brand = brandRepository.findById(form.getBrandId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid brand ID"));

        Category category = categoryRepository.findById(form.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid category ID"));

        Item item = new Item();
        item.setName(form.getName());
        item.setSku(form.getSku());
        item.setPrice(form.getPrice());
        item.setDescription(form.getDescription());
        item.setBrand(brand);
        item.setCategory(category);

        itemRepository.save(item);
    }

    public boolean skuExists(String sku) {
        return itemRepository.existsBySkuIgnoreCase(sku);
    }
}

