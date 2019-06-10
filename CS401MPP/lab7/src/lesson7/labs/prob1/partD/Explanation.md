# The reason of wrong answer
Because the following code:

```java
	/**
	 * Removes all duplicate Employee instances from input list (only a copy is modified)
	 * An Employee instance is considered to be a duplicate of another Employee
	 * instance if the two instances have the same name and salary.
	 */
	public static List<Employee> removeDuplicates(List<Employee> employees) {
		HashMap<Employee, Employee> tracker = new HashMap<>();
		List<Employee> noDupsList = new ArrayList<>();
		for(int i = 0; i < employees.size(); ++i) {
			Employee e = employees.get(i);
			if(!tracker.containsKey(e)) {
				tracker.put(e, e);
				noDupsList.add(e);
			} else {
				tracker.get(e).setVisited(true);
			}
		}
		return noDupsList;
	}
```

the code  

```java
tracker.get(e).setVisited(true);
```

is not necessary and must be removed, Because it change the key of HashMap and cause unexpected outcome, we should make sure the key of HashMap is immutable.