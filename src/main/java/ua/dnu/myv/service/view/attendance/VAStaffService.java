package ua.dnu.myv.service.view.attendance;

import ua.dnu.myv.repository.view.attendance.VAStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VAStaffService {

    @Autowired
    private VAStaffRepository vAStaffRepository;
    public VAStaffService(VAStaffRepository vAStaffRepository) {
        this.vAStaffRepository = vAStaffRepository;
    }
}
