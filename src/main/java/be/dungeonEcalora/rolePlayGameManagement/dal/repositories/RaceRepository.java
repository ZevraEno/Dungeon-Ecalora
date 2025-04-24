package be.dungeonEcalora.rolePlayGameManagement.dal.repositories;

import be.dungeonEcalora.rolePlayGameManagement.dl.entities.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RaceRepository extends JpaRepository<Race, Long> {

    boolean existsByName(String name);

    @Query("SELECT r FROM Race r ORDER BY r.nom ASC")
    List<Race> findAllOrderedByName();

    @Query("SELECT r FROM Race r WHERE r.taille = true")
    List<Race> findAllAvailableRaces();

    @Query("SELECT r FROM Race r WHERE LOWER(r.nom) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Race> searchByName(@Param("keyword") String keyword);

}