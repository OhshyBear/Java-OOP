package huddleston;

/*
 * File name: HT54Gui.java
 * Author: Trevor Huddleston, 1717354, CS252
 * Date: 04/13/2025
 * This JavaFX application provides a simple email subscription GUI. 
 * Users can enter their email address to join a mailing list. The program 
 * validates input to ensure it contains exactly one '@', no spaces, at least 
 * one '.', and that the last '.' occurs after the '@'. Duplicate emails are 
 * rejected, and appropriate messages are displayed in a read-only TextArea. 
 * The interface uses a BorderPane layout with an HBox containing a Label, 
 * TextField, and Button at the top, and a TextArea at the center. 
 */


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import java.util.ArrayList;

public class HT54Gui extends Application {
	
	//class level variables
	private ArrayList<String> subscribers = new ArrayList<>();
	private TextField email = new TextField();
	private TextArea textArea = new TextArea();
	
	public void start(Stage stage) {		
		//creating components used in the GUI
		BorderPane content = new BorderPane();
		Label mailLabel = new Label("Join our mailing list: ");		
		Button subscribe = new Button("Join");
		HBox top = new HBox(20, mailLabel, email, subscribe);
		
		//set the components inside their respective containers
		Scene scene = new Scene(content);
		content.setTop(top);
		content.setCenter(textArea);
		textArea.setPrefRowCount(2);
		textArea.setWrapText(true);
		textArea.setEditable(false);
		email.setPromptText("Enter your email address");
		subscribe.requestFocus(); // puts the focus on the button so the text shows in the email
		
		subscribe.setOnAction(e -> process());
		
		//stage declarations
		stage.setScene(scene);
		stage.setTitle("HT54 Email Subscription GUI");
		stage.show();
	}
	
	//process button click to get the email entered and add it to the list or report errors in email validation as needed. 
	public void process() {
		String input = email.getText();
		
		
		//check email for input
		if(input == null || input.trim().isEmpty()) {
			textArea.setText("Error: please enter a valid email address");
			email.requestFocus();
			return;
		}
		
		//valid email call
		if(!validEmail(input)) {
			textArea.setText("Error: please enter a valid email address");
			email.requestFocus();
			return;
		}
		
		//checks if subscribers list already has the entered email
		if (subscribers.contains(input)) {
			textArea.setText("Error: \"" + input + "\" is already on our mailing list.");
            email.requestFocus();
            email.selectAll();
            return;
		}
		
		//If valid and not already on list
		subscribers.add(input);
		email.clear();
		email.setPromptText("Enter your email address");
		textArea.setText("Thank you for signing up! You have successfully joined our mailing list. A confirmation email has been sent to \"" + input + "\"");
		return;		
	}
	
	//boolean helper method to check for valid email format
	public boolean validEmail(String input) {
		int atCount = 0;
		
		//ensure no spaces
		if(input.contains(" ")) {
			return false;
		}
		
		//count the @s if more than 1 return false
		for (int i = 0; i < input.length(); ++i) {
			if (input.charAt(i) == '@') {
				atCount++;
			}
		}
				
		if (atCount != 1) {
			return false;
		}
				
		
		//verifies there is at least 1 . and then checks the last index of . greater than @
		if (input.contains(".") && input.lastIndexOf("@") < input.lastIndexOf(".")) {
			textArea.setText("true");
			return true;
		}
		
		//if checks fail
		return false;
	}

	public static void main(String[] args) {
		launch(args);

	}

}
