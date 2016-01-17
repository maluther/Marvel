package com.marvel.repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
	parameters.put("mastermindId", mastermindId);
	Mastermind mastermind = getNamedParameterJdbcTemplate().queryForObject(query, parameters, new BeanPropertyRowMapper<Mastermind>(Mastermind.class));
	return mastermind;
    }

    public Scheme lookupScheme(int schemeId)
    {
	String query = (String)sql.get("LOOKUP_SCHEME");
	Map<String, Object> parameters = new HashMap<String, Object>();
	parameters.put("schemeId", schemeId);
	Scheme scheme = getNamedParameterJdbcTemplate().queryForObject(query, parameters, new BeanPropertyRowMapper<Scheme>(Scheme.class));
	return scheme;
    }

    public Villian[] lookupVillians(int[] villianIds)
    {
	String query = (String)sql.get("LOOKUP_VILLIANS");
	Map<String, Object> parameters = new HashMap<String, Object>();
	parameters.put("villianIds", Arrays.asList(villianIds));
	Villian[] villians = new Villian[villianIds.length];
	List<Villian> villianList = getNamedParameterJdbcTemplate().query(query, parameters, new BeanPropertyRowMapper<Villian>(Villian.class));
	villianList.toArray(villians);
	return villians;
    }

    public Henchman[] lookupHenchmen(int[] henchmenIds)
    {
	String query = (String)sql.get("LOOKUP_HENCHMEN");
	Map<String, Object> parameters = new HashMap<String, Object>();
	parameters.put("henchmenIds", henchmenIds);
	Henchman[] henchmen = new Henchman[henchmenIds.length];
	getNamedParameterJdbcTemplate().query(query, parameters, new BeanPropertyRowMapper<Henchman>(Henchman.class)).toArray(henchmen);
	return henchmen;
    }

    public Hero[] lookupHeroes(int[] heroIds)
    {
	String query = (String)sql.get("LOOKUP_HEROES");
	Map<String, Object> parameters = new HashMap<String, Object>();
	parameters.put("heroIds", heroIds);
	Hero[] heroes = new Hero[heroIds.length];
	getNamedParameterJdbcTemplate().query(query, parameters, new BeanPropertyRowMapper<Hero>(Hero.class)).toArray(heroes);
	return heroes;
    }

}
