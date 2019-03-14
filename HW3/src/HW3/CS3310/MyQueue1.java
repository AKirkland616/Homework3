package HW3.CS3310;

/**
 * @author Anthony Kirkland
 *
 * @param <E> java generic used to pass any data type
 */
public class MyQueue1<E> {
	private Node<E> front;
	private Node<E> rear;
	//Node e = new Node();
	
	
	/**Determines if queue is empty.
	 * @return true or false depending on if the queue has value in it.
	 */
	public boolean isEmpty() {
			return (front == null);
		}
		
	/**Adds data value into queue. inserted into the rear.
	 * @param data data value to be added to the queue.
	 */
	public void enqueue(E data) {
		Node n = new Node(data);
		if(isEmpty()) {
			front = n;
			rear =front;
		}else {
			Node headcopy = front;
			if (size() == 0) {
				Node newNode = new Node(n.getData(), front);
				front = newNode;
			}else {
				Node ref = front;
				for(int i = 0; i < size()-1; i++) {
					ref = ref.getNext();
				}
				Node successor = ref.getNext();
				ref.setNext(n);
				n.setNext(successor);
				if(n.getNext() == null) {
					rear = n;
				}
			}
		}
	
	}
	
	/**dequeues data value. this is in a first in first out manner.
	 * @return node from the front of the queue
	 */
	public E dequeue() {
		E ret;
		if(!isEmpty()) {
			ret = front.getData();
			if(size() > 1) {
				front=front.getNext();
			}else if(size()==1) {
				front = null;
				rear = front;
			}
		}else {
			ret = null;
			System.out.println("Queue is empty. There is nothing to dequeue.");
		}
		return ret;
	}
	
	/**Gets size of queue. The amount of elements/nodes in queue.
	 * @return integer value of size of queue. number or elements in queue.
	 */
	public int size() {
		Node headcopy = front;
		int size = 0;
		while(headcopy != null) {
			headcopy = headcopy.getNext();
			size++;
		}
		return size;
	}
	


}
