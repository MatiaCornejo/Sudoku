/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;


import java.awt.Dimension;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;


/**
 *
 * @author mataya
 */
public class vistaSudoku extends javax.swing.JFrame {
    public JTextField arreglo[][]=new JTextField[9][9];

  
   
    public  vistaSudoku(ActionListener al) {
        initComponents();
        setActionListener(al);
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/iconoSudoku.png")).getImage());  
        añadirTextField();
        
    }

    private void setActionListener(ActionListener al){
        this.jBIniciar.addActionListener(al);
        this.jBSolución.addActionListener(al);
        this.jBVolver.addActionListener(al);
        this.jBRevisar.addActionListener(al);
        

    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        fondoPlantilla = new javax.swing.JLabel();
        jBRevisar = new javax.swing.JButton();
        jBIniciar = new javax.swing.JButton();
        jBVolver = new javax.swing.JButton();
        jBSolución = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sudoku");
        setFocusable(false);
        setMinimumSize(new java.awt.Dimension(980, 550));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/quest.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, 230, 150));

        fondoPlantilla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/plantilla.gif"))); // NOI18N
        getContentPane().add(fondoPlantilla, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 56, -1, 440));

        jBRevisar.setText("Revisar");
        getContentPane().add(jBRevisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 430, -1, -1));

        jBIniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inicio.png"))); // NOI18N
        jBIniciar.setText("Iniciar");
        jBIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBIniciarActionPerformed(evt);
            }
        });
        getContentPane().add(jBIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, -1, -1));

        jBVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/volver.png"))); // NOI18N
        jBVolver.setText("Volver");
        getContentPane().add(jBVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 460, -1, -1));

        jBSolución.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/solucion.png"))); // NOI18N
        jBSolución.setText("Solución");
        jBSolución.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSoluciónActionPerformed(evt);
            }
        });
        getContentPane().add(jBSolución, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 380, 130, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 550));
        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 450, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void finalizarJuego(){
        Icon triste=new ImageIcon(getClass().getResource("/Imagenes/triste.png"));
        JOptionPane.showMessageDialog(rootPane,"Has visto la solución...","¡Traidor!",JOptionPane.INFORMATION_MESSAGE,triste);   
    }
    public void ganarJuego(){
        Icon iconoTriunfo=new ImageIcon(getClass().getResource("/Imagenes/triunfo.png"));
        JOptionPane.showMessageDialog(rootPane,"¡Lo Has Logrado!","¡Felicidades!",JOptionPane.INFORMATION_MESSAGE,iconoTriunfo);
        
    }    
       
    private void jBIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBIniciarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBIniciarActionPerformed

    private void jBSoluciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSoluciónActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBSoluciónActionPerformed


//###########################GET DE LOS BOTONES#################################
    public JButton getjBIniciar() {
        return jBIniciar;
    }

    public JButton getjBSolución() {
        return jBSolución;
    }

    public JButton getjBVolver() {
        return jBVolver;
    }

   public JButton getjBRevisar(){
       return jBRevisar;
   }

    public void añadirTextField(){
    //Se cambia de cadena de caracteres a numeros
        int filas = 9;
        int columnas = 9;
        //Se crea una matriz de botones segun las filas y columnas entrantes
        
        //Se recorren las filas
        for( int fila = 0 ; fila <filas; fila++ )
        {
            //Estando en la fila se recorrer las columnas
            for( int columna = 0 ; columna <columnas; columna++ )
            {
                arreglo[fila][columna]= new JTextField();
                arreglo[fila][columna].setPreferredSize(new Dimension(43,43));
                arreglo[fila][columna].setFont(new java.awt.Font("Dialog", 1, 24));
                panel.add(arreglo[fila][columna]);
            }
        }   
		panel.updateUI();
	}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondoPlantilla;
    private javax.swing.JButton jBIniciar;
    private javax.swing.JButton jBRevisar;
    private javax.swing.JButton jBSolución;
    private javax.swing.JButton jBVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables


      
}
