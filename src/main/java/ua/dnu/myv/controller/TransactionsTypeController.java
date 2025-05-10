package ua.dnu.myv.controller;

import ua.dnu.myv.domain.TransactionsType;
import ua.dnu.myv.service.TransactionsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transactions-type")
public class TransactionsTypeController {

    @Autowired
    private TransactionsTypeService transactionsTypeService;
    public TransactionsTypeController(TransactionsTypeService transactionsTypeService) {
        this.transactionsTypeService = transactionsTypeService;
    }

    @GetMapping
    public List<TransactionsType> findAll() {
        return transactionsTypeService.findAll();
    }
}
