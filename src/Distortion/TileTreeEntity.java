package Distortion;


public class TileTreeEntity extends Mob{

	public TileTreeEntity(int x, int y){
		this.x = x<<4;
		this.y = y<<4;
		sprite = Sprite.spawn_tree;
	}
	public void update(){
		
	}
	public void render(Screen screen) {
		

		screen.renderTree(x - 16, y - 16, sprite);

	}

}
	

