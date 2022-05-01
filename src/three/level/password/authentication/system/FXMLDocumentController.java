/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package three.level.password.authentication.system;

import animatefx.animation.FadeInLeft;
import animatefx.animation.FadeInRight;
import com.github.sarxos.webcam.Webcam;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author Suja Mohamed
 */
public class FXMLDocumentController implements Initializable {
     @FXML
    private StackPane stackPane;
    @FXML
    AnchorPane anchorPane;
    @FXML
    private Pane slidePane;
    @FXML
    private JFXButton signupBtn;
    @FXML
    private JFXButton next1Btn;
    @FXML
    private JFXButton next2Btn;
    @FXML
    private JFXButton saveBtn;    
    @FXML
    private ImageView minimizeBtn;
    @FXML
    private ImageView closeBtn;
    @FXML
    private Pane signinPane;
    @FXML
    private Pane slidePaneSignup;
    @FXML
    private Pane slidePaneSave;
    @FXML
    private Pane regPane;
    @FXML
    private ImageView backBtn1;
    @FXML
    private ImageView backBtn2;
    @FXML
    private ImageView backBtn3;
    @FXML
    private Pane qrRegpane;
    @FXML
    private Pane oRegpane;
    @FXML
    private Pane slidePaneSave2;
    @FXML
    private Pane slidePaneSave3;
    @FXML
    private Pane passRegpane;
    @FXML
    private Label posReg1;
    @FXML
    private Label posReg2;
    @FXML
    private Label posReg3;
    
    @FXML
    private Pane login3;
    @FXML
    private JFXButton loginbtn3;
    @FXML
    private Pane login2;
    @FXML
    private JFXButton lognbtn2;
    @FXML
    private Pane login1;
    @FXML
    private JFXButton loginbtn1;
    
   
    
    @FXML
    private JFXTextField newIdfield;
    @FXML
    private JFXTextField newEmailfield;
    @FXML
    private JFXPasswordField newPskfield1;
    @FXML
    private JFXPasswordField newPskfield2;
    @FXML
    private JFXTextField loginIdField;
    @FXML
    private JFXPasswordField loginPskField;
    
    @FXML
    private TextField newQrfield;
    @FXML
    private Label newchack;
    
    @FXML
    private JFXButton r1;
    @FXML
    private JFXButton r9;
    @FXML
    private JFXButton r17;
    @FXML
    private JFXButton r25;
    @FXML
    private JFXButton r33;
    @FXML
    private JFXButton r41;
    @FXML
    private JFXButton r49;
    @FXML
    private JFXButton r57;
    @FXML
    private JFXButton r2;
    @FXML
    private JFXButton r10;
    @FXML
    private JFXButton r18;
    @FXML
    private JFXButton r26;
    @FXML
    private JFXButton r34;
    @FXML
    private JFXButton r42;
    @FXML
    private JFXButton r50;
    @FXML
    private JFXButton r58;
    @FXML
    private JFXButton r3;
    @FXML
    private JFXButton r11;
    @FXML
    private JFXButton r19;
    @FXML
    private JFXButton r27;
    @FXML
    private JFXButton r35;
    @FXML
    private JFXButton r43;
    @FXML
    private JFXButton r51;
    @FXML
    private JFXButton r59;
    @FXML
    private JFXButton r4;
    @FXML
    private JFXButton r5;
    @FXML
    private JFXButton r6;
    @FXML
    private JFXButton r7;
    @FXML
    private JFXButton r8;
    @FXML
    private JFXButton r12;
    @FXML
    private JFXButton r13;
    @FXML
    private JFXButton r14;
    @FXML
    private JFXButton r15;
    @FXML
    private JFXButton r16;
    @FXML
    private JFXButton r20;
    @FXML
    private JFXButton r21;
    @FXML
    private JFXButton r22;
    @FXML
    private JFXButton r23;
    @FXML
    private JFXButton r24;
    @FXML
    private JFXButton r28;
    @FXML
    private JFXButton r36;
    @FXML
    private JFXButton r44;
    @FXML
    private JFXButton r52;
    @FXML
    private JFXButton r60;
    @FXML
    private JFXButton r29;
    @FXML
    private JFXButton r37;
    @FXML
    private JFXButton r45;
    @FXML
    private JFXButton r53;
    @FXML
    private JFXButton r61;
    @FXML
    private JFXButton r30;
    @FXML
    private JFXButton r38;
    @FXML
    private JFXButton r46;
    @FXML
    private JFXButton r54;
    @FXML
    private JFXButton r62;
    @FXML
    private JFXButton r31;
    @FXML
    private JFXButton r32;
    @FXML
    private JFXButton r39;
    @FXML
    private JFXButton r40;
    @FXML
    private JFXButton r47;
    @FXML
    private JFXButton r48;
    @FXML
    private JFXButton r55;
    @FXML
    private JFXButton r56;
    @FXML
    private JFXButton r63;
    @FXML
    private JFXButton r64;
    @FXML
    private JFXPasswordField imgregpskField;
    
    
    @FXML
    private JFXButton l1;
    @FXML
    private JFXButton l9;
    @FXML
    private JFXButton l17;
    @FXML
    private JFXButton l25;
    @FXML
    private JFXButton l33;
    @FXML
    private JFXButton l41;
    @FXML
    private JFXButton l49;
    @FXML
    private JFXButton l57;
    @FXML
    private JFXButton l2;
    @FXML
    private JFXButton l10;
    @FXML
    private JFXButton l18;
    @FXML
    private JFXButton l26;
    @FXML
    private JFXButton l34;
    @FXML
    private JFXButton l42;
    @FXML
    private JFXButton l50;
    @FXML
    private JFXButton l58;
    @FXML
    private JFXButton l3;
    @FXML
    private JFXButton l11;
    @FXML
    private JFXButton l19;
    @FXML
    private JFXButton l27;
    @FXML
    private JFXButton l35;
    @FXML
    private JFXButton l43;
    @FXML
    private JFXButton l51;
    @FXML
    private JFXButton l59;
    @FXML
    private JFXButton l4;
    @FXML
    private JFXButton l5;
    @FXML
    private JFXButton l6;
    @FXML
    private JFXButton l7;
    @FXML
    private JFXButton l8;
    @FXML
    private JFXButton l12;
    @FXML
    private JFXButton l13;
    @FXML
    private JFXButton l14;
    @FXML
    private JFXButton l15;
    @FXML
    private JFXButton l16;
    @FXML
    private JFXButton l20;
    @FXML
    private JFXButton l21;
    @FXML
    private JFXButton l22;
    @FXML
    private JFXButton l23;
    @FXML
    private JFXButton l24;
    @FXML
    private JFXButton l28;
    @FXML
    private JFXButton l36;
    @FXML
    private JFXButton l44;
    @FXML
    private JFXButton l52;
    @FXML
    private JFXButton l60;
    @FXML
    private JFXButton l29;
    @FXML
    private JFXButton l37;
    @FXML
    private JFXButton l45;
    @FXML
    private JFXButton l53;
    @FXML
    private JFXButton l61;
    @FXML
    private JFXButton l30;
    @FXML
    private JFXButton l38;
    @FXML
    private JFXButton l46;
    @FXML
    private JFXButton l54;
    @FXML
    private JFXButton l62;
    @FXML
    private JFXButton l31;
    @FXML
    private JFXButton l32;
    @FXML
    private JFXButton l39;
    @FXML
    private JFXButton l40;
    @FXML
    private JFXButton l47;
    @FXML
    private JFXButton l48;
    @FXML
    private JFXButton l55;
    @FXML
    private JFXButton l56;
    @FXML
    private JFXButton l63;
    @FXML
    private JFXButton l64;
    
    @FXML
    private ImageView loginImgView;
    @FXML
    private JFXTextField imgloginField;
    @FXML
    private TextField loginQrField;
    @FXML
    private Label newchack2;
    @FXML
    private ImageView regImageView;
   
 

    JFXButton btn = new JFXButton("Okay!");
      
    
    Connection con=null;  
    //ResultSet rs = null;
    //PreparedStatement pst = null;
    
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    
    @FXML
    private void signup(ActionEvent event) {
          con =DBConnection.ConnectDB();
              
        
          String sql = "SELECT COUNT(*) FROM user";
            try {
                preparedStatement = con.prepareStatement(sql);                
                resultSet = preparedStatement.executeQuery();
                
                if (resultSet.next()) {
                    String sum=resultSet.getString("COUNT(*)");
                    if(sum.equals("1")){                   
                    
                    
                     AlertMaker.showMaterialDialog(stackPane, anchorPane, Arrays.asList(btn), "You Already Registed", "You Can Register Only One Time");
                    
                    } else {
                        
                          TranslateTransition slide = new TranslateTransition();
                          slide.setDuration(Duration.seconds(0.7));
                          slide.setNode(slidePane);
        
                           int AP = (int) anchorPane.getWidth();
                           int SP = (int) slidePane.getWidth();
        
                           slidePaneSave.toFront();
                           slide.setToX(AP-SP);
                           slide.play();   
                           signinPane.setVisible(false);
                           regPane.setVisible(true);
                           new FadeInLeft(regPane).play();
        
                           passRegpane.toFront();
        
                           posReg1.setStyle(" -fx-background-color: linear-gradient(to right, #fc466b, #3f5efb);");
                           //  newQrfield.setText(null);
                    
              
                }
                    
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                
            }finally{
                try {
                    resultSet.close();
                    preparedStatement.close();
                    
                } catch (Exception e) {
                }
            
            }
            
 
    }
    
    @FXML
    private void next1(ActionEvent event) {
     
        boolean n =newPskfield1.getText().equals(newPskfield2.getText());
        boolean n1 =newPskfield1.getText().isEmpty();
        boolean n2 =newPskfield2.getText().isEmpty();
        boolean n3 =newEmailfield.getText().isEmpty();
        boolean n4 =newEmailfield.getText().isEmpty();
        
        
         if(n && !n1 && !n3 && !n4){
           qrRegpane.toFront();
         new FadeInLeft(qrRegpane).play();         
         slidePaneSave2.toFront();
         posReg2.setStyle(" -fx-background-color:  linear-gradient(to right, #fc466b, #3f5efb);");
        
        }else{
         
         AlertMaker.showMaterialDialog(stackPane, anchorPane, Arrays.asList(btn), "Oops", "Wrong Submission");
         
         }
        
        
        
        
        
         
       
    }
     @FXML
    private void next2(ActionEvent event) {
        
    /*    
        if(newQrfield.getText().isEmpty()){
        AlertMaker.showMaterialDialog(stackPane, anchorPane, Arrays.asList(btn), "Oops", "Wrong Submission");
        }else{
       
       
        }*/
          oRegpane.toFront();
         new FadeInLeft(oRegpane).play();  
         
        slidePaneSave3.toFront();
        posReg3.setStyle(" -fx-background-color:  linear-gradient(to right, #fc466b, #3f5efb);");
        
        
        
    }
    private FileChooser fc;
    private File f,fd;
    private FileInputStream fis,fisd;
    private Image image;
    @FXML
    private void pickImage(ActionEvent event){
     fc = new FileChooser();
             
            //Set extension filter
            FileChooser.ExtensionFilter extFilterJPG = 
                    new FileChooser.ExtensionFilter("JPG files (*.JPG)", "*.JPG");
            FileChooser.ExtensionFilter extFilterjpg = 
                    new FileChooser.ExtensionFilter("jpg files (*.jpg)", "*.jpg");
            FileChooser.ExtensionFilter extFilterPNG = 
                    new FileChooser.ExtensionFilter("PNG files (*.PNG)", "*.PNG");
            FileChooser.ExtensionFilter extFilterpng = 
                    new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
            fc.getExtensionFilters()
                    .addAll(extFilterJPG, extFilterjpg, extFilterPNG, extFilterpng);

            //Show open file dialog
             f = fc.showOpenDialog(null);
            
            try {
                
               
                BufferedImage bufferedImage = ImageIO.read(f);
                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
               
                regImageView.setImage(image);
            } catch (IOException ex) {
               JOptionPane.showMessageDialog(null, ex);
               
            }
    
    
    
    }
    
    
    JFXButton btn2 = new JFXButton("Okay!");
    @FXML
    private void save(ActionEvent event) {
      con =DBConnection.ConnectDB();  
       if(!imgregpskField.getText().isEmpty()){
       
       btn2.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent) -> {
             TranslateTransition slide = new TranslateTransition();
             slide.setDuration(Duration.seconds(0.7));
             slide.setNode(slidePane);
        
             slide.setToX(0);
             slide.play();
             signinPane.setVisible(true);
             regPane.setVisible(false);
             slidePaneSignup.toFront();
             new FadeInRight(signinPane).play();
       
             posReg1.setStyle(" -fx-background-color:  linear-gradient(to right, #00c6ff, #0072ff);");
             posReg2.setStyle(" -fx-background-color:  linear-gradient(to right, #00c6ff, #0072ff);");
             posReg3.setStyle(" -fx-background-color:  linear-gradient(to right, #00c6ff, #0072ff);");
      
                
               
               
            });
     
     //save data
      
      String sql ="insert into user (ID,Email,Psk,QR,ImgPsk,img) values(?,?,?,?,?,?)";
    
        try {
            preparedStatement =con.prepareStatement(sql);
            
            preparedStatement.setString(1, newIdfield.getText());
            preparedStatement.setString(2, newEmailfield.getText());
            preparedStatement.setString(3, newPskfield1.getText());
            preparedStatement.setString(4, newQrfield.getText());
            preparedStatement.setString(5, imgregpskField.getText());
            
            
                      
            
            
            
            if(f==null){
            fd= new File("DefaultImg.jpg");
            fisd= new FileInputStream(fd);
            preparedStatement.setBinaryStream(6, (InputStream)fisd, (int)fd.length()); 
            }else{
                fis = new FileInputStream(f);           
                preparedStatement.setBinaryStream(6, (InputStream)fis, (int)f.length()); 
              }
            
            preparedStatement.execute();
            
            
           AlertMaker.showMaterialDialog(stackPane, anchorPane, Arrays.asList(btn2), "Register Sucees", "Now You Can Login");
          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }finally{
                try {
                    resultSet.close();
                    preparedStatement.close();
                    
                } catch (Exception e) {
                }
            
            }
       
       
       }else{
       
        AlertMaker.showMaterialDialog(stackPane, anchorPane, Arrays.asList(btn), "Oops", "Wrong Submission");
       
       }
     
     
        
        
        
    
      
      
      
    }
    
   
    
   // private ObjectProperty<javafx.scene.image.Image> imageProperty = new SimpleObjectProperty<javafx.scene.image.Image>();
    Webcam webcam;
    
    @FXML
    private void newQrscane(ActionEvent event ){
         
        
         webcam = Webcam.getDefault();
         webcam.setCustomViewSizes(new Dimension(320,240));
         webcam.open();
       
       Thread clock = new Thread() {
             public void run() {
                
        for(int i=0;i <=100;i++){
        runf();
        
      
         try {                    
                    sleep(40);
                } catch (InterruptedException ex) {
                     //...
                }
        
        System.out.println("Chack"+i);
       
            if(i ==100){
            webcam.close();
           
    
            }  
         }
        
        if(newQrfield.getText().isEmpty()){
             newchack.setText("Please Scanne Again");
             
          }else{
             newchack.setText("Scanne Succes");
            
          }
     
             }
             
       };
       clock.start(); 
 
    
    }
    
    @FXML
    private void loginQrscane(ActionEvent event ){
         
        
        webcam = Webcam.getDefault();
        webcam.setCustomViewSizes(new Dimension(320,240));
        webcam.open();
       
     
        for(int i=0;i <=100;i++){
        runf();
        System.out.println("Chack"+i);
       
            if(i ==100){
            webcam.close();
             
            }  
         }
        
          if(newQrfield.getText().isEmpty()){
          
             newchack2.setText("Please Scanne Again");
          }else{
             
             newchack2.setText("Scanne Succes");
          }

    
    }
    
    
    
      public void runf() {
         
         

            com.google.zxing.Result result = null;
            BufferedImage image = null;

            if (webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                  
                }
            }

            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException e) {
                //No result...
            }

            if (result != null) {
                newQrfield.setText(result.getText());
                loginQrField.setText(result.getText());
            } 
      }

    @FXML
    private void close(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void minimize(MouseEvent event) {
    Stage stage = (Stage)minimizeBtn.getScene().getWindow();
    stage.setIconified(true);    
    }
    @FXML
    private void back1(MouseEvent event) {
        //
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.7));
        slide.setNode(slidePane);
        
        slide.setToX(0);
        slide.play();
        signinPane.setVisible(true);
        regPane.setVisible(false);
        slidePaneSignup.toFront();
        new FadeInRight(signinPane).play();
        //
        
       
    }
      @FXML
    private void back2(MouseEvent event) {
        //
      
        // 
        slidePaneSave.toFront();
        passRegpane.toFront();
        new FadeInRight(passRegpane).play();
        posReg2.setStyle(" -fx-background-color: linear-gradient(to right, #00c6ff, #0072ff);");
       
    }
        @FXML
    private void back3(MouseEvent event) {
        //
      
        //
       slidePaneSave2.toFront();
        qrRegpane.toFront();
        new FadeInRight(qrRegpane).play();
      
        posReg3.setStyle(" -fx-background-color: linear-gradient(to right, #00c6ff, #0072ff);");
       
    }
    @FXML
    private void imgpskReg(ActionEvent event){
        if(event.getSource() == r1){
        imgregpskField.setText(imgregpskField.getText()+"01");
        }else if(event.getSource() == r2){
        imgregpskField.setText(imgregpskField.getText()+"02");
        }else if(event.getSource() == r3){
        imgregpskField.setText(imgregpskField.getText()+"03");
        }else if(event.getSource() == r4){
        imgregpskField.setText(imgregpskField.getText()+"04");
        }else if(event.getSource() == r5){
        imgregpskField.setText(imgregpskField.getText()+"05");
        }else if(event.getSource() == r6){
        imgregpskField.setText(imgregpskField.getText()+"06");
        }else if(event.getSource() == r7){
        imgregpskField.setText(imgregpskField.getText()+"07");
        }else if(event.getSource() == r8){
        imgregpskField.setText(imgregpskField.getText()+"08");
        }else if(event.getSource() == r9){
        imgregpskField.setText(imgregpskField.getText()+"09");
        }else if(event.getSource() == r10){
        imgregpskField.setText(imgregpskField.getText()+"10");
        }else if(event.getSource() == r11){
        imgregpskField.setText(imgregpskField.getText()+"11");
        }else if(event.getSource() == r12){
        imgregpskField.setText(imgregpskField.getText()+"12");
        }else if(event.getSource() == r13){
        imgregpskField.setText(imgregpskField.getText()+"13");
        }else if(event.getSource() == r14){
        imgregpskField.setText(imgregpskField.getText()+"14");
        }else if(event.getSource() == r15){
        imgregpskField.setText(imgregpskField.getText()+"15");
        }else if(event.getSource() == r16){
        imgregpskField.setText(imgregpskField.getText()+"16");
        }else if(event.getSource() == r17){
        imgregpskField.setText(imgregpskField.getText()+"17");
        }else if(event.getSource() == r18){
        imgregpskField.setText(imgregpskField.getText()+"18");
        }else if(event.getSource() == r19){
        imgregpskField.setText(imgregpskField.getText()+"19");
        }else if(event.getSource() == r20){
        imgregpskField.setText(imgregpskField.getText()+"20");
        }else if(event.getSource() == r21){
        imgregpskField.setText(imgregpskField.getText()+"21");
        }else if(event.getSource() == r22){
        imgregpskField.setText(imgregpskField.getText()+"22");
        }else if(event.getSource() == r23){
        imgregpskField.setText(imgregpskField.getText()+"23");
        }else if(event.getSource() == r24){
        imgregpskField.setText(imgregpskField.getText()+"24");
        }else if(event.getSource() == r25){
        imgregpskField.setText(imgregpskField.getText()+"25");
        }else if(event.getSource() == r26){
        imgregpskField.setText(imgregpskField.getText()+"26");
        }else if(event.getSource() == r27){
        imgregpskField.setText(imgregpskField.getText()+"27");
        }else if(event.getSource() == r28){
        imgregpskField.setText(imgregpskField.getText()+"28");
        }else if(event.getSource() == r29){
        imgregpskField.setText(imgregpskField.getText()+"29");
        }else if(event.getSource() == r30){
        imgregpskField.setText(imgregpskField.getText()+"30");
        }else if(event.getSource() == r31){
        imgregpskField.setText(imgregpskField.getText()+"31");
        }else if(event.getSource() == r32){
        imgregpskField.setText(imgregpskField.getText()+"32");
        }else if(event.getSource() == r33){
        imgregpskField.setText(imgregpskField.getText()+"33");
        }else if(event.getSource() == r34){
        imgregpskField.setText(imgregpskField.getText()+"34");
        }else if(event.getSource() == r35){
        imgregpskField.setText(imgregpskField.getText()+"35");
        }else if(event.getSource() == r36){
        imgregpskField.setText(imgregpskField.getText()+"36");
        }else if(event.getSource() == r37){
        imgregpskField.setText(imgregpskField.getText()+"37");
        }else if(event.getSource() == r38){
        imgregpskField.setText(imgregpskField.getText()+"38");
        }else if(event.getSource() == r39){
        imgregpskField.setText(imgregpskField.getText()+"39");
        }else if(event.getSource() == r40){
        imgregpskField.setText(imgregpskField.getText()+"40");
        }else if(event.getSource() == r41){
        imgregpskField.setText(imgregpskField.getText()+"41");
        }else if(event.getSource() == r42){
        imgregpskField.setText(imgregpskField.getText()+"42");
        }else if(event.getSource() == r43){
        imgregpskField.setText(imgregpskField.getText()+"43");
        }else if(event.getSource() == r44){
        imgregpskField.setText(imgregpskField.getText()+"44");
        }else if(event.getSource() == r45){
        imgregpskField.setText(imgregpskField.getText()+"45");
        }else if(event.getSource() == r46){
        imgregpskField.setText(imgregpskField.getText()+"46");
        }else if(event.getSource() == r47){
        imgregpskField.setText(imgregpskField.getText()+"47");
        }else if(event.getSource() == r48){
        imgregpskField.setText(imgregpskField.getText()+"48");
        }else if(event.getSource() == r49){
        imgregpskField.setText(imgregpskField.getText()+"49");
        }else if(event.getSource() == r50){
        imgregpskField.setText(imgregpskField.getText()+"50");
        }else if(event.getSource() == r51){
        imgregpskField.setText(imgregpskField.getText()+"51");
        }else if(event.getSource() == r52){
        imgregpskField.setText(imgregpskField.getText()+"52");
        }else if(event.getSource() == r53){
        imgregpskField.setText(imgregpskField.getText()+"53");
        }else if(event.getSource() == r54){
        imgregpskField.setText(imgregpskField.getText()+"54");
        }else if(event.getSource() == r55){
        imgregpskField.setText(imgregpskField.getText()+"55");
        }else if(event.getSource() == r56){
        imgregpskField.setText(imgregpskField.getText()+"56");
        }else if(event.getSource() == r57){
        imgregpskField.setText(imgregpskField.getText()+"57");
        }else if(event.getSource() == r58){
        imgregpskField.setText(imgregpskField.getText()+"58");
        }else if(event.getSource() == r59){
        imgregpskField.setText(imgregpskField.getText()+"59");
        }else if(event.getSource() == r60){
        imgregpskField.setText(imgregpskField.getText()+"60");
        }else if(event.getSource() == r61){
        imgregpskField.setText(imgregpskField.getText()+"61");
        }else if(event.getSource() == r62){
        imgregpskField.setText(imgregpskField.getText()+"62");
        }else if(event.getSource() == r63){
        imgregpskField.setText(imgregpskField.getText()+"63");
        }else if(event.getSource() == r64){
        imgregpskField.setText(imgregpskField.getText()+"64");
        }
    
    
    }
    @FXML
    private void imgpskLogin(ActionEvent event){
        if(event.getSource() == l1){
        imgloginField.setText(imgloginField.getText()+"01");
        }else if(event.getSource() == l2){
        imgloginField.setText(imgloginField.getText()+"02");
        }else if(event.getSource() == l3){
        imgloginField.setText(imgloginField.getText()+"03");
        }else if(event.getSource() == l4){
        imgloginField.setText(imgloginField.getText()+"04");
        }else if(event.getSource() == l5){
        imgloginField.setText(imgloginField.getText()+"05");
        }else if(event.getSource() == l6){
        imgloginField.setText(imgloginField.getText()+"06");
        }else if(event.getSource() == l7){
        imgloginField.setText(imgloginField.getText()+"07");
        }else if(event.getSource() == l8){
        imgloginField.setText(imgloginField.getText()+"08");
        }else if(event.getSource() == l9){
        imgloginField.setText(imgloginField.getText()+"09");
        }else if(event.getSource() == l10){
        imgloginField.setText(imgloginField.getText()+"10");
        }else if(event.getSource() == l11){
        imgloginField.setText(imgloginField.getText()+"11");
        }else if(event.getSource() == l12){
        imgloginField.setText(imgloginField.getText()+"12");
        }else if(event.getSource() == l13){
        imgloginField.setText(imgloginField.getText()+"13");
        }else if(event.getSource() == l14){
        imgloginField.setText(imgloginField.getText()+"14");
        }else if(event.getSource() == l15){
        imgloginField.setText(imgloginField.getText()+"15");
        }else if(event.getSource() == l16){
        imgloginField.setText(imgloginField.getText()+"16");
        }else if(event.getSource() == l17){
        imgloginField.setText(imgloginField.getText()+"17");
        }else if(event.getSource() == l18){
        imgloginField.setText(imgloginField.getText()+"18");
        }else if(event.getSource() == l19){
        imgloginField.setText(imgloginField.getText()+"19");
        }else if(event.getSource() == l20){
        imgloginField.setText(imgloginField.getText()+"20");
        }else if(event.getSource() == l21){
        imgloginField.setText(imgloginField.getText()+"21");
        }else if(event.getSource() == l22){
        imgloginField.setText(imgloginField.getText()+"22");
        }else if(event.getSource() == l23){
        imgloginField.setText(imgloginField.getText()+"23");
        }else if(event.getSource() == l24){
        imgloginField.setText(imgloginField.getText()+"24");
        }else if(event.getSource() == l25){
        imgloginField.setText(imgloginField.getText()+"25");
        }else if(event.getSource() == l26){
        imgloginField.setText(imgloginField.getText()+"26");
        }else if(event.getSource() == l27){
        imgloginField.setText(imgloginField.getText()+"27");
        }else if(event.getSource() == l28){
        imgloginField.setText(imgloginField.getText()+"28");
        }else if(event.getSource() == l29){
        imgloginField.setText(imgloginField.getText()+"29");
        }else if(event.getSource() == l30){
        imgloginField.setText(imgloginField.getText()+"30");
        }else if(event.getSource() == l31){
        imgloginField.setText(imgloginField.getText()+"31");
        }else if(event.getSource() == l32){
        imgloginField.setText(imgloginField.getText()+"32");
        }else if(event.getSource() == l33){
        imgloginField.setText(imgloginField.getText()+"33");
        }else if(event.getSource() == l34){
        imgloginField.setText(imgloginField.getText()+"34");
        }else if(event.getSource() == l35){
        imgloginField.setText(imgloginField.getText()+"35");
        }else if(event.getSource() == l36){
        imgloginField.setText(imgloginField.getText()+"36");
        }else if(event.getSource() == l37){
        imgloginField.setText(imgloginField.getText()+"37");
        }else if(event.getSource() == l38){
        imgloginField.setText(imgloginField.getText()+"38");
        }else if(event.getSource() == l39){
        imgloginField.setText(imgloginField.getText()+"39");
        }else if(event.getSource() == l40){
        imgloginField.setText(imgloginField.getText()+"40");
        }else if(event.getSource() == l41){
        imgloginField.setText(imgloginField.getText()+"41");
        }else if(event.getSource() == l42){
        imgloginField.setText(imgloginField.getText()+"42");
        }else if(event.getSource() == l43){
        imgloginField.setText(imgloginField.getText()+"43");
        }else if(event.getSource() == l44){
        imgloginField.setText(imgloginField.getText()+"44");
        }else if(event.getSource() == l45){
        imgloginField.setText(imgloginField.getText()+"45");
        }else if(event.getSource() == l46){
        imgloginField.setText(imgloginField.getText()+"46");
        }else if(event.getSource() == l47){
        imgloginField.setText(imgloginField.getText()+"47");
        }else if(event.getSource() == l48){
        imgloginField.setText(imgloginField.getText()+"48");
        }else if(event.getSource() == l49){
        imgloginField.setText(imgloginField.getText()+"49");
        }else if(event.getSource() == l50){
        imgloginField.setText(imgloginField.getText()+"50");
        }else if(event.getSource() == l51){
        imgloginField.setText(imgloginField.getText()+"51");
        }else if(event.getSource() == l52){
        imgloginField.setText(imgloginField.getText()+"52");
        }else if(event.getSource() == l53){
        imgloginField.setText(imgloginField.getText()+"53");
        }else if(event.getSource() == l54){
        imgloginField.setText(imgloginField.getText()+"54");
        }else if(event.getSource() == l55){
        imgloginField.setText(imgloginField.getText()+"55");
        }else if(event.getSource() == l56){
        imgloginField.setText(imgloginField.getText()+"56");
        }else if(event.getSource() == l57){
        imgloginField.setText(imgloginField.getText()+"57");
        }else if(event.getSource() == l58){
        imgloginField.setText(imgloginField.getText()+"58");
        }else if(event.getSource() == l59){
        imgloginField.setText(imgloginField.getText()+"59");
        }else if(event.getSource() == l60){
        imgloginField.setText(imgloginField.getText()+"60");
        }else if(event.getSource() == l61){
        imgloginField.setText(imgloginField.getText()+"61");
        }else if(event.getSource() == l62){
        imgloginField.setText(imgloginField.getText()+"62");
        }else if(event.getSource() == l63){
        imgloginField.setText(imgloginField.getText()+"63");
        }else if(event.getSource() == l64){
        imgloginField.setText(imgloginField.getText()+"64");
        }
        
    }
    @FXML
    private ImageView img1;
    @FXML
    private Label lbl1;
    @FXML
    private ImageView img2;
    @FXML
    private Label lbl2;
    @FXML
    private ImageView img3;
    
     private RotateTransition rotateTransition1,rotateTransition2,rotateTransition3;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        regPane.setVisible(false);
      
        
            RequiredFieldValidator reqInputValid = new  RequiredFieldValidator();
            reqInputValid.setMessage("Cant be Empty");           
            newIdfield.getValidators().add(reqInputValid);
            newIdfield.focusedProperty().addListener((o,oldVal,newVal)->{
                if(!newVal)newIdfield.validate();
                
            });
            
            newEmailfield.getValidators().add(reqInputValid);
            newEmailfield.focusedProperty().addListener((o,oldVal,newVal)->{
                if(!newVal)newEmailfield.validate();
                
            });
            
            newPskfield1.getValidators().add(reqInputValid);
            newPskfield1.focusedProperty().addListener((o,oldVal,newVal)->{
                if(!newVal)newPskfield1.validate();
                
            });
            
            newPskfield2.getValidators().add(reqInputValid);
            newPskfield2.focusedProperty().addListener((o,oldVal,newVal)->{
                if(!newVal)newPskfield2.validate();
                
            });
        
        
        
        btn.setStyle(" -fx-background-color:  red;" +                     
                     "    -fx-background-radius: 200;" +
                     "    -fx-text-fill: white;" +
                     "    -fx-font-weight: bold;");
        btn2.setStyle(" -fx-background-color:  red;" +                     
                     "    -fx-background-radius: 200;" +
                     "    -fx-text-fill: white;" +
                     "    -fx-font-weight: bold;");
        
        rotateTransition1 = new RotateTransition(Duration.seconds(5),img1);
        rotateTransition2 = new RotateTransition(Duration.seconds(5),img2);
        rotateTransition3 = new RotateTransition(Duration.seconds(5),img3);
        
        RotateTransition transition[] = {rotateTransition1,rotateTransition2,rotateTransition3};
        for(RotateTransition rTransition: transition ){
        rTransition.setCycleCount(1);
        rTransition.setAutoReverse(true);
        rTransition.setFromAngle(720);
        rTransition.setToAngle(0);
        }        
        rotateTransition1.play();
        
        
        
    }
    
    
    @FXML
    private void loginbt1(ActionEvent event) {       
         con=DBConnection.ConnectDB();
         String uname = loginIdField.getText();
         String pword = loginPskField.getText();
         
        
          String sql = "SELECT * FROM user Where id = ? and psk = ?";
            try {
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, uname);
                preparedStatement.setString(2, pword);
                resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()) {
                    
                    AlertMaker.showMaterialDialog(stackPane, anchorPane, Arrays.asList(btn), "Try Again", "Check Your Id & Password ");
                    
                    String logstyle ="-jfx-unfocus-color: red";
                    loginIdField.setStyle(logstyle);
                    loginPskField.setStyle(logstyle);
                    
                    
                    
                    
                } else {
                    
                 login2.toFront();
                 new FadeInRight(login2).play();
                 img1.setImage(new Image("Icon/pass1.png"));
                 lbl1.setStyle( "-fx-background-color: #009D1A;");       

        
                 rotateTransition2.play();
               
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                
            }finally{
                try {
                    resultSet.close();
                    preparedStatement.close();
                    
                } catch (Exception e) {
                }
            
            } 
    
        
        loginQrField.setText(null);
    }

    @FXML
    private void loginbt2(ActionEvent event) {

         con=DBConnection.ConnectDB();
         String uname = loginIdField.getText();
         String pword = loginPskField.getText();
         String qrpword = loginQrField.getText();
         
        
          String sql = "SELECT * FROM user Where id = ? and psk = ? and qr = ?";
            try {
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, uname);
                preparedStatement.setString(2, pword);
                preparedStatement.setString(3, qrpword);
                resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()) {                   
                     AlertMaker.showMaterialDialog(stackPane, anchorPane, Arrays.asList(btn), "Try Again", "Incorrect QR ID");
                    loginQrField.setText("");
                    
                } else {
                     login3.toFront();
                     new FadeInRight(login3).play();
                     img2.setImage(new Image("Icon/pass1.png"));
                     lbl2.setStyle( "-fx-background-color: #009D1A;");    

                     rotateTransition3.play();
                     viewImage();
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                
            }finally{
                try {
                    resultSet.close();
                    preparedStatement.close();
                    
                } catch (Exception e) {
                }
            
            }
        
        
        
        
        
    }

    @FXML
    private void loginbt3(ActionEvent event) {
        
        
        
         con=DBConnection.ConnectDB();
         String uname = loginIdField.getText();
         String pword = loginPskField.getText();
         String qrpword = loginQrField.getText();
         String imgpword = imgloginField.getText();
         
        
          String sql = "SELECT * FROM user Where id = ? and psk = ? and qr = ? and imgpsk = ?";
            try {
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, uname);
                preparedStatement.setString(2, pword);
                preparedStatement.setString(3, qrpword);
                preparedStatement.setString(4, imgpword);
                resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()) {
                    
                 AlertMaker.showMaterialDialog(stackPane, anchorPane, Arrays.asList(btn), "Try Again", "Incorrect Picture Password");
                 
                 
                 imgloginField.setText("");
                    
                    
                } else {
                  //JOptionPane.showConfirmDialog(null, "suja");
                  img3.setImage(new Image("Icon/pass1.png"));
      
                  loadMain();
                  closeStage();
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                
            }finally{
                try {
                    resultSet.close();
                    preparedStatement.close();
                    con.close();
                    
                } catch (Exception e) {
                }
            
            }
        
        

    }    
    
     void loadMain() {
   
         
          FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));         
        Parent root;
        try {
           
            root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        //stage.initStyle(StageStyle.UTILITY);
       // stage.initStyle(StageStyle.TRANSPARENT);
       
       MainController ad = loader.getController();
       ad.setUser(loginIdField.getText());
       
       
  

        stage.setScene(scene);
        stage.show(); 
        
      
        
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
         
    }
      private void closeStage() {
        ((Stage) anchorPane.getScene().getWindow()).close();
    }
    
    @FXML
    private void regImgDefault(ActionEvent event){
        
        imgregpskField.setText("");
        f=null;
        Image dImg = new Image("Icon/DefaultImg.jpg");
        regImageView.setImage(dImg);
    
    
    
    }
        public void viewImage(){
        con=DBConnection.ConnectDB();
        try {
            preparedStatement=con.prepareStatement("select img from user where id =?");
            preparedStatement.setString(1,loginIdField.getText());
            resultSet=preparedStatement.executeQuery();
            
            if(resultSet.next()){
             InputStream is = resultSet.getBinaryStream(1);
             OutputStream os = new FileOutputStream(new File("savedphoto.png"));
            byte[] content = new byte[102400];
            int size =0;
            while((size = is.read(content)) != -1){
                   os.write(content, 0, size);
            
            }
            image = new Image("file:savedphoto.png");
            //image = new Image("file:savedphoto.png",loginImgView.getFitWidth(),loginImgView.getFitHeight(),true,true);
            loginImgView.setImage(image);
            
            os.close(); 
            is.close();
            
            }
           
   
           
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }finally{
            try {
                preparedStatement.close();       
                resultSet.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        
        }
    
    
    }
    
}
