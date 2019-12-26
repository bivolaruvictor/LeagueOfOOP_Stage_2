package main;

import terrain.Terrain;

import java.util.ArrayList;

public class GameMap {
    private static GameMap singleInstance = null;
    private int numRows;
    private int numColumns;

    private ArrayList<ArrayList<Terrain>> map;
    public GameMap() {
        map = new ArrayList<ArrayList<Terrain>>();
    }

    public GameMap(final int numRows, final int numColumns) {
        this.numRows = numRows;
        this.numColumns = numColumns;
        map = new ArrayList<ArrayList<Terrain>>(numRows);
        for (int i = 0; i < numRows; ++i) {
            map.add(new ArrayList<Terrain>(numColumns));
        }
    }

    /**/
    public ArrayList<ArrayList<Terrain>> getMap() {
        return map;
    }
    /**/
    public void addToMap(final int row, final Terrain column) {
        getMap().get(row).add(column);
    }

    /**/
    public int getNumRows() {
        return numRows;
    }

    /**/
    public int getNumColumns() {
        return numColumns;
    }

    public static GameMap getInstance() {
        return singleInstance;
    }

    public static GameMap getInstance(final int numRows, final int numColumns) {
        if (singleInstance == null) {
            singleInstance = new GameMap(numRows, numColumns);
        }
        return singleInstance;
    }
}
