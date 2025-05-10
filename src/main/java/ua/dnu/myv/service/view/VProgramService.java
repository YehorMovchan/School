package ua.dnu.myv.service.view;

import ua.dnu.myv.domain.view.ViewProgram;
import ua.dnu.myv.repository.view.VProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class VProgramService {
    @Autowired
    private VProgramRepository vProgramRepository;
    public VProgramService(VProgramRepository vProgramRepository) {
        this.vProgramRepository = vProgramRepository;
    }

    public ViewProgram findByKid(int kid) {
        return Objects.requireNonNullElseGet(
                vProgramRepository.findByKid(kid),
                ViewProgram::new
        );
    }

    public List<ViewProgram> findHistoryByKid(int id){
        return vProgramRepository.findHistoryByKid(id);
    }

    public List<ViewProgram> findByProgram(int id){
        return vProgramRepository.findByProgram(id);
    }

    public Integer findSumByKid(int kidId){
        return vProgramRepository.findPriceByKid(kidId).orElse(-1);
    }
}
