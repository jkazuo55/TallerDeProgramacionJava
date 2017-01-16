/**
* @class GraficoEmigrante.java 
* @brief Implementacion de la Clase GraficoEmigrante</br>
* La clase GraficoEmigrante representa la vista del del analisis Estadistico;
* @author SoftTux
* @version 0.2
* @since 1.0
* @see https://github.com/jkazuo55/TallerDeProgramacionJava
*/
import java.awt.BorderLayout;
import java.util.Date;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.chart.ChartUtilities; 

public class GraficoEmigrante extends JPanel{

    public DefaultCategoryDataset dataset;
    public JFreeChart barChart;
    private ChartPanel chartPanel;

    public GraficoEmigrante(){
        super(new BorderLayout());
        dataset = new DefaultCategoryDataset();
        chartPanel = crearGrafico();
        this.add(chartPanel, BorderLayout.CENTER);
    }

    public void agregarInformacion(double cantidad, String departamento, String mes){
        dataset.addValue(cantidad,departamento,mes);
    }

    public void incrementarDato(double cantidad, String departamento, String mes){
        dataset.incrementValue(cantidad,departamento,mes);
    }

    public ChartPanel crearGrafico(){
        barChart = ChartFactory.createBarChart3D(
         "Flujo de Emigrantes por Departamento", 
         "Departamentos",
         "Cantidad",
         dataset,
         PlotOrientation.VERTICAL,
         true, true, false);
        ChartPanel panel = new ChartPanel(barChart);
        return panel;
    }
}
