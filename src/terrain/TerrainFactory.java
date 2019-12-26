package terrain;

public class TerrainFactory {
    /**/
    public Terrain getTerrainType(final TerrainType terrainType) {
        if (terrainType == null) {
            return null;
        }
        if (terrainType.equals(TerrainType.volcanic)) {
            return new Volcanic();
        }
        if (terrainType.equals(TerrainType.dessert)) {
            return new Dessert();
        }
        if (terrainType.equals(TerrainType.woods)) {
            return new Woods();
        }
        if (terrainType.equals(TerrainType.land)) {
            return new Land();
        }
        return null;
    }
}
