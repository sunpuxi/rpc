之前学习阿里 Dubbo 的时候，好奇这一种 RPC 框架是如何实现的。最近找了一些教程正在学习如何开发一个自己的 RPC 框架。

先认识一下什么是 RPC ？ 即远程过程调用。简单的举一个例子：你在自己开发的过程中，需要调用非本地的别人开发的服务，那么就可以使用常规的构建 HTTP 请求的方式实现调用，或者是使用 RPC 框架进行服务调用。

为什么使用 RPC 而不是 HTTP 呢？我们知道，使用 HTTP 需要构建复杂的 HTTP 消息，这在部分场景中并不适用，因为效率并不高。而使用 RPC 框架即可以解决这个问题。

从 Dubbo 官方推荐的模块开发中，我们可以得知依次完成的 RPC 过程需要三个角色：1、服务提供者：负责提供具体的服务。2、服务消费者：调用提供者的服务。3、通用模块：保存着一些通用的对象信息。

下面继续梳理一下如何使用 Java 开发一个简易版的 RPC 框架：

1、通用模块：这里负责通用对象信息的存储，如实体信息，服务信息等。

2、服务提供方：引入通用模块的内容，并自主实现具体自定义的服务。

3、消费者：引入通用模块的依赖，通过其中的服务对象进行服务之间的调用。

这其中存在什么问题呢？

1、消费者如何调用服务？引入生产者的模块后直接进行调用？这个过程并不涉及通信，也就不跟 RPC 沾边了，所以我们在消费者方进行依赖引入时，引入的是通用模块中未做具体实现的抽象服务。
解决方式：需要进行 RPC 调用，就需要进行网络通信，要进行网络通信就离不开网络服务器了。服务提供方作为主动提供服务的一方，自然需要具有网络服务器的功能，因此我们在服务提供者方搭建简单的网络服务器用于生产者与消费者之间的网络通信。
