package com.xpanxion.java.assignments.student2;

import com.xpanxion.java.assignments.DataAccess;
import com.xpanxion.java.assignments.model.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Worker2 {

    DataAccess dataAccess = new DataAccess();
    HashMap<Integer, String> depNames = new HashMap<>();

    public void ex1() {
        depNames.put(1,"Electronics");
        depNames.put(2,"Food");

        Map<Integer, Product> products = dataAccess.getProducts()
                .stream()
                .map(p -> {
                    p.setDepartmentName(depNames.get(p.getDepartmentId()));
                    return p;
                }).collect(Collectors.toMap(Product::getId,
                        Function.identity()));

        System.out.println("Ex. 1...");
        System.out.println(products);
    }
}
