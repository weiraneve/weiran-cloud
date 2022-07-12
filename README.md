# 拥有的技术栈与功能：
一些自己玩的微服务Demo，贻笑大方

- uaa模块集成用户认证中心模块简单集成了安全框架SaToken完成鉴权与登录。
- gateway模块集成了SpringCloud Gateway 与 SaToken框架的网关统一鉴权功能，实现了uaa模块登陆与认证，网关鉴权。
- mqtt模块集成了RabbitMq的mqtt的功能，集成度比较简单。
- admin模块集成了SpringBoot Admin 微服务应用监控。
- mission模块集成了Feign、与一些测试的功能。
- sentinel模块集成了Feign与sentinel。
- 总的技术栈有：网关SpringCloud Gateway、服务注册与发现使用Nacos、业务的持久层MyBatisPlus、MQTT-RabbitMq即时通信、Feign服务客户端模块
、Elastic Apm监控、Sleuth + Zipkin分布式链路追踪、SpringBoot Actuator、SpringBoot Admin监控、ELK、Sentinel、
- mq模块集成了RabbitMQ、RocketMQ

# 出现的疑难杂症
- satoken依赖引入时，网关要和内部服务分开，不要直接在父级pom引入Sa-Token,sa-token-spring-boot-starter 和 sa-token-reactor-spring-boot-starter，格子选择一个，一个对应Servlet模型比如Zuul，一个对应Reactor模型，如SpringCloud Gateway，切不可直接在一个项目里同时引入这两个依赖，否则会造成项目无法启动，并且要映入redis集成包，实现网关与子服务通过Redis来同步数据
- Nacos的依赖需要在自己的子模块pom中引入，否则即便配置文件无误，也注册不成功。
- 经常有一些奇怪的bug，比如那个在配置文件中需要加一句覆盖的配置，那里是同名Bean需要覆盖
- 有时候即便是官方封装的工具类似乎在兼容使用上还有点问题
- 父模块里不要引入过多依赖，尽量只控制必要的版本，而不是通用引入。
- SaToken引入后，网关模块可以把Spring Security依赖给舍弃，避免Spring Security的login的界面出现
- uaa模块pom中引入了一个解决bootstrap配置文件无效的依赖
- 引入mysql等sql连接依赖后，要么在启动类排除类，要么在配置文件里随意配置一个。
- alone-redis 引入依赖后可以在配置文件中配置，但一定要看清楚业务redis与权限或者自己设置但数据的redis是否能对应上
- 很多功能使用时，需要注意是否在本模块以及引入依赖，比如thymeleaf
- 设置重定向的时候，过滤器一定要排除login接口，否则一直重定向报错
- Mac的IDEA有可能有那模块依赖添加问题，解决办法就是，删除有问题的模块重新生成
- 过滤器尽量不要有重复的地方，以免顺序上执行有误，但似乎网关的统一鉴权与登陆和子模块冲突不大
- 我的理解里，这个saToken框架里的SSO应用，只需要在认证中心server里登陆，其他回调配置好，不需要自己调ticket和back，直接登陆就是
- 有时候一些bug查询资料下来，最终发现无非就是删除pom依赖或者添加一些pom依赖
- Mac IDEA 里maven子模块建立后，似乎要在pom文件里把dependencies标签配置一下，哪怕是为空，也可，否则子模块依赖库配置不了，以及application配置文件需要在project structure的facets中添加spring，bootstrap
文件应该是需要替添加那个依赖，可解决
- 很多bug都是依赖冲突，或者修改pom文件后IDEA没有立即反馈更改的问题
- 如果模块没有启动类，那么spring-Applictaion-yml配置文件无法加入facets
- 需要格外注意每一个模块的mysql、redis等数据源和中间件的连接配置与依赖，特别父模块取消那些依赖后，子模块需要独自配置
- 因为common模块里有redis相关的代码，所以每一个引用common模块的子模块都需要配置redis属性或者上nacos，以及虽然通过nacos配置过的，但数据库以及数据源用本地的，建议注释掉nacos相关配置代码
- 依赖注入报错的sqlSessionFactory的BUG，通过pom文件里添加Mybaits数据库映射与mysql连接器解决。
- 配置文件的Mysql时区问题
- MP框架中，依赖mybatis-plus-boot-starter与配置mybatis-plus.mapper-locations对应，mybatis-plus依赖包则是mybatis.mapper-locations，否则会有映射失败的bug
- 导入admin依赖的时候发现部分版本有问题，2.2.0相对稳定
- SpringBoot Admin关于安全认证，网上都是关于Spring Security的教程，至于如何关于Satoken的配置暂且没有，项目里在全局过滤器里放开actuator路径
- 提示加载不到主类参考 https://blog.csdn.net/qq_37870901/article/details/88921400
- Feign调用服务，回调降级和封装返回结构体似乎会影响服务调用
- Sentinel引入版本与父模块spring.cloud-alibaba依赖版本有关系，2.1.0.RELEASE目前看起来可用
- sentinel依赖版本与feign版本似乎有影响，目前springcloud版本与alibaba的2.2.2.RELEASE是可行的
- sentinel 配置持久化到nacos时，yaml配置文件中nacos的username和password要加上，否则无法使用
