package algo.girlTeacher.linkList;

public class LinkListApp2 {

	public static void main(String[] args) {
		LinkList list = new LinkList();
		list.insertFirst(22, 2.99);
		list.insertFirst(44, 4.99);
		list.insertFirst(66, 6.99);
		list.insertFirst(88, 8.99);
		list.displayList();

		Link f = list.find(44);
		if(f != null)
			System.out.println("Found link with key: " + f.iData);
		else
			System.out.println("Can not find link.");
		
		Link del = list.delete(66);
		if(del != null)
			System.out.println("deleted link with key: " + del.iData);
		else
			System.out.println("Can not find link.");
		list.displayList();
	}

}
