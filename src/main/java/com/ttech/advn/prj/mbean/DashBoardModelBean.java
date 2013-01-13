/**
 * 
 */
package com.ttech.advn.prj.mbean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import lombok.Getter;

import org.primefaces.event.DashboardReorderEvent;
import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;
import org.primefaces.model.chart.BubbleChartModel;
import org.primefaces.model.chart.BubbleChartSeries;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.springframework.stereotype.Controller;

/**
 * @author Ramkumar
 * @copyrights  Code written, Owned, and Licensed by TRIADIC Technologies, Inc
 * @since Jan 12, 2013 
 */
@Controller
public class DashBoardModelBean implements Serializable {

	private static final long serialVersionUID = -2290786551988739359L;
	
	@Getter 
	private DashboardModel model;
	@Getter  
	private CartesianChartModel categoryModel;
	@Getter  
	private BubbleChartModel bubbleModel;  
	
	public DashBoardModelBean() {
		model = new DefaultDashboardModel();
		DashboardColumn column1 = new DefaultDashboardColumn();
		DashboardColumn column2 = new DefaultDashboardColumn();
		DashboardColumn column3 = new DefaultDashboardColumn();
		
		column1.addWidget("sports");
		column1.addWidget("finance");
		
		column2.addWidget("lifestyle");
		column2.addWidget("weather");
		
		column3.addWidget("politics");

		model.addColumn(column1);
		model.addColumn(column2);
		model.addColumn(column3);
		
        categoryModel = new CartesianChartModel();

        ChartSeries boys = new ChartSeries();
        boys.setLabel("Boys");

        boys.set("2004", 120);
        boys.set("2005", 100);
        boys.set("2006", 44);
        boys.set("2007", 150);
        boys.set("2008", 25);

        ChartSeries girls = new ChartSeries();
        girls.setLabel("Girls");

        girls.set("2004", 52);
        girls.set("2005", 60);
        girls.set("2006", 110);
        girls.set("2007", 135);
        girls.set("2008", 120);

        categoryModel.addSeries(boys);
        categoryModel.addSeries(girls);
        
        bubbleModel = new BubbleChartModel();  
        
        bubbleModel.add(new BubbleChartSeries("Acura", 70, 183,55));  
        bubbleModel.add(new BubbleChartSeries("Alfa Romeo", 45, 92, 36));  
        bubbleModel.add(new BubbleChartSeries("AM General", 24, 104, 40));  
        bubbleModel.add(new BubbleChartSeries("Bugatti", 50, 123, 60));  
        bubbleModel.add(new BubbleChartSeries("BMW", 15, 89, 25));  
        bubbleModel.add(new BubbleChartSeries("Audi", 40, 180, 80));  
        bubbleModel.add(new BubbleChartSeries("Aston Martin", 70, 70, 48)); 
	}
	
	public void handleReorder(DashboardReorderEvent event) {
		FacesMessage message = new FacesMessage();
		message.setSeverity(FacesMessage.SEVERITY_INFO);
		message.setSummary("Reordered: " + event.getWidgetId());
		message.setDetail("Item index: " + event.getItemIndex() + ", Column index: " + event.getColumnIndex() + ", Sender index: " + event.getSenderColumnIndex());
		addMessage(message);
	}
	
	private void addMessage(FacesMessage message) {
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	
	
}
			