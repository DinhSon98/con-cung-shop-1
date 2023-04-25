package com.concungshop.service.impl;

import com.concungshop.dto.CategoryDto;
import com.concungshop.dto.ProductDto;
import com.concungshop.entity.Category;
import com.concungshop.entity.Product;
import com.concungshop.repository.ProductRepository;
import com.concungshop.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public java.lang.Object findAll() {
        Iterable<Product> products = productRepository.findByActivated(true);
        return StreamSupport.stream(products.spliterator(), true)
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductDto> findById(Long id) {
        Product product = productRepository.findById(id).get();
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        return Optional.ofNullable(productDto);
    }


    @Override
    public void save(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        Product product = productRepository.findById(id).get();
        product.setActivated(false);;
        productRepository.save(product);
    }

    @Override
    public Iterable<ProductDto> findByNameContaining(String keyword) {
        Iterable<Product> products = productRepository.findByNameContaining(keyword);
        return StreamSupport.stream(products.spliterator(), true)
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<ProductDto> findByCategory(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);
        Iterable<Product> products = productRepository.findByCategory(category);
        return StreamSupport.stream(products.spliterator(), true)
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Page<ProductDto> findAllByFullNameContaining(String fullName, Pageable pageable) {
        Page<Product> entities = productRepository.findAllByNameContaining(fullName, pageable);
        Page<ProductDto> productDtos = entities.map(entity -> {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(entity, productDto);
            return productDto;
        });
        return productDtos;
    }

    @Override
    public Page<ProductDto> findAll(Pageable pageable) {
        Page<Product> entities = productRepository.findAll(pageable);
        Page<ProductDto> productDtos = entities.map(entity -> {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(entity, productDto);
            return productDto;
        });
        return productDtos;
    }

    @Override
    public void deleteByCategory(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);
        Iterable<Product> products = productRepository.findByCategory(category);
        for(Product p: products) {
            p.setActivated(false);
        }
    }
}
