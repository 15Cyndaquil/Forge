package com.cynda;

/**
 * Created by 15Cyndaquil on 3/2/2017.
 */
public class ModInfo {
    String modComapny, modID, modName, modVersion, acceptedVersions;

    public ModInfo(String modCompany, String modID, String modName, String modVersion, String acceptedVersions){
        this.modComapny = modCompany;
        this.modID = modID;
        this.modName = modName;
        this.modVersion = modVersion;
        this.acceptedVersions = acceptedVersions;
    }

    public ModInfo(){
        this.modComapny = "cynda";
        this.modID = "test";
        this.modName = "Test Mod";
        this.modVersion = "0.1";
        this.acceptedVersions = "[1.11.2]";
    }

    public String getModComapny() {
        return modComapny;
    }

    public String getModID() {
        return modID;
    }

    public String getModName() {
        return modName;
    }

    public String getModVersion() {
        return modVersion;
    }

    public String getAcceptedVersions() {
        return acceptedVersions;
    }



    public void setModComapny(String modComapny) {
        this.modComapny = modComapny;
    }

    public void setModID(String modID) {
        this.modID = modID;
    }

    public void setModName(String modName) {
        this.modName = modName;
    }

    public void setModVersion(String modVersion) {
        this.modVersion = modVersion;
    }

    public void setAcceptedVersions(String acceptedVersions) {
        this.acceptedVersions = acceptedVersions;
    }



    public String toString(){
        return modComapny+", "+modID+", "+modName+", "+ modVersion +", "+acceptedVersions;
    }
}
