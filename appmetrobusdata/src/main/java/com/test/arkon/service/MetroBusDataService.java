package com.test.arkon.service;


import java.util.ArrayList;
import java.util.Date;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


import com.test.arkon.model.DataMbCdmxAlcaldia;
import com.test.arkon.model.DataMbCdmxUnidadUbicacion;
import com.test.arkon.model.FetchDataAlcaldia;
import com.test.arkon.model.FetchDataUbicacionUnidad;
import com.test.arkon.model.ResponseDataMbCdmx;
import com.test.arkon.repository.AlcaldiaDataRepository;
import com.test.arkon.repository.FetchAlcaldiaRepository;
import com.test.arkon.repository.FetchUnidadUbicacionRepository;
import com.test.arkon.repository.UnidadDataRepository;
import com.test.arkon.util.constantes.Constantes;
import com.test.arkon.util.enums.Estatus;
import com.test.arkon.util.enums.EstatusProceso;

/**
 * Servicio para consumir información que proporciona los centros de datos de
 * CDMX
 * 
 * @author nodez
 *
 */
@Service
public class MetroBusDataService {

	private static final Logger LOG = LoggerFactory.getLogger(MetroBusDataService.class);
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private AlcaldiaDataRepository alcaldiaDataRepository;
	@Autowired
	private FetchAlcaldiaRepository fetchAlcaldiaRepository;

	@Autowired
	private UnidadDataRepository unidadDataRepository;
	@Autowired
	private FetchUnidadUbicacionRepository fetchUnidadUbicacionRepository;

	/**
	 * Metodo para obtener los registros de alcaldias
	 * 
	 * @return
	 */
	public ResponseDataMbCdmx<DataMbCdmxAlcaldia> obtenerAlcaldiasMbCdmx() {
		ResponseDataMbCdmx<DataMbCdmxAlcaldia> response = exchangeAsList(Constantes.DATOS_CDMX_GOB_MX,
				new ParameterizedTypeReference<ResponseDataMbCdmx<DataMbCdmxAlcaldia>>() {
				}, Constantes.RESOURCE_ALCALDIAS_UBICACION);
		LOG.info("obtenerAlcaldiasMbCdmx response: {}", response);
		return response;
	}

	/**
	 * Metodo para obtener los registros de unidades
	 * 
	 * @return
	 */
	public ResponseDataMbCdmx<DataMbCdmxUnidadUbicacion> obtenerUnidadesMbCdmx() {
		ResponseDataMbCdmx<DataMbCdmxUnidadUbicacion> response = exchangeAsList(Constantes.DATOS_CDMX_GOB_MX,
				new ParameterizedTypeReference<ResponseDataMbCdmx<DataMbCdmxUnidadUbicacion>>() {
				}, Constantes.RESOURCE_UNIDADES_UBICACION);
		LOG.info("obtenerUnidadesMbCdmx response: {}", response);
		return response;
	}

	/**
	 * Metodo de apoyo para generar las peticiones
	 * 
	 * @param <T>
	 * @param uri
	 * @param responseType
	 * @param idResource
	 * @return
	 */
	public <T> ResponseDataMbCdmx<T> exchangeAsList(String uri,
			ParameterizedTypeReference<ResponseDataMbCdmx<T>> responseType, String idResource) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(uri).queryParam(Constantes.PARAM_ID_RESOURCE,
				idResource);
		String uriBuilder = builder.build().encode().toUriString();
		LOG.info("exchangeAsList uriBuilder: {}", uriBuilder);
		return restTemplate.exchange(uriBuilder, HttpMethod.GET, null, responseType).getBody();
	}

	public List<DataMbCdmxAlcaldia> almacenamientoAlcaldias() {
		try {
			ResponseDataMbCdmx<DataMbCdmxAlcaldia> extractoAlcaldias = obtenerAlcaldiasMbCdmx();
			LOG.info("almacenamientoAlcaldias  DATA CDMX isSuccess : {}", extractoAlcaldias.isSuccess());
			LOG.info("almacenamientoAlcaldias  DATA CDMX extractoAlcaldias : {}",
					extractoAlcaldias.getResult().getRecords().size());
			FetchDataAlcaldia dataAlcaldia = new FetchDataAlcaldia();
			dataAlcaldia.setFecha_registro(new Date());
			dataAlcaldia.setEstatus_proceso(EstatusProceso.CORRECTO.getDescripcion());
			fetchAlcaldiaRepository.save(dataAlcaldia);
			LOG.info("almacenamientoAlcaldias  DATA CDMX dataAlcaldia : {}", dataAlcaldia);
			fetchAlcaldiaRepository.flush();
			LOG.info("almacenamientoAlcaldias  DATA CDMX after flush dataAlcaldia : {}", dataAlcaldia);

			
			for (DataMbCdmxAlcaldia item : extractoAlcaldias.getResult().getRecords()) {
				item.setId_fetch_alcaldia(dataAlcaldia.getId_fetch());
				item.setEstatus(Estatus.ACTIVO.getId());
			}
			alcaldiaDataRepository.saveAll(extractoAlcaldias.getResult().getRecords());
			alcaldiaDataRepository.bajaAlcaldiasAnteriores(dataAlcaldia.getId_fetch());
			LOG.info("almacenamiento correcto Alcaldias de DATA CDMX");
			return extractoAlcaldias.getResult().getRecords();
		} catch (Exception e) {
			FetchDataAlcaldia dataAlcaldia = new FetchDataAlcaldia();
			dataAlcaldia.setFecha_registro(new Date());
			dataAlcaldia.setEstatus_proceso(EstatusProceso.INCORRECTO.getDescripcion());
			fetchAlcaldiaRepository.save(dataAlcaldia);
			LOG.error("Error al almacenar Alcaldias de DATA CDMX", e);
			return new ArrayList<>();
		}

	}

	public List<DataMbCdmxUnidadUbicacion> almacenamientoUnidades() {
		try {
			ResponseDataMbCdmx<DataMbCdmxUnidadUbicacion> extractoUnidades = obtenerUnidadesMbCdmx();
			LOG.info("almacenamientoUnidades  DATA CDMX isSuccess : {}", extractoUnidades.isSuccess());
			LOG.info("almacenamientoUnidades  DATA CDMX extractoUnidades : {}",
					extractoUnidades.getResult().getRecords().size());

			FetchDataUbicacionUnidad dataUbicacionUnidad = new FetchDataUbicacionUnidad();
			dataUbicacionUnidad.setFecha_registro(new Date());
			dataUbicacionUnidad.setEstatus_proceso(EstatusProceso.CORRECTO.getDescripcion());
			fetchUnidadUbicacionRepository.save(dataUbicacionUnidad);
			LOG.info("almacenamientoUnidades  DATA CDMX dataUbicacionUnidad : {}", dataUbicacionUnidad);
			fetchUnidadUbicacionRepository.flush();
			LOG.info("almacenamientoUnidades  DATA CDMX after flush dataUbicacionUnidad : {}", dataUbicacionUnidad);

			for (DataMbCdmxUnidadUbicacion item : extractoUnidades.getResult().getRecords()) {
				item.setId_fetch_mb(dataUbicacionUnidad.getId_fetch());
				item.setEstatus(Estatus.ACTIVO.getId());
			}
			unidadDataRepository.saveAll(extractoUnidades.getResult().getRecords());
			unidadDataRepository.bajaUnidadesAnteriores(dataUbicacionUnidad.getId_fetch());
			LOG.info("almacenamientoUnidades correcto Unidades de DATA CDMX");
			return extractoUnidades.getResult().getRecords();
		} catch (Exception e) {
			FetchDataUbicacionUnidad dataUbicacionUnidad = new FetchDataUbicacionUnidad();
			dataUbicacionUnidad.setFecha_registro(new Date());
			dataUbicacionUnidad.setEstatus_proceso(EstatusProceso.INCORRECTO.getDescripcion());
			fetchUnidadUbicacionRepository.save(dataUbicacionUnidad);
			LOG.error("almacenamientoUnidades Error al almacenar Unidades de DATA CDMX", e);
			return new ArrayList<>();
		}

	}
}
