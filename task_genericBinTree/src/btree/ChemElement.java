package btree;

public class ChemElement implements Comparable<ChemElement> {
	
	private String name;		
	private double density;		
	
	/**
	 * Constructor  
	 * @param name - name of element
	 * @param density - its density
	 */
	public ChemElement(String name, double density){
		this.name = name;
		this.density = density;
	}
	
	/**
	 * Prints ChemElement
	 */
	@Override
	public String toString() {
		return this.name + " " + this.density;
	}
	
	/**
	 * Compares to elements: x.compareTo(y)
	 * @return -1 if x < y, 0 if x = y; 1 if x > y 
	 */
	@Override
	public int compareTo(ChemElement o) {	
		if (this.density < o.density) return -1;
		if (this.density > o.density) return 1;	
		return 0;	
	}

	
	
}
