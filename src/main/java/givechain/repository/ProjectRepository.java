package givechain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import givechain.domain.CProject;

import java.util.List;

public interface ProjectRepository extends JpaRepository<CProject, Long>
{
    @Query("select c from CProject c where c.charity like %?1%")
    List<CProject> findByCharity (String charity);
}
