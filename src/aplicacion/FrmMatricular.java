/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import clases.Administrativo;
import clases.Alumno;
import clases.Beca;
import clases.Carrera; 
import clases.Patrocinador;
import clases.AlumnoAtendido;
import colaDinamica.Cola;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;  
import javax.swing.JOptionPane;  
import stack.Stack;
import utiles.Rut;

/**
 *
 * @author folke
 */
public class FrmMatricular extends javax.swing.JFrame {
    Cola<Alumno> colaespera = new Cola();//alumnos esperando para ser matriculado
    Cola<Alumno> colaesperaaux = new Cola();   
    Cola<Alumno> montobecas = new Cola();//para mostrar el monto de las becas de los alumnosAtendidos que estan registrado como Administrativo(clase no tiene propiedad montobeca)
    Cola<Alumno> montobecasaux = new Cola();
    Cola<Alumno> atendidos = new Cola();//cola para los alumnos matriculados que se usa para mostrar la cantidad de alumnos matriculados con beca
    Cola<Alumno> atendidosaux = new Cola();
    Cola<Carrera> carreras = new Cola();
    Cola<Carrera> carrerasaux = new Cola();
    Cola<Administrativo> admins = new Cola();//cola que se usa para generar admins en el metodo generarAdmins()
    Stack<AlumnoAtendido> alumnosAtendidos = new Stack();
    Stack<AlumnoAtendido> alumnosAtendidosaux = new Stack();
    ArrayList<Administrativo> adminsAtendiendo = new ArrayList();
    /**
     * Creates new form FrmMatricular
     */
    public FrmMatricular() {
        initComponents();  
        this.setSize(925, 1010);
        this.setLocationRelativeTo(null); 
        generarAlumnos("alumnos.txt");
        generarCarreras("carreras.txt");
        imprimirAlumnos();
        llenarComboCarrera();
        this.txtTiempo.setText("30");
        btnActualizar.setVisible(false);
    }
    
    public void generarAlumnos(String archivo){
        try{
            FileReader f = new FileReader(archivo);
            Scanner sc = new Scanner(f);
            String linea;
            
            while(sc.hasNextLine()){
                linea = sc.nextLine();
                Alumno alumno = new Alumno(linea);
                colaespera.add(alumno);
            }
        }
        catch(IOException ex){
            
        }
    }
    
    public void imprimirAlumnos(){
        Alumno a;
        while(!colaespera.isEmpty()){
            a = colaespera.remove();
            this.txtColaEspera.append(a.toString() + "\n");
            colaesperaaux.add(a);
        }
        while(!colaesperaaux.isEmpty()){
            a = colaesperaaux.remove();
            colaespera.add(a);
        }
    }
    
    public void generarCarreras(String archivo){///use a different constructor
        try{
            FileReader f = new FileReader(archivo);
            Scanner sc = new Scanner(f);
            String codigo, nombre, valor, linea;
            
            while(sc.hasNextLine()){
                linea = sc.nextLine();
                String[] datos = linea.split(",");
                codigo = datos[0];
                nombre = datos[1];
                valor = datos[2];
                Carrera carrera = new Carrera(codigo,nombre,valor);
                carreras.add(carrera);
            }
        }
        catch(IOException ex){
            
        }
    }
    
    public void llenarComboCarrera(){
        Carrera c;
        while(!carreras.isEmpty()){
            c = carreras.remove();
            String nombre = c.getNombreCarrera();
            this.cboCarreras.addItem(nombre);
            carrerasaux.add(c);
        }
        while(!carrerasaux.isEmpty()){
            c = carrerasaux.remove();
            carreras.add(c);
        }
    }
    
    public void generarAdmins(){                                
        int tiempo = Integer.parseInt(this.txtTiempo.getText());
        int cantidad = 0;
        Administrativo admin;
        
        while(cantidad < 50){
            admin = new Administrativo(tiempo);
            admins.add(admin);
            cantidad++;
        }
    }
    
    public void vaciarAdmins(){
        Administrativo admin;
        while(!admins.isEmpty()){
            admin = admins.remove();
        }
    }
    
    public void vaciarListaAdmins(){      
        adminsAtendiendo.removeAll(adminsAtendiendo);
    }
    
    public boolean expresionesRegularesAlumnos(){
        boolean valido = false;
        
        Pattern pAlumnos = Pattern.compile("([0-9]+)$");
        Matcher mAlumnos = pAlumnos.matcher(txtNumAlumnos.getText());
        boolean AlumnosValido = mAlumnos.matches();
        
        if (AlumnosValido == false){
            JOptionPane.showMessageDialog(this, "Ingrese un valor");
            txtNumAlumnos.requestFocus();
            valido = false;
        }
        else{
            valido = true;
        }

        return valido;
    }
    
    public boolean expresionesRegularesTiempo(){
        boolean valido = false;
        
        Pattern pTiempo = Pattern.compile("([0-9]+)$");
        Matcher mTiempo = pTiempo.matcher(txtTiempo.getText());
        boolean TiempoValido = mTiempo.matches();
        
        if (TiempoValido == false){
            JOptionPane.showMessageDialog(this, "Ingrese un valor");  
            txtTiempo.requestFocus();
            valido = false;
        }
        else{
            valido = true;
        }

        return valido;
    }
    
    public void grabarCola(String archivo){
        try{
            FileWriter fw = new FileWriter(archivo);
            PrintWriter pw = new PrintWriter(fw);
            String linea;
            Alumno a;
            while(!colaespera.isEmpty()){
                a = colaespera.remove();
                linea = a.toString();
                pw.println(linea);
                //fw.close();
                //pw.close();
            }
            fw.close();
            pw.close();
            
        }
        catch(IOException ex){
            
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAtendidos = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtAdmin = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        txtTiempo = new javax.swing.JTextField();
        btnSimularTiempo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtNumAlumnos = new javax.swing.JTextField();
        btnSimularAlumnos = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtColaEspera = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        cboCarreras = new javax.swing.JComboBox<>();
        txtCAlumnos = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtCAAtendidos = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        txtCBecas = new javax.swing.JTextField();
        btnCalcular = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(204, 204, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MATRICULAR ALUMNOS");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 40));

        txtAtendidos.setColumns(20);
        txtAtendidos.setRows(5);
        jScrollPane1.setViewportView(txtAtendidos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 540, 530, 360));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Cantidad de Administrativos:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));
        jPanel1.add(txtAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 50, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 290, 60));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(txtTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 12, 60, 30));

        btnSimularTiempo.setText("Simular");
        btnSimularTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimularTiempoActionPerformed(evt);
            }
        });
        jPanel2.add(btnSimularTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 290, 60));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Alumnos atendidos");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 510, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Simular atencion segun tiempo disponible");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 290, -1));

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(txtNumAlumnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 60, 30));

        btnSimularAlumnos.setText("Simular");
        btnSimularAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimularAlumnosActionPerformed(evt);
            }
        });
        jPanel3.add(btnSimularAlumnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 290, 60));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Simular atencion segun cantidad de alumnos");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel4.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel4.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, 30));

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel4.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, 30));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 290, 60));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Agregar o eliminar alumnos");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, -1));

        txtColaEspera.setColumns(20);
        txtColaEspera.setRows(5);
        jScrollPane2.setViewportView(txtColaEspera);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 530, 360));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 870, 10));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Alumnos en cola de espera");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, -1, -1));

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cboCarreras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCarrerasActionPerformed(evt);
            }
        });
        jPanel5.add(cboCarreras, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 250, 30));
        jPanel5.add(txtCAlumnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 90, 30));

        jLabel10.setText("Cantidad de alumnos en cola de espera");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));
        jPanel5.add(txtCAAtendidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 90, 30));

        jLabel11.setText("Cantidad de alumnos atendidos");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));
        jPanel5.add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 90, 30));

        jLabel12.setText("Monto total en becas");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, 290, 260));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Consultas por carrera");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Cantidad de alumnos atendidos con becas");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 810, -1, -1));

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCBecas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCBecasActionPerformed(evt);
            }
        });
        jPanel6.add(txtCBecas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 60, 30));

        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });
        jPanel6.add(btnCalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, 30));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 840, 290, 60));

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 920, -1, -1));

        btnGrabar.setText("Grabar cola espera");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGrabar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 920, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimularTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimularTiempoActionPerformed
        // TODO add your handling code here:
        if(expresionesRegularesTiempo()){
            generarAdmins(); 
            int numeroAdmins = Integer.parseInt(this.txtAdmin.getText()); 
            this.txtColaEspera.setText(null);
            this.txtAtendidos.setText(null);
            String nombreCarrera = "", formaPago = "", rut = "";
            Administrativo admin;
            AlumnoAtendido alumnoA;
            Carrera carrera;
            Alumno alumno;
            int tiempoAlumno = 0, tiempoAdmin = 0, contador = 0, monto = 0;
          
            while(contador < numeroAdmins){
                admin = admins.remove();
                adminsAtendiendo.add(admin);
                contador++;
            }
             
            while(!adminsAtendiendo.isEmpty()){
                if(!colaespera.isEmpty()){
                    for(int i = 0; i < adminsAtendiendo.size(); i++){
                        int beca = 0;
                        alumno = colaespera.peek();
                        rut = alumno.getRutAlumno().toString();
                        tiempoAlumno = alumno.getDuracion();
                        formaPago = alumno.getFormaPago().toString(); 
                        
                        if(alumno.getBeca().equals(Beca.Si)){
                            beca = alumno.getMontoBeca();
                        }
                        
                        while(!carreras.isEmpty()){
                            carrera = carreras.remove();
                
                            if(alumno.getCodigoCarrera().equals(carrera.getCodigo())){
                                nombreCarrera = carrera.getNombreCarrera();
                                monto = carrera.getValor();
                            }
                            carrerasaux.add(carrera);
                        }
            
                        while(!carrerasaux.isEmpty()){
                            carrera = carrerasaux.remove();
                            carreras.add(carrera);
                        }  
                        
                        tiempoAdmin = adminsAtendiendo.get(i).getTiempo();
                        if(tiempoAlumno <= tiempoAdmin){
                            alumno = colaespera.remove();  
                            tiempoAdmin = tiempoAdmin - tiempoAlumno;
                            adminsAtendiendo.get(i).setTiempo(tiempoAdmin);
                            alumnoA = new AlumnoAtendido(rut,nombreCarrera,monto - beca,formaPago);
                            alumnosAtendidos.push(alumnoA);
                            atendidos.add(alumno); 
                            montobecas.add(alumno);
                        }
                        else{
                            tiempoAlumno = tiempoAlumno - tiempoAdmin;
                            adminsAtendiendo.remove(i);   
                            alumno.setDuracion(tiempoAlumno);
                        }
                    }
                }
                else{
                    break;
                }
            }
            this.txtAtendidos.append(alumnosAtendidos.toString() + "\n");
            this.txtColaEspera.append(colaespera.toString() + "\n");
            vaciarAdmins();
        }
    }//GEN-LAST:event_btnSimularTiempoActionPerformed

    private void btnSimularAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimularAlumnosActionPerformed
        // TODO add your handling code here:
        if(expresionesRegularesAlumnos()){
            generarAdmins();
            int numAlumnos = Integer.parseInt(this.txtNumAlumnos.getText());
            int numeroAdmins = Integer.parseInt(this.txtAdmin.getText()); 
            this.txtColaEspera.setText(null);
            this.txtAtendidos.setText(null);
            int contador = 0, cAdmins = 0, monto = 0;
            Carrera carrera;
            Alumno alumno;
            Administrativo admin;
            AlumnoAtendido alumnoA;
            String formaPago = "", nombreCarrera = "", rut = ""; 
            
            while(cAdmins < numeroAdmins){
                admin = admins.remove();
                adminsAtendiendo.add(admin);
                cAdmins++;
            }
        
            while(!colaespera.isEmpty() && contador < numAlumnos*numeroAdmins){
                for(int i = 0; i < adminsAtendiendo.size(); i++){
                    if(colaespera.isEmpty() || contador == numAlumnos*numeroAdmins){
                        break;
                    }
                    else{
                        int beca = 0;
                        alumno = colaespera.remove();
                        formaPago = alumno.getFormaPago().toString();
                        rut = alumno.getRutAlumno().toString();
                        
                        if(alumno.getBeca().equals(Beca.Si)){
                            beca = alumno.getMontoBeca();
                        }
               
                        while(!carreras.isEmpty()){
                            carrera = carreras.remove(); 
                
                            if(alumno.getCodigoCarrera().equals(carrera.getCodigo())){
                                nombreCarrera = carrera.getNombreCarrera();
                                monto = carrera.getValor();
                            }
                            carrerasaux.add(carrera);
                        }
            
                        while(!carrerasaux.isEmpty()){
                            carrera = carrerasaux.remove();
                            carreras.add(carrera);
                        }
            
                        alumnoA = new AlumnoAtendido(rut,nombreCarrera,monto - beca,formaPago);
                        alumnosAtendidos.push(alumnoA);
                        atendidos.add(alumno);
                        montobecas.add(alumno);
                        contador++;
                    }
                }
            }
            this.txtAtendidos.append(alumnosAtendidos.toString());  
            this.txtColaEspera.append(colaespera.toString() + "\n");
            vaciarListaAdmins();
        }
    }//GEN-LAST:event_btnSimularAlumnosActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if(colaespera.isEmpty()){
            JOptionPane.showMessageDialog(this, "No hay alumnos en la cola de espera");
        }
        else{
            this.txtColaEspera.setText(null);
            Alumno a;
            while(colaespera.getTamaño() > 1){
                a = colaespera.remove();
                colaesperaaux.add(a);
            }
            a = colaespera.remove();
            while(!colaesperaaux.isEmpty()){   
                a = colaesperaaux.remove();
                colaespera.add(a);
            }
            this.txtColaEspera.append(colaespera.toString() + "\n");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void cboCarrerasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCarrerasActionPerformed
        // TODO add your handling code here:
        String c = this.cboCarreras.getSelectedItem().toString();
        Alumno alumno;
        Carrera carrera;
        AlumnoAtendido alumnoA;
        int espera = 0, atendidos = 0, montobeca = 0;
         
        while(!colaespera.isEmpty()){
            alumno = colaespera.remove();
            
            while(!carreras.isEmpty()){
                carrera = carreras.remove();
                
                if(alumno.getCodigoCarrera().equals(carrera.getCodigo())){
                    if(carrera.getNombreCarrera().equals(c)){
                        espera++;
                        montobeca = montobeca + alumno.getMontoBeca();
                    }
                } 
                carrerasaux.add(carrera);
            }
            
            while(!carrerasaux.isEmpty()){
                carrera = carrerasaux.remove();  
                carreras.add(carrera);   
            }
            colaesperaaux.add(alumno);
        }       
        while(!colaesperaaux.isEmpty()){
            alumno = colaesperaaux.remove();
            colaespera.add(alumno);
        }
        
        
        while(!montobecas.isEmpty()){
            alumno = montobecas.remove();
            
            while(!carreras.isEmpty()){
                carrera = carreras.remove();
                
                if(alumno.getCodigoCarrera().equals(carrera.getCodigo())){
                    if(carrera.getNombreCarrera().equals(c)){
                        montobeca = montobeca + alumno.getMontoBeca();
                    }
                } 
                carrerasaux.add(carrera);
            }  
            
            while(!carrerasaux.isEmpty()){
                carrera = carrerasaux.remove();  
                carreras.add(carrera);   
            }
            montobecasaux.add(alumno);
        }
        while(!montobecasaux.isEmpty()){
            alumno = montobecasaux.remove();
            montobecas.add(alumno);
        }
        
        
        while(!alumnosAtendidos.isEmpty()){
            alumnoA = alumnosAtendidos.pop();
            
            if(alumnoA.getNombreCarrera().equals(c)){
                atendidos++;
            }
            alumnosAtendidosaux.push(alumnoA);
        }        
        while(!alumnosAtendidosaux.isEmpty()){
            alumnoA = alumnosAtendidosaux.pop();
            alumnosAtendidos.push(alumnoA); 
        }      
        
        this.txtCAlumnos.setText(Integer.toString(espera));
        this.txtCAAtendidos.setText(Integer.toString(atendidos));
        this.txtMonto.setText(Integer.toString(montobeca)); 
    }//GEN-LAST:event_cboCarrerasActionPerformed

    private void txtCBecasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCBecasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCBecasActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        // TODO add your handling code here:
        AlumnoAtendido alumnoA;
        Alumno alumno;
        int contador = 0;
        
        while(!alumnosAtendidos.isEmpty()){
            alumnoA = alumnosAtendidos.pop();
            
            while(!atendidos.isEmpty()){
                alumno = atendidos.remove();
                
                if(alumnoA.getRutAlumno().equals(alumno.getRutAlumno())){
                    if(alumno.getBeca().equals(Beca.Si)){
                        contador++;
                    }
                }
                atendidosaux.add(alumno);
            }
            while(!atendidosaux.isEmpty()){
                alumno = atendidosaux.remove();
                atendidos.add(alumno);
            }
            alumnosAtendidosaux.push(alumnoA);
        }
        while(!alumnosAtendidosaux.isEmpty()){
            alumnoA = alumnosAtendidosaux.pop();
            alumnosAtendidos.push(alumnoA);
        }
        
        this.txtCBecas.setText(Integer.toString(contador));
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        FrmRegistrar f = new FrmRegistrar(); 
        f.setVisible(true);
        btnActualizar.setVisible(true);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        this.txtColaEspera.setText(null);
        this.txtColaEspera.append(colaespera.toString());
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        // TODO add your handling code here:
        grabarCola("alumnos.txt");
    }//GEN-LAST:event_btnGrabarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMatricular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMatricular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMatricular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMatricular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMatricular().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnSimularAlumnos;
    private javax.swing.JButton btnSimularTiempo;
    private javax.swing.JComboBox<String> cboCarreras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtAdmin;
    private javax.swing.JTextArea txtAtendidos;
    private javax.swing.JTextField txtCAAtendidos;
    private javax.swing.JTextField txtCAlumnos;
    private javax.swing.JTextField txtCBecas;
    private javax.swing.JTextArea txtColaEspera;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtNumAlumnos;
    private javax.swing.JTextField txtTiempo;
    // End of variables declaration//GEN-END:variables
}
