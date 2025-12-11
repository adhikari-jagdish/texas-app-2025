package com.texas.texasmobileapp.Model;

public class CountryModel {
    private String name;
    private int icon;

    public CountryModel (String name, int icon){
        this.name = name;
        this.icon = icon;
    }

    public String getName(){
        return this.name;
    }

    public int getIcon(){
        return this.icon;
    }

}
