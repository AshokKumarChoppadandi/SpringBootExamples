package com.java.springboot.sms.repo;

import com.java.springboot.sms.entity.CricketerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaCricketerRepository extends JpaRepository<CricketerEntity, Integer> {
    List<CricketerEntity> findAllByLastName(String lastName);
    List<CricketerEntity> findAllByFirstNameAndLastName(String firstName, String lastName);
    List<CricketerEntity> findAllByFirstNameLikeOrLastNameLike(String firstName, String lastName);
}
