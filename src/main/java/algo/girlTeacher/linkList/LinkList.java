package algo.girlTeacher.linkList;

public class LinkList {

	private Link first;
	public LinkList() {
		first = null;
	}
	
	/**
	 * 从头部添加
	 * @param id
	 * @param dd
	 */
	public void insertFirst(int id, double dd) {
		Link newLink = new Link(id, dd);
		newLink.next = first;
		first = newLink;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	// 删除：从头部删除
	public Link deleteFirst() {
		Link temp = first;
		first = first.next;
		return temp;
	}
	
	public void displayList() {
		System.out.println("List (first ---> last): ");
		Link current = first;
		while(current != null) {
			current.display();
			current = current.next;
		}
		System.out.println();
	}
	
	public Link find(int key) {
		Link current = first;
		while(current.iData != key) {
			if(current.next != null) {
				current = current.next;
			}else {
				return null;
			}
		}
		return current;
	}
	
	public Link delete(int key) {
		Link current = first;
		Link previous = first;
		while(current.iData != key) {
			if(current.next == null) {
				return null;
			}else {
				previous = current;
				current = current.next;
			}
		}
		if(current == first) 
			first = first.next;
		else 
			previous.next = current.next;
		
		return current;
		
	}
}
