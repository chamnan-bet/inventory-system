package com.chamnan.inventory_system.controller;

import java.util.ArrayList;
import java.util.List;

import com.chamnan.inventory_system.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chamnan.inventory_system.entities.StockTransaction;
import com.chamnan.inventory_system.service.ProductService;


@Controller
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String stockManagement(Model model) {
        model.addAttribute("activePage", "stocks");
        model.addAttribute("transaction", new StockTransaction());
        model.addAttribute("products", productService.getAllProducts());
        // The history table will be loaded via AJAX from your RestController
        return "stock/management";
    }

    @GetMapping("/select/{productId}")
    public String getById(@PathVariable Long productId, Model model) {
        List<Product> allProducts = productService.getAllProducts();
        Product product = productService.findById(productId);

        StockTransaction transaction = new StockTransaction();
        transaction.setProduct(product);

        model.addAttribute("activePage", "stocks");
        model.addAttribute("transaction", transaction);
        model.addAttribute("products", allProducts);

        // This returns the same unified page, but with the 'transaction' object pre-filled
        return "stock/management";
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "stock/form";
    }

}
