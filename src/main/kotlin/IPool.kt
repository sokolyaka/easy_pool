interface IPool<E> {

    /**
     * @return element from the pool
     * */
    fun poll(): E

    /**
     * the way to return polled element back to the pool
     * */
    fun clearAndOffer(e: E): Boolean

    /**
     * the way to return polled elements back to the pool
     * */
    fun clearAndOfferList(eList: List<E>)

    /**
     * Removes all of the elements from this pool.
     * The pool will be empty after this call returns, but any already polled elements will stay alive
     * @see getCount() will return 0
     * */
    fun clear()

    /**
     * total count of created elements
     * */
    fun getCount(): Int

    /**
     * count of available elements in the pool
     * */
    fun size(): Int
}