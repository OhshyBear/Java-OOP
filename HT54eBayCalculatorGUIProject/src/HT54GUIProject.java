/*
 * File name: HT54GuiProject.java
 * Author: Trevor Huddleston, 1717354, CS252
 * Date: 04/13/2025
 * This GUI project is a personal project for my eBay store to help me calculate the potential earnings of my products after the bulk price,
 * eBay fees. It also takes into account offers that are made on items to help me calculate the earning if an offer is made below the list price
 * to ensure that I am still making a profit by accepting an offer made.
 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class HT54GUIProject extends Application {
	
	private TextField productTF = new TextField();
	private TextField listedTF = new TextField();
	private TextField bulkTF = new TextField();
	private TextField offerTF = new TextField();
	private TextField quantityTF = new TextField();
	private TextField feesTF = new TextField();
	private TextField discountTF = new TextField();
	private TextField profitTF = new TextField();
	private CheckBox save = new CheckBox("Save Item");
	
	public void start(Stage stage) {
		//GUI components : save is never truly used it is intended for part2 where 
		// I create the item for future use so all I have to do is edit the offer made to get faster results 		
		GridPane grid = new GridPane();
		Label title = new Label("eBay Earnings Calculator");
		Label product = new Label("Product Name: ");
		Label listed = new Label("Store Listed Price: ");
		Label bulk = new Label("Product Aquisition Cost: ");
		Label offer = new Label("Proposed Offer Price: ");
		Label quantity = new Label("Quantity: ");
		Label results = new Label("Results will appear below");
		Label fees = new Label("eBay Fees: ");
		Label discount = new Label("% Discount: ");
		Label profit = new Label("Net Profit: ");
		Button calculate = new Button("Calculate Earnings");
		Button clear = new Button("Clear");
		HBox buttonBox = new HBox(30, calculate, clear);
		
		//row 0
		grid.add(product, 0, 0);
		grid.add(productTF, 1, 0);
		grid.add(save, 2, 0);		
		//row1
		grid.add(listed, 0, 1);
		grid.add(listedTF, 1, 1);
		//row 2
		grid.add(bulk, 0, 2);
		grid.add(bulkTF, 1, 2);
		//row 3
		grid.add(offer, 0, 3);
		grid.add(offerTF, 1, 3);
		//row 4
		grid.add(quantity, 0, 4);
		grid.add(quantityTF, 1, 4);
		//row 5
		grid.add(results, 0, 5);
		grid.add(buttonBox, 1, 5);
		//row 6 
		grid.add(fees, 0, 6);
		grid.add(feesTF, 1, 6);
		//row 7 
		grid.add(discount, 0, 7);
		grid.add(discountTF, 1, 7);
		//row 8 
		grid.add(profit, 0, 8);
		grid.add(profitTF, 1, 8);
		
		
		//Set the components
		feesTF.setEditable(false);
		discountTF.setEditable(false);
		profitTF.setEditable(false);
		title.setFont(new Font("Arial", 24));
		title.setPadding(new Insets(10,0,30,0));
		buttonBox.setPadding(new Insets(20,0,0,0));
		grid.setHgap(10);
		grid.setVgap(10);
		VBox root = new VBox(title, grid);
		root.setAlignment(Pos.TOP_CENTER);
		root.setPadding(new Insets(20,20,30,30));
		Scene scene = new Scene(root);
		clear.setOnAction(e -> clearAll());
		calculate.setOnAction(e -> calculateProfit());
		
		//Stage declarations
		stage.setScene(scene);
		stage.setTitle("eBay Earnings Calculator");
		stage.show();
	}
	
	//clear the information entered by the seller
	public void clearAll() {
		productTF.clear();
		listedTF.clear();
		bulkTF.clear();
		offerTF.clear();
		quantityTF.clear();
		feesTF.clear();
		discountTF.clear();
		profitTF.clear();
		save.setSelected(false);
	}
	
	//calculate the fees, discount, and net profit
	public void calculateProfit() {
		
		try {
			double listedPrice = Double.parseDouble(listedTF.getText());
			double bulkPrice = Double.parseDouble(bulkTF.getText());
			double offerAmount = offerTF.getText().isEmpty() ? 0 : Double.parseDouble(offerTF.getText());
			int quantity = Integer.parseInt(quantityTF.getText());	
	
			if (offerAmount > 0) {
				//calculate the fees and profit of an item with an offer made as well as the discount on the offer.
				double offerFee = calculateFees(offerAmount);
				double offerProfit = calculatePotentialProfit(offerAmount, bulkPrice, offerFee) * quantity;
				double discountPercentage = calculateDiscount(listedPrice, offerAmount);
				feesTF.setText(String.format("$%.2f", offerFee));
				profitTF.setText(String.format("$%.2f", offerProfit));
				discountTF.setText(String.format("%.2f", discountPercentage) + "%");
			}else {
				//calculate fees and profit of an item without an offer
				double listFee = calculateFees(listedPrice);
				double listProfit = calculatePotentialProfit(listedPrice, bulkPrice, listFee) * quantity;
				feesTF.setText(String.format("$%.2f", listFee));
				profitTF.setText(String.format("$%.2f", listProfit));
				discountTF.setText("0%");
			}
		}
		catch(NumberFormatException e){
			Alert invalidNumber = new Alert(AlertType.ERROR);
			invalidNumber.setTitle("Input Error");
			invalidNumber.setHeaderText("Please input a Valid Price");
			invalidNumber.setContentText("Valid Prices are formated as 45.99 or 45");
			invalidNumber.showAndWait();
		}
	}
	
	// ebay fees for the majority of orders is set at 13.6% plus 40cents for all orders over $10 
	// there are some exceptions but they dont apply to my store because I dont sell those products
	//this could potentially be expanded upon in the part2 but the current version meets my personal needs
	public double calculateFees(double price) {
		return (price * .136) + 0.40;  
	}
	
	//this is the method to calculate the potential profit made. The acquisition price and the fee can make 
	//for a negative profit some times so this is where the functionality of the program will really shine
	public double calculatePotentialProfit(double amount, double bulkPrice, double fee) {
		return amount - bulkPrice - fee;
	}
	
	// the discount method calculates the % of a discount being offered eBay does not show this until after 
	// you accept an offer and its really annoying I have given over a 15% discount before for a single item
	// due to not having this feature readily available when accepting potential offers.
	public double calculateDiscount(double listedPrice, double offerAmount) {
		return ((listedPrice - offerAmount) / listedPrice) * 100;
	}
	
	
	

	public static void main(String[] args) {
		launch(args);

	}

}
