package dynamicList;

/**
 * Pretty much just ArrayList but worse.
 * 
 * @author alex
 *
 */
public class IntDynamicList implements IntList {

	private int[] data;
	private int size;

	public IntDynamicList() {
		this.data = new int[10];
		this.size = 0;
	}

	@Override
	public void append(int value) {
		insert(size, value);
	}

	@Override
	public void appendAll(IntList vals) {
		for (int i = 0; i < vals.size(); i++)
			this.insert(size, vals.get(i));
	}

	@Override
	public void clear() {
		size = 0;
	}

	@Override
	public boolean contains(int val) {
		return indexOf(val) != -1;
	}

	@Override
	public boolean equals(IntList other) {
		if (other == null)
			return false;

		if (this.size != other.size())
			return false;

		for (int i = 0; i < size; i++)
			if (data[i] != other.get(i))
				return false;

		return true;
	}

	@Override
	public int get(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();

		return data[index];
	}

	@Override
	public int indexOf(int val) {
		for (int i = 0; i < size; i++)
			if (data[i] == val)
				return i;

		return -1;
	}

	@Override
	public void insert(int index, int val) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();

		if (size == data.length)
			// Special case
			if (data.length == 0)
				changeBackingArray(8);
			else
				changeBackingArray(size * 2);

		size++;
		shiftDataRight(index);
		data[index] = val;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int lastIndexOf(int val) {
		for (int i = size - 1; i >= 0; i--)
			if (data[i] == val)
				return i;

		return -1;
	}

	@Override
	public void prepend(int value) {
		insert(0, value);
	}

	@Override
	public int remove(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();

		int oldVal = data[index];

		size--;
		shiftDataLeft(index + 1);

		return oldVal;
	}

	@Override
	public int set(int index, int val) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();

		int oldVal = data[index];

		data[index] = val;

		return oldVal;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int[] toArray() {
		int[] arr = new int[size];

		for (int i = 0; i < size; i++)
			arr[i] = data[i];

		return arr;
	}

	@Override
	public void trimToSize() {
		changeBackingArray(size);
	}

	/**
	 * Changes the backing array to a new array with the given size. All data from
	 * the old array is copied to the new array in order.
	 * 
	 * @param newSize
	 */
	private void changeBackingArray(int newSize) {
		int[] newData = new int[newSize];

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
