/**
 * 
 */
package com.pram;

/**
 * @author PraveenPatel 15-Jul-2019
 */
public class ImmutableQueue<T> implements Queue<T> {

	private class ImmutableStack {
		private final T head;
		private final ImmutableStack tail;

		public ImmutableStack() {
			this.head = null;
			this.tail = null;
		}

		private ImmutableStack(T head, ImmutableStack tail) {
			this.head = head;
			this.tail = tail;
		}

		public ImmutableStack push(T t) {
			return new ImmutableStack(t, this);
		}

		public ImmutableStack pop() {
			return this.tail;
		}

		public T peek() {
			return this.head;
		}

		public boolean isEmpty() {
			return this.head == null && this.tail == null;
		}

		public ImmutableStack reverse() {
			ImmutableStack result = new ImmutableStack();
			ImmutableStack tmp = this;
			while (!tmp.isEmpty()) {
				result = result.push(tmp.peek());
				tmp = tmp.pop();
			}
			return result;
		}
	}

	private final ImmutableStack front; // stack to remove elements from
	private final ImmutableStack rear; // stack to add elements to

	public ImmutableQueue() { // empty queue using two empty stacks
		this.front = new ImmutableStack();
		this.rear = new ImmutableStack();
	}

	private ImmutableQueue(ImmutableStack front, ImmutableStack back) {
		this.front = front;
		this.rear = back;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pram.Queue#enQueue(java.lang.Object)
	 */
	@Override
	public Queue<T> enQueue(T t) {
		// TODO Auto-generated method stub
		if (this.front.isEmpty()) { 
			return new ImmutableQueue<T>(this.rear.reverse().push(t), new ImmutableStack());
		}
		return new ImmutableQueue<T>(this.front, this.rear.push(t));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pram.Queue#deQueue()
	 */
	@Override
	public Queue<T> deQueue() {
		// TODO Auto-generated method stub
		if (this.front.isEmpty()) { 
			return new ImmutableQueue<T>(this.rear.reverse().pop(), new ImmutableStack());
		} else {
			ImmutableStack newFront = this.front.pop();
			if (newFront.isEmpty()) { 
				return new ImmutableQueue<T>(this.rear.reverse(), new ImmutableStack());
			}
			return new ImmutableQueue<T>(newFront, this.rear);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pram.Queue#head()
	 */
	@Override
	public T head() {
		// TODO Auto-generated method stub
		return this.front.peek();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pram.Queue#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.front.isEmpty() && this.rear.isEmpty();
	}

}
