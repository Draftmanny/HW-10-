/*	In this program i am using the program that was used before which was a loan program.
 * I used javafx for this program to create the GUI for the code. 
 * It will have the user enter there information and have radio buttons 
 * for the term and which account is being created. 
 * After you click the submit button it will open another window and display the information of the 
 * account
 *  
 * 
 * 
 *	Assignment : Chapter 10
 * 	Date:3/27/2023
 * 
 * 
 * @author Manny Villegas
 *
 */


package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;


public class Main extends Application {
	double primeInterest,loanAmountValue;
	int  number,loanTerm;
	String name;
	@Override
	
	public void start(Stage primaryStage) {
		try {
			// Creating a Grid pane to hold labels and text fields for the first window
			GridPane grid = new GridPane();
			GridPane secondGrid = new GridPane();
		    Scene secondScene = new Scene(secondGrid, 750, 200);
		    Stage secondStage = new Stage();
	        secondStage.setScene(secondScene);
			Button submit = new Button("Submit");
			Label intrest = new Label("Intrest:");
			Label lastName = new Label("Enter Last Name");
			Label accNumber = new Label("Enter Account Number");
			Label loanAmount = new Label("Loan Amount:");
			Label accountInformation = new Label("Account Information");
			TextArea accountText = new TextArea();
			accountText.setPrefColumnCount(54);
			accountText.setPrefRowCount(1);
			
			TextField intrestText = new TextField();
			TextField loanText = new TextField();
			TextField accNumText= new TextField();
			TextField lastNameField = new TextField();
			ToggleGroup group = new ToggleGroup();
			// Adding the Labels and text fields to the Grid pane
			grid.add(lastName, 0, 0);
			grid.add(lastNameField, 1, 0);
			grid.add(intrest, 0, 1);
			grid.add(intrestText, 1, 1);
			grid.add(accNumber, 0, 2);
			grid.add(accNumText, 1, 2);
			grid.add(loanAmount, 0, 3);
			grid.add(loanText,1, 3);
			RadioButton term = new RadioButton();
			term.setText("Short Terem");
			term.setToggleGroup(group);
			RadioButton middleTerm = new RadioButton();
			middleTerm.setText(("Middle Term"));
			middleTerm.setToggleGroup(group);
			RadioButton longTerm = new RadioButton();
			longTerm.setText("Long Term");
			longTerm.setToggleGroup(group);
			grid.add(new Text("Enter Loan Length"), 0, 4);
			grid.add(term, 0, 5);
			grid.add(middleTerm, 0, 6);
			grid.add(longTerm, 0, 7);
			// Using radio Buttons to have the user select a personal or business account
			RadioButton personal = new RadioButton("Personal");
			RadioButton business = new RadioButton("Business");
			ToggleGroup bankPick = new ToggleGroup();
			personal.setToggleGroup(bankPick);
			business.setToggleGroup(bankPick);
			grid.add(new Text("Enter Loan Type"), 0, 8);
			grid.add(personal, 0, 9);
			grid.add(business, 1, 9);
			secondGrid.add(accountInformation, 0, 0);
			secondGrid.add(accountText, 1, 0);
			grid.add(submit, 1, 10);
			submit.setOnAction(e->{
				name = lastNameField.getText();
				primeInterest= Double.valueOf(intrestText.getText());
				loanAmountValue= Double.valueOf(loanText.getText());
				number=Integer.valueOf(accNumText.getText());
				
				if(personal.isSelected()) {
					// Checking which one is selected
					// It will use the loan constants depending on whats selected and make it a value 
					if(term.isSelected()) {
						loanTerm= LoanConstants.shortTerm;
					}
					else if (middleTerm.isSelected()) {
						loanTerm= LoanConstants.mediumTerm;
					}
					else if(longTerm.isSelected()) {
						loanTerm = LoanConstants.longTerm;
					}
					// Create an instance of Personal account
					 PersonalLoan acc = new PersonalLoan( number, name, loanAmountValue, loanTerm,primeInterest);
					 //Print the value in a text field and show the window
					 accountText.setText(acc.toString());
					
					 secondStage.show();
					
				}
				// If the Business Radio button is selected it will run this code
				else if(business.isSelected()) {
					// Check which term is selected 
					//It will convert the term selected to the value used in LoaanConstants
					if(term.isSelected()) {
						loanTerm= LoanConstants.shortTerm;
					}
					else if (middleTerm.isSelected()) {
						loanTerm= LoanConstants.mediumTerm;
					}
					else if(longTerm.isSelected()) {
						loanTerm = LoanConstants.longTerm;
					}
					
					// Create a new Instance of the account Selected
					BusinessLoan acc = new BusinessLoan( number, name, loanAmountValue, loanTerm,primeInterest);
					// Print the account to string and showing a new window
					accountText.setText(acc.toString());
				
					secondStage.show();
					
				}
				
				
			});
	
			BorderPane root = new BorderPane();
			root.setCenter(grid);
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
