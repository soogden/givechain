package givechain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import givechain.domain.Charity;

import java.util.List;

public interface CharityRepository extends JpaRepository<Charity, Long>
{
  
}
