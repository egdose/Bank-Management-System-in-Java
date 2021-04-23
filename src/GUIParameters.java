import java.awt.Color;import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class GUIParameters {

	public int frameWidth = 960;
	public int frameHeight = 720;
	
	//FONT VARIABLES
	public Font normalFont = new Font("Montserrat", Font.PLAIN, 12);
	public Font titleFont = new Font("TYPOGRAPH PRO", Font.PLAIN, 32);
	public Font headingFont = new Font("Montserrat", Font.BOLD, 20);
	public Font subheadingFont = new Font("Montserrat", Font.PLAIN, 14);
	
	//COLOR VARIABLES
	public Color backgroundBlue = new Color(0x00194F);
	public Color backgroundPurple = new Color(0x7000D0);
	public Color backgroundDark = new Color(0x1A1423);
	public Color primaryStrong = new Color(0x2C6DFE);
	public Color primaryLight = new Color(0x1DDAFF);
	public Color whiteMain = new Color(0xE9EEF4);
	public Color whiteSecondary = new Color(0xC3D0E1);
	
	//TEXTFIELD DIMENSIONS
	public Dimension normalField = new Dimension(275, 17);
	
	//BORDERS
	public Border noBorder = BorderFactory.createEmptyBorder();
	public Border solidBorder = BorderFactory.createLineBorder(Color.white, 1);
	
	GUIParameters(){
		
	}
}
