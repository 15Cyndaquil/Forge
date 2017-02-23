package com.cynda.block_basics;

/**
 * Created by 15Cyndaquil on 2/23/2017.
 */
public class Referance {
    public static final String MOD_ID="block_basics";
    public static final String NAME="Block Basics";
    public static final String VERSION="1.0";
    public static final String ACCEPTED_VERSIONS="[1.11.2]";

    public static final String CLIENT_PROXY_CLASS="com.cynda.block_basics.proxy.ClientProxy";
    public static final String SERVER_PROXY_CLASS="com.cynda.block_basics.proxy.ServerProxy";

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
