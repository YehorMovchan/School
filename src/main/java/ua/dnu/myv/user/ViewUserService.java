package ua.dnu.myv.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ViewUserService {
    private final ViewUserRepository viewUserRepository;

    public ViewUserService(ViewUserRepository viewUserRepository) {
        this.viewUserRepository = viewUserRepository;
    }

    public List<ViewUser> findAll() {
        return viewUserRepository.findAll();
    }

}
