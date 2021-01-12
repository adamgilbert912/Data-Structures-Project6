package structures;

import comparators.IntegerComparator;
//import sun.jvm.hotspot.memory.HeapBlock;

import java.util.Comparator;
import java.util.Iterator;

public class MaxQueue<V> implements PriorityQueue<Integer, V> {
  // TODO: Implement all abstract methods from PriorityQueue.
  IntegerComparator comparator = new IntegerComparator();
  StudentArrayHeap<Integer,V> heapQueue = new StudentArrayHeap<>(comparator);

  public PriorityQueue<Integer, V> enqueue(Integer priority, V value) {
      
    heapQueue.add(priority, value);

    return this;
  }

  public V dequeue() {
    V value = heapQueue.remove();

    return value;
  }

  public V peek() {

   return heapQueue.peek();
  }

  public Iterator<Entry<Integer, V>> iterator() {
    return heapQueue.heap.iterator();
  }

  public Comparator<Integer> getComparator() {
    return comparator;
  }

  public int size() {
    return heapQueue.size();
  }
  
  public boolean isEmpty() {
    return heapQueue.isEmpty();
  }
}
