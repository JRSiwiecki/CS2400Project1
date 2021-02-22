package cs2400project1;

/**
 * A class of bags whose entries are stored in a chain of linked nodes.
 * The bag is never full.
 */

public class LinkedBag<T> implements BagInterface<T>
{
    /**
     * @InstanceField firstNode The first node of the linked bag.
     * @InstanceField numberOfEntries The number of entries in the linked bag.
     */
	private Node<T> firstNode;
    private int numberOfEntries;
    
    /**
     * Creates an empty linked list bag.
     */
    public LinkedBag()
    {
        firstNode = null;
        numberOfEntries = 0;
    }
    
    @Override
    public int getCurrentSize() 
    {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() 
    {
        return numberOfEntries == 0;
    }

    @Override
    public boolean add(T newEntry) // OutOfMemoryError possible
    {
        // Add to the beginning of the chain:
        Node<T> newNode = new Node<T>(newEntry); 
        newNode.next = firstNode; // Make new node reference rest of chain
                                  // (firstNode is null if chain is empty)
        
        firstNode = newNode; // New node is at beginning of chain
        numberOfEntries++;

        return true;
    }

    @Override
    public T remove() 
    {
        T result = null;

        if (firstNode != null)
        {
            result = (T) firstNode.getData();
            firstNode = firstNode.getNextNode(); //Remove first node from chain
            numberOfEntries--;
        }

        return result;
        
    }

    @Override
    public boolean remove(T anEntry) 
    {
        boolean result = false;
        Node<T> nodeN = getReferenceTo(anEntry);

        if (nodeN != null)
        {
            // Replace located entry with entry in the first node.
            nodeN.setData(firstNode.getData());
            // Remove first node
            firstNode = firstNode.getNextNode();

            numberOfEntries--;

            result = true;
        }

        return result;

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
        int frequency = 0;

        int counter = 0;
        Node<T> currentNode = firstNode;
        while ((counter < numberOfEntries) && (currentNode != null))
        {
            if (anEntry.equals(currentNode.getData()))
            {
                frequency++;
            }

            counter++;
            currentNode = currentNode.getNextNode();
        }

        return frequency;

    }

    @Override
    public boolean contains(T anEntry) 
    {
        boolean found = false;
        Node<T> currentNode = firstNode;

        while (!found && (currentNode != null))
        {
            if (anEntry.equals(currentNode.getData()))
            {
                found = true;
            }

            else
            {
                currentNode = currentNode.getNextNode();
            }
        }

        return found;

    }

    @Override
    public T[] toArray() 
    {
        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries]; // Unchecked cast

        int index = 0;
        Node<T> currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null))
        {
            result[index] = (T) currentNode.getData();
            index++;
            currentNode = currentNode.getNextNode();
        }

        return result;

    }

    @Override
    public BagInterface<T> union(BagInterface<T> bag1) 
    {
        // If either bag is empty, return the other bag since
    	// the only elements, if there are any, are in the other bag.
    	if (this.isEmpty())
        {
        	return bag1;
        }
        
        else if (bag1.isEmpty())
        {
        	return this;
        }
    	
    	// The bag containing all elements of both bags.
    	BagInterface<T> unionBag = new LinkedBag<>();
        
        // The first bag.
    	T[] parameterBag = bag1.toArray();
        
        // Adds elements of the first bag to the union bag.
    	for (T entry: parameterBag)
        {
        	unionBag.add(entry);
        }
        
        // The second bag.
    	T[] referenceBag = this.toArray();
        
        // Adds entries of the second bag to the union bag.
    	for (T entry: referenceBag)
        {
        	unionBag.add(entry);
        }
        
        return unionBag;
    }

    @Override
    public BagInterface<T> intersection(BagInterface<T> bag1) 
    {
    	// If either bag is empty, then there can be no overlap of elements, and so
    	// the resulting bag of intersection is empty.
    	if (this.isEmpty() || bag1.isEmpty())
    	{
    		BagInterface<T> emptyBag = new LinkedBag<>();
    		return emptyBag;
    	}
    	
    	// Bag to compare to when checking if an entry is in both bags.
    	BagInterface<T> tempBag = new LinkedBag<>();
    	
    	// Final bag to be added and returned.
    	BagInterface<T> intersectionBag = new LinkedBag<>();
    	
    	// Bag that the method was called on.
    	T[] referenceBag = this.toArray();
    	
    	// Adding entries from the referenceBag
    	// to the tempBag.
    	for (T entry: referenceBag)
    	{
    		tempBag.add(entry);
    	}
    	
    	// The parameter bag to an array.
    	T[] parameterBag = bag1.toArray();
    	
    	// Goes through each entry in the parameter bag 
    	// and checks if it is in the temp bag from the reference
    	// bag. If so, then that means it is in both bags
    	// and will be added to the intersection bag.
    	for (T entry: parameterBag)
    	{
    		if (tempBag.contains(entry))
    		{
    			intersectionBag.add(entry);
    		}
    	}
    	
        return intersectionBag;
    }

    @Override
    public BagInterface<T> difference(BagInterface<T> bag1) 
    {
    	// Subtracting a bag with elements from an empty bag 
    	// just results in an empty bag.
    	if (this.isEmpty() && !(bag1.isEmpty()))
    	{
    		BagInterface<T> emptyBag = new LinkedBag<>();
    		return emptyBag;
    	}
    	
    	// If the parameter bag is empty and the reference bag is not, 
    	// then the difference is what is in the parameter bag.
    	else if (bag1.isEmpty() && !(this.isEmpty()))
    	{
    		return this;
    	}
    	
    	// Bag that will contain the difference of bag1 from bag2.
    	BagInterface<T> differenceBag = new LinkedBag<>();
        
        // The reference bag this method was called on to an array.
    	T[] referenceBag = this.toArray();
        
        // Adds the entries of the reference bag to the difference bag.
    	for (T entry: referenceBag)
        {
        	differenceBag.add(entry);
        }
        
        // Bag from the parameter to an array.
    	T[] parameterBag = bag1.toArray();
        
        // Removes an entry from difference bag 
    	// if that entry occurs in the parameter bag.
    	for (T entry: parameterBag)
        {
        	if (differenceBag.contains(entry))
        	{
        		differenceBag.remove(entry);
        	}
        }
    	
    	return differenceBag;
    }

    /**
     * Locates a given entry within this bag.
     * @param anEntry The entry to be located.
     * @return The reference to the node containing the entry or null.
     */
    private Node<T> getReferenceTo(T anEntry)
    {
        boolean found = false;
        Node<T> currentNode = firstNode;

        while (!found && (currentNode != null))
        {
            if (anEntry.equals(currentNode.getData()))
            {
                found = true;
            }

            else
            {
                currentNode = currentNode.getNextNode();
            }
        }

        return currentNode;

    }

    /**
     * Nodes representing entries in the linked bag.
     * @param <T> The entry datatype.
     */
    @SuppressWarnings("hiding")
	private class Node<T>
    {
        /**
         * @InstanceField data The entry itself.
         * @InstanceField next The entry next to the current node.
         */
    	private T data; 
        private Node<T> next; 

        /**
         * Creates a node of data at the front of the list.
         * @param dataPortion The entry.
         */
        private Node(T dataPortion)
        {
            this(dataPortion, null);
        }

        /**
         * Creates a node at a given position
         * @param dataPortion The entry.
         * @param nextNode The given position.
         */
        private Node(T dataPortion, Node<T> nextNode)
        {
            data = dataPortion;
            next = nextNode;
        }

        /**
         * Getter function to get the entry.
         * @return The entry.
         */
        private T getData()
        {
            return data;
        }

        /**
         * Setter function to set the entry.
         * @param newData The entry.
         */
        private void setData(T newData)
        {
            data = newData;
        }

        /**
         * Gets the next node.
         * @return The node.
         */
        private Node<T> getNextNode()
        {
            return next;
        }

        /**
         * Sets the next node.
         * @param nextNode The next node.
         */
        @SuppressWarnings("unused")
		private void setNextNode(Node<T> nextNode)
        {
            next = nextNode;
        }
    }
}
