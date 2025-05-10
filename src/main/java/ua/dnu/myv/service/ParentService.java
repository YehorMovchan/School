package ua.dnu.myv.service;

import ua.dnu.myv.domain.Parent;
import ua.dnu.myv.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ParentService {

    @Autowired
    private ParentRepository parentRepository;
    public ParentService( ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    public List<Parent> findAll() { return parentRepository.findAll(); }

    public Optional<Parent> findById(long id) { return parentRepository.findById(id); }

    public Parent save(Parent parent) {
        return parentRepository.save(parent);
    }
}
