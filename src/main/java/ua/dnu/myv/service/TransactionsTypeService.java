package ua.dnu.myv.service;


import ua.dnu.myv.domain.TransactionsType;
import ua.dnu.myv.repository.TransactionsTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TransactionsTypeService {

    @Autowired
    private TransactionsTypeRepository transactionsTypeRepository;
    public TransactionsTypeService(TransactionsTypeRepository transactionsTypeRepository) {
        this.transactionsTypeRepository = transactionsTypeRepository;
    }

    public List<TransactionsType> findAll() {
        return transactionsTypeRepository.findAll();
    }
}
