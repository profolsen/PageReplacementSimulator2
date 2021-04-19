/**
 * Called First, because it evicts the first page in the array (the page at index 0).
 */
public class FirstPageReplacementAlgorithm implements PageReplacementAlgorithm{

    @Override
    public int identifyReplaceablePage(Page[] frames) {
        return 0; //some really complicated reasoning went into this decision.
    }
}
