import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Scanner;

public class Clicker {

	/**
	 * @param args
	 * @throws AWTException
	 */
	public static void main(String[] args) throws AWTException
	{
		Robot click = new Robot();
		Scanner input = new Scanner(System.in);
		input.nextLine();
		int x = 0;
		Point p = MouseInfo.getPointerInfo().getLocation();
		while(x == 0) {
			for (int i = 0; i < 100000; i++) {
				click.mousePress(InputEvent.BUTTON1_MASK);
				click.mouseRelease(InputEvent.BUTTON1_MASK);
				try {
					Thread.sleep(10);// 1000 milliseconds is one second.
				} catch (InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
			}
			try {
				Thread.sleep(5000);// 1000 milliseconds is one second.
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
			x = mouseMoved(click, p);
		}
	}
	
	public static int mouseMoved(Robot mouse, Point p){
		Point now = MouseInfo.getPointerInfo().getLocation();
		if(p.distance(now) > 1){
			return 1;
		}
		return 0;
	}
}
