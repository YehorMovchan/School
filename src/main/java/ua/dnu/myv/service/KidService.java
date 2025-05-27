package ua.dnu.myv.service;


import ua.dnu.myv.domain.Kid;
import ua.dnu.myv.repository.KidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class KidService {

    private final KidRepository kidRepository;

    public KidService(KidRepository kidRepository){
        this.kidRepository=kidRepository;
    }

    public List<Kid> findAll(){
        return kidRepository.findAll();
    }

    public Integer save(Kid kid, MultipartFile birthCertificate) throws IOException {
        Kid newKid = kidRepository.save(kid);
        if(birthCertificate!=null){
            newKid.setBirthCertificate(birthCertificate.getBytes());
        }
        return newKid.getId();
    }

    public Optional<Kid> findById(int id){
        return kidRepository.findById(id);
    }


    public List<Kid> findByGrade(int grade){
        return kidRepository.findByGrade(grade);
    }

    public void update(int id, Kid kidNew, MultipartFile birthCertificate) throws IOException {
        Kid kid = kidRepository.findById(id).orElse(null);
        assert kid != null;
        kid.setName(kidNew.getName());
        kid.setBirthday(kidNew.getBirthday());
        kid.setGrade(kidNew.getGrade());
        if(birthCertificate != null){
            kid.setBirthCertificate(birthCertificate.getBytes());
        }
    }

    public void updateParents(int id, Kid kidNew){
        Kid kid = kidRepository.findById(id).orElse(null);
        assert kid != null;
        kid.setMother(kidNew.getMother());
        kid.setFather(kidNew.getFather());
    }

    public void deleteById(int id){
        kidRepository.deleteById(id);
    }
}
