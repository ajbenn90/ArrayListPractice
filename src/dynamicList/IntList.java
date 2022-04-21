package dynamicList;

/**
 * Defines the methods that a dynamic list of integers must implement.
 * 
 * @author alex
 *
 */
public interface IntList {

	/**
	 * Appends the given value to the end of the list.
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
	 * Removes all elemnts from this list.
	 */
	public void clear();

	/**
	 * Checks if the given value is in the list.
	 * 
	 * @param val
	 * @return True if the value is in the list. False otherwise.
	 */
	public boolean contains(int val);

	/**
	 * Checks if the given list is the same as this list, i.e. has the same values
	 * in the same order. If "other" is null, return false.
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
	 * Returns the index of the first occurrence of the given value or -1 if the
	 * list does not contain the value.
	 * 
	 * @param val
	 * @return
	 */
	public int indexOf(int val);

	/**
	 * Inserts the value at the given index. All values after this index (including
	 * the value originally at this index) are shifted one to the right. The value
	 * may inserted at the very end of the list.
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
	 * Returns the index of the last occurrence of the given value or -1 if the list
	 * does not contain the value.
	 * 
	 * @param val
	 * @return
	 */
	public int lastIndexOf(int val);

	/**
	 * Inserts the given value at the beginning of the list.
	 * 
	 * @param value
	 */
	public void prepend(int value);

	/**
	 * Removes the value at the given index, shifting all subsequent values one to
	 * the left.
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
