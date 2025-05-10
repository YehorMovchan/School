package ua.dnu.myv.service.view.attendance;

import ua.dnu.myv.repository.view.attendance.VAGroupsRepository;
import ua.dnu.myv.repository.view.attendance.VAKidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VAKidService {

    @Autowired
    private VAKidRepository vaKidRepository;
    public VAKidService(VAKidRepository vakidRepository) {
        this.vaKidRepository = vakidRepository;
    }
}
