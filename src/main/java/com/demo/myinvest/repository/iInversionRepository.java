package com.demo.myinvest.repository;

import com.demo.myinvest.model.Inversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iInversionRepository extends JpaRepository<Inversion, Long> {
}
