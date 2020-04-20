package application;

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

	private Label lblPlayer, lblBanker, lblPTotal, lblBTotal, lblChips, lblResult, lbl;
	private TextField txtBet;
	private Button btnDeal, btnBet, btnQuit;
	private ImageView[] imgPlayer, imgBanker;
	private String[] cards;
	private String[] cardvalue;
	private String[] cards2;
	private String[] cards3;
	private String[] cards4;
	private int randPos;
	private int randPos2;
	private int randPos3;
	private int randPos4;
	private int randPos5;
	private int randPos6;
	private int sum;
	private int first_card;
	private int second_card;
	private int third_card;
	private int fourth_card;
	private int fifth_card;
	private int sixth_card;
	private int sum2;
	private int score;
	private int score2;
	private int ad;
	private Integer result;
	private String final_score;
	private String final_score2;
	private Button btnSelected;
	private int clicked;
	Scene scene; //Declare scene

	private int yPos = 175;

	public void start(Stage primaryStage) {

		try {	
			
		    Random random = new Random();
			cards = new String[] {"10C", "10D", "10H","10S","11C","11D","11H","11S",
					"12C","12D","12H","12S","13C", "13D", "13H","13S","14C", "14D", "14H","14S","2C", "2D", "2H","2S","3C", "3D", "3H","3S","4C", "4D", "4H","4S","5C", "5D", "5H","5S","6C", "6D", "6H","6S","7C", "7D", "7H","7S","8C", "8D", "8H","8S","9C", "9D", "9H","9S"};
			 cardvalue = new String[] {"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","1","1","1","1","2","2","2","2","3","3","3","3","4","4","4","4","5","5","5","5","6","6","6","6","7","7","7","7","8","8","8","8","9","9","9","9"}; 
			Random rgen = new Random();
		    Random rgen2 = new Random();
		    Random rgen3 = new Random();
		    Random rgen4 = new Random();
		    Random rgen5 = new Random();
		    Random rgen6 = new Random();
			Image imgTitle = new Image("file:images/baccarat1.png");
			ImageView iviewTitle = new ImageView(imgTitle);

			final int SCENE_WIDTH = 1000;

			ImageView iviewBack = new ImageView(new Image("file:images/card_table.jpg"));
			lbl = new Label();
			lbl.setText("$");
			lbl.setPrefSize(175, 40);
			lbl.setAlignment(Pos.CENTER);
			lbl.setFont(Font.font("System", FontWeight.BOLD, 36));
			lbl.setTextFill(Color.WHITE);

			lblChips = new Label();
			lblChips.setText("500");
			lblChips.setPrefSize(175, 40);
			lblChips.setAlignment(Pos.CENTER);
			lblChips.setFont(Font.font("System", FontWeight.BOLD, 36));
			lblChips.setTextFill(Color.WHITE);
			lblChips.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, 
					BorderWidths.DEFAULT, new Insets(0, 0, 0, 0))));

			lblPlayer = new Label("Player has:");
			lblPlayer.setFont(Font.font("System", FontWeight.BOLD, 18));
			lblPlayer.setAlignment(Pos.CENTER);
			lblPlayer.setPrefSize(150, 40);
			lblPlayer.setTextFill(Color.WHITE);

			lblBanker = new Label("Banker has:");
			lblBanker.setFont(Font.font("System", FontWeight.BOLD, 18));
			lblBanker.setAlignment(Pos.CENTER);
			lblBanker.setPrefSize(150, 40);
			lblBanker.setTextFill(Color.WHITE);

			lblPTotal = new Label();
			lblPTotal.setFont(Font.font("System", FontWeight.BOLD, 28));
			lblPTotal.setAlignment(Pos.CENTER);
			lblPTotal.setTextFill(Color.WHITE);
			lblPTotal.setPrefSize(150, 40);
			lblPTotal.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, 
					BorderWidths.DEFAULT, null)));

			lblBTotal = new Label();
			lblBTotal.setFont(Font.font("System", FontWeight.BOLD, 28));
			lblBTotal.setAlignment(Pos.CENTER);
			lblBTotal.setTextFill(Color.WHITE);
			lblBTotal.setPrefSize(150, 40);
			lblBTotal.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, null)));

			lblResult = new Label();
			lblResult.setPrefSize(200, 40);
			lblResult.setFont(Font.font("System", FontWeight.BOLD, 18));
			lblResult.setTextFill(Color.WHITE);
			lblResult.setText("Place BET to begin!");
			lblResult.setAlignment(Pos.CENTER);

			txtBet = new TextField();
			txtBet.setEditable(true);
			txtBet.setAlignment(Pos.CENTER);
			txtBet.setPrefSize(120, 40);
			txtBet.setMaxSize(120, 40);

			btnBet = new Button("PLACE BET");
			btnBet.setPrefSize(120, 40);
			btnBet.setFocusTraversable(false);

			btnQuit = new Button("QUIT");
			btnQuit.setPrefSize(120, 40);
			btnQuit.setFocusTraversable(false);
			btnQuit.setOnAction(new EventHandler<ActionEvent>() {
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

			btnDeal = new Button("DEAL");
			btnDeal.setPrefSize(120, 40);
			btnDeal.setDisable(true);
			btnDeal.setFocusTraversable(false);
			
			btnBet.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					try {
						ad = Integer.parseInt(txtBet.getText());
						if(ad <= Integer.valueOf(lblChips.getText()) && ad>=1)
						{
							btnBet.setDisable(true);
							btnDeal.setDisable(false);
							lblResult.setText("Click DEAL!");
							txtBet.setEditable(false);
						}
						if(ad> Integer.valueOf(lblChips.getText()))
								{
							Alert alert = new Alert(AlertType.ERROR);
							alert.setHeaderText(null);
							alert.setContentText("Your bet cannot exceed" + " $" + Integer.valueOf(lblChips.getText()) + "!");
							alert.setTitle("Invalid bet!");
							alert.showAndWait();
								}
						if(ad<1)
						{
							Alert alert = new Alert(AlertType.ERROR);
							alert.setHeaderText(null);
							alert.setContentText("You must bet at least $1!");
							alert.setTitle("Invalid bet!");
							alert.showAndWait();

						}
						if(txtBet.getText().trim().isEmpty())
						{
							Alert alert = new Alert(AlertType.ERROR);
							alert.setHeaderText(null);
							alert.setContentText("You must enter a number");
							alert.setTitle("Invalid bet!");
							alert.showAndWait();
						}

					} catch (NumberFormatException b) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setHeaderText(null);
						alert.setContentText("You must enter an integer!");
						alert.setTitle("Invalid bet!");
						alert.showAndWait();
					    // One of the integer fields failed to parse. Do something to alert the user.
					}
				}
			});
	        
			imgPlayer = new ImageView[3];

			for (int i = 0; i < imgPlayer.length; i++)
			{
				imgPlayer[i] = new ImageView("file:images/back_blue.png");
				StackPane.setMargin(imgPlayer[i], new Insets(yPos, 0, 0, 250));
				yPos += 75;
			}

			yPos = 175;

			imgBanker = new ImageView[3];

			for (int i = 0; i < 3; i++)
			{
				imgBanker[i] = new ImageView("file:images/back_blue.png");
				StackPane.setMargin(imgBanker[i], new Insets(yPos, 0, 0, 600));
				yPos += 75;
			}
		     clicked = 0;

			btnDeal.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
			        
				        randPos = rgen.nextInt(cards.length);
				        randPos2 = rgen2.nextInt(cards.length);
				        randPos5 = rgen5.nextInt(cards.length);

				        
					imgPlayer[0].setImage(new Image("file:images/" + 
							cards[randPos] + ".png"));
					imgPlayer[0].setId(cardvalue[randPos]);//setting the value of the card 
					int first_card = Integer.valueOf(imgPlayer[0].getId());
					imgPlayer[1].setImage(new Image("file:images/" + 
							cards[randPos2] + ".png"));
					imgPlayer[1].setId(cardvalue[randPos2]);//setting the value of the card 
					int second_card = Integer.valueOf(imgPlayer[1].getId());
                     sum = first_card + second_card;
                     score = sum % 10;
                     final_score = Integer.toString(score);

                     lblPTotal.setText(final_score);
         			if(lblPTotal.getText().equals("9"))
        			{
         				result = Integer.valueOf(lblChips.getText());		

         				int b = result + ad;
         			    String str4 = new Integer(b).toString(); 
         				lblChips.setText(str4);
        				lblResult.setText("Player wins!");
        				btnBet.setDisable(false);
        				btnDeal.setDisable(true);
						txtBet.setEditable(true);
						btnDeal.setText("DEAL");
        			}
				        randPos3 = rgen3.nextInt(cards.length);
				        randPos4 = rgen4.nextInt(cards.length); 
				        randPos6 = rgen6.nextInt(cards.length);

					imgBanker[0].setImage(new Image("file:images/" + 
							cards[randPos3] + ".png"));

					imgBanker[0].setId(cardvalue[randPos3]);//setting the value of the card 
					int third_card = Integer.valueOf(imgBanker[0].getId());


					imgBanker[1].setImage(new Image("file:images/" + 
							cards[randPos4] + ".png"));
					imgBanker[1].setId(cardvalue[randPos4]);//setting the value of the card 

					int fourth_card = Integer.valueOf(imgBanker[1].getId());

                    int sum2 = third_card + fourth_card;
                    int score2 = sum2 % 10;
                    String final_score2 = Integer.toString(score2);
                    lblBTotal.setText(final_score2);
                    if((score == 6 || score == 7 || score == 8) && (score2 ==5 || score2 == 4|| score2 == 3 ||  score2 == 2 ||  score2 == 1 ||  score2 == 0))
                   	{ 
         				lblResult.setText("Draw one more card!");
        				btnDeal.setText("DRAW CARD");   
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
        				public void handle(ActionEvent event2)
                        {
            				imgBanker[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));

           					imgBanker[2].setId(cardvalue[randPos6]);//setting the value of the card 
           					sixth_card = Integer.valueOf(imgBanker[2].getId());	
           				 sum = first_card + second_card;
        					int sum2  = third_card + fourth_card + sixth_card;
        					 score = sum % 10;
                            int score2 = sum2 % 10;
                             final_score = Integer.toString(score);
                            String final_score2 = Integer.toString(score2); 

                             lblPTotal.setText(final_score);
                             lblBTotal.setText(final_score2);
                             
                             if(score > score2)
                             {
                           	  Integer result1 = Integer.valueOf(lblChips.getText());		
              				int a = result1 + ad;
              			    String str5 = new Integer(a).toString(); 
              				lblChips.setText(str5);
           				lblResult.setText("Player wins!");
         				btnBet.setDisable(false);
         				btnDeal.setDisable(true);
         				txtBet.setEditable(true);
         				btnDeal.setText("DEAL");
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
        				public void handle(ActionEvent event3)
                        {
            				imgBanker[2].setImage(new Image("file:images/back_blue.png"));
        				run();
        				//STARTS
        				}
        				});
                             }
        				//SECOND
                             if( score2 > score)
                             {
                           	 Integer result1 = Integer.valueOf(lblChips.getText());		
              				int a = result1 - ad;
              			    String str5 = new Integer(a).toString(); 
              				lblChips.setText(str5);
           				lblResult.setText("Banker wins!");      
         				btnBet.setDisable(false);
         				btnDeal.setDisable(true);
         				txtBet.setEditable(true);
         				btnDeal.setText("DEAL");
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
        				public void handle(ActionEvent event3)
        				{
        					imgBanker[2].setImage(new Image("file:images/back_blue.png"));
        					run();
        				}
    				});
                             }
                             //THIRD
                             if(score == score2)
                             {
                 				lblResult.setText("TIE");
                 				btnBet.setDisable(false);
                 				btnDeal.setDisable(true);
                 				txtBet.setEditable(true);
                 				btnDeal.setText("DEAL");
                 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
                    				public void handle(ActionEvent event3)
                    				{
                    					run();
                    					imgBanker[2].setImage(new Image("file:images/back_blue.png"));
                    				}
                 				});

                             }
      
        				}
                   	});
                   	}
                    if(score == 5 || score == 4 || score ==3 || score == 2 || score == 1 || score ==0)
                   	{ 
         				lblResult.setText("Draw one more card!");
        				btnDeal.setText("DRAW CARD");   
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
        				public void handle(ActionEvent event2)
                        {
            				imgPlayer[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));

            				imgPlayer[2].setId(cardvalue[randPos6]);//setting the value of the card 
           					sixth_card = Integer.valueOf(imgPlayer[2].getId());	
           				 sum = first_card + second_card + sixth_card;
        					int sum2  = third_card + fourth_card;
        					 score = sum % 10;
                            int score2 = sum2 % 10;
                             final_score = Integer.toString(score);
                            String final_score2 = Integer.toString(score2);

                             lblPTotal.setText(final_score);
                             lblBTotal.setText(final_score2);
                             
                             if(score > score2)
                             {
                           	  Integer result1 = Integer.valueOf(lblChips.getText());		
              				int a = result1 + ad;
              			    String str5 = new Integer(a).toString(); 
              				lblChips.setText(str5);
           				lblResult.setText("Player wins!");
         				btnBet.setDisable(false);
         				btnDeal.setDisable(true);
         				txtBet.setEditable(true);
         				btnDeal.setText("DEAL");
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
        				public void handle(ActionEvent event3)
                        {
            				imgPlayer[2].setImage(new Image("file:images/back_blue.png"));
        				run();
        				//STARTS
        				}
        				});
                             }
        				//SECOND
                             if( score2 > score)
                             {
                           	 Integer result1 = Integer.valueOf(lblChips.getText());		
              				int a = result1 - ad;
              			    String str5 = new Integer(a).toString(); 
              				lblChips.setText(str5);
           				lblResult.setText("Banker wins!");      
         				btnBet.setDisable(false);
         				btnDeal.setDisable(true);
         				txtBet.setEditable(true);
         				btnDeal.setText("DEAL");
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
        				public void handle(ActionEvent event3)
        				{
        					imgPlayer[2].setImage(new Image("file:images/back_blue.png"));
        					run();
        				}
    				});
                             }
                             //THIRD
                             if(score == score2)
                             {
                 				lblResult.setText("TIE");
                 				btnBet.setDisable(false);
                 				btnDeal.setDisable(true);
                 				txtBet.setEditable(true);
                 				btnDeal.setText("DEAL");
                 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
                    				public void handle(ActionEvent event3)
                    				{
                    					run();
                    					imgPlayer[2].setImage(new Image("file:images/back_blue.png"));
                    				}
                 				});

                             }
      
        				}
                   	});
                   	}
                    if((score == 5 || score == 4 || score ==3 || score == 2 || score == 1 || score ==0) && (score2 ==0 || score2 == 1|| score2 == 2))
                   	{ 
         				lblResult.setText("Draw one more card!");
        				btnDeal.setText("DRAW CARD");   
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
        				public void handle(ActionEvent event2)
                        {
            				imgBanker[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));

            				imgBanker[2].setId(cardvalue[randPos6]);//setting the value of the card 
            				imgPlayer[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));

            				imgPlayer[2].setId(cardvalue[randPos6]);//setting the value of the card 
           					sixth_card = Integer.valueOf(imgBanker[2].getId());	
           					fifth_card = Integer.valueOf(imgPlayer[2].getId());	
           				 sum = first_card + second_card + fifth_card;
        					int sum2  = third_card + fourth_card + sixth_card;
        					 score = sum % 10;
                            int score2 = sum2 % 10;
                             final_score = Integer.toString(score);
                            String final_score2 = Integer.toString(score2);

                             lblPTotal.setText(final_score);
                             lblBTotal.setText(final_score2);
                             
                             if(score > score2)
                             {
                           	  Integer result1 = Integer.valueOf(lblChips.getText());		
              				int a = result1 + ad;
              			    String str5 = new Integer(a).toString(); 
              				lblChips.setText(str5);
           				lblResult.setText("Player wins!");
         				btnBet.setDisable(false);
         				btnDeal.setDisable(true);
         				txtBet.setEditable(true);
         				btnDeal.setText("DEAL");
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
        				public void handle(ActionEvent event3)
                        {
            				imgPlayer[2].setImage(new Image("file:images/back_blue.png"));
            				imgBanker[2].setImage(new Image("file:images/back_blue.png"));
        				run();
        				//STARTS
        				}
        				});
                             }
        				//SECOND
                             if( score2 > score)
                             {
                           	 Integer result1 = Integer.valueOf(lblChips.getText());		
              				int a = result1 - ad;
              			    String str5 = new Integer(a).toString(); 
              				lblChips.setText(str5);
           				lblResult.setText("Banker wins!");      
         				btnBet.setDisable(false);
         				btnDeal.setDisable(true);
         				txtBet.setEditable(true);
         				btnDeal.setText("DEAL");
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
        				public void handle(ActionEvent event3)
        				{
            				imgPlayer[2].setImage(new Image("file:images/back_blue.png"));
        					imgBanker[2].setImage(new Image("file:images/back_blue.png"));
        					run();
        				}
    				});
                             }
                             //THIRD
                             if(score == score2)
                             {
                 				lblResult.setText("TIE");
                 				btnBet.setDisable(false);
                 				btnDeal.setDisable(true);
                 				txtBet.setEditable(true);
                 				btnDeal.setText("DEAL");
                 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
                    				public void handle(ActionEvent event3)
                    				{
                    					imgPlayer[2].setImage(new Image("file:images/back_blue.png"));
                    					imgBanker[2].setImage(new Image("file:images/back_blue.png"));
                    					run();
                    				}
                 				});

                             }
      
        				}
                   	});
                   	}
                    if((score == 7 || score == 6 || score == 5 || score == 4 || score ==3 || score == 2 || score == 1 || score ==0) && (score2 == 3))
                   	{ 
         				lblResult.setText("Draw one more card!");
        				btnDeal.setText("DRAW CARD");   
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
        				public void handle(ActionEvent event2)
                        {
            				imgBanker[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));

            				imgBanker[2].setId(cardvalue[randPos6]);//setting the value of the card 
            				imgPlayer[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));

            				imgPlayer[2].setId(cardvalue[randPos6]);//setting the value of the card 
           					sixth_card = Integer.valueOf(imgBanker[2].getId());	
           					fifth_card = Integer.valueOf(imgPlayer[2].getId());	
           				 sum = first_card + second_card + fifth_card;
        					int sum2  = third_card + fourth_card + sixth_card;
        					 score = sum % 10;
                            int score2 = sum2 % 10;
                             final_score = Integer.toString(score);
                            String final_score2 = Integer.toString(score2);

                             lblPTotal.setText(final_score);
                             lblBTotal.setText(final_score2);
                             
                             if(score > score2)
                             {
                           	  Integer result1 = Integer.valueOf(lblChips.getText());		
              				int a = result1 + ad;
              			    String str5 = new Integer(a).toString(); 
              				lblChips.setText(str5);
           				lblResult.setText("Player wins!");
         				btnBet.setDisable(false);
         				btnDeal.setDisable(true);
         				txtBet.setEditable(true);
         				btnDeal.setText("DEAL");
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
        				public void handle(ActionEvent event3)
                        {
            				imgPlayer[2].setImage(new Image("file:images/back_blue.png"));
            				imgBanker[2].setImage(new Image("file:images/back_blue.png"));
        				run();
        				//STARTS
        				}
        				});
                             }
        				//SECOND
                             if( score2 > score)
                             {
                           	 Integer result1 = Integer.valueOf(lblChips.getText());		
              				int a = result1 - ad;
              			    String str5 = new Integer(a).toString(); 
              				lblChips.setText(str5);
           				lblResult.setText("Banker wins!");      
         				btnBet.setDisable(false);
         				btnDeal.setDisable(true);
         				txtBet.setEditable(true);
         				btnDeal.setText("DEAL");
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
        				public void handle(ActionEvent event3)
        				{
            				imgPlayer[2].setImage(new Image("file:images/back_blue.png"));
        					imgBanker[2].setImage(new Image("file:images/back_blue.png"));
        					run();
        				}
    				});
                             }
                             //THIRD
                             if(score == score2)
                             {
                 				lblResult.setText("TIE");
                 				btnBet.setDisable(false);
                 				btnDeal.setDisable(true);
                 				txtBet.setEditable(true);
                 				btnDeal.setText("DEAL");
                 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
                    				public void handle(ActionEvent event3)
                    				{
                    					imgPlayer[2].setImage(new Image("file:images/back_blue.png"));
                    					imgBanker[2].setImage(new Image("file:images/back_blue.png"));
                    					run();
                    				}
                 				});

                             }
      
        				}
                   	});
                   	}
                    if((score == 7 || score == 6 || score == 5 || score == 4 || score ==3 || score == 2 ) && (score2 == 4))
                   	{ 
         				lblResult.setText("Draw one more card!");
        				btnDeal.setText("DRAW CARD");   
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
        				public void handle(ActionEvent event2)
                        {
            				imgBanker[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));

            				imgBanker[2].setId(cardvalue[randPos6]);//setting the value of the card 
            				imgPlayer[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));

            				imgPlayer[2].setId(cardvalue[randPos6]);//setting the value of the card 
           					sixth_card = Integer.valueOf(imgBanker[2].getId());	
           					fifth_card = Integer.valueOf(imgPlayer[2].getId());	
           				 sum = first_card + second_card + fifth_card;
        					int sum2  = third_card + fourth_card + sixth_card;
        					 score = sum % 10;
                            int score2 = sum2 % 10;
                             final_score = Integer.toString(score);
                            String final_score2 = Integer.toString(score2);

                             lblPTotal.setText(final_score);
                             lblBTotal.setText(final_score2);
                             
                             if(score > score2)
                             {
                           	  Integer result1 = Integer.valueOf(lblChips.getText());		
              				int a = result1 + ad;
              			    String str5 = new Integer(a).toString(); 
              				lblChips.setText(str5);
           				lblResult.setText("Player wins!");
         				btnBet.setDisable(false);
         				btnDeal.setDisable(true);
         				txtBet.setEditable(true);
         				btnDeal.setText("DEAL");
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
        				public void handle(ActionEvent event3)
                        {
            				imgPlayer[2].setImage(new Image("file:images/back_blue.png"));
            				imgBanker[2].setImage(new Image("file:images/back_blue.png"));
        				run();
        				//STARTS
        				}
        				});
                             }
        				//SECOND
                             if( score2 > score)
                             {
                           	 Integer result1 = Integer.valueOf(lblChips.getText());		
              				int a = result1 - ad;
              			    String str5 = new Integer(a).toString(); 
              				lblChips.setText(str5);
           				lblResult.setText("Banker wins!");      
         				btnBet.setDisable(false);
         				btnDeal.setDisable(true);
         				txtBet.setEditable(true);
         				btnDeal.setText("DEAL");
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
        				public void handle(ActionEvent event3)
        				{
            				imgPlayer[2].setImage(new Image("file:images/back_blue.png"));
        					imgBanker[2].setImage(new Image("file:images/back_blue.png"));
        					run();
        				}
    				});
                             }
                             //THIRD
                             if(score == score2)
                             {
                 				lblResult.setText("TIE");
                 				btnBet.setDisable(false);
                 				btnDeal.setDisable(true);
                 				txtBet.setEditable(true);
                 				btnDeal.setText("DEAL");
                 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
                    				public void handle(ActionEvent event3)
                    				{
                    					imgPlayer[2].setImage(new Image("file:images/back_blue.png"));
                    					imgBanker[2].setImage(new Image("file:images/back_blue.png"));
                    					run();
                    				}
                 				});

                             }
      
        				}
                   	});
                   	}
                    if((score == 7 || score == 6 || score == 5 || score == 4) && (score2 == 5))
                   	{ 
         				lblResult.setText("Draw one more card!");
        				btnDeal.setText("DRAW CARD");   
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
        				public void handle(ActionEvent event2)
                        {
            				imgBanker[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));

            				imgBanker[2].setId(cardvalue[randPos6]);//setting the value of the card 
            				imgPlayer[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));

            				imgPlayer[2].setId(cardvalue[randPos6]);//setting the value of the card 
           					sixth_card = Integer.valueOf(imgBanker[2].getId());	
           					fifth_card = Integer.valueOf(imgPlayer[2].getId());	
           				 sum = first_card + second_card + fifth_card;
        					int sum2  = third_card + fourth_card + sixth_card;
        					 score = sum % 10;
                            int score2 = sum2 % 10;
                             final_score = Integer.toString(score);
                            String final_score2 = Integer.toString(score2);

                             lblPTotal.setText(final_score);
                             lblBTotal.setText(final_score2);
                             
                             if(score > score2)
                             {
                           	  Integer result1 = Integer.valueOf(lblChips.getText());		
              				int a = result1 + ad;
              			    String str5 = new Integer(a).toString(); 
              				lblChips.setText(str5);
           				lblResult.setText("Player wins!");
         				btnBet.setDisable(false);
         				btnDeal.setDisable(true);
         				txtBet.setEditable(true);
         				btnDeal.setText("DEAL");
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
        				public void handle(ActionEvent event3)
                        {
            				imgPlayer[2].setImage(new Image("file:images/back_blue.png"));
            				imgBanker[2].setImage(new Image("file:images/back_blue.png"));
        				run();
        				//STARTS
        				}
        				});
                             }
        				//SECOND
                             if( score2 > score)
                             {
                           	 Integer result1 = Integer.valueOf(lblChips.getText());		
              				int a = result1 - ad;
              			    String str5 = new Integer(a).toString(); 
              				lblChips.setText(str5);
           				lblResult.setText("Banker wins!");      
         				btnBet.setDisable(false);
         				btnDeal.setDisable(true);
         				txtBet.setEditable(true);
         				btnDeal.setText("DEAL");
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
        				public void handle(ActionEvent event3)
        				{
            				imgPlayer[2].setImage(new Image("file:images/back_blue.png"));
        					imgBanker[2].setImage(new Image("file:images/back_blue.png"));
        					run();
        				}
    				});
                             }
                             //THIRD
                             if(score == score2)
                             {
                 				lblResult.setText("TIE");
                 				btnBet.setDisable(false);
                 				btnDeal.setDisable(true);
                 				txtBet.setEditable(true);
                 				btnDeal.setText("DEAL");
                 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
                    				public void handle(ActionEvent event3)
                    				{
                    					imgPlayer[2].setImage(new Image("file:images/back_blue.png"));
                    					imgBanker[2].setImage(new Image("file:images/back_blue.png"));
                    					run();
                    				}
                 				});

                             }
      
        				}
                   	});
                   	}
                    if((score == 7 || score == 6 ) && (score2 == 6))
                   	{ 
         				lblResult.setText("Draw one more card!");
        				btnDeal.setText("DRAW CARD");   
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
        				public void handle(ActionEvent event2)
                        {
            				imgBanker[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));

            				imgBanker[2].setId(cardvalue[randPos6]);//setting the value of the card 
            				imgPlayer[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));

            				imgPlayer[2].setId(cardvalue[randPos6]);//setting the value of the card 
           					sixth_card = Integer.valueOf(imgBanker[2].getId());	
           					fifth_card = Integer.valueOf(imgPlayer[2].getId());	
           				 sum = first_card + second_card + fifth_card;
        					int sum2  = third_card + fourth_card + sixth_card;
        					 score = sum % 10;
                            int score2 = sum2 % 10;
                             final_score = Integer.toString(score);
                            String final_score2 = Integer.toString(score2);

                             lblPTotal.setText(final_score);
                             lblBTotal.setText(final_score2);
                             
                             if(score > score2)
                             {
                           	  Integer result1 = Integer.valueOf(lblChips.getText());		
              				int a = result1 + ad;
              			    String str5 = new Integer(a).toString(); 
              				lblChips.setText(str5);
           				lblResult.setText("Player wins!");
         				btnBet.setDisable(false);
         				btnDeal.setDisable(true);
         				txtBet.setEditable(true);
         				btnDeal.setText("DEAL");
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
        				public void handle(ActionEvent event3)
                        {
            				imgPlayer[2].setImage(new Image("file:images/back_blue.png"));
            				imgBanker[2].setImage(new Image("file:images/back_blue.png"));
        				run();
        				//STARTS
        				}
        				});
                             }
        				//SECOND
                             if( score2 > score)
                             {
                           	 Integer result1 = Integer.valueOf(lblChips.getText());		
              				int a = result1 - ad;
              			    String str5 = new Integer(a).toString(); 
              				lblChips.setText(str5);
           				lblResult.setText("Banker wins!");      
         				btnBet.setDisable(false);
         				btnDeal.setDisable(true);
         				txtBet.setEditable(true);
         				btnDeal.setText("DEAL");
        				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
        				public void handle(ActionEvent event3)
        				{
            				imgPlayer[2].setImage(new Image("file:images/back_blue.png"));
        					imgBanker[2].setImage(new Image("file:images/back_blue.png"));
        					run();
        				}
    				});
                             }
                             //THIRD
                             if(score == score2)
                             {
                 				lblResult.setText("TIE");
                 				btnBet.setDisable(false);
                 				btnDeal.setDisable(true);
                 				txtBet.setEditable(true);
                 				btnDeal.setText("DEAL");
                 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
                    				public void handle(ActionEvent event3)
                    				{
                    					imgPlayer[2].setImage(new Image("file:images/back_blue.png"));
                    					imgBanker[2].setImage(new Image("file:images/back_blue.png"));
                    					run();
                    				}
                 				});

                             }
      
        				}
                   	});
                   	}
         			if(lblBTotal.getText().equals("9"))
        			{
         				Integer result1 = Integer.valueOf(lblChips.getText());		
         				int a = result1 - ad;
         			    String str5 = new Integer(a).toString(); 
         				lblChips.setText(str5);
        				lblResult.setText("Banker wins!");
        				btnBet.setDisable(false);
        				btnDeal.setDisable(true);
						txtBet.setEditable(true);
						btnDeal.setText("DEAL");
        			}
         			if((lblPTotal.getText().equals("9")) && (lblBTotal.getText().equals("9")))
			{
				lblResult.setText("It's a TIE");
				btnBet.setDisable(false);
				btnDeal.setDisable(true);
				txtBet.setEditable(true);
				btnDeal.setText("DEAL");
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
				Random rgen = new Random();
			    Random rgen2 = new Random();
			    Random rgen3 = new Random();
			    Random rgen4 = new Random();
			    Random rgen5 = new Random();
			    Random rgen6 = new Random();
			        randPos = rgen.nextInt(cards.length);
			        randPos2 = rgen2.nextInt(cards.length);
			        randPos5 = rgen5.nextInt(cards.length);

			        
				imgPlayer[0].setImage(new Image("file:images/" + 
						cards[randPos] + ".png"));
				imgPlayer[0].setId(cardvalue[randPos]);//setting the value of the card 
				int first_card = Integer.valueOf(imgPlayer[0].getId());
				imgPlayer[1].setImage(new Image("file:images/" + 
						cards[randPos2] + ".png"));
				imgPlayer[1].setId(cardvalue[randPos2]);//setting the value of the card 
				int second_card = Integer.valueOf(imgPlayer[1].getId());
              sum = first_card + second_card;
              score = sum % 10;
              final_score = Integer.toString(score);

              lblPTotal.setText(final_score);
  			if(lblPTotal.getText().equals("9"))
 			{
  				result = Integer.valueOf(lblChips.getText());		

  				int b = result + ad;
  			    String str4 = new Integer(b).toString(); 
  				lblChips.setText(str4);
 				lblResult.setText("Player wins!");
 				btnBet.setDisable(false);
 				btnDeal.setDisable(true);
					txtBet.setEditable(true);
					btnDeal.setText("DEAL");
 			}
			        randPos3 = rgen3.nextInt(cards.length);
			        randPos4 = rgen4.nextInt(cards.length);
			        randPos6 = rgen6.nextInt(cards.length);

				imgBanker[0].setImage(new Image("file:images/" + 
						cards[randPos3] + ".png"));

				imgBanker[0].setId(cardvalue[randPos3]);//setting the value of the card 
				int third_card = Integer.valueOf(imgBanker[0].getId());


				imgBanker[1].setImage(new Image("file:images/" + 
						cards[randPos4] + ".png"));
				imgBanker[1].setId(cardvalue[randPos4]);//setting the value of the card 

				int fourth_card = Integer.valueOf(imgBanker[1].getId());

             int sum2 = third_card + fourth_card;
             int score2 = sum2 % 10;
             String final_score2 = Integer.toString(score2);
             lblBTotal.setText(final_score2);
             if((score == 6 || score == 7) && (score2 ==5 || score2 == 4|| score2 == 3 ||  score2 == 2 ||  score2 == 1 ||  score2 == 0))
            	{
  				lblResult.setText("Draw one more card!");
 				btnDeal.setText("DRAW CARD");   
 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
 				public void handle(ActionEvent event2)
                 {
     				imgBanker[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));

    					imgBanker[2].setId(cardvalue[randPos6]);//setting the value of the card 
    					sixth_card = Integer.valueOf(imgBanker[2].getId());	
    				 sum = first_card + second_card;
 					int sum2  = third_card + fourth_card + sixth_card;
 					 score = sum % 10;
                     int score2 = sum2 % 10;
                      final_score = Integer.toString(score);
                     String final_score2 = Integer.toString(score2);

                      lblPTotal.setText(final_score);
                      lblBTotal.setText(final_score2);

                      if(score > score2)
                      {
                    	  Integer result1 = Integer.valueOf(lblChips.getText());		
       				int a = result1 + ad;
       			    String str5 = new Integer(a).toString(); 
       				lblChips.setText(str5);
    				lblResult.setText("Player wins!");
  				btnBet.setDisable(false);
  				btnDeal.setDisable(true);
  				txtBet.setEditable(true);
  				btnDeal.setText("DEAL");
 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
 				public void handle(ActionEvent event3)
                 {
 					imgBanker[2].setImage(new Image("file:images/back_blue.png"));
 				run();
 				//STARTS

 				}
 				});
                      }
 				//SECOND
                      if( score2 > score)
                      {
                    	 Integer result1 = Integer.valueOf(lblChips.getText());		
       				int a = result1 - ad;
       			    String str5 = new Integer(a).toString(); 
       				lblChips.setText(str5);
    				lblResult.setText("Banker wins!");      
  				btnBet.setDisable(false);
  				btnDeal.setDisable(true);
  				txtBet.setEditable(true);
  				btnDeal.setText("DEAL");
 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
 				public void handle(ActionEvent event3)
 				{
    				imgBanker[2].setImage(new Image("file:images/back_blue.png"));
 					run();
 				}
				});
                      }
                      //THIRD
                      if(score == score2)
                      {
          				lblResult.setText("TIE");
          				btnBet.setDisable(false);
          				btnDeal.setDisable(true);
          				txtBet.setEditable(true);
          				btnDeal.setText("DEAL");
          				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
             				public void handle(ActionEvent event3)
             				{
                				imgBanker[2].setImage(new Image("file:images/back_blue.png"));
             					run();
             				}
          				});

                      }

 				}
            	});
            	}
			
             if(score == 5 || score == 4 || score ==3 || score == 2 || score == 1 || score ==0)
            	{ 
  				lblResult.setText("Draw one more card!");
 				btnDeal.setText("DRAW CARD");   
 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
 				public void handle(ActionEvent event2)
                 {
     				imgPlayer[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));

     				imgPlayer[2].setId(cardvalue[randPos6]);//setting the value of the card 
    					sixth_card = Integer.valueOf(imgPlayer[2].getId());	
    				 sum = first_card + second_card + sixth_card;
 					int sum2  = third_card + fourth_card;
 					 score = sum % 10;
                     int score2 = sum2 % 10;
                      final_score = Integer.toString(score);
                     String final_score2 = Integer.toString(score2);

                      lblPTotal.setText(final_score);
                      lblBTotal.setText(final_score2);
                      
                      if(score > score2)
                      {
                    	  Integer result1 = Integer.valueOf(lblChips.getText());		
       				int a = result1 + ad;
       			    String str5 = new Integer(a).toString(); 
       				lblChips.setText(str5);
    				lblResult.setText("Player wins!");
  				btnBet.setDisable(false);
  				btnDeal.setDisable(true);
  				txtBet.setEditable(true);
  				btnDeal.setText("DEAL");
 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
 				public void handle(ActionEvent event3)
                 {
     				imgPlayer[2].setImage(new Image("file:images/back_blue.png"));
 				run();
 				//STARTS
 				}
 				});
                      }
 				//SECOND
                      if( score2 > score)
                      {
                    	 Integer result1 = Integer.valueOf(lblChips.getText());		
       				int a = result1 - ad;
       			    String str5 = new Integer(a).toString(); 
       				lblChips.setText(str5);
    				lblResult.setText("Banker wins!");      
  				btnBet.setDisable(false);
  				btnDeal.setDisable(true);
  				txtBet.setEditable(true);
  				btnDeal.setText("DEAL");
 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
 				public void handle(ActionEvent event3)
 				{
 					imgPlayer[2].setImage(new Image("file:images/back_blue.png"));
 					run();
 				}
				});
                      }
                      //THIRD
                      if(score == score2)
                      {
          				lblResult.setText("TIE");
          				btnBet.setDisable(false);
          				btnDeal.setDisable(true);
          				txtBet.setEditable(true);
          				btnDeal.setText("DEAL");
          				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
             				public void handle(ActionEvent event3)
             				{
             					run();
             					imgPlayer[2].setImage(new Image("file:images/back_blue.png"));
             				}
          				});

                      }

 				}
            	});
            	}
             if((score == 5 || score == 4 || score ==3 || score == 2 || score == 1 || score ==0) && (score2 ==0 || score2 == 1|| score2 == 2))
            	{ 
  				lblResult.setText("Draw one more card!");
 				btnDeal.setText("DRAW CARD");   
 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
 				public void handle(ActionEvent event2)
                 {
     				imgBanker[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));

     				imgBanker[2].setId(cardvalue[randPos6]);//setting the value of the card 
    					sixth_card = Integer.valueOf(imgBanker[2].getId());	
    				 sum = first_card + second_card;
 					int sum2  = third_card + fourth_card + sixth_card;
 					 score = sum % 10;
                     int score2 = sum2 % 10;
                      final_score = Integer.toString(score);
                     String final_score2 = Integer.toString(score2);

                      lblPTotal.setText(final_score);
                      lblBTotal.setText(final_score2);
                      
                      if(score > score2)
                      {
                    	  Integer result1 = Integer.valueOf(lblChips.getText());		
       				int a = result1 + ad;
       			    String str5 = new Integer(a).toString(); 
       				lblChips.setText(str5);
    				lblResult.setText("Player wins!");
  				btnBet.setDisable(false);
  				btnDeal.setDisable(true);
  				txtBet.setEditable(true);
  				btnDeal.setText("DEAL");
 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
 				public void handle(ActionEvent event3)
                 {
     				imgBanker[2].setImage(new Image("file:images/back_blue.png"));
 				run();
 				//STARTS
 				}
 				});
                      }
 				//SECOND
                      if( score2 > score)
                      {
                    	 Integer result1 = Integer.valueOf(lblChips.getText());		
       				int a = result1 - ad;
       			    String str5 = new Integer(a).toString(); 
       				lblChips.setText(str5);
    				lblResult.setText("Banker wins!");      
  				btnBet.setDisable(false);
  				btnDeal.setDisable(true);
  				txtBet.setEditable(true);
  				btnDeal.setText("DEAL");
 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
 				public void handle(ActionEvent event3)
 				{
 					imgBanker[2].setImage(new Image("file:images/back_blue.png"));
 					run();
 				}
				});
                      }
                      //THIRD
                      if(score == score2)
                      {
          				lblResult.setText("TIE");
          				btnBet.setDisable(false);
          				btnDeal.setDisable(true);
          				txtBet.setEditable(true);
          				btnDeal.setText("DEAL");
          				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
             				public void handle(ActionEvent event3)
             				{
             					imgBanker[2].setImage(new Image("file:images/back_blue.png"));
             					run();
             				}
          				});

                      }

 				}
            	});
            	}
             
             if((score == 5 || score == 4 || score ==3 || score == 2 || score == 1 || score ==0) && (score2 ==0 || score2 == 1|| score2 == 2))
            	{ 
  				lblResult.setText("Draw one more card!");
 				btnDeal.setText("DRAW CARD");   
 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
 				public void handle(ActionEvent event2)
                 {
     				imgBanker[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));

     				imgBanker[2].setId(cardvalue[randPos6]);//setting the value of the card 
     				imgPlayer[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));

     				imgPlayer[2].setId(cardvalue[randPos6]);//setting the value of the card 
    					sixth_card = Integer.valueOf(imgBanker[2].getId());	
    					fifth_card = Integer.valueOf(imgPlayer[2].getId());	
    				 sum = first_card + second_card + fifth_card;
 					int sum2  = third_card + fourth_card + sixth_card;
 					 score = sum % 10;
                     int score2 = sum2 % 10;
                      final_score = Integer.toString(score);
                     String final_score2 = Integer.toString(score2);

                      lblPTotal.setText(final_score);
                      lblBTotal.setText(final_score2);
                      
                      if(score > score2)
                      {
                    	  Integer result1 = Integer.valueOf(lblChips.getText());		
       				int a = result1 + ad;
       			    String str5 = new Integer(a).toString(); 
       				lblChips.setText(str5);
    				lblResult.setText("Player wins!");
  				btnBet.setDisable(false);
  				btnDeal.setDisable(true);
  				txtBet.setEditable(true);
  				btnDeal.setText("DEAL");
 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
 				public void handle(ActionEvent event3)
                 {
     				imgPlayer[2].setImage(new Image("file:images/back_blue.png"));
     				imgBanker[2].setImage(new Image("file:images/back_blue.png"));
 				run();
 				//STARTS
 				}
 				});
                      }
 				//SECOND
                      if( score2 > score)
                      {
                    	 Integer result1 = Integer.valueOf(lblChips.getText());		
       				int a = result1 - ad;
       			    String str5 = new Integer(a).toString(); 
       				lblChips.setText(str5);
    				lblResult.setText("Banker wins!");      
  				btnBet.setDisable(false);
  				btnDeal.setDisable(true);
  				txtBet.setEditable(true);
  				btnDeal.setText("DEAL");
 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
 				public void handle(ActionEvent event3)
 				{
     				imgPlayer[2].setImage(new Image("file:images/back_blue.png"));
 					imgBanker[2].setImage(new Image("file:images/back_blue.png"));
 					run();
 				}
				});
                      }
                      //THIRD
                      if(score == score2)
                      {
          				lblResult.setText("TIE");
          				btnBet.setDisable(false);
          				btnDeal.setDisable(true);
          				txtBet.setEditable(true);
          				btnDeal.setText("DEAL");
          				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
             				public void handle(ActionEvent event3)
             				{
             					imgPlayer[2].setImage(new Image("file:images/back_blue.png"));
             					imgBanker[2].setImage(new Image("file:images/back_blue.png"));
             					run();
             				}
          				});

                      }

 				}
            	});
            	}
             if((score == 7 || score == 6 || score == 5 || score == 4 || score ==3 || score == 2 || score == 1 || score ==0) && (score2 == 3))
            	{ 
  				lblResult.setText("Draw one more card!");
 				btnDeal.setText("DRAW CARD");   
 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
 				public void handle(ActionEvent event2)
                 {
     				imgBanker[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));

     				imgBanker[2].setId(cardvalue[randPos6]);//setting the value of the card 
     				imgPlayer[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));

     				imgPlayer[2].setId(cardvalue[randPos6]);//setting the value of the card 
    					sixth_card = Integer.valueOf(imgBanker[2].getId());	
    					fifth_card = Integer.valueOf(imgPlayer[2].getId());	
    				 sum = first_card + second_card + fifth_card;
 					int sum2  = third_card + fourth_card + sixth_card;
 					 score = sum % 10;
                     int score2 = sum2 % 10;
                      final_score = Integer.toString(score);
                     String final_score2 = Integer.toString(score2);

                      lblPTotal.setText(final_score);
                      lblBTotal.setText(final_score2);
                      
                      if(score > score2)
                      {
                    	  Integer result1 = Integer.valueOf(lblChips.getText());		
       				int a = result1 + ad;
       			    String str5 = new Integer(a).toString(); 
       				lblChips.setText(str5);
    				lblResult.setText("Player wins!");
  				btnBet.setDisable(false);
  				btnDeal.setDisable(true);
  				txtBet.setEditable(true);
  				btnDeal.setText("DEAL");
 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
 				public void handle(ActionEvent event3)
                 {
     				imgPlayer[2].setImage(new Image("file:images/back_blue.png"));
     				imgBanker[2].setImage(new Image("file:images/back_blue.png"));
 				run();
 				//STARTS
 				}
 				});
                      }
 				//SECOND
                      if( score2 > score)
                      {
                    	 Integer result1 = Integer.valueOf(lblChips.getText());		
       				int a = result1 - ad;
       			    String str5 = new Integer(a).toString(); 
       				lblChips.setText(str5);
    				lblResult.setText("Banker wins!");      
  				btnBet.setDisable(false);
  				btnDeal.setDisable(true);
  				txtBet.setEditable(true);
  				btnDeal.setText("DEAL");
 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
 				public void handle(ActionEvent event3)
 				{
     				imgPlayer[2].setImage(new Image("file:images/back_blue.png"));
 					imgBanker[2].setImage(new Image("file:images/back_blue.png"));
 					run();
 				}
				});
                      }
                      //THIRD
                      if(score == score2)
                      {
          				lblResult.setText("TIE");
          				btnBet.setDisable(false);
          				btnDeal.setDisable(true);
          				txtBet.setEditable(true);
          				btnDeal.setText("DEAL");
          				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
             				public void handle(ActionEvent event3)
             				{
             					imgPlayer[2].setImage(new Image("file:images/back_blue.png"));
             					imgBanker[2].setImage(new Image("file:images/back_blue.png"));
             					run();
             				}
          				});

                      }

 				}
            	});
            	}
             if((score == 7 || score == 6 || score == 5 || score == 4 || score ==3 || score == 2 ) && (score2 == 4))
            	{ 
  				lblResult.setText("Draw one more card!");
 				btnDeal.setText("DRAW CARD");   
 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
 				public void handle(ActionEvent event2)
                 {
     				imgBanker[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));

     				imgBanker[2].setId(cardvalue[randPos6]);//setting the value of the card 
     				imgPlayer[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));

     				imgPlayer[2].setId(cardvalue[randPos6]);//setting the value of the card 
    					sixth_card = Integer.valueOf(imgBanker[2].getId());	
    					fifth_card = Integer.valueOf(imgPlayer[2].getId());	
    				 sum = first_card + second_card + fifth_card;
 					int sum2  = third_card + fourth_card + sixth_card;
 					 score = sum % 10;
                     int score2 = sum2 % 10;
                      final_score = Integer.toString(score);
                     String final_score2 = Integer.toString(score2);

                      lblPTotal.setText(final_score);
                      lblBTotal.setText(final_score2);
                      
                      if(score > score2)
                      {
                    	  Integer result1 = Integer.valueOf(lblChips.getText());		
       				int a = result1 + ad;
       			    String str5 = new Integer(a).toString(); 
       				lblChips.setText(str5);
    				lblResult.setText("Player wins!");
  				btnBet.setDisable(false);
  				btnDeal.setDisable(true);
  				txtBet.setEditable(true);
  				btnDeal.setText("DEAL");
 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
 				public void handle(ActionEvent event3)
                 {
     				imgPlayer[2].setImage(new Image("file:images/back_blue.png"));
     				imgBanker[2].setImage(new Image("file:images/back_blue.png"));
 				run();
 				//STARTS
 				}
 				});
                      }
 				//SECOND
                      if( score2 > score)
                      {
                    	 Integer result1 = Integer.valueOf(lblChips.getText());		
       				int a = result1 - ad;
       			    String str5 = new Integer(a).toString(); 
       				lblChips.setText(str5);
    				lblResult.setText("Banker wins!");      
  				btnBet.setDisable(false);
  				btnDeal.setDisable(true);
  				txtBet.setEditable(true);
  				btnDeal.setText("DEAL");
 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
 				public void handle(ActionEvent event3)
 				{
     				imgPlayer[2].setImage(new Image("file:images/back_blue.png"));
 					imgBanker[2].setImage(new Image("file:images/back_blue.png"));
 					run();
 				}
				});
                      }
                      //THIRD
                      if(score == score2)
                      {
          				lblResult.setText("TIE");
          				btnBet.setDisable(false);
          				btnDeal.setDisable(true);
          				txtBet.setEditable(true);
          				btnDeal.setText("DEAL");
          				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
             				public void handle(ActionEvent event3)
             				{
             					imgPlayer[2].setImage(new Image("file:images/back_blue.png"));
             					imgBanker[2].setImage(new Image("file:images/back_blue.png"));
             					run();
             				}
          				});

                      }

 				}
            	});
            	}
             if((score == 7 || score == 6 || score == 5 || score == 4) && (score2 == 5))
            	{ 
  				lblResult.setText("Draw one more card!");
 				btnDeal.setText("DRAW CARD");   
 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
 				public void handle(ActionEvent event2)
                 {
     				imgBanker[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));

     				imgBanker[2].setId(cardvalue[randPos6]);//setting the value of the card 
     				imgPlayer[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));

     				imgPlayer[2].setId(cardvalue[randPos6]);//setting the value of the card 
    					sixth_card = Integer.valueOf(imgBanker[2].getId());	
    					fifth_card = Integer.valueOf(imgPlayer[2].getId());	
    				 sum = first_card + second_card + fifth_card;
 					int sum2  = third_card + fourth_card + sixth_card;
 					 score = sum % 10;
                     int score2 = sum2 % 10;
                      final_score = Integer.toString(score);
                     String final_score2 = Integer.toString(score2);

                      lblPTotal.setText(final_score);
                      lblBTotal.setText(final_score2);
                      
                      if(score > score2)
                      {
                    	  Integer result1 = Integer.valueOf(lblChips.getText());		
       				int a = result1 + ad;
       			    String str5 = new Integer(a).toString(); 
       				lblChips.setText(str5);
    				lblResult.setText("Player wins!");
  				btnBet.setDisable(false);
  				btnDeal.setDisable(true);
  				txtBet.setEditable(true);
  				btnDeal.setText("DEAL");
 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
 				public void handle(ActionEvent event3)
                 {
     				imgPlayer[2].setImage(new Image("file:images/back_blue.png"));
     				imgBanker[2].setImage(new Image("file:images/back_blue.png"));
 				run();
 				//STARTS
 				}
 				});
                      }
 				//SECOND
                      if( score2 > score)
                      {
                    	 Integer result1 = Integer.valueOf(lblChips.getText());		
       				int a = result1 - ad;
       			    String str5 = new Integer(a).toString(); 
       				lblChips.setText(str5);
    				lblResult.setText("Banker wins!");      
  				btnBet.setDisable(false);
  				btnDeal.setDisable(true);
  				txtBet.setEditable(true);
  				btnDeal.setText("DEAL");
 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
 				public void handle(ActionEvent event3)
 				{
     				imgPlayer[2].setImage(new Image("file:images/back_blue.png"));
 					imgBanker[2].setImage(new Image("file:images/back_blue.png"));
 					run();
 				}
				});
                      }
                      //THIRD
                      if(score == score2)
                      {
          				lblResult.setText("TIE");
          				btnBet.setDisable(false);
          				btnDeal.setDisable(true);
          				txtBet.setEditable(true);
          				btnDeal.setText("DEAL");
          				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
             				public void handle(ActionEvent event3)
             				{
             					imgPlayer[2].setImage(new Image("file:images/back_blue.png"));
             					imgBanker[2].setImage(new Image("file:images/back_blue.png"));
             					run();
             				}
          				});

                      }

 				}
            	});
            	}
             if((score == 7 || score == 6 ) && (score2 == 6))
            	{ 
  				lblResult.setText("Draw one more card!");
 				btnDeal.setText("DRAW CARD");   
 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
 				public void handle(ActionEvent event2)
                 {
     				imgBanker[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));

     				imgBanker[2].setId(cardvalue[randPos6]);//setting the value of the card 
     				imgPlayer[2].setImage(new Image("file:images/" + cards[randPos6] + ".png"));

     				imgPlayer[2].setId(cardvalue[randPos6]);//setting the value of the card 
    					sixth_card = Integer.valueOf(imgBanker[2].getId());	
    					fifth_card = Integer.valueOf(imgPlayer[2].getId());	
    				 sum = first_card + second_card + fifth_card;
 					int sum2  = third_card + fourth_card + sixth_card;
 					 score = sum % 10;
                     int score2 = sum2 % 10;
                      final_score = Integer.toString(score);
                     String final_score2 = Integer.toString(score2);

                      lblPTotal.setText(final_score);
                      lblBTotal.setText(final_score2);
                      
                      if(score > score2)
                      {
                    	  Integer result1 = Integer.valueOf(lblChips.getText());		
       				int a = result1 + ad;
       			    String str5 = new Integer(a).toString(); 
       				lblChips.setText(str5);
    				lblResult.setText("Player wins!");
  				btnBet.setDisable(false);
  				btnDeal.setDisable(true);
  				txtBet.setEditable(true);
  				btnDeal.setText("DEAL");
 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
 				public void handle(ActionEvent event3)
                 {
     				imgPlayer[2].setImage(new Image("file:images/back_blue.png"));
     				imgBanker[2].setImage(new Image("file:images/back_blue.png"));
 				run();
 				//STARTS
 				}
 				});
                      }
 				//SECOND
                      if( score2 > score)
                      {
                    	 Integer result1 = Integer.valueOf(lblChips.getText());		
       				int a = result1 - ad;
       			    String str5 = new Integer(a).toString(); 
       				lblChips.setText(str5);
    				lblResult.setText("Banker wins!");      
  				btnBet.setDisable(false);
  				btnDeal.setDisable(true);
  				txtBet.setEditable(true);
  				btnDeal.setText("DEAL");
 				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
 				public void handle(ActionEvent event3)
 				{
     				imgPlayer[2].setImage(new Image("file:images/back_blue.png"));
 					imgBanker[2].setImage(new Image("file:images/back_blue.png"));
 					run();
 				}
				});
                      }
                      //THIRD
                      if(score == score2)
                      {
          				lblResult.setText("TIE");
          				btnBet.setDisable(false);
          				btnDeal.setDisable(true);
          				txtBet.setEditable(true);
          				btnDeal.setText("DEAL");
          				btnDeal.setOnAction(new EventHandler<ActionEvent>(){
             				public void handle(ActionEvent event3)
             				{
             					imgPlayer[2].setImage(new Image("file:images/back_blue.png"));
             					imgBanker[2].setImage(new Image("file:images/back_blue.png"));
             					run();
             				}
          				});

                      }

 				}
            	});
            	}
  			if(lblBTotal.getText().equals("9"))
 			{
  				Integer result1 = Integer.valueOf(lblChips.getText());		
  				int a = result1 - ad;
  			    String str5 = new Integer(a).toString(); 
  				lblChips.setText(str5);
 				lblResult.setText("Banker wins!");
 				btnBet.setDisable(false);
 				btnDeal.setDisable(true);
					txtBet.setEditable(true);
					btnDeal.setText("DEAL");
 			}
  			if((lblPTotal.getText().equals("9")) && (lblBTotal.getText().equals("9")))
		{
			lblResult.setText("It's a TIE");
			btnBet.setDisable(false);
			btnDeal.setDisable(true);
			txtBet.setEditable(true);
			btnDeal.setText("DEAL");
		}


					}
			});
	

}

	public static void main(String[] args) {
		launch(args);
	}
}
