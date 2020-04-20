//By: Andre Nonaka 
// 2020-04-19
package application;
//importing important packages
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Main extends Application {

	private Label lblPlayer, lblBanker, lblPTotal, lblBTotal, lblChips, lblResult, lbl;  //Declaring Labels
	private TextField txtBet; // declaring textfield as txtBet
	private Button btnDeal, btnBet, btnQuit; //declaring the buttons
	private ImageView[] imgPlayer, imgBanker; //declaring imageviews of player and banker
	private String[] cards; //declaring declaring string cards
	private String[] cardvalue; //declaring string cardvalue
	private String[] cards2; //declaring string cards2
	private String[] cards3; //declaring string cards3
	private String[] cards4; //declaring string cards4
	private int randPos; //declaring int randPos
	private int randPos2; //declaring int randPos2
	private int randPos3;   //declaring int randPos3
	private int randPos4;  //declaring int randPos4
	private int randPos5;  //declaring int randPos5
	private int randPos6;  //declaring int randPos6
	private int sum;  //declaring int sum
	private int first_card; //declaring int first_card
	private int second_card; //declaring int second_card
	private int third_card; //declaring int third_card
	private int fourth_card; //declaring int fourth_card
	private int fifth_card; //declaring int fifth_card
	private int sixth_card; //declaring int sixth_card
	private int sum2; //declaring int sum2
	private int score; //declaring int score
	private int score2; //declaring int score2
	private int ad; //declaring ad
	private Integer result; //declaring Integer result
	private String final_score; //declaring String final_score
	private String final_score2; //declaring String final_score2
	private Button btnSelected; //declaring button btnSelected
	private int clicked; //declaring int clicked
	Scene scene; //Declare scene

	private int yPos = 175; //declaring int yPos

	public void start(Stage primaryStage) {

		try {	
			
		    Random random = new Random(); //declaring random to randomize numbers
		    //declaring string of cards reffering to the pictures
			cards = new String[] {"10C", "10D", "10H","10S","11C","11D","11H","11S",
					"12C","12D","12H","12S","13C", "13D", "13H","13S","14C", "14D", "14H","14S","2C", "2D", "2H","2S","3C", "3D", "3H","3S","4C", "4D", "4H","4S","5C", "5D", "5H","5S","6C", "6D", "6H","6S","7C", "7D", "7H","7S","8C", "8D", "8H","8S","9C", "9D", "9H","9S"};
			//declaring string of cardvalues to set each cardvalue to the corresponding card above
			cardvalue = new String[] {"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","1","1","1","1","2","2","2","2","3","3","3","3","4","4","4","4","5","5","5","5","6","6","6","6","7","7","7","7","8","8","8","8","9","9","9","9"}; 
			Random rgen = new Random(); //declaring rgen to randomize numbers
		    Random rgen2 = new Random(); //declaring rgen2 to randomize numbers
		    Random rgen3 = new Random(); //declaring rgen3 to randomize numbers
		    Random rgen4 = new Random(); //declaring rgen4 to randomize numbers
		    Random rgen5 = new Random();//declaring rgen5 to randomize numbers
		    Random rgen6 = new Random(); //declaring rgen6 to randomize numbers
			Image imgTitle = new Image("file:images/baccarat1.png"); //declaring imgTitle as image
			ImageView iviewTitle = new ImageView(imgTitle); //declaring iviewTitle as ImageView setting from imgTitle

			final int SCENE_WIDTH = 1000; //declaring scene width as 1000

			ImageView iviewBack = new ImageView(new Image("file:images/card_table.jpg")); //declaring ImageView as ivewBack
			lbl = new Label(); //declaring lbl
			lbl.setText("$"); //setting the text of the lbl
			lbl.setPrefSize(175, 40); //setting the size of the lbl
			lbl.setAlignment(Pos.CENTER); //setting the alignement of the lbl
			lbl.setFont(Font.font("System", FontWeight.BOLD, 36)); //setting the font of the lbl
			lbl.setTextFill(Color.WHITE); //seting the color of the lbl

			lblChips = new Label(); //declaring the lbl
			lblChips.setText("500"); //setting the text of the lbl
			lblChips.setPrefSize(175, 40);//setting the size of the lbl
			lblChips.setAlignment(Pos.CENTER); //setting the alignement of the lbl
			lblChips.setFont(Font.font("System", FontWeight.BOLD, 36)); //setting the font of the lbl
			lblChips.setTextFill(Color.WHITE);//setting the color of the lbl
			lblChips.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, 
					BorderWidths.DEFAULT, new Insets(0, 0, 0, 0)))); //setting the border of the label

			lblPlayer = new Label("Player has:"); //declaring lbl
			lblPlayer.setFont(Font.font("System", FontWeight.BOLD, 18));//setting the font of the lbl
			lblPlayer.setAlignment(Pos.CENTER);//setting the alignement of the lbl
			lblPlayer.setPrefSize(150, 40);//setting the size of the lbl
			lblPlayer.setTextFill(Color.WHITE);//setting the color of the lbl

			lblBanker = new Label("Banker has:"); //declaring lbl
			lblBanker.setFont(Font.font("System", FontWeight.BOLD, 18));//setting the font of the lbl
			lblBanker.setAlignment(Pos.CENTER);//setting the alignement of the lbl
			lblBanker.setPrefSize(150, 40);//setting the size of the lbl
			lblBanker.setTextFill(Color.WHITE);//setting the color of the lbl

			lblPTotal = new Label();//declaring lbl
			lblPTotal.setFont(Font.font("System", FontWeight.BOLD, 28));//setting the font of the lbl
			lblPTotal.setAlignment(Pos.CENTER);//setting the alignement of the lbl
			lblPTotal.setTextFill(Color.WHITE);//setting the color of the lbl
			lblPTotal.setPrefSize(150, 40);//setting the size of the lbl
			lblPTotal.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, 
					BorderWidths.DEFAULT, null)));//setting the border of the label

			lblBTotal = new Label();//declaring lbl
			lblBTotal.setFont(Font.font("System", FontWeight.BOLD, 28));//setting the font of the lbl
			lblBTotal.setAlignment(Pos.CENTER);//setting the alignement of the lbl
			lblBTotal.setTextFill(Color.WHITE);//setting the color of the lbl
			lblBTotal.setPrefSize(150, 40);//setting the size of the lbl
			//setting the border of the label
			lblBTotal.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, null)));

			lblResult = new Label();//declaring lbl
			lblResult.setPrefSize(200, 40);//setting the size of the lbl
			lblResult.setFont(Font.font("System", FontWeight.BOLD, 18));//setting the font of the lbl
			lblResult.setTextFill(Color.WHITE);//setting the color of the lbl
			lblResult.setText("Place BET to begin!"); //setting the text of the label
			lblResult.setAlignment(Pos.CENTER); //setting the alignement of the lbl

			txtBet = new TextField(); //setting the textfield of the txtBet
			txtBet.setEditable(true); //setting the textfield to editable
			txtBet.setAlignment(Pos.CENTER); //setting the allignment of the txtBet
			txtBet.setPrefSize(120, 40); //setting the size of the textfield
			txtBet.setMaxSize(120, 40); //setting the maxSize of the textfield

			btnBet = new Button("PLACE BET"); //declaring the button 
			btnBet.setPrefSize(120, 40); //declaring size
			btnBet.setFocusTraversable(false);  //setting button settings to false

			btnQuit = new Button("QUIT"); //declaring the button 
			btnQuit.setPrefSize(120, 40); //setting the button size 
			btnQuit.setFocusTraversable(false); //setting button settings to false
			btnQuit.setOnAction(new EventHandler<ActionEvent>() { //setting button actione event
				public void handle(ActionEvent e) {
						Alert alert = new Alert(AlertType.CONFIRMATION);//declaring alert and setting it to CONFIRMATION alert
						alert.setContentText("Are you sure you want to exit?");//Alert pop up that says the following
						alert.setHeaderText(null);//Alert pop up with no headertext
						alert.getButtonTypes().clear();
						alert.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);//adding the yes or no button when asked to quit
		    			alert.setTitle("Baccarat");//set the title of the alert to the following
						Optional<ButtonType> result = alert.showAndWait();//gets results returned and compares it
						if(result.get() == ButtonType.YES) { //if user presses no then do following
							System.exit(0);//exit program
						}
						else
						{
							e.consume();//do noting resume program
						}
						}
						});

			btnDeal = new Button("DEAL"); //declaring button
			btnDeal.setPrefSize(120, 40); //declaring button size
			btnDeal.setDisable(true); //disabling the button
			btnDeal.setFocusTraversable(false); //setting button settings to false			
			btnBet.setOnAction(new EventHandler<ActionEvent>() { //declaring button action event
				public void handle(ActionEvent e) {
					try {
						ad = Integer.parseInt(txtBet.getText());  //parsing the text from textfield to an int and declaring as ad
						if(ad <= Integer.valueOf(lblChips.getText()) && ad>=1) //if ad  is less than Integer value of the lblChips text and is greater than 1
						{
							btnBet.setDisable(true); //disable button 
							btnDeal.setDisable(false); //enable button
							lblResult.setText("Click DEAL!"); //setting text of label
							txtBet.setEditable(false); //setting so you cannot edit
						}
						if(ad> Integer.valueOf(lblChips.getText())) //if statement 
								{
							Alert alert = new Alert(AlertType.ERROR);//declaring alert and setting it to ERROR alert
							alert.setHeaderText(null);//Alert pop up with no headertext
							alert.setContentText("Your bet cannot exceed" + " $" + Integer.valueOf(lblChips.getText()) + "!");//Alert pop up that says the following
							alert.setTitle("Invalid bet!");//set the title of the alert to the following
							alert.showAndWait();
								}
						if(ad<1)
						{
							Alert alert = new Alert(AlertType.ERROR);//declaring alert and setting it to ERROR alert
							alert.setHeaderText(null);//Alert pop up with no headertext
							alert.setContentText("You must bet at least $1!");//Alert pop up that says the following
							alert.setTitle("Invalid bet!");//set the title of the alert to the following
							alert.showAndWait();

						}
						if(txtBet.getText().trim().isEmpty())
						{
							Alert alert = new Alert(AlertType.ERROR);//declaring alert and setting it to ERROR alert
							alert.setHeaderText(null);//Alert pop up with no headertext
							alert.setContentText("You must enter a number");//Alert pop up that says the following
							alert.setTitle("Invalid bet!");//set the title of the alert to the following
							alert.showAndWait();
						}

					} catch (NumberFormatException b) {
						Alert alert = new Alert(AlertType.ERROR);//declaring alert and setting it to ERROR alert
						alert.setHeaderText(null);//Alert pop up with no headertext
						alert.setContentText("You must enter an integer!");//Alert pop up that says the following
						alert.setTitle("Invalid bet!");//set the title of the alert to the following
						alert.showAndWait();
					    // One of the integer fields failed to parse. Do something to alert the user.
					}
				}
			});
	        
			imgPlayer = new ImageView[3];// declare image array 

			for (int i = 0; i < imgPlayer.length; i++) //for loop for image
			{
				imgPlayer[i] = new ImageView("file:images/back_blue.png"); //setting the image of imagePlayer array
				StackPane.setMargin(imgPlayer[i], new Insets(yPos, 0, 0, 250));
				yPos += 75; //setting the yposition
			}

			yPos = 175;//declaring yPos = 175

			imgBanker = new ImageView[3];// declare image array 

			for (int i = 0; i < 3; i++)//for loop for image
			{
				imgBanker[i] = new ImageView("file:images/back_blue.png");//setting the image of imagePlayer array
				StackPane.setMargin(imgBanker[i], new Insets(yPos, 0, 0, 600));
				yPos += 75;//setting the yposition
			}
		     clicked = 0;

			btnDeal.setOnAction(new EventHandler<ActionEvent>() { //setting button action event
				public void handle(ActionEvent e) {
			        
				        randPos = rgen.nextInt(cards.length); //declaring randPos as the randomized integer length of cards
				        randPos2 = rgen2.nextInt(cards.length);//declaring randPos2 as the randomized integer length of cards
				        randPos5 = rgen5.nextInt(cards.length);//declaring randPos5 as the randomized integer length of cards

				        
					imgPlayer[0].setImage(new Image("file:images/" + 
							cards[randPos] + ".png")); //setting first card image of player to following
					imgPlayer[0].setId(cardvalue[randPos]);//setting the value of the card 
					int first_card = Integer.valueOf(imgPlayer[0].getId()); //getting value of the card and storing in first_card as int
					imgPlayer[1].setImage(new Image("file:images/" + 
							cards[randPos2] + ".png"));//setting second card image of player to following
					imgPlayer[1].setId(cardvalue[randPos2]);//setting the value of the card 
					int second_card = Integer.valueOf(imgPlayer[1].getId());//getting value of the card and storing in second_card as int
                     sum = first_card + second_card; //getting the sum of both cards
                     score = sum % 10; //getting the score by modulus of the sum 
                     final_score = Integer.toString(score); //geting the integer value of the string 

                     lblPTotal.setText(final_score); //setting the label text
         			if(lblPTotal.getText().equals("9")) //if label text is equal to 9
        			{
         				result = Integer.valueOf(lblChips.getText());	 //gettng the integer value of lblChips text and declaring it as an int called result	

         				int b = result + ad; //adding both and storing as int b
         			    String str4 = new Integer(b).toString(); //converting from Integer of int b to String and declaring as String str4
         				lblChips.setText(str4); //setting the text of lblChips
        				lblResult.setText("Player wins!"); //setting the text of the lblResult to the following
        				btnBet.setDisable(false); //enabling the button
        				btnDeal.setDisable(true);//disabling the button
						txtBet.setEditable(true);//setting so you can the text
						btnDeal.setText("DEAL"); //setting the text of the button
        			}
				        randPos3 = rgen3.nextInt(cards.length); //declaring randPos3 as the randomized integer length of cards
				        randPos4 = rgen4.nextInt(cards.length); //declaring randPos4 as the randomized integer length of cards
				        randPos6 = rgen6.nextInt(cards.length);//declaring randPos6 as the randomized integer length of cards
                    //setting image of the first banker card
					imgBanker[0].setImage(new Image("file:images/" + 
							cards[randPos3] + ".png"));

					imgBanker[0].setId(cardvalue[randPos3]);//setting the value of the card 
					int third_card = Integer.valueOf(imgBanker[0].getId()); //getting the value of the card and storing it in third_card

					   //setting image of the second banker card
					imgBanker[1].setImage(new Image("file:images/" + 
							cards[randPos4] + ".png")); 
					imgBanker[1].setId(cardvalue[randPos4]);//setting the value of the card 

					int fourth_card = Integer.valueOf(imgBanker[1].getId()); //getting the value of the card and storing it in fourth_card

                    int sum2 = third_card + fourth_card; //getting the sum of the banker 
                    int score2 = sum2 % 10; //getting the score of the banker by modulus of 10
                    String final_score2 = Integer.toString(score2); //converting from Integer to String and storing it as final_string
                    lblBTotal.setText(final_score2); //setting the text of the label
                    //if statement 
                    if((score == 6 || score == 7 || score == 8) && (score2 ==5 || score2 == 4|| score2 == 3 ||  score2 == 2 ||  score2 == 1 ||  score2 == 0))
                   	{ 
         				lblResult.setText("Draw one more card!"); //set the text of the label
        				btnDeal.setText("DRAW CARD");    //set the text of the button
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){ //button action event
        				public void handle(ActionEvent event2)
                        {
        					   //setting image of the last banker card
            				imgBanker[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));

           					imgBanker[2].setId(cardvalue[randPos6]);//setting the value of the card 
           					sixth_card = Integer.valueOf(imgBanker[2].getId());	 //getting the value of the card and storing it in sixth_card
           				 sum = first_card + second_card; //getting the sum of both cards
        					int sum2  = third_card + fourth_card + sixth_card;//getting the sum of three cards
        					 score = sum % 10;//getting the score by modulus of the sum 
                            int score2 = sum2 % 10;//getting the score by modulus of the second sum2
                             final_score = Integer.toString(score); //geting the integer value of the string 
                            String final_score2 = Integer.toString(score2); //geting the integer value of the string 

                             lblPTotal.setText(final_score); //setting the label text
                             lblBTotal.setText(final_score2); //setting the label text
                             
                             if(score > score2) //if the player score is greater than banker score then do
                             {
                           	  Integer result1 = Integer.valueOf(lblChips.getText()); //gettng the integer value of lblChips text and declaring it as an int called result1
              				int a = result1 + ad;  //adding both and storing as int a
              			    String str5 = new Integer(a).toString(); //converting from Integer of int a to String and declaring as String str5
              				lblChips.setText(str5);//setting the text of lblChips
           				lblResult.setText("Player wins!");//setting the text of the lblResult to the following
         				btnBet.setDisable(false);//enabling the button
         				btnDeal.setDisable(true);//disabling the button
         				txtBet.setEditable(true);//setting so you can the text
         				btnDeal.setText("DEAL");//setting the text of the button
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
        				public void handle(ActionEvent event3)//setting button action event
                        {
            				imgBanker[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of banker to following
        				run(); //run method
        				//STARTS
        				}
        				});
                             }
        				//SECOND
                             if( score2 > score)  //if the player score is less than banker score then do
                             {
                           	 Integer result1 = Integer.valueOf(lblChips.getText());//gettng the integer value of lblChips text and declaring it as an int called result1
              				int a = result1 - ad; //adding both and storing as int a
              			    String str5 = new Integer(a).toString(); //converting from Integer of int a to String and declaring as String str5
              				lblChips.setText(str5); //setting the text of lblChips
           				lblResult.setText("Banker wins!"); //setting the text of the lblResult to the following
         				btnBet.setDisable(false);//enabling the button
         				btnDeal.setDisable(true);//disabling the button
         				txtBet.setEditable(true);//setting so you can the text
         				btnDeal.setText("DEAL"); //setting the text of the button
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){//setting button action event
        				public void handle(ActionEvent event3)
        				{
        					imgBanker[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of banker to following
        					run(); //run method
        				}
    				});
                             }
                             //THIRD
                             if(score == score2)//if the player score is equal to banker score then do
                             {
                 				lblResult.setText("TIE"); //set label result to TIE
                 				btnBet.setDisable(false);//enabling the button
                 				btnDeal.setDisable(true);//disabling the button
                 				txtBet.setEditable(true);//setting so you can the text
                 				btnDeal.setText("DEAL");//setting the text of the button
                 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
                    				public void handle(ActionEvent event3)//setting button action event
                    				{
                    					run(); //run method
                    					imgBanker[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of banker to following
                    				}
                 				});

                             }
      
        				}
                   	});
                   	}
                    if(score == 5 || score == 4 || score ==3 || score == 2 || score == 1 || score ==0)
                   	{ 
         				lblResult.setText("Draw one more card!"); //set the text of the label
        				btnDeal.setText("DRAW CARD");    //set the text of the button
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){ //button action event
        				public void handle(ActionEvent event2)
                        {
            				imgPlayer[2].setImage(new Image("file:images/" + cards[randPos6] + ".png")); //setting image of the last player card

            				imgPlayer[2].setId(cardvalue[randPos6]);//setting the value of the card 
           					sixth_card = Integer.valueOf(imgPlayer[2].getId());	//getting the value of the card and storing it in sixth_card
           				 sum = first_card + second_card + sixth_card;//getting the sum of three cards
        					int sum2  = third_card + fourth_card;//getting the sum of three cards
        					 score = sum % 10;//getting the score by modulus of the sum 
                            int score2 = sum2 % 10;//getting the score by modulus of the second sum2
                             final_score = Integer.toString(score);//geting the integer value of the string 
                            String final_score2 = Integer.toString(score2);//geting the integer value of the string 

                             lblPTotal.setText(final_score);//setting the label text
                             lblBTotal.setText(final_score2);//setting the label text
                             
                             if(score > score2) //if the player score is greater than banker score then do
                             {
                           	  Integer result1 = Integer.valueOf(lblChips.getText()); //getting the integer value of lblChips text and declaring it as an int called result1	
              				int a = result1 + ad; //adding both and storing as int a
              			    String str5 = new Integer(a).toString(); //converting from Integer of int a to String and declaring as String str5
              				lblChips.setText(str5);//setting the text of lblChips
           				lblResult.setText("Player wins!");//setting the text of the lblResult to the following
         				btnBet.setDisable(false);//enabling the button
         				btnDeal.setDisable(true);//disabling the button
         				txtBet.setEditable(true);//setting so you can the text
         				btnDeal.setText("DEAL");//setting the text of the button
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){//setting button action event
        				public void handle(ActionEvent event3)
                        {
            				imgPlayer[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of player to following
        				run();//run method
        				//STARTS
        				}
        				});
                             }
        				//SECOND
                             if( score2 > score)//if the player score is less than banker score then do
                             {
                           	 Integer result1 = Integer.valueOf(lblChips.getText());	//getting the integer value of lblChips text and declaring it as an int called result1
              				int a = result1 - ad; //adding both and storing as int a
              			    String str5 = new Integer(a).toString();  //converting from Integer of int a to String and declaring as String str5
              				lblChips.setText(str5);//setting the text of lblChips
           				lblResult.setText("Banker wins!"); //setting the text of the lblResult to the following
         				btnBet.setDisable(false);//enabling the button
         				btnDeal.setDisable(true);//disabling the button
         				txtBet.setEditable(true);//setting so you can the text
         				btnDeal.setText("DEAL");//setting the text of the button
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){//setting button action event
        				public void handle(ActionEvent event3)
        				{
        					imgPlayer[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of player to following
        					run();//run method
        				}
    				});
                             }
                             //THIRD
                             if(score == score2)//if the player score is equal to banker score then do
                             {
                 				lblResult.setText("TIE"); //set label result to TIE
                 				btnBet.setDisable(false);//enabling the button
                 				btnDeal.setDisable(true);//disabling the button
                 				txtBet.setEditable(true);//setting so you can the text
                 				btnDeal.setText("DEAL");//setting the text of the button
                 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){//setting button action event
                    				public void handle(ActionEvent event3)
                    				{
                    					run();//run method
                    					imgPlayer[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of Player to following
                    				}
                 				});

                             }
      
        				}
                   	});
                   	}
                    if((score == 5 || score == 4 || score ==3 || score == 2 || score == 1 || score ==0) && (score2 ==0 || score2 == 1|| score2 == 2))
                   	{ 
         				lblResult.setText("Draw one more card!");//set the text of the label
        				btnDeal.setText("DRAW CARD"); //set the text of the button  
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){//button action event
        				public void handle(ActionEvent event2)
                        {
        					//setting image of the last banker card
            				imgBanker[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));

            				imgBanker[2].setId(cardvalue[randPos6]);//setting the value of the card 
            				imgPlayer[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));//setting image of the last player card

            				imgPlayer[2].setId(cardvalue[randPos6]);//setting the value of the card 
           					sixth_card = Integer.valueOf(imgBanker[2].getId());	//getting the value of the card and storing it in sixth_card
           					fifth_card = Integer.valueOf(imgPlayer[2].getId());	//getting the value of the card and storing it in fifth_card
           				 sum = first_card + second_card + fifth_card;//getting the sum of three cards
        					int sum2  = third_card + fourth_card + sixth_card;//getting the sum of three cards
        					 score = sum % 10;//getting the score by modulus of the sum 
                            int score2 = sum2 % 10;//getting the score by modulus of the second sum2
                             final_score = Integer.toString(score);//geting the integer value of the string 
                            String final_score2 = Integer.toString(score2);//geting the integer value of the string 

                             lblPTotal.setText(final_score); //setting the label text
                             lblBTotal.setText(final_score2); //setting the label text
                             
                             if(score > score2) //if the player score is greater than banker score then do
                             {
                           	  Integer result1 = Integer.valueOf(lblChips.getText());//gettng the integer value of lblChips text and declaring it as an int called result1	
              				int a = result1 + ad; //adding both and storing as int a
              			    String str5 = new Integer(a).toString(); //converting from Integer of int a to String and declaring as String str5
              				lblChips.setText(str5);//setting the text of lblChips
           				lblResult.setText("Player wins!");//setting the text of the lblResult to the following
         				btnBet.setDisable(false);//enabling the button
         				btnDeal.setDisable(true);//disabling the button
         				txtBet.setEditable(true);//setting so you can the text
         				btnDeal.setText("DEAL");//setting the text of the button
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){//setting button action event
        				public void handle(ActionEvent event3)
                        {
            				imgPlayer[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of player to following
            				imgBanker[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of banker to following
        				run();//run method
        				//STARTS
        				}
        				});
                             }
        				//SECOND
                             if( score2 > score)//if the player score is less than banker score then do
                             {
                           	 Integer result1 = Integer.valueOf(lblChips.getText());	//gettng the integer value of lblChips text and declaring it as an int called result1	
              				int a = result1 - ad;//adding both and storing as int a
              			    String str5 = new Integer(a).toString(); //converting from Integer of int a to String and declaring as String str5
              				lblChips.setText(str5);//setting the text of lblChips
           				lblResult.setText("Banker wins!");  //setting the text of the lblResult to the following
         				btnBet.setDisable(false);//enabling the button
         				btnDeal.setDisable(true);//disabling the button
         				txtBet.setEditable(true);//setting so you can the text
         				btnDeal.setText("DEAL");//setting the text of the button
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){//setting button action event
        				public void handle(ActionEvent event3)
        				{
            				imgPlayer[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of player to following
        					imgBanker[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of banker to following
        					run(); //run method
        				}
    				});
                             }
                             //THIRD
                             if(score == score2)//if the player score is equal to banker score then do
                             {
                 				lblResult.setText("TIE");//set label result to TIE
                 				btnBet.setDisable(false);//enabling the button
                 				btnDeal.setDisable(true);//disabling the button
                 				txtBet.setEditable(true);//setting so you can the text
                 				btnDeal.setText("DEAL");//setting the text of the button
                 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
                    				public void handle(ActionEvent event3)//setting button action event
                    				{
                    					imgPlayer[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of Player to following
                    					imgBanker[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of banker to following
                    					run();//run method
                    				}
                 				});

                             }
      
        				}
                   	});
                   	}
                    if((score == 7 || score == 6 || score == 5 || score == 4 || score ==3 || score == 2 || score == 1 || score ==0) && (score2 == 3))
                   	{ 
         				lblResult.setText("Draw one more card!");//set the text of the label
        				btnDeal.setText("DRAW CARD");   //set the text of the button 
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){//button action event
        				public void handle(ActionEvent event2)
                        {
        					 //setting image of the last banker card
            				imgBanker[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));//setting image of the last banker card 

            				imgBanker[2].setId(cardvalue[randPos6]);//setting the value of the card 
            				imgPlayer[2].setImage(new Image("file:images/" + cards[randPos6] + ".png")); //setting image of the last player card

            				imgPlayer[2].setId(cardvalue[randPos6]);//setting the value of the card 
           					sixth_card = Integer.valueOf(imgBanker[2].getId());	//getting the value of the card and storing it in sixth_card
           					fifth_card = Integer.valueOf(imgPlayer[2].getId());	//getting the value of the card and storing it in fifth_card
           				 sum = first_card + second_card + fifth_card;//getting the sum of the three cards
        					int sum2  = third_card + fourth_card + sixth_card;//getting the sum of three cards
        					 score = sum % 10;//getting the score by modulus of the sum 
                            int score2 = sum2 % 10;//getting the score by modulus of the second sum2
                             final_score = Integer.toString(score);//geting the integer value of the string 
                            String final_score2 = Integer.toString(score2);//geting the integer value of the string 

                             lblPTotal.setText(final_score);//setting the label text
                             lblBTotal.setText(final_score2);//setting the label text
                             
                             if(score > score2)//if the player score is greater than banker score then do
                             {
                           	  Integer result1 = Integer.valueOf(lblChips.getText());//gettng the integer value of lblChips text and declaring it as an int called result1		
              				int a = result1 + ad;//adding both and storing as int a
              			    String str5 = new Integer(a).toString();  //converting from Integer of int a to String and declaring as String str5
              				lblChips.setText(str5);//setting the text of lblChips
           				lblResult.setText("Player wins!");//setting the text of the lblResult to the following
         				btnBet.setDisable(false);//enabling the button
         				btnDeal.setDisable(true);//disabling the button
         				txtBet.setEditable(true);//setting so you can the text
         				btnDeal.setText("DEAL");//setting the text of the button
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
        				public void handle(ActionEvent event3)//setting button action event
                        {
            				imgPlayer[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of player to following
            				imgBanker[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of banker to following
        				run();//run method
        				//STARTS
        				}
        				});
                             }
        				//SECOND
                             if( score2 > score) //if the player score is less than banker score then do
                             {
                           	 Integer result1 = Integer.valueOf(lblChips.getText()); //getting the integer value of lblChips text and declaring it as an int called result1
              				int a = result1 - ad;//adding both and storing as int a
              			    String str5 = new Integer(a).toString(); //converting from Integer of int a to String and declaring as String str5
              				lblChips.setText(str5);//setting the text of lblChips
           				lblResult.setText("Banker wins!"); //setting the text of the lblResult to the following
         				btnBet.setDisable(false);//enabling the button
         				btnDeal.setDisable(true);//disabling the button
         				txtBet.setEditable(true);//setting so you can the text
         				btnDeal.setText("DEAL");//setting the text of the button
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){//setting button action event
        				public void handle(ActionEvent event3)
        				{
            				imgPlayer[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of player to following
        					imgBanker[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of banker to following
        					run();
        				}
    				});
                             }
                             //THIRD
                             if(score == score2)//if the player score is equal to banker score then do
                             {
                 				lblResult.setText("TIE"); //set label result to TIE
                 				btnBet.setDisable(false);//enabling the button
                 				btnDeal.setDisable(true);//disabling the button
                 				txtBet.setEditable(true);//setting so you can the text
                 				btnDeal.setText("DEAL");//setting the text of the button
                 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
                    				public void handle(ActionEvent event3)//setting button action event
                    				{
                    					imgPlayer[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of player to following
                    					imgBanker[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of banker to following
                    					run();
                    				}
                 				});

                             }
      
        				}
                   	});
                   	}
                    if((score == 7 || score == 6 || score == 5 || score == 4 || score ==3 || score == 2 ) && (score2 == 4))
                   	{ 
         				lblResult.setText("Draw one more card!"); //set the text of the label
        				btnDeal.setText("DRAW CARD");    //set the text of the button
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){//button action event
        				public void handle(ActionEvent event2)
                        {
        					 //setting image of the last banker card
            				imgBanker[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));

            				imgBanker[2].setId(cardvalue[randPos6]);//setting the value of the card 
            				imgPlayer[2].setImage(new Image("file:images/" + cards[randPos6] + ".png")); //setting image of the last player card

            				imgPlayer[2].setId(cardvalue[randPos6]);//setting the value of the card 
           					sixth_card = Integer.valueOf(imgBanker[2].getId());	//getting the value of the card and storing it in sixth_card
           					fifth_card = Integer.valueOf(imgPlayer[2].getId());	//getting the value of the card and storing it in fifth_card
           				 sum = first_card + second_card + fifth_card;//getting the sum of three cards
        					int sum2  = third_card + fourth_card + sixth_card;//getting the sum of three cards
        					 score = sum % 10;//getting the score by modulus of the sum 
                            int score2 = sum2 % 10;//getting the score by modulus of the second sum2
                             final_score = Integer.toString(score);//geting the integer value of the string 
                            String final_score2 = Integer.toString(score2);//geting the integer value of the string 

                             lblPTotal.setText(final_score); //setting the label text
                             lblBTotal.setText(final_score2); //setting the label text
                             
                             if(score > score2)//if the player score is greater than banker score then do
                             {
                           	  Integer result1 = Integer.valueOf(lblChips.getText());//gettng the integer value of lblChips text and declaring it as an int called result1
              				int a = result1 + ad; //adding both and storing as int a
              			    String str5 = new Integer(a).toString(); //converting from Integer of int a to String and declaring as String str5
              				lblChips.setText(str5);//setting the text of lblChips
           				lblResult.setText("Player wins!");//setting the text of the lblResult to the following
         				btnBet.setDisable(false);//enabling the button
         				btnDeal.setDisable(true);//disabling the button
         				txtBet.setEditable(true);//setting so you can the text
         				btnDeal.setText("DEAL");//setting the text of the button
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
        				public void handle(ActionEvent event3)//setting button action event
                        {
            				imgPlayer[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of Player to following
            				imgBanker[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of banker to following
        				run();//run method
        				//STARTS
        				}
        				});
                             }
        				//SECOND
                             if( score2 > score)//if the player score is less than banker score then do
                             {
                           	 Integer result1 = Integer.valueOf(lblChips.getText());	//gettng the integer value of lblChips text and declaring it as an int called result1	
              				int a = result1 - ad;//adding both and storing as int a
              			    String str5 = new Integer(a).toString(); //converting from Integer of int a to String and declaring as String str5
              				lblChips.setText(str5);//setting the text of lblChips
           				lblResult.setText("Banker wins!"); //setting the text of the lblResult to the following
         				btnBet.setDisable(false);//enabling the button
         				btnDeal.setDisable(true);//disabling the button
         				txtBet.setEditable(true);//setting so you can the text
         				btnDeal.setText("DEAL");//setting the text of the button
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){//setting button action event
        				public void handle(ActionEvent event3)
        				{
            				imgPlayer[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of player to following
        					imgBanker[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of banker to following
        					run();//run method
        				}
    				});
                             }
                             //THIRD
                             if(score == score2)//if the player score is equal to banker score then do
                             {
                 				lblResult.setText("TIE");//set label result to TIE
                 				btnBet.setDisable(false);//enabling the button
                 				btnDeal.setDisable(true);//disabling the button
                 				txtBet.setEditable(true);//setting so you can the text
                 				btnDeal.setText("DEAL");//setting the text of the button
                 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
                    				public void handle(ActionEvent event3)//setting button action event
                    				{
                    					imgPlayer[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of player to following
                    					imgBanker[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of banker to following
                    					run();
                    				}
                 				});

                             }
      
        				}
                   	});
                   	}
                    if((score == 7 || score == 6 || score == 5 || score == 4) && (score2 == 5))
                   	{ 
         				lblResult.setText("Draw one more card!");//set the text of the label
        				btnDeal.setText("DRAW CARD");    //set the text of the button
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){//button action event
        				public void handle(ActionEvent event2)
                        {
        					 //setting image of the last banker card
            				imgBanker[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));

            				imgBanker[2].setId(cardvalue[randPos6]);//setting the value of the card 
            				imgPlayer[2].setImage(new Image("file:images/" + cards[randPos6] + ".png")); //setting image of the last player card


            				imgPlayer[2].setId(cardvalue[randPos6]);//setting the value of the card 
           					sixth_card = Integer.valueOf(imgBanker[2].getId());	//getting the value of the card and storing it in sixth_card
           					fifth_card = Integer.valueOf(imgPlayer[2].getId());	//getting the value of the card and storing it in fifth_card
           				 sum = first_card + second_card + fifth_card;//getting the sum of three cards
        					int sum2  = third_card + fourth_card + sixth_card;//getting the sum of both cards
        					 score = sum % 10;//getting the score by modulus of the sum 
                            int score2 = sum2 % 10;//getting the score by modulus of the second sum2
                             final_score = Integer.toString(score);//geting the integer value of the string 
                            String final_score2 = Integer.toString(score2);//geting the integer value of the string 

                             lblPTotal.setText(final_score);//setting the label text
                             lblBTotal.setText(final_score2); //setting the label text
                             
                             if(score > score2)//if the player score is greater than banker score then do
                             {
                           	  Integer result1 = Integer.valueOf(lblChips.getText());	//getting the integer value of lblChips text and declaring it as an int called result1	
              				int a = result1 + ad;//adding both and storing as int a
              			    String str5 = new Integer(a).toString(); //converting from Integer of int a to String and declaring as String str5
              				lblChips.setText(str5);//setting the text of lblChips
           				lblResult.setText("Player wins!");//setting the text of the lblResult to the following
         				btnBet.setDisable(false);//enabling the button
         				btnDeal.setDisable(true);//disabling the button
         				txtBet.setEditable(true);//setting so you can the text
         				btnDeal.setText("DEAL");//setting the text of the button
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
        				public void handle(ActionEvent event3)//setting button action event
                        {
            				imgPlayer[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of player to following
            				imgBanker[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of banker to following
        				run();//run method
        				//STARTS
        				}
        				});
                             }
        				//SECOND
                             if( score2 > score)//if the player score is less than banker score then do
                             {
                           	 Integer result1 = Integer.valueOf(lblChips.getText());	//gettng the integer value of lblChips text and declaring it as an int called result1	
              				int a = result1 - ad;//adding both and storing as int a
              			    String str5 = new Integer(a).toString(); //converting from Integer of int a to String and declaring as String str5
              				lblChips.setText(str5);//setting the text of lblChips
           				lblResult.setText("Banker wins!");      //setting the text of the lblResult to the following
         				btnBet.setDisable(false);//enabling the button
         				btnDeal.setDisable(true);//disabling the button
         				txtBet.setEditable(true);//setting so you can the text
         				btnDeal.setText("DEAL");//setting the text of the button
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){//setting button action event
        				public void handle(ActionEvent event3)
        				{
            				imgPlayer[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of player to following
        					imgBanker[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of banker to following
        					run();//run method
        				}
    				});
                             }
                             //THIRD
                             if(score == score2)//if the player score is equal to banker score then do
                             {
                 				lblResult.setText("TIE"); //set label result to TIE
                 				btnBet.setDisable(false);//enabling the button
                 				btnDeal.setDisable(true);//disabling the button
                 				txtBet.setEditable(true);//setting so you can the text
                 				btnDeal.setText("DEAL"); //setting the text of the button
                 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
                    				public void handle(ActionEvent event3)//setting button action event
                    				{
                    					imgPlayer[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of player to following
                    					imgBanker[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of banker to following
                    					run();//run method
                    				}
                 				});

                             }
      
        				}
                   	});
                   	}
                    if((score == 7 || score == 6 ) && (score2 == 6))
                   	{ 
         				lblResult.setText("Draw one more card!");//set the text of the label
        				btnDeal.setText("DRAW CARD");   //set the text of the button 
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){//button action event
        				public void handle(ActionEvent event2)
                        {
        					//setting image of the last banker card
            				imgBanker[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));

            				imgBanker[2].setId(cardvalue[randPos6]);//setting the value of the card 
            				imgPlayer[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));//setting image of the last player card

            				imgPlayer[2].setId(cardvalue[randPos6]);//setting the value of the card 
           					sixth_card = Integer.valueOf(imgBanker[2].getId());	//getting the value of the card and storing it in sixth_card
           					fifth_card = Integer.valueOf(imgPlayer[2].getId());	//getting the value of the card and storing it in fifth_card
           				 sum = first_card + second_card + fifth_card;//getting the sum of three cards
        					int sum2  = third_card + fourth_card + sixth_card;//getting the sum of three cards
        					 score = sum % 10;//getting the score by modulus of the sum 
                            int score2 = sum2 % 10;//getting the score by modulus of the second sum2
                             final_score = Integer.toString(score);//geting the integer value of the string 
                            String final_score2 = Integer.toString(score2);//geting the integer value of the string 

                             lblPTotal.setText(final_score); //setting the label text
                             lblBTotal.setText(final_score2); //setting the label text
                             
                             if(score > score2)//if the player score is greater than banker score then do
                             {
                           	  Integer result1 = Integer.valueOf(lblChips.getText());//getting the integer value of lblChips text and declaring it as an int called result1		
              				int a = result1 + ad;//adding both and storing as int a
              			    String str5 = new Integer(a).toString(); //converting from Integer of int a to String and declaring as String str5
              				lblChips.setText(str5);//setting the text of lblChips
           				lblResult.setText("Player wins!");//setting the text of the lblResult to the following
         				btnBet.setDisable(false);//enabling the button
         				btnDeal.setDisable(true);//disabling the button
         				txtBet.setEditable(true);//setting so you can the text
         				btnDeal.setText("DEAL");//setting the text of the button
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
        				public void handle(ActionEvent event3)//setting button action event
                        {
            				imgPlayer[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of player to following
            				imgBanker[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of banker to following
        				run(); //run method
        				//STARTS
        				}
        				});
                             }
        				//SECOND
                             if( score2 > score) //if the player score is less than banker score then do
                             {
                           	 Integer result1 = Integer.valueOf(lblChips.getText()); //gettng the integer value of lblChips text and declaring it as an int called result1		
              				int a = result1 - ad; //adding both and storing as int a
              			    String str5 = new Integer(a).toString();  //converting from Integer of int a to String and declaring as String str5
              				lblChips.setText(str5); //setting the text of lblChips
           				lblResult.setText("Banker wins!");   //setting the text of the lblResult to the following   
         				btnBet.setDisable(false);//enabling the button
         				btnDeal.setDisable(true);//disabling the button
         				txtBet.setEditable(true);//setting so you can the text
         				btnDeal.setText("DEAL"); //setting the text of the button
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){//setting button action event
        				public void handle(ActionEvent event3)
        				{
            				imgPlayer[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of player to following
        					imgBanker[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of banker to following
        					run();//run method
        				}
    				});
                             }
                             //THIRD
                             if(score == score2)//if the player score is equal to banker score then do
                             {
                 				lblResult.setText("TIE");//set label result to TIE
                 				btnBet.setDisable(false);//enabling the button
                 				btnDeal.setDisable(true);//disabling the button
                 				txtBet.setEditable(true);//setting so you can the text
                 				btnDeal.setText("DEAL");//setting the text of the button
                 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
                    				public void handle(ActionEvent event3)//setting button action event
                    				{
                    					imgPlayer[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of player to following
                    					imgBanker[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of banker to following
                    					run();
                    				}
                 				});

                             }
      
        				}
                   	});
                   	}
         			if(lblBTotal.getText().equals("9")) //if banker label text is equal to 9 
        			{
         				Integer result1 = Integer.valueOf(lblChips.getText());	//getting the integer value of lblChips text and declaring it as an int called result1		
         				int a = result1 - ad;//adding both and storing as int a
         			    String str5 = new Integer(a).toString(); //converting from Integer of int a to String and declaring as String str5
         				lblChips.setText(str5);//setting the text of lblChips
        				lblResult.setText("Banker wins!");//setting the text of the lblResult to the following
        				btnBet.setDisable(false);//enabling the button
        				btnDeal.setDisable(true);//disabling the button
						txtBet.setEditable(true);//setting so you can the text
						btnDeal.setText("DEAL");//setting the text of the button
        			}
         			if((lblPTotal.getText().equals("9")) && (lblBTotal.getText().equals("9"))) //if player label text is equal to 9 and banker label is equal to 9
			{
				lblResult.setText("It's a TIE");  //set label result to TIE
				btnBet.setDisable(false);//enabling the button
				btnDeal.setDisable(true);//disabling the button
				txtBet.setEditable(true);//setting so you can the text
				btnDeal.setText("DEAL");//setting the text of the button
			}

                
                   

   			
         			  if(lblChips.getText().equals("0"))
            		  {
            	  Alert alert = new Alert(AlertType.CONFIRMATION);
        			alert.setHeaderText(null);
        			alert.setContentText("GAME OVER! You have $0 remaining.\nWould you like to play again?");
        			alert.getButtonTypes().clear();
        			alert.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);//adding the yes or no button when asked to quit
        			alert.setTitle("Baccarat");//set the title of the alert to the following
        			Optional<ButtonType> result = alert.showAndWait();//gets results returned and compares it
        			if(result.get() == ButtonType.YES) { //if user presses yes then do following
        				//this basically restarts the applications
        				primaryStage.close(); 
        			      Platform.runLater( () -> new Main().start( new Stage() ) );
        			     
        				primaryStage.setScene(scene);
        				primaryStage.show();    			}
        			else
        			{
        				System.exit(0); //end game
        			}
            		}
                   	
						} 
				});
		


			
       	
 			

              


  			
	
	              

			StackPane root = new StackPane();
			root.setPadding(new Insets(0, 0, 0, 0));
			root.setAlignment(Pos.TOP_LEFT);
			StackPane.setMargin(iviewTitle, new Insets(0, 0, 0, SCENE_WIDTH / 2 - imgTitle.getWidth() / 2));
			StackPane.setMargin(lblChips, new Insets(175, 0, 0, SCENE_WIDTH / 2 - lblChips.getPrefWidth() / 2));
			StackPane.setMargin(lbl, new Insets(176, 0, 0, SCENE_WIDTH / 2.37 - lbl.getPrefWidth() / 3.4));
			StackPane.setMargin(lblPlayer, new Insets(540, 0, 0, 250));
			StackPane.setMargin(lblBanker, new Insets(540, 0, 0, 600));
			StackPane.setMargin(lblPTotal, new Insets(580, 0, 0, 250));
			StackPane.setMargin(lblBTotal, new Insets(580, 0, 0, 600));
			StackPane.setMargin(lblResult, new Insets(495, 0, 0, SCENE_WIDTH / 2 - lblResult.getPrefWidth() / 2));
			StackPane.setMargin(txtBet, new Insets(250, 0, 0, SCENE_WIDTH / 2 - txtBet.getPrefWidth() / 2));
			StackPane.setMargin(btnBet, new Insets(310, 0, 0, SCENE_WIDTH / 2 - btnBet.getPrefWidth() / 2));
			StackPane.setMargin(btnDeal, new Insets(370, 0, 0, SCENE_WIDTH / 2 - btnDeal.getPrefWidth() / 2));
			StackPane.setMargin(btnQuit, new Insets(430, 0, 0, SCENE_WIDTH / 2 - btnQuit.getPrefWidth() / 2));
			root.getChildren().addAll(iviewBack, iviewTitle, lblChips, lbl, lblPlayer, lblBanker, lblPTotal, lblBTotal, lblResult, txtBet,
					btnBet, btnDeal, btnQuit, imgPlayer[0], imgPlayer[1], imgPlayer[2], imgBanker[0], imgBanker[1], imgBanker[2]);
			
		
		
			scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setTitle("Baccarat"); 
			primaryStage.setScene(scene);
			primaryStage.show();
			
			   primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			    	public void handle(WindowEvent e) {
			    			Alert alert = new Alert(AlertType.CONFIRMATION);//declaring alert and setting it to CONFIRMATION alert
			    			alert.setContentText("Are you sure you want to exit?");//Alert pop up that says the following
			    			alert.setHeaderText(null);//Alert pop up with no headertext
			    			alert.getButtonTypes().clear();
			    			alert.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);//adding the yes or no button when asked to quit
			    			alert.setTitle("Baccarat");//set the title of the alert to the following
			    			Optional<ButtonType> result = alert.showAndWait();//gets results returned and compares it
			    			if(result.get() == ButtonType.YES) { //if user presses no then do following
			    				System.exit(0);
			    			}
			    			else
			    			{
			    				e.consume();//do noting resume program
			    			}
			    			}
			    			});
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	 public void run() 
	 {
		btnDeal.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {
				Random rgen = new Random();//declaring rgen to randomize numbers
			    Random rgen2 = new Random();//declaring rgen2 to randomize numbers
			    Random rgen3 = new Random();//declaring rgen3 to randomize numbers
			    Random rgen4 = new Random();//declaring rgen4 to randomize numbers
			    Random rgen5 = new Random();//declaring rgen5 to randomize numbers
			    Random rgen6 = new Random();//declaring rgen6 to randomize numbers
			        randPos = rgen.nextInt(cards.length);//declaring randPos as the randomized integer length of cards
			        randPos2 = rgen2.nextInt(cards.length);//declaring randPos2 as the randomized integer length of cards
			        randPos5 = rgen5.nextInt(cards.length);//declaring randPos5 as the randomized integer length of cards

			        
				imgPlayer[0].setImage(new Image("file:images/" + 
						cards[randPos] + ".png"));//setting first card image of player to following
				imgPlayer[0].setId(cardvalue[randPos]);//setting the value of the card 
				int first_card = Integer.valueOf(imgPlayer[0].getId());//getting value of the card and storing in first_card as int
				imgPlayer[1].setImage(new Image("file:images/" + 
						cards[randPos2] + ".png"));//setting second card image of player to following
				imgPlayer[1].setId(cardvalue[randPos2]);//setting the value of the card 
				int second_card = Integer.valueOf(imgPlayer[1].getId());//getting value of the card and storing in second_card as int
              sum = first_card + second_card;//getting the sum of both cards
              score = sum % 10;//getting the score by modulus of the sum 
              final_score = Integer.toString(score);//geting the integer value of the string 

              lblPTotal.setText(final_score);//setting the label text
  			if(lblPTotal.getText().equals("9"))//if label text is equal to 9
 			{
  				result = Integer.valueOf(lblChips.getText());		//gettng the integer value of lblChips text and declaring it as an int called result	

  				int b = result + ad; //adding both and storing as int b
  			    String str4 = new Integer(b).toString();  //converting from Integer of int b to String and declaring as String str4
  				lblChips.setText(str4); //setting the text of lblChips
 				lblResult.setText("Player wins!");//setting the text of the lblResult to the following
 				btnBet.setDisable(false);//enabling the button
 				btnDeal.setDisable(true);//disabling the button
					txtBet.setEditable(true);//setting so you can the text
					btnDeal.setText("DEAL"); //setting the text of the button
 			}
			        randPos3 = rgen3.nextInt(cards.length);//declaring randPos3 as the randomized integer length of cards
			        randPos4 = rgen4.nextInt(cards.length);//declaring randPos4 as the randomized integer length of cards
			        randPos6 = rgen6.nextInt(cards.length);//declaring randPos6 as the randomized integer length of cards
			        //setting image of the first banker card
				imgBanker[0].setImage(new Image("file:images/" + 
						cards[randPos3] + ".png"));

				imgBanker[0].setId(cardvalue[randPos3]);//setting the value of the card 
				int third_card = Integer.valueOf(imgBanker[0].getId());//getting the value of the card and storing it in third_card

				  //setting image of the second banker card
				imgBanker[1].setImage(new Image("file:images/" + 
						cards[randPos4] + ".png"));
				imgBanker[1].setId(cardvalue[randPos4]);//setting the value of the card 

				int fourth_card = Integer.valueOf(imgBanker[1].getId());//getting the value of the card and storing it in fourth_card

             int sum2 = third_card + fourth_card;//getting the sum of the banker 
             int score2 = sum2 % 10;//getting the score of the banker by modulus of 10
             String final_score2 = Integer.toString(score2);//converting from Integer to String and storing it as final_string
             lblBTotal.setText(final_score2);//setting the text of the label
             if((score == 6 || score == 7) && (score2 ==5 || score2 == 4|| score2 == 3 ||  score2 == 2 ||  score2 == 1 ||  score2 == 0))
            	{
  				lblResult.setText("Draw one more card!");//set the text of the label
 				btnDeal.setText("DRAW CARD");   //set the text of the button
 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){//button action event
 				public void handle(ActionEvent event2)
                 {
 					//setting image of the last banker card
     				imgBanker[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));

    					imgBanker[2].setId(cardvalue[randPos6]);//setting the value of the card 
    					sixth_card = Integer.valueOf(imgBanker[2].getId());	//getting the value of the card and storing it in sixth_card
    				 sum = first_card + second_card;//getting the sum of both cards
 					int sum2  = third_card + fourth_card + sixth_card;//getting the sum of three cards
 					 score = sum % 10;//getting the score by modulus of the sum 
                     int score2 = sum2 % 10;//getting the score by modulus of the second sum2
                      final_score = Integer.toString(score);//geting the integer value of the string 
                     String final_score2 = Integer.toString(score2); //geting the integer value of the string 

                      lblPTotal.setText(final_score);//setting the label text
                      lblBTotal.setText(final_score2);//setting the label text

                      if(score > score2)//if the player score is greater than banker score then do
                      {
                    	  Integer result1 = Integer.valueOf(lblChips.getText());	//getting the integer value of lblChips text and declaring it as an int called result1	
       				int a = result1 + ad;//adding both and storing as int a
       			    String str5 = new Integer(a).toString(); //converting from Integer of int a to String and declaring as String str5
       				lblChips.setText(str5);//setting the text of lblChips
    				lblResult.setText("Player wins!");//setting the text of the lblResult to the following
  				btnBet.setDisable(false);//enabling the button
  				btnDeal.setDisable(true);//disabling the button
  				txtBet.setEditable(true);//setting so you can the text
  				btnDeal.setText("DEAL");//setting the text of the button
 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
 				public void handle(ActionEvent event3)//setting button action event
                 {
 					imgBanker[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of banker to following
 				run();//run method
 				//STARTS

 				}
 				});
                      }
 				//SECOND
                      if( score2 > score) //if the player score is less than banker score then do
                      {
                    	 Integer result1 = Integer.valueOf(lblChips.getText());//getting the integer value of lblChips text and declaring it as an int called result1		
       				int a = result1 - ad; //adding both and storing as int a
       			    String str5 = new Integer(a).toString(); //converting from Integer of int a to String and declaring as String str5
       				lblChips.setText(str5);//setting the text of lblChips
    				lblResult.setText("Banker wins!");   //setting the text of the lblResult to the following   
  				btnBet.setDisable(false); //enabling the button
  				btnDeal.setDisable(true);//disabling the button
  				txtBet.setEditable(true);//setting so you can the text
  				btnDeal.setText("DEAL");//setting the text of the button
 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){//setting button action event
 				public void handle(ActionEvent event3)
 				{
    				imgBanker[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of banker to following
 					run();//run method
 				}
				});
                      }
                      //THIRD
                      if(score == score2)//if the player score is equal to banker score then do
                      {
          				lblResult.setText("TIE");//set label result to TIE
          				btnBet.setDisable(false);//enabling the button
          				btnDeal.setDisable(true);//disabling the button
          				txtBet.setEditable(true);//setting so you can the text
          				btnDeal.setText("DEAL");//setting the text of the button
          				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
             				public void handle(ActionEvent event3)//setting button action event
             				{
             					run();//run method
                				imgBanker[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of banker to following
             				}
          				});

                      }

 				}
            	});
            	}
			
             if(score == 5 || score == 4 || score ==3 || score == 2 || score == 1 || score ==0)
            	{ 
  				lblResult.setText("Draw one more card!");//set the text of the label
 				btnDeal.setText("DRAW CARD");   //set the text of the button
 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){//button action event
 				public void handle(ActionEvent event2)
                 {
     				imgPlayer[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));//setting image of the last player card

     				imgPlayer[2].setId(cardvalue[randPos6]);//setting the value of the card 
    					sixth_card = Integer.valueOf(imgPlayer[2].getId());		//getting the value of the card and storing it in sixth_card
    				 sum = first_card + second_card + sixth_card;//getting the sum of three cards
 					int sum2  = third_card + fourth_card;//getting the sum of three cards
 					 score = sum % 10;//getting the score by modulus of the sum 
                     int score2 = sum2 % 10;//getting the score by modulus of the second sum2
                      final_score = Integer.toString(score);//geting the integer value of the string 
                     String final_score2 = Integer.toString(score2);//geting the integer value of the string 

                      lblPTotal.setText(final_score);//setting the label text
                      lblBTotal.setText(final_score2);//setting the label text
                      
                      if(score > score2) //if the player score is greater than banker score then do
                      {
                    	  Integer result1 = Integer.valueOf(lblChips.getText());//getting the integer value of lblChips text and declaring it as an int called result1			
       				int a = result1 + ad; //adding both and storing as int a
       			    String str5 = new Integer(a).toString(); //converting from Integer of int a to String and declaring as String str5
       				lblChips.setText(str5);//setting the text of lblChips
    				lblResult.setText("Player wins!");//setting the text of the lblResult to the following
  				btnBet.setDisable(false);//enabling the button
  				btnDeal.setDisable(true);//disabling the button
  				txtBet.setEditable(true);//setting so you can the text
  				btnDeal.setText("DEAL");//setting the text of the button
 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){//setting button action event
 				public void handle(ActionEvent event3)
                 {
     				imgPlayer[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of player to following
 				run();//run method
 				//STARTS
 				}
 				});
                      }
 				//SECOND
                      if( score2 > score) ///if the player score is less than banker score then do
                      {
                    	 Integer result1 = Integer.valueOf(lblChips.getText());	//getting the integer value of lblChips text and declaring it as an int called result1
       				int a = result1 - ad;//adding both and storing as int a
       			    String str5 = new Integer(a).toString(); //converting from Integer of int a to String and declaring as String str5
       				lblChips.setText(str5);//setting the text of lblChips
    				lblResult.setText("Banker wins!");    //setting the text of the lblResult to the following  
  				btnBet.setDisable(false);//enabling the button
  				btnDeal.setDisable(true);//disabling the button
  				txtBet.setEditable(true);//setting so you can the text
  				btnDeal.setText("DEAL");//setting the text of the button
 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){//setting button action event
 				public void handle(ActionEvent event3)
 				{
 					imgPlayer[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of player to following
 					run();//run method
 				}
				});
                      }
                      //THIRD
                      if(score == score2)//if the player score is equal to banker score then do
                      {
          				lblResult.setText("TIE");//set label result to TIE
          				btnBet.setDisable(false);//enabling the button
          				btnDeal.setDisable(true);//disabling the button
          				txtBet.setEditable(true);//setting so you can the text
          				btnDeal.setText("DEAL");//setting the text of the button
          				btnDeal.setOnAction(new EventHandler<ActionEvent>(){//setting button action event
             				public void handle(ActionEvent event3)
             				{
             					run();//run method
             					imgPlayer[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of Player to following
             				}
          				});

                      }

 				}
            	});
            	}
             if((score == 5 || score == 4 || score ==3 || score == 2 || score == 1 || score ==0) && (score2 ==0 || score2 == 1|| score2 == 2))
            	{ 
  				lblResult.setText("Draw one more card!");//set the text of the label
 				btnDeal.setText("DRAW CARD"); //set the text of the button    
 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){//button action event
 				public void handle(ActionEvent event2)
                 {
 					//setting image of the last banker card
     				imgBanker[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));

     				imgBanker[2].setId(cardvalue[randPos6]);//setting the value of the card 
     				imgPlayer[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));//setting image of the last player card

     				imgPlayer[2].setId(cardvalue[randPos6]);//setting the value of the card 
    					sixth_card = Integer.valueOf(imgBanker[2].getId());	//getting the value of the card and storing it in sixth_card
    					fifth_card = Integer.valueOf(imgPlayer[2].getId());	//getting the value of the card and storing it in fifth_card
    				 sum = first_card + second_card + fifth_card;//getting the sum of three cards
 					int sum2  = third_card + fourth_card + sixth_card;//getting the sum of three cards
 					 score = sum % 10;//getting the score by modulus of the sum 
                     int score2 = sum2 % 10;//getting the score by modulus of the second sum2
                      final_score = Integer.toString(score);//geting the integer value of the string 
                     String final_score2 = Integer.toString(score2);//geting the integer value of the string 

                      lblPTotal.setText(final_score); //setting the label text
                      lblBTotal.setText(final_score2); //setting the label text
                      
                      if(score > score2) //if the player score is greater than banker score then do
                      {
                    	  Integer result1 = Integer.valueOf(lblChips.getText());	//gettng the integer value of lblChips text and declaring it as an int called result1		
       				int a = result1 + ad;//adding both and storing as int a
       			    String str5 = new Integer(a).toString(); //converting from Integer of int a to String and declaring as String str5
       				lblChips.setText(str5);//setting the text of lblChips
    				lblResult.setText("Player wins!");//setting the text of the lblResult to the following
  				btnBet.setDisable(false);//enabling the button
  				btnDeal.setDisable(true);//disabling the button
  				txtBet.setEditable(true);//setting so you can the text
  				btnDeal.setText("DEAL");//setting the text of the button
 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){//setting button action event
 				public void handle(ActionEvent event3)
                 {
 					imgPlayer[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of player to following
     				imgBanker[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of player to following
 				run();
 				//STARTS
 				}
 				});
                      }
 				//SECOND
                      if( score2 > score)//if the player score is less than banker score then do
                      {
                    	 Integer result1 = Integer.valueOf(lblChips.getText());		//gettng the integer value of lblChips text and declaring it as an int called result1	
       				int a = result1 - ad;//adding both and storing as int a
       			    String str5 = new Integer(a).toString(); //converting from Integer of int a to String and declaring as String str5
       				lblChips.setText(str5);//setting the text of lblChips
    				lblResult.setText("Banker wins!");   //setting the text of the lblResult to the following   
  				btnBet.setDisable(false);//enabling the button
  				btnDeal.setDisable(true);//disabling the button
  				txtBet.setEditable(true);//setting so you can the text
  				btnDeal.setText("DEAL");//setting the text of the button
 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){//setting button action event
 				public void handle(ActionEvent event3)
 				{
 					imgPlayer[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of player to following
 					imgBanker[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of banker to following
 					run();//run method
 				}
				});
                      }
                      //THIRD
                      if(score == score2)//if the player score is equal to banker score then do
                      {
          				lblResult.setText("TIE");//set label result to TIE
          				btnBet.setDisable(false);//enabling the button
          				btnDeal.setDisable(true);//disabling the button
          				txtBet.setEditable(true);//setting so you can the text
          				btnDeal.setText("DEAL");//setting the text of the button
          				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
             				public void handle(ActionEvent event3)//setting button action event
             				{
             					imgPlayer[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of Player to following
             					imgBanker[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of banker to following
             					run();//run method
             				}
          				});

                      }

 				}
            	});
            	}

             if((score == 7 || score == 6 || score == 5 || score == 4 || score ==3 || score == 2 || score == 1 || score ==0) && (score2 == 3))
            	{ 
  				lblResult.setText("Draw one more card!");//set the text of the label
 				btnDeal.setText("DRAW CARD");   //set the text of the button 
 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){//button action event
 				public void handle(ActionEvent event2)
                 {
 					 //setting image of the last banker card
     				imgBanker[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));//setting image of the last banker card 

     				imgBanker[2].setId(cardvalue[randPos6]);//setting the value of the card 
     				imgPlayer[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));//setting image of the last player card

     				imgPlayer[2].setId(cardvalue[randPos6]);//setting the value of the card 
    					sixth_card = Integer.valueOf(imgBanker[2].getId());	//getting the value of the card and storing it in sixth_card
    					fifth_card = Integer.valueOf(imgPlayer[2].getId());	//getting the value of the card and storing it in fifth_card
    				 sum = first_card + second_card + fifth_card;//getting the sum of the three cards
 					int sum2  = third_card + fourth_card + sixth_card;//getting the sum of three cards
 					 score = sum % 10;//getting the score by modulus of the sum 
                     int score2 = sum2 % 10;//getting the score by modulus of the second sum2
                      final_score = Integer.toString(score);//geting the integer value of the string 
                     String final_score2 = Integer.toString(score2);//geting the integer value of the string 

                      lblPTotal.setText(final_score);//setting the label text
                      lblBTotal.setText(final_score2);//setting the label text
                      
                      if(score > score2)//if the player score is greater than banker score then do
                      {
                    	  Integer result1 = Integer.valueOf(lblChips.getText());//gettng the integer value of lblChips text and declaring it as an int called result1			
       				int a = result1 + ad;//adding both and storing as int a
       			    String str5 = new Integer(a).toString();  //converting from Integer of int a to String and declaring as String str5
       				lblChips.setText(str5);//setting the text of lblChips
    				lblResult.setText("Player wins!");//setting the text of the lblResult to the following
  				btnBet.setDisable(false);//enabling the button
  				btnDeal.setDisable(true);//disabling the button
  				txtBet.setEditable(true);//setting so you can the text
  				btnDeal.setText("DEAL");//setting the text of the button
 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
 				public void handle(ActionEvent event3)//setting button action event
                 {
     				imgPlayer[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of player to following
     				imgBanker[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of banker to following
 				run();//run method
 				//STARTS
 				}
 				});
                      }
 				//SECOND
                      if( score2 > score)//if the player score is less than banker score then do
                      {
                    	 Integer result1 = Integer.valueOf(lblChips.getText());	 //getting the integer value of lblChips text and declaring it as an int called result1	
       				int a = result1 - ad;//adding both and storing as int a
       			    String str5 = new Integer(a).toString(); //converting from Integer of int a to String and declaring as String str5
       				lblChips.setText(str5);//setting the text of lblChips
    				lblResult.setText("Banker wins!");      //setting the text of the lblResult to the following
  				btnBet.setDisable(false);//enabling the button
  				btnDeal.setDisable(true);//disabling the button
  				txtBet.setEditable(true);//setting so you can the text
  				btnDeal.setText("DEAL");//setting the text of the button
 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){//setting button action event
 				public void handle(ActionEvent event3)
 				{
     				imgPlayer[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of player to following
 					imgBanker[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of banker to following
 					run(); //run method
 				}
				});
                      }
                      //THIRD
                      if(score == score2)//if the player score is equal to banker score then do
                      {
          				lblResult.setText("TIE"); //set label result to TIE
          				btnBet.setDisable(false);//enabling the button
          				btnDeal.setDisable(true);//disabling the button
          				txtBet.setEditable(true);//setting so you can the text
          				btnDeal.setText("DEAL");//setting the text of the button
          				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
             				public void handle(ActionEvent event3)//setting button action event
             				{
             					imgPlayer[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of player to following
             					imgBanker[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of banker to following
             					run();
             				}
          				});

                      }

 				}
            	});
            	}
             if((score == 7 || score == 6 || score == 5 || score == 4 || score ==3 || score == 2 ) && (score2 == 4))
         	{ 
         		lblResult.setText("Draw one more card!"); //set the text of the label
         	btnDeal.setText("DRAW CARD");    //set the text of the button
         	btnDeal.setOnAction(new EventHandler<ActionEvent>(){//button action event
         	public void handle(ActionEvent event2)
             {
         		 //setting image of the last banker card
         		imgBanker[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));

         		imgBanker[2].setId(cardvalue[randPos6]);//setting the value of the card 
         		imgPlayer[2].setImage(new Image("file:images/" + cards[randPos6] + ".png")); //setting image of the last player card

         		imgPlayer[2].setId(cardvalue[randPos6]);//setting the value of the card 
         			sixth_card = Integer.valueOf(imgBanker[2].getId());	//getting the value of the card and storing it in sixth_card
         			fifth_card = Integer.valueOf(imgPlayer[2].getId());	//getting the value of the card and storing it in fifth_card
         		 sum = first_card + second_card + fifth_card;//getting the sum of three cards
         		int sum2  = third_card + fourth_card + sixth_card;//getting the sum of three cards
         		 score = sum % 10;//getting the score by modulus of the sum 
                 int score2 = sum2 % 10;//getting the score by modulus of the second sum2
                  final_score = Integer.toString(score);//geting the integer value of the string 
                 String final_score2 = Integer.toString(score2);//geting the integer value of the string 

                  lblPTotal.setText(final_score); //setting the label text
                  lblBTotal.setText(final_score2); //setting the label text
                  
                  if(score > score2)//if the player score is greater than banker score then do
                  {
                	  Integer result1 = Integer.valueOf(lblChips.getText());//gettng the integer value of lblChips text and declaring it as an int called result1
         			int a = result1 + ad; //adding both and storing as int a
         		    String str5 = new Integer(a).toString(); //converting from Integer of int a to String and declaring as String str5
         			lblChips.setText(str5);//setting the text of lblChips
         		lblResult.setText("Player wins!");//setting the text of the lblResult to the following
         		btnBet.setDisable(false);//enabling the button
         		btnDeal.setDisable(true);//disabling the button
         		txtBet.setEditable(true);//setting so you can the text
         		btnDeal.setText("DEAL");//setting the text of the button
         	btnDeal.setOnAction(new EventHandler<ActionEvent>(){
         	public void handle(ActionEvent event3)//setting button action event
             {
         		imgPlayer[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of Player to following
         		imgBanker[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of banker to following
         	run();//run method
         	//STARTS
         	}
         	});
                  }
         	//SECOND
                  if( score2 > score)//if the player score is less than banker score then do
                  {
                	 Integer result1 = Integer.valueOf(lblChips.getText());	//gettng the integer value of lblChips text and declaring it as an int called result1	
         			int a = result1 - ad;//adding both and storing as int a
         		    String str5 = new Integer(a).toString(); //converting from Integer of int a to String and declaring as String str5
         			lblChips.setText(str5);//setting the text of lblChips
         		lblResult.setText("Banker wins!"); //setting the text of the lblResult to the following
         		btnBet.setDisable(false);//enabling the button
         		btnDeal.setDisable(true);//disabling the button
         		txtBet.setEditable(true);//setting so you can the text
         		btnDeal.setText("DEAL");//setting the text of the button
         	btnDeal.setOnAction(new EventHandler<ActionEvent>(){//setting button action event
         	public void handle(ActionEvent event3)
         	{
         		imgPlayer[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of player to following
         		imgBanker[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of banker to following
         		run();//run method
         	}
         });
                  }
                  //THIRD
                  if(score == score2)//if the player score is equal to banker score then do
                  {
         				lblResult.setText("TIE");//set label result to TIE
         				btnBet.setDisable(false);//enabling the button
         				btnDeal.setDisable(true);//disabling the button
         				txtBet.setEditable(true);//setting so you can the text
         				btnDeal.setText("DEAL");//setting the text of the button
         				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
         				public void handle(ActionEvent event3)//setting button action event
         				{
         					imgPlayer[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of player to following
         					imgBanker[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of banker to following
         					run();
         				}
         				});

                  }

         	}
         	});
         	}
             if((score == 7 || score == 6 || score == 5 || score == 4) && (score2 == 5))
         	{ 
         		lblResult.setText("Draw one more card!");//set the text of the label
         	btnDeal.setText("DRAW CARD");    //set the text of the button
         	btnDeal.setOnAction(new EventHandler<ActionEvent>(){//button action event
         	public void handle(ActionEvent event2)
             {
         		 //setting image of the last banker card
        		imgBanker[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));

        		imgBanker[2].setId(cardvalue[randPos6]);//setting the value of the card 
        		imgPlayer[2].setImage(new Image("file:images/" + cards[randPos6] + ".png")); //setting image of the last player card


        		imgPlayer[2].setId(cardvalue[randPos6]);//setting the value of the card 
        			sixth_card = Integer.valueOf(imgBanker[2].getId());	//getting the value of the card and storing it in sixth_card
        			fifth_card = Integer.valueOf(imgPlayer[2].getId());	//getting the value of the card and storing it in fifth_card
        		 sum = first_card + second_card + fifth_card;//getting the sum of three cards
        		int sum2  = third_card + fourth_card + sixth_card;//getting the sum of both cards
        		 score = sum % 10;//getting the score by modulus of the sum 
                int score2 = sum2 % 10;//getting the score by modulus of the second sum2
                 final_score = Integer.toString(score);//geting the integer value of the string 
                String final_score2 = Integer.toString(score2);//geting the integer value of the string 

                 lblPTotal.setText(final_score);//setting the label text
                 lblBTotal.setText(final_score2); //setting the label text
                 
                 if(score > score2)//if the player score is greater than banker score then do
                 {
               	  Integer result1 = Integer.valueOf(lblChips.getText());	//getting the integer value of lblChips text and declaring it as an int called result1	
        			int a = result1 + ad;//adding both and storing as int a
        		    String str5 = new Integer(a).toString(); //converting from Integer of int a to String and declaring as String str5
        			lblChips.setText(str5);//setting the text of lblChips
        		lblResult.setText("Player wins!");//setting the text of the lblResult to the following
        		btnBet.setDisable(false);//enabling the button
        		btnDeal.setDisable(true);//disabling the button
        		txtBet.setEditable(true);//setting so you can the text
        		btnDeal.setText("DEAL");//setting the text of the button
        	btnDeal.setOnAction(new EventHandler<ActionEvent>(){
        	public void handle(ActionEvent event3)//setting button action event
            {
        		imgPlayer[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of player to following
        		imgBanker[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of banker to following
        	run();//run method
        	//STARTS
        	}
        	});
                 }
        	//SECOND
                 if( score2 > score)//if the player score is less than banker score then do
                 {
               	 Integer result1 = Integer.valueOf(lblChips.getText());	//gettng the integer value of lblChips text and declaring it as an int called result1	
        			int a = result1 - ad;//adding both and storing as int a
        		    String str5 = new Integer(a).toString(); //converting from Integer of int a to String and declaring as String str5
        			lblChips.setText(str5);//setting the text of lblChips
        		lblResult.setText("Banker wins!");      //setting the text of the lblResult to the following
        		btnBet.setDisable(false);//enabling the button
        		btnDeal.setDisable(true);//disabling the button
        		txtBet.setEditable(true);//setting so you can the text
        		btnDeal.setText("DEAL");//setting the text of the button
        	btnDeal.setOnAction(new EventHandler<ActionEvent>(){//setting button action event
        	public void handle(ActionEvent event3)
        	{
        		imgPlayer[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of player to following
        		imgBanker[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of banker to following
        		run();//run method
        	}
        });
                 }
                 //THIRD
                 if(score == score2)//if the player score is equal to banker score then do
                 {
        				lblResult.setText("TIE"); //set label result to TIE
        				btnBet.setDisable(false);//enabling the button
        				btnDeal.setDisable(true);//disabling the button
        				txtBet.setEditable(true);//setting so you can the text
        				btnDeal.setText("DEAL"); //setting the text of the button
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
        				public void handle(ActionEvent event3)//setting button action event
        				{
        					imgPlayer[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of player to following
        					imgBanker[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of banker to following
        					run();//run method
        				}
        				});


                      }

 				}
            	});
            	}
             if((score == 7 || score == 6 ) && (score2 == 6))
         	{ 
         		lblResult.setText("Draw one more card!");//set the text of the label
         	btnDeal.setText("DRAW CARD");   //set the text of the button 
         	btnDeal.setOnAction(new EventHandler<ActionEvent>(){//button action event
         	public void handle(ActionEvent event2)
             {
         		//setting image of the last banker card
         		imgBanker[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));

         		imgBanker[2].setId(cardvalue[randPos6]);//setting the value of the card 
         		imgPlayer[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));//setting image of the last player card

         		imgPlayer[2].setId(cardvalue[randPos6]);//setting the value of the card 
         			sixth_card = Integer.valueOf(imgBanker[2].getId());	//getting the value of the card and storing it in sixth_card
         			fifth_card = Integer.valueOf(imgPlayer[2].getId());	//getting the value of the card and storing it in fifth_card
         		 sum = first_card + second_card + fifth_card;//getting the sum of three cards
         		int sum2  = third_card + fourth_card + sixth_card;//getting the sum of three cards
         		 score = sum % 10;//getting the score by modulus of the sum 
                 int score2 = sum2 % 10;//getting the score by modulus of the second sum2
                  final_score = Integer.toString(score);//geting the integer value of the string 
                 String final_score2 = Integer.toString(score2);//geting the integer value of the string 

                  lblPTotal.setText(final_score); //setting the label text
                  lblBTotal.setText(final_score2); //setting the label text
                  
                  if(score > score2)//if the player score is greater than banker score then do
                  {
                	  Integer result1 = Integer.valueOf(lblChips.getText());//getting the integer value of lblChips text and declaring it as an int called result1		
         			int a = result1 + ad;//adding both and storing as int a
         		    String str5 = new Integer(a).toString(); //converting from Integer of int a to String and declaring as String str5
         			lblChips.setText(str5);//setting the text of lblChips
         		lblResult.setText("Player wins!");//setting the text of the lblResult to the following
         		btnBet.setDisable(false);//enabling the button
         		btnDeal.setDisable(true);//disabling the button
         		txtBet.setEditable(true);//setting so you can the text
         		btnDeal.setText("DEAL");//setting the text of the button
         	btnDeal.setOnAction(new EventHandler<ActionEvent>(){
         	public void handle(ActionEvent event3)//setting button action event
             {
         		imgPlayer[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of player to following
         		imgBanker[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of banker to following
         	run(); //run method
         	//STARTS
         	}
         	});
                  }
         	//SECOND
                  if( score2 > score) //if the player score is less than banker score then do
                  {
                	 Integer result1 = Integer.valueOf(lblChips.getText()); //gettng the integer value of lblChips text and declaring it as an int called result1		
         			int a = result1 - ad; //adding both and storing as int a
         		    String str5 = new Integer(a).toString();  //converting from Integer of int a to String and declaring as String str5
         			lblChips.setText(str5); //setting the text of lblChips
         		lblResult.setText("Banker wins!");   //setting the text of the lblResult to the following   
         		btnBet.setDisable(false);//enabling the button
         		btnDeal.setDisable(true);//disabling the button
         		txtBet.setEditable(true);//setting so you can the text
         		btnDeal.setText("DEAL"); //setting the text of the button
         	btnDeal.setOnAction(new EventHandler<ActionEvent>(){//setting button action event
         	public void handle(ActionEvent event3)
         	{
         		imgPlayer[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of player to following
         		imgBanker[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of banker to following
         		run();//run method
         	}
         });
                  }
                  //THIRD
                  if(score == score2)//if the player score is equal to banker score then do
                  {
         				lblResult.setText("TIE");//set label result to TIE
         				btnBet.setDisable(false);//enabling the button
         				btnDeal.setDisable(true);//disabling the button
         				txtBet.setEditable(true);//setting so you can the text
         				btnDeal.setText("DEAL");//setting the text of the button
         				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
         				public void handle(ActionEvent event3)//setting button action event
         				{
         					imgPlayer[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of player to following
         					imgBanker[2].setImage(new Image("file:images/back_blue.png"));//setting last card image of banker to following
         					run();
         				}
         				});
                      }

 				}
            	});
            	}
             if(lblBTotal.getText().equals("9")) //if banker label text is equal to 9 
             {
             		Integer result1 = Integer.valueOf(lblChips.getText());	//getting the integer value of lblChips text and declaring it as an int called result1		
             		int a = result1 - ad;//adding both and storing as int a
             	    String str5 = new Integer(a).toString(); //converting from Integer of int a to String and declaring as String str5
             		lblChips.setText(str5);//setting the text of lblChips
             	lblResult.setText("Banker wins!");//setting the text of the lblResult to the following
             	btnBet.setDisable(false);//enabling the button
             	btnDeal.setDisable(true);//disabling the button
             	txtBet.setEditable(true);//setting so you can the text
             	btnDeal.setText("DEAL");//setting the text of the button
             }
             	if((lblPTotal.getText().equals("9")) && (lblBTotal.getText().equals("9"))) //if player label text is equal to 9 and banker label is equal to 9
             {
             lblResult.setText("It's a TIE");  //set label result to TIE
             btnBet.setDisable(false);//enabling the button
             btnDeal.setDisable(true);//disabling the button
             txtBet.setEditable(true);//setting so you can the text
             btnDeal.setText("DEAL");//setting the text of the button
		}


					}
			});
	

}

	public static void main(String[] args) {
		launch(args);
	}
}
