// James Burke: 
package postgrad.oop2.code1;

public class MyGenericType<T>{
	private T t;
	
	public void add(T t) {
		this.t = t;
	}
	
	public T get() {
		return this.t;
	}
}