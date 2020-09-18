include "User.thrift"

namespace java com.changingfond.thrift

typedef map<string, string> Data

struct Response {
    1:required i32 errCode;
    2:required string errMsg;
    3:required Data data;
}

service HelloService {

    Response SayHello(1:required User.User user)

    Response GetUser(1:required i32 id)
}