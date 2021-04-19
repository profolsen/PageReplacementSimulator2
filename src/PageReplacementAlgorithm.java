/**
 * You will create classes that implement this interface:
 * LRU, FIFO, Random.
*/

public interface PageReplacementAlgorithm {
    /**
     * Identifies an index of a page that can be removed.
     * @param frames an array of pages
     * @return an index of a page that should be evicted.
     */
    public int identifyReplaceablePage(Page[] frames);
}
