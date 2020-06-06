package com.globalsoft.constants;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class GenericConstants {
	public static Map<String, String> tokenActiveStatus = new HashMap<>();

	{
		tokenActiveStatus.put("active", "ACTIVE");
	}

}
