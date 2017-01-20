package vw.learner;

/**
 * @author deak
 */
final public class VWFloatLearner extends VWBase implements VWLearner {
    VWFloatLearner(final long nativePointer) {
        super(nativePointer);
    }

    /**
     * <code>learnOrPredict</code> allows the ability to return an unboxed prediction.  This will reduce the overhead
     * of this function call.
     * @param example an example
     * @param learn whether to call the learn or predict VW functions.
     * @return an <em>UNBOXED</em> prediction.
     */
    private float learnOrPredict(final String example, final boolean learn) {
        lock.lock();
        try {
            if (isOpen()) {
                return predict(example, learn, nativePointer);
            }
            throw new IllegalStateException("Already closed.");
        }
        finally {
            lock.unlock();
        }
    }

    /**
     * Runs prediction on <code>example</code> and returns the prediction output.
     *
     * @param example a single vw example string
     * @return A prediction
     */
    public float predict(final String example) {
        return learnOrPredict(example, false);
    }

    /**
     * Runs learning on <code>example</code> and returns the prediction output.
     *
     * @param example a single vw example string
     * @return A prediction
     */
    public float learn(final String example) {
        return learnOrPredict(example, true);
    }

    public float getWeight(int index){
       return this.getWeight(nativePointer, index);
    }

   public void setWeight(int index, float value){
       this.setWeight(nativePointer, index, value);
   }

    private native float predict(String example, boolean learn, long nativePointer);

    private native float getWeight(long nativePointer, int index);

    private native void setWeight(long nativePointer, int index, float value);
}
