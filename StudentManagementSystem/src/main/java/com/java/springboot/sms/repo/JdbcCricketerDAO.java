package com.java.springboot.sms.repo;

import com.java.springboot.sms.dao.CricketerDAO;
import com.java.springboot.sms.entity.Cricketer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
//@SuppressWarnings({"SqlResolve", "SqlNoDataSourceInspection", "ConstantConditions"})
public class JdbcCricketerDAO implements CricketerDAO {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert jdbcInsert;

    private RowMapper<Cricketer> cricketerRowMapper =
            ((resultSet, i) -> new Cricketer(
                    resultSet.getInt("id"),
                    resultSet.getString("skill"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name")
            ));

    public JdbcCricketerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.jdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("cricketers")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public Cricketer save(Cricketer cricketer) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("skill", cricketer.getSkill());
        parameters.put("first_name", cricketer.getFirstName());
        parameters.put("last_name", cricketer.getLastName());

        //Integer newId =  Integer.valueOf(String.valueOf(jdbcInsert.executeAndReturnKey(parameters)));
        Integer newId = jdbcInsert.executeAndReturnKey(parameters).intValue();
        cricketer.setId(newId);

        return cricketer;
    }

    @Override
    public Optional<Cricketer> findById(Integer id) {
        if(!existsById(id))
            return Optional.empty();
        return Optional.ofNullable(
                jdbcTemplate.queryForObject(
                        "select * from cricketers where id = ?",
                        /*((resultSet, i) -> new Cricketer(
                                resultSet.getInt("id"),
                                resultSet.getString("skill"),
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name")
                        ))*/
                        cricketerRowMapper,
                        id
                )
        );
    }

    @Override
    public List<Cricketer> findAll() {
        return jdbcTemplate.query(
                "select * from cricketers",
                /*((resultSet, i) -> new Cricketer(
                        resultSet.getInt("id"),
                        resultSet.getString("skill"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name")
                ))*/
                cricketerRowMapper
        );
    }

    @Override
    public long count() {
        return jdbcTemplate.queryForObject(
                "select count(*) from cricketers",
                Long.class
        );
    }

    @Override
    public void delete(Cricketer cricketer) {
        jdbcTemplate.update(
                "delete from cricketers where id = ?",
                cricketer.getId()
        );
    }

    @Override
    public void deleteById(Integer id) {
        jdbcTemplate.update(
                "delete from cricketers where id = ?",
                id
        );
    }

    @Override
    public boolean existsById(Integer id) {
        return jdbcTemplate.queryForObject(
                "select exists(select 1 from cricketers where id = ?)",
                Boolean.class,
                id
        );
    }
}
