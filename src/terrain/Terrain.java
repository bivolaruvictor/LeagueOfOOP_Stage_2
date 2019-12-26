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
