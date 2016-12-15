
import ejb.FancyRegServiceRemote;
import entities.Course;
import entities.Registration;
import entities.Student;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class FancyRegClient extends javax.swing.JFrame {
    
    FancyRegServiceRemote fancyRegService;
    DefaultListModel<Student> studentsModel;
    DefaultListModel<Course> coursesModel;
    DefaultListModel<Registration> registrationsModel;

    public FancyRegClient() {
         try {
            Properties props = new Properties();
            props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
            InitialContext ctx = new InitialContext(props);
            fancyRegService = (FancyRegServiceRemote) ctx.lookup(FancyRegServiceRemote.class.getName());            
            studentsModel = new DefaultListModel<Student>();
            coursesModel = new DefaultListModel<Course>();
            registrationsModel = new DefaultListModel<Registration>();
            initComponents();
            refreshStudents();
            refreshCourses();
            refreshRegistrations();
                    
        } catch (NamingException ex) {
            JOptionPane.showMessageDialog(null, "Error connectiong to Glassfish");
            throw new RuntimeException("Error connecting to Glassfish", ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        btStudentAdd = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tfCourse = new javax.swing.JTextField();
        btCourseAdd = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlstudentList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlcourseList = new javax.swing.JList<>();
        btRegister = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListRegistrations = new javax.swing.JList<>();
        btUnregister = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Name:");

        btStudentAdd.setText("Add");
        btStudentAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btStudentAddActionPerformed(evt);
            }
        });

        jLabel2.setText("Course:");

        btCourseAdd.setText("Add");
        btCourseAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCourseAddActionPerformed(evt);
            }
        });

        jLabel3.setText("Students:");

        jlstudentList.setModel(studentsModel);
        jlstudentList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jlstudentList);

        jlcourseList.setModel(coursesModel);
        jlcourseList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jlcourseList);

        btRegister.setText("Register");
        btRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegisterActionPerformed(evt);
            }
        });

        jLabel4.setText("Courses:");

        jLabel5.setText("Registrations:");

        jListRegistrations.setModel(registrationsModel);
        jListRegistrations.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(jListRegistrations);

        btUnregister.setText("Unregister");
        btUnregister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUnregisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(426, 426, 426))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfName))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btStudentAdd)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                                        .addComponent(jLabel2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane3)
                                    .addComponent(btUnregister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(20, 20, 20)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(tfCourse)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btCourseAdd))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(tfCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btCourseAdd))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btStudentAdd))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btRegister)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3)
                        .addGap(18, 18, 18)
                        .addComponent(btUnregister)
                        .addGap(12, 12, 12)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btStudentAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btStudentAddActionPerformed
        try {
            String name = tfName.getText();
            if(name.isEmpty()){
                JOptionPane.showMessageDialog(this, "Please provide the student name");
                return;
            }
            
            fancyRegService.addStudent(new Student(name));
            refreshStudents();
            tfName.setText("");
        }catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(null, "Error processing operation: " + ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btStudentAddActionPerformed

    private void btCourseAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCourseAddActionPerformed
       try {
            String subject = tfCourse.getText();
            if(subject.isEmpty()){
                JOptionPane.showMessageDialog(this, "Please provide the course subject");
                return;
            }
            
            fancyRegService.addCourse(new Course(subject));
            refreshCourses();
            tfCourse.setText("");
        }catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(null, "Error processing operation: " + ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btCourseAddActionPerformed

    private void btRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegisterActionPerformed
        try {
            Student student = (Student) jlstudentList.getSelectedValue();
            Course course = (Course) jlcourseList.getSelectedValue();
            if(jlstudentList.isSelectionEmpty() || jlcourseList.isSelectionEmpty() ){
                JOptionPane.showMessageDialog(this, "Please make sure both student and course are selected");
                return;
            }
             
            fancyRegService.addRegistration(new Registration(new Date(), student, course));
            refreshRegistrations();
            
            jlstudentList.clearSelection();
            jlcourseList.clearSelection();
        }catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(null, "Error processing operation: " + ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btRegisterActionPerformed

    private void btUnregisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUnregisterActionPerformed
        
        try {
            Registration reg  = (Registration)jListRegistrations.getSelectedValue();
           /* if(subject.isEmpty()){
                JOptionPane.showMessageDialog(this, "Please provide the course subject");
                return;
            }*/
            
            fancyRegService.removeRegistration(reg);
            refreshRegistrations();
        }catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(null, "Error processing operation: " + ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btUnregisterActionPerformed

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
            java.util.logging.Logger.getLogger(FancyRegClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FancyRegClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FancyRegClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FancyRegClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FancyRegClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCourseAdd;
    private javax.swing.JButton btRegister;
    private javax.swing.JButton btStudentAdd;
    private javax.swing.JButton btUnregister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<Registration> jListRegistrations;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<Course> jlcourseList;
    private javax.swing.JList<Student> jlstudentList;
    private javax.swing.JTextField tfCourse;
    private javax.swing.JTextField tfName;
    // End of variables declaration//GEN-END:variables

    private void refreshStudents() {
      List<Student> studentsList =  fancyRegService.getAllStudents();
      studentsModel.removeAllElements();
      for( Student s: studentsList){
          studentsModel.addElement(s);
      }
    }

    private void refreshCourses() {
      List<Course> coursesList =  fancyRegService.getAllCourses();
      coursesModel.removeAllElements();
      for( Course c: coursesList){
          coursesModel.addElement(c);
      }
    }

    private void refreshRegistrations() {
        List<Registration> registrationsList =  fancyRegService.getAllRegistrations();
        registrationsModel.removeAllElements();
      for( Registration r: registrationsList){
          registrationsModel.addElement(r);
      }
    }
}
