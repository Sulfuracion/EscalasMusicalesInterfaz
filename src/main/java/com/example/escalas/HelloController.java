package com.example.escalas;

import javafx.util.StringConverter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private ToggleGroup AlteracionesGrupo;

    @FXML
    public Spinner<Integer> OctavaSeleccion;
    SpinnerValueFactory<Integer> svf= new SpinnerValueFactory.IntegerSpinnerValueFactory(1,4,1);//esto hace que vaya del 1 al 10 y que de saltos de 1 en 1


    @FXML
    private TextField mostrar;


    @FXML
    private Slider notaSlider;

    @FXML
    private RadioButton bemolBoton;

    @FXML
    private RadioButton nomalBoton;

    @FXML
    private RadioButton sostenidoBoton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {//se usa para dar valores predefinidos
        OctavaSeleccion.setValueFactory(svf);
        //controlSlider();
        //seleccionar();


        notaSlider.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double n) {
                switch (n.intValue()) {
                    case 1:
                        return "Do";
                    case 2:
                        return "Re";
                    case 3:
                        return "Mi";
                    case 4:
                        return "Fa";
                    case 5:
                        return "Sol";
                    case 6:
                        return "La";
                    case 7:
                        return "Si";
                    default:
                        return "Do";

                }
            }

            @Override
            public Double fromString(String s) {
                switch (s) {
                    case "ene":
                        return 0d;
                    case "feb":
                        return 1d;
                    case "mar":
                        return 2d;
                    case "abr":
                        return 3d;
                    case "may":
                        return 4d;
                    case "jun":
                        return 5d;
                    case "jul":
                        return 6d;
                    default:
                        return 0d;
                }
            }
        });


    }

    public String controlSlider(){//redondear el slider
     int valor= (int)notaSlider.getValue();

        switch (valor) {
            case 1:
                sostenidoBoton.setDisable(false);
                bemolBoton.setDisable(false);
                return "Do";//bemolBoton
            case 2:
                sostenidoBoton.setDisable(false);
                bemolBoton.setDisable(false);
                return "Re";//bemolBoton
            case 3:

                sostenidoBoton.setDisable(true);
                bemolBoton.setDisable(false);
                sostenidoBoton.setSelected(false);
                return "Mi";//bemolBoton
            case 4:
                sostenidoBoton.setDisable(false);
                bemolBoton.setDisable(false);
                return "Fa";//bemolBoton
            case 5:
                sostenidoBoton.setDisable(false);
                bemolBoton.setDisable(true);
                bemolBoton.setSelected(false);
                return "Sol";
            case 6:
                sostenidoBoton.setDisable(true);
                bemolBoton.setDisable(false);
                sostenidoBoton.setSelected(false);
                return "La";//bemolBoton
            case 7:
                sostenidoBoton.setDisable(true);
                bemolBoton.setDisable(false);
                sostenidoBoton.setSelected(false);
                return "Si";//bemolBoton
            default:
                return "7";

        }
    }


    public void  seleccionar(){
        mostrar.setText("La nota escogida es " + controlSlider() + " en la " + octabaselect()+ " " + radioBottonSeleccionado());
    }

    public String radioBottonSeleccionado(){
        String select=" no hay selección";
        if (bemolBoton.isSelected()){
            select= " bemol";
            return select;
        }
        if (nomalBoton.isSelected()){
            select= " normal";
            return select;
        }
        if (sostenidoBoton.isSelected()){
            select= " sostenido";
            return select;
        }

        return select;
    }


    public String octabaselect(){
        int select =OctavaSeleccion.getValue();
        switch (select){
            case 1:
                return " primera ";
            case 2:
                return " segunda ";

            case 3:
                return " tercera ";
            case 4:
                return " cuarta ";
            default:
                return "para metro no valido";
        }

    }



}
