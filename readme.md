# 工程说明
* polaris-central-warehouse-pom 中央集权仓
* polaris-double-swords 双刃剑可同时具备dubbo服务，也可作为feign服务
* polaris-double-swords-demo 测试服务，可同时调用dubbo或者feign服务
* 

#### polaris-central-warehouse-pom 作用
*   基于微服务架构，会有很多的子项目(启动的服务)，每个服务都需要引入jar，版本号很难控制
所以就需要一个空的工程统一引入jar，作为子项目的祖父，子项目只需引用jar无需指定版本号 