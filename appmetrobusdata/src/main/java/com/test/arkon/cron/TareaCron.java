package com.test.arkon.cron;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.test.arkon.service.MetroBusDataService;
/**
 * Clase para especificar las tareas
 * @author nodez
 *
 */
@Component
public class TareaCron {

	private static final Logger LOG = LoggerFactory.getLogger(TareaCron.class);
	
	@Autowired
	private MetroBusDataService dataService;

	/**
	 * tarea para ejecutar cada minuto
	 */
	@Scheduled(cron = "*/60 * * ? * *")
	public void ejecutarTareaA() {
		LOG.info("ejecutarTareaA ");
		try {
			dataService.almacenamientoUnidades();
		} catch (Exception e)

		{
			LOG.error("Error al dar de alta ", e);
		}
	}

	/**
	 * Tarea para ejecutar cada dia a las 00 hrs
	 */
	@Scheduled(cron = "0 0 0 ? * *")
	public void ejecutarTareaB() {
		LOG.info("ejecutarTareaB");
		try {
			dataService.almacenamientoAlcaldias();
		} catch (Exception e)

		{
			LOG.error("Error al dar de alta ", e);
		}
	}
}
