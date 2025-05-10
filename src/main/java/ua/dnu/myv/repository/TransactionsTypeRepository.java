package ua.dnu.myv.repository;

import ua.dnu.myv.domain.TransactionsType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TransactionsTypeRepository extends JpaRepository<TransactionsType, Integer> {
}
