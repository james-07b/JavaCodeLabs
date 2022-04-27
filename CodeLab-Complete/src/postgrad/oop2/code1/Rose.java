// James Burke: 
// Code the enumeration type Rose as per the UML. This enumeration should contain 
// references that represent four types of roses: RED, YELLOW, WHITE and PINK 
// (representing "Red", "Yellow", "White" and "Pink" respectively). 
package postgrad.oop2.code1;

public enum Rose {
	RED("Red"), YELLOW("Yellow"), WHITE("White"), PINK("Pink");
	
	private String colour;
    
    Rose(String colour){ 
        this.colour=colour;
    }

	public String getColour() {
		return colour;
	}
}
