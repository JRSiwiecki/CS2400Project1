package cs2400project1;

/** An interface that describes the operations of a bag of objects. */
public interface BagInterface<T>
{
	/** 
	 * Gets the current number of entries in this bag.
	 * @return The integer number of entries currently in the bag.
	 */
	public int getCurrentSize();
	
	/** 
	 * Sees whether the bag is empty
	 * @return True if the bag is empty, or falise if not.
	 */
	public boolean isEmpty();

    /** 
    * Adds a new entry to the bag.
    * @param newEntry The object to be added as a new entry.
    * @return True if the addition is successful, or false if not.
    */
    public boolean add(T newEntry);

    /** 
    * Removes one unspecified entry from this bag, if possible.
    * @return Either the removed entry, if the removal was successful, or null.
    */
    public T remove();

    /** 
    * Removes one occurrence of a given entry from this bag, if possible.
    * @param anEntry The entry to be removed.
    * @return True if the removal was successful, false if not.
    */
    public boolean remove(T anEntry);
    
    /** 
    * Removes all entries from this bag.
    */ 
    public void clear();

    /**
     * Counts the number of times a given entry appears in this bag.
     * @param anEntry The entry to be counted.
     * @return The number of times anEntry appears in the bag.
     */
    public int getFrequencyOf(T anEntry);
    
    /**
     * Tests whether this bag contains a given entry.
     * @param anEntry The entry to find.
     * @return True if the bag contains anEntry, or false if not.
     */
    public boolean contains(T anEntry);

    /**
     * Retrieves all entry that are in this bag.
     * @return A newly allocated array of all the entries in the bag. 
     * Note: If the bag is empty, the returned array is empty.
     */
    public T[] toArray();

    /**
     * The union of two bags, combines all elements together into one new bag.
     * @param bag1 The bag to combined with.
     * @return The new bag containing all items of bag1 and bag2.
     * Note: May contain duplicates.
     */
    public BagInterface<T> union(BagInterface<T> bag1);

    /**
     * Takes the entries in bag1 and bag2 and makes a new bag containing only those entries 
     * present in both bags.
     * @param bag1 The bag to be intersected with.
     * @return The new bag after interesection. 
     * Note: May contain duplicates. 
     */
    public BagInterface<T> intersection(BagInterface<T> bag1);

    /**
     * Compares the entries in bag1 to bag2 and creates a new bag that only contains the unique
     * entries of bag1.
     * @param bag1 The bag to take the difference of.
     * @return The new bag after removing the difference.
     * Note: May contain duplicates.
     */
    public BagInterface<T> difference(BagInterface<T> bag1);
}
