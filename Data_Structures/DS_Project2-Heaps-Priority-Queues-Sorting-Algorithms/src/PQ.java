import java.util.Comparator;

public class PQ implements PQInterface {
		
		private City[] heap;
		private int size;
		private Comparator<City> comparator;
		private static final int DEFAULT_CAPACITY = 999;
		private static final int AUTOGROW_SIZE = 2;
		private int[] positions;
		
		public PQ(Comparator<City> comparator) {
	        this.heap = new City[DEFAULT_CAPACITY + 1];
	        this.size = 0;
	        this.comparator = comparator;
	        
	        positions = new int[DEFAULT_CAPACITY + 1];
	        for (int i = 0; i <= DEFAULT_CAPACITY; i++) {
	            positions[i] = -1;
	        }
	    }
		
		public boolean isEmpty() {
			return size == 0;
		}
		
		public int size() {
			return size;
		}
		
		public void insert(City x) {
			
			if (size >= heap.length * 0.75 ) {
				resize();
			}
			
			heap[++size] = x;
			
			positions[x.getID()] = size;
			
			swim(size);
			
		}
		
		private void swim(int i) {
	        // if i is root (i==1) return
	        if (i == 1)
	            return;

	        // find parent
	        int parent = i / 2;

	        // compare parent with child i
	        while (i != 1 && comparator.compare(heap[i], heap[parent]) < 0) { // >
	            swap(i, parent);
	            i = parent;
	            parent = i / 2;
	        }
	        
	    }
		
		private void sink(int i) {
	        
	        int left = 2 * i;
	        int right = left + 1;

	        
	        if (left > size)
	            return;

	        
	        while (left <= size) {
	            
	            int max = left;
	            if (right <= size) {
	                if (comparator.compare(heap[left], heap[right]) > 0) // <
	                    max = right;
	            }
	            
	            if (comparator.compare(heap[i], heap[max]) <= 0) // >=
	                return;
	            else {
	                swap(i, max);
	                i = max;
	                left = i * 2;
	                right = left + 1;
	            }
	        }
	    }
		
		private void swap(int i, int j) {
	    	City tmp = heap[i];
	        heap[i] = heap[j];
	        heap[j] = tmp;
	        
	        positions[heap[i].getID()] = i;
	        positions[heap[j].getID()] = j;
	    }
		
		public City min() {
			return heap[1];
		}
		
		public City getmin() {
			City root = null;
			if (size == 0) {
				return root;
			}
			
			root = heap[1];
			swap(1, size--);
			
			positions[root.getID()] = -1; // Mark as removed
	        positions[heap[size + 1].getID()] = 1; // Update position of last element
			
			sink(1);
			
			return root;
		}
		
		public City remove(int id) {
			int index = positions[id];
	        City removed = heap[index];
	        swap(index, size--);
	        positions[removed.getID()] = -1; // Mark as removed
	        positions[heap[index].getID()] = index; // Update position of swapped element
	        swim(index);
	        sink(index);
	        return removed;
		}
		
		private void resize() {
			City[] newHeap = new City[heap.length * AUTOGROW_SIZE];
			
		    for (int i = 0; i <= size; i++) {
		    	newHeap[i] = heap[i];
		    }

		    heap = newHeap;
		}
		
}
