MyApplication 是Android stduio的项目
另外一个是clion的C++项目


1.编译指令：cmake -DCMAKE_TOOLCHAIN_FILE=../android.toolchain.cmake -DANDROID_TOOLCHAIN_NAME=arm-linux-androideabi-4.9 -DANDROID_STL=system  -DANDROID_NDK=/mnt/software/adt-bundle-linux-x86_64-20140702/sdk/ndk-bundle -DCMAKE_BUILD_TYPE=Release -DANDROID_ABI="armeabi-v7a with NEON"  ../lib
2.编译完毕之后，使用make指令去编译出so的动态库

3.之前出现了错误 如下，要在第一个参数后面加上这个参数 -DANDROID_TOOLCHAIN_NAME=arm-linux-androideabi-4.9 就可以编译出makefile文件了。
‘[root@localhost build]# cmake -DCMAKE_TOOLCHAIN_FILE=../android.toolchain.cmake -DANDROID_NDK=/mnt/software/adt-bundle-linux-x86_64-20140702/sdk/ndk-bundle -DCMAKE_BUILD_TYPE=Release -DANDROID_ABI="armeabi-v7a with NEON" -DANDROID_STL=none ../lib
-- Android: Selected GCC toolchain 'arm-linux-androideabi-4.9'
-- Check for working C compiler: /mnt/software/adt-bundle-linux-x86_64-20140702/sdk/ndk-bundle/toolchains/arm-linux-androideabi-4.9/prebuilt/linux-x86_64/bin/arm-linux-androideabi-gcc
-- Check for working C compiler: /mnt/software/adt-bundle-linux-x86_64-20140702/sdk/ndk-bundle/toolchains/arm-linux-androideabi-4.9/prebuilt/linux-x86_64/bin/arm-linux-androideabi-gcc -- broken
CMake Error at /usr/local/share/cmake-3.8/Modules/CMakeTestCCompiler.cmake:51 (message):
  The C compiler
  "/mnt/software/adt-bundle-linux-x86_64-20140702/sdk/ndk-bundle/toolchains/arm-linux-androideabi-4.9/prebuilt/linux-x86_64/bin/arm-linux-androideabi-gcc"
  is not able to compile a simple test program.

  It fails with the following output:

   Change Dir: /root/桌面/test/build/CMakeFiles/CMakeTmp



  Run Build Command:"/usr/bin/gmake" "cmTC_1fd8c/fast"

  /usr/bin/gmake -f CMakeFiles/cmTC_1fd8c.dir/build.make
  CMakeFiles/cmTC_1fd8c.dir/build

  gmake[1]: 进入目录“/root/桌面/test/build/CMakeFiles/CMakeTmp”

  Building C object CMakeFiles/cmTC_1fd8c.dir/testCCompiler.c.o


  /mnt/software/adt-bundle-linux-x86_64-20140702/sdk/ndk-bundle/toolchains/arm-linux-androideabi-4.9/prebuilt/linux-x86_64/bin/arm-linux-androideabi-gcc
  -target armv7-none-linux-androideabi
  --sysroot=/mnt/software/adt-bundle-linux-x86_64-20140702/sdk/ndk-bundle/platforms/android-9/arch-arm
  -isystem
  /mnt/software/adt-bundle-linux-x86_64-20140702/sdk/ndk-bundle/platforms/android-9/arch-arm/usr/include
  -g -DANDROID -ffunction-sections -funwind-tables -fstack-protector-strong
  -no-canonical-prefixes -march=armv7-a -mfloat-abi=softfp -mfpu=vfpv3-d16
  -fno-integrated-as -mthumb -mfpu=neon -Wa,--noexecstack -Wformat
  -Werror=format-security -O0 -fno-limit-debug-info -o
  CMakeFiles/cmTC_1fd8c.dir/testCCompiler.c.o -c
  /root/桌面/test/build/CMakeFiles/CMakeTmp/testCCompiler.c

  arm-linux-androideabi-gcc: error: armv7-none-linux-androideabi: No such
  file or directory

  arm-linux-androideabi-gcc: error: unrecognized command line option
  '-target'

  arm-linux-androideabi-gcc: error: unrecognized command line option
  '-fno-integrated-as'

  arm-linux-androideabi-gcc: error: unrecognized command line option
  '-fno-limit-debug-info'

  gmake[1]: *** [CMakeFiles/cmTC_1fd8c.dir/testCCompiler.c.o] 错误 1

  gmake[1]: 离开目录“/root/桌面/test/build/CMakeFiles/CMakeTmp”

  gmake: *** [cmTC_1fd8c/fast] 错误 2





  CMake will not be able to correctly generate this project.
Call Stack (most recent call first):
  CMakeLists.txt


-- Configuring incomplete, errors occurred!
’

[参考地址1](https://github.com/taka-no-me/android-cmake)


1.编译出动态库之后，怎么在AndroidStudio中进行引用，
  [参考地址](http://blog.csdn.net/ningjingsun/article/details/52960355)
  [参考地址](http://blog.csdn.net/fpcc/article/details/69942540)
  [参考地址](http://blog.csdn.net/ddjjll8877/article/details/52670097?)


使用的软件：Clion Android Studio
系统：centos 64
文件中：Camke是clion编写的c项目
      Applicatio是Android Studio项目 在项目的NDK中使用第三方的so库，非Jni方式。
      errorlog 是为自己出现的错误的log
