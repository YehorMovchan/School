package ua.dnu.myv.service.view;

import ua.dnu.myv.domain.view.ViewStaff;
import ua.dnu.myv.repository.view.VStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VStaffService {

    @Autowired
    private VStaffRepository vstaffRepository;
    public VStaffService(VStaffRepository vstaffRepository) {
        this.vstaffRepository = vstaffRepository;
    }

    public List<ViewStaff> findAllByOrderByNameAsc() {
        return vstaffRepository.findAllByOrderByNameAsc();
    }
}
