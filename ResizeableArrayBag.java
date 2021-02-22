package cs2400project1;

import java.util.Arrays;
import java.util.*;

/**
 * A resizeable bag implemented using arrays.
 */

public class ResizeableArrayBag<T> implements BagInterface<T>
{
    private T[] bag;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 25;
    private boolean integrityOK = false;
    private static final int MAX_CAPACITY = 10000;
    
    public ResizeableArrayBag()
    {
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[]) new Object[DEFAULT_CAPACITY];
        bag = tempBag;
    	numberOfEntries = 0;
        integrityOK = true;
    }

    /**
     * Creates an empty bag having a given capacity.
     * @param desiredCapacity The integer capacity desired.
     */
    public ResizeableArrayBag(int desiredCapacity)
    {
        if (desiredCapacity <= MAX_CAPACITY)
        {
            @SuppressWarnings("unchecked")
            T[] tempBag = (T[]) new Object[desiredCapacity];
            bag = tempBag;
            numberOfEntries = 0;
            integrityOK = true;
        }

        else
        {
            throw new IllegalStateException("Attempt to create a bag whose"
            + "capacity exceeds allowed maximum.");
        }
    }

    /**
     * Throws an exception if this object is not initialized. 
     */
    private void checkIntegrity()
    {
        if (!integrityOK)
        {
            throw new SecurityException("ResizeableArrayBag object is corrupt.");
        }
    }
    
    @Override
    public int getCurrentSize() 
    {
        return numberOfEntries;
    }

    public boolean isFull()
    {
        return numberOfEntries == bag.length;
    }
    
    @Override
    public boolean isEmpty() 
    {
        return numberOfEntries == 0;
    }

    @Override
    public boolean add(T newEntry) 
    {
        checkIntegrity();
        boolean result = true;
        if (isFull())
        {
            doubleCapacity();
        }

        bag[numberOfEntries] = newEntry;
        numberOfEntries++;
        
        return result;
    }

    /**
     * Removes and returns the entry at a given index within the array bag.
     * If no such entry exists, return null.
     * @param givenIndex The index of the entry to be removed.
     * @return The removed entry.
     */
    private T removeEntry(int givenIndex)
    {
        T result = null;

        if (!isEmpty() && (givenIndex >= 0))
        {
            result = bag[givenIndex]; // Entry to remove.
            bag[givenIndex] = bag[numberOfEntries - 1]; // Replaces entry with last entry.
            bag[numberOfEntries - 1] = null; // Remove last entry.
            numberOfEntries--;  
        }

        return result;
        
    }
    
    @Override
    public T remove() 
    {
        checkIntegrity();
        return removeEntry(numberOfEntries - 1);
    }

    @Override
    public boolean remove(T anEntry) 
    {
        checkIntegrity();
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);
        return anEntry.equals(result);
    }

    @Override
    public void clear() 
    {
        while (!isEmpty())
        {
            remove();
        }
    }

    @Override
    public int getFrequencyOf(T anEntry) 
    {
        checkIntegrity();
        int counter = 0;

        for (int index = 0; index < numberOfEntries; index++)
        {
            if (anEntry.equals(bag[index]))
            {
                counter++;
            }
        }

        return counter;
    }

    /**
     * Locates a given entry within the array bag.
     * @param anEntry THe entry to be found.
     * @return The index of the entry, or -1 if entry is not present in the bag.
     */
    private int getIndexOf(T anEntry)
    {
        int where = -1;
        boolean found = false;
        int index = 0;

        while(!found && (index < numberOfEntries))
        {
            
            if (anEntry.equals(bag[index]))
            {
                found = true;
                where = index;
            }
            
            index++;

        }
       
        return where;

    }
    
    @Override
    public boolean contains(T anEntry) 
    {
        checkIntegrity();
        return getIndexOf(anEntry) > -1;
    }

    @Override
    public T[] toArray() 
    {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
        
        for (int index = 0; index < numberOfEntries; index++)
        {
            result[index] = bag[index];
        }

        return result;
    }

    @Override
    public BagInterface<T> union(BagInterface<T> bag1) 
    {
        // bag containing all elements of bag1 and bag2
    	BagInterface<T> unionBag = new ResizeableArrayBag<>();
    	
    	// the referenced bag when the union method is called 
    	// in array form
    	T[] referenceBag = this.toArray();
        
        // add contents of the reference bag
    	// to the unionbag
    	for (T entry: referenceBag)
        {
        	unionBag.add(entry);
        }
        
        // the bag from the parameter in array form
        T[] parameterBag = bag1.toArray();
        
        // adds contents of the parameter bag
        // to the union bag
        for (T entry: parameterBag)
        {
        	unionBag.add(entry);
        }
        
        return unionBag; 
    }

    @Override
    public BagInterface<T> intersection(BagInterface<T> bag1) 
    {
    	
    	
        return this;
    }

    @Override
    public BagInterface<T> difference(BagInterface<T> bag1) 
    {
        
    	
    	return this;
    }

    /**
     * Checks capacity of the bag to make sure it is larger than the array should be.
     * @param capacity The capacity to be checked.
     */
    private void checkCapacity(int capacity)
    {
        if (capacity > MAX_CAPACITY)
        {
            throw new IllegalStateException("Attempt to create a bag whose " +
                                        "capacity exceeds allowed " +
                                        "maximum of " + MAX_CAPACITY);
        }
    }
    
    /**
     * Doubles the capacity of the resizeable array bag.
     * Checks to see if the new capacity will be larger than 
     * the max capacity using checkCapacity.
     */
    private void doubleCapacity()
    {
        int newLength = 2 * bag.length;
        checkCapacity(newLength);
        bag = Arrays.copyOf(bag, newLength);
    }
}
