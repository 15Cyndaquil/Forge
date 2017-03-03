package com.cynda.create;

/**
 * Created by 15Cyndaquil on 3/2/2017.
 */
public class CreateBlocks {

    public static StringBuffer getBlockEnumFiles(Object[] blocks){
        StringBuffer blockEnum = new StringBuffer();
        blockEnum = blockEnum(blockEnum, blocks);

        return blockEnum;
    }

    private static StringBuffer blockEnum(StringBuffer blockEnum, Object[] blocks){

        blockEnum.append("public static enum ModBlocks{\n");
        for(int i=0; i<blocks.length; i++){
            blockEnum.append("    "+blocks[i].toString().toUpperCase()+"_BLOCK"+"(\""
                    +blocks[i].toString().toLowerCase()+"\", \"Block"
                    +blocks[i].toString().toUpperCase().charAt(0)
                    +blocks[i].toString().toLowerCase().substring(1)
                    +"\");\n");
        }
        blockEnum.append("\n");
        blockEnum.append("    private String unlocalizedName;\n");
        blockEnum.append("    private String registryName;\n\n");
        blockEnum.append("    ModBlocks(String unlocalizedName, String registryName){\n");
        blockEnum.append("        this.unlocalizedName = unlocalizedName;\n");
        blockEnum.append("        this.registryName = registryName;\n");
        blockEnum.append("    }\n\n");

        blockEnum.append("    public String getUnlocalizedName() {return unlocalizedName;}\n\n");
        blockEnum.append("    public String getRegistryName() {return registryName;}\n");

        blockEnum.append("}\n");

        return blockEnum;
    }
}
