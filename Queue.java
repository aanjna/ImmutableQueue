/**
 * 
 */
package com.pram;

/**
 * @author PraveenPatel
 *15-Jul-2019
 */
public interface Queue<T> {

	public Queue<T> enQueue(T t);
    public Queue<T> deQueue();
    public T head();
    public boolean isEmpty();
}
