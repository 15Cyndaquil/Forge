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
public class ItemGUI {

    public static ArrayList<String> items = new ArrayList<String>();

    private static Button itemInputButton = new Button("Item Submit");
    private static Button itemDeleteButton = new Button("Delete Submit");
    private static Button back = new Button("<- Back");
    private static Button craftingRecipe = new Button("Set Crafting Recipes");
    private static TextArea inputtedItems = new TextArea();

    public static void createItemGUI(GridPane grid){

        grid.getChildren().clear();

        back(grid);
        createItemInputBox(1, 1, grid);
        deleteItemBox(1, 5, grid);
        createCraftingRecipe(5, 8, grid);
    }



    private static void createItemInputBox(int cordColumn, int cordRow, GridPane grid){

        //Sets up all of the GUI for Item Inputs
        TextField itemInputBox = new TextField();

        Label itemInputLabel = new Label("Input one Item at a time\nThen press Item Submit");


        itemInputButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);


        inputtedItems.setEditable(false);
        inputtedItems.setWrapText(true);

        grid.add(itemInputLabel, cordColumn, cordRow);
        grid.add(itemInputBox, cordColumn, cordRow+2);
        grid.add(itemInputButton, cordColumn, cordRow+3);
        grid.add(inputtedItems, cordColumn+4, cordRow);

        GridPane.setColumnSpan(itemInputLabel, 3);
        GridPane.setRowSpan(itemInputLabel, 2);
        GridPane.setColumnSpan(itemInputBox, 3);
        GridPane.setColumnSpan(itemInputButton, 3);
        GridPane.setColumnSpan(inputtedItems, 4);
        GridPane.setRowSpan(inputtedItems, 6);

        GridPane.setHalignment(itemInputLabel, HPos.CENTER);
        GridPane.setValignment(itemInputLabel, VPos.CENTER);
        GridPane.setHalignment(itemInputButton, HPos.CENTER);
        GridPane.setValignment(itemInputButton, VPos.CENTER);

        GridPane.setFillHeight(itemInputBox, true);
        GridPane.setFillWidth(itemInputBox, true);
        GridPane.setFillHeight(itemInputButton, true);
        GridPane.setFillWidth(itemInputButton, true);

        //Inputs the Items
        itemInputButton.setOnAction(new javafx.event.EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if(items.contains(itemInputBox.getText().toString().trim())){
                    System.out.println("Item Already Added");
                }else if(!itemInputBox.getText().toString().trim().equals("")) {
                    items.add(itemInputBox.getText().toString().trim());
                    itemInputBox.setText("");
                }else{System.out.println("Nothing Inputed");}


                setInputedItems();
            }
        });

        itemInputBox.textProperty().addListener((observable, oldValue, newValue) -> {
            itemDeleteButton.setDefaultButton(false);
            itemInputButton.setDefaultButton(true);
        });



    }

    private static void deleteItemBox(int cordColumn, int cordRow, GridPane grid){

        TextField itemDeleteBox = new TextField();

        Label itemDeleteLabel = new Label(" Type out items to delete\nThen press Delete Submit");

        itemDeleteButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        grid.add(itemDeleteLabel, cordColumn, cordRow);
        grid.add(itemDeleteBox, cordColumn, cordRow+2);
        grid.add(itemDeleteButton, cordColumn, cordRow+3);

        GridPane.setColumnSpan(itemDeleteLabel, 3);
        GridPane.setRowSpan(itemDeleteLabel, 2);
        GridPane.setColumnSpan(itemDeleteBox, 3);
        GridPane.setColumnSpan(itemDeleteButton, 3);

        GridPane.setHalignment(itemDeleteLabel, HPos.CENTER);
        GridPane.setValignment(itemDeleteLabel, VPos.CENTER);
        GridPane.setHalignment(itemDeleteButton, HPos.CENTER);
        GridPane.setValignment(itemDeleteButton, VPos.CENTER);

        GridPane.setFillHeight(itemDeleteBox, true);
        GridPane.setFillWidth(itemDeleteBox, true);
        GridPane.setFillHeight(itemDeleteButton, true);
        GridPane.setFillWidth(itemDeleteButton, true);

        itemDeleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if(items.contains(itemDeleteBox.getText().toString().trim())){
                    items.remove(items.indexOf(itemDeleteBox.getText().toString().trim()));
                    items.trimToSize();
                    itemDeleteBox.setText("");
                }

                setInputedItems();
            }
        });

        itemDeleteBox.textProperty().addListener((observable, oldValue, newValue) -> {
            itemInputButton.setDefaultButton(false);
            itemDeleteButton.setDefaultButton(true);
        });

    }

    private static void setInputedItems(){

        inputtedItems.replaceText(0, inputtedItems.getLength(), "");
        for (int i = 0; i < items.size(); i++) {
            inputtedItems.appendText(items.get(i).toString() + "\n");
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



    public static ArrayList<String> getInputtedItems(){
        return items;
    }
}
