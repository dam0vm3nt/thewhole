package org.dam0vm3nt.client.services;

import java.util.HashMap;
import java.util.Map;

public class Services {

	private Services() {
		initServices();
	}
	
	private void initServices() {
		mServices.put(Services.class, this);
		mServices.put(DaM0vm3ntService.class, new DaM0vm3ntService());
	}

	private final static Services SERVICES = new Services();
	
	private Map<Class<?>, Object> mServices = new HashMap<Class<?>, Object>();
	
	@SuppressWarnings("unchecked")
	public <T> T getService(Class<T> pClass) {
		return (T) mServices.get(pClass);
	}
	
	public static <T> T $(Class<T> pClass) {
		return SERVICES.getService(pClass);
	}

}
