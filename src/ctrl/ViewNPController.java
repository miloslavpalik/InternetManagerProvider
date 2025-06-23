package ctrl;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafxappnetpack2.NetPack;

public class ViewNPController implements Initializable {
    

    IntegerProperty year;
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfLastName;
    @FXML
    private Button saveBtn;
    @FXML
    private Button clearBtn;
    @FXML
    private Button deleteBtn;
    @FXML
    private ChoiceBox<Integer> yearCb = new ChoiceBox<>();
    @FXML
    private ChoiceBox<Integer> speedCb = new ChoiceBox<>();
    @FXML
    private ChoiceBox<Integer> flowCb = new ChoiceBox<>();

    @FXML
    private TableColumn<NetPack, String> columnName;
    @FXML
    private TableColumn<NetPack, String> columnLastName;
    @FXML
    private TableColumn<NetPack, Integer> columnYear;
    @FXML
    private TableColumn<NetPack, Integer> columnSpeed;
    @FXML
    private TableColumn<NetPack, Integer> columnFlow;

    ObservableList<NetPack> list = FXCollections.<NetPack>observableArrayList();
    NetPack netpack;

    @FXML
    TableView<NetPack> tabela = new TableView<>();

    public ViewNPController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        netpack = new NetPack();
        yearCb.getItems().addAll(data.data.year());
        speedCb.getItems().addAll(data.data.speed());
        flowCb.getItems().addAll(data.data.flow());

        columnName = new TableColumn<>("FirstName");
        columnLastName = new TableColumn<>("Last Name");
        columnYear = new TableColumn<>("Year");
        columnSpeed = new TableColumn<>("Speed");
        columnFlow = new TableColumn<>("Flow");

        columnName.setCellValueFactory(new PropertyValueFactory<NetPack, String>("firstName"));
        columnLastName.setCellValueFactory(new PropertyValueFactory<NetPack, String>("lastName"));
        columnYear.setCellValueFactory(new PropertyValueFactory<NetPack,Integer>("year"));
        columnSpeed.setCellValueFactory(new PropertyValueFactory<NetPack,Integer>("speed"));
        columnFlow.setCellValueFactory(new PropertyValueFactory<NetPack,Integer>("flow"));



        
        tfName.textProperty().bindBidirectional(netpack.firstNameProperty());
        tfLastName.textProperty().bindBidirectional(netpack.lastNameProperty());
        yearCb.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                netpack.yearProperty().set(newValue);
            }
        });
        speedCb.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<?extends Integer> observable, Integer oldValue, Integer newValue) {
                netpack.speedProperty().set(newValue);
            }
           
        });
        flowCb.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                netpack.flowProperty().set(newValue);
            }
        });
        
        
        tabela.getColumns().add(columnName);
        tabela.getColumns().add(columnLastName);
        tabela.getColumns().add(columnYear);
        tabela.getColumns().add(columnSpeed);
        tabela.getColumns().add(columnFlow);
    }

    @FXML
    private void saveNP() {
        if(netpack.isValid()){
        list = tabela.getItems();
        list.add(new NetPack(tfName.getText(),tfLastName.getText(),netpack.getYear(),netpack.getSpeed(),netpack.getFlow()));
        tabela.setItems(list);
        }else{
            StringBuilder errMsg = new StringBuilder();

	    ArrayList<String> errList = netpack.errorsProperty().get();
	    for(String errList1 : errList)
		errMsg.append(errList1);
            
	    Alert alert = new Alert(Alert.AlertType.ERROR);
	    alert.setTitle("Error");
	    alert.setContentText(errMsg.toString());
	    alert.showAndWait();
	    errList.clear();
        }
    }
    
    @FXML
    private void deleteNP(){
        list = tabela.getItems();
        int index = tabela.getSelectionModel().getSelectedIndex();
        if(index!=-1){
        list.remove(index);
        tabela.setItems(list);
        }else{
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setTitle("Error");
            al.setContentText("No package selected");
            al.showAndWait();
        }
    }
    @FXML
    private void clearNP(){
        netpack.firstNameProperty().set("");
        netpack.lastNameProperty().set("");
    }
    @FXML
    private void close(){
        Platform.exit();
    }

}
