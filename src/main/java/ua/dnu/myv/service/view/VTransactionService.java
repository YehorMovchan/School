package ua.dnu.myv.service.view;

import ua.dnu.myv.domain.view.ViewTransaction;
import ua.dnu.myv.repository.view.VTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VTransactionService {
    @Autowired
    private VTransactionRepository vTransactionRepository;
    public VTransactionService(VTransactionRepository vTransactionRepository) {
        this.vTransactionRepository = vTransactionRepository;
    }

    public List<ViewTransaction> findByKid(int id){
        return vTransactionRepository.findByKid(id);
    }
}
