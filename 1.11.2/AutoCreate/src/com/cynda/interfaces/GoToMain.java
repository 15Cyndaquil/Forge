package com.cynda.interfaces;

import com.cynda.ModInfo;
import com.cynda.create.CreateMain;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;


/**
 * Created by 15Cyndaquil on 3/2/2017.
 */
public class GoToMain {

    private static ModInfo modInfo = new ModInfo();

    private static Button addItems = new Button("Add Items");
    private static Button addBlocks = new Button("Add Blocks");
    private static Button addModInfo = new Button("Set Mod Info");
    private static Button finishMod = new Button ("Finish Mod");

    private static TextField addCompany = new TextField();
    private static TextField addModID = new TextField();
    private static TextField addModName = new TextField();
    private static TextField addModVersion = new TextField();
    private static TextField addAcceptedVersions = new TextField();

    private static TextArea items = new TextArea();
    private static TextArea blocks = new TextArea();

    public static void toMain(GridPane grid){
        grid.getChildren().clear();

        setMainModInfo(grid, 5, 1);
        setMainItems(grid, 1, 1);
        setMainBlocks(grid, 1, 5);
        setModInfo(grid, 6,6);
        setFinishMod(grid, 6,7);
    }



    private static void setMainModInfo(GridPane grid, int cordColumn, int cordRow){
        addCompany.setPromptText("Enter Company/User Name Here");
        addModID.setPromptText("Enter Mod ID Here");
        addModName.setPromptText("Enter Mod Name Here");
        addModVersion.setPromptText("Enter Mod Version Here");
        addAcceptedVersions.setPromptText("Enter Accepted Versions Here");

        grid.add(addCompany, cordColumn, cordRow);
        grid.add(addModID, cordColumn, cordRow+1);
        grid.add(addModName, cordColumn, cordRow+2);
        grid.add(addModVersion, cordColumn, cordRow+3);
        grid.add(addAcceptedVersions, cordColumn, cordRow+4);

        GridPane.setColumnSpan(addCompany, 4);
        GridPane.setColumnSpan(addModID, 4);
        GridPane.setColumnSpan(addModName, 4);
        GridPane.setColumnSpan(addModVersion, 4);
        GridPane.setColumnSpan(addAcceptedVersions, 4);
    }

    private static void setMainItems(GridPane grid, int cordColumn, int cordRow){
        addItems.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        items.setEditable(false);

        grid.add(addItems, cordColumn, cordRow);
        grid.add(items, cordColumn+2, cordRow);

        GridPane.setColumnSpan(addItems, 2);
        GridPane.setRowSpan(addItems, 1);
        GridPane.setColumnSpan(items, 2);
        GridPane.setRowSpan(items, 3);

        GridPane.setFillHeight(addItems, true);
        GridPane.setFillWidth(addItems, true);

        ArrayList<String> currentItems = ItemGUI.getInputtedItems();

        items.replaceText(0, items.getLength(), "");
        for (int i = 0; i < currentItems.size(); i++) {
            items.appendText(currentItems.get(i).toString() + "\n");
        }

        addItems.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ItemGUI.createItemGUI(grid);
            }
        });
    }

    private static void setMainBlocks(GridPane grid, int cordColumn, int cordRow){
        addBlocks.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        blocks.setEditable(false);

        grid.add(addBlocks, cordColumn, cordRow);
        grid.add(blocks, cordColumn+2, cordRow);

        GridPane.setColumnSpan(addBlocks, 2);
        GridPane.setRowSpan(addBlocks, 1);
        GridPane.setColumnSpan(blocks, 2);
        GridPane.setRowSpan(blocks, 3);

        GridPane.setFillHeight(addBlocks, true);
        GridPane.setFillWidth(addBlocks, true);

        ArrayList<String> currentBlocks = BlockGUI.getInputtedBlocks();

        blocks.replaceText(0, blocks.getLength(), "");
        for (int i = 0; i < currentBlocks.size(); i++) {
            blocks.appendText(currentBlocks.get(i).toString() + "\n");
        }

        addBlocks.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                BlockGUI.createBlockGUI(grid);
            }
        });
    }

    private static void setModInfo(GridPane grid, int cordColumn, int cordRow){
        addModInfo.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        addModInfo.setDefaultButton(true);

        grid.add(addModInfo, cordColumn, cordRow);

        GridPane.setColumnSpan(addModInfo, 2);

        GridPane.setFillHeight(addModInfo, true);
        GridPane.setFillWidth(addModInfo, true);


        addModInfo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String company = addCompany.getText().toString();
                String modID = addModID.getText().toString();
                String modName = addModName.getText().toString();
                String modVersion = addModVersion.getText().toString();
                String acceptedVersions = addAcceptedVersions.getText().toString();

                modInfo.setModComapny(company);
                modInfo.setModID(modID);
                modInfo.setModName(modName);
                modInfo.setModVersion(modVersion);
                modInfo.setAcceptedVersions(acceptedVersions);

                System.out.println(GoToMain.getModInfo().toString());
            }
        });
    }

    private static void setFinishMod(GridPane grid, int cordColumn, int cordRow){
        finishMod.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        grid.add(finishMod, cordColumn, cordRow);

        GridPane.setColumnSpan(finishMod, 2);

        GridPane.setFillHeight(finishMod, true);
        GridPane.setFillWidth(finishMod, true);

        finishMod.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                CreateMain.createMainClass();
            }
        });
    }



    public static ModInfo getModInfo(){
        return modInfo;
    }
}
