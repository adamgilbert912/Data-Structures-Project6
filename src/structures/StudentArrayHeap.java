package structures;

import java.util.Comparator;
import java.util.Iterator;

public class StudentArrayHeap<P, V> extends AbstractArrayHeap<P, V> {
  // TODO: Implement all abstract methods from AbstractArrayHeap.

  public StudentArrayHeap(Comparator<P> comparator) {
    super(comparator);
  }

  public int getLeftChildOf(int index) {
    if (index < 0)
      throw new IndexOutOfBoundsException();

    return index*2 + 1;
  }

  public  int getRightChildOf(int index) {
    if (index < 0)
      throw new IndexOutOfBoundsException();

    return index*2 + 2;
  }

  public int getParentOf(int index) {
    if (index < 1)
      throw new IndexOutOfBoundsException();

    return (index - 1) / 2;
  }

  protected void bubbleUp(int index) {
    if (index < 0)
      throw new IndexOutOfBoundsException();

    Comparator<P> comparator = getComparator();

    while (index > 0) {
      int parentIndex = getParentOf(index);
      if (comparator.compare(heap.get(index).getPriority(), heap.get(parentIndex).getPriority()) > 0) {
        Entry<P,V> parentValues = heap.get(parentIndex);
        heap.set(parentIndex, heap.get(index));
        heap.set(index, parentValues);
        index = parentIndex;
      } else {
        return;
      }
    }
  }

  protected void bubbleDown(int index) {
    if (index < 0)
      throw new IndexOutOfBoundsException();

    Comparator<P> comparator = getComparator();

    int childIndex = getLeftChildOf(index);
    P priority = heap.get(index).getPriority();

    while (index < heap.size()) {
      int maxIndex = -1;
      P maxValue = priority;

      for (int i = 0; i < 2 && i + childIndex < heap.size(); i++) {
        if (comparator.compare(heap.get(childIndex + i).getPriority(), maxValue) > 0) {
          maxValue = heap.get(childIndex + i).getPriority();
          maxIndex = i + childIndex;
        }
      }

      if (maxValue == priority) {
        return;
      } else {
        Entry<P,V> entry = heap.get(maxIndex);
        heap.set(maxIndex, heap.get(index));
        heap.set(index, entry);

        index = maxIndex;
        childIndex = getLeftChildOf(index);

      }
    }

  }
}
