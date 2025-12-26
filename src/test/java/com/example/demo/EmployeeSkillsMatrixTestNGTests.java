package com.example.demo;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;
import static org.testng.Assert.assertEquals;

import com.example.demo.controller.SupplierController;
import com.example.demo.model.Supplier;
import com.example.demo.service.SupplierService;

import java.util.ArrayList;
import java.util.List;

public class EmployeeSkillsMatrixTestNGTests {

    @Mock
    private SupplierService supplierService;

    @InjectMocks
    private SupplierController supplierController;

    @BeforeClass
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddSupplier() {
        Supplier supplier = new Supplier();
        supplier.setId(1L);
        supplier.setName("ABC Corp");
        supplier.setDiversityCategory("Minority");

        when(supplierService.addSupplier(supplier)).thenReturn(supplier);

        Supplier result = supplierController.addSupplier(supplier);
        assertEquals(result.getName(), "ABC Corp");
        assertEquals(result.getDiversityCategory(), "Minority");
    }

    @Test
    public void testGetAllSuppliers() {
        List<Supplier> suppliers = new ArrayList<>();
        Supplier s1 = new Supplier();
        s1.setId(1L); s1.setName("ABC Corp"); s1.setDiversityCategory("Minority");
        Supplier s2 = new Supplier();
        s2.setId(2L); s2.setName("XYZ Ltd"); s2.setDiversityCategory("Women-Owned");

        suppliers.add(s1);
        suppliers.add(s2);

        when(supplierService.getAllSuppliers()).thenReturn(suppliers);

        List<Supplier> result = supplierController.getAllSuppliers();
        assertEquals(result.size(), 2);
        assertEquals(result.get(0).getName(), "ABC Corp");
        assertEquals(result.get(1).getDiversityCategory(), "Women-Owned");
    }

    @Test
    public void testGetSupplierById() {
        Supplier supplier = new Supplier();
        supplier.setId(1L);
        supplier.setName("ABC Corp");
        supplier.setDiversityCategory("Minority");

        when(supplierService.getSupplierById(1L)).thenReturn(supplier);

        Supplier result = supplierController.getSupplierById(1L);
        assertEquals(result.getId(), Long.valueOf(1));
        assertEquals(result.getName(), "ABC Corp");
    }

    @Test
    public void testUpdateSupplier() {
        Supplier supplier = new Supplier();
        supplier.setId(1L);
        supplier.setName("ABC Corp Updated");
        supplier.setDiversityCategory("Minority");

        when(supplierService.updateSupplier(supplier)).thenReturn(supplier);

        Supplier result = supplierController.updateSupplier(supplier);
        assertEquals(result.getName(), "ABC Corp Updated");
    }

    @Test
    public void testDeleteSupplier() {
        doNothing().when(supplierService).deleteSupplier(1L);

        supplierController.deleteSupplier(1L);

        verify(supplierService, times(1)).deleteSupplier(1L);
    }
}
