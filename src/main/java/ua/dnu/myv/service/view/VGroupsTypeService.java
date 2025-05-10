package ua.dnu.myv.service.view;

import ua.dnu.myv.domain.view.ViewGroupsType;
import ua.dnu.myv.repository.view.VGroupsTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VGroupsTypeService {
    @Autowired
    private VGroupsTypeRepository vGroupsTypeRepository;
    public VGroupsTypeService(VGroupsTypeRepository vGroupsTypeRepository) {
        this.vGroupsTypeRepository = vGroupsTypeRepository;
    }

    public List<ViewGroupsType> findAll(){
        return vGroupsTypeRepository.findAll();
    }

    public Optional<ViewGroupsType> findById(int id){
        return vGroupsTypeRepository.findById(id);
    }
}
