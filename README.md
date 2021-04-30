# SpringBoot ToolBox
本项目基于SpringBoot集成不同组件，组成SpringBoot工具箱，即开即用。
每个组件为一个独立的项目，保证组件的隔离性，如有定制化需求，自定义组合不同的项目。

## 2.1 项目构成
项目名称springboot-[component-name]，以springboot开头，后面为组件的名称。

## 2.2 组件
组件包括MyBatis、JWT、Shiro、Security、Quartz、WebSocket等。组件功能以及实现的日期如下表所示。


|序号|组件|描述|应用场景|集成日期|
|--|--|--|--|--|
|1|MyBatis|数据库操作组件，实现CURD|数据库操作||
|2|Quartz|定时器组件，自定义逻辑和定时的时间|定时任务调度||
|3|Redis|缓存组件，基于内存存储|热点数据||
|4|JWT|生成Token组件，自定义Token加密和生效时间|权限认证||
|5|RabbitMQ|消息队列组件|削峰填谷||