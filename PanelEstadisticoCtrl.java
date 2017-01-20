/**
* @class PanelEstadistico.java 
* @brief Implementacion de la Clase PanelEstadistico</br>
* La clase PanelEstadistico es controlador auxiliar de la Clase PestaniaAnalisisEstadisco;
* @author SoftTux
* @version 0.2
* @since 1.0
* @see https://github.com/jkazuo55/TallerDeProgramacionJava
*/
import java.awt.event.*;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.axis.NumberAxis;
import java.util.Calendar;
import java.util.HashMap;

public class PanelEstadisticoCtrl implements ActionListener {

    private PanelEstadisticoModel model;
    private PestaniaEstadistico view;
    private PanelEstadisticoCtrl self;
    private JRadioButton radioGeneral;
    private JRadioButton radioCiudad;
    private JComboBox<String> comboMotivo;
    private JComboBox<String> comboCiudad;
    private JComboBox<String> comboYear;
    private HashMap<String,String[]> filterData;
    private Controlador generalController;

    public PanelEstadisticoCtrl(PestaniaEstadistico panelView) {
        self = this;
        this.view = panelView;
        this.model = new PanelEstadisticoModel();
    }

    public String obtenerMes(int value){
        String meses[] = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        return meses[value];
    }
    
    public void actualizarInformacion(String departamento,String mes){
	String data[];
	String data_mes; 
	String cant; 
	int value_cant;
	if(filterData.get(departamento)==null){
		data = new String[2];
		data[0]=mes;
		data[1]=Integer.toString(1);
		this.view.grafico.agregarInformacion(1,departamento,mes);
		filterData.put(departamento,data);
	}else{
		data = filterData.get(departamento);
		data_mes = data[0];
		cant = data[1];
		value_cant = Integer.parseInt(cant);
		if(data_mes.equals(mes)){
			this.view.grafico.incrementarDato(1,departamento,mes);
			data[1] = Integer.toString(value_cant+1);
		}else{
		    data = new String[2];
		    data[0]=mes;
		    data[1]=Integer.toString(1);
		    this.view.grafico.agregarInformacion(1,departamento,mes);
		    filterData.put(departamento,data);
		}
	}

    }

    public void procesarEmigrantes(Lista<Emigrante> listaEmigrantes){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Calendar cal = Calendar.getInstance();
        String motivoMigracion = comboMotivo.getSelectedItem().toString();
        String ciudadSeleccionada = comboCiudad.getSelectedItem().toString();
	String año = comboYear.getSelectedItem().toString();
        String mes,year,departamento;
        Date fecha;
        for(Emigrante emigrante:listaEmigrantes){
            if(emigrante.getMotivoDeMigracion().equals(motivoMigracion)){
                try {
                    fecha = dateFormat.parse(emigrante.getFecha());
                    cal.setTime(fecha);
                    departamento = emigrante.getDestino();
                    mes = this.obtenerMes(fecha.getMonth());
                    year = Integer.toString(cal.get(Calendar.YEAR));
                    if(year.equals(año)){
                            this.actualizarInformacion(departamento,mes);
                    }
                }catch(ParseException e){
                        e.printStackTrace();
                        System.out.println("Exception"); 
                }
            }
        }
    }

    public void accionGraphicButton(){
        Lista<Emigrante> listaEmigrantes; 
        String ciudadSeleccionada = comboCiudad.getSelectedItem().toString();
	listaEmigrantes = model.getListaGeneral();
	this.view.grafico.dataset.clear();
	if(radioGeneral.isSelected()){
            this.procesarEmigrantes(listaEmigrantes);
	}
        if(radioCiudad.isSelected()){
            listaEmigrantes = this.filtrarPorCiudad(listaEmigrantes,ciudadSeleccionada);
            this.procesarEmigrantes(listaEmigrantes);
        }
        CategoryPlot plot = self.view.grafico.barChart.getCategoryPlot();
        ValueAxis axis = plot.getRangeAxis();
        axis.setStandardTickUnits(NumberAxis.createIntegerTickUnits()); 
        axis.setRange(0,10);
        self.view.grafico.revalidate();
    }

    public Lista<Emigrante> filtrarPorCiudad(Lista<Emigrante> listaEmigrantes, String ciudad){
        Lista<Emigrante> res = new Lista<Emigrante>();
        String destino = "";
        for(Emigrante emigrante:listaEmigrantes){
            destino = emigrante.getDestino();
            if(destino.equals(ciudad)){
                res.insertarAlFinal(emigrante); 
            }
        }
        return res;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
	radioGeneral = self.view.general;
	radioCiudad = self.view.porCiudad;
	comboMotivo = self.view.comboMotivo;
	comboCiudad = self.view.comboCiudad;
	comboYear = self.view.comboYear;
	filterData = new HashMap<String,String[]>();

        if (actionEvent.getActionCommand().equals("graphicButton")) {
		self.accionGraphicButton();
        }
        if (actionEvent.getActionCommand().equals("radioCiudad")) {
            comboCiudad.setEnabled(true);
        }
        if (actionEvent.getActionCommand().equals("radioGeneral")) {
            comboCiudad.setEnabled(false);
        }
    }

    public void setGeneralController(Controlador control){
        this.generalController = control;
        this.model.setControlador(control);
    
    
    }
}
