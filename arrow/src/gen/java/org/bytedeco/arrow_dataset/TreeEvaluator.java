// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow_dataset;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;
import org.bytedeco.parquet.*;
import static org.bytedeco.arrow.global.parquet.*;

import static org.bytedeco.arrow.global.arrow_dataset.*;


/** construct an Evaluator which uses compute kernels to evaluate expressions and
 *  filter record batches in depth first order */
@Namespace("arrow::dataset") @Properties(inherit = org.bytedeco.arrow.presets.arrow_dataset.class)
public class TreeEvaluator extends ExpressionEvaluator {
    static { Loader.load(); }
    /** Default native constructor. */
    public TreeEvaluator() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public TreeEvaluator(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public TreeEvaluator(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public TreeEvaluator position(long position) {
        return (TreeEvaluator)super.position(position);
    }
    @Override public TreeEvaluator getPointer(long i) {
        return new TreeEvaluator((Pointer)this).position(position + i);
    }

  public native @ByVal DatumResult Evaluate(@Const @ByRef Expression expr, @Const @ByRef RecordBatch batch,
                           MemoryPool pool);

  public native @ByVal RecordBatchResult Filter(@Const @ByRef Datum selection,
                                                @SharedPtr @Cast({"", "std::shared_ptr<arrow::RecordBatch>"}) RecordBatch batch,
                                                MemoryPool pool);
}
