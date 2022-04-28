package dynamicList;

/**
 * Defines the methods that a generic, dynamic list must implement.
 * 
 * @author alex
 *
 * @param <T> The type of objects stored in this list.
 */
public interface List<T> {

	/**
	 * Appends the given element to the end of the list.
	 * 
	 * @param e
	 */
	public void append(T e);

	/**
	 * Appends all of the values in the given list to this list.
	 * 
	 * @param list
	 */
	public void appendAll(List<T> list);

	/**
	 * Removes all elements from this list.
	 */
	public void clear();

	/**
	 * Checks if the given element is in this list.
	 * 
	 * @param e
	 * @return True if the element is in this list. False otherwise.
	 */
	public boolean contains(T e);

	/**
	 * Checks if the given list is the same as this list, i.e. has the same values
	 * in the same order. If other is null, return false. However, both arrays may
	 * contain null values. Null values are considered equal.
	 * 
	 * @param other
	 * @return
	 */
	public boolean equals(List<T> other);

	/**
	 * Returns the element stored at the given index.
	 * 
	 * @param index
	 * @return
	 * @throws IndexOutOfBoundsException if the given index is not between 0 and
	 *                                   (size - 1) inclusive.
	 */
	public T get(int index);

	/**
	 * Returns the index of the first occurrence of the given element or -1 if the
	 * list does not contain the element. The element can be null.
	 * 
	 * @param e
	 * @return
	 */
	public int indexOf(T e);

	/**
	 * Inserts the element at the given index. All elements after this index
	 * (including the element originally at this index) are shifted one to the
	 * right. The element may inserted at the very end of the list.
	 * 
	 * @param index
	 * @param val
	 * @throws IndexOutOfBoundsException if the given index is not between 0 and
	 *                                   size inclusive.
	 */
	public void insert(int index, T e);

	/**
	 * Returns true if this list is empty. False otherwise.
	 * 
	 * @return
	 */
	public boolean isEmpty();

	/**
	 * Returns the index of the last occurrence of the given element or -1 if this
	 * list does not contain the element.
	 * 
	 * @param e
	 * @return
	 */
	public int lastIndexOf(T e);

	/**
	 * Inserts the given element at the beginning of this list.
	 * 
	 * @param e
	 */
	public void prepend(T e);

	/**
	 * Removes the element at the given index, shifting all subsequent elements one
	 * to the left.
	 * 
	 * @param index
	 * @return
	 * @throws IndexOutOfBoundsException if the given index is not between 0 and
	 *                                   (size - 1) inclusive.
	 */
	public T remove(int index);

	/**
	 * Changes the element at the given index to the given element. Returns the
	 * element previously stored there.
	 * 
	 * @param index
	 * @param e
	 * @return The original element at the index.
	 * @throws IndexOutOfBoundsException if the given index is not between 0 and
	 *                                   (size - 1) inclusive.
	 */
	public T set(int index, T e);

	/**
	 * Returns the size of this list.
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
	public T[] toArray();

	/**
	 * Trims the capacity of the backing array to match this list's current size.
	 */
	public void trimToSize();

}
