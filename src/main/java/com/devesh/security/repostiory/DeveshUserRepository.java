package com.devesh.security.repostiory;


import com.devesh.security.model.DeveshUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveshUserRepository extends JpaRepository<DeveshUser, Integer> {
}
