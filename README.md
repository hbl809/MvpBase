# MvpBase

MVP + RxJava2 + Retrofit2 + Dagger2 学习Demo

使用RxJava配合Retrofit2做网络请求

使用RxUtil对线程操作和网络请求结果处理做了封装

使用RxPresenter对订阅的生命周期做管理

使用RxBus来方便组件间的通信

使用RxJava其他操作符来做延时、轮询、转化、筛选等操作

使用okhttp3对网络返回内容做缓存，还有日志、超时重连、头部消息的配置

使用MVP架构整个项目，对应于model、ui、presenter三个包

使用Dagger2将M层注入P层，将P层注入V层，无需new，直接调用对象


感谢  https://github.com/codeestX/GeekNews
Demo参考了GeekNews，仅保留了结构干净的MVP结构，加入了一个接口测试用例
