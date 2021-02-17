package cs2400project1;

/**
 * A class of bags whose entries are stored in a chain of linked nodes.
 * The bag is never full.
 */

public class LinkedBag<T> implements BagInterface<T>
{
    private Node<T> firstNode;
    private int numberOfEntries;
    
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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BagInterface<T> intersection(BagInterface<T> bag1) 
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BagInterface<T> difference(BagInterface<T> bag1) 
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String toString()
    {
        
        return "";
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

    private class Node<T>
    {
        private T data; // entry in bag
        private Node<T> next; // link to next node

        private Node(T dataPortion)
        {
            this(dataPortion, null);
        }

        private Node(T dataPortion, Node<T> nextNode)
        {
            data = dataPortion;
            next = nextNode;
        }

        private T getData()
        {
            return data;
        }

        private void setData(T newData)
        {
            data = newData;
        }

        private Node<T> getNextNode()
        {
            return next;
        }

        private void setNextNode(Node<T> nextNode)
        {
            next = nextNode;
        }
    }
}
