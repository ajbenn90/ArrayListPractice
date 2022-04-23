package dynamicList;

/**
 * Defines the methods that a dynamic list of integers must implement.
 * 
 * @author alex
 *
 */
public interface IntList {

	/**
	 * Appends the given value to the end of this list.
	 * 
	 * @param value
	 */
	public void append(int value);

	/**
	 * Appends all of the values in the given list to this list.
	 * 
	 * @param vals
	 */
	public void appendAll(IntList vals);

	/**
	 * Removes all elements from this list.
	 */
	public void clear();

	/**
	 * Checks if the given value is in this list.
	 * 
	 * @param val
	 * @return True if the value is in the list. False otherwise.
	 */
	public boolean contains(int val);

	/**
	 * Checks if the given list is the same as this list, i.e. has the same values
	 * in the same order. If <i>other</i> is null, return false instead of throwing an
	 * exception.
	 * 
	 * @param other
	 * @return
	 */
	public boolean equals(IntList other);

	/**
	 * Returns the value stored at the given index.
	 * 
	 * @param index
	 * @return
	 * @throws IndexOutOfBoundsException if the given index is not between 0 and
	 *                                   (size - 1) inclusive.
	 */
	public int get(int index);

	/**
	 * Returns the index of the <i>first</i> occurrence of the given value or -1 if
	 * the list does not contain the value.
	 * 
	 * @param val
	 * @return
	 */
	public int indexOf(int val);

	/**
	 * <p>
	 * Inserts the value at the given index. All values after this index (including
	 * the value originally at this index) are shifted one to the right. The value
	 * may be inserted at the very end of the list (at index "size").
	 * </p>
	 * <p>
	 * e.g. If a = [0, 1, 3, 4], a.insert(2, 2) would make it [0, 1, 2, 3, 4].
	 * a.insert(5, 5) would make it [0, 1, 2, 3, 4, 5].
	 * </p>
	 * 
	 * @param index
	 * @param val
	 * @throws IndexOutOfBoundsException if the given index is not between 0 and
	 *                                   size inclusive.
	 */
	public void insert(int index, int val);

	/**
	 * Returns true if the list is empty. False otherwise.
	 * 
	 * @return
	 */
	public boolean isEmpty();

	/**
	 * Returns the index of the <i>last</i> occurrence of the given value or -1 if
	 * the list does not contain the value.
	 * 
	 * @param val
	 * @return
	 */
	public int lastIndexOf(int val);

	/**
	 * Inserts the given value at the beginning of the list (index 0).
	 * 
	 * @param val
	 */
	public void prepend(int val);

	/**
	 * <p>
	 * Removes the value at the given index, shifting all subsequent values one to
	 * the left.
	 * </p>
	 * <p>
	 * e.g. If a = [0, 1, 2, 3], a.remove(2) would make a = [0, 1, 3] and return 2.
	 * </p>
	 * 
	 * @param index
	 * @return
	 * @throws IndexOutOfBoundsException if the given index is not between 0 and
	 *                                   (size - 1) inclusive.
	 */
	public int remove(int index);

	/**
	 * Changes the value at the given index to the given value. Returns the value
	 * previously stored there.
	 * 
	 * @param index
	 * @param val
	 * @return The original value at the index.
	 * @throws IndexOutOfBoundsException if the given index is not between 0 and
	 *                                   (size - 1) inclusive.
	 */
	public int set(int index, int val);

	/**
	 * Returns the size of the list.
	 * 
	 * @return
	 */
	public int size();

	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence (from first to last element).
	 * 
	 * @return
	 */
	public int[] toArray();

	/**
	 * Trims the capacity of the backing array to match the list's current size.
	 */
	public void trimToSize();

}
