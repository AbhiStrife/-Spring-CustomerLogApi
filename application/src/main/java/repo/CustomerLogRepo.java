package repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import entity.LogModel;

@Repository
public interface CustomerLogRepo extends JpaRepository<LogModel,String> {
    
    @Query("SELECT log FROM LogModel log WHERE log.logDate =:d")
    public List<LogModel> findByDate(@Param("d") String date);

}
