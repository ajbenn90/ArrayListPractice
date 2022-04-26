package dynamicList;

public interface SomeInterface<T> {
	
	public void foo(T e);
	
	public void goo(SomeInterface<T> other);
	
	public T hoo(int i);
	
}
