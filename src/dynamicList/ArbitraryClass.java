package dynamicList;

/**
 * <p>
 * We make this class generic by adding <T> to the end of the class name. This
 * indicates that ArbitraryClass will be able to take in a type. T (which really
 * can have any name) will now represent a given type wherever its used in this
 * class.
 * </p>
 * <p>
 * This type (T) is also passed to SomeInterface, so SomeInterface knows that it
 * is using type T.
 * </p>
 * <p>
 * Like I said above, we could actually name T whatever we want. We could use
 * "Type" or "V" or "Triskaidekaphobia" in place of T, and Java would accept it.
 * You just have to use that same name everywhere you would have used the
 * specific, unknown type.
 * </p>
 */
public class ArbitraryClass<T> implements SomeInterface<T> {

	// You'll need a backing array of type T.

	/**
	 * Using T as the parameter type means that this method can take in an object of
	 * whatever type the user said this class should use. So, if this is an Integer
	 * type ArbitraryClass, then this method can take in an Integer (but nothing
	 * else). If this is a String type ArbitraryClass, this method can take in a
	 * String (and only String).
	 */
	public void foo(T e) {
		// ...
	}

	/**
	 * This method can take in any object that inherits from List and uses type T
	 * (effectively any object that inherits from List<T> where T is the given
	 * type).
	 */
	public void goo(SomeInterface<T> other) {
		// ...
	}

	/**
	 * This method returns an object of type T, whatever type that is. If this is an
	 * ArbitraryClass<String>, then it will return a String.
	 */
	public T hoo(int i) {
		// ...
		return null; //
	}

}
