package ua.dnu.myv.controller;

import org.springframework.web.bind.annotation.*;
import ua.dnu.myv.domain.Transaction;
import ua.dnu.myv.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public void save(@RequestPart Transaction transaction, @RequestPart MultipartFile receipt) throws IOException {
        transactionService.save(transaction, receipt);
    }


    @PostMapping("groups-list")
    public void saveGroupsList(@RequestBody List<Transaction> transactions) throws IOException {
        transactionService.saveGroupsList(transactions);
    }

    @PostMapping("nutrition-list")
    public void saveNutritionList(@RequestBody List<Transaction> transactions) throws IOException {
        transactionService.saveNutritionList(transactions);
    }

    @GetMapping("sum/{id}")
    public int sum(@PathVariable int id) throws IOException {
        return transactionService.findSumByKid(id);
    }
}
