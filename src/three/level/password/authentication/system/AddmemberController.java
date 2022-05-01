/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package three.level.password.authentication.system;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Suja Mohamed
 */
public class AddmemberController implements Initializable {

     @FXML
    public JFXTextField addid;

    @FXML
    private JFXTextField addname;

    @FXML
    private JFXTextField addia;
    @FXML
    public ImageView img;
    @FXML
    private StackPane stackPane;
    @FXML
    private AnchorPane achorPane;
    @FXML
    public JFXButton saveBtn;
    @FXML
    public JFXButton updateBtn;
    
    JFXButton okbtn =new JFXButton("OK");
    JFXButton okclose =new JFXButton("OK");
    Connection con=null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        okbtn.getStyleClass().add("blueRound");
        okclose.getStyleClass().add("blueRound");
    }


     
   private FileChooser nfc;
   private File nf,fEd;
   private FileInputStream nfis,fisEd;
  
    @FXML
    private void addImage(ActionEvent event) {
         nfc = new FileChooser();
             
            //Set extension filter
       nfc.getExtensionFilters().addAll(              
               new FileChooser.ExtensionFilter("Image Files", "*.jpg","*.png"),              
               new FileChooser.ExtensionFilter("All Files", "*")       
       );   
            
            //Show open file dialog
            nf = nfc.showOpenDialog(null);
            
            try {
                BufferedImage bufferedImage = ImageIO.read(nf);
                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                img.setImage(image);
            } catch (IOException ex) {
               JOptionPane.showMessageDialog(null, ex);
            }  

    }
    @FXML
    private void save(ActionEvent event) {
      con=DBConnection.ConnectDB();
        okclose.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent) -> {
             ((Stage) achorPane.getScene().getWindow()).close();
        
        });
      
      
    String sql ="insert into officers (id,name,ia,img) values(?,?,?,?)";
        try {
            
            pst =con.prepareStatement(sql);
            
            
            pst.setString(1, addid.getText());
            pst.setString(2, addname.getText());
            pst.setString(3, addia.getText());
           
            nfis= new FileInputStream(nf);
            pst.setBinaryStream(4, (InputStream)nfis, (int)nf.length());
   
            pst.execute();            
           
           
           AlertMaker.showMaterialDialog(stackPane, achorPane, Arrays.asList(okclose), "Alart", "Add Successfull");
          
        } catch (Exception e) {
           // JOptionPane.showMessageDialog(null,e);
          
            AlertMaker.showMaterialDialog(stackPane, achorPane, Arrays.asList(okbtn), "Wrong Submission", e.toString());
            //showErrorMessage(e);
        }finally{
            try {
                rs.close();
                pst.close();
            } catch (SQLException ex) {
                
            }          
        
        }
        
     
    }
    


          public void setUser(String id,String name,String ia){
               addid.setText(id);
               addname.setText(name);
               addia.setText(ia);
                
          }
     @FXML
     private void update(ActionEvent event){
            con =DBConnection.ConnectDB();
            
              okclose.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent) -> {
             ((Stage) achorPane.getScene().getWindow()).close();
        
        });
            
            
            
           String sql="update officers set name=?,ia=?,img=? where id=?"; 
        try {
            pst=con.prepareStatement(sql);
            pst.setString(1, addname.getText());
            pst.setString(2, addia.getText());
            
            
            
          /*  
            Image i=img.getImage();
            
            BufferedImage bImg=SwingFXUtils.fromFXImage(i, null);
            
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bImg,"png",baos);
            InputStream iss=new ByteArrayInputStream(baos.toByteArray());
             pst.setBinaryStream(3, (InputStream)iss);
            */
                     if(nf==null){
            fEd= new File("photo.png");
            fisEd= new FileInputStream(fEd);
            pst.setBinaryStream(3, fisEd, (int)fEd.length());
            }else{
                nfis= new FileInputStream(nf);
                pst.setBinaryStream(3, (InputStream)nfis, (int)nf.length());
              }
            
           
             
            pst.setString(4, addid.getText());
            pst.execute();
            AlertMaker.showMaterialDialog(stackPane, achorPane, Arrays.asList(okclose), "Alart", "Update Successfull");
        } catch (SQLException ex) {
            AlertMaker.showMaterialDialog(stackPane, achorPane, Arrays.asList(okbtn), "Wrong Submission", ex.toString());
        } catch (FileNotFoundException ex) {
             Logger.getLogger(AddmemberController.class.getName()).log(Level.SEVERE, null, ex);
         }finally{
            try {
                rs.close();
                pst.close();
            } catch (SQLException ex) {
                
            }          
        
        }
     
     
     }
    
}
