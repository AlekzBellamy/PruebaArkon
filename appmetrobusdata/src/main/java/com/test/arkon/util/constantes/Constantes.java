package com.test.arkon.util.constantes;

/**
 * Definicion de Constantes
 * 
 * @author nodez
 *
 */
public final class Constantes {

	private Constantes() {
	}

	public static final String UNIDADES_UBICACION;
	public static final String ALCALDIAS_UBICACION;

	public static final String DATOS_CDMX_GOB_MX;

	public static final String PARAM_ID_RESOURCE;
	public static final String RESOURCE_UNIDADES_UBICACION;
	public static final String RESOURCE_ALCALDIAS_UBICACION;

	static {

		UNIDADES_UBICACION = "https://datos.cdmx.gob.mx/api/3/action/datastore_search?resource_id=ad360a0e-b42f-482c-af12-1fd72140032e";
		ALCALDIAS_UBICACION = "https://datos.cdmx.gob.mx/api/3/action/datastore_search?resource_id=e4a9b05f-c480-45fb-a62c-6d4e39c5180e";

		DATOS_CDMX_GOB_MX = "https://datos.cdmx.gob.mx/api/3/action/datastore_search";

		PARAM_ID_RESOURCE = "resource_id";
		RESOURCE_UNIDADES_UBICACION = "ad360a0e-b42f-482c-af12-1fd72140032e";
		RESOURCE_ALCALDIAS_UBICACION = "e4a9b05f-c480-45fb-a62c-6d4e39c5180e";

	}
}
