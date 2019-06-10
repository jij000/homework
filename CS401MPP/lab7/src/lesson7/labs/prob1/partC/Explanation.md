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
			}
		}
		return noDupsList;
	}
```

It used HashMap tracker to remove Duplicates, and use Employee as the key, but Employee class did not override the hashCode() function, so the "!tracker.containsKey(e)" did not work as expected, as a result, it can not remove Duplicates.