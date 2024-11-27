package com.inglab.balance_management.controller;

import com.inglab.balance_management.dto.request.IncomeCategoryAddRequest;
import com.inglab.balance_management.dto.request.IncomeCategoryUpdateRequest;
import com.inglab.balance_management.dto.response.IncomeCategoryGetResponse;
import com.inglab.balance_management.repository.IncomeCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/incomecategory")
public class IncomeCategoryController {
    private final IncomeCategoryRepository incomeCategoryRepository;

    @PostMapping("/add")
    public void add(@RequestBody IncomeCategoryAddRequest incomeCategoryAddRequest) {
        add(incomeCategoryAddRequest);
    }

    @PatchMapping("/update")
    public void update(@PathVariable Long id, @RequestBody IncomeCategoryUpdateRequest incomeCategoryUpdateRequest) {
        update(id, incomeCategoryUpdateRequest);
    }

    @DeleteMapping("/delete")
    public void delete(@PathVariable Long id) {
        delete(id);
    }

    @GetMapping("/get")
    public IncomeCategoryGetResponse get() {
        return get();
    }

}
