package Save;

import Distortion.Game;
import GUIstart.PrologueWindow;

public class Ending {
	public static int allend;
	public static boolean visible = true;
	
	public Ending( int end){
		visible();
		allend = end;
		endchooser(allend);
	//	PrologueWindow Prologue1 = new PrologueWindow(4);
		
	}
	
	public static boolean visible(){
		visible = false;
		return visible;
		
	}
	public static void endchooser(int end){
		System.out.println("end value " + end);
		if( end == 2){
			PrologueWindow Prologue1 = new PrologueWindow(7);
			PrologueWindow Prologue2 = new PrologueWindow(8);
			PrologueWindow Prologue3 = new PrologueWindow(9);
			PrologueWindow Prologue4 = new PrologueWindow(10);
			PrologueWindow Prologue5 = new PrologueWindow(11);
			PrologueWindow Prologue6 = new PrologueWindow(12);
			System.exit(0);
		}
		if( end == 3){
			PrologueWindow Prologue1 = new PrologueWindow(4);
			PrologueWindow Prologue2 = new PrologueWindow(5);
			System.exit(0);
		}
		if( end == 4){
			PrologueWindow Prologue1 = new PrologueWindow(4);
			System.exit(0);
		}
		if( end == 5){
			PrologueWindow Prologue1 = new PrologueWindow(6);
			System.exit(0);
		}
	}
}
