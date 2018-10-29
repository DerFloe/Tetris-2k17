package com.tetris.main;

import javax.swing.*;
import com.tetris.game.*;
import sun.audio.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DialogEvent;
import javafx.scene.image.Image;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Window;
import com.tetris.game.*;

public class Main extends Application {
	
    public static final int TILE_SIZE = 40;
    public static final int GRID_WIDTH = 15;
    public static final int GRID_HEIGHT = 20;
   
    private double time;
    
    
    
    @Override
	public void start(Stage primaryStage) {
		try {// bsdfsas
			
			Button infob=new Button();
			
			infob.setText("Read Before Playing");
			infob.setTextFill(Color.RED);
			infob.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
			Alert info = new Alert(AlertType.INFORMATION);
			info.setTitle("Information");
			info.setContentText("The game is currently under developement and the code is not in its final state. There might be a few bugs.");
			info.setOnCloseRequest(new EventHandler<DialogEvent>(){

				@Override
				public void handle(DialogEvent event) {
					// TODO Auto-generated method stub
				}
				
			});
			info.show();
			
			

			}
			});
			
			Pane root= new Pane();
			
			Button btnStart=new Button();
			btnStart.setText("> Spiel starten <");
			btnStart.setId("btnStart");
			Button btnSettings=new Button();
			btnSettings.setText("> Einstellungen <");
			btnSettings.setId("btnOptions");
			Button btnEnd=new Button();
			btnEnd.setText("> Spiel beenden <");
			btnEnd.setId("btnEnde");
			double buttonsize=250;
			btnStart.setMinWidth(buttonsize);
			btnSettings.setMinWidth(buttonsize);
			btnEnd.setMinWidth(buttonsize);
			infob.setMinWidth(buttonsize);

			btnStart.setLayoutX(500);
			btnStart.setLayoutY(180);
			
			
			btnSettings.setLayoutX(500);
			btnSettings.setLayoutY(250);
			
			btnEnd.setLayoutX(500);
			btnEnd.setLayoutY(320);
			
			btnStart.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					GameStarter g=new GameStarter();
					g.start(new Stage());
				}
				
			});
			
			btnSettings.setOnAction(new EventHandler<ActionEvent>() {
				 
	            @Override
	            public void handle(ActionEvent event) {
	                try {
						stop();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
	        });
			btnEnd.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					
					System.out.println("Thank you for playing Tetris 2k17");
					System.out.println("For updates visit:");
					System.out.println("https://github.com/derfloe/Tetris-2k17/");
					Stage stage = (Stage) btnEnd.getScene().getWindow();
					
				    stage.close();
				}
				
				
			});
			
			
			root.getChildren().add(btnStart);
			root.getChildren().add(btnEnd);
			root.getChildren().add(btnSettings);
			String  style= getClass().getResource("application.css").toExternalForm();
			root.getStylesheets().add(style);
			root.setId("background");
			Scene scene = new Scene(root,790,500);
			
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Tetris 2k17");
			primaryStage.setResizable(false);
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

    
    
 
	public static void main(String[] args) {
		launch(args);
	}
}
