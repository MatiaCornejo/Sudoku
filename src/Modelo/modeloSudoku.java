package Modelo;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author mataya
 */
public class modeloSudoku {
    private static  final Random funcionAleatoria=new Random();
    private static final  int numeroSudoku=funcionAleatoria.nextInt(4);
    private static final int filas=9;
    private static  final int columnas=9;
    public  ArrayList<ArrayList> tablero=new ArrayList();
    public  ArrayList<ArrayList>solucion=new ArrayList();
    private static final ArrayList<String> tableros=new ArrayList();
    private static final ArrayList<String> soluciones=new ArrayList();
public  modeloSudoku()
{
    //DESAFIOS
    tableros.add("000385000039000800400000020000000006000076900000100074004000300080009000060007000");
    tableros.add("000000100960000040003000060000400005000080004290030007005020080000700900000306000");
    tableros.add("000010000000030000000608000003000600250000083004000700000902000000040000000050000");
    tableros.add("300010005000008000000004000064000000200040006000000170000900000000200000500060003"); 
    //SOLUCIONES
    soluciones.add("627385491139724865458961723712498536345276918896153274574612389281539647963847152");
    soluciones.add("458963172967512348123874569876491235531287694294635817645129783312748956789356421");
    soluciones.add("548719236629534817137628459793185642256497183814263795485972361971346528362851974");
    soluciones.add("389712645647598312152634789764159238231847596895326174423975861916283457578461923");
    
}
public  ArrayList crearTablero()        
{   
    String sudoku=tableros.get(numeroSudoku);
    ArrayList filaActual=new ArrayList();
    for(int i=0;i<81;i++)
    {
        String caracter=(new StringBuffer().append(sudoku.charAt(i))).toString();
        filaActual.add(caracter);
        if(filaActual.size()==9)
       {
           tablero.add(filaActual);
           filaActual=new ArrayList();
       }
    }
    return tablero;
}
public  ArrayList crearSolucion()
{   
    String sudoku=soluciones.get(numeroSudoku);
    ArrayList filaActual=new ArrayList();
    for(int i=0;i<columnas*filas;i++)
    {
        String caracter=(new StringBuffer().append(sudoku.charAt(i))).toString();
        filaActual.add(caracter);
        if(filaActual.size()==9)
       {
           solucion.add(filaActual);
           filaActual=new ArrayList();
       }
    }
    return solucion;
}
public static int contarRepeticiones(String  string, ArrayList<String> array)
{  int i=0, cont = 0;
   while(i < array.size())
   {
     if(array.get(i).equals(string)){
        cont++;
        }
     i++;
   }
   return cont;
}


}


 
