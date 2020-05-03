package com.narsli.blotsmartnote.Data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.narsli.blotsmartnote.Model.BloteNote;

import java.util.List;

//*-----------------------Room--------------------------------
//*-----------------------Room bibliotekai @Dao--------------------------------
//3. @Dao komponent (com.narsli.blotsmartnote.Data  Access Object)- objekt dljya dostupa k dannim,
// ays anotaciayov otmechaetca, clasn kam interfeys, vorn tuyl e talis unenal dostup k tvyalnerin.
//---------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------
//ays interfeysum (mer koxmic sarqac) menq petq e nshenq ayn metodnernv voronq anhrajesht
// en dlya monipulyacii dannix
@Dao
public interface HashivDAO {
    //@ndamen@ mek toxov texadrum enq db-i mej info hashiv tipi ev ayn veradarcnum e long tipi
//   (avelacvac toxi) id-i hamarn
    @Insert
    public long addHashiv(BloteNote bloteNote);

    //metod xmbagrman  kam update anelu talis enq bloteNote tipi popoxakan ev vochin chi veradarcnum
    @Update
    public void updateHashiv(BloteNote bloteNote);

    //parz e
    @Delete
    public void deleteHashiv(BloteNote bloteNote);

    //veradarcnum e alla data from table` blot_hashiv
    @Query("select * from blot_hashiv")

    public List<BloteNote> getAllHashivner();

    //veradarcnum e konkret car_id (primary key)= car_Id -i toxn
    @Query("select * from blot_hashiv where blot_id ==:blotId ")

    public BloteNote getHashiv(long blotId);
}
