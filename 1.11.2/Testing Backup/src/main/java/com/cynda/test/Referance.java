package com.cynda.test;

/**
 * Created by 15Cyndaquil on 2/16/2017.
 */


public class Referance {

    public static final String MOD_ID="test";
    public static final String NAME="Test Mod";
    public static final String VERSION="0.1";
    public static final String ACCEPTED_VERSIONS="[1.11.2]";

    public static final String CLIENT_PROXY_CLASS="com.cynda.test.proxy.ClientProxy";
    public static final String SERVER_PROXY_CLASS="com.cynda.test.proxy.ServerProxy";

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

    public static enum TestBlocks{
        CHEESEBLOCK("cheeseblock", "BlockCheese");

        private String unlocalisedName, registryName;

        TestBlocks(String unlocalizedName, String registryName){
            this.unlocalisedName = unlocalizedName;
            this.registryName = registryName;
        }

        public String getUnlocalisedName() {
            return unlocalisedName;
        }

        public String getRegistryName() {
            return registryName;
        }
    }
}
