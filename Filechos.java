/*import javax.swing.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Filechos {

    byte[] userpdf;
    String path;
    String newpath;

    Filechos(){
        private void jButton2ActionPerformed(java.awt.event.ActionEvent e ) {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile();
            String filename = f.getAbsolutePath();
            path = filename;
            newpath = path.replace('\\', '/');
        }


        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

            try{
                File newpdf = new File(newpath);
                FileInputStream fis = new FileInputStream(newpdf);
                ByteArrayOutputStream baos= new ByteArrayOutputStream();
                byte[] buff = new byte[2048000];
                for(int readNum; (readNum=fis.read(buff)) !=-1 ; ){
                    baos.write(buff,0,readNum);
                }

                userpdf=baos.toByteArray();


            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            PreparedStatement pstmt = null;

            try{
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ppl","root","");
                String proj_name = JOptionPane.showInputDialog("Please enter name of the file");

             String insert = "INSERT INTO project VALUES ('" + login.admission + "','" + login.yr + "','" + proj_name + "','" + userpdf + "')";

             java.sql.PreparedStatement pst = con.prepareStatement(insert);
             pst.executeUpdate(insert);



                pstmt = (PreparedStatement) con.prepareStatement(sql);
                pstmt.setString(1, login.admission);
                pstmt.setString(2, login.yr);
                pstmt.setString(3, proj_name);
                pstmt.setBlob(4, userpdf); //This line has an error may be because of userpdf.Plz //suggest

                pstmt.executeUpdate();


                JOptionPane.showMessageDialog(null, "Saved");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }


        }
}*/
