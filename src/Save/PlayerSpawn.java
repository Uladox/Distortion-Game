package Save;

public class PlayerSpawn {
public static int playerx = 135;
public static int playery = 196;

	public  PlayerSpawn(int ending) {
		PlayerSpawncal( ending);	
	
	return;
}



	public int PlayerSpawncal(int end){
		
			findx(end);
			findy(end);
		
		return playerx & playery;
	}
		
		

public  int findx(int end){
	if(end ==3){
		playerx = 51;
	}
	else{
		playerx = 135;
	}
	return playerx;
	}


public  int findy(int end){
	if(end ==3){
		playery = 160;
	}
	else{
		playery = 196;
	}
	return playery;
	}
}


