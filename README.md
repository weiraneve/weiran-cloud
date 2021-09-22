## 拥有的技术栈与功能：
- 鉴权框架SaToken
- 完成SSO、OAuth2、网关统一鉴权等登录与权限功能。
- 分布式事务框架-TX-LCN、网关-SpringCloud Gateway、服务注册与发现-Nacos、持久层-MyBatisPlus、

## 出现的疑难杂症
- satoken依赖引入时，网关要和内部服务分开，不要直接在父级pom引入Sa-Token,sa-token-spring-boot-starter 和 sa-token-reactor-spring-boot-starter，格子选择一个，一个对应Servlet模型比如Zuul，一个对应Reactor模型，如SpringCloud Gateway，切不可直接在一个项目里同时引入这两个依赖，否则会造成项目无法启动，并且要映入redis集成包，实现网关与子服务通过Redis来同步数据
- Nacos的依赖需要在自己的子模块pom中引入，否则即便配置文件无误，也注册不成功。
- 经常有一些奇怪的bug，比如那个在配置文件中需要加一句覆盖的配置，那里是同名Bean需要覆盖
- 有时候即便是官方封装的工具类似乎在兼容使用上还有点问题
- 父模块里不要引入过多依赖，尽量只控制必要的版本，而不是通用引入。
- SaToken引入后，网关模块可以把Spring Security依赖给舍弃，避免Spring Security的login的界面出现
- studentmanager模块pom中引入了一个解决bootstrap配置文件无效的依赖
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