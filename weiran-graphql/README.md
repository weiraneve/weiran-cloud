# 参考
- [部分代码参考](https://github.com/gaohanghang/springboot-graphql)
- [apollo-client sandbox官网](https://apollo-fullstack-tutorial.herokuapp.com/graphql)
- [SpringBoot GraphQL Demo](https://github.com/Loading-Life/spring-graphql-demo)

# 简介
跑起来后，postman上用`graphql`模式调试。mutation和query分别如下模板。

请求接口为 `127.0.0.1/graphql`

```
mutation {
  createVehicle(type: "car", modelCode: "XYZ0192", brandName: "XYZ", launchDate: "2016-08-16") 
  {
    id
  }
}
```

```
query {
  vehicles(count: 1) 
  {
    id, 
    type, 
    modelCode
	}
}
```

```
subscription {
  getVehicleUpdate(id: 1) 
  {
    id, 
    type, 
    modelCode
	}
}
```

json的query模板:`{"query": "{vehicles(count: 1){id,type,modelCode}}"}`

- 调试工具GraphIQL ${address}/graphiql
- 调试工具Voyager ${address}/voyager
- 调试工具Altair ${address}/altair
- 调试工具Playground ${address}/playground
