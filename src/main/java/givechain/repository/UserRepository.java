package givechain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import givechain.domain.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>
{
  
}
