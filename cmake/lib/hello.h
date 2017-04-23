//
// Created by jin on 17-4-22.
//
/**
 * // 这个 是连接android_ndk的命令
 * cmake -DCMAKE_TOOLCHAIN_FILE=../android.toolchain.cmake -DANDROID_TOOLCHAIN_NAME=arm-linux-androideabi-4.9 -DANDROID_STL=system  -DANDROID_NDK=/mnt/software/adt-bundle-linux-x86_64-20140702/sdk/ndk-bundle -DCMAKE_BUILD_TYPE=Release -DANDROID_ABI="armeabi-v7a with NEON"  ../lib

 */
#ifndef CMAKE_HELLO_H


#define CMAKE_HELLO_H


void HelloFunc();

int add(int a);


#endif //CMAKE_HELLO_H
