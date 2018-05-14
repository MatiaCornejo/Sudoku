package Controlador;
import Modelo.modeloSudoku;
import Vista.vistaSudoku;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 *
 * @author mataya
 */
public  class controladorSudoku implements ActionListener 
{  
    private static vistaSudoku vistaSudoku;
    private static  final  modeloSudoku sudoku=new modeloSudoku();
    private static final ArrayList<ArrayList> desafioSudoku=sudoku.crearTablero();
    private static final  ArrayList<ArrayList> solucionSudoku=sudoku.crearSolucion();
    private static ArrayList<ArrayList> tableroJugadorFilas;
    private static ArrayList<ArrayList> tableroJugadorColumnas;
    private static ArrayList<ArrayList> tableroJugadorCuadrantes;
    private static  ArrayList<String> filas;
    private static  ArrayList<String> columnas;
    private static  ArrayList<String> cuadrantes;
    private static boolean error=true;
    private static boolean errorC=true;
    
    
    
       
public controladorSudoku(){
    vistaSudoku = new vistaSudoku(this);
    vistaSudoku.setVisible(true);
    vistaSudoku.setLocationRelativeTo(null);
}

    @Override
public  void actionPerformed(ActionEvent ae) {
    if(vistaSudoku.getjBIniciar()==ae.getSource()){
        mostrarAlJugador(desafioSudoku);
        vistaSudoku.getjBIniciar().setEnabled(false);
    }
    if(vistaSudoku.getjBSolución()==ae.getSource()){
        mostrarAlJugador(solucionSudoku);
        vistaSudoku.finalizarJuego();
        vistaSudoku.dispose();;
    }
    if(vistaSudoku.getjBVolver()== ae.getSource()){
        System.out.println("volver al Menu");
        vistaSudoku.dispose();

    }
    if(vistaSudoku.getjBRevisar()==ae.getSource()){
        revisar(); 
        
    }
}

private void mostrarAlJugador(ArrayList tablero){
    for (int i = 0; i <9; i++) {
        ArrayList filaActual=(ArrayList) tablero.get(i);
        for (int j = 0; j <9; j++) {
            String valor=(String) filaActual.get(j);
            if (valor.equals("0")) {
                vistaSudoku.arreglo[i][j].setText("");
                
            }
            else{
                vistaSudoku.arreglo[i][j].setText(valor);
                vistaSudoku.arreglo[i][j].setBackground(Color.green);
                vistaSudoku.arreglo[i][j].setEnabled(false);
                vistaSudoku.arreglo[i][j].setDisabledTextColor(Color.blue);
                
                
            }
        }
    }
}
private void extraerDatosFilas(){
    tableroJugadorFilas=new ArrayList();
    filas=new ArrayList();
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            if (vistaSudoku.arreglo[i][j].getText().equals("")) {
                filas.add("0");
            }
            else {
                filas.add(vistaSudoku.arreglo[i][j].getText()); 
            }
        }
        tableroJugadorFilas.add(filas);
        filas=new ArrayList();
    }
}

private void revisarFilas(){
    extraerDatosFilas();
    for (int i = 0; i <9; i++) {
        ArrayList<String> filaActual=(ArrayList)tableroJugadorFilas.get(i);
        for (int j = 0; j <9; j++) {
            if(!"0".equals(filaActual.get(j))){
            int valorRepeticion=modeloSudoku.contarRepeticiones(filaActual.get(j),filaActual);
                if(valorRepeticion>=2){
                    for (int k = 0; k < 9; k++) {
                        vistaSudoku.arreglo[i][k].setBackground(Color.RED);
                        error=true;
                    }
                    break;
                }
                
            }
        } 
    } 
}

private void extraerDatosColumnas(){
    tableroJugadorColumnas=new ArrayList();
    columnas=new ArrayList();
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            if (vistaSudoku.arreglo[j][i].getText().equals("")) {
                columnas.add("0");
            }
            else {
                columnas.add(vistaSudoku.arreglo[j][i].getText()); 
                
            }
        }
        tableroJugadorColumnas.add(columnas);
        columnas=new ArrayList();
    }
}

private void revisarColumnas(){
    extraerDatosColumnas();
    for (int i = 0; i <9; i++) {
        ArrayList<String> filaActual=(ArrayList)tableroJugadorColumnas.get(i);
        for (int j = 0; j <9; j++) {
            if(!"0".equals(filaActual.get(j))){
            int valorRepeticion=modeloSudoku.contarRepeticiones(filaActual.get(j),filaActual);
                if(valorRepeticion>=2){
                    for (int k = 0; k < 9; k++) {
                        vistaSudoku.arreglo[k][i].setBackground(Color.RED);
                        error=true;
                    }
                    break;
                }
                else{
                    for (int k = 0; k < 9; k++) {
                        vistaSudoku.arreglo[k][i].setBackground(Color.green);
                        error=false;
                    }
                }
            }
        } 
    } 
}
private void extraerDatosCuadrantes(){
    tableroJugadorCuadrantes=new ArrayList();
    cuadrantes=new ArrayList();
    for (int i = 0; i < 3; i++) {
        for (int c=0; c < 3; c++) {
            if (vistaSudoku.arreglo[i][c].getText().equals("")) {
                cuadrantes.add("0");
            }
            else {
                cuadrantes.add(vistaSudoku.arreglo[i][c].getText());}
            
        }
    }
    tableroJugadorCuadrantes.add(cuadrantes);
    cuadrantes=new ArrayList();
    for (int i = 0; i < 3; i++) {
        for (int c=3; c < 6; c++) {
            if (vistaSudoku.arreglo[i][c].getText().equals("")) {
                cuadrantes.add("0");
            }
            else {
                cuadrantes.add(vistaSudoku.arreglo[i][c].getText());}
            
        }
    }
    tableroJugadorCuadrantes.add(cuadrantes);
    cuadrantes=new ArrayList();
    for (int i = 0; i < 3; i++) {
        for (int c=6; c < 9; c++) {
            if (vistaSudoku.arreglo[i][c].getText().equals("")) {
                cuadrantes.add("0");
            }
            else {
                cuadrantes.add(vistaSudoku.arreglo[i][c].getText());}
            
        }
    }
    tableroJugadorCuadrantes.add(cuadrantes);
    cuadrantes=new ArrayList();
    for (int i = 3; i < 6; i++) {
        for (int c=0; c < 3; c++) {
            if (vistaSudoku.arreglo[i][c].getText().equals("")) {
                cuadrantes.add("0");
            }
            else {
                cuadrantes.add(vistaSudoku.arreglo[i][c].getText());}
            
        }
    }
    tableroJugadorCuadrantes.add(cuadrantes);
    cuadrantes=new ArrayList();
    for (int i = 3; i < 6; i++) {
        for (int c=3; c < 6; c++) {
            if (vistaSudoku.arreglo[i][c].getText().equals("")) {
                cuadrantes.add("0");
            }
            else {
                cuadrantes.add(vistaSudoku.arreglo[i][c].getText());}
            
        }
    }
    tableroJugadorCuadrantes.add(cuadrantes);
    cuadrantes=new ArrayList();
    for (int i = 3; i < 6; i++) {
        for (int c=6; c < 9; c++) {
            if (vistaSudoku.arreglo[i][c].getText().equals("")) {
                cuadrantes.add("0");
            }
            else {
                cuadrantes.add(vistaSudoku.arreglo[i][c].getText());}
            
        }
    }
    tableroJugadorCuadrantes.add(cuadrantes);
    cuadrantes=new ArrayList();
    for (int i = 6; i < 9; i++) {
        for (int c=0; c < 3; c++) {
            if (vistaSudoku.arreglo[i][c].getText().equals("")) {
                cuadrantes.add("0");
            }
            else {
                cuadrantes.add(vistaSudoku.arreglo[i][c].getText());}
            
        }
    }
    tableroJugadorCuadrantes.add(cuadrantes);
    cuadrantes=new ArrayList();
    for (int i = 6; i < 9; i++) {
        for (int c=3; c < 6; c++) {
            if (vistaSudoku.arreglo[i][c].getText().equals("")) {
                cuadrantes.add("0");
            }
            else {
                cuadrantes.add(vistaSudoku.arreglo[i][c].getText());}
            
        }
    }
    tableroJugadorCuadrantes.add(cuadrantes);
    cuadrantes=new ArrayList();
    for (int i = 6; i < 9; i++) {
        for (int c=6; c < 9; c++) {
            if (vistaSudoku.arreglo[i][c].getText().equals("")) {
                cuadrantes.add("0");
            }
            else {
                cuadrantes.add(vistaSudoku.arreglo[i][c].getText());}
            
        }
    }
    tableroJugadorCuadrantes.add(cuadrantes);
    cuadrantes=new ArrayList();
}

private void revisarCuadrantes(){
    extraerDatosCuadrantes();
    for (int i = 0; i <9; i++) {
        ArrayList<String> filaActual=(ArrayList)tableroJugadorCuadrantes.get(i);
        for (int j = 0; j <9; j++) {
            if(!"0".equals(filaActual.get(j))){
            int valorRepeticion=modeloSudoku.contarRepeticiones(filaActual.get(j),filaActual);
                if(valorRepeticion>=2){
                    if(i==0){
                        for (int k = 0; k < 3; k++) {
                                for (int c=0; c < 3; c++) {
                                    vistaSudoku.arreglo[k][c].setBackground(Color.RED);
                                    error=true;
                                }
                        }
                    }
                    if(i==1){
                        for (int k = 0; k < 3; k++) {
                                for (int c=3; c < 6; c++) {
                                    vistaSudoku.arreglo[k][c].setBackground(Color.RED);
                                    error=true;
                                }
                        }
                    }
                    if(i==2){
                        for (int k = 0; k < 3; k++) {
                                for (int c=6; c < 9; c++) {
                                    vistaSudoku.arreglo[k][c].setBackground(Color.RED);
                                    error=true;
                                }
                        }
                    }
                    if(i==3){
                        for (int k = 3; k < 6; k++) {
                                for (int c=0; c < 3; c++) {
                                    vistaSudoku.arreglo[k][c].setBackground(Color.RED);
                                    error=true;
                                }
                        }
                    }
                    if(i==4){
                        for (int k = 3; k < 6; k++) {
                                for (int c=3; c < 6; c++) {
                                    vistaSudoku.arreglo[k][c].setBackground(Color.RED);
                                    error=true;
                                }
                        }
                    }
                    if(i==5){
                        for (int k = 3; k < 6; k++) {
                                for (int c=6; c < 9; c++) {
                                    vistaSudoku.arreglo[k][c].setBackground(Color.RED);
                                    error=true;
                                }
                        }
                    }
                    if(i==6){
                        for (int k = 6; k < 9; k++) {
                                for (int c=0; c < 3; c++) {
                                    vistaSudoku.arreglo[k][c].setBackground(Color.RED);
                                    error=true;
                                }
                        }
                    }
                    if(i==7){
                        for (int k = 6; k < 9; k++) {
                                for (int c=3; c < 6; c++) {
                                    vistaSudoku.arreglo[k][c].setBackground(Color.RED);
                                    error=true;
                                }
                        }
                    }
                     if(i==8){
                        for (int k = 6; k < 9; k++) {
                                for (int c=6; c < 9; c++) {
                                    vistaSudoku.arreglo[k][c].setBackground(Color.RED);
                                    error=true;
                                }
                        }
                    }
                    break;
                }
                
            }
        } 
    } 
}
private void revisar(){
    revisarColumnas();
    revisarFilas();
    revisarCuadrantes();
    verificarTriunfo();
}
public void verificarTriunfo(){
    for (int i = 0; i < 9; i++) {
        ArrayList<String> filaActual=tableroJugadorFilas.get(i);
        for (int j = 0; j < 9; j++) {
            if (filaActual.get(j).equals("0")==false) {
                errorC=false;
            }
            else{
                errorC=true;
                break;
            }
        } 
    }
if(error==false && errorC==false){
    vistaSudoku.ganarJuego();
        vistaSudoku.dispose();

}
}

}




