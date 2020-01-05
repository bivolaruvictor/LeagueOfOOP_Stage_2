/*
 * Terrain.java
 *
 * 5/1/2020
 *
 * Bivolaru Victor-Alexandru 324CA
 */
package terrain;

public abstract class Terrain {
    private TerrainType terrainType;
    /**/
    public void setTerrainType(final TerrainType terrainType) {
        this.terrainType = terrainType;
    }
    /**/
    public TerrainType getTerrainType() {
        return terrainType;
    }
}
