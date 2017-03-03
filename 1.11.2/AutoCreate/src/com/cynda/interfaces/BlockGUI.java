package com.cynda.interfaces;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

/**
 * Created by 15Cyndaquil on 3/2/2017.
 */
public class BlockGUI {

    public static ArrayList<String> blocks = new ArrayList<String>();

    private static Button blockInputButton = new Button("Block Submit");
    private static Button blockDeleteButton = new Button("Delete Submit");
    private static Button back = new Button("<- Back");
    private static Button craftingRecipe = new Button("Set Crafting Recipes");
    private static TextArea inputtedBlocks = new TextArea();

    public static void createBlockGUI(GridPane grid){

        grid.getChildren().clear();

        back(grid);
        createBlockInputBox(1, 1, grid);
        deleteBlockBox(1, 5, grid);
        createCraftingRecipe(5, 8, grid);
    }



    private static void createBlockInputBox(int cordColumn, int cordRow, GridPane grid){

        //Sets up all of the GUI for Block Inputs
        TextField blockInputBox = new TextField();

        Label blockInputLabel = new Label("Input one Block at a time\nThen press Block Submit");


        blockInputButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);


        inputtedBlocks.setEditable(false);
        inputtedBlocks.setWrapText(true);

        grid.add(blockInputLabel, cordColumn, cordRow);
        grid.add(blockInputBox, cordColumn, cordRow+2);
        grid.add(blockInputButton, cordColumn, cordRow+3);
        grid.add(inputtedBlocks, cordColumn+4, cordRow);

        GridPane.setColumnSpan(blockInputLabel, 3);
        GridPane.setRowSpan(blockInputLabel, 2);
        GridPane.setColumnSpan(blockInputBox, 3);
        GridPane.setColumnSpan(blockInputButton, 3);
        GridPane.setColumnSpan(inputtedBlocks, 4);
        GridPane.setRowSpan(inputtedBlocks, 6);

        GridPane.setHalignment(blockInputLabel, HPos.CENTER);
        GridPane.setValignment(blockInputLabel, VPos.CENTER);
        GridPane.setHalignment(blockInputButton, HPos.CENTER);
        GridPane.setValignment(blockInputButton, VPos.CENTER);

        GridPane.setFillHeight(blockInputBox, true);
        GridPane.setFillWidth(blockInputBox, true);
        GridPane.setFillHeight(blockInputButton, true);
        GridPane.setFillWidth(blockInputButton, true);

        //Inputs the Blocks
        blockInputButton.setOnAction(new javafx.event.EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if(blocks.contains(blockInputBox.getText().toString().trim())){
                    System.out.println("Block Already Added");
                }else if(!blockInputBox.getText().toString().trim().equals("")) {
                    blocks.add(blockInputBox.getText().toString().trim());
                    blockInputBox.setText("");
                }else{System.out.println("Nothing Inputed");}


                setInputedBlocks();
            }
        });

        blockInputBox.textProperty().addListener((observable, oldValue, newValue) -> {
            blockDeleteButton.setDefaultButton(false);
            blockInputButton.setDefaultButton(true);
        });



    }

    private static void deleteBlockBox(int cordColumn, int cordRow, GridPane grid){

        TextField blockDeleteBox = new TextField();

        Label blockDeleteLabel = new Label(" Type out blocks to delete\nThen press Delete Submit");

        blockDeleteButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        grid.add(blockDeleteLabel, cordColumn, cordRow);
        grid.add(blockDeleteBox, cordColumn, cordRow+2);
        grid.add(blockDeleteButton, cordColumn, cordRow+3);

        GridPane.setColumnSpan(blockDeleteLabel, 3);
        GridPane.setRowSpan(blockDeleteLabel, 2);
        GridPane.setColumnSpan(blockDeleteBox, 3);
        GridPane.setColumnSpan(blockDeleteButton, 3);

        GridPane.setHalignment(blockDeleteLabel, HPos.CENTER);
        GridPane.setValignment(blockDeleteLabel, VPos.CENTER);
        GridPane.setHalignment(blockDeleteButton, HPos.CENTER);
        GridPane.setValignment(blockDeleteButton, VPos.CENTER);

        GridPane.setFillHeight(blockDeleteBox, true);
        GridPane.setFillWidth(blockDeleteBox, true);
        GridPane.setFillHeight(blockDeleteButton, true);
        GridPane.setFillWidth(blockDeleteButton, true);

        blockDeleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if(blocks.contains(blockDeleteBox.getText().toString().trim())){
                    blocks.remove(blocks.indexOf(blockDeleteBox.getText().toString().trim()));
                    blocks.trimToSize();
                    blockDeleteBox.setText("");
                }

                setInputedBlocks();
            }
        });

        blockDeleteBox.textProperty().addListener((observable, oldValue, newValue) -> {
            blockInputButton.setDefaultButton(false);
            blockDeleteButton.setDefaultButton(true);
        });

    }

    private static void setInputedBlocks(){

        inputtedBlocks.replaceText(0, inputtedBlocks.getLength(), "");
        for (int i = 0; i < blocks.size(); i++) {
            inputtedBlocks.appendText(blocks.get(i).toString() + "\n");
        }
    }

    private static void back(GridPane grid){
        grid.add(back, 0,0);
        back.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        GridPane.setColumnSpan(back, 2);
        GridPane.setRowSpan(back, 1);

        GridPane.setFillHeight(back, true);
        GridPane.setFillWidth(back, true);

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GoToMain.toMain(grid);
            }
        });
    }

    private static void createCraftingRecipe(int cordColumn, int cordRow, GridPane grid){
        craftingRecipe.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        grid.add(craftingRecipe, cordColumn, cordRow);

        GridPane.setColumnSpan(craftingRecipe, 4);
        GridPane.setRowSpan(craftingRecipe, 1);

        GridPane.setFillHeight(craftingRecipe, true);
        GridPane.setFillWidth(craftingRecipe, true);
    }



    public static ArrayList<String> getInputtedBlocks(){
        return blocks;
    }
}
