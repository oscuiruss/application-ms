package com.hakaton.us.repo.repository;

import com.hakaton.us.repo.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long>, JpaSpecificationExecutor<Application> {

}

