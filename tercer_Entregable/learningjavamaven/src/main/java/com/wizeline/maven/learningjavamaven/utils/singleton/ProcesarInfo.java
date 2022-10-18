package com.wizeline.maven.learningjavamaven.utils.singleton;

import java.util.logging.Logger;
import java.util.regex.Pattern;

 


public class ProcesarInfo {
	private static final Logger LOG = Logger.getLogger(ProcesarInfo.class.getName());

	public String fecha;
	private static ProcesarInfo SINGLETON;

	private static Pattern DATE_PATTERN = Pattern.compile("^\\d{2}-\\d{2}-\\d{4}$");

	public ProcesarInfo(String fecha) {
	}

	public static ProcesarInfo getInstance(String fecha) {
		SINGLETON = new ProcesarInfo(fecha);
		return SINGLETON;
	}

	public boolean isDateFormatValid(String fecha) {
		LOG.info(
				"diseño de patron singleton" + fecha);
		return DATE_PATTERN.matcher(fecha).matches();
	}

}
