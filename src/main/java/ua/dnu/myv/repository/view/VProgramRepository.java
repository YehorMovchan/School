package ua.dnu.myv.repository.view;

import ua.dnu.myv.domain.view.ViewProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VProgramRepository extends JpaRepository<ViewProgram, Long> {
    @Query("select p from ViewProgram p where p.kidId=?1 and p.to is null order by p.kidName")
    public ViewProgram findByKid(int kid);

    @Query("select p from ViewProgram p where p.kidId=?1 order by p.kidName")
    public List<ViewProgram> findHistoryByKid(int kid);

    @Query("select p from ViewProgram  p where p.programId=?1 and p.to is null order by p.kidName")
    public List<ViewProgram> findByProgram(int programId);

    @Query("select v.programPrice from ViewProgram v where v.kidId=?1 and v.priceTo is null and v.to is null ")
    Optional<Integer> findPriceByKid(int kidId);
}
