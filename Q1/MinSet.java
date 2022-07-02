import java.util.Iterator;

public class MinSet {

	public static <E extends Comparable<E>> E minItem(Set<E> set) {
		Iterator<E> it = set.iterator();
		E min = it.next();
		while (it.hasNext()) {
			E next = it.next();
			if (next.compareTo(min) < 0) {
				min = next;
			}
		}
		return min;
	}
}
