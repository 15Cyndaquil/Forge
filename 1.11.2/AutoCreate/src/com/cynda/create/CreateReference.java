package com.cynda.create;

import com.cynda.ModInfo;
import com.cynda.interfaces.BlockGUI;
import com.cynda.interfaces.GoToMain;
import com.cynda.interfaces.ItemGUI;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateReference {

    private static ModInfo modInfo;

    public static void  createReferenceFile(File filePath){

        setModInfo();

        try{
            File tmp = new File(filePath, "Reference.java");
            PrintWriter writer = new PrintWriter(tmp, "UTF-8");

            writer.println("package com."+modInfo.getModComapny()+"."+modInfo.getModID()+"\n");
            writer.println("public class Reference{\n");
            writer.println("    public static final String MOD_ID=\""+modInfo.getModID()+"\";");
            writer.println("    public static final String NAME=\""+modInfo.getModName()+"\";");
            writer.println("    public static final String VERSION=\""+modInfo.getModVersion()+"\";");
            writer.println("    public static final String ACCEPTED_VERSIONS=\""+modInfo.getAcceptedVersions()+"\";\n");
            writer.println("    public static final String CLIENT_PROXY_CLASS=\"com."+modInfo.getModComapny()+"."+modInfo.getModID()+".proxy.ClientProxy\";");
            writer.println("    public static final String SERVER_PROXY_CLASS=\"com."+modInfo.getModComapny()+"."+modInfo.getModID()+".proxy.ServerProxy\";\n");
            writer.println(CreateItems.getItemEnumFiles(ItemGUI.getInputtedItems().toArray())+"\n");
            writer.println(CreateBlocks.getBlockEnumFiles(BlockGUI.getInputtedBlocks().toArray()));

            writer.println("}");
            writer.close();
        }catch(IOException exc){System.out.println("Reference File Creation Failed");}


    }

    private static void setModInfo(){
        modInfo = GoToMain.getModInfo();
    }
}
