package be.dungeonEcalora.rolePlayGameManagement.dal.repositories;

import be.dungeonEcalora.rolePlayGameManagement.dl.entities.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RaceRepository extends JpaRepository<Race, Long> {


}