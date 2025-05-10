package ua.dnu.myv.service.view;

import ua.dnu.myv.domain.view.ViewGroup;
import ua.dnu.myv.repository.view.VGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VGroupService {
    @Autowired
    private VGroupRepository vGroupRepository;
    public VGroupService(VGroupRepository vGroupRepository) {
        this.vGroupRepository = vGroupRepository;
    }

    public List<ViewGroup> findAll(){
        return vGroupRepository.findAll();
    }

    public List<ViewGroup> findByKid(int id){
        return vGroupRepository.findByKid(id);
    }

    public List<ViewGroup> findByGroup(int id){
        return vGroupRepository.findByGroup(id);
    }
}
