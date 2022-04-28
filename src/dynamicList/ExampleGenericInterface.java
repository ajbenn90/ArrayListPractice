package dynamicList;

public interface ExampleGenericInterface<T> {
	
	public void foo(T e);
	
	public void goo(ExampleGenericInterface<T> other);
	
	public T hoo(int i);
	
}
