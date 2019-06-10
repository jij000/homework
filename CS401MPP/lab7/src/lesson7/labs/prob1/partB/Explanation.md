# The reason of wrong answer
Because the equals(Employee e) function in Employee Class did not override the base class Object's equals(Object e) function. 

So although the equals(Employee e) function work well in this part:

```java
	/** Returns true if e is in the list emps, false otherwise */
	private static boolean inList(Employee e, List<Employee> emps) {
		for(Employee emp : emps) {
			if(e.equals(emp)) return true;
		}
		return false;
	}
```

But when the code goto the following part, the contains(e) will use base class Object's equals(Object e) function to check if two Employee are equal, it will return false in this situation.

```java
	/**
	 * Returns true if the two lists have the same size and contain exactly the same
	 * elements (this is just set equality)
	 */
	public static boolean listsAreEqual(List<Employee> l1, List<Employee> l2) {
		if(l1.size() != l2.size()) return false;
		for(Employee e : l1) {
			if(!l2.contains(e)) return false;
		}
		return true;
	}
```
