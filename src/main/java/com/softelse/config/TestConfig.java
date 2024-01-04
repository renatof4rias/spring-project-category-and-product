package com.softelse.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.softelse.entities.Category;
import com.softelse.entities.Product;
import com.softelse.repositories.CategoryRepository;
import com.softelse.repositories.ProductRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Books");
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		
		Product p1 = new Product(null, "TV", 2200.00);
		Product p2 = new Product(null, "Domain Driven Desing", 120.00);
		Product p3 = new Product(null, "PS5", 2800.00);
		Product p4 = new Product(null, "Docker", 100.00);
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
		
		p1.setCategory(cat1);
		p2.setCategory(cat2);
		p3.setCategory(cat1);
		p4.setCategory(cat2);

//		cat1.getProducts().add(p1);
//		cat1.getProducts().add(p3);
//		cat2.getProducts().add(p2);
//		cat2.getProducts().add(p4);
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
		
	}
}
