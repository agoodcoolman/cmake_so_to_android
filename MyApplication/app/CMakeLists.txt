

cmake_minimum_required(VERSION 3.4.1)
set(CMAKE_VERBOSE_MAKEFILE on)
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11")
set(pathToProject /mnt/AndroidStudioProjects/LoggerProject/MyApplication)
include_directories(${pathToProject}/app/src/main/cpp/include)
add_library(
             native-lib
             SHARED
             src/main/cpp/native-lib.cpp )
add_library(cmake SHARED IMPORTED)
set_target_properties(cmake PROPERTIES IMPORTED_LOCATION ${pathToProject}/app/src/main/jniLibs/${ANDROID_ABI}/libcmake.so)


find_library(
              log-lib
              log )


target_link_libraries(
                       native-lib
                       ${log-lib}
                       cmake)
