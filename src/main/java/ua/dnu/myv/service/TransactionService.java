package ua.dnu.myv.service;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import ua.dnu.myv.domain.Kid;
import ua.dnu.myv.domain.Nutrition;
import ua.dnu.myv.domain.NutritionPrice;
import ua.dnu.myv.domain.Transaction;
import ua.dnu.myv.domain.view.ViewKidProgramGroup;
import ua.dnu.myv.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ua.dnu.myv.service.view.VKidProgramGroupService;
import ua.dnu.myv.service.view.VProgramService;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private KidService kidService;

    @Autowired
    private NutritionService nutritionService;

    @Autowired
    private NutritionPriceService nutritionPriceService;

    @Autowired
    private VKidProgramGroupService vKidProgramGroupService;

    @Autowired
    private GroupsScheduleService groupsScheduleService;

    @Autowired
    private VProgramService vProgramService;


    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public void save(Transaction transaction, MultipartFile receipt) throws IOException {
        Transaction t = transactionRepository.save(transaction);
        if(receipt != null) {
            t.setReceipt(receipt.getBytes());
        }
    }


    public void saveGroupsList(List<Transaction> transactions) {
        transactions.forEach(transaction -> {
            int kid = transaction.getKid();
            int group = groupsScheduleService.findById(transaction.getIdOfItem()).get_group();
            List<ViewKidProgramGroup> list = vKidProgramGroupService.findByKidId(kid);
            List<Integer> freeGroups = list.stream().map(ViewKidProgramGroup::getGroupId).toList();

            if(freeGroups.contains(group)) {
                return;
            }
            List<Transaction> matches = transactionRepository.
                    findByDateAndIdOfItem(
                            transaction.getDate(),
                            transaction.getIdOfItem());
            if(matches.isEmpty()) {
                transactionRepository.save(transaction);
            }
        });
    }

    public void saveNutritionList(List<Transaction> transactions) {
        transactions.forEach(transaction -> {
            List<Transaction> matches = transactionRepository.findByKidAndDateAndType(transaction.getKid(),
                    transaction.getDate(),
                    transaction.getType());
            if(matches.isEmpty()) {
                Nutrition n = nutritionService.findByKid(transaction.getKid());
                NutritionPrice prices = nutritionPriceService.findNutritionPrice().get();
                int sum = 0;
                sum -= n.getDinner() ? prices.getDinner() : 0;
                sum -= n.getBreakfast() ? prices.getBreakfast() : 0;
                sum -= n.getLunch() ? prices.getLunch() : 0;
                transaction.setSum(sum);
                transactionRepository.save(transaction);
            }
        });
    }

    public Integer findSumByKid(int kidId){
        return transactionRepository.findSumByKid(kidId);
    }

    @Scheduled(cron = "0 0 0 1 * ?")
    public void processMonthlyTransactions() {
        List<Kid> kids = kidService.findAll();
        kids.forEach(kid->{
            int price = vProgramService.findSumByKid(kid.getId());
            Transaction transaction = new Transaction();
            transaction.setSum(-price);
            transaction.setDate(LocalDate.now());
            transaction.setType(4);
            transaction.setKid(kid.getId());
            transactionRepository.save(transaction);
        });
    }

    @EventListener(ApplicationReadyEvent.class)
    public void createMonthlyPaymentIfNotExist(){
        YearMonth currentMonth = YearMonth.now();
        List<Kid> kids = kidService.findAll();
        kids.forEach(kid -> {
            boolean exists = transactionRepository.checkOnMonthlyPayment(currentMonth.getYear(), currentMonth.getMonthValue(), kid.getId());
            if(!exists){
                int price = vProgramService.findSumByKid(kid.getId());
                Transaction transaction = new Transaction();
                transaction.setSum(-price);
                transaction.setDate(LocalDate.now());
                transaction.setType(4);
                transaction.setKid(kid.getId());
                transactionRepository.save(transaction);
            }
        });
    }

}
