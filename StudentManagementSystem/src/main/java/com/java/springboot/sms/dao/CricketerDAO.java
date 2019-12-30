package com.java.springboot.sms.dao;

import com.java.springboot.sms.entity.Cricketer;

import java.util.List;
import java.util.Optional;

public interface CricketerDAO {

    public Cricketer save(Cricketer cricketer);
    public Optional<Cricketer> findById(Integer id);
    public List<Cricketer> findAll();
    public long count();
    public void delete(Cricketer cricketer);
    public void deleteById(Integer id);
    public boolean existsById(Integer id);
}
