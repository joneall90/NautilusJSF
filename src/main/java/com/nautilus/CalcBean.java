package com.nautilus;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;


import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.shaded.json.JSONArray;

@ManagedBean
@SessionScoped
public class CalcBean {

	private double rate = 2;
	private int nper = 3;
	private double pmt;
	private double pv = 15 ;
	private double fv;
	private int when;
	private JSONArray dataArray = new JSONArray();
	private JSONArray dataArray2 = new JSONArray();
	public JSONArray getDataArray2() {
		dataArray2 = new JSONArray();
		for(int x=0; x<this.nper;x++) {
			dataArray2.put(calculateFutureValues(getPv(),1,x));
		}
		return dataArray2;
	}

	public void setDataArray2(JSONArray dataArray2) {
		this.dataArray2 = dataArray2;
	}

	private JSONArray labelArray = new JSONArray();
	
	public JSONArray getLabelArray() {
		labelArray = new JSONArray();
		for(int x=0; x<this.nper;x++) {
			labelArray.put("Year "+ (x+1));
		}
		return labelArray;
	}

	public void setLabelArray(JSONArray labelArray) {
		this.labelArray = labelArray;
	}

	private String dataString = "[5,7,5]";
	
	public String getDataString() {
		return dataString;
	}

	public void setDataString(String dataString) {
		this.dataString = dataString;
	}

	private LineChartModel futureValueLine;
	public LineChartModel getFutureValueLine() {
		return futureValueLine;
	}

	public void setFutureValueLine(LineChartModel futureValueLine) {
		this.futureValueLine = futureValueLine;
	}

	private double calculateFutureValues(double pv2, double rate2, int nper2) {
		double fv = pv2 * Math.pow((1 + rate2 / 100), nper2);
		return fv;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public int getNper() {
		return nper;
	}

	public void setNper(int nper) {
		this.nper = nper;
	}

	public double getPmt() {
		return pmt;
	}

	public void setPmt(double pmt) {
		this.pmt = pmt;
	}

	public double getPv() {
		return pv;
	}

	public void setPv(double pv) {
		this.pv = pv;
	}

	public double getFv() {
		return fv;
	}

	public void setFv(double fv) {
		this.fv = fv;
	}

	public int getWhen() {
		return when;
	}

	public void setWhen(int when) {
		this.when = when;
	}

	public JSONArray getDataArray() {
		dataArray = new JSONArray();
		for(int x=0; x<this.nper;x++) {
			dataArray.put(calculateFutureValues(getPv(),getRate(),x));
		}
		return dataArray;
	}

	public void setDataArray(JSONArray dataArray) {
		this.dataArray = dataArray;
	}
	
	/*
	 * private void createLineModels() { futureValueLine = initLinearModel();
	 * futureValueLine.setTitle("Linear Chart");
	 * futureValueLine.setLegendPosition("e"); Axis yAxis =
	 * futureValueLine.getAxis(AxisType.Y); yAxis.setMin(0); yAxis.setMax(10);
	 * 
	 * }
	 */
	/*
	 * private LineChartModel initLinearModel() { LineChartModel model = new
	 * LineChartModel();
	 * 
	 * LineChartSeries series1 = new LineChartSeries();
	 * series1.setLabel("Series 1");
	 * 
	 * for(FutureValueModel fvm: x) { series1.set(fvm.., y); }
	 * 
	 * LineChartSeries series2 = new LineChartSeries();
	 * series2.setLabel("Series 2");
	 * 
	 * series2.set(1, 6); series2.set(2, 3); series2.set(3, 2); series2.set(4, 7);
	 * series2.set(5, 9);
	 * 
	 * 
	 * model.addSeries(series1); model.addSeries(series2);
	 * 
	 * return model; }
	 */

}
