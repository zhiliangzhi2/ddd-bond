# ddd-bond
ddd-bond是验证领域驱动设计（domain driven design）的实践案例，以国债认购为业务背景，目的是探索应用ddd一个可参考应用框架。
关键业务逻辑（application service）一般可分为：dto、do、vo、领域对象转换、参数验证、业务规则、业务逻辑、事务处理逻辑、第三方访问、存储访问。贯穿业务逻辑处理还有异常处理、日志。
1.dto、do、vo、领域对象转换。用mapstruct(https://github.com/mapstruct/mapstruct)。
2.参数验证。用fluent-validator（https://github.com/neoremind/fluent-validator）。
3.业务规则。用domian service封装业务规则，命名为xxxRule。
4.业务逻辑。用domain service封装业务逻辑，命名为xxxService。
5.事务处理逻辑。用domain service封装事务处理逻辑，命名为xxxTransaction，用springframework的@transaction。
6.第三方访问。用acl设计，命名为xxxFacade。
7.存储访问。用Repository。
8.异常处理。
  a 整个应用定义一种类型异常AppException（RuntimeException），用错误码区分不同异常类型。
  b 错误码组成：应用名+业务名+错误码。
  c 
9.日志。
