package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import javafx.scene.text.*;
import javafx.scene.Group;
import javafx.scene.shape.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.collections.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

public class FileChoose extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		// set title for the stage
		stage.setTitle("FileChooser");

		// create a File chooser
        DirectoryChooser directoryChooser = new DirectoryChooser();

		// create a Label
		Label title = new Label("Folder Map");
		title.setFont(new Font("Arial", 28));
		Label label = new Label("No Folder has been selected");
		// label config
		label.setFont(new Font("Arial", 20));
		// create a Button
		Button selectButton = new Button("Select a Folder File");

		Button readButton = new Button("Scan the Folder File");

		readButton.setDisable(true);
		// create an Event Handler
		EventHandler<ActionEvent> fileChooser = new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {
				// get the file selected
				File selectedDirectory = directoryChooser.showDialog(stage);

				if (selectedDirectory != null) {
					label.setText(selectedDirectory.getAbsolutePath());
					RecursivePara.setFileStr(selectedDirectory.getAbsoluteFile());
					readButton.setDisable(false);
				}

			}
		};

		EventHandler<ActionEvent> readFile = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

				//System.out.println(str.getSelectedFile());
				try {
					//I couldn't figure out tree nodes and implementing into map
					//RecursiveBox.displayBox(RecursivePara.getFileStr());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println(e1);
				}
			}

		};

		// setActions
		selectButton.setOnAction(fileChooser);
		readButton.setOnAction(readFile);

		// create a VBox
		VBox vbox = new VBox(30, title, label, selectButton, readButton);

		// set Alignment
		vbox.setAlignment(Pos.CENTER);

		// create a scene
		Scene scene = new Scene(vbox, 800, 400);

		// set the scene
		stage.setScene(scene);

		stage.show();
	}

}
