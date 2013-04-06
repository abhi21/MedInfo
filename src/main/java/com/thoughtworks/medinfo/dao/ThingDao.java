package com.thoughtworks.medinfo.dao;

import com.thoughtworks.medinfo.model.*;

import java.util.List;

public interface ThingDao {

	Thing get(Long id);
	void save(Thing thing);
	void delete(Thing thing);
	List<Thing> findAll();

}
