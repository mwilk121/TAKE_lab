package view.backing;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author mw121
 */
@Named(value = "chartBean")
@RequestScoped
public class ChartBean {

    private LineChartModel lineModel;

    /**
     * Creates a new instance of ChartBean
     */
    public ChartBean() {
        init();
    }

    public void init() {
        int step = 10;
        lineModel = new LineChartModel();
        LineChartSeries sins = new LineChartSeries();
        LineChartSeries coss = new LineChartSeries();

        sins.setLabel("F(x) = sin(x)");
        coss.setLabel("F(x) = cos(x)");

        for (int i = 0; i <= 36 * step; i = i + step) {
            sins.set(i, sin(Math.toRadians(Double.valueOf(i))));
            coss.set(i, cos(Math.toRadians(Double.valueOf(i))));
        }
        lineModel.addSeries(sins);
        lineModel.addSeries(coss);

        lineModel.setLegendPosition("e");
        lineModel.setZoom(true);
        Axis y = lineModel.getAxis(AxisType.Y);
        y.setMin(-1);
        y.setMax(1);
        y.setLabel("F(x)");

        Axis x = lineModel.getAxis(AxisType.X);
        x.setMin(0);
        x.setMax(360);
        x.setTickInterval("30");
        x.setLabel("x [°]");

    }

    public LineChartModel getLineModel() {
        return lineModel;
    }
}
