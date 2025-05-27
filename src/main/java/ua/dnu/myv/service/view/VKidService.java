package ua.dnu.myv.service.view;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.dnu.myv.domain.view.ViewKid;
import ua.dnu.myv.repository.view.VKidRepository;

import java.util.List;

@Service
@Transactional
public class VKidService {
    private final VKidRepository vkidRepository;

    public VKidService(VKidRepository vkidRepository) {
        this.vkidRepository = vkidRepository;
    }

    public List<ViewKid> findStudentsByGrade(int grade) {
        return vkidRepository.findAllByGradeAndSchoolIncludedIsTrue(grade);
    }
    public ViewKid findById(int id) {
        return vkidRepository.findById(id).orElse(null);
    }
}
