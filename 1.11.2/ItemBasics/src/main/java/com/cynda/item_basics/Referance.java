package com.cynda.item_basics;

/**
 * Created by 15Cyndaquil on 2/16/2017.
 */
public class Referance {

    public static final String MOD_ID="item_basics";
    public static final String NAME="Item Basics";
    public static final String VERSION="1.0";
    public static final String ACCEPTED_VERSIONS="[1.11.2]";

    public static final String CLIENT_PROXY_CLASS="com.cynda.item_basics.proxy.ClientProxy";
    public static final String SERVER_PROXY_CLASS="com.cynda.item_basics.proxy.ServerProxy";

    public static enum TestItems{
        CHEESE("cheese", "ItemCheese");

        private String unlocalizedName;
        private String registryName;

        TestItems(String unlocalizedName, String registryName){
            this.unlocalizedName = unlocalizedName;
            this.registryName = registryName;
        }

        public String getUnlocalizedName() {return unlocalizedName;}

        public String getRegistryName() {return registryName;}
    }

}
