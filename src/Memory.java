public class Memory {
    public Page[] frames;
    private int pageFaults;
    private PageReplacementAlgorithm evictor;

    /**
     * Creates a new Memory Object with the specified number of frames.
     * @param numberOfFrames the number of frames to use.
     */
    public Memory(int numberOfFrames) {
        frames = new Page[numberOfFrames];
    }

    /**
     * Accesses the given pageID.
     * @param pageID the id of a page.
     * @param now the current time in the simulation.
     */
    public void access(int pageID, int now) {
        //see if the page is in frames.
        //if not, increment page fault and
        //first evict a page if there are no empty frames
        //add the page to an empty frame
    }

    /**
     * removes a page using the PageReplacementAlgorithm.
     */
    public void evict() {
        int frameToFree = evictor.identifyReplaceablePage(frames);
        frames[frameToFree] = null;
    }

    /**
     * Returns the index of a free frame or null if there
     * is no free frame.
     * @return the index of a free frame or null if there
     * is no free frame.
     */
    public Integer freeFrame() {
        Integer freeFrame = null;
        for(int i = 0; i < frames.length; i++)
            if (frames[i] == null) {
                freeFrame = i;
                break;
            }
        return freeFrame;
    }

    /**
     * Return the number of page faults.
     * @return the number of page faults.
     */
    public int pageFaults() {
        return pageFaults;
    }

    public void setPageReplacementAglorithm(PageReplacementAlgorithm evictor) {
        this.evictor = evictor;
    }
}
