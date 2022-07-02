import java.util.ArrayList;
import java.util.Iterator;

// I have use contains to array list. Contains use equals method

public class Set<E> {

	private ArrayList<E> setList;

	public Set() {
		this.setList = new ArrayList<E>();
	}

	public Set(E[] arr) {
		// adds the array items without duplicates
		this.setList = new ArrayList<E>();
		for (int i = 0; i < arr.length; i++) {
			if (!this.setList.contains(arr[i])) {
				this.setList.add(arr[i]);
			}
		}
	}

	public void union(Set<E> set2) {
		Iterator<E> it = set2.getList().iterator();
		while (it.hasNext()) {
			E next = it.next();
			if (!this.setList.contains(next)) {
				this.setList.add(next);
			}
		}
	}

	public void intersect(Set<E> set2) {
		ArrayList<E> list2 = set2.getList();
		Iterator<E> it = this.setList.iterator();
		while (it.hasNext()) {
			E next = it.next();
			if (!list2.contains(next)) {
				it.remove();
			}
		}
	}

	public boolean isSubset(Set<E> set2) {
		Iterator<E> it = set2.getList().iterator();
		while (it.hasNext()) {
			E next = it.next();
			if (!this.setList.contains(next)) {
				return false;
			}
		}
		return true;
	}

	public boolean isMember(E item) {
		if (this.setList.contains(item)) {
			return true;
		}
		return false;
	}

	public void insert(E item) {
		if (!isMember(item)) {
			this.setList.add(item);
		}
	}

	public void delete(E item) {
		if (isMember(item)) {
			this.setList.remove(item);
		}
	}

	public Iterator<E> iterator() {
		return this.setList.iterator();
	}

	@Override
	public String toString() {
		return "" + setList + "";
	}

	private ArrayList<E> getList() {
		return this.setList;
	}

}
