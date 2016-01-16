package com.marvel.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.marvel.domain.Henchman;
import com.marvel.domain.Hero;
import com.marvel.domain.Mastermind;
import com.marvel.domain.Scheme;
import com.marvel.domain.Villian;

@Repository
public class RandomizerRepository extends NamedParameterJdbcDaoSupport
{

    Properties sql;

    @Autowired
    RandomizerRepository(@Qualifier("dataSource") DataSource ds, @Qualifier("marvelQueriesBean") Properties sql)
    {
	super();
	this.setDataSource(ds);
	this.sql = sql;
    }

    public Mastermind lookupMastermind(int mastermindId)
    {
	String query = (String)sql.get("LOOKUP_MASTERMIND");
	Map<String, Object> parameters = new HashMap<String, Object>();
	int tableMasterMindId = mastermindId * 10 + 1;
	parameters.put("mastermindId", tableMasterMindId);
	Mastermind mastermind = getNamedParameterJdbcTemplate().queryForObject(query, parameters, new BeanPropertyRowMapper<Mastermind>(Mastermind.class));
	return mastermind;
    }

    public Scheme lookupScheme(int schemeId)
    {
	// TODO Auto-generated method stub
	return null;
    }

    public Villian[] lookupVillians(int[] villianIds)
    {
	// TODO Auto-generated method stub
	return null;
    }

    public Henchman[] lookupHenchmen(int[] henchmenIds)
    {
	// TODO Auto-generated method stub
	return null;
    }

    public Hero[] lookupHeroes(int[] heroIds)
    {

	return null;
    }

}
