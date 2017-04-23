#include <jni.h>
#include <string>
#include "include/hello.h"
#include "android/log.h"
extern "C"
jstring Java_com_jin_android_myapplication_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++ ";
    int i = add(10);

    __android_log_print(ANDROID_LOG_INFO, "kaikai","a = %i", i);

    return env->NewStringUTF(hello.c_str());
}
