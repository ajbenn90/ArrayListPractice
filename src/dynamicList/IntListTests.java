package dynamicList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IntListTests {

	/**
	 * Tests appending a single element to an empty list.
	 */
	@Test
	void appendTest01() {
		IntDynamicList l = new IntDynamicList();
		l.append(0);

		assertEquals(1, l.size());
		assertEquals(0, l.get(0));
	}

	/**
	 * Tests appending two elements to an empty list.
	 */
	@Test
	void appendTest02() {
		IntDynamicList l = new IntDynamicList();
		l.append(1);
		l.append(2);

		assertEquals(2, l.size());
		assertEquals(1, l.get(0));
		assertEquals(2, l.get(1));
	}

	/**
	 * Tests appending a list to an empty list.
	 */
	@Test
	void appendAllTest01() {
		IntDynamicList l = new IntDynamicList();
		IntDynamicList other = new IntDynamicList();
		other.append(0);
		other.append(1);
		other.append(2);
		l.appendAll(other);

		assertEquals(other, l);
	}

	/**
	 * Tests appending a list to a non-empty list.
	 */
	@Test
	void appendAllTest02() {
		IntDynamicList l = new IntDynamicList();
		l.append(0);
		IntDynamicList other = new IntDynamicList();
		other.append(1);
		other.append(2);
		other.append(3);
		l.appendAll(other);

		assertEquals(4, l.size());
		for (int i = 0; i < l.size(); i++)
			assertEquals(i, l.get(i));
	}

	/**
	 * Tests clearing an empty list
	 */
	@Test
	void clearTest01() {
		IntDynamicList l = new IntDynamicList();
		l.clear();

		assertEquals(0, l.size());
	}

	/**
	 * Tests clearing a non-empty list. Attempting to access an element that was
	 * cleared should throw an exception.
	 */
	@Test
	void clearTest02() {
		IntDynamicList l = new IntDynamicList();
		l.append(0);
		l.append(1);
		l.clear();

		assertEquals(0, l.size());
		assertThrows(IndexOutOfBoundsException.class, () -> {
			l.get(1);
		});
	}

	/**
	 * Tests finding an element in a list where the only element is the one being
	 * searched for
	 */
	@Test
	void containsTest01() {
		IntDynamicList l = new IntDynamicList();
		l.append(22);

		assertTrue(l.contains(22));
	}

	/**
	 * Tests finding an element in an empty list
	 */
	@Test
	void containsTest02() {
		IntDynamicList l = new IntDynamicList();

		assertFalse(l.contains(22));
	}

	/**
	 * Tests finding an element in an list with one occurrence of the element and
	 * several occurrences of other elements
	 */
	@Test
	void containsTest03() {
		IntDynamicList l = new IntDynamicList();
		l.append(0);
		l.append(22);
		l.append(100);
		l.append(-1);

		assertTrue(l.contains(22));
	}

	/**
	 * Tests finding an element in an list with several instances of the element and
	 * several occurrences of other elements
	 */
	@Test
	void containsTest04() {
		IntDynamicList l = new IntDynamicList();
		l.append(0);
		l.append(22);
		l.append(100);
		l.append(-1);
		l.append(22);
		l.append(124);

		assertTrue(l.contains(22));
	}

	/**
	 * Tests finding an element that isn't in the list
	 */
	@Test
	void containsTest05() {
		IntDynamicList l = new IntDynamicList();
		l.append(0);
		l.append(22);
		l.append(100);
		l.append(-1);
		l.append(22);
		l.append(124);

		assertFalse(l.contains(1));
	}

	/**
	 * Tests finding an element at the beginning of the list
	 */
	@Test
	void containsTest06() {
		IntDynamicList l = new IntDynamicList();
		l.append(0);
		l.append(22);
		l.append(100);

		assertTrue(l.contains(0));
	}

	/**
	 * Tests finding an element at the end of the list
	 */
	@Test
	void containsTest07() {
		IntDynamicList l = new IntDynamicList();
		l.append(0);
		l.append(22);
		l.append(100);

		assertTrue(l.contains(100));
	}

	/**
	 * Tests if two empty lists are equal
	 */
	@Test
	void equalsTest01() {
		IntDynamicList l1 = new IntDynamicList();
		IntDynamicList l2 = new IntDynamicList();

		assertTrue(l1.equals(l2));
	}

	/**
	 * Tests if an empty list equals itself
	 */
	@Test
	void equalsTest02() {
		IntDynamicList l1 = new IntDynamicList();

		assertTrue(l1.equals(l1));
	}

	/**
	 * Tests if two non-empty lists are equal
	 */
	@Test
	void equalsTest03() {
		IntDynamicList l1 = new IntDynamicList();
		l1.append(0);
		IntDynamicList l2 = new IntDynamicList();
		l2.append(0);

		assertTrue(l1.equals(l2));
	}

	/**
	 * Tests if a non-empty list equals itself
	 */
	@Test
	void equalsTest04() {
		IntDynamicList l1 = new IntDynamicList();
		l1.append(0);

		assertTrue(l1.equals(l1));
	}

	/**
	 * Tests that lists of the same size but different elements are not equal
	 */
	@Test
	void equalsTest05() {
		IntDynamicList l1 = new IntDynamicList();
		l1.append(0);
		IntDynamicList l2 = new IntDynamicList();
		l2.append(1);

		assertFalse(l1.equals(l2));
	}

	/**
	 * This should be false. The first list has fewer elements than the second list,
	 * but the first l1.size() elements are the same between them.
	 */
	@Test
	void equalsTest06() {
		IntDynamicList l1 = new IntDynamicList();
		l1.append(0);
		l1.append(1);
		l1.append(2);
		IntDynamicList l2 = new IntDynamicList();
		l2.append(0);
		l2.append(1);
		l2.append(2);
		l2.append(3);

		assertFalse(l1.equals(l2));
	}

	/**
	 * This should be false. The second list has fewer elements than the first list,
	 * but the first l2.size() elements are the same between them.
	 */
	@Test
	void equalsTest07() {
		IntDynamicList l1 = new IntDynamicList();
		l1.append(0);
		l1.append(1);
		l1.append(2);
		l1.append(3);
		IntDynamicList l2 = new IntDynamicList();
		l2.append(0);
		l2.append(1);
		l2.append(2);

		assertFalse(l1.equals(l2));
	}

	/**
	 * Tests that an empty and non-empty list are unequal where the first list is
	 * empty.
	 */
	@Test
	void equalsTest08() {
		IntDynamicList l1 = new IntDynamicList();
		IntDynamicList l2 = new IntDynamicList();
		l2.append(0);

		assertFalse(l1.equals(l2));
	}

	/**
	 * Tests that an empty and non-empty list are unequal where the second list is
	 * empty.
	 */
	@Test
	void equalsTest09() {
		IntDynamicList l1 = new IntDynamicList();
		l1.append(0);
		IntDynamicList l2 = new IntDynamicList();

		assertFalse(l1.equals(l2));
	}

	/**
	 * Tests that an empty and null list are unequal.
	 */
	@Test
	void equalsTest10() {
		IntDynamicList l = new IntDynamicList();

		assertFalse(l.equals(null));
	}

	/**
	 * Tests that a non-empty and null list are unequal.
	 */
	@Test
	void equalsTest11() {
		IntDynamicList l = new IntDynamicList();
		l.append(0);

		assertFalse(l.equals(null));
	}

	/**
	 * Tests that getting valid indexes from a list works.
	 */
	@Test
	void getTest01() {
		IntDynamicList l = new IntDynamicList();
		l.append(10);
		l.append(11);
		l.append(12);
		l.append(13);

		for (int i = 0; i < l.size(); i++)
			assertEquals(i + 10, l.get(i));
	}

	/**
	 * Tests that getting a negative index from an empty list throws an exception.
	 */
	@Test
	void getTest02() {
		IntDynamicList l = new IntDynamicList();

		assertThrows(IndexOutOfBoundsException.class, () -> {
			l.get(-1);
		});
		assertThrows(IndexOutOfBoundsException.class, () -> {
			l.get(-100);
		});
	}

	/**
	 * Tests that getting index 0 from an empty list throws an exception.
	 */
	@Test
	void getTest03() {
		IntDynamicList l = new IntDynamicList();

		assertThrows(IndexOutOfBoundsException.class, () -> {
			l.get(0);
		});
	}

	/**
	 * Tests that getting index l.size() for a non-empty list throws an exception.
	 */
	@Test
	void getTest04() {
		IntDynamicList l = new IntDynamicList();
		l.append(10);
		l.append(11);
		l.append(12);
		l.append(13);

		assertThrows(IndexOutOfBoundsException.class, () -> {
			l.get(4);
		});
	}

	/**
	 * Tests that getting index greater than l.size() for a non-empty list throws an
	 * exception.
	 */
	@Test
	void getTest05() {
		IntDynamicList l = new IntDynamicList();
		l.append(10);
		l.append(11);
		l.append(12);
		l.append(13);

		assertThrows(IndexOutOfBoundsException.class, () -> {
			l.get(5);
		});
		assertThrows(IndexOutOfBoundsException.class, () -> {
			l.get(500);
		});
	}

	/**
	 * If the list is empty, should return -1
	 */
	@Test
	void indexOfTest01() {
		IntDynamicList l = new IntDynamicList();

		assertEquals(-1, l.indexOf(0));
		assertEquals(-1, l.indexOf(1));
		assertEquals(-1, l.indexOf(-1));
	}

	/**
	 * If a list of length 1 does not contain the element, should return -1
	 */
	@Test
	void indexOfTest02() {
		IntDynamicList l = new IntDynamicList();
		l.append(0);

		assertEquals(-1, l.indexOf(1));
	}
	
	/**
	 * If a list does not contain the element, should return -1
	 */
	@Test
	void indexOfTest03() {
		IntDynamicList l = new IntDynamicList();
		l.append(4);
		l.append(5);
		l.append(6);

		assertEquals(-1, l.indexOf(0));
	}
	
	/**
	 * Test on a length 1 list with an instance of the element being searched for
	 */
	@Test
	void indexOfTest04() {
		IntDynamicList l = new IntDynamicList();
		l.append(4);
		
		assertEquals(0, l.indexOf(4));
	}
	
	/**
	 * Test on a list that contains one of the given element
	 */
	@Test
	void indexOfTest05() {
		IntDynamicList l = new IntDynamicList();
		l.append(1);
		l.append(4);
		l.append(0);
		
		assertEquals(1, l.indexOf(4));
	}
	
	/**
	 * Test on a list that contains several of the given element
	 */
	@Test
	void indexOfTest06() {
		IntDynamicList l = new IntDynamicList();
		l.append(1);
		l.append(4);
		l.append(0);
		l.append(4);
		l.append(4);
		l.append(5);
		
		assertEquals(1, l.indexOf(4));
	}
	
	/**
	 * Test on a list that contains the given element at the beginning
	 */
	@Test
	void indexOfTest07() {
		IntDynamicList l = new IntDynamicList();
		l.append(4);
		l.append(4);
		l.append(0);
		l.append(4);
		l.append(4);
		l.append(5);
		
		assertEquals(0, l.indexOf(4));
	}
	
	/**
	 * Test on a list that only contains the given element at the end
	 */
	@Test
	void indexOfTest08() {
		IntDynamicList l = new IntDynamicList();
		l.append(4);
		l.append(4);
		l.append(0);
		l.append(4);
		l.append(4);
		l.append(5);
		
		assertEquals(0, l.indexOf(5));
	}
	
	/**
	 * 
	 */
	@Test
	void insertTest01() {
		
	}

}
