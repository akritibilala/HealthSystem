package views;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Login extends Application {

	Label username;
	Label password;
	TextField uText;
	TextField pText;
	Button login;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		username = new Label("Username");
		uText = new TextField();
		password = new Label("Password");
		pText = new TextField();
		login = new Button("Login");

		login.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				login.setText("Hey");
			}
		});
		;

		VBox root = new VBox();
		root.getChildren().add(username);
		root.getChildren().add(uText);
		root.getChildren().add(password);
		root.getChildren().add(pText);
		root.getChildren().add(login);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
