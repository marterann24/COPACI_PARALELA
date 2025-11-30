package views;

import Model.Usuario;
import cjb.ci.Mensajes;
import copaci_paralela.Mtd;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Timestamp;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import DB.DataBaseConnection;

public class REGISTRO extends javax.swing.JFrame {

    private Usuario user;

    public REGISTRO() {
        LocalDate fecha = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormato = fecha.format(formato);
        initComponents();
        txtfechaAlta.setText(fechaFormato);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        grupoOriginario = new javax.swing.ButtonGroup();
        grupoExtemporaneo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        txtDomicilio = new javax.swing.JTextField();
        boxEstadoCivil = new javax.swing.JComboBox<>();
        txtOcupacion = new javax.swing.JTextField();
        txtGradoEstudios = new javax.swing.JComboBox<>();
        txtfechaAlta = new javax.swing.JTextField();
        txtManzana = new javax.swing.JTextField();
        txtLugarNac = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCertificado = new javax.swing.JTextField();
        btnSi = new javax.swing.JRadioButton();
        btnNo = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnnormal = new javax.swing.JRadioButton();
        btnExtemporaneo = new javax.swing.JRadioButton();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jScrollPane1.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel3.setText("NOMBRE:");

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel4.setText("FECHA DE NACIMIENTO ");

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel5.setText("DOMICILIO ACTUAL:");

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel8.setText("MANZANA:");

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel9.setText("LUGAR DE NACIMIENTO:");

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel11.setText("ORIGINARIO DE ALMAYA:");

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel6.setText("ESTADO CIVIL");

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel7.setText("OCUPACIÓN:");

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel12.setText("GRADO MAXIMO DE ESTUDIOS:");

        jLabel14.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel14.setText("FECHA EN LA QUE SE DIO DE ALTA:");

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel10.setText("TELEFONO:");

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel13.setText("CERTIFICADO DE COMUNERO No. :");

        btnAceptar.setText("ACEPTAR");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnRegresar.setText("REGRESAR");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        boxEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SOLTERO", "CASADO", "DIVORCIADO" }));

        txtGradoEstudios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NINGUNO", "PREESCOLAR", "PRIMARIA", "SECUNDARIA", "PREPARATORIA", "UNIVERSIDAD", "MAESTRIA", "DOCTORADO" }));

        txtfechaAlta.setEditable(false);

        grupoOriginario.add(btnSi);
        btnSi.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnSi.setText("SI");

        grupoOriginario.add(btnNo);
        btnNo.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnNo.setText("NO");
        btnNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(102, 255, 102));

        jLabel16.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel16.setText("REGISTRO DE EXPEDIENTE");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/imagenes/FONDO1_1.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(162, Short.MAX_VALUE))
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16)
                                .addContainerGap())
        );

        grupoExtemporaneo.add(btnnormal);
        btnnormal.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnnormal.setText("NORMAL");

        grupoExtemporaneo.add(btnExtemporaneo);
        btnExtemporaneo.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnExtemporaneo.setText("EXTEMPORANEO");
        btnExtemporaneo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExtemporaneoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING))
                                                                .addGap(65, 65, 65))
                                                        .addComponent(jLabel4)
                                                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(boxEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel14)
                                                        .addComponent(txtfechaAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(btnnormal)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(btnExtemporaneo)))
                                                .addGap(44, 44, 44)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(6, 6, 6)
                                                                .addComponent(btnNo)
                                                                .addGap(35, 35, 35)
                                                                .addComponent(btnSi))
                                                        .addComponent(txtManzana, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel8)
                                                        .addComponent(jLabel9)
                                                        .addComponent(txtLugarNac, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel11)
                                                        .addComponent(jLabel10)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(33, 33, 33)
                                                                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(txtCertificado, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(jLabel13)
                                                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addComponent(txtGradoEstudios, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtManzana, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel9))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel5)
                                                .addGap(14, 14, 14)
                                                .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel6)
                                                .addGap(12, 12, 12)
                                                .addComponent(boxEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtCertificado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel12))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(txtLugarNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnNo)
                                                        .addComponent(btnSi))
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel10)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGradoEstudios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(jLabel14)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtfechaAlta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnnormal)
                                        .addComponent(btnExtemporaneo))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExtemporaneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExtemporaneoActionPerformed
        // nada especial por ahora
    }//GEN-LAST:event_btnExtemporaneoActionPerformed

    private void btnNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoActionPerformed
        // nada especial por ahora
    }//GEN-LAST:event_btnNoActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // 1) Validar datos
        if (!validarFormulario()) {
            return;
        }

        // 2) Calcular deudas si es extemporáneo (solo mostrar, no guardar aún)
        double deudaCoop = 0;
        double deudaFaen = 0;
        if (btnExtemporaneo.isSelected()) {
            long meses = Mtd.calcularMesesDesdeMayoriaEdad(txtFecha.getText());
            if (meses <= 0) {
                Mensajes.error(this, "No debe nada");
            } else {
                deudaFaen = 200 * meses;
                double anio = meses / 12.0;
                deudaCoop = 1800 * anio;
                Mensajes.error(this,
                        "Deuda en faena: $" + deudaFaen + "\nDeuda en cooperaciones: $" + deudaCoop);
            }
        }

        // 3) Construir el objeto Usuario
        Usuario usuario;
        try {
            usuario = crearUsuario();
        } catch (DateTimeParseException ex) {
            Mensajes.error(this, "Error al convertir fechas: " + ex.getMessage());
            return;
        }

        // 4) Deshabilitar botón para evitar doble clic
        btnAceptar.setEnabled(false);

        // 5) Crear HILO para guardar en la base de datos
        new Thread(() -> {
            int idGenerado = createUsuario(usuario);  // ahora regresa el id

            // Volver al hilo de Swing para actualizar la UI
            SwingUtilities.invokeLater(() -> {
                btnAceptar.setEnabled(true);

                if (idGenerado > 0) {
                    String folioFormateado = String.format("%05d", idGenerado);

                    JOptionPane.showMessageDialog(
                            this,
                            "Usuario registrado correctamente.\nFolio: " + folioFormateado,
                            "Registro exitoso",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    limpiarFormulario();
                } else {
                    Mensajes.error(this, "No se pudo registrar el usuario en la base de datos");
                }

            });
        }).start();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        new Dashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    // ========= MÉTODOS EXTRA ===========

    private boolean validarFormulario() {
        if (txtNombre.getText().trim().isEmpty()) {
            Mensajes.error(this, "Ingrese nombre");
            return false;
        }
        if (txtManzana.getText().trim().isEmpty()) {
            Mensajes.error(this, "Ingrese una manzana");
            return false;
        }
        if (txtCertificado.getText().trim().isEmpty()) {
            Mensajes.error(this, "Ingrese un certificado");
            return false;
        }
        if (txtDomicilio.getText().trim().isEmpty()) {
            Mensajes.error(this, "Ingrese domicilio");
            return false;
        }
        if (txtFecha.getText().trim().isEmpty()) {
            Mensajes.error(this, "Ingrese fecha de nacimiento");
            return false;
        }
        if (txtLugarNac.getText().trim().isEmpty()) {
            Mensajes.error(this, "Ingrese lugar de nacimiento");
            return false;
        }
        if (txtOcupacion.getText().trim().isEmpty()) {
            Mensajes.error(this, "Ingrese ocupación");
            return false;
        }
        if (txtTelefono.getText().trim().isEmpty()) {
            Mensajes.error(this, "Ingrese teléfono");
            return false;
        }
        if (txtfechaAlta.getText().trim().isEmpty()) {
            Mensajes.error(this, "Ingrese la fecha de alta");
            return false;
        }
        if (grupoExtemporaneo.getSelection() == null) {
            Mensajes.error(this, "Elija si es extemporáneo");
            return false;
        }
        if (grupoOriginario.getSelection() == null) {
            Mensajes.error(this, "Elija si es originario");
            return false;
        }

        // Validar formato de fechas
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate.parse(txtFecha.getText().trim(), formatter);
        } catch (DateTimeParseException e) {
            Mensajes.error(this, "La fecha de nacimiento no tiene el formato dd/MM/yyyy");
            return false;
        }

        try {
            LocalDate.parse(txtfechaAlta.getText().trim(), formatter);
        } catch (DateTimeParseException e) {
            Mensajes.error(this, "La fecha de alta no tiene el formato dd/MM/yyyy");
            return false;
        }

        return true;
    }

    private Usuario crearUsuario() {
        Usuario u = new Usuario();

        // Usamos el certificado que capturas
        String certificado = txtCertificado.getText().trim();
        u.setCertificado(certificado);

        u.setNombre(txtNombre.getText().trim());
        u.setManzana(txtManzana.getText().trim());
        u.setLugarNacimiento(txtLugarNac.getText().trim());
        u.setDomicilio(txtDomicilio.getText().trim());
        u.setOcupacion(txtOcupacion.getText().trim());
        u.setTelefono(txtTelefono.getText().trim());
        u.setMaxEstudios(txtGradoEstudios.getSelectedItem().toString());

        // Estado civil: primer carácter de SOLTERO, CASADO, DIVORCIADO (S, C, D)
        String estadoCivilStr = boxEstadoCivil.getSelectedItem().toString();
        u.setEstadoCivil(estadoCivilStr.charAt(0));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Fecha de nacimiento
        String fechaNacStr = txtFecha.getText().trim();
        if (!fechaNacStr.isEmpty()) {
            u.setFechaNacimiento(LocalDate.parse(fechaNacStr, formatter));
        }

        // Fecha de alta
        String fechaAltaStr = txtfechaAlta.getText().trim();
        if (!fechaAltaStr.isEmpty()) {
            u.setFechaAlta(LocalDate.parse(fechaAltaStr, formatter));
        }

        // Originario
        boolean esOriginario = btnSi.isSelected(); // SI = true, NO = false
        u.setEsOriginario(esOriginario);

        // Extemporáneo
        boolean esExtemporaneo = btnExtemporaneo.isSelected();
        u.setEsExtemporaneo(esExtemporaneo);

        // Fecha de registro: ahora
        u.setFechaRegistro(LocalDateTime.now());

        // Activo
        u.setActivo(true);

        return u;
    }

    // Inserta y regresa el ID generado (folio)
    private int createUsuario(Usuario usuario) {
        String sql = """
        INSERT INTO usuarios (
            nombre,
            manzana,
            fecha_nacimiento,
            lugar_nacimiento,
            domicilio,
            estado_civil,
            ocupacion,
            telefono,
            max_estudios,
            certificado,
            fecha_alta,
            es_extemporaneo,
            es_originario,
            fecha_registro,
            activo
        ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        RETURNING id
        """;

        try (Connection conexion = new DataBaseConnection().getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            int i = 1;

            pstmt.setString(i++, usuario.getNombre());
            pstmt.setString(i++, usuario.getManzana());

            if (usuario.getFechaNacimiento() != null) {
                pstmt.setDate(i++, Date.valueOf(usuario.getFechaNacimiento()));
            } else {
                pstmt.setNull(i++, java.sql.Types.DATE);
            }

            pstmt.setString(i++, usuario.getLugarNacimiento());
            pstmt.setString(i++, usuario.getDomicilio());
            pstmt.setString(i++, String.valueOf(usuario.getEstadoCivil()));
            pstmt.setString(i++, usuario.getOcupacion());
            pstmt.setString(i++, usuario.getTelefono());
            pstmt.setString(i++, usuario.getMaxEstudios());
            pstmt.setString(i++, usuario.getCertificado());

            if (usuario.getFechaAlta() != null) {
                pstmt.setDate(i++, Date.valueOf(usuario.getFechaAlta()));
            } else {
                pstmt.setNull(i++, java.sql.Types.DATE);
            }

            pstmt.setBoolean(i++, usuario.isEsExtemporaneo());
            pstmt.setBoolean(i++, usuario.isEsOriginario());

            LocalDateTime fechaRegistro = usuario.getFechaRegistro() != null
                    ? usuario.getFechaRegistro()
                    : LocalDateTime.now();
            pstmt.setTimestamp(i++, Timestamp.valueOf(fechaRegistro));

            pstmt.setBoolean(i++, usuario.isActivo());

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                } else {
                    return -1;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            Mensajes.error(this, "Error al registrar el usuario: " + e.getMessage());
            return -1;
        }
    }

    private void limpiarFormulario() {
        txtNombre.setText("");
        txtManzana.setText("");
        txtFecha.setText("");
        txtLugarNac.setText("");
        txtDomicilio.setText("");
        boxEstadoCivil.setSelectedIndex(0);
        txtOcupacion.setText("");
        txtTelefono.setText("");
        txtCertificado.setText("");
        txtGradoEstudios.setSelectedIndex(0);
        grupoOriginario.clearSelection();
        grupoExtemporaneo.clearSelection();

        LocalDate fecha = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        txtfechaAlta.setText(fecha.format(formato));
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(REGISTRO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(REGISTRO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(REGISTRO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(REGISTRO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new REGISTRO().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxEstadoCivil;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JRadioButton btnExtemporaneo;
    private javax.swing.JRadioButton btnNo;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JRadioButton btnSi;
    private javax.swing.JRadioButton btnnormal;
    private javax.swing.ButtonGroup grupoExtemporaneo;
    private javax.swing.ButtonGroup grupoOriginario;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCertificado;
    private javax.swing.JTextField txtDomicilio;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JComboBox<String> txtGradoEstudios;
    private javax.swing.JTextField txtLugarNac;
    private javax.swing.JTextField txtManzana;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtOcupacion;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtfechaAlta;
    // End of variables declaration//GEN-END:variables
}
