# saToken 代替SpringSecurity

# 出现的疑难杂症
- satoken依赖引入时，网关要和内部服务分开，不要直接在父级pom引入Sa-Token,sa-token-spring-boot-starter 和 sa-token-reactor-spring-boot-starter，格子选择一个，一个对应Servlet模型比如Zuul，一个对应Reactor模型，如SpringCloud Gateway，切不可直接在一个项目里同时引入这两个依赖，否则会造成项目无法启动，并且要映入redis集成包，实现网关与子服务通过Redis来同步数据
- Nacos的依赖需要在自己的子模块pom中引入，否则即便配置文件无误，也注册不成功。
- 经常有一些奇怪的bug，比如那个在配置文件中需要加一句覆盖的配置。
- 有时候即便是官方封装的工具类似乎在兼容使用上还有点问题
- 父模块里不要引入过多依赖，尽量只控制必要的版本，而不是通用引入。
- SaToken引入后，网关模块可以把Spring Security依赖给舍弃，避免Spring Security的login的界面出现
- studentmanager模块pom中引入了一个解决bootstrap配置文件无效的依赖
- 引入mysql等sql连接依赖后，要么在启动类排除类，要么在配置文件里随意配置一个。
- 