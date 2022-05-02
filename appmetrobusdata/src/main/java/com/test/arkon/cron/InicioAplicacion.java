package com.test.arkon.cron;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.test.arkon.service.MetroBusDataService;

@Component
public class InicioAplicacion implements ApplicationListener<ApplicationReadyEvent> {
	private static final Logger LOG = LoggerFactory.getLogger(InicioAplicacion.class);
	@Autowired
	private MetroBusDataService dataService;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		LOG.info("onApplicationEvent");
		try {
			dataService.almacenamientoAlcaldias();
		} catch (Exception e)

		{
			LOG.error("onApplicationEvent Error al dar de alta ", e);
		}

	}

}
