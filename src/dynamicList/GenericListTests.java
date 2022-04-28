package dynamicList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/* NOTE: assertEquals(intList1, intList2) won't work since the equals methods are overloaded instead of overriden.
 * You have to use assertTrue(intList1.equals(intList2)).
 */

class GenericListTests {

	/**
	 * Tests appending a single element to an empty list.
	 */
	@Test
	void appendTest01() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.append(0);

		assertEquals(1, l.size());
		assertEquals(0, l.get(0));
	}

	/**
	 * Tests appending two elements to an empty list.
	 */
	@Test
	void appendTest02() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.append(1);
		l.append(2);

		assertEquals(2, l.size());
		assertEquals(1, l.get(0));
		assertEquals(2, l.get(1));
	}

	/**
	 * Append 1000 elements. This should guarantee a resize.
	 */
	@Test
	void appendTest03() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		for (int i = 0; i < 1000; i++)
			l.append(i);

		assertEquals(1000, l.size());
		for (int i = 0; i < 1000; i++)
			assertEquals(i, l.get(i));
	}
	
	/**
	 * Append null
	 */
	@Test
	void appendTest04() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.append(1);
		l.append(null);

		assertEquals(2, l.size());
		assertEquals(1, l.get(0));
		assertEquals(null, l.get(1));
	}

	/**
	 * Tests appending a list to an empty list.
	 */
	@Test
	void appendAllTest01() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		DynamicList<Integer> other = new DynamicList<Integer>();
		other.append(0);
		other.append(1);
		other.append(2);
		l.appendAll(other);

		assertTrue(l.equals(other));
	}

	/**
	 * Tests appending a list to a non-empty list.
	 */
	@Test
	void appendAllTest02() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.append(0);
		DynamicList<Integer> other = new DynamicList<Integer>();
		other.append(1);
		other.append(2);
		other.append(3);
		l.appendAll(other);

		assertEquals(4, l.size());
		for (int i = 0; i < l.size(); i++)
			assertEquals(i, l.get(i));
	}

	/**
	 * Append 1000 elements. This should guarantee a resize.
	 */
	@Test
	void appendAllTest03() {
		DynamicList<Integer> l1 = new DynamicList<Integer>();
		for (int i = 0; i < 1000; i++)
			l1.append(i);

		DynamicList<Integer> l2 = new DynamicList<Integer>();
		l2.appendAll(l1);

		assertEquals(1000, l2.size());
		for (int i = 0; i < 1000; i++)
			assertEquals(i, l2.get(i));
	}

	/**
	 * Append an empty to list to this list
	 */
	@Test
	void appendAllTest04() {
		DynamicList<Integer> l1 = new DynamicList<Integer>();
		l1.append(0);

		DynamicList<Integer> l2 = new DynamicList<Integer>();
		l1.appendAll(l2);

		Integer[] expected = { 0 };
		assertArrayEquals(expected, l1.toArray());
	}

	/**
	 * Append an empty to list to an empty list
	 */
	@Test
	void appendAllTest05() {
		DynamicList<Integer> l1 = new DynamicList<Integer>();

		DynamicList<Integer> l2 = new DynamicList<Integer>();
		l1.appendAll(l2);

		Integer[] expected = {};
		assertArrayEquals(expected, l1.toArray());
	}
	
	/**
	 * Append null value
	 */
	@Test
	void appendAllTest06() {
		DynamicList<Integer> l1 = new DynamicList<Integer>();
		l1.append(0);

		DynamicList<Integer> l2 = new DynamicList<Integer>();
		l2.append(null);
		l1.appendAll(l2);

		Integer[] expected = { 0, null };
		assertArrayEquals(expected, l1.toArray());
	}

	/**
	 * Tests clearing an empty list
	 */
	@Test
	void clearTest01() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.clear();

		assertEquals(0, l.size());
	}

	/**
	 * Tests clearing a non-empty list. Attempting to access an element that was
	 * cleared should throw an exception.
	 */
	@Test
	void clearTest02() {
		DynamicList<Integer> l = new DynamicList<Integer>();
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
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.append(22);

		assertTrue(l.contains(22));
	}

	/**
	 * Tests finding an element in an empty list
	 */
	@Test
	void containsTest02() {
		DynamicList<Integer> l = new DynamicList<Integer>();

		assertFalse(l.contains(22));
	}

	/**
	 * Tests finding an element in an list with one occurrence of the element and
	 * several occurrences of other elements
	 */
	@Test
	void containsTest03() {
		DynamicList<Integer> l = new DynamicList<Integer>();
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
		DynamicList<Integer> l = new DynamicList<Integer>();
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
		DynamicList<Integer> l = new DynamicList<Integer>();
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
		DynamicList<Integer> l = new DynamicList<Integer>();
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
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.append(0);
		l.append(22);
		l.append(100);

		assertTrue(l.contains(100));
	}
	
	/**
	 * Find a new String object
	 */
	@Test
	void containsTest08() {
		DynamicList<String> l = new DynamicList<String>();
		l.append("a");
		l.append("b");
		l.append("c");

		assertTrue(l.contains(new String("a")));
	}
	
	/**
	 * Contains null value
	 */
	@Test
	void containsTest09() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.append(null);

		assertTrue(l.contains(null));
	}
	
	/**
	 * Search for non-existent null value
	 */
	@Test
	void containsTest10() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.append(10);

		assertFalse(l.contains(null));
	}

	/**
	 * Tests if two empty lists are equal
	 */
	@Test
	void equalsTest01() {
		DynamicList<Integer> l1 = new DynamicList<Integer>();
		DynamicList<Integer> l2 = new DynamicList<Integer>();

		assertTrue(l1.equals(l2));
	}

	/**
	 * Tests if an empty list equals itself
	 */
	@Test
	void equalsTest02() {
		DynamicList<Integer> l1 = new DynamicList<Integer>();

		assertTrue(l1.equals(l1));
	}

	/**
	 * Tests if two non-empty lists are equal
	 */
	@Test
	void equalsTest03() {
		DynamicList<Integer> l1 = new DynamicList<Integer>();
		l1.append(0);
		DynamicList<Integer> l2 = new DynamicList<Integer>();
		l2.append(0);

		assertTrue(l1.equals(l2));
	}

	/**
	 * Tests if a non-empty list equals itself
	 */
	@Test
	void equalsTest04() {
		DynamicList<Integer> l1 = new DynamicList<Integer>();
		l1.append(0);

		assertTrue(l1.equals(l1));
	}

	/**
	 * Tests that lists of the same size but different elements are not equal
	 */
	@Test
	void equalsTest05() {
		DynamicList<Integer> l1 = new DynamicList<Integer>();
		l1.append(0);
		DynamicList<Integer> l2 = new DynamicList<Integer>();
		l2.append(1);

		assertFalse(l1.equals(l2));
	}

	/**
	 * This should be false. The first list has fewer elements than the second list,
	 * but the first l1.size() elements are the same between them.
	 */
	@Test
	void equalsTest06() {
		DynamicList<Integer> l1 = new DynamicList<Integer>();
		l1.append(0);
		l1.append(1);
		l1.append(2);
		DynamicList<Integer> l2 = new DynamicList<Integer>();
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
		DynamicList<Integer> l1 = new DynamicList<Integer>();
		l1.append(0);
		l1.append(1);
		l1.append(2);
		l1.append(3);
		DynamicList<Integer> l2 = new DynamicList<Integer>();
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
		DynamicList<Integer> l1 = new DynamicList<Integer>();
		DynamicList<Integer> l2 = new DynamicList<Integer>();
		l2.append(0);

		assertFalse(l1.equals(l2));
	}

	/**
	 * Tests that an empty and non-empty list are unequal where the second list is
	 * empty.
	 */
	@Test
	void equalsTest09() {
		DynamicList<Integer> l1 = new DynamicList<Integer>();
		l1.append(0);
		DynamicList<Integer> l2 = new DynamicList<Integer>();

		assertFalse(l1.equals(l2));
	}

	/**
	 * Tests that an empty and null list are unequal.
	 */
	@Test
	void equalsTest10() {
		DynamicList<Integer> l = new DynamicList<Integer>();

		assertFalse(l.equals(null));
	}

	/**
	 * Tests that a non-empty and null list are unequal.
	 */
	@Test
	void equalsTest11() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.append(0);

		assertFalse(l.equals(null));
	}
	
	/**
	 * Using a String list
	 */
	@Test
	void equalsTest12() {
		DynamicList<String> l1 = new DynamicList<String>();
		l1.append("a");
		DynamicList<String> l2 = new DynamicList<String>();
		l2.append(new String("a"));

		assertTrue(l1.equals(l2));
	}
	
	/**
	 * Null value in this list
	 */
	@Test
	void equalsTest13() {
		DynamicList<String> l1 = new DynamicList<String>();
		l1.append(null);
		l1.append("b");
		DynamicList<String> l2 = new DynamicList<String>();
		l2.append("a");
		l2.append("b");

		assertFalse(l1.equals(l2));
	}
	
	/**
	 * Null value in other list
	 */
	@Test
	void equalsTest14() {
		DynamicList<String> l1 = new DynamicList<String>();
		l1.append("a");
		l1.append("b");
		DynamicList<String> l2 = new DynamicList<String>();
		l2.append("a");
		l2.append(null);

		assertFalse(l1.equals(l2));
	}
	
	/**
	 * Null values in both lists. Lists same.
	 */
	@Test
	void equalsTest15() {
		DynamicList<String> l1 = new DynamicList<String>();
		l1.append("a");
		l1.append(null);
		DynamicList<String> l2 = new DynamicList<String>();
		l2.append("a");
		l2.append(null);

		assertTrue(l1.equals(l2));
	}

	/**
	 * Tests that getting valid indexes from a list works.
	 */
	@Test
	void getTest01() {
		DynamicList<Integer> l = new DynamicList<Integer>();
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
		DynamicList<Integer> l = new DynamicList<Integer>();

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
		DynamicList<Integer> l = new DynamicList<Integer>();

		assertThrows(IndexOutOfBoundsException.class, () -> {
			l.get(0);
		});
	}

	/**
	 * Tests that getting index l.size() for a non-empty list throws an exception.
	 */
	@Test
	void getTest04() {
		DynamicList<Integer> l = new DynamicList<Integer>();
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
		DynamicList<Integer> l = new DynamicList<Integer>();
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
	 * Get a null value
	 */
	@Test
	void getTest06() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.append(null);

		assertEquals(null, l.get(0));
	}

	/**
	 * If the list is empty, should return -1
	 */
	@Test
	void indexOfTest01() {
		DynamicList<Integer> l = new DynamicList<Integer>();

		assertEquals(-1, l.indexOf(0));
		assertEquals(-1, l.indexOf(1));
		assertEquals(-1, l.indexOf(-1));
	}

	/**
	 * If a list of length 1 does not contain the element, should return -1
	 */
	@Test
	void indexOfTest02() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.append(0);

		assertEquals(-1, l.indexOf(1));
	}

	/**
	 * If a list does not contain the element, should return -1
	 */
	@Test
	void indexOfTest03() {
		DynamicList<Integer> l = new DynamicList<Integer>();
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
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.append(4);

		assertEquals(0, l.indexOf(4));
	}

	/**
	 * Test on a list that contains one of the given element
	 */
	@Test
	void indexOfTest05() {
		DynamicList<Integer> l = new DynamicList<Integer>();
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
		DynamicList<Integer> l = new DynamicList<Integer>();
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
		DynamicList<Integer> l = new DynamicList<Integer>();
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
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.append(4);
		l.append(4);
		l.append(0);
		l.append(4);
		l.append(4);
		l.append(5);

		assertEquals(5, l.indexOf(5));
	}
	
	/**
	 * Using new String objects
	 */
	@Test
	void indexOfTest09() {
		DynamicList<String> l = new DynamicList<String>();
		l.append("a");
		l.append("b");
		l.append("c");

		assertEquals(0, l.indexOf(new String("a")));
	}
	
	/**
	 * Null value in list, not searched for
	 */
	@Test
	void indexOfTest10() {
		DynamicList<String> l = new DynamicList<String>();
		l.append(null);
		l.append("b");
		l.append("c");

		assertEquals(-1, l.indexOf("a"));
	}
	
	/**
	 * Null value not in list, being searched for
	 */
	@Test
	void indexOfTest11() {
		DynamicList<String> l = new DynamicList<String>();
		l.append("a");
		l.append("b");
		l.append("c");

		assertEquals(-1, l.indexOf(null));
	}

	/**
	 * Null value in list, being searched for
	 */
	@Test
	void indexOfTest12() {
		DynamicList<String> l = new DynamicList<String>();
		l.append("a");
		l.append(null);
		l.append("c");

		assertEquals(1, l.indexOf(null));
	}

	/**
	 * Inserting at index 0 into an empty list
	 */
	@Test
	void insertTest01() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.insert(0, 1);

		assertEquals(1, l.size());
		assertEquals(1, l.get(0));
	}

	/**
	 * Inserting several times at the end of a list
	 */
	@Test
	void insertTest02() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		for (int i = 0; i < 5; i++)
			l.insert(i, i + 1);

		assertEquals(5, l.size());
		for (int i = 0; i < 5; i++)
			assertEquals(i + 1, l.get(i));
	}

	/**
	 * Inserting at index 0 into a non-empty list
	 */
	@Test
	void insertTest03() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		for (int i = 0; i < 5; i++)
			l.insert(i, i + 1);
		l.insert(0, 0);

		assertEquals(6, l.size());
		for (int i = 0; i < 6; i++)
			assertEquals(i, l.get(i));
	}

	/**
	 * Inserting into the middle of a non-empty list
	 */
	@Test
	void insertTest04() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.append(0);
		l.append(1);
		l.append(2);
		l.append(4);
		l.insert(3, 3);

		assertEquals(5, l.size());
		for (int i = 0; i < l.size(); i++)
			assertEquals(i, l.get(i));
	}

	/**
	 * Inserting into a negative index in an empty list
	 */
	@Test
	void insertTest05() {
		DynamicList<Integer> l = new DynamicList<Integer>();

		assertThrows(IndexOutOfBoundsException.class, () -> {
			l.insert(-1, 0);
		});
		assertThrows(IndexOutOfBoundsException.class, () -> {
			l.insert(-10, 0);
		});
	}

	/**
	 * Inserting into a negative index in a non-empty list
	 */
	@Test
	void insertTest06() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.append(0);

		assertThrows(IndexOutOfBoundsException.class, () -> {
			l.insert(-1, 0);
		});
		assertThrows(IndexOutOfBoundsException.class, () -> {
			l.insert(-10, 0);
		});
	}

	/**
	 * Inserting into an invalid index in an empty list
	 */
	@Test
	void insertTest07() {
		DynamicList<Integer> l = new DynamicList<Integer>();

		assertThrows(IndexOutOfBoundsException.class, () -> {
			l.insert(1, 0);
		});
		assertThrows(IndexOutOfBoundsException.class, () -> {
			l.insert(10, 0);
		});
	}

	/**
	 * Inserting into an invalid index in a non-empty list
	 */
	@Test
	void insertTest08() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.append(0);

		assertThrows(IndexOutOfBoundsException.class, () -> {
			l.insert(2, 0);
		});
		assertThrows(IndexOutOfBoundsException.class, () -> {
			l.insert(20, 0);
		});
	}

	/**
	 * Insert 1000 elements at the end. Guarantees a resize.
	 */
	@Test
	void insertTest09() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		Integer[] expected = new Integer[1000];
		for (int i = 0; i < 1000; i++) {
			l.insert(i, i);
			expected[i] = i;
		}

		assertArrayEquals(expected, l.toArray());
	}

	/**
	 * Insert 1000 elements at the beginning. Guarantees a resize.
	 */
	@Test
	void insertTest10() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		Integer[] expected = new Integer[1000];
		for (int i = 0; i < 1000; i++) {
			l.insert(0, i);
			expected[999 - i] = i;
		}

		assertArrayEquals(expected, l.toArray());
	}

	/**
	 * Insert 1000 elements at index 1 (after one element inserted). Guarantees a
	 * resize.
	 */
	@Test
	void insertTest11() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		Integer[] expected = new Integer[1000];
		l.append(999);
		expected[0] = 999;
		for (int i = 0; i < 999; i++) {
			l.insert(1, i);
			expected[999 - i] = i;
		}

		assertArrayEquals(expected, l.toArray());
	}
	
	/**
	 * Insert null values at end
	 */
	@Test
	void insertTest12() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.insert(0, null);
		l.insert(1, null);
		
		Integer[] expected = { null, null };
		
		assertArrayEquals(expected, l.toArray());
	}
	
	/**
	 * Insert null values at beginning
	 */
	@Test
	void insertTest13() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.insert(0, null);
		l.insert(0, null);
		
		Integer[] expected = { null, null };
		
		assertArrayEquals(expected, l.toArray());
	}
	
	/**
	 * Insert null values in middle
	 */
	@Test
	void insertTest14() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.insert(0, 0);
		l.insert(1, 2);
		l.insert(1, null);
		
		Integer[] expected = { 0, null, 2 };
		
		assertArrayEquals(expected, l.toArray());
	}

	/**
	 * Empty list
	 */
	@Test
	void isEmptyTest01() {
		DynamicList<Integer> l = new DynamicList<Integer>();

		assertTrue(l.isEmpty());
	}

	/**
	 * List with 1 element
	 */
	@Test
	void isEmptyTest02() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.append(0);

		assertFalse(l.isEmpty());
	}

	/**
	 * List with several elements
	 */
	@Test
	void isEmptyTest03() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		for (int i = 0; i < 5; i++)
			l.append(i);

		assertFalse(l.isEmpty());
	}

	/**
	 * If the list is empty, should return -1
	 */
	@Test
	void lastIndexOfTest01() {
		DynamicList<Integer> l = new DynamicList<Integer>();

		assertEquals(-1, l.lastIndexOf(0));
		assertEquals(-1, l.lastIndexOf(1));
		assertEquals(-1, l.lastIndexOf(-1));
	}

	/**
	 * If a list of length 1 does not contain the element, should return -1
	 */
	@Test
	void lastIndexOfTest02() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.append(0);

		assertEquals(-1, l.lastIndexOf(1));
	}

	/**
	 * If a list does not contain the element, should return -1
	 */
	@Test
	void lastIndexOfTest03() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.append(4);
		l.append(5);
		l.append(6);

		assertEquals(-1, l.lastIndexOf(0));
	}

	/**
	 * Test on a length 1 list with an instance of the element being searched for
	 */
	@Test
	void lastIndexOfTest04() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.append(4);

		assertEquals(0, l.lastIndexOf(4));
	}

	/**
	 * Test on a list that contains one of the given element
	 */
	@Test
	void lastIndexOfTest05() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.append(1);
		l.append(4);
		l.append(0);

		assertEquals(1, l.lastIndexOf(4));
	}

	/**
	 * Test on a list that contains several of the given element
	 */
	@Test
	void lastIndexOfTest06() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.append(1);
		l.append(4);
		l.append(0);
		l.append(4);
		l.append(4);
		l.append(5);

		assertEquals(4, l.lastIndexOf(4));
	}

	/**
	 * Test on a list that contains the given element only at the beginning
	 */
	@Test
	void lastIndexOfTest07() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.append(1);
		l.append(4);
		l.append(0);
		l.append(4);
		l.append(4);
		l.append(5);

		assertEquals(0, l.lastIndexOf(1));
	}

	/**
	 * Test on a list that contains the given element at the end
	 */
	@Test
	void lastIndexOfTest08() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.append(4);
		l.append(4);
		l.append(0);
		l.append(4);
		l.append(4);
		l.append(4);

		assertEquals(5, l.lastIndexOf(4));
	}
	
	/**
	 * String list
	 */
	@Test
	void lastIndexOfTest09() {
		DynamicList<String> l = new DynamicList<String>();
		l.append("a");
		l.append("b");
		l.append("c");

		assertEquals(0, l.lastIndexOf(new String("a")));
	}
	
	/**
	 * Null value in list, not searched for
	 */
	@Test
	void lastIndexOfTest10() {
		DynamicList<String> l = new DynamicList<String>();
		l.append(null);
		l.append("b");
		l.append("c");

		assertEquals(-1, l.lastIndexOf("a"));
	}
	
	/**
	 * Null value not in list, being searched for
	 */
	@Test
	void lastIndexOfTest11() {
		DynamicList<String> l = new DynamicList<String>();
		l.append("a");
		l.append("b");
		l.append("c");

		assertEquals(-1, l.lastIndexOf(null));
	}

	/**
	 * Null value in list, being searched for
	 */
	@Test
	void lastIndexOfTest12() {
		DynamicList<String> l = new DynamicList<String>();
		l.append("a");
		l.append(null);
		l.append("c");

		assertEquals(1, l.lastIndexOf(null));
	}

	/**
	 * Prepend a value in an empty list.
	 */
	@Test
	void prependTest01() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.prepend(1);

		assertEquals(1, l.size());
		assertEquals(1, l.get(0));
	}

	/**
	 * Prepend a value in to a list of length 1.
	 */
	@Test
	void prependTest02() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.prepend(1);
		l.prepend(2);

		assertEquals(2, l.size());
		assertEquals(2, l.get(0));
		assertEquals(1, l.get(1));
	}

	/**
	 * Prepend a value in to a list of length 2.
	 */
	@Test
	void prependTest03() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.prepend(1);
		l.prepend(2);
		l.prepend(3);

		assertEquals(3, l.size());
		assertEquals(3, l.get(0));
		assertEquals(2, l.get(1));
		assertEquals(1, l.get(2));
	}

	/**
	 * Prepend 1000 values. Guarantees a resize.
	 */
	@Test
	void prependTest04() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		Integer[] expected = new Integer[1000];
		for (int i = 0; i < 1000; i++) {
			l.prepend(i);
			expected[999 - i] = i;
		}

		assertArrayEquals(expected, l.toArray());
	}
	
	/**
	 * Prepend two null values
	 */
	@Test
	void prependTest05() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.prepend(null);
		l.prepend(2);
		l.prepend(null);
		
		Integer[] expected = { null, 2, null };

		assertArrayEquals(expected, l.toArray());
	}

	/**
	 * Remove from a list of length 1.
	 */
	@Test
	void removeTest01() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.append(1);
		l.remove(0);

		assertEquals(0, l.size());
	}

	/**
	 * Remove from the beginning of a list of length 2.
	 */
	@Test
	void removeTest02() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.append(1);
		l.append(2);
		l.remove(0);

		assertEquals(1, l.size());
		assertEquals(2, l.get(0));
	}

	/**
	 * Remove from the end of a list of length 2.
	 */
	@Test
	void removeTest03() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.append(0);
		l.append(1);
		l.remove(1);

		assertEquals(1, l.size());
		assertEquals(0, l.get(0));
	}

	/**
	 * Throws an exception when removing from an empty list. And size remains 0.
	 */
	@Test
	void removeTest04() {
		DynamicList<Integer> l = new DynamicList<Integer>();

		assertThrows(IndexOutOfBoundsException.class, () -> {
			l.remove(0);
		});
		assertEquals(0, l.size());
	}

	/**
	 * Throws an exception when removing from an invalid index in a non-empty list.
	 */
	@Test
	void removeTest05() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.append(0);

		assertThrows(IndexOutOfBoundsException.class, () -> {
			l.remove(1);
		});
		assertThrows(IndexOutOfBoundsException.class, () -> {
			l.remove(-1);
		});
	}

	/**
	 * Remove from the middle of a list of length 3.
	 */
	@Test
	void removeTest06() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.append(0);
		l.append(1);
		l.append(2);
		l.remove(1);

		assertEquals(2, l.size());
		assertEquals(0, l.get(0));
		assertEquals(2, l.get(1));
	}
	
	/**
	 * Remove with a null value
	 */
	@Test
	void removeTest07() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.append(0);
		l.append(1);
		l.append(null);
		l.remove(1);

		assertEquals(2, l.size());
		assertEquals(0, l.get(0));
		assertEquals(null, l.get(1));
	}

	/**
	 * Setting at an invalid index throws an exception.
	 */
	@Test
	void setTest01() {
		DynamicList<Integer> l = new DynamicList<Integer>();

		assertThrows(IndexOutOfBoundsException.class, () -> {
			l.set(0, 0);
		});
		assertThrows(IndexOutOfBoundsException.class, () -> {
			l.set(-1, 0);
		});
		assertThrows(IndexOutOfBoundsException.class, () -> {
			l.set(1, 0);
		});
	}

	/**
	 * Set index 0 of a one element list.
	 */
	@Test
	void setTest02() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.append(0);
		l.set(0, 1);

		assertEquals(1, l.get(0));
		assertEquals(1, l.size());
	}

	/**
	 * Set index several indexes of a large list.
	 */
	@Test
	void setTest03() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.append(0);
		l.append(1);
		l.append(2);
		l.append(3);
		l.append(4);
		l.append(5);
		l.set(0, 6);
		l.set(1, 7);
		l.set(2, 8);
		l.set(3, 9);
		l.set(4, 10);
		l.set(5, 11);

		Integer[] expected = { 6, 7, 8, 9, 10, 11 };
		assertArrayEquals(expected, l.toArray());
	}
	
	/**
	 * Set a value to null
	 */
	@Test
	void setTest04() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.append(0);
		l.set(0, null);

		assertEquals(1, l.size());
		assertEquals(null, l.get(0));
	}

	/**
	 * Size of empty list is 0
	 */
	@Test
	void sizeTest01() {
		DynamicList<Integer> l = new DynamicList<Integer>();

		assertEquals(0, l.size());
	}

	/**
	 * Length 1 list
	 */
	@Test
	void sizeTest02() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.append(0);

		assertEquals(1, l.size());
	}

	/**
	 * Length 0
	 */
	@Test
	void toArrayTest01() {
		DynamicList<Integer> l = new DynamicList<Integer>();

		Integer[] expected = {};
		assertArrayEquals(expected, l.toArray());
	}

	/**
	 * Length 1
	 */
	@Test
	void toArrayTest02() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.append(1);

		Integer[] expected = { 1 };
		assertArrayEquals(expected, l.toArray());
	}

	/**
	 * Length 5
	 */
	@Test
	void toArrayTest03() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.append(1);
		l.append(3);
		l.append(5);
		l.append(7);
		l.append(9);

		Integer[] expected = { 1, 3, 5, 7, 9 };
		assertArrayEquals(expected, l.toArray());
	}
	
	/**
	 * String list
	 */
	@Test
	void toArrayTest04() {
		DynamicList<String> l = new DynamicList<String>();
		l.append("a");
		l.append("b");
		l.append("c");

		String[] expected = { new String("a"), new String("b"), "c" };
		assertArrayEquals(expected, l.toArray());
	}
	
	/**
	 * With a null value
	 */
	@Test
	void toArrayTest05() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.append(1);
		l.append(3);
		l.append(null);
		l.append(7);
		l.append(9);

		Integer[] expected = { 1, 3, null, 7, 9 };
		assertArrayEquals(expected, l.toArray());
	}

	/**
	 * Empty list. No exceptions thrown.
	 */
	@Test
	void trimToSizeTest01() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.trimToSize();

		assertEquals(0, l.size());
	}

	/**
	 * Append after empty trimToSize. No exceptions.
	 */
	@Test
	void trimToSizeTest02() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.trimToSize();
		l.append(0);

		Integer[] expected = { 0 };
		assertArrayEquals(expected, l.toArray());
	}

	/**
	 * Length 1 trim. Nothing changed.
	 */
	@Test
	void trimToSizeTest03() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		l.append(0);
		l.trimToSize();

		Integer[] expected = { 0 };
		assertArrayEquals(expected, l.toArray());
	}

	/**
	 * Length 5 trim. Nothing changed.
	 */
	@Test
	void trimToSizeTest04() {
		DynamicList<Integer> l = new DynamicList<Integer>();
		for (int i = 0; i < 5; i++)
			l.append(i);
		l.trimToSize();

		Integer[] expected = { 0, 1, 2, 3, 4 };
		assertArrayEquals(expected, l.toArray());
	}

}
