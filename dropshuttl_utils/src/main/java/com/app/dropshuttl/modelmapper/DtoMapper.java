package com.app.dropshuttl.modelmapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class DtoMapper{
	
	public static <E> E map(Object source, Class<E> destination){
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(source, destination);
	}
}
