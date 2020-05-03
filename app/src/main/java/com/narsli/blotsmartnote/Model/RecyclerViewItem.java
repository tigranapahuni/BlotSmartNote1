package com.narsli.blotsmartnote.Model;

public class RecyclerViewItem {
    //drawable-um imagnerin kareli int-ov dimel
    private int imageResource;
    private String txt_kom1, txt_kom2;
    private String zakaz;

    //cons -n avtomat kareli e sarqel alt+enter
    public RecyclerViewItem(String txt_kom1, String txt_kom2, int imageResource, String zakaz) {

        this.txt_kom1 = txt_kom1;
        this.txt_kom2 = txt_kom2;
        this.imageResource = imageResource;
        this.zakaz = zakaz;
    }
//seter ev geter karel avtomat sarqel alt+insert

    public String getZakaz() {
        return zakaz;
    }

    public void setZakaz(String zakaz) {
        this.zakaz = zakaz;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getTxt_kom1() {
        return txt_kom1;
    }

    public void setTxt_kom1(String txt_kom1) {
        this.txt_kom1 = txt_kom1;
    }

    public String getTxt_kom2() {
        return txt_kom2;
    }

    public void setTxt_kom2(String txt_kom2) {
        this.txt_kom2 = txt_kom2;
    }
}
