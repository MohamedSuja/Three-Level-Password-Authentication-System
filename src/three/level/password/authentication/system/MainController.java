/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package three.level.password.authentication.system;

import com.jfoenix.controls.JFXButton;
import java.io.File;
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
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Suja Mohamed
 */
public class MainController implements Initializable {

    @FXML
    private StackPane stackPane;
    @FXML
    private AnchorPane rootPane;
    
    @FXML
    private Label idLabel;
    @FXML
    private TextField searchid;
    
    @FXML
    private TableView<tablelist> table;
    @FXML
    private TableColumn<tablelist, String> idCol;
    @FXML
    private TableColumn<tablelist, String> nameCol;
    @FXML
    private TableColumn<tablelist, String> IACol;
    @FXML
    private ImageView image;

    Connection con=null;
    ResultSet resultSet = null;
    PreparedStatement  preparedStatement = null;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        nobtn.getStyleClass().add("blueRound");
        ok.getStyleClass().add("blueRound");
        yesRSbtn.getStyleClass().add("redRound");
        oklogout.getStyleClass().add("redRound");
        
        UpdateTable();
        search();
        
    }   
    @FXML
    private void logout(ActionEvent event) {
        
        try {
            loadMain();
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeStage();

    }
    
    private double xOffset = 0;
    private double yOffset = 0;
         void loadMain() throws IOException{
   
          Stage stage = new Stage();
          Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        stage.initStyle(StageStyle.UNDECORATED);
        Scene scene = new Scene(root);  
        
        
        
                root.setOnMousePressed((MouseEvent event) ->{
           xOffset = event.getSceneX();
           yOffset = event.getSceneY();
        
        });
        
        root.setOnMouseDragged((MouseEvent event) ->{
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
    });     
        
        stage.setScene(scene);
        stage.show();
         
         
    }
    
         
    private void closeStage() {
        ((Stage) rootPane.getScene().getWindow()).close();
    }
    
    
    JFXButton yesRSbtn =new JFXButton("Yes");
    JFXButton nobtn =new JFXButton("No");
    JFXButton oklogout =new JFXButton("OK");
    JFXButton ok =new JFXButton("OK");
    @FXML
    private void resetId(ActionEvent event){
         
        oklogout.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent) -> {
           try {
            loadMain();
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeStage();
        
        });
         yesRSbtn.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent) -> {
              Connection con=DBConnection.ConnectDB();

           String sql ="delete from user where id= ?";
    
        try {
            preparedStatement =con.prepareStatement(sql);
            preparedStatement.setString(1, idLabel.getText());
            preparedStatement.execute();
            
           // JOptionPane.showMessageDialog(null,"Delete add succes");
            
             AlertMaker.showMaterialDialog(stackPane, rootPane, Arrays.asList(oklogout), "Reset Successful", "");
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }finally{
                try {
                    resultSet.close();
                    preparedStatement.close();
                    
                } catch (Exception e) {
                }
            
            }      
         
       
         
         });
        
        AlertMaker.showMaterialDialog(stackPane, rootPane, Arrays.asList(yesRSbtn,nobtn), "Are You Sure Reset?", "If reset please sign in new account");

}

          public void setUser(String id){
            idLabel.setText(id);
          }
    
    private void UpdateTable(){
        idCol.setCellValueFactory(new PropertyValueFactory<tablelist,String>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<tablelist,String>("name"));
        IACol.setCellValueFactory(new PropertyValueFactory<tablelist,String>("ia"));
        
        
        ObservableList<tablelist> listM =DBConnection.getData();
        table.setItems(listM);   
    
    }
    @FXML
    private void add(ActionEvent event){  
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Addmember.fxml"));         
          Parent root;
        try {
           
            root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setOnHidden((e)->{
            UpdateTable();
            search();
           
        });
       
      // MainController ad = loader.getController();
      // ad.setUser(loginIdField.getText());
       AddmemberController amc = loader.getController();
       amc.updateBtn.setVisible(false);
       
  

        stage.setScene(scene);
        stage.show(); 
        
      
        
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    

      int index = -1;
         @FXML
     private void getselect(MouseEvent event){
         
         
         index =table.getSelectionModel().getSelectedIndex();
         if(index <= -1){
             
             return;
         }
         
          viewImage();
         
       
    }
       
      public void viewImage(){
   
          Connection con=DBConnection.ConnectDB();
        try {
            preparedStatement=con.prepareStatement("select img from officers where id =?");
            preparedStatement.setString(1, idCol.getCellData(index).toString());
            resultSet=preparedStatement.executeQuery();
            
            if(resultSet.next()){
             InputStream is = resultSet.getBinaryStream(1);
             OutputStream os = new FileOutputStream(new File("photo.png"));
            byte[] content = new byte[102400];
            int size =0;
            while((size = is.read(content)) != -1){
                   os.write(content, 0, size);
            
            }
            Image imaget = new Image("file:photo.png",image.getFitWidth(),image.getFitHeight(),true,true);
            image.setImage(imaget);
            
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
      ObservableList<tablelist> dataList;
      @FXML
     private void search(){
  
        idCol.setCellValueFactory(new PropertyValueFactory<tablelist,String>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<tablelist,String>("name"));
        IACol.setCellValueFactory(new PropertyValueFactory<tablelist,String>("ia"));
        
        
       
        
        dataList = DBConnection.getData();
        table.setItems(dataList);
        FilteredList<tablelist> filteredData = new FilteredList<>(dataList, b -> true);		
	searchid.textProperty().addListener((observable, oldValue, newValue) -> {
	filteredData.setPredicate(person -> {
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}				
				String lowerCaseFilter = newValue.toLowerCase();
				if (String.valueOf(person.getId()).indexOf(lowerCaseFilter)!=-1) {
					return true; // Filter
				}
                                else if (person.getName().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches username
				}else if (String.valueOf(person.getIa()).indexOf(lowerCaseFilter)!=-1)
				     return true;
                                
				     else  
				    	 return false; // Does not match.
			});
		});		
		SortedList<tablelist> sortedData = new SortedList<>(filteredData);		
		sortedData.comparatorProperty().bind(table.comparatorProperty());		
		table.setItems(sortedData);      
    }
      @FXML
     private void del(ActionEvent event){
       
         
         String sql ="delete from officers where id= ?";
                Connection con=DBConnection.ConnectDB();

           
    
        try {
            preparedStatement =con.prepareStatement(sql);
            preparedStatement.setString(1, idCol.getCellData(index).toString());
            preparedStatement.execute();

            
             AlertMaker.showMaterialDialog(stackPane, rootPane, Arrays.asList(ok), "Delete Successful", "");
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }finally{
                try {
                    resultSet.close();
                    preparedStatement.close();
                    
                } catch (Exception e) {
                }
            
            }   
           
      UpdateTable();
      search();
     
     }
     @FXML
     public void edit(ActionEvent event){
     
       
       
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Addmember.fxml"));         
          Parent root;
        try {
           
            root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setOnHidden((e)->{
            UpdateTable();
            search();
           
        });
       AddmemberController amc = loader.getController();
       amc.setUser(idCol.getCellData(index).toString(), nameCol.getCellData(index).toString(), IACol.getCellData(index).toString());
       amc.img.setImage(image.getImage());
       amc.addid.setEditable(false);
       amc.saveBtn.setVisible(false);
      // MainController ad = loader.getController();
      // ad.setUser(loginIdField.getText());
       
       
  

        stage.setScene(scene);
        stage.show(); 
        
      
        
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     }
    
    
}
