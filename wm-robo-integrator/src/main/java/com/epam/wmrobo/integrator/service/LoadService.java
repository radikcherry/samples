package com.epam.wmrobo.integrator.service;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.epam.wmrobo.integrator.model.SimpleTickerData;

import reactor.core.publisher.Flux;

@Service
public class LoadService {

    private static final String INSERT_SQL = 
        "replace into ticker_data (ticker_symbol, ticker_date, ticker_value) values (?,?,?)";
    
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LoadService(JdbcTemplate  jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }   
    
    
    public boolean execute(Flux<SimpleTickerData> data) {
        data.buffer(100).log()
            .subscribe(bucket -> {
                jdbcTemplate.batchUpdate(INSERT_SQL,
                    new BatchPreparedStatementSetter() {
                        @Override
                        public int getBatchSize() {
                            return bucket.size();
                        }
                    
                        @Override
                        public void setValues(PreparedStatement ps, int i) throws SQLException {
                            SimpleTickerData x = bucket.get(i);
                            ps.setString(1, x.getSymbol());
                            ps.setDate(2, java.sql.Date.valueOf(x.getDate()));
                            ps.setBigDecimal(3, x.getClose());
                        }
                    }
                );
            });
        return true;
    }

}
