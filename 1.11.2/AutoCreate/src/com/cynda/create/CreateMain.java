package com.cynda.create;

import com.cynda.DeleteDir;
import com.cynda.ModInfo;
import com.cynda.interfaces.GoToMain;
import com.cynda.interfaces.ItemGUI;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 * Created by 15Cyndaquil on 3/2/2017.
 */
public class CreateMain {

    private static ModInfo modInfo;

    private static File dirMain;
    private static File dirMainBlocks;
    private static File dirMainInit;
    private static File dirMainItems;
    private static File dirMainProxy;
    private static File dirResources;
    private static File dirResourcesBlockStates;
    private static File dirResourcesLang;
    private static File dirResourcesModels;
    private static File dirResourcesModelsBlock;
    private static File dirResourcesModelsItem;
    private static File dirResourcesTextures;
    private static File dirResourcesTexturesBlocks;
    private static File dirResourcesTextureItems;


    public static void createMainClass(){

        getModInfo();
        createDir();

        CreateReference.createReferenceFile(dirMain);
        createItems();


//        moveDir();
    }



    private static void getModInfo(){
        modInfo = GoToMain.getModInfo();
    }

    private static void createDir(){

        dirMain = new File(
                modInfo.getModName()
                        + "/src/main/java/com/"
                        + modInfo.getModComapny()
                        + "/" + modInfo.getModID()
        );
        dirMainBlocks = new File(dirMain.toString()+"/blocks");
        dirMainInit = new File( dirMain.toString()+"/init");
        dirMainItems = new File(dirMain.toString()+"/items");
        dirMainProxy = new File(dirMain.toString()+"/proxy");


        dirResources = new File(
                modInfo.getModName()
                +"/src/main/resources/assets/"
                +modInfo.getModID()
        );
        dirResourcesBlockStates = new File(dirResources.toString()+"/blockstates");
        dirResourcesLang = new File(dirResources.toString()+"/lang");

        dirResourcesModels = new File(dirResources.toString()+"/models");
        dirResourcesModelsBlock = new File(dirResourcesModels.toString()+"/block");
        dirResourcesModelsItem = new File(dirResourcesModels.toString()+"/item");

        dirResourcesTextures = new File(dirResources.toString()+"/textures");
        dirResourcesTexturesBlocks = new File(dirResourcesTextures.toString()+"/blocks");
        dirResourcesTextureItems = new File(dirResourcesTextures.toString()+"/items");



        dirMainBlocks.mkdirs();
        dirMainInit.mkdirs();
        dirMainItems.mkdirs();
        dirMainProxy.mkdirs();

        dirResourcesBlockStates.mkdirs();
        dirResourcesLang.mkdirs();
        dirResourcesModelsBlock.mkdirs();
        dirResourcesModelsItem.mkdirs();
        dirResourcesTexturesBlocks.mkdirs();
        dirResourcesTextureItems.mkdirs();

        System.out.println();

//        File tmp = new File(dirMain, "test.txt");
//
//
//        try {
//            tmp.createNewFile();
//            PrintWriter test = new PrintWriter(tmp);
//        }catch (IOException exc){System.out.println("Create File Failed");
//        }
    }

    private static void createItems(){
        Object[] itemJava = CreateItems.itemJava(ItemGUI.getInputtedItems().toArray()).toArray();

        for(int i=0; i<itemJava.length; i++) {
            try {
                File tmp = new File(dirMainItems, "Item"+ItemGUI.getInputtedItems().toArray()[i].toString().toUpperCase().charAt(0)+ItemGUI.getInputtedItems().toArray()[i].toString().toLowerCase().substring(1, ItemGUI.getInputtedItems().toArray()[i].toString().length())+".java");
                PrintWriter writer = new PrintWriter(tmp, "UTF-8");
                writer.println(itemJava[i].toString());
                writer.close();
            } catch (IOException exc) {System.out.println("ItemJava failed");
            }
        }
    }

    private static void createInit(){

    }

    private static void moveDir(){

        File dirFinal = new File("C:\\Users\\15Cyndaquil\\Desktop\\"+modInfo.getModName());
        File dirStart = new File(modInfo.getModName());

        System.out.println("Directory Deleted: "+ DeleteDir.deleteDirectory(dirFinal));

        try {
            Files.move(dirStart.toPath() , dirFinal.toPath(), REPLACE_EXISTING);
            System.out.println(dirFinal.toString());
        }catch (IOException exc) {
            System.out.println("Move File Failed");
        }
    }
}
