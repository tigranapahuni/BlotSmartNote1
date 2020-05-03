package com.narsli.blotsmartnote.Data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.narsli.blotsmartnote.Model.BloteNote;
//*-----------------------Room--------------------------------
//*-----------------------Room bibliotekai @Database--------------------------------
//----------------------------------------------------------------
//---------------------------------------------------------------
//room bibliotekan baxkacac e 3 himnakan komponentner en (anatacianeric),
// voronc mijocov ashxatum e room bibliotekan ashxatum e SQLite-i het.
//
// 1. @DataBase -vorov nshum enq vor clasn database e, petq e lini abstract clas,
// vorn explent e linum RoomDataBase clasic
//----------------------------------------------------------------
//---------------------------------------------------------------
//            stexcum enq database
//nshum enq @Database anotaciayov mer koxmic stexcvac` CarsAppDatabase abstract clasn,
// @ndamen@ 1 table- e linelu` blot_hashiv anunov

@Database(entities = {BloteNote.class}, version = 1)

public abstract class HashivAppDatabase extends RoomDatabase {//jarangum enq RoomDatabase-ic

    //stexcum enq abstract metod, vorn veradarcnum e HashivDAO
    public abstract HashivDAO getHashivDAO();
}