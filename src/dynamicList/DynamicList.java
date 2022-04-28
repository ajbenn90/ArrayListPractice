package dynamicList;

public class DynamicList<T> implements List<T> {

	private T[] data;
	private int size;

	@SuppressWarnings("unchecked")
	public DynamicList() {
		this.data = (T[]) new Object[10];
		this.size = 0;
	}

	@Override
	public void append(T e) {
		insert(size, e);
	}

	@Override
	public void appendAll(List<T> list) {
		for (int i = 0; i < list.size(); i++)
			insert(size, list.get(i));
	}

	@Override
	public void clear() {
		size = 0;
	}

	@Override
	public boolean contains(T e) {
		return indexOf(e) != -1;
	}

	@Override
	public boolean equals(List<T> other) {
		if (other == null)
			return false;

		if (this.size != other.size())
			return false;

		for (int i = 0; i < size; i++)
			if (!areEqual(data[i], other.get(i)))
				return false;

		return true;
	}

	@Override
	public T get(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();

		return data[index];
	}

	@Override
	public int indexOf(T e) {
		for (int i = 0; i < size; i++)
			if (areEqual(data[i], e))
				return i;
		
		return -1;
	}

	@Override
	public void insert(int index, T e) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();

		if (size == data.length)
			if (data.length != 0)
				changeBackingArray(size * 2);
			else // Special case
				changeBackingArray(10);

		size++;
		shiftDataRight(index);
		data[index] = e;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int lastIndexOf(T e) {
		for (int i = size - 1; i >= 0; i--)
			if (areEqual(data[i], e))
				return i;
		
		return -1;
	}

	@Override
	public void prepend(T e) {
		insert(0, e);
	}

	@Override
	public T remove(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();

		T oldVal = data[index];

		size--;
		shiftDataLeft(index + 1);

		return oldVal;
	}

	@Override
	public T set(int index, T e) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();

		T oldVal = data[index];

		data[index] = e;

		return oldVal;
	}

	@Override
	public int size() {
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {
		T[] arr = (T[]) new Object[size];

		for (int i = 0; i < size; i++)
			arr[i] = data[i];

		return arr;
	}

	@Override
	public void trimToSize() {
		changeBackingArray(size);
	}

	/**
	 * Checks if two elements are equal, treating null values as equal.
	 * 
	 * @param e1
	 * @param e2
	 * @return
	 */
	private boolean areEqual(T e1, T e2) {
		if (e1 == null)
			return e2 == null;
		return e1.equals(e2);
	}
	
	/**
	 * Changes the backing array to a new array with the given size. All data from
	 * the old array is copied to the new array in order.
	 * 
	 * @param newSize
	 */
	@SuppressWarnings("unchecked")
	private void changeBackingArray(int newSize) {
		T[] newData = (T[]) new Object[newSize];

		for (int i = 0; i < size; i++)
			newData[i] = data[i];

		data = newData;
	}

	/**
	 * Shifts data in the backing array one to the right, including the value at
	 * startIndex. Assumes size has already been incremented.
	 * 
	 * @param startIndex Where to start shifting
	 */
	private void shiftDataRight(int startIndex) {
		for (int i = size - 1; i > startIndex; i--)
			data[i] = data[i - 1];
	}

	/**
	 * Shifts data in the backing array one to the left, including the value at
	 * startIndex and the value at index size. startIndex should never be 0. The
	 * data to the left of startIndex will be lost. Assumes size has already been
	 * decremented.
	 * 
	 * @param startIndex Where to start shifting
	 */
	private void shiftDataLeft(int startIndex) {
		for (int i = startIndex; i <= size; i++)
			data[i - 1] = data[i];
	}

}
