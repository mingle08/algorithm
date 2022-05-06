package algorithm.girlTeacher.linkList;

public class LinkListApp {

	public static void main(String[] args) {
		LinkList list = new LinkList();
		list.insertFirst(22, 2.99);
		list.insertFirst(44, 4.99);
		list.insertFirst(66, 6.99);
		list.insertFirst(88, 8.99);
		list.displayList();

		while(!list.isEmpty()) {
			Link aLink = list.deleteFirst();
			System.out.print("deleted ");
			aLink.display();
			System.out.println();
		}
		list.displayList();

	}

}
