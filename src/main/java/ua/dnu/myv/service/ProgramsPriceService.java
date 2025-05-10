package ua.dnu.myv.service;

import ua.dnu.myv.domain.ProgramsPrice;
import ua.dnu.myv.repository.ProgramsPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProgramsPriceService {
    @Autowired
    private ProgramsPriceRepository programsPriceRepository;
    public ProgramsPriceService(ProgramsPriceRepository programsPriceRepository) {
        this.programsPriceRepository = programsPriceRepository;
    }

    public List<ProgramsPrice> findAll() {
        return programsPriceRepository.findAll();
    }

    public void update(int id, ProgramsPrice programsPrice) {
        ProgramsPrice pp = programsPriceRepository.findById(id).orElse(null);
        assert pp != null;
        pp.setTo(programsPrice.getTo());
        pp.setReasonOfChange(programsPrice.getReasonOfChange());
        programsPrice.setFrom(programsPrice.getTo());
        programsPrice.setTo(null);
        programsPrice.setReasonOfChange(null);
        programsPriceRepository.save(programsPrice);
    }
    public List<ProgramsPrice> findHistoryById(int id) {
        return programsPriceRepository.findHistoryById(id);
    }

    public void save(ProgramsPrice programsPrice) {
        programsPriceRepository.save(programsPrice);
    }
}
