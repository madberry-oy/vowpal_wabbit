#include "../../../../vowpalwabbit/vw.h"
#include "jni_base_learner.h"
#include "vw_learner_VWFloatLearner.h"

jfloat floatPredictor(example* vec, JNIEnv *env) { return vec->pred.scalar; }

JNIEXPORT jfloat JNICALL Java_vw_learner_VWFloatLearner_predict(JNIEnv *env, jobject obj, jstring example_string, jboolean learn, jlong vwPtr)
{ return base_predict<jfloat>(env, obj, example_string, learn, vwPtr, floatPredictor);
}

JNIEXPORT jfloat JNICALL Java_vw_learner_VWLearners_getWeight(JNIEnv *env, jobject obj, jlong vwPtr, jint index, jint offset)
{ vw* vwInstance = (vw*)vwPtr;
  return (jfloat) VW::get_weight(*vwInstance, index, offset);
}

JNIEXPORT void JNICALL Java_vw_learner_VWLearners_setWeight(JNIEnv *env, jobject obj, jlong vwPtr, jint index, jint offset, jfloat value)
{ vw* vwInstance = (vw*)vwPtr;
  VW::set_weight(*vwInstance, index, offset, value);
}
