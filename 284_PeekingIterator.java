// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> itr;
    boolean peeked;
    int peekVal;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.itr = iterator;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(peeked){
            return peekVal;
        } else{
            peeked = true;
            peekVal = itr.next();
            return peekVal;
        }
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(peeked){
	        peeked = false; // most important!!!!
	        return peekVal;
	    } else{
	        return itr.next();
	    }
	}

	@Override
	public boolean hasNext() {
	    if(peeked) return true;
	    else return itr.hasNext();
	}
}