package com.narsli.blotsmartnote.Model;
//*-----------------------Room--------------------------------
//database-i het ashxatelu hamar use android-i nor db- bibliotekanern voronq kochvum en Room
//shat shat heshtacnum ev parzacnum ev avtomatacnum en amboxch ashxatanqn
//--------------------------------------------------------------------
//nra hramannern sksvum en @ nshanov ev kochvum en anotacia anel

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

//room bibliotekan baxkacac e 3 himnakan komponentner en (anatacianeric),
// voronc mijocov ashxatum e room bibliotekan ashxatum e SQLite-i het.
//
// 1. @DataBase -vorov nshum enq vor clasn database e, petq e lini abstract clas,
// vorn explent e linum RoomDataBase clasic
// 2. @Entity -anatacian nshum e clasin  vor na table e. aysinqn db-i yuraqanchyur
// table-i hamar stexcvum e clas , vorn otmechaetca e @Entity- anataciyov
//3. @Dao komponent (com.narsli.blotsmartnote.Data  Access Object)- objekt dljya dostupa k dannim, ays anotaciayov
// otmechaetca, clasn kam interfeys, vorn tuyl e talis unenal dostup k tvyalnerin.
//----------------------------------------------------------------------------------
//----------------------------------------------------------------------------------
//implementacia enq anum Room-n
@Entity(tableName = "blot_hashiv")//stexcecinq cars tbale
public class BloteNote {
    //-------------------------------------------------
//stexcum enq table-i syunnern, talov anunner syunerin
    //gone mek syun petq e lini partadir primary Key
    @PrimaryKey(autoGenerate = true)//true nshanakum eid-n avtomat e achelu mekov, false-n manual
    @ColumnInfo(name = "blot_id")
    private int id;

    @ColumnInfo(name = "blot_kom1")
    private String kom1;

    @ColumnInfo(name = "blot_Kom2")
    private String kom2;
    //drawable-um imagnerin kareli int-ov dimel
    @ColumnInfo(name = "imageResource")
    private int imageResource;

    @ColumnInfo(name = "blot_zakaz")
    private String zakaz;

    //-*------------**-*-----------------*-*-*---------------------------------
//    qani vor Room bibliotekan amenn anum e avtomat mer poxaren nhhum enq vor komsn e use-e
    @Ignore //nshanakum e ays kons-n chi use
    public BloteNote() {
    }

    @Ignore //nshanakum e ays kons-n chi use
    public BloteNote(int id, String kom1, String kom2, String zakaz) {
        this.id = id;
        this.kom1 = kom1;
        this.kom2 = kom2;
        this.zakaz = zakaz;
    }

    @Ignore //nshanakum e ays kons-n chi use
    public BloteNote(int id, String zakaz) {
        this.id = id;
        this.zakaz = zakaz;
    }

    public BloteNote(int id, String kom1, String kom2, int imageResource, String zakaz) {
        this.id = id;
        this.kom1 = kom1;
        this.kom2 = kom2;
        this.imageResource = imageResource;
        this.zakaz = zakaz;
    }

    @Ignore
    public BloteNote(String kom1, String kom2) {
        this.kom1 = kom1;
        this.kom2 = kom2;
    }

    public BloteNote(int i, String kom1, String kom2) {
    }

    public int getId() {
        return id;
    }

    //------------------------------------------------------------------
//-------------------------- seter ev geter -------------------------
    public void setId(int id) {
        this.id = id;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getKom1() {
        return kom1;
    }

    public void setKom1(String kom1) {
        this.kom1 = kom1;
    }

    public String getKom2() {
        return kom2;
    }

    public void setKom2(String kom2) {
        this.kom2 = kom2;
    }

    public String getZakaz() {
        return zakaz;
    }

    public void setZakaz(String zakaz) {
        this.zakaz = zakaz;
    }
}
