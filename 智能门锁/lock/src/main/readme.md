# readme
# Collrollor
### DoorController  
*控制层*
1.远程开门
2.设置临时密码
3.通知：开锁次数过多或者电量过低
## Service
业务逻辑层
### socket
~~~json
用于和硬件进行通信， 
ClientSocketService  客户端业务类，将硬件那边作为一个服务器端，向服务器（硬件）
发送一些json字符串，然后硬件收到这些字符串后可以做出一些对应的动作。
ServiceSocketThread 服务器线程：接收请求  然后将请求交给DealSocketData来处理
~~~
### UserService
~~~json
用了处理一些对用户数据进行操作的具体业务
~~~
### mappeer
持久层:将数据持久化到磁盘中，也就是进行一些对数据库的具体操作
###  简单的java对象
