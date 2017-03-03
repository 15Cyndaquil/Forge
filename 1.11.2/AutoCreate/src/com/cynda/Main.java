package com.cynda;

import com.cynda.interfaces.GoToMain;
import com.cynda.interfaces.ItemGUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;


public class Main extends Application{

    private GridPane grid = new GridPane();
    private ModInfo modInfo;

    @Override
    public void start(Stage primaryStage) throws Exception{

        createGrid();
        grid.setHgap(10);
        grid.setVgap(10);

        GoToMain.toMain(grid);

//        grid.setGridLinesVisible(true);
        primaryStage.setTitle("Minecraft Mod Creator");
        primaryStage.setScene(new Scene(grid, 500, 500));
        primaryStage.show();
    }

    private void createGrid(){
        for(int col=0; col<10; col++){
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(10);
            column.setHgrow(Priority.ALWAYS);
            column.setFillWidth(true);
            grid.getColumnConstraints().add(column);
        }
        for(int ro=0; ro<10; ro++){
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(10);
            row.setVgrow(Priority.ALWAYS);
            row.setFillHeight(true);
            grid.getRowConstraints().add(row);
        }
    }

}
