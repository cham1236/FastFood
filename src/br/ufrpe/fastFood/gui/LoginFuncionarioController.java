package br.ufrpe.fastFood.gui;

import java.net.URL;
import java.util.ResourceBundle;

import br.ufrpe.fastFood.exceptions.ONFException;
import br.ufrpe.fastFood.exceptions.WPException;
import br.ufrpe.fastFood.negocios.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;



public class LoginFuncionarioController implements Initializable {

	@FXML
	private TextField txtLoginF;

	@FXML
	private PasswordField txtSenhaF;

	@FXML
	private Hyperlink esqueceuSenhaF;

	@FXML
	private Button botaoEntrarF;

	@FXML
	private Button botaoSairF;

	@FXML
	private Label avisoF;

	@FXML
	private ImageView imagemF;

	@FXML
	private void botaoEntrarActionF(ActionEvent event) throws ONFException, WPException{

		if (!(txtLoginF.getText().equals("") || txtSenhaF.getText().equals(""))) {

			String login, senha;

			login = txtLoginF.getText();
			senha = txtSenhaF.getText();

			try{

				if(Fachada.getInstancia().loginFuncionario(login, senha)){
					((Node) (event.getSource())).getScene().getWindow().hide();

				}else{
					avisoF.setText("Login ou Senha inv�lido ");
				}

			}catch(ONFException e){
				System.out.println(e.getMessage());
				avisoF.setText("Usu�rio n�o encontrado");
			}

		}else{
			avisoF.setText("Preencha os campos");
		}

	}

	@FXML
	private void botaoSairActionF(ActionEvent event){

		((Node) (event.getSource())).getScene().getWindow().hide();	
		try{
			Parent root = FXMLLoader.load(getClass().getResource("Tela Inicial.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = new Stage();
			primaryStage.setScene(scene);
			primaryStage.setTitle("Tela Incial");
			primaryStage.show();			
		}catch (Exception e){
			System.out.println(e.getMessage());
		}


	}



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Image img = new Image("br/ufrpe/fastFood/gui/LOGO_PROJETO.png");
		this.imagemF.setImage(img);

	}



}