import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javax.swing.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.geometry.Insets;

public class JavaFx extends Application{
	public enum AccountType {Administrator, Guest}
	public void start(Stage primaryStage) {
		String UsernameTrue = "Jonathan";
		String PasswordTrue = "Margulies";
		primaryStage.setTitle("User Authentication");
		GridPane Grid = new GridPane();
		Grid.setAlignment(Pos.CENTER);
		Grid.setHgap(10);
		Grid.setVgap(10);
		Grid.setPadding(new Insets(25, 25, 25, 25));

		Text scenetitle = new Text("Please Authenticate.");
		scenetitle.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		Grid.add(scenetitle,0,0,2,1);

		Label UsernameLabel = new Label("Username");
		Grid.add(UsernameLabel,0,1);
	
		TextField UsernameTxtFld = new TextField();
		Grid.add(UsernameTxtFld,1,1);
		
		Label PasswordLabel = new Label("Password");
		Grid.add(PasswordLabel, 0, 2);

		PasswordField PasswordTxtFld = new PasswordField();
		Grid.add(PasswordTxtFld,1,2);

		Button LoginButton = new Button("Log in");
		LoginButton.setOnAction(new EventHandler<ActionEvent>() {
			String UsernameInput = "";
			String PasswordInput = "";

			@Override	
			public void handle(ActionEvent arg0) {
				UsernameInput = UsernameTxtFld.getText();
				PasswordInput = PasswordTxtFld.getText();
				AccountType[] AccountTypes = {AccountType.Administrator, AccountType.Guest};
				if(UsernameTrue.equals(UsernameInput) && PasswordTrue.equals(PasswordInput)) {
					JFrame Frame1 = new JFrame("My Account Frame");
					Object Selection = "";
					do {
					Selection = (AccountType)JOptionPane.showInputDialog(Frame1, "Please choose an account type", "Account Type Options", JOptionPane.INFORMATION_MESSAGE, null, AccountTypes, AccountTypes[1]);
					} while (Selection!=AccountType.Administrator);
						if(Selection==AccountType.Administrator) {
							System.out.println("Welcome " + UsernameTrue + "!");
						}

				} else {
					JOptionPane.showMessageDialog(null, "Invalid Username or Password!");
				}

			}
		});

		Grid.add(LoginButton,0,3);
		Scene scene = new Scene(Grid, 200, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
	
