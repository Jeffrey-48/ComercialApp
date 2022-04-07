package com.uniquindio.comercial_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uniquindio.comercial_app.interfaceService.IProductService;
import com.uniquindio.comercial_app.modelo.Product;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private IProductService serviceProduct;

	// Create product
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return serviceProduct.addProduct(product);
	}

	// List products
	@GetMapping("/listProducts")
	public List<Product> listProducts() {
		return serviceProduct.listProducts();
	}

	// Edit product
	@PutMapping(path = { "/editProduct" })
	public Product editProduct(@RequestBody Product product) {
		return serviceProduct.editProduct(product);
	}

	// Delete product
	@DeleteMapping(path = { "/deleteProduct/{idProduct}" })
	public Product deleteProduct(@PathVariable("idProduct") Integer idProduct) {
		return serviceProduct.deleteProduct(idProduct);
	}
	
}
