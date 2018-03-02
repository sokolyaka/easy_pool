import java.util.*

class Pool<E>(val pool: Queue<E>, initSize: Int, val eBuilder: INewElementBuilder<E>, val eCleaner: IElementCleaner<E>) : IPool<E> {

    private var eCount: Int = 0

    init {
        for (i in 0 until initSize) {
            pool.add(
                    eBuilder
                            .number(eCount++)
                            .build())
        }
    }

    override fun poll(): E {
        var e: E? = null
        try {
            e = pool.poll()
        } catch (ignored: NoSuchElementException) {
        }

        if (e == null) {
            e = eBuilder
                    .number(eCount++)
                    .build()
        }

        return e!!
    }

    override fun clearAndOffer(e: E): Boolean {
        return pool.offer(
                eCleaner.clear(e))
    }

    override fun clearAndOfferList(eList: List<E>) {
        for (e in eList) {
            clearAndOffer(e)
        }
    }

    override fun clear() {
        pool.clear()
        eCount = 0
    }

    override fun getCount(): Int {
        return eCount
    }

    override fun size(): Int {
        return pool.size
    }
}