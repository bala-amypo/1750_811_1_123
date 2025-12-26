package com.example.demo.controller;

import com.example.demo.model.Supplier;
import com.example.demo.service.SupplierService;
import java.util.List;

public class SupplierController {

    private SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    public Supplier createSupplier(Supplier supplier) {
        return supplierService.addSupplier(supplier);
    }

    public List<Supplier> getSuppliers() {
        return supplierService.getAllSuppliers();
    }

    public Supplier getSupplierById(Long id) {
        return supplierService.getSupplierById(id);
    }

    public Supplier updateSupplier(Long id, Supplier supplier) {
        return supplierService.updateSupplier(id, supplier);
    }

    public boolean deleteSupplier(Long id) {
        return supplierService.deleteSupplier(id);
    }
}
