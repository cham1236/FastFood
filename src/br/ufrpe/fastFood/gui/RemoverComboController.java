package src.br.ufrpe.fastFood.gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import src.br.ufrpe.fastFood.beans.Combo;
import src.br.ufrpe.fastFood.beans.Produto;
import src.br.ufrpe.fastFood.exceptions.ONFException;
import src.br.ufrpe.fastFood.negocios.Fachada;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class RemoverComboController implements Initializable {

	@FXML
	private TableView<Combo> tabela;
	
	@FXML
	private TableColumn<Combo, String> colunaNome;
	
	@FXML
	private TableColumn<Combo, String> colunaid;
	
	@FXML
	private TableColumn<Combo, Double> colunavalor;
	
	@FXML
	private TableColumn<Combo, Produto> colunap1;
	
	@FXML
	private TableColumn<Combo, Produto> colunap2;
	
	@FXML
	private TableColumn<Combo, Produto> colunap3;
	
	@FXML
	private TextField idtxt;
	
	@FXML
	private Button concluir;
	
	@FXML
	private Button sair;
	
	@FXML
	private Label label;
	
	
	@FXML
	private void Sair(ActionEvent event)
	{	
		((Node) (event.getSource())).getScene().getWindow().hide();
		
		try
		{
			Parent root = FXMLLoader.load(getClass().getResource("Remover Produto.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = new Stage();
			primaryStage.setScene(scene);
			primaryStage.setTitle("Cadastro");
			primaryStage.show();
			
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	

	@FXML
	private void Concluir(ActionEvent event)
	{
		String id = idtxt.getText();
		
		if(!id.equals(""))
		{
			try {
				Fachada.getInstancia().removerCombo(id);
				
				((Node) (event.getSource())).getScene().getWindow().hide();
				
				try
				{
					Parent root = FXMLLoader.load(getClass().getResource("Remover Produto.fxml"));
					Scene scene = new Scene(root);
					Stage primaryStage = new Stage();
					primaryStage.setScene(scene);
					primaryStage.setTitle("Cadastro");
					primaryStage.show();
					
				}catch (Exception e){
					System.out.println(e.getMessage());
				}
				
			} catch (ONFException e) {
			
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning Dialog");
				alert.setHeaderText("Impossivel realizar a acao");
				alert.setContentText("Combo com o id " + e.getidObjeto() + " nao existe");	
				alert.showAndWait();
			}
		}
		else
		{
			label.setText("Preencha todos os campos");
		}
	}
	
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		ArrayList<Combo> c = (ArrayList<Combo>) Fachada.getInstancia().listarCombos();
		
		colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		colunaid.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		colunavalor.setCellValueFactory(new PropertyValueFactory<>("valor"));
		colunap1.setCellValueFactory(new PropertyValueFactory<>("p1"));
		colunap2.setCellValueFactory(new PropertyValueFactory<>("p2"));
		colunap3.setCellValueFactory(new PropertyValueFactory<>("p3"));
		
		
		tabela.setItems(FXCollections.observableArrayList(c));
		
	}

}
