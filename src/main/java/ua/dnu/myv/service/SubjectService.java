package ua.dnu.myv.service;

import ua.dnu.myv.domain.Subject;
import ua.dnu.myv.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    public void save(Subject subject) {
        subjectRepository.save(subject);
    }

    public void update(Subject subject) {
        Subject s = subjectRepository.findById(subject.getId()).orElse(null);
        assert s != null;
        s.setName(subject.getName());
    }

    public void delete(Integer id){
        subjectRepository.deleteById(id);
    }
}
