package ua.dnu.myv.service;

import ua.dnu.myv.domain.Staff;
import ua.dnu.myv.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StaffService {
    @Autowired
    private StaffRepository staffRepository;
    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public Integer save(Staff staff, MultipartFile passportCopy) throws IOException {
        Staff s = staffRepository.save(staff);
        if(passportCopy != null) {
            s.setPassportCopy(passportCopy.getBytes());
        }
        return s.getId();
    }

    public Optional<Staff> findById(int id) {
        return staffRepository.findById(id);
    }

    public List<Staff> findAll() {
        return staffRepository.findAllByOrderByNameAsc();
    }

    public List<Staff> findTeachers() {
        return staffRepository.findTeachers();
    }

    public void update(int id, Staff staff, MultipartFile passportCopy) throws IOException {
        Staff s = staffRepository.findById(id).orElse(null);
        assert s != null;
        s.setName(staff.getName());
        s.setPosition(staff.getPosition());
        s.setPhone(staff.getPhone());
        s.setPassportNumber(staff.getPassportNumber());
        s.setTeacher(staff.getTeacher());
        s.setInfo(staff.getInfo());
        if(passportCopy != null) {
            s.setPassportCopy(passportCopy.getBytes());
        }
    }

    public void deleteById(int id) {
        staffRepository.deleteById(id);
    }



}
