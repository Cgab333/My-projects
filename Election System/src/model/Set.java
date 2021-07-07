package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Set<T> implements Iterable<T>, Serializable {
	private List<T> list;

	public Set() {
		this.list = new ArrayList<>();
	}

	public int size() {
		return list.size();
	}

	public T get(int index) {
		return list.get(index);
	}

	public int indexOf(T t1) {
		return list.indexOf(t1);
	}

	public void remove(int index) {
		list.remove(index);
	}

	public void clear() {
		list.clear();
	}

	public void add(T t1) {
		for (T t : list) {
			if (t.equals(t1)) {
				return;
			}
		}
		list.add(t1);
	}

	@Override
	public Iterator iterator() {
		return list.iterator();

	}

	public void sort(Object object) {
		list.sort(null);

	}

}
