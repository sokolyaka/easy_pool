/**
 * The pool returns as many elements as polled,
 * but accepts back only a fixed count
 * */
class FixedSizePool<E>(val origin: IPool<E>, val maxSize: Int) : IPool<E> {

    override fun poll(): E {
        return origin.poll()
    }

    override fun clearAndOffer(e: E): Boolean {
        if (size() < maxSize) {
            return origin.clearAndOffer(e)
        }
        return false
    }

    override fun clearAndOfferList(eList: List<E>) {
        origin.clearAndOfferList(eList)
    }

    override fun clear() {
        origin.clear()
    }

    override fun getCount(): Int {
        return origin.getCount()
    }

    override fun size(): Int {
        return origin.size()
    }
}