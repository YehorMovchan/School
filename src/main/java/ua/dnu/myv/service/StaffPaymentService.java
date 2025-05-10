package ua.dnu.myv.service;

import ua.dnu.myv.domain.StaffPayment;
import ua.dnu.myv.repository.StaffPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StaffPaymentService {

    @Autowired
    private StaffPaymentRepository staffPaymentRepository;
    public StaffPaymentService(StaffPaymentRepository staffPaymentRepository) {
        this.staffPaymentRepository = staffPaymentRepository;
    }

    public void save(StaffPayment staffPayment) {
        staffPaymentRepository.save(staffPayment);
    }

    public List<StaffPayment> findAll() {
        return staffPaymentRepository.findAll();
    }

    public StaffPayment findActual(int id) {
        return staffPaymentRepository.findActual(id);
    }

    public void update(int id, StaffPayment staffPayment) {
        StaffPayment oldPayment = staffPaymentRepository.findActual(id);
        if (oldPayment != null) {
            oldPayment.setTo(staffPayment.getTo());
            oldPayment.setReasonOfChange(staffPayment.getReasonOfChange());
        }
        staffPayment.setFrom(staffPayment.getTo());
        staffPayment.setTo(null);
        staffPayment.setReasonOfChange(null);
        staffPaymentRepository.save(staffPayment);
    }

    public List<StaffPayment> findHistory(int id) {
        return staffPaymentRepository.findHistory(id);
    }
}
