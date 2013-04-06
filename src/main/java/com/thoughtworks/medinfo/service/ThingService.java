package com.thoughtworks.medinfo.service;

import com.thoughtworks.medinfo.model.Thing;
import com.thoughtworks.medinfo.web.ThingCommand;
import com.thoughtworks.medinfo.web.ThingGrid;

public interface ThingService {
	
	Thing get(Long id);
	
	void save(ThingCommand thingCommand);
	
	void delete(Thing thing);
	
	ThingGrid findAll();
	
	void saveAll(ThingGrid thingGrid);

	void updateWithAll(ThingGrid thingGrid);
	
}
