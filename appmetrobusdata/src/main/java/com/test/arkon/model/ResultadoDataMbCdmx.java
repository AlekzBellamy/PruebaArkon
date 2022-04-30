package com.test.arkon.model;

import java.util.List;

public class ResultadoDataMbCdmx<T> {

	private boolean include_total;
	private int limit;
	private String records_format;
	private String resource_id;
	private String total_estimation_threshold;
	private List<T> records;
	private List<DataMbCdmxFields> fields;
	private long total;
	private boolean total_was_estimated;

	public boolean isInclude_total() {
		return include_total;
	}

	public void setInclude_total(boolean include_total) {
		this.include_total = include_total;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getRecords_format() {
		return records_format;
	}

	public void setRecords_format(String records_format) {
		this.records_format = records_format;
	}

	public String getResource_id() {
		return resource_id;
	}

	public void setResource_id(String resource_id) {
		this.resource_id = resource_id;
	}

	public String getTotal_estimation_threshold() {
		return total_estimation_threshold;
	}

	public void setTotal_estimation_threshold(String total_estimation_threshold) {
		this.total_estimation_threshold = total_estimation_threshold;
	}

	public List<T> getRecords() {
		return records;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}

	public List<DataMbCdmxFields> getFields() {
		return fields;
	}

	public void setFields(List<DataMbCdmxFields> fields) {
		this.fields = fields;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public boolean isTotal_was_estimated() {
		return total_was_estimated;
	}

	public void setTotal_was_estimated(boolean total_was_estimated) {
		this.total_was_estimated = total_was_estimated;
	}

	@Override
	public String toString() {
		return "ResultadoDataMbCdmx [include_total=" + include_total + ", limit=" + limit + ", records_format="
				+ records_format + ", resource_id=" + resource_id + ", total_estimation_threshold="
				+ total_estimation_threshold + ", records=" + records + ", fields=" + fields + ", total=" + total
				+ ", total_was_estimated=" + total_was_estimated + "]";
	}

}
