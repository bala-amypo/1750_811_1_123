package com.example.demo.service;

import com.example.demo.model.Supplier;
import java.util.ArrayList;
import java.util.List;

public class SupplierService {

    private List<Supplier> suppliers = new ArrayList<>();

    public Supplier addSupplier(Supplier supplier) {
        suppliers.add(supplier);
        return supplier;
    }

    public List<Supplier> getAllSuppliers() {
        return suppliers;
    }

    public Supplier getSupplierById(Long id) {
        return suppliers.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }

    public Supplier updateSupplier(Long id, Supplier updatedSupplier) {
        Supplier existing = getSupplierById(id);
        if (existing != null) {
            existing.setName(updatedSupplier.getName());
            existing.setCategory(updatedSupplier.getCategory());
        }
        return existing;
    }

    public boolean deleteSupplier(Long id) {
        return suppliers.removeIf(s -> s.getId().equals(id));
    }
}
