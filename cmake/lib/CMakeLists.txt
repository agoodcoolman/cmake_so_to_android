
cmake_minimum_required(VERSION 3.6)
set(LIBHELLO_SRC hello.h hello.cpp)
include_directories(/usr/include/)
link_directories(/usr/lib /usr/lib64)
add_library(cmake SHARED ${LIBHELLO_SRC})
