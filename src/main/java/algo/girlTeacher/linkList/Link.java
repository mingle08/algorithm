package algo.girlTeacher.linkList;

public class Link {

	public int iData;
	public double dData;
	public Link next;
	public Link(int id, double dd) {
		this.iData = id;
		this.dData = dd;
	}
	
	public void display() {
		System.out.print("{" + iData + " , " + dData + "}");
	}
	
	
}
