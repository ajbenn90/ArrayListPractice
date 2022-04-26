package dynamicList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ListTests {

	@Test
	void prependTest01() {
		IntDynamicList list = new IntDynamicList();
		list.append(72);
		assertEquals(72, list.get(0));
		list.append(47);
		assertEquals(47, list.get(1));
		list.append(80);
		assertEquals(80, list.get(2));
		list.prepend(62);
		assertEquals(62, list.get(0));
	}


	@Test
	void prependTest02() {
		IntDynamicList list = new IntDynamicList();
		list.append(47);
		assertEquals(47, list.get(0));
		list.append(72);
		assertEquals(72, list.get(1));
		list.append(80);
		assertEquals(80, list.get(2));
		list.prepend(78);
		assertEquals(78, list.get(0));
		list.prepend(14);
		assertEquals(14, list.get(0));
		list.prepend(1701);
		assertEquals(1701, list.get(0));
	}

	@Test
	void removeTest01() {
		IntDynamicList list = new IntDynamicList();
		list.append(47);
		assertEquals(47, list.get(0));
		list.append(1701);
		assertEquals(1701, list.get(1));
		list.remove(0);
		assertEquals(1701, list.get(0));
	}
	
	@Test
	void removeTest02() {
		IntDynamicList list = new IntDynamicList();
		list.append(47);
		assertEquals(47, list.get(0));
		list.append(1701);
		assertEquals(1701, list.get(1));
		list.remove(1);
		assertFalse(list.contains(1701));
	}
	
	

	// TODO: With toArray, make sure that the array's elements are not pointing to
	// the elements of the original list
	// Maybe in appendAll as well


}
