package com.cynda.create;

import com.cynda.ModInfo;
import com.cynda.interfaces.GoToMain;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by 15Cyndaquil on 3/1/2017.
 */
public class CreateItems {

    public static StringBuffer getItemEnumFiles(Object[] items){
        StringBuffer itemEnum = new StringBuffer();
        itemEnum = itemEnum(itemEnum, items);

        return itemEnum;
    }

    private static StringBuffer itemEnum(StringBuffer itemEnum, Object[] items){

        itemEnum.append("public static enum ModItems{\n");
        for(int i=0; i<items.length; i++){
            itemEnum.append("    "+items[i].toString().toUpperCase()+"(\""
                    +items[i].toString().toLowerCase()+"\", \"Item"
                    +items[i].toString().toUpperCase().charAt(0)
                    +items[i].toString().toLowerCase().substring(1)
                    +"\");\n");
        }
        itemEnum.append("\n");
        itemEnum.append("    private String unlocalizedName;\n");
        itemEnum.append("    private String registryName;\n\n");
        itemEnum.append("    ModItems(String unlocalizedName, String registryName){\n");
        itemEnum.append("        this.unlocalizedName = unlocalizedName;\n");
        itemEnum.append("        this.registryName = registryName;\n");
        itemEnum.append("    }\n\n");

        itemEnum.append("    public String getUnlocalizedName() {return unlocalizedName;}\n\n");
        itemEnum.append("    public String getRegistryName() {return registryName;}\n");

        itemEnum.append("}\n");

        return itemEnum;
    }

    public static ArrayList<StringBuffer> itemJava(Object[] items){
        ArrayList<StringBuffer> itemJavaFiles = new ArrayList<StringBuffer>();
        ModInfo modInfo = GoToMain.getModInfo();

        for(int i=0; i<items.length; i++){
            StringBuffer item = new StringBuffer(1);

            item.append("package com."+modInfo.getModComapny()+"."+modInfo.getModID()+".items;\n\n");
            item.append("import com."+modInfo.getModComapny()+"."+modInfo.getModID()+".Reference;\n");
            item.append("import net.minecraft.item.Item;\n\n");
            item.append("public class Item"+items[i].toString().toUpperCase().charAt(0)+items[i].toString().toLowerCase().substring(1,items[i].toString().length())+" extends Item{\n\n");
            item.append("    public Item"+items[i].toString().toUpperCase().charAt(0)+items[i].toString().toLowerCase().substring(1,items[i].toString().length())+"(){\n");
            item.append("        setUnlocalizedName(Reference.ModItems."+items[i].toString().toUpperCase()+".getUnlocalizedName());\n");
            item.append("        setRegistryName(Reference.ModItems."+items[i].toString().toUpperCase()+".getRegistryName());\n");
            item.append("    }\n}");

            itemJavaFiles.add(item);
        }

        return itemJavaFiles;
    }

}
