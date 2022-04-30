package com.test.arkon.model;

public class ResponseDataMbCdmx<T> {

	private String help;
	private boolean success;
	private ResultadoDataMbCdmx<T> result;

	public String getHelp() {
		return help;
	}

	public void setHelp(String help) {
		this.help = help;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public ResultadoDataMbCdmx<T> getResult() {
		return result;
	}

	public void setResult(ResultadoDataMbCdmx<T> result) {
		this.result = result;
	}
	
	

}
