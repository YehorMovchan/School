package ua.dnu.myv.controller.view;

import ua.dnu.myv.domain.view.ViewTransaction;
import ua.dnu.myv.service.view.VTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("view/transaction")
public class VTransactionController {
    @Autowired
    private VTransactionService transactionService;
    public VTransactionController(VTransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/{id}")
    public List<ViewTransaction> findByKid(@PathVariable("id") int id) {
        return transactionService.findByKid(id);
    }
}
