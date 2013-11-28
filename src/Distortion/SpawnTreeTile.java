package Distortion;


public class SpawnTreeTile extends Tile {
	//public TileEntity  tileEntity;
	public SpawnTreeTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
		
	}

	public boolean front() {
		return true;
	}
	
	
}
