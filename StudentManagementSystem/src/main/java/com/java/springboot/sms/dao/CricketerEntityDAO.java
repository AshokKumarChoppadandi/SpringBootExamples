package com.java.springboot.sms.dao;

import com.java.springboot.sms.entity.CricketerEntity;

import java.util.List;
import java.util.Optional;

public interface CricketerEntityDAO {
    public CricketerEntity save(CricketerEntity cricketer);
    public Optional<CricketerEntity> findById(Integer id);
    public List<CricketerEntity> findAll();
    public long count();
    public void delete(CricketerEntity cricketer);
    public void deleteById(Integer id);
    public boolean existsById(Integer id);
}
