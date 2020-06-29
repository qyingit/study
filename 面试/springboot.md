
## 1��Spring Boot ���

> ��SpringӦ�ÿ�����һ����ܣ�
>
> ����Spring����ջ��һ�������ϣ�
>
> J2EE������һվʽ���������
## 2��΢����

2014��martin fowler

΢���񣺼ܹ���񣨷���΢����

һ��Ӧ��Ӧ����һ��С�ͷ��񣻿���ͨ��HTTP�ķ�ʽ���л�ͨ��

����Ӧ�ã�ALL IN ONE

΢����ÿһ������Ԫ�����ն���һ���ɶ����滻�Ͷ��������������Ԫ��

[��ϸ����΢�����ĵ�](https://martinfowler.com/articles/microservices.html#MicroservicesAndSoa)



## 3������׼��

http://www.gulixueyuan.com/ ����ѧԺ

����Լ��

�Cjdk1.8��Spring Boot �Ƽ�jdk1.7�����ϣ�java version "1.8.0_112"

�Cmaven3.x��maven 3.3���ϰ汾��Apache Maven 3.3.9

�CIntelliJIDEA2017��IntelliJ IDEA 2017.2.2 x64��STS

�CSpringBoot 1.5.9.RELEASE��1.5.9��

ͳһ������



### 1��MAVEN���ã�

��maven ��settings.xml�����ļ���profiles��ǩ���

```xml
<profile>
  <id>jdk-1.8</id>
  <activation>
    <activeByDefault>true</activeByDefault>
    <jdk>1.8</jdk>
  </activation>
  <properties>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
    <maven.compiler.compilerVersion>1.8</maven.compiler.compilerVersion>
  </properties>
</profile>
```

### 2��IDEA����

����maven������

![idea����](images/�ѹ���ͼ20180129151045.png)



![images/](images/�ѹ���ͼ20180129151112.png)

## 4��Spring Boot HelloWorld

һ�����ܣ�

���������hello���󣬷������������󲢴�����ӦHello World�ַ�����



### 1������һ��maven���̣���jar��

### 2������spring boot��ص�����

```xml
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.5.9.RELEASE</version>
    </parent>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>
```

### 3����дһ������������Spring BootӦ��

```java
/**
 *  @SpringBootApplication ����עһ���������࣬˵������һ��Spring BootӦ��
 */
@SpringBootApplication
public class HelloWorldMainApplication {
    public static void main(String[] args) {
        // SpringӦ����������
        SpringApplication.run(HelloWorldMainApplication.class,args);
    }
}
```

### 4����д��ص�Controller��Service

```java
@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World!";
    }
}
```



### 5���������������

### 6���򻯲���

```xml
 <!-- �����������Խ�Ӧ�ô����һ����ִ�е�jar����-->
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
```

�����Ӧ�ô��jar����ֱ��ʹ��java -jar���������ִ�У�

## 5��Hello World̽��

### 1��POM�ļ�

#### 1������Ŀ

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>1.5.9.RELEASE</version>
</parent>

���ĸ���Ŀ��
<parent>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-dependencies</artifactId>
  <version>1.5.9.RELEASE</version>
  <relativePath>../../spring-boot-dependencies</relativePath>
</parent>
������������Spring BootӦ����������������汾��

```

Spring Boot�İ汾�ٲ����ģ�

�Ժ����ǵ�������Ĭ���ǲ���Ҫд�汾����û����dependencies��������������Ȼ��Ҫ�����汾�ţ�

#### 2��������

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

**spring-boot-starter**-==web==��

?	spring-boot-starter��spring-boot�����������������ǵ�����webģ�����������������������



Spring Boot�����еĹ��ܳ�������ȡ����������һ������starters������������ֻ��Ҫ����Ŀ����������Щstarter��س����������������ᵼ�������Ҫ��ʲô���ܾ͵���ʲô������������



### 2���������࣬�������

```java
/**
 *  @SpringBootApplication ����עһ���������࣬˵������һ��Spring BootӦ��
 */
@SpringBootApplication
public class HelloWorldMainApplication {
    public static void main(String[] args) {
        // SpringӦ����������
        SpringApplication.run(HelloWorldMainApplication.class,args);
    }
}
```

@**SpringBootApplication**:    Spring BootӦ�ñ�ע��ĳ������˵���������SpringBoot���������࣬SpringBoot��Ӧ������������main����������SpringBootӦ�ã�



```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(excludeFilters = {
      @Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
      @Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) })
public @interface SpringBootApplication {
```
@**SpringBootConfiguration**:Spring Boot�������ࣻ
?		��ע��ĳ�����ϣ���ʾ����һ��Spring Boot�������ࣻ
?		@**Configuration**:������������ע���ע�⣻
?			������ -----  �����ļ���������Ҳ�������е�һ�������@Component
@**EnableAutoConfiguration**�������Զ����ù��ܣ�
?		��ǰ������Ҫ���õĶ�����Spring Boot�������Զ����ã�@**EnableAutoConfiguration**����SpringBoot�����Զ����ù��ܣ������Զ����ò�����Ч��
```java
@AutoConfigurationPackage
@Import(EnableAutoConfigurationImportSelector.class)
public @interface EnableAutoConfiguration {
```
?      	@**AutoConfigurationPackage**���Զ����ð�
?		@**Import**(AutoConfigurationPackages.Registrar.class)��
?		Spring�ĵײ�ע��@Import���������е���һ�����������������AutoConfigurationPackages.Registrar.class��
==���������ࣨ@SpringBootApplication��ע���ࣩ�����ڰ������������Ӱ�������������ɨ�赽Spring������==
?	@**Import**(EnableAutoConfigurationImportSelector.class)��
?		�������е��������
?		**EnableAutoConfigurationImportSelector**��������Щ�����ѡ������
?		��������Ҫ����������ȫ�����ķ�ʽ���أ���Щ����ͻᱻ��ӵ������У�
?		��������е���ǳ�����Զ������ࣨxxxAutoConfiguration�������Ǹ������е������������Ҫ����������������ú���Щ�����		![�Զ�������](images/�ѹ���ͼ20180129224104.png)
�����Զ������࣬��ȥ�������ֶ���д����ע�빦������ȵĹ�����
?		SpringFactoriesLoader.loadFactoryNames(EnableAutoConfiguration.class,classLoader)��
==Spring Boot��������ʱ�����·���µ�META-INF/spring.factories�л�ȡEnableAutoConfigurationָ����ֵ������Щֵ��Ϊ�Զ������ർ�뵽�����У��Զ����������Ч�������ǽ����Զ����ù�����==��ǰ������Ҫ�Լ����õĶ������Զ������඼�����ǣ�
J2EE���������Ͻ���������Զ����ö���spring-boot-autoconfigure-1.5.9.RELEASE.jar��
?		
==Springע��棨����ѧԺ��==
## 6��ʹ��Spring Initializer���ٴ���Spring Boot��Ŀ
### 1��IDEA��ʹ�� Spring Initializer���ٴ�����Ŀ
IDE��֧��ʹ��Spring����Ŀ�����򵼿��ٴ���һ��Spring Boot��Ŀ��
ѡ��������Ҫ��ģ�飻�򵼻���������Spring Boot��Ŀ��
Ĭ�����ɵ�Spring Boot��Ŀ��
- �������Ѿ����ɺ��ˣ�����ֻ��Ҫ�����Լ����߼�
- resources�ļ�����Ŀ¼�ṹ
  - static���������еľ�̬��Դ�� js css  images��
  - templates���������е�ģ��ҳ�棻��Spring BootĬ��jar��ʹ��Ƕ��ʽ��Tomcat��Ĭ�ϲ�֧��JSPҳ�棩������ʹ��ģ�����棨freemarker��thymeleaf����
  - application.properties��Spring BootӦ�õ������ļ��������޸�һЩĬ�����ã�
### 2��STSʹ�� Spring Starter Project���ٴ�����Ŀ
-------------
# ���������ļ�
## 1�������ļ�
SpringBootʹ��һ��ȫ�ֵ������ļ��������ļ����ǹ̶��ģ�
?application.properties
?application.yml
�����ļ������ã��޸�SpringBoot�Զ����õ�Ĭ��ֵ��SpringBoot�ڵײ㶼�������Զ����úã�
YAML��YAML Ain't Markup Language��
?	YAML  A Markup Language����һ���������
?	YAML   isn't Markup Language������һ��������ԣ�
������ԣ�
?	��ǰ�������ļ�����඼ʹ�õ���  **xxxx.xml**�ļ���
?	YAML��**������Ϊ����**����json��xml�ȸ��ʺ��������ļ���
?	YAML����������
```yaml
server:
  port: 8081
```
?	XML��
```xml
<server>
	<port>8081</port>
</server>
```
## 2��YAML�﷨��
### 1�������﷨
k:(�ո�)v����ʾһ�Լ�ֵ�ԣ��ո�����У���
��**�ո�**�����������Ʋ㼶��ϵ��ֻҪ��������һ�����ݣ�����ͬһ���㼶��
```yaml
server:
    port: 8081
    path: /hello
```
���Ժ�ֵҲ�Ǵ�Сд���У�
### 2��ֵ��д��
#### ����������ͨ��ֵ�����֣��ַ�����������
?	k: v������ֱ����д��
?		�ַ���Ĭ�ϲ��ü��ϵ����Ż���˫���ţ�
?		""��˫���ţ�����ת���ַ�������������ַ��������ַ�����Ϊ�������ʾ����˼
?				name:   "zhangsan \n lisi"�������zhangsan ����  lisi
?		''�������ţ���ת�������ַ��������ַ�����ֻ��һ����ͨ���ַ�������
?				name:   ��zhangsan \n lisi���������zhangsan \n  lisi
#### ����Map�����Ժ�ֵ������ֵ�ԣ���
?	k: v������һ����д��������Ժ�ֵ�Ĺ�ϵ��ע������
?		������k: v�ķ�ʽ
```yaml
friends:
		lastName: zhangsan
		age: 20
```
����д����
```yaml
friends: {lastName: zhangsan,age: 18}
```
#### ���飨List��Set����
��- ֵ��ʾ�����е�һ��Ԫ��
```yaml
pets:
 - cat
 - dog
 - pig
```
����д��
```yaml
pets: [cat,dog,pig]
```
## 3�������ļ�ֵע��
�����ļ�
```yaml
person:
    lastName: hello
    age: 18
    boss: false
    birth: 2017/12/12
    maps: {k1: v1,k2: 12}
    lists:
      - lisi
      - zhaoliu
    dog:
      name: С��
      age: 12
```
javaBean��
```java
/**
 * �������ļ������õ�ÿһ�����Ե�ֵ��ӳ�䵽��������
 * @ConfigurationProperties������SpringBoot�������е��������Ժ������ļ�����ص����ý��а󶨣�
 *      prefix = "person"�������ļ����ĸ�������������Խ���һһӳ��
 *
 * ֻ���������������е���������������ṩ��@ConfigurationProperties���ܣ�
 *
 */
@Component
@ConfigurationProperties(prefix = "person")
public class Person {
    private String lastName;
    private Integer age;
    private Boolean boss;
    private Date birth;
    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;
```
���ǿ��Ե��������ļ����������Ժ��д���þ�����ʾ��
```xml
<!--���������ļ��������������ļ����а󶨾ͻ�����ʾ-->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-configuration-processor</artifactId>
			<optional>true</optional>
		</dependency>
```
#### 1��properties�����ļ���idea��Ĭ��utf-8���ܻ�����
����
![idea��������](images/�ѹ���ͼ20180130161620.png)
#### 2��@Value��ȡֵ��@ConfigurationProperties��ȡֵ�Ƚ�
|            | @ConfigurationProperties | @Value |
| ---------- | ------------------------ | ------ |
| ����         | ����ע�������ļ��е�����             | һ����ָ��  |
| ��ɢ�󶨣���ɢ�﷨�� | ֧��                       | ��֧��    |
| SpEL       | ��֧��                      | ֧��     |
| JSR303����У�� | ֧��                       | ��֧��    |
| �������ͷ�װ     | ֧��                       | ��֧��    |
�����ļ�yml����properties���Ƕ��ܻ�ȡ��ֵ��
���˵������ֻ����ĳ��ҵ���߼�����Ҫ��ȡһ�������ļ��е�ĳ��ֵ��ʹ��@Value��
���˵������ר�ű�д��һ��javaBean���������ļ�����ӳ�䣬���Ǿ�ֱ��ʹ��@ConfigurationProperties��
#### 3�������ļ�ע��ֵ����У��
```java
@Component
@ConfigurationProperties(prefix = "person")
@Validated
public class Person {
    /**
     * <bean class="Person">
     *      <property name="lastName" value="������/${key}�ӻ��������������ļ��л�ȡֵ/#{SpEL}"></property>
     * <bean/>
     */
   //lastName�����������ʽ
    @Email
    //@Value("${person.last-name}")
    private String lastName;
    //@Value("#{11*2}")
    private Integer age;
    //@Value("true")
    private Boolean boss;
    private Date birth;
    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;
```
#### 4��@PropertySource&@ImportResource&@Bean
@**PropertySource**������ָ���������ļ���
```java
/**
 * �������ļ������õ�ÿһ�����Ե�ֵ��ӳ�䵽��������
 * @ConfigurationProperties������SpringBoot�������е��������Ժ������ļ�����ص����ý��а󶨣�
 *      prefix = "person"�������ļ����ĸ�������������Խ���һһӳ��
 *
 * ֻ���������������е���������������ṩ��@ConfigurationProperties���ܣ�
 *  @ConfigurationProperties(prefix = "person")Ĭ�ϴ�ȫ�������ļ��л�ȡֵ��
 *
 */
@PropertySource(value = {"classpath:person.properties"})
@Component
@ConfigurationProperties(prefix = "person")
//@Validated
public class Person {
    /**
     * <bean class="Person">
     *      <property name="lastName" value="������/${key}�ӻ��������������ļ��л�ȡֵ/#{SpEL}"></property>
     * <bean/>
     */
   //lastName�����������ʽ
   // @Email
    //@Value("${person.last-name}")
    private String lastName;
    //@Value("#{11*2}")
    private Integer age;
    //@Value("true")
    private Boolean boss;
```
@**ImportResource**������Spring�������ļ����������ļ������������Ч��
Spring Boot����û��Spring�������ļ��������Լ���д�������ļ���Ҳ�����Զ�ʶ��
����Spring�������ļ���Ч�����ؽ�����@**ImportResource**��ע��һ����������
```java
@ImportResource(locations = {"classpath:beans.xml"})
����Spring�������ļ�������Ч
```
������дSpring�������ļ�
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    <bean id="helloService" class="com.atguigu.springboot.service.HelloService"></bean>
</beans>
```
SpringBoot�Ƽ����������������ķ�ʽ���Ƽ�ʹ��ȫע��ķ�ʽ
1��������**@Configuration**------>Spring�����ļ�
2��ʹ��**@Bean**��������������
```java
/**
 * @Configuration��ָ����ǰ����һ�������ࣻ���������֮ǰ��Spring�����ļ�
 *
 * �������ļ�����<bean><bean/>��ǩ������
 *
 */
@Configuration
public class MyAppConfig {
    //�������ķ���ֵ��ӵ������У�������������Ĭ�ϵ�id���Ƿ�����
    @Bean
    public HelloService helloService02(){
        System.out.println("������@Bean����������������...");
        return new HelloService();
    }
}
```
##4�������ļ�ռλ��
### 1�������
```java
${random.value}��${random.int}��${random.long}
${random.int(10)}��${random.int[1024,65536]}
```
### 2��ռλ����ȡ֮ǰ���õ�ֵ�����û�п�������:ָ��Ĭ��ֵ
```properties
person.last-name=����${random.uuid}
person.age=${random.int}
person.birth=2017/12/15
person.boss=false
person.maps.k1=v1
person.maps.k2=14
person.lists=a,b,c
person.dog.name=${person.hello:hello}_dog
person.dog.age=15
```
## 5��Profile
### 1����Profile�ļ�
�������������ļ���д��ʱ���ļ���������   application-{profile}.properties/yml
Ĭ��ʹ��application.properties�����ã�
### 2��yml֧�ֶ��ĵ��鷽ʽ
```yml
server:
  port: 8081
spring:
  profiles:
    active: prod
---
server:
  port: 8083
spring:
  profiles: dev
---
server:
  port: 8084
spring:
  profiles: prod  #ָ�������ĸ�����
```
### 3������ָ��profile
?	1���������ļ���ָ��  spring.profiles.active=dev
?	2�������У�
?		java -jar spring-boot-02-config-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev��
?		����ֱ���ڲ��Ե�ʱ�����ô��������в���
?	3�������������
?		-Dspring.profiles.active=dev
## 6�������ļ�����λ��
springboot ������ɨ������λ�õ�application.properties����application.yml�ļ���ΪSpring boot��Ĭ�������ļ�
�Cfile:./config/
�Cfile:./
�Cclasspath:/config/
�Cclasspath:/
���ȼ��ɸߵ��ף������ȼ������ûḲ�ǵ����ȼ������ã�
SpringBoot������ĸ�λ��ȫ�������������ļ���**��������**��
==���ǻ�����ͨ��spring.config.location���ı�Ĭ�ϵ������ļ�λ��==
**��Ŀ������Ժ����ǿ���ʹ�������в�������ʽ��������Ŀ��ʱ����ָ�������ļ�����λ�ã�ָ�������ļ���Ĭ�ϼ��ص���Щ�����ļ���ͬ�������γɻ������ã�**
java -jar spring-boot-02-config-02-0.0.1-SNAPSHOT.jar --spring.config.location=G:/application.properties
## 7���ⲿ���ü���˳��
**==SpringBootҲ���Դ�����λ�ü������ã� ���ȼ��Ӹߵ��ͣ������ȼ������ø��ǵ����ȼ������ã����е����û��γɻ�������==**
**1.�����в���**
���е����ö��������������Ͻ���ָ��
java -jar spring-boot-02-config-02-0.0.1-SNAPSHOT.jar --server.port=8087  --server.context-path=/abc
��������ÿո�ֿ��� --������=ֵ
2.����java:comp/env��JNDI����
3.Javaϵͳ���ԣ�System.getProperties()��
4.����ϵͳ��������
5.RandomValuePropertySource���õ�random.*����ֵ
==**��jar������jar���ڽ���Ѱ�ң�**==
==**���ȼ��ش�profile**==
**6.jar���ⲿ��application-{profile}.properties��application.yml(��spring.profile)�����ļ�**
**7.jar���ڲ���application-{profile}.properties��application.yml(��spring.profile)�����ļ�**
==**�������ز���profile**==
**8.jar���ⲿ��application.properties��application.yml(����spring.profile)�����ļ�**
**9.jar���ڲ���application.properties��application.yml(����spring.profile)�����ļ�**
10.@Configurationע�����ϵ�@PropertySource
11.ͨ��SpringApplication.setDefaultPropertiesָ����Ĭ������
����֧�ֵ����ü�����Դ��
[�ο��ٷ��ĵ�](https://docs.spring.io/spring-boot/docs/1.5.9.RELEASE/reference/htmlsingle/#boot-features-external-config)
## 8���Զ�����ԭ��
�����ļ�������дʲô����ôд���Զ�����ԭ��
[�����ļ������õ����Բ���](https://docs.spring.io/spring-boot/docs/1.5.9.RELEASE/reference/htmlsingle/#common-application-properties)
### 1��**�Զ�����ԭ��**
1����SpringBoot������ʱ������������࣬�������Զ����ù��� ==@EnableAutoConfiguration==
**2����@EnableAutoConfiguration ���ã�**
 -  ����EnableAutoConfigurationImportSelector�������е���һЩ�����
- ���Բ鿴selectImports()���������ݣ�
- List<String> configurations = getCandidateConfigurations(annotationMetadata,      attributes);��ȡ��ѡ������
  - ```java
    SpringFactoriesLoader.loadFactoryNames()
    ɨ������jar����·����  META-INF/spring.factories
    ��ɨ�赽����Щ�ļ������ݰ�װ��properties����
    ��properties�л�ȡ��EnableAutoConfiguration.class�ࣨ��������Ӧ��ֵ��Ȼ������������������
    ```
    ?
**==�� ��·����  META-INF/spring.factories �������õ�����EnableAutoConfiguration��ֵ���뵽�������У�==**
```properties
# Auto Configure
org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration,\
org.springframework.boot.autoconfigure.aop.AopAutoConfiguration,\
org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration,\
org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration,\
org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration,\
org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration,\
org.springframework.boot.autoconfigure.cloud.CloudAutoConfiguration,\
org.springframework.boot.autoconfigure.context.ConfigurationPropertiesAutoConfiguration,\
org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration,\
org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration,\
org.springframework.boot.autoconfigure.couchbase.CouchbaseAutoConfiguration,\
org.springframework.boot.autoconfigure.dao.PersistenceExceptionTranslationAutoConfiguration,\
org.springframework.boot.autoconfigure.data.cassandra.CassandraDataAutoConfiguration,\
org.springframework.boot.autoconfigure.data.cassandra.CassandraRepositoriesAutoConfiguration,\
org.springframework.boot.autoconfigure.data.couchbase.CouchbaseDataAutoConfiguration,\
org.springframework.boot.autoconfigure.data.couchbase.CouchbaseRepositoriesAutoConfiguration,\
org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchAutoConfiguration,\
org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration,\
org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchRepositoriesAutoConfiguration,\
org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration,\
org.springframework.boot.autoconfigure.data.ldap.LdapDataAutoConfiguration,\
org.springframework.boot.autoconfigure.data.ldap.LdapRepositoriesAutoConfiguration,\
org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration,\
org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration,\
org.springframework.boot.autoconfigure.data.neo4j.Neo4jDataAutoConfiguration,\
org.springframework.boot.autoconfigure.data.neo4j.Neo4jRepositoriesAutoConfiguration,\
org.springframework.boot.autoconfigure.data.solr.SolrRepositoriesAutoConfiguration,\
org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration,\
org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration,\
org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration,\
org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration,\
org.springframework.boot.autoconfigure.elasticsearch.jest.JestAutoConfiguration,\
org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration,\
org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration,\
org.springframework.boot.autoconfigure.h2.H2ConsoleAutoConfiguration,\
org.springframework.boot.autoconfigure.hateoas.HypermediaAutoConfiguration,\
org.springframework.boot.autoconfigure.hazelcast.HazelcastAutoConfiguration,\
org.springframework.boot.autoconfigure.hazelcast.HazelcastJpaDependencyAutoConfiguration,\
org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration,\
org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration,\
org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration,\
org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration,\
org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration,\
org.springframework.boot.autoconfigure.jdbc.JndiDataSourceAutoConfiguration,\
org.springframework.boot.autoconfigure.jdbc.XADataSourceAutoConfiguration,\
org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration,\
org.springframework.boot.autoconfigure.jms.JmsAutoConfiguration,\
org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration,\
org.springframework.boot.autoconfigure.jms.JndiConnectionFactoryAutoConfiguration,\
org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration,\
org.springframework.boot.autoconfigure.jms.artemis.ArtemisAutoConfiguration,\
org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration,\
org.springframework.boot.autoconfigure.groovy.template.GroovyTemplateAutoConfiguration,\
org.springframework.boot.autoconfigure.jersey.JerseyAutoConfiguration,\
org.springframework.boot.autoconfigure.jooq.JooqAutoConfiguration,\
org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration,\
org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapAutoConfiguration,\
org.springframework.boot.autoconfigure.ldap.LdapAutoConfiguration,\
org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration,\
org.springframework.boot.autoconfigure.mail.MailSenderAutoConfiguration,\
org.springframework.boot.autoconfigure.mail.MailSenderValidatorAutoConfiguration,\
org.springframework.boot.autoconfigure.mobile.DeviceResolverAutoConfiguration,\
org.springframework.boot.autoconfigure.mobile.DeviceDelegatingViewResolverAutoConfiguration,\
org.springframework.boot.autoconfigure.mobile.SitePreferenceAutoConfiguration,\
org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration,\
org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration,\
org.springframework.boot.autoconfigure.mustache.MustacheAutoConfiguration,\
org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration,\
org.springframework.boot.autoconfigure.reactor.ReactorAutoConfiguration,\
org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration,\
org.springframework.boot.autoconfigure.security.SecurityFilterAutoConfiguration,\
org.springframework.boot.autoconfigure.security.FallbackWebSecurityAutoConfiguration,\
org.springframework.boot.autoconfigure.security.oauth2.OAuth2AutoConfiguration,\
org.springframework.boot.autoconfigure.sendgrid.SendGridAutoConfiguration,\
org.springframework.boot.autoconfigure.session.SessionAutoConfiguration,\
org.springframework.boot.autoconfigure.social.SocialWebAutoConfiguration,\
org.springframework.boot.autoconfigure.social.FacebookAutoConfiguration,\
org.springframework.boot.autoconfigure.social.LinkedInAutoConfiguration,\
org.springframework.boot.autoconfigure.social.TwitterAutoConfiguration,\
org.springframework.boot.autoconfigure.solr.SolrAutoConfiguration,\
org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration,\
org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration,\
org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration,\
org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration,\
org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration,\
org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration,\
org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration,\
org.springframework.boot.autoconfigure.web.HttpEncodingAutoConfiguration,\
org.springframework.boot.autoconfigure.web.HttpMessageConvertersAutoConfiguration,\
org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration,\
org.springframework.boot.autoconfigure.web.ServerPropertiesAutoConfiguration,\
org.springframework.boot.autoconfigure.web.WebClientAutoConfiguration,\
org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration,\
org.springframework.boot.autoconfigure.websocket.WebSocketAutoConfiguration,\
org.springframework.boot.autoconfigure.websocket.WebSocketMessagingAutoConfiguration,\
org.springframework.boot.autoconfigure.webservices.WebServicesAutoConfiguration
```
ÿһ��������  xxxAutoConfiguration�඼�������е�һ������������뵽�����У������������Զ����ã�
3����ÿһ���Զ�����������Զ����ù��ܣ�
4������**HttpEncodingAutoConfiguration��Http�����Զ����ã�**Ϊ�������Զ�����ԭ��
```java
@Configuration   //��ʾ����һ�������࣬��ǰ��д�������ļ�һ����Ҳ���Ը�������������
@EnableConfigurationProperties(HttpEncodingProperties.class)  //����ָ�����ConfigurationProperties���ܣ��������ļ��ж�Ӧ��ֵ��HttpEncodingProperties������������HttpEncodingProperties���뵽ioc������
@ConditionalOnWebApplication //Spring�ײ�@Conditionalע�⣨Springע��棩�����ݲ�ͬ���������������ָ����������������������������þͻ���Ч��    �жϵ�ǰӦ���Ƿ���webӦ�ã�����ǣ���ǰ��������Ч
@ConditionalOnClass(CharacterEncodingFilter.class)  //�жϵ�ǰ��Ŀ��û�������CharacterEncodingFilter��SpringMVC�н����������Ĺ�������
@ConditionalOnProperty(prefix = "spring.http.encoding", value = "enabled", matchIfMissing = true)  //�ж������ļ����Ƿ����ĳ������  spring.http.encoding.enabled����������ڣ��ж�Ҳ�ǳ�����
//��ʹ���������ļ��в�����pring.http.encoding.enabled=true��Ҳ��Ĭ����Ч�ģ�
public class HttpEncodingAutoConfiguration {
  
  	//���Ѿ���SpringBoot�������ļ�ӳ����
  	private final HttpEncodingProperties properties;
  
   //ֻ��һ���вι�����������£�������ֵ�ͻ����������
  	public HttpEncodingAutoConfiguration(HttpEncodingProperties properties) {
		this.properties = properties;
	}
  
    @Bean   //�����������һ���������������ĳЩֵ��Ҫ��properties�л�ȡ
	@ConditionalOnMissingBean(CharacterEncodingFilter.class) //�ж�����û����������
	public CharacterEncodingFilter characterEncodingFilter() {
		CharacterEncodingFilter filter = new OrderedCharacterEncodingFilter();
		filter.setEncoding(this.properties.getCharset().name());
		filter.setForceRequestEncoding(this.properties.shouldForce(Type.REQUEST));
		filter.setForceResponseEncoding(this.properties.shouldForce(Type.RESPONSE));
		return filter;
	}
```
���ݵ�ǰ��ͬ�������жϣ���������������Ƿ���Ч��
һ�������������Ч�����������ͻ����������Ӹ����������Щ����������ǴӶ�Ӧ��properties���л�ȡ�ģ���Щ�������ÿһ���������Ǻ������ļ��󶨵ģ�
5���������������ļ��������õ����Զ�����xxxxProperties���з�װ�ߡ��������ļ�������ʲô�Ϳ��Բ���ĳ�����ܶ�Ӧ�����������
```java
@ConfigurationProperties(prefix = "spring.http.encoding")  //�������ļ��л�ȡָ����ֵ��bean�����Խ��а�
public class HttpEncodingProperties {
   public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
```
**���裺**
?	**1����SpringBoot��������ش������Զ�������**
?	**2�������ǿ�������Ҫ�Ĺ�����û��SpringBootĬ��д�õ��Զ������ࣻ**
?	**3������������������Զ��������е�����������Щ�������ֻҪ����Ҫ�õ�����У����ǾͲ���Ҫ���������ˣ�**
?	**4�������������Զ���������������ʱ�򣬻��properties���л�ȡĳЩ���ԡ����ǾͿ����������ļ���ָ����Щ���Ե�ֵ��**
xxxxAutoConfigurartion���Զ������ࣻ
��������������
xxxxProperties:��װ�����ļ���������ԣ�
### 2��ϸ��
#### 1��@Conditional����ע�⣨Springע���ԭ����@Conditional���ã�
���ã�������@Conditionalָ���������������Ÿ���������������������������������ݲ���Ч��
| @Conditional��չע��                | ���ã��ж��Ƿ����㵱ǰָ��������               |
| ------------------------------- | ------------------------------ |
| @ConditionalOnJava              | ϵͳ��java�汾�Ƿ����Ҫ��                |
| @ConditionalOnBean              | �����д���ָ��Bean��                   |
| @ConditionalOnMissingBean       | �����в�����ָ��Bean��                  |
| @ConditionalOnExpression        | ����SpEL���ʽָ��                    |
| @ConditionalOnClass             | ϵͳ����ָ������                       |
| @ConditionalOnMissingClass      | ϵͳ��û��ָ������                      |
| @ConditionalOnSingleCandidate   | ������ֻ��һ��ָ����Bean���������Bean����ѡBean |
| @ConditionalOnProperty          | ϵͳ��ָ���������Ƿ���ָ����ֵ                |
| @ConditionalOnResource          | ��·�����Ƿ����ָ����Դ�ļ�                 |
| @ConditionalOnWebApplication    | ��ǰ��web����                       |
| @ConditionalOnNotWebApplication | ��ǰ����web����                      |
| @ConditionalOnJndi              | JNDI����ָ����                      |
**�Զ������������һ���������²�����Ч��**
������ô֪����Щ�Զ���������Ч��
**==���ǿ���ͨ������  debug=true���ԣ����ÿ���̨��ӡ�Զ����ñ���==**���������ǾͿ��Ժܷ����֪����Щ�Զ���������Ч��
```java
=========================
AUTO-CONFIGURATION REPORT
=========================
Positive matches:���Զ����������õģ�
-----------------
   DispatcherServletAutoConfiguration matched:
      - @ConditionalOnClass found required class 'org.springframework.web.servlet.DispatcherServlet'; @ConditionalOnMissingClass did not find unwanted class (OnClassCondition)
      - @ConditionalOnWebApplication (required) found StandardServletEnvironment (OnWebApplicationCondition)
        
    
Negative matches:��û��������û��ƥ��ɹ����Զ������ࣩ
-----------------
   ActiveMQAutoConfiguration:
      Did not match:
         - @ConditionalOnClass did not find required classes 'javax.jms.ConnectionFactory', 'org.apache.activemq.ActiveMQConnectionFactory' (OnClassCondition)
   AopAutoConfiguration:
      Did not match:
         - @ConditionalOnClass did not find required classes 'org.aspectj.lang.annotation.Aspect', 'org.aspectj.lang.reflect.Advice' (OnClassCondition)
        
```
# ������־
## 1����־���
 С�ţ�����һ������ϵͳ��
?		1��System.out.println("")�����ؼ����ݴ�ӡ�ڿ���̨��ȥ����д��һ���ļ���
?		2���������¼ϵͳ��һЩ����ʱ��Ϣ����־��� ��  zhanglogging.jar��
?		3���ߴ��ϵļ������ܣ��첽ģʽ���Զ��鵵��xxxx��  zhanglogging-good.jar��
?		4������ǰ���ж�����������µĿ�ܣ������޸�֮ǰ��ص�API��zhanglogging-prefect.jar��
?		5��JDBC---���ݿ�������
?			д��һ��ͳһ�Ľӿڲ㣻��־���棨��־��һ������㣩��logging-abstract.jar��
?			����Ŀ�е���������־ʵ�־����ˣ�����֮ǰ����־��ܶ���ʵ�ֵĳ���㣻
**�����ϵ���־��ܣ�**
JUL��JCL��Jboss-logging��logback��log4j��log4j2��slf4j....
| ��־����  ����־�ĳ���㣩                           | ��־ʵ��                                     |
| ---------------------------------------- | ---------------------------------------- |
| ~~JCL��Jakarta  Commons Logging��~~    SLF4j��Simple  Logging Facade for Java��    **~~jboss-logging~~** | Log4j  JUL��java.util.logging��  Log4j2  **Logback** |
���ѡһ�����棨����㣩���ұ���ѡһ��ʵ�֣�
��־���棺  SLF4J��
��־ʵ�֣�Logback��
SpringBoot���ײ���Spring��ܣ�Spring���Ĭ������JCL����
?	**==SpringBootѡ�� SLF4j��logback��==**
## 2��SLF4jʹ��
### 1�������ϵͳ��ʹ��SLF4j   https://www.slf4j.org
�Ժ󿪷���ʱ����־��¼�����ĵ��ã���Ӧ����ֱ�ӵ�����־��ʵ���࣬���ǵ�����־���������ķ�����
��ϵͳ���浼��slf4j��jar��  logback��ʵ��jar
```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class HelloWorld {
  public static void main(String[] args) {
    Logger logger = LoggerFactory.getLogger(HelloWorld.class);
    logger.info("Hello World");
  }
}
```
ͼʾ��
![images/concrete-bindings.png](images/concrete-bindings.png)
ÿһ����־��ʵ�ֿ�ܶ����Լ��������ļ���ʹ��slf4j�Ժ�**�����ļ�����������־ʵ�ֿ���Լ�����������ļ���**
### 2����������
a��slf4j+logback��: Spring��commons-logging����Hibernate��jboss-logging����MyBatis��xxxx
ͳһ��־��¼����ʹ�Ǳ�Ŀ�ܺ���һ��ͳһʹ��slf4j���������
![](images/legacy.png)
**�����ϵͳ�����е���־��ͳһ��slf4j��**
==1����ϵͳ��������־������ų���ȥ��==
==2�����м�����滻ԭ�е���־��ܣ�==
==3�����ǵ���slf4j������ʵ��==
## 3��SpringBoot��־��ϵ
```xml
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter</artifactId>
		</dependency>
```
SpringBootʹ����������־���ܣ�
```xml
	<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-logging</artifactId>
		</dependency>
```
�ײ�������ϵ
![](images/�ѹ���ͼ20180131220946.png)
�ܽ᣺
?	1����SpringBoot�ײ�Ҳ��ʹ��slf4j+logback�ķ�ʽ������־��¼
?	2����SpringBootҲ����������־���滻����slf4j��
?	3�����м��滻����
```java
@SuppressWarnings("rawtypes")
public abstract class LogFactory {
    static String UNSUPPORTED_OPERATION_IN_JCL_OVER_SLF4J = "http://www.slf4j.org/codes.html#unsupported_operation_in_jcl_over_slf4j";
    static LogFactory logFactory = new SLF4JLogFactory();
```
![](images/�ѹ���ͼ20180131221411.png)
?	4�����������Ҫ����������ܣ�һ��Ҫ�������ܵ�Ĭ����־�����Ƴ�����
?			Spring����õ���commons-logging��
```xml
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-core</artifactId>
			<exclusions>
				<exclusion>
					<groupId>commons-logging</groupId>
					<artifactId>commons-logging</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
```
**==SpringBoot���Զ��������е���־�����ҵײ�ʹ��slf4j+logback�ķ�ʽ��¼��־������������ܵ�ʱ��ֻ��Ҫ����������������־����ų������ɣ�==**
## 4����־ʹ�ã�
### 1��Ĭ������
SpringBootĬ�ϰ��������ú�����־��
```java
	//��¼��
	Logger logger = LoggerFactory.getLogger(getClass());
	@Test
	public void contextLoads() {
		//System.out.println();
		//��־�ļ���
		//�ɵ͵���   trace<debug<info<warn<error
		//���Ե����������־������־��ֻ��������������Ժ�ĸ߼�����Ч
		logger.trace("����trace��־...");
		logger.debug("����debug��־...");
		//SpringBootĬ�ϸ�����ʹ�õ���info����ģ�û��ָ������ľ���SpringBootĬ�Ϲ涨�ļ���root����
		logger.info("����info��־...");
		logger.warn("����warn��־...");
		logger.error("����error��־...");
	}
```
        ��־�����ʽ��
    		%d��ʾ����ʱ�䣬
    		%thread��ʾ�߳�����
    		%-5level�����������ʾ5���ַ����
    		%logger{50} ��ʾlogger�����50���ַ��������վ��ָ 
    		%msg����־��Ϣ��
    		%n�ǻ��з�
        -->
        %d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{50} - %msg%n
SpringBoot�޸���־��Ĭ������
```properties
logging.level.com.atguigu=trace
#logging.path=
# ��ָ��·���ڵ�ǰ��Ŀ������springboot.log��־
# ����ָ��������·����
#logging.file=G:/springboot.log
# �ڵ�ǰ���̵ĸ�·���´���spring�ļ��к������log�ļ��У�ʹ�� spring.log ��ΪĬ���ļ�
logging.path=/spring/log
#  �ڿ���̨�������־�ĸ�ʽ
logging.pattern.console=%d{yyyy-MM-dd} [%thread] %-5level %logger{50} - %msg%n
# ָ���ļ�����־����ĸ�ʽ
logging.pattern.file=%d{yyyy-MM-dd} === [%thread] === %-5level === %logger{50} ==== %msg%n
```
| logging.file | logging.path | Example  | Description             |
| ------------ | ------------ | -------- | ----------------------- |
| (none)       | (none)       |          | ֻ�ڿ���̨���                 |
| ָ���ļ���        | (none)       | my.log   | �����־��my.log�ļ�           |
| (none)       | ָ��Ŀ¼         | /var/log | �����ָ��Ŀ¼�� spring.log �ļ��� |
### 2��ָ������
����·���·���ÿ����־����Լ��������ļ����ɣ�SpringBoot�Ͳ�ʹ����Ĭ�����õ���
| Logging System          | Customization                            |
| ----------------------- | ---------------------------------------- |
| Logback                 | `logback-spring.xml`, `logback-spring.groovy`, `logback.xml` or `logback.groovy` |
| Log4j2                  | `log4j2-spring.xml` or `log4j2.xml`      |
| JDK (Java Util Logging) | `logging.properties`                     |
logback.xml��ֱ�Ӿͱ���־���ʶ���ˣ�
**logback-spring.xml**����־��ܾͲ�ֱ�Ӽ�����־���������SpringBoot������־���ã�����ʹ��SpringBoot�ĸ߼�Profile����
```xml
<springProfile name="staging">
    <!-- configuration to be enabled when the "staging" profile is active -->
  	����ָ��ĳ������ֻ��ĳ����������Ч
</springProfile>
```
�磺
```xml
<appender name="stdout" class="ch.qos.logback.core.ConsoleAppender">
        <!--
        ��־�����ʽ��
			%d��ʾ����ʱ�䣬
			%thread��ʾ�߳�����
			%-5level�����������ʾ5���ַ����
			%logger{50} ��ʾlogger�����50���ַ��������վ��ָ 
			%msg����־��Ϣ��
			%n�ǻ��з�
        -->
        <layout class="ch.qos.logback.classic.PatternLayout">
            <springProfile name="dev">
                <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} ----> [%thread] ---> %-5level %logger{50} - %msg%n</pattern>
            </springProfile>
            <springProfile name="!dev">
                <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} ==== [%thread] ==== %-5level %logger{50} - %msg%n</pattern>
            </springProfile>
        </layout>
    </appender>
```
���ʹ��logback.xml��Ϊ��־�����ļ�����Ҫʹ��profile���ܣ��������´���
 `no applicable action for [springProfile]`
## 5���л���־���
���԰���slf4j����־����ͼ��������ص��л���
slf4j+log4j�ķ�ʽ��
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
  <exclusions>
    <exclusion>
      <artifactId>logback-classic</artifactId>
      <groupId>ch.qos.logback</groupId>
    </exclusion>
    <exclusion>
      <artifactId>log4j-over-slf4j</artifactId>
      <groupId>org.slf4j</groupId>
    </exclusion>
  </exclusions>
</dependency>
<dependency>
  <groupId>org.slf4j</groupId>
  <artifactId>slf4j-log4j12</artifactId>
</dependency>
```
�л�Ϊlog4j2
```xml
   <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <exclusions>
                <exclusion>
                    <artifactId>spring-boot-starter-logging</artifactId>
                    <groupId>org.springframework.boot</groupId>
                </exclusion>
            </exclusions>
        </dependency>
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-log4j2</artifactId>
</dependency>
```
-----------------
# �ġ�Web����
## 1�����
ʹ��SpringBoot��
**1��������SpringBootӦ�ã�ѡ��������Ҫ��ģ�飻**
**2����SpringBoot�Ѿ�Ĭ�Ͻ���Щ�������ú��ˣ�ֻ��Ҫ�������ļ���ָ���������þͿ�����������**
**3�����Լ���дҵ����룻**
**�Զ�����ԭ��**
�������SpringBoot������������ʲô���ܲ����޸ģ����޸���Щ���ã��ܲ�����չ��xxx
```
xxxxAutoConfiguration�������Ǹ��������Զ����������
xxxxProperties:����������װ�����ļ������ݣ�
```
## 2��SpringBoot�Ծ�̬��Դ��ӳ�����
```java
@ConfigurationProperties(prefix = "spring.resources", ignoreUnknownFields = false)
public class ResourceProperties implements ResourceLoaderAware {
  //�������ú;�̬��Դ�йصĲ���������ʱ���
```
```java
	WebMvcAuotConfiguration��
		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			if (!this.resourceProperties.isAddMappings()) {
				logger.debug("Default resource handling disabled");
				return;
			}
			Integer cachePeriod = this.resourceProperties.getCachePeriod();
			if (!registry.hasMappingForPattern("/webjars/**")) {
				customizeResourceHandlerRegistration(
						registry.addResourceHandler("/webjars/**")
								.addResourceLocations(
										"classpath:/META-INF/resources/webjars/")
						.setCachePeriod(cachePeriod));
			}
			String staticPathPattern = this.mvcProperties.getStaticPathPattern();
          	//��̬��Դ�ļ���ӳ��
			if (!registry.hasMappingForPattern(staticPathPattern)) {
				customizeResourceHandlerRegistration(
						registry.addResourceHandler(staticPathPattern)
								.addResourceLocations(
										this.resourceProperties.getStaticLocations())
						.setCachePeriod(cachePeriod));
			}
		}
        //���û�ӭҳӳ��
		@Bean
		public WelcomePageHandlerMapping welcomePageHandlerMapping(
				ResourceProperties resourceProperties) {
			return new WelcomePageHandlerMapping(resourceProperties.getWelcomePage(),
					this.mvcProperties.getStaticPathPattern());
		}
       //����ϲ����ͼ��
		@Configuration
		@ConditionalOnProperty(value = "spring.mvc.favicon.enabled", matchIfMissing = true)
		public static class FaviconConfiguration {
			private final ResourceProperties resourceProperties;
			public FaviconConfiguration(ResourceProperties resourceProperties) {
				this.resourceProperties = resourceProperties;
			}
			@Bean
			public SimpleUrlHandlerMapping faviconHandlerMapping() {
				SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
				mapping.setOrder(Ordered.HIGHEST_PRECEDENCE + 1);
              	//����  **/favicon.ico 
				mapping.setUrlMap(Collections.singletonMap("**/favicon.ico",
						faviconRequestHandler()));
				return mapping;
			}
			@Bean
			public ResourceHttpRequestHandler faviconRequestHandler() {
				ResourceHttpRequestHandler requestHandler = new ResourceHttpRequestHandler();
				requestHandler
						.setLocations(this.resourceProperties.getFaviconLocations());
				return requestHandler;
			}
		}
```
==1�������� /webjars/** ����ȥ classpath:/META-INF/resources/webjars/ ����Դ��==
?	webjars����jar���ķ�ʽ���뾲̬��Դ��
http://www.webjars.org/
![](images/�ѹ���ͼ20180203181751.png)
localhost:8080/webjars/jquery/3.3.1/jquery.js
```xml
<!--����jquery-webjar-->�ڷ��ʵ�ʱ��ֻ��Ҫдwebjars������Դ�����Ƽ���
		<dependency>
			<groupId>org.webjars</groupId>
			<artifactId>jquery</artifactId>
			<version>3.3.1</version>
		</dependency>
```
==2����"/**" ���ʵ�ǰ��Ŀ���κ���Դ����ȥ����̬��Դ���ļ��У���ӳ��==
```
"classpath:/META-INF/resources/", 
"classpath:/resources/",
"classpath:/static/", 
"classpath:/public/" 
"/"����ǰ��Ŀ�ĸ�·��
```
localhost:8080/abc ===  ȥ��̬��Դ�ļ���������abc
==3������ӭҳ�� ��̬��Դ�ļ����µ�����index.htmlҳ�棻��"/**"ӳ�䣻==
?	localhost:8080/   ��indexҳ��
==4�������е� **/favicon.ico  �����ھ�̬��Դ�ļ����ң�==
## 3��ģ������
JSP��Velocity��Freemarker��Thymeleaf
![](images/template-engine.png)
SpringBoot�Ƽ���Thymeleaf��
�﷨���򵥣����ܸ�ǿ��
### 1������thymeleaf��
```xml
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-thymeleaf</artifactId>
          	2.1.6
		</dependency>
�л�thymeleaf�汾
<properties>
		<thymeleaf.version>3.0.9.RELEASE</thymeleaf.version>
		<!-- ���ֹ��ܵ�֧�ֳ���  thymeleaf3������  layout2���ϰ汾 -->
		<!-- thymeleaf2   layout1-->
		<thymeleaf-layout-dialect.version>2.2.2</thymeleaf-layout-dialect.version>
  </properties>
```
### 2��Thymeleafʹ��
```java
@ConfigurationProperties(prefix = "spring.thymeleaf")
public class ThymeleafProperties {
	private static final Charset DEFAULT_ENCODING = Charset.forName("UTF-8");
	private static final MimeType DEFAULT_CONTENT_TYPE = MimeType.valueOf("text/html");
	public static final String DEFAULT_PREFIX = "classpath:/templates/";
	public static final String DEFAULT_SUFFIX = ".html";
  	//
```
ֻҪ���ǰ�HTMLҳ�����classpath:/templates/��thymeleaf�����Զ���Ⱦ��
ʹ�ã�
1������thymeleaf�����ƿռ�
```xml
<html lang="en" xmlns:th="http://www.thymeleaf.org">
```
2��ʹ��thymeleaf�﷨��
```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <h1>�ɹ���</h1>
    <!--th:text ��div������ı���������Ϊ -->
    <div th:text="${hello}">������ʾ��ӭ��Ϣ</div>
</body>
</html>
```
### 3���﷨����
1����th:text���ı䵱ǰԪ��������ı����ݣ�
?	th������html���ԣ����滻ԭ�����Ե�ֵ
![](images/2018-02-04_123955.png)
2�������ʽ��
```properties
Simple expressions:�����ʽ�﷨��
    Variable Expressions: ${...}����ȡ����ֵ��OGNL��
    		1������ȡ��������ԡ����÷���
    		2����ʹ�����õĻ�������
    			#ctx : the context object.
    			#vars: the context variables.
                #locale : the context locale.
                #request : (only in Web Contexts) the HttpServletRequest object.
                #response : (only in Web Contexts) the HttpServletResponse object.
                #session : (only in Web Contexts) the HttpSession object.
                #servletContext : (only in Web Contexts) the ServletContext object.
                
                ${session.foo}
            3�������õ�һЩ���߶���
#execInfo : information about the template being processed.
#messages : methods for obtaining externalized messages inside variables expressions, in the same way as they would be obtained using #{��} syntax.
#uris : methods for escaping parts of URLs/URIs
#conversions : methods for executing the configured conversion service (if any).
#dates : methods for java.util.Date objects: formatting, component extraction, etc.
#calendars : analogous to #dates , but for java.util.Calendar objects.
#numbers : methods for formatting numeric objects.
#strings : methods for String objects: contains, startsWith, prepending/appending, etc.
#objects : methods for objects in general.
#bools : methods for boolean evaluation.
#arrays : methods for arrays.
#lists : methods for lists.
#sets : methods for sets.
#maps : methods for maps.
#aggregates : methods for creating aggregates on arrays or collections.
#ids : methods for dealing with id attributes that might be repeated (for example, as a result of an iteration).
    Selection Variable Expressions: *{...}��ѡ����ʽ����${}�ڹ�������һ����
    	���䣺��� th:object="${session.user}��
   <div th:object="${session.user}">
    <p>Name: <span th:text="*{firstName}">Sebastian</span>.</p>
    <p>Surname: <span th:text="*{lastName}">Pepper</span>.</p>
    <p>Nationality: <span th:text="*{nationality}">Saturn</span>.</p>
    </div>
    
    Message Expressions: #{...}����ȡ���ʻ�����
    Link URL Expressions: @{...}������URL��
    		@{/order/process(execId=${execId},execType='FAST')}
    Fragment Expressions: ~{...}��Ƭ�����ñ��ʽ
    		<div th:insert="~{commons :: main}">...</div>
    		
Literals����������
      Text literals: 'one text' , 'Another one!' ,��
      Number literals: 0 , 34 , 3.0 , 12.3 ,��
      Boolean literals: true , false
      Null literal: null
      Literal tokens: one , sometext , main ,��
Text operations:���ı�������
    String concatenation: +
    Literal substitutions: |The name is ${name}|
Arithmetic operations:����ѧ���㣩
    Binary operators: + , - , * , / , %
    Minus sign (unary operator): -
Boolean operations:���������㣩
    Binary operators: and , or
    Boolean negation (unary operator): ! , not
Comparisons and equality:���Ƚ����㣩
    Comparators: > , < , >= , <= ( gt , lt , ge , le )
    Equality operators: == , != ( eq , ne )
Conditional operators:�������㣨��Ԫ�������
    If-then: (if) ? (then)
    If-then-else: (if) ? (then) : (else)
    Default: (value) ?: (defaultvalue)
Special tokens:
    No-Operation: _ 
```
## 4��SpringMVC�Զ�����
https://docs.spring.io/spring-boot/docs/1.5.10.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications
### 1. Spring MVC auto-configuration
Spring Boot �Զ����ú���SpringMVC
������SpringBoot��SpringMVC��Ĭ������:**==��WebMvcAutoConfiguration��==**
- Inclusion of `ContentNegotiatingViewResolver` and `BeanNameViewResolver` beans.
  - �Զ�������ViewResolver����ͼ�����������ݷ����ķ���ֵ�õ���ͼ����View������ͼ������������Ⱦ��ת�����ض��򣿣���
  - ContentNegotiatingViewResolver��������е���ͼ�������ģ�
  - ==��ζ��ƣ����ǿ����Լ������������һ����ͼ���������Զ��Ľ�����Ͻ�����==
- Support for serving static resources, including support for WebJars (see below).��̬��Դ�ļ���·��,webjars
- Static `index.html` support. ��̬��ҳ����
- Custom `Favicon` support (see below).  favicon.ico
  ?
- �Զ�ע���� of `Converter`, `GenericConverter`, `Formatter` beans.
  - Converter��ת������  public String hello(User user)������ת��ʹ��Converter
  - `Formatter`  ��ʽ������  2017.12.17===Date��
```java
		@Bean
		@ConditionalOnProperty(prefix = "spring.mvc", name = "date-format")//���ļ����������ڸ�ʽ���Ĺ���
		public Formatter<Date> dateFormatter() {
			return new DateFormatter(this.mvcProperties.getDateFormat());//���ڸ�ʽ�����
		}
```
?	==�Լ���ӵĸ�ʽ����ת����������ֻ��Ҫ���������м���==
- Support for `HttpMessageConverters` (see below).
  - HttpMessageConverter��SpringMVC����ת��Http�������Ӧ�ģ�User---Json��
  - `HttpMessageConverters` �Ǵ�������ȷ������ȡ���е�HttpMessageConverter��
    ==�Լ������������HttpMessageConverter��ֻ��Ҫ���Լ������ע�������У�@Bean,@Component��==
    ?
- Automatic registration of `MessageCodesResolver` (see below).�������������ɹ���
- Automatic use of a `ConfigurableWebBindingInitializer` bean (see below).
  ==���ǿ�������һ��ConfigurableWebBindingInitializer���滻Ĭ�ϵģ�����ӵ�������==
  ```
  ��ʼ��WebDataBinder��
  ��������=====JavaBean��
  ```
**org.springframework.boot.autoconfigure.web��web�������Զ�������**
If you want to keep Spring Boot MVC features, and you just want to add additional [MVC configuration](https://docs.spring.io/spring/docs/4.3.14.RELEASE/spring-framework-reference/htmlsingle#mvc) (interceptors, formatters, view controllers etc.) you can add your own `@Configuration` class of type `WebMvcConfigurerAdapter`, but **without** `@EnableWebMvc`. If you wish to provide custom instances of `RequestMappingHandlerMapping`, `RequestMappingHandlerAdapter` or `ExceptionHandlerExceptionResolver` you can declare a `WebMvcRegistrationsAdapter` instance providing such components.
If you want to take complete control of Spring MVC, you can add your own `@Configuration` annotated with `@EnableWebMvc`.
### 2����չSpringMVC
```xml
    <mvc:view-controller path="/hello" view-name="success"/>
    <mvc:interceptors>
        <mvc:interceptor>
            <mvc:mapping path="/hello"/>
            <bean></bean>
        </mvc:interceptor>
    </mvc:interceptors>
```
**==��дһ�������ࣨ@Configuration������WebMvcConfigurerAdapter���ͣ����ܱ�ע@EnableWebMvc==**;
�ȱ��������е��Զ����ã�Ҳ����������չ�����ã�
```java
//ʹ��WebMvcConfigurerAdapter��������չSpringMVC�Ĺ���
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
       // super.addViewControllers(registry);
        //��������� /atguigu �������� success
        registry.addViewController("/atguigu").setViewName("success");
    }
}
```
ԭ��
?	1����WebMvcAutoConfiguration��SpringMVC���Զ�������
?	2�������������Զ�����ʱ�ᵼ�룻@Import(**EnableWebMvcConfiguration**.class)
```java
    @Configuration
	public static class EnableWebMvcConfiguration extends DelegatingWebMvcConfiguration {
      private final WebMvcConfigurerComposite configurers = new WebMvcConfigurerComposite();
	 //�������л�ȡ���е�WebMvcConfigurer
      @Autowired(required = false)
      public void setConfigurers(List<WebMvcConfigurer> configurers) {
          if (!CollectionUtils.isEmpty(configurers)) {
              this.configurers.addWebMvcConfigurers(configurers);
            	//һ���ο�ʵ�֣������е�WebMvcConfigurer������ö���һ����ã�  
            	@Override
             // public void addViewControllers(ViewControllerRegistry registry) {
              //    for (WebMvcConfigurer delegate : this.delegates) {
               //       delegate.addViewControllers(registry);
               //   }
              }
          }
	}
```
?	3�������������е�WebMvcConfigurer����һ�������ã�
?	4�������ǵ�������Ҳ�ᱻ���ã�
?	Ч����SpringMVC���Զ����ú����ǵ���չ���ö��������ã�
### 3��ȫ��ӹ�SpringMVC��
SpringBoot��SpringMVC���Զ����ò���Ҫ�ˣ����ж��������Լ����ã����е�SpringMVC���Զ����ö�ʧЧ��
**������Ҫ�������������@EnableWebMvc���ɣ�**
```java
//ʹ��WebMvcConfigurerAdapter��������չSpringMVC�Ĺ���
@EnableWebMvc
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
       // super.addViewControllers(registry);
        //��������� /atguigu �������� success
        registry.addViewController("/atguigu").setViewName("success");
    }
}
```
ԭ��
Ϊʲô@EnableWebMvc�Զ����þ�ʧЧ�ˣ�
1��@EnableWebMvc�ĺ���
```java
@Import(DelegatingWebMvcConfiguration.class)
public @interface EnableWebMvc {
```
2����
```java
@Configuration
public class DelegatingWebMvcConfiguration extends WebMvcConfigurationSupport {
```
3����
```java
@Configuration
@ConditionalOnWebApplication
@ConditionalOnClass({ Servlet.class, DispatcherServlet.class,
		WebMvcConfigurerAdapter.class })
//������û����������ʱ������Զ����������Ч
@ConditionalOnMissingBean(WebMvcConfigurationSupport.class)
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE + 10)
@AutoConfigureAfter({ DispatcherServletAutoConfiguration.class,
		ValidationAutoConfiguration.class })
public class WebMvcAutoConfiguration {
```
4����@EnableWebMvc��WebMvcConfigurationSupport������������
5���������WebMvcConfigurationSupportֻ��SpringMVC������Ĺ��ܣ�
## 5������޸�SpringBoot��Ĭ������
ģʽ��
?	1����SpringBoot���Զ����úܶ������ʱ���ȿ���������û���û��Լ����õģ�@Bean��@Component������о����û����õģ����û�У����Զ����ã������Щ��������ж����ViewResolver�����û����õĺ��Լ�Ĭ�ϵ����������
?	2������SpringBoot�л��зǳ����xxxConfigurer�������ǽ�����չ����
?	3������SpringBoot�л��кܶ��xxxCustomizer�������ǽ��ж�������
## 6��RestfulCRUD
### 1����Ĭ�Ϸ�����ҳ
```java
//ʹ��WebMvcConfigurerAdapter��������չSpringMVC�Ĺ���
//@EnableWebMvc   ��Ҫ�ӹ�SpringMVC
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
       // super.addViewControllers(registry);
        //��������� /atguigu �������� success
        registry.addViewController("/atguigu").setViewName("success");
    }
    //���е�WebMvcConfigurerAdapter�������һ��������
    @Bean //�����ע��������
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
            }
        };
        return adapter;
    }
}
```
### 2�������ʻ�
**1������д���ʻ������ļ���**
2����ʹ��ResourceBundleMessageSource������ʻ���Դ�ļ�
3������ҳ��ʹ��fmt:messageȡ�����ʻ�����
���裺
1������д���ʻ������ļ�����ȡҳ����Ҫ��ʾ�Ĺ��ʻ���Ϣ
![](images/�ѹ���ͼ20180211130721.png)
2����SpringBoot�Զ����ú��˹�����ʻ���Դ�ļ��������
```java
@ConfigurationProperties(prefix = "spring.messages")
public class MessageSourceAutoConfiguration {
    
    /**
	 * Comma-separated list of basenames (essentially a fully-qualified classpath
	 * location), each following the ResourceBundle convention with relaxed support for
	 * slash based locations. If it doesn't contain a package qualifier (such as
	 * "org.mypackage"), it will be resolved from the classpath root.
	 */
	private String basename = "messages";  
    //���ǵ������ļ�����ֱ�ӷ�����·���½�messages.properties��
    
    @Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		if (StringUtils.hasText(this.basename)) {
            //���ù��ʻ���Դ�ļ��Ļ�������ȥ�����Թ��Ҵ���ģ�
			messageSource.setBasenames(StringUtils.commaDelimitedListToStringArray(
					StringUtils.trimAllWhitespace(this.basename)));
		}
		if (this.encoding != null) {
			messageSource.setDefaultEncoding(this.encoding.name());
		}
		messageSource.setFallbackToSystemLocale(this.fallbackToSystemLocale);
		messageSource.setCacheSeconds(this.cacheSeconds);
		messageSource.setAlwaysUseMessageFormat(this.alwaysUseMessageFormat);
		return messageSource;
	}
```
3����ȥҳ���ȡ���ʻ���ֵ��
![](images/�ѹ���ͼ20180211134506.png)
```html
<!DOCTYPE html>
<html lang="en"  xmlns:th="http://www.thymeleaf.org">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="">
		<title>Signin Template for Bootstrap</title>
		<!-- Bootstrap core CSS -->
		<link href="asserts/css/bootstrap.min.css" th:href="@{/webjars/bootstrap/4.0.0/css/bootstrap.css}" rel="stylesheet">
		<!-- Custom styles for this template -->
		<link href="asserts/css/signin.css" th:href="@{/asserts/css/signin.css}" rel="stylesheet">
	</head>
	<body class="text-center">
		<form class="form-signin" action="dashboard.html">
			<img class="mb-4" th:src="@{/asserts/img/bootstrap-solid.svg}" src="asserts/img/bootstrap-solid.svg" alt="" width="72" height="72">
			<h1 class="h3 mb-3 font-weight-normal" th:text="#{login.tip}">Please sign in</h1>
			<label class="sr-only" th:text="#{login.username}">Username</label>
			<input type="text" class="form-control" placeholder="Username" th:placeholder="#{login.username}" required="" autofocus="">
			<label class="sr-only" th:text="#{login.password}">Password</label>
			<input type="password" class="form-control" placeholder="Password" th:placeholder="#{login.password}" required="">
			<div class="checkbox mb-3">
				<label>
          		<input type="checkbox" value="remember-me"/> [[#{login.remember}]]
        </label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit" th:text="#{login.btn}">Sign in</button>
			<p class="mt-5 mb-3 text-muted">? 2017-2018</p>
			<a class="btn btn-sm">����</a>
			<a class="btn btn-sm">English</a>
		</form>
	</body>
</html>
```
Ч��������������������õ���Ϣ�л��˹��ʻ���
ԭ��
?	���ʻ�Locale��������Ϣ���󣩣�LocaleResolver����ȡ������Ϣ���󣩣�
```java
		@Bean
		@ConditionalOnMissingBean
		@ConditionalOnProperty(prefix = "spring.mvc", name = "locale")
		public LocaleResolver localeResolver() {
			if (this.mvcProperties
					.getLocaleResolver() == WebMvcProperties.LocaleResolver.FIXED) {
				return new FixedLocaleResolver(this.mvcProperties.getLocale());
			}
			AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
			localeResolver.setDefaultLocale(this.mvcProperties.getLocale());
			return localeResolver;
		}
Ĭ�ϵľ��Ǹ�������ͷ������������Ϣ��ȡLocale���й��ʻ�
```
4������������л����ʻ�
```java
/**
 * ������������Я��������Ϣ
 */
public class MyLocaleResolver implements LocaleResolver {
    
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("l");
        Locale locale = Locale.getDefault();
        if(!StringUtils.isEmpty(l)){
            String[] split = l.split("_");
            locale = new Locale(split[0],split[1]);
        }
        return locale;
    }
    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
    }
}
 @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
```
### 3������½
�����ڼ�ģ������ҳ���޸��Ժ�Ҫʵʱ��Ч
1��������ģ������Ļ���
```
# ���û���
spring.thymeleaf.cache=false 
```
2����ҳ���޸�����Ժ�ctrl+f9�����±��룻
��½������Ϣ����ʾ
```html
<p style="color: red" th:text="${msg}" th:if="${not #strings.isEmpty(msg)}"></p>
```
### 4�������������е�½���
������
```java
/**
 * ��½��飬
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    //Ŀ�귽��ִ��֮ǰ
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        if(user == null){
            //δ��½�����ص�½ҳ��
            request.setAttribute("msg","û��Ȩ�����ȵ�½");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else{
            //�ѵ�½����������
            return true;
        }
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
```
ע��������
```java
  //���е�WebMvcConfigurerAdapter�������һ��������
    @Bean //�����ע��������
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }
            //ע��������
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //super.addInterceptors(registry);
                //��̬��Դ��  *.css , *.js
                //SpringBoot�Ѿ������˾�̬��Դӳ��
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html","/","/user/login");
            }
        };
        return adapter;
    }
```
### 5����CRUD-Ա���б�
ʵ��Ҫ��
1����RestfulCRUD��CRUD����Rest���
URI��  /��Դ����/��Դ��ʶ       HTTP����ʽ���ֶ���ԴCRUD����
|      | ��ͨCRUD��uri�����ֲ����� | RestfulCRUD       |
| ---- | ------------------------- | ----------------- |
| ��ѯ | getEmp                    | emp---GET         |
| ��� | addEmp?xxx                | emp---POST        |
| �޸� | updateEmp?id=xxx&xxx=xx   | emp/{id}---PUT    |
| ɾ�� | deleteEmp?id=1            | emp/{id}---DELETE |
2����ʵ�������ܹ�;
| ʵ�鹦��                             | ����URI | ����ʽ |
| ------------------------------------ | ------- | -------- |
| ��ѯ����Ա��                         | emps    | GET      |
| ��ѯĳ��Ա��(�����޸�ҳ��)           | emp/1   | GET      |
| �������ҳ��                         | emp     | GET      |
| ���Ա��                             | emp     | POST     |
| �����޸�ҳ�棨���Ա��������Ϣ���ԣ� | emp/1   | GET      |
| �޸�Ա��                             | emp     | PUT      |
| ɾ��Ա��                             | emp/1   | DELETE   |
3����Ա���б�
#### thymeleaf����ҳ��Ԫ�س�ȡ
```html
1����ȡ����Ƭ��
<div th:fragment="copy">
&copy; 2011 The Good Thymes Virtual Grocery
</div>
2�����빫��Ƭ��
<div th:insert="~{footer :: copy}"></div>
~{templatename::selector}��ģ����::ѡ����
~{templatename::fragmentname}:ģ����::Ƭ����
3��Ĭ��Ч����
insert�Ĺ���Ƭ����div��ǩ��
���ʹ��th:insert�����Խ������룬���Բ���д~{}��
����д�����Լ��ϣ�[[~{}]];[(~{})]��
```
�������빫��Ƭ�ε�th���ԣ�
**th:insert**��������Ƭ���������뵽���������Ԫ����
**th:replace**�������������Ԫ���滻Ϊ����Ƭ��
**th:include**�����������Ƭ�ε����ݰ����������ǩ��
```html
<footer th:fragment="copy">
&copy; 2011 The Good Thymes Virtual Grocery
</footer>
���뷽ʽ
<div th:insert="footer :: copy"></div>
<div th:replace="footer :: copy"></div>
<div th:include="footer :: copy"></div>
Ч��
<div>
    <footer>
    &copy; 2011 The Good Thymes Virtual Grocery
    </footer>
</div>
<footer>
&copy; 2011 The Good Thymes Virtual Grocery
</footer>
<div>
&copy; 2011 The Good Thymes Virtual Grocery
</div>
```
����Ƭ�ε�ʱ��������� 
```html
<nav class="col-md-2 d-none d-md-block bg-light sidebar" id="sidebar">
    <div class="sidebar-sticky">
        <ul class="nav flex-column">
            <li class="nav-item">
                <a class="nav-link active"
                   th:class="${activeUri=='main.html'?'nav-link active':'nav-link'}"
                   href="#" th:href="@{/main.html}">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-home">
                        <path d="M3 9l9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z"></path>
                        <polyline points="9 22 9 12 15 12 15 22"></polyline>
                    </svg>
                    Dashboard <span class="sr-only">(current)</span>
                </a>
            </li>
<!--��������;�������-->
<div th:replace="commons/bar::#sidebar(activeUri='emps')"></div>
```
### 6����CRUD-Ա�����
���ҳ��
```html
<form>
    <div class="form-group">
        <label>LastName</label>
        <input type="text" class="form-control" placeholder="zhangsan">
    </div>
    <div class="form-group">
        <label>Email</label>
        <input type="email" class="form-control" placeholder="zhangsan@atguigu.com">
    </div>
    <div class="form-group">
        <label>Gender</label><br/>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="gender"  value="1">
            <label class="form-check-label">��</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="gender"  value="0">
            <label class="form-check-label">Ů</label>
        </div>
    </div>
    <div class="form-group">
        <label>department</label>
        <select class="form-control">
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
        </select>
    </div>
    <div class="form-group">
        <label>Birth</label>
        <input type="text" class="form-control" placeholder="zhangsan">
    </div>
    <button type="submit" class="btn btn-primary">���</button>
</form>
```
�ύ�����ݸ�ʽ���ԣ����գ����ڣ�
2017-12-12��2017/12/12��2017.12.12��
���ڵĸ�ʽ����SpringMVC��ҳ���ύ��ֵ��Ҫת��Ϊָ��������;
2017-12-12---Date�� ����ת������ʽ��;
Ĭ�������ǰ���/�ķ�ʽ��
### 7����CRUD-Ա���޸�
�޸���Ӷ���һ��
```html
<!--��Ҫ������Ա���޸Ļ�����ӣ�-->
<form th:action="@{/emp}" method="post">
    <!--����put�����޸�Ա������-->
    <!--
1��SpringMVC������HiddenHttpMethodFilter;��SpringBoot�Զ����úõģ�
2��ҳ�洴��һ��post��
3������һ��input�name="_method";ֵ��������ָ��������ʽ
-->
    <input type="hidden" name="_method" value="put" th:if="${emp!=null}"/>
    <input type="hidden" name="id" th:if="${emp!=null}" th:value="${emp.id}">
    <div class="form-group">
        <label>LastName</label>
        <input name="lastName" type="text" class="form-control" placeholder="zhangsan" th:value="${emp!=null}?${emp.lastName}">
    </div>
    <div class="form-group">
        <label>Email</label>
        <input name="email" type="email" class="form-control" placeholder="zhangsan@atguigu.com" th:value="${emp!=null}?${emp.email}">
    </div>
    <div class="form-group">
        <label>Gender</label><br/>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="gender" value="1" th:checked="${emp!=null}?${emp.gender==1}">
            <label class="form-check-label">��</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="gender" value="0" th:checked="${emp!=null}?${emp.gender==0}">
            <label class="form-check-label">Ů</label>
        </div>
    </div>
    <div class="form-group">
        <label>department</label>
        <!--�ύ���ǲ��ŵ�id-->
        <select class="form-control" name="department.id">
            <option th:selected="${emp!=null}?${dept.id == emp.department.id}" th:value="${dept.id}" th:each="dept:${depts}" th:text="${dept.departmentName}">1</option>
        </select>
    </div>
    <div class="form-group">
        <label>Birth</label>
        <input name="birth" type="text" class="form-control" placeholder="zhangsan" th:value="${emp!=null}?${#dates.format(emp.birth, 'yyyy-MM-dd HH:mm')}">
    </div>
    <button type="submit" class="btn btn-primary" th:text="${emp!=null}?'�޸�':'���'">���</button>
</form>
```
### 8����CRUD-Ա��ɾ��
```html
<tr th:each="emp:${emps}">
    <td th:text="${emp.id}"></td>
    <td>[[${emp.lastName}]]</td>
    <td th:text="${emp.email}"></td>
    <td th:text="${emp.gender}==0?'Ů':'��'"></td>
    <td th:text="${emp.department.departmentName}"></td>
    <td th:text="${#dates.format(emp.birth, 'yyyy-MM-dd HH:mm')}"></td>
    <td>
        <a class="btn btn-sm btn-primary" th:href="@{/emp/}+${emp.id}">�༭</a>
        <button th:attr="del_uri=@{/emp/}+${emp.id}" class="btn btn-sm btn-danger deleteBtn">ɾ��</button>
    </td>
</tr>
<script>
    $(".deleteBtn").click(function(){
        //ɾ����ǰԱ����
        $("#deleteEmpForm").attr("action",$(this).attr("del_uri")).submit();
        return false;
    });
</script>
```
## 7�����������
### 1����SpringBootĬ�ϵĴ��������
Ĭ��Ч����
?		1���������������һ��Ĭ�ϵĴ���ҳ��
![](images/�ѹ���ͼ20180226173408.png)
  ������������������ͷ��
![](images/�ѹ���ͼ20180226180347.png)
?		2��������������ͻ��ˣ�Ĭ����Ӧһ��json����
![](images/�ѹ���ͼ20180226173527.png)
?		![](images/�ѹ���ͼ20180226180504.png)
ԭ��
?	���Բ���ErrorMvcAutoConfiguration����������Զ����ã�
  	��������������������
?	1��DefaultErrorAttributes��
```java
��������ҳ�湲����Ϣ��
@Override
	public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes,
			boolean includeStackTrace) {
		Map<String, Object> errorAttributes = new LinkedHashMap<String, Object>();
		errorAttributes.put("timestamp", new Date());
		addStatus(errorAttributes, requestAttributes);
		addErrorDetails(errorAttributes, requestAttributes, includeStackTrace);
		addPath(errorAttributes, requestAttributes);
		return errorAttributes;
	}
```
?	2��BasicErrorController������Ĭ��/error����
```java
@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")
public class BasicErrorController extends AbstractErrorController {
    
    @RequestMapping(produces = "text/html")//����html���͵����ݣ���������͵��������������������
	public ModelAndView errorHtml(HttpServletRequest request,
			HttpServletResponse response) {
		HttpStatus status = getStatus(request);
		Map<String, Object> model = Collections.unmodifiableMap(getErrorAttributes(
				request, isIncludeStackTrace(request, MediaType.TEXT_HTML)));
		response.setStatus(status.value());
        
        //ȥ�ĸ�ҳ����Ϊ����ҳ�棻����ҳ���ַ��ҳ������
		ModelAndView modelAndView = resolveErrorView(request, response, status, model);
		return (modelAndView == null ? new ModelAndView("error", model) : modelAndView);
	}
	@RequestMapping
	@ResponseBody    //����json���ݣ������ͻ������������������
	public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
		Map<String, Object> body = getErrorAttributes(request,
				isIncludeStackTrace(request, MediaType.ALL));
		HttpStatus status = getStatus(request);
		return new ResponseEntity<Map<String, Object>>(body, status);
	}
```
?	3��ErrorPageCustomizer��
```java
	@Value("${error.path:/error}")
	private String path = "/error";  ϵͳ���ִ����Ժ�����error������д�����web.xmlע��Ĵ���ҳ�����
```
?	4��DefaultErrorViewResolver��
```java
@Override
	public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status,
			Map<String, Object> model) {
		ModelAndView modelAndView = resolve(String.valueOf(status), model);
		if (modelAndView == null && SERIES_VIEWS.containsKey(status.series())) {
			modelAndView = resolve(SERIES_VIEWS.get(status.series()), model);
		}
		return modelAndView;
	}
	private ModelAndView resolve(String viewName, Map<String, Object> model) {
        //Ĭ��SpringBoot����ȥ�ҵ�һ��ҳ�棿  error/404
		String errorViewName = "error/" + viewName;
        
        //ģ��������Խ������ҳ���ַ����ģ���������
		TemplateAvailabilityProvider provider = this.templateAvailabilityProviders
				.getProvider(errorViewName, this.applicationContext);
		if (provider != null) {
            //ģ��������õ�����·��ص�errorViewNameָ������ͼ��ַ
			return new ModelAndView(errorViewName, model);
		}
        //ģ�����治���ã����ھ�̬��Դ�ļ�������errorViewName��Ӧ��ҳ��   error/404.html
		return resolveResource(errorViewName, model);
	}
```
?	���裺
?		һ��ϵͳ����4xx����5xx֮��Ĵ���ErrorPageCustomizer�ͻ���Ч�����ƴ������Ӧ���򣩣��ͻ�����/error���󣻾ͻᱻ**BasicErrorController**����
?		1����Ӧҳ�棻ȥ�ĸ�ҳ������**DefaultErrorViewResolver**�����õ��ģ�
```java
protected ModelAndView resolveErrorView(HttpServletRequest request,
      HttpServletResponse response, HttpStatus status, Map<String, Object> model) {
    //���е�ErrorViewResolver�õ�ModelAndView
   for (ErrorViewResolver resolver : this.errorViewResolvers) {
      ModelAndView modelAndView = resolver.resolveErrorView(request, status, model);
      if (modelAndView != null) {
         return modelAndView;
      }
   }
   return null;
}
```
### 2����������ƴ�����Ӧ��
#### 	**1������ζ��ƴ����ҳ�棻**
?			**1������ģ�����������£�error/״̬��;** ��������ҳ������Ϊ  ����״̬��.html ����ģ�������ļ�������� error�ļ����¡���������״̬��Ĵ���ͻ�����  ��Ӧ��ҳ�棻
?			���ǿ���ʹ��4xx��5xx��Ϊ����ҳ����ļ�����ƥ���������͵����д��󣬾�ȷ���ȣ�����Ѱ�Ҿ�ȷ��״̬��.html����		
?			ҳ���ܻ�ȡ����Ϣ��
?				timestamp��ʱ���
?				status��״̬��
?				error��������ʾ
?				exception���쳣����
?				message���쳣��Ϣ
?				errors��JSR303����У��Ĵ���������
?			2����û��ģ�����棨ģ�������Ҳ����������ҳ�棩����̬��Դ�ļ������ң�
?			3�������϶�û�д���ҳ�棬����Ĭ������SpringBootĬ�ϵĴ�����ʾҳ�棻
#### 	2������ζ��ƴ����json���ݣ�
?		1�����Զ����쳣����&���ض���json���ݣ�
```java
@ControllerAdvice
public class MyExceptionHandler {
    @ResponseBody
    @ExceptionHandler(UserNotExistException.class)
    public Map<String,Object> handleException(Exception e){
        Map<String,Object> map = new HashMap<>();
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        return map;
    }
}
//û������ӦЧ��...
```
?		2����ת����/error��������Ӧ��ӦЧ������
```java
 @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        //���������Լ��Ĵ���״̬��  4xx 5xx������Ͳ�����붨�ƴ���ҳ��Ľ�������
        /**
         * Integer statusCode = (Integer) request
         .getAttribute("javax.servlet.error.status_code");
         */
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        //ת����/error
        return "forward:/error";
    }
```
#### 	3���������ǵĶ�������Я����ȥ��
���ִ����Ժ󣬻�����/error���󣬻ᱻBasicErrorController������Ӧ��ȥ���Ի�ȡ����������getErrorAttributes�õ��ģ���AbstractErrorController��ErrorController���涨�ķ�������
?	1����ȫ����дһ��ErrorController��ʵ���ࡾ�����Ǳ�дAbstractErrorController�����ࡿ�����������У�
?	2��ҳ�������õ����ݣ�������json�������õ����ݶ���ͨ��errorAttributes.getErrorAttributes�õ���
?			������DefaultErrorAttributes.getErrorAttributes()��Ĭ�Ͻ������ݴ���ģ�
�Զ���ErrorAttributes
```java
//�������м��������Լ������ErrorAttributes
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(requestAttributes, includeStackTrace);
        map.put("company","atguigu");
        return map;
    }
}
```
���յ�Ч������Ӧ������Ӧ�ģ�����ͨ������ErrorAttributes�ı���Ҫ���ص����ݣ�
![](images/�ѹ���ͼ20180228135513.png)
## 8������Ƕ��ʽServlet����
SpringBootĬ��ʹ��Tomcat��ΪǶ��ʽ��Servlet������
![](images/�ѹ���ͼ20180301142915.png)
���⣿
### 1������ζ��ƺ��޸�Servlet������������ã�
1���޸ĺ�server�йص����ã�ServerProperties��Ҳ��EmbeddedServletContainerCustomizer������
```properties
server.port=8081
server.context-path=/crud
server.tomcat.uri-encoding=UTF-8
//ͨ�õ�Servlet��������
server.xxx
//Tomcat������
server.tomcat.xxx
```
2����дһ��**EmbeddedServletContainerCustomizer**��Ƕ��ʽ��Servlet�����Ķ����������޸�Servlet����������
```java
@Bean  //һ��Ҫ��������������뵽������
public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer(){
    return new EmbeddedServletContainerCustomizer() {
        //����Ƕ��ʽ��Servlet������صĹ���
        @Override
        public void customize(ConfigurableEmbeddedServletContainer container) {
            container.setPort(8083);
        }
    };
}
```
### 2����ע��Servlet���������Servlet��Filter��Listener��
����SpringBootĬ������jar���ķ�ʽ����Ƕ��ʽ��Servlet����������SpringBoot��webӦ�ã�û��web.xml�ļ���
ע��������������·�ʽ
ServletRegistrationBean
```java
//ע���������
@Bean
public ServletRegistrationBean myServlet(){
    ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(),"/myServlet");
    return registrationBean;
}
```
FilterRegistrationBean
```java
@Bean
public FilterRegistrationBean myFilter(){
    FilterRegistrationBean registrationBean = new FilterRegistrationBean();
    registrationBean.setFilter(new MyFilter());
    registrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));
    return registrationBean;
}
```
ServletListenerRegistrationBean
```java
@Bean
public ServletListenerRegistrationBean myListener(){
    ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean<>(new MyListener());
    return registrationBean;
}
```
SpringBoot�������Զ�SpringMVC��ʱ���Զ���ע��SpringMVC��ǰ�˿�������DIspatcherServlet��
DispatcherServletAutoConfiguration�У�
```java
@Bean(name = DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME)
@ConditionalOnBean(value = DispatcherServlet.class, name = DEFAULT_DISPATCHER_SERVLET_BEAN_NAME)
public ServletRegistrationBean dispatcherServletRegistration(
      DispatcherServlet dispatcherServlet) {
   ServletRegistrationBean registration = new ServletRegistrationBean(
         dispatcherServlet, this.serverProperties.getServletMapping());
    //Ĭ�����أ� /  �������󣻰���̬��Դ�����ǲ�����jsp����   /*������jsp
    //����ͨ��server.servletPath���޸�SpringMVCǰ�˿�����Ĭ�����ص�����·��
    
   registration.setName(DEFAULT_DISPATCHER_SERVLET_BEAN_NAME);
   registration.setLoadOnStartup(
         this.webMvcProperties.getServlet().getLoadOnStartup());
   if (this.multipartConfig != null) {
      registration.setMultipartConfig(this.multipartConfig);
   }
   return registration;
}
```
2����SpringBoot�ܲ���֧��������Servlet������
### 3�����滻Ϊ����Ƕ��ʽServlet����
![](images/�ѹ���ͼ20180302114401.png)
Ĭ��֧�֣�
Tomcat��Ĭ��ʹ�ã�
```xml
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-web</artifactId>
   ����webģ��Ĭ�Ͼ���ʹ��Ƕ��ʽ��Tomcat��ΪServlet������
</dependency>
```
Jetty
```xml
<!-- ����webģ�� -->
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-web</artifactId>
   <exclusions>
      <exclusion>
         <artifactId>spring-boot-starter-tomcat</artifactId>
         <groupId>org.springframework.boot</groupId>
      </exclusion>
   </exclusions>
</dependency>
<!--����������Servlet����-->
<dependency>
   <artifactId>spring-boot-starter-jetty</artifactId>
   <groupId>org.springframework.boot</groupId>
</dependency>
```
Undertow
```xml
<!-- ����webģ�� -->
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-web</artifactId>
   <exclusions>
      <exclusion>
         <artifactId>spring-boot-starter-tomcat</artifactId>
         <groupId>org.springframework.boot</groupId>
      </exclusion>
   </exclusions>
</dependency>
<!--����������Servlet����-->
<dependency>
   <artifactId>spring-boot-starter-undertow</artifactId>
   <groupId>org.springframework.boot</groupId>
</dependency>
```
### 4����Ƕ��ʽServlet�����Զ�����ԭ��
EmbeddedServletContainerAutoConfiguration��Ƕ��ʽ��Servlet�����Զ����ã�
```java
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
@Configuration
@ConditionalOnWebApplication
@Import(BeanPostProcessorsRegistrar.class)
//����BeanPostProcessorsRegistrar��Springע��棻�������е���һЩ���
//������EmbeddedServletContainerCustomizerBeanPostProcessor��
//���ô�������bean��ʼ��ǰ�󣨴�������󣬻�û��ֵ��ֵ��ִ�г�ʼ������
public class EmbeddedServletContainerAutoConfiguration {
    
    @Configuration
	@ConditionalOnClass({ Servlet.class, Tomcat.class })//�жϵ�ǰ�Ƿ�������Tomcat������
	@ConditionalOnMissingBean(value = EmbeddedServletContainerFactory.class, search = SearchStrategy.CURRENT)//�жϵ�ǰ����û���û��Լ�����EmbeddedServletContainerFactory��Ƕ��ʽ��Servlet�������������ã�����Ƕ��ʽ��Servlet����
	public static class EmbeddedTomcat {
		@Bean
		public TomcatEmbeddedServletContainerFactory tomcatEmbeddedServletContainerFactory() {
			return new TomcatEmbeddedServletContainerFactory();
		}
	}
    
    /**
	 * Nested configuration if Jetty is being used.
	 */
	@Configuration
	@ConditionalOnClass({ Servlet.class, Server.class, Loader.class,
			WebAppContext.class })
	@ConditionalOnMissingBean(value = EmbeddedServletContainerFactory.class, search = SearchStrategy.CURRENT)
	public static class EmbeddedJetty {
		@Bean
		public JettyEmbeddedServletContainerFactory jettyEmbeddedServletContainerFactory() {
			return new JettyEmbeddedServletContainerFactory();
		}
	}
	/**
	 * Nested configuration if Undertow is being used.
	 */
	@Configuration
	@ConditionalOnClass({ Servlet.class, Undertow.class, SslClientAuthMode.class })
	@ConditionalOnMissingBean(value = EmbeddedServletContainerFactory.class, search = SearchStrategy.CURRENT)
	public static class EmbeddedUndertow {
		@Bean
		public UndertowEmbeddedServletContainerFactory undertowEmbeddedServletContainerFactory() {
			return new UndertowEmbeddedServletContainerFactory();
		}
	}
```
1����EmbeddedServletContainerFactory��Ƕ��ʽServlet����������
```java
public interface EmbeddedServletContainerFactory {
   //��ȡǶ��ʽ��Servlet����
   EmbeddedServletContainer getEmbeddedServletContainer(
         ServletContextInitializer... initializers);
}
```
![](images/�ѹ���ͼ20180302144835.png)
2����EmbeddedServletContainer����Ƕ��ʽ��Servlet������
![](images/�ѹ���ͼ20180302144910.png)
3������**TomcatEmbeddedServletContainerFactory**Ϊ��
```java
@Override
public EmbeddedServletContainer getEmbeddedServletContainer(
      ServletContextInitializer... initializers) {
    //����һ��Tomcat
   Tomcat tomcat = new Tomcat();
    
    //����Tomcat�Ļ�������
   File baseDir = (this.baseDirectory != null ? this.baseDirectory
         : createTempDir("tomcat"));
   tomcat.setBaseDir(baseDir.getAbsolutePath());
   Connector connector = new Connector(this.protocol);
   tomcat.getService().addConnector(connector);
   customizeConnector(connector);
   tomcat.setConnector(connector);
   tomcat.getHost().setAutoDeploy(false);
   configureEngine(tomcat.getEngine());
   for (Connector additionalConnector : this.additionalTomcatConnectors) {
      tomcat.getService().addConnector(additionalConnector);
   }
   prepareContext(tomcat.getHost(), initializers);
    
    //�����úõ�Tomcat�����ȥ������һ��EmbeddedServletContainer����������Tomcat������
   return getTomcatEmbeddedServletContainer(tomcat);
}
```
4�������Ƕ�Ƕ��ʽ�����������޸�����ô��Ч��
```
ServerProperties��EmbeddedServletContainerCustomizer
```
**EmbeddedServletContainerCustomizer**���������������޸���Servlet���������ã�
��ô�޸ĵ�ԭ��
5���������е�����**EmbeddedServletContainerCustomizerBeanPostProcessor**
```java
//��ʼ��֮ǰ
@Override
public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    //�����ǰ��ʼ������һ��ConfigurableEmbeddedServletContainer���͵����
   if (bean instanceof ConfigurableEmbeddedServletContainer) {
       //
      postProcessBeforeInitialization((ConfigurableEmbeddedServletContainer) bean);
   }
   return bean;
}
private void postProcessBeforeInitialization(
			ConfigurableEmbeddedServletContainer bean) {
    //��ȡ���еĶ�����������ÿһ����������customize��������Servlet�����������Ը�ֵ��
    for (EmbeddedServletContainerCustomizer customizer : getCustomizers()) {
        customizer.customize(bean);
    }
}
private Collection<EmbeddedServletContainerCustomizer> getCustomizers() {
    if (this.customizers == null) {
        // Look up does not include the parent context
        this.customizers = new ArrayList<EmbeddedServletContainerCustomizer>(
            this.beanFactory
            //�������л�ȡ����������͵������EmbeddedServletContainerCustomizer
            //����Servlet�������������п������һ��EmbeddedServletContainerCustomizer���͵����
            .getBeansOfType(EmbeddedServletContainerCustomizer.class,
                            false, false)
            .values());
        Collections.sort(this.customizers, AnnotationAwareOrderComparator.INSTANCE);
        this.customizers = Collections.unmodifiableList(this.customizers);
    }
    return this.customizers;
}
ServerPropertiesҲ�Ƕ�����
```
���裺
1����SpringBoot���ݵ��������������������������Ӧ��EmbeddedServletContainerFactory��TomcatEmbeddedServletContainerFactory��
2����������ĳ�����Ҫ��������ͻᾪ�����ô�������EmbeddedServletContainerCustomizerBeanPostProcessor��
ֻҪ��Ƕ��ʽ��Servlet�������������ô������͹�����
3�������ô��������������л�ȡ���е�**EmbeddedServletContainerCustomizer**�����ö������Ķ��Ʒ���
###5����Ƕ��ʽServlet��������ԭ��
ʲôʱ�򴴽�Ƕ��ʽ��Servlet����������ʲôʱ���ȡǶ��ʽ��Servlet����������Tomcat��
��ȡǶ��ʽ��Servlet����������
1����SpringBootӦ����������run����
2����refreshContext(context);SpringBootˢ��IOC����������IOC�������󣬲���ʼ�����������������е�ÿһ��������������webӦ�ô���**AnnotationConfigEmbeddedWebApplicationContext**������**AnnotationConfigApplicationContext**
3����refresh(context);**ˢ�¸ղŴ����õ�ioc������**
```java
public void refresh() throws BeansException, IllegalStateException {
   synchronized (this.startupShutdownMonitor) {
      // Prepare this context for refreshing.
      prepareRefresh();
      // Tell the subclass to refresh the internal bean factory.
      ConfigurableListableBeanFactory beanFactory = obtainFreshBeanFactory();
      // Prepare the bean factory for use in this context.
      prepareBeanFactory(beanFactory);
      try {
         // Allows post-processing of the bean factory in context subclasses.
         postProcessBeanFactory(beanFactory);
         // Invoke factory processors registered as beans in the context.
         invokeBeanFactoryPostProcessors(beanFactory);
         // Register bean processors that intercept bean creation.
         registerBeanPostProcessors(beanFactory);
         // Initialize message source for this context.
         initMessageSource();
         // Initialize event multicaster for this context.
         initApplicationEventMulticaster();
         // Initialize other special beans in specific context subclasses.
         onRefresh();
         // Check for listener beans and register them.
         registerListeners();
         // Instantiate all remaining (non-lazy-init) singletons.
         finishBeanFactoryInitialization(beanFactory);
         // Last step: publish corresponding event.
         finishRefresh();
      }
      catch (BeansException ex) {
         if (logger.isWarnEnabled()) {
            logger.warn("Exception encountered during context initialization - " +
                  "cancelling refresh attempt: " + ex);
         }
         // Destroy already created singletons to avoid dangling resources.
         destroyBeans();
         // Reset 'active' flag.
         cancelRefresh(ex);
         // Propagate exception to caller.
         throw ex;
      }
      finally {
         // Reset common introspection caches in Spring's core, since we
         // might not ever need metadata for singleton beans anymore...
         resetCommonCaches();
      }
   }
}
```
4����  onRefresh(); web��ioc������д��onRefresh����
5����webioc�����ᴴ��Ƕ��ʽ��Servlet������**createEmbeddedServletContainer**();
**6������ȡǶ��ʽ��Servlet����������**
EmbeddedServletContainerFactory containerFactory = getEmbeddedServletContainerFactory();
?	��ioc�����л�ȡEmbeddedServletContainerFactory �����**TomcatEmbeddedServletContainerFactory**�������󣬺��ô�����һ����������󣬾ͻ�ȡ���еĶ��������ȶ���Servlet������������ã�
7����**ʹ������������ȡǶ��ʽ��Servlet����**��this.embeddedServletContainer = containerFactory      .getEmbeddedServletContainer(getSelfInitializer());
8����Ƕ��ʽ��Servlet����������������Servlet������
**������Ƕ��ʽ��Servlet�������ٽ�ioc������ʣ��û�д������Ķ����ȡ������**
**==IOC������������Ƕ��ʽ��Servlet����==**
## 9��ʹ�����õ�Servlet����
Ƕ��ʽServlet������Ӧ�ô�ɿ�ִ�е�jar
?		�ŵ㣺�򵥡���Я��
?		ȱ�㣺Ĭ�ϲ�֧��JSP���Ż����ƱȽϸ��ӣ�ʹ�ö�������ServerProperties���Զ���EmbeddedServletContainerCustomizer�����Լ���дǶ��ʽServlet�����Ĵ���������EmbeddedServletContainerFactory������
���õ�Servlet���������氲װTomcat---Ӧ��war���ķ�ʽ�����
### ����
1�������봴��һ��war��Ŀ��������idea������Ŀ¼�ṹ��
2������Ƕ��ʽ��Tomcatָ��Ϊprovided��
```xml
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-tomcat</artifactId>
   <scope>provided</scope>
</dependency>
```
3���������дһ��**SpringBootServletInitializer**�����࣬������configure����
```java
public class ServletInitializer extends SpringBootServletInitializer {
   @Override
   protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
       //����SpringBootӦ�õ�������
      return application.sources(SpringBoot04WebJspApplication.class);
   }
}
```
4���������������Ϳ���ʹ�ã�
### ԭ��
jar����ִ��SpringBoot�����main����������ioc����������Ƕ��ʽ��Servlet������
war����������������**����������SpringBootӦ��**��SpringBootServletInitializer��������ioc������
servlet3.0��Springע��棩��
8.2.4 Shared libraries / runtimes pluggability��
����
?	1����������������webӦ���������ᴴ����ǰwebӦ������ÿһ��jar������ServletContainerInitializerʵ����
?	2����ServletContainerInitializer��ʵ�ַ���jar����META-INF/services�ļ����£���һ����Ϊjavax.servlet.ServletContainerInitializer���ļ������ݾ���ServletContainerInitializer��ʵ�����ȫ����
?	3����������ʹ��@HandlesTypes����Ӧ��������ʱ��������Ǹ���Ȥ���ࣻ
���̣�
1��������Tomcat
2����org\springframework\spring-web\4.3.14.RELEASE\spring-web-4.3.14.RELEASE.jar!\META-INF\services\javax.servlet.ServletContainerInitializer��
Spring��webģ������������ļ���**org.springframework.web.SpringServletContainerInitializer**
3����SpringServletContainerInitializer��@HandlesTypes(WebApplicationInitializer.class)��ע������������͵��඼���뵽onStartup������Set<Class<?>>��Ϊ��ЩWebApplicationInitializer���͵��ഴ��ʵ����
4����ÿһ��WebApplicationInitializer�������Լ���onStartup��
![](images/�ѹ���ͼ20180302221835.png)
5�����൱�����ǵ�SpringBootServletInitializer����ᱻ�������󣬲�ִ��onStartup����
6����SpringBootServletInitializerʵ��ִ��onStartup��ʱ���createRootApplicationContext����������
```java
protected WebApplicationContext createRootApplicationContext(
      ServletContext servletContext) {
    //1������SpringApplicationBuilder
   SpringApplicationBuilder builder = createSpringApplicationBuilder();
   StandardServletEnvironment environment = new StandardServletEnvironment();
   environment.initPropertySources(servletContext, null);
   builder.environment(environment);
   builder.main(getClass());
   ApplicationContext parent = getExistingRootWebApplicationContext(servletContext);
   if (parent != null) {
      this.logger.info("Root context already created (using as parent).");
      servletContext.setAttribute(
            WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, null);
      builder.initializers(new ParentContextApplicationContextInitializer(parent));
   }
   builder.initializers(
         new ServletContextApplicationContextInitializer(servletContext));
   builder.contextClass(AnnotationConfigEmbeddedWebApplicationContext.class);
    
    //����configure������������д�������������SpringBoot���������ഫ���˽���
   builder = configure(builder);
    
    //ʹ��builder����һ��SpringӦ��
   SpringApplication application = builder.build();
   if (application.getSources().isEmpty() && AnnotationUtils
         .findAnnotation(getClass(), Configuration.class) != null) {
      application.getSources().add(getClass());
   }
   Assert.state(!application.getSources().isEmpty(),
         "No SpringApplication sources have been defined. Either override the "
               + "configure method or add an @Configuration annotation");
   // Ensure error pages are registered
   if (this.registerErrorPageFilter) {
      application.getSources().add(ErrorPageFilterConfiguration.class);
   }
    //����SpringӦ��
   return run(application);
}
```
7����Spring��Ӧ�þ��������Ҵ���IOC����
```java
public ConfigurableApplicationContext run(String... args) {
   StopWatch stopWatch = new StopWatch();
   stopWatch.start();
   ConfigurableApplicationContext context = null;
   FailureAnalyzers analyzers = null;
   configureHeadlessProperty();
   SpringApplicationRunListeners listeners = getRunListeners(args);
   listeners.starting();
   try {
      ApplicationArguments applicationArguments = new DefaultApplicationArguments(
            args);
      ConfigurableEnvironment environment = prepareEnvironment(listeners,
            applicationArguments);
      Banner printedBanner = printBanner(environment);
      context = createApplicationContext();
      analyzers = new FailureAnalyzers(context);
      prepareContext(context, environment, listeners, applicationArguments,
            printedBanner);
       
       //ˢ��IOC����
      refreshContext(context);
      afterRefresh(context, applicationArguments);
      listeners.finished(context, null);
      stopWatch.stop();
      if (this.logStartupInfo) {
         new StartupInfoLogger(this.mainApplicationClass)
               .logStarted(getApplicationLog(), stopWatch);
      }
      return context;
   }
   catch (Throwable ex) {
      handleRunFailure(context, listeners, analyzers, ex);
      throw new IllegalStateException(ex);
   }
}
```
**==����Servlet������������SpringBootӦ��==**
# �塢Docker
## 1�����
**Docker**��һ����Դ��Ӧ���������棻��һ������������������
Docker֧�ֽ���������һ������Ȼ���ھ����и�������������ã������񷢲���ȥ������ʹ���߿���ֱ��ʹ���������
�����е���������Ϊ���������������Ƿǳ����ٵġ�
![](images/�ѹ���ͼ20180303145450.png)
![](images/�ѹ���ͼ20180303145531.png)
## 2�����ĸ���
docker����(Host)����װ��Docker����Ļ�����Dockerֱ�Ӱ�װ�ڲ���ϵͳ֮�ϣ���
docker�ͻ���(Client)������docker�������в�����
docker�ֿ�(Registry)������������ִ���õ��������
docker����(Images)���������õľ��񣻷���docker�ֿ��У�
docker����(Container)�������������ʵ����Ϊһ�������������Ƕ������е�һ����һ��Ӧ��
![](images/�ѹ���ͼ20180303165113.png)
ʹ��Docker�Ĳ��裺
1������װDocker
2����ȥDocker�ֿ��ҵ���������Ӧ�ľ���
3����ʹ��Docker������������������ͻ�����һ��Docker������
4����������������ֹͣ���Ƕ����������ֹͣ��
## 3����װDocker
#### 1������װlinux�����
?	1����VMWare��VirtualBox����װ����
?	2��������������ļ�centos7-atguigu.ova��
?	3����˫������linux�����;ʹ��  root/ 123456��½
?	4����ʹ�ÿͻ�������linux�������������������
?	5����������������磻
?		�Ž�����===ѡ������====�������ߣ�
?	6�������ú������Ժ�ʹ���������������������
```shell
service network restart
```
?	7�����鿴linux��ip��ַ
```shell
ip addr
```
?	8����ʹ�ÿͻ�������linux��
#### 2������linux������ϰ�װdocker
���裺
```shell
1������ں˰汾��������3.10������
uname -r
2����װdocker
yum install docker
3������yȷ�ϰ�װ
4������docker
[root@localhost ~]# systemctl start docker
[root@localhost ~]# docker -v
Docker version 1.12.6, build 3e8e77d/1.12.6
5����������docker
[root@localhost ~]# systemctl enable docker
Created symlink from /etc/systemd/system/multi-user.target.wants/docker.service to /usr/lib/systemd/system/docker.service.
6��ֹͣdocker
systemctl stop docker
```
## 4��Docker��������&����
### 1�����������
| ���� | ����                                            | ˵��                                                     |
| ---- | ----------------------------------------------- | -------------------------------------------------------- |
| ���� | docker  search �ؼ���  eg��docker  search redis | ���Ǿ���ȥdocker  hub�ϼ����������ϸ��Ϣ���羵���TAG�� |
| ��ȡ | docker pull ������:tag                          | :tag�ǿ�ѡ�ģ�tag��ʾ��ǩ����Ϊ����İ汾��Ĭ����latest  |
| �б� | docker images                                   | �鿴���б��ؾ���                                         |
| ɾ�� | docker rmi image-id                             | ɾ��ָ���ı��ؾ���                                       |
https://hub.docker.com/
### 2������������
�������QQ��װ����----���о���----����һ���������������е���������е�QQ����
���裺
````shell
1����������
[root@localhost ~]# docker search tomcat
2����ȡ����
[root@localhost ~]# docker pull tomcat
3�����ݾ�����������
docker run --name mytomcat -d tomcat:latest
4��docker ps  
�鿴�����е�����
5�� ֹͣ�����е�����
docker stop  ������id
6���鿴���е�����
docker ps -a
7����������
docker start ����id
8��ɾ��һ������
 docker rm ����id
9������һ�����˶˿�ӳ���tomcat
[root@localhost ~]# docker run -d -p 8888:8080 tomcat
-d����̨����
-p: �������Ķ˿�ӳ�䵽������һ���˿�    �����˿�:�����ڲ��Ķ˿�
10��Ϊ����ʾ�򵥹ر���linux�ķ���ǽ
service firewalld status ���鿴����ǽ״̬
service firewalld stop���رշ���ǽ
11���鿴��������־
docker logs container-name/container-id
��������ο�
https://docs.docker.com/engine/reference/commandline/docker/
���Բο�ÿһ��������ĵ�
````
### 3������װMySQLʾ��
```shell
docker pull mysql
```
���������
```shell
[root@localhost ~]# docker run --name mysql01 -d mysql
42f09819908bb72dd99ae19e792e0a5d03c48638421fa64cce5f8ba0f40f5846
mysql�˳���
[root@localhost ~]# docker ps -a
CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS                           PORTS               NAMES
42f09819908b        mysql               "docker-entrypoint.sh"   34 seconds ago      Exited (1) 33 seconds ago                            mysql01
538bde63e500        tomcat              "catalina.sh run"        About an hour ago   Exited (143) About an hour ago                       compassionate_
goldstine
c4f1ac60b3fc        tomcat              "catalina.sh run"        About an hour ago   Exited (143) About an hour ago                       lonely_fermi
81ec743a5271        tomcat              "catalina.sh run"        About an hour ago   Exited (143) About an hour ago                       sick_ramanujan
//������־
[root@localhost ~]# docker logs 42f09819908b
error: database is uninitialized and password option is not specified 
  You need to specify one of MYSQL_ROOT_PASSWORD, MYSQL_ALLOW_EMPTY_PASSWORD and MYSQL_RANDOM_ROOT_PASSWORD�����������������ָ��һ��
```
��ȷ������
```shell
[root@localhost ~]# docker run --name mysql01 -e MYSQL_ROOT_PASSWORD=123456 -d mysql
b874c56bec49fb43024b3805ab51e9097da779f2f572c22c695305dedd684c5f
[root@localhost ~]# docker ps
CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS               NAMES
b874c56bec49        mysql               "docker-entrypoint.sh"   4 seconds ago       Up 3 seconds        3306/tcp            mysql01
```
���˶˿�ӳ��
```shell
[root@localhost ~]# docker run -p 3306:3306 --name mysql02 -e MYSQL_ROOT_PASSWORD=123456 -d mysql
ad10e4bc5c6a0f61cbad43898de71d366117d120e39db651844c0e73863b9434
[root@localhost ~]# docker ps
CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS                    NAMES
ad10e4bc5c6a        mysql               "docker-entrypoint.sh"   4 seconds ago       Up 2 seconds        0.0.0.0:3306->3306/tcp   mysql02
```
���������ĸ߼�����
```
docker run --name mysql03 -v /conf/mysql:/etc/mysql/conf.d -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql:tag
��������/conf/mysql�ļ��й��ص� mysqldocker������/etc/mysql/conf.d�ļ�������
��mysql�������ļ���ֻ��Ҫ��mysql�����ļ������Զ�����ļ����£�/conf/mysql��
docker run --name some-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql:tag --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci
ָ��mysql��һЩ���ò���
```
# ����SpringBoot�����ݷ���
## 1��JDBC
```xml
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-jdbc</artifactId>
		</dependency>
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<scope>runtime</scope>
		</dependency>
```
```yaml
spring:
  datasource:
    username: root
    password: 123456
    url: jdbc:mysql://192.168.15.22:3306/jdbc
    driver-class-name: com.mysql.jdbc.Driver
```
Ч����
?	Ĭ������org.apache.tomcat.jdbc.pool.DataSource��Ϊ����Դ��
?	����Դ��������ö���DataSourceProperties���棻
�Զ�����ԭ��
org.springframework.boot.autoconfigure.jdbc��
1���ο�DataSourceConfiguration���������ô�������Դ��Ĭ��ʹ��Tomcat���ӳأ�����ʹ��spring.datasource.typeָ���Զ��������Դ���ͣ�
2��SpringBootĬ�Ͽ���֧�֣�
```
org.apache.tomcat.jdbc.pool.DataSource��HikariDataSource��BasicDataSource��
```
3���Զ�������Դ����
```java
/**
 * Generic DataSource configuration.
 */
@ConditionalOnMissingBean(DataSource.class)
@ConditionalOnProperty(name = "spring.datasource.type")
static class Generic {
   @Bean
   public DataSource dataSource(DataSourceProperties properties) {
       //ʹ��DataSourceBuilder��������Դ�����÷��䴴����Ӧtype������Դ�����Ұ��������
      return properties.initializeDataSourceBuilder().build();
   }
}
```
4��**DataSourceInitializer��ApplicationListener**��
?	���ã�
?		1����runSchemaScripts();���н�����䣻
?		2����runDataScripts();���в������ݵ�sql��䣻
Ĭ��ֻ��Ҫ���ļ�����Ϊ��
```properties
schema-*.sql��data-*.sql
Ĭ�Ϲ���schema.sql��schema-all.sql��
����ʹ��   
	schema:
      - classpath:department.sql
      ָ��λ��
```
5���������ݿ⣺�Զ�������JdbcTemplate�������ݿ�
## 2������Druid����Դ
```java
����druid����Դ
@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
       return  new DruidDataSource();
    }
    //����Druid�ļ��
    //1������һ�������̨��Servlet
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String,String> initParams = new HashMap<>();
        initParams.put("loginUsername","admin");
        initParams.put("loginPassword","123456");
        initParams.put("allow","");//Ĭ�Ͼ����������з���
        initParams.put("deny","192.168.15.21");
        bean.setInitParameters(initParams);
        return bean;
    }
    //2������һ��web��ص�filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String,String> initParams = new HashMap<>();
        initParams.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(initParams);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return  bean;
    }
}
```
## 3������MyBatis
```xml
		<dependency>
			<groupId>org.mybatis.spring.boot</groupId>
			<artifactId>mybatis-spring-boot-starter</artifactId>
			<version>1.3.1</version>
		</dependency>
```
![](images/�ѹ���ͼ20180305194443.png)
���裺
?	1������������Դ������ԣ�����һ��Druid��
?	2���������ݿ⽨��
?	3��������JavaBean
### 	4����ע���
```java
//ָ������һ���������ݿ��mapper
@Mapper
public interface DepartmentMapper {
    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);
    @Delete("delete from department where id=#{id}")
    public int deleteDeptById(Integer id);
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(departmentName) values(#{departmentName})")
    public int insertDept(Department department);
    @Update("update department set departmentName=#{departmentName} where id=#{id}")
    public int updateDept(Department department);
}
```
���⣺
�Զ���MyBatis�����ù��򣻸����������һ��ConfigurationCustomizer��
```java
@org.springframework.context.annotation.Configuration
public class MyBatisConfig {
    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
        return new ConfigurationCustomizer(){
            @Override
            public void customize(Configuration configuration) {
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
```
```java
ʹ��MapperScan����ɨ�����е�Mapper�ӿڣ�
@MapperScan(value = "com.atguigu.springboot.mapper")
@SpringBootApplication
public class SpringBoot06DataMybatisApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBoot06DataMybatisApplication.class, args);
	}
}
```
### 5���������ļ���
```yaml
mybatis:
  config-location: classpath:mybatis/mybatis-config.xml ָ��ȫ�������ļ���λ��
  mapper-locations: classpath:mybatis/mapper/*.xml  ָ��sqlӳ���ļ���λ��
```
����ʹ�ò���
http://www.mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/
## 4������SpringData JPA
### 1����SpringData���
![](images/�ѹ���ͼ20180306105412.png)
### 2��������SpringData JPA
JPA:ORM��Object Relational Mapping����
1������дһ��ʵ���ࣨbean�������ݱ����ӳ�䣬�������ú�ӳ���ϵ��
```java
//ʹ��JPAע������ӳ���ϵ
@Entity //����JPA����һ��ʵ���ࣨ�����ݱ�ӳ����ࣩ
@Table(name = "tbl_user") //@Table��ָ�����ĸ����ݱ��Ӧ;���ʡ��Ĭ�ϱ�������user��
public class User {
    @Id //����һ������
    @GeneratedValue(strategy = GenerationType.IDENTITY)//��������
    private Integer id;
    @Column(name = "last_name",length = 50) //���Ǻ����ݱ��Ӧ��һ����
    private String lastName;
    @Column //ʡ��Ĭ����������������
    private String email;
```
2������дһ��Dao�ӿ�������ʵ�����Ӧ�����ݱ�Repository��
```java
//�̳�JpaRepository����ɶ����ݿ�Ĳ���
public interface UserRepository extends JpaRepository<User,Integer> {
}
```
3��������������JpaProperties
```yaml
spring:  
 jpa:
    hibernate:
#     ���»��ߴ������ݱ�ṹ
      ddl-auto: update
#    ����̨��ʾSQL
    show-sql: true
```
# �ߡ���������ԭ��
������Ҫ���¼��ص�����
������META-INF/spring.factories
**ApplicationContextInitializer**
**SpringApplicationRunListener**
ֻ��Ҫ����ioc������
**ApplicationRunner**
**CommandLineRunner**
�������̣�
## **1������SpringApplication����**
```java
initialize(sources);
private void initialize(Object[] sources) {
    //������������
    if (sources != null && sources.length > 0) {
        this.sources.addAll(Arrays.asList(sources));
    }
    //�жϵ�ǰ�Ƿ�һ��webӦ��
    this.webEnvironment = deduceWebEnvironment();
    //����·�����ҵ�META-INF/spring.factories���õ�����ApplicationContextInitializer��Ȼ�󱣴�����
    setInitializers((Collection) getSpringFactoriesInstances(
        ApplicationContextInitializer.class));
    //����·�����ҵ�ETA-INF/spring.factories���õ�����ApplicationListener
    setListeners((Collection) getSpringFactoriesInstances(ApplicationListener.class));
    //�Ӷ�����������ҵ���main��������������
    this.mainApplicationClass = deduceMainApplicationClass();
}
```
![](images/�ѹ���ͼ20180306145727.png)
![](images/�ѹ���ͼ20180306145855.png)
## 2������run����
```java
public ConfigurableApplicationContext run(String... args) {
   StopWatch stopWatch = new StopWatch();
   stopWatch.start();
   ConfigurableApplicationContext context = null;
   FailureAnalyzers analyzers = null;
   configureHeadlessProperty();
    
   //��ȡSpringApplicationRunListeners������·����META-INF/spring.factories
   SpringApplicationRunListeners listeners = getRunListeners(args);
    //�ص����еĻ�ȡSpringApplicationRunListener.starting()����
   listeners.starting();
   try {
       //��װ�����в���
      ApplicationArguments applicationArguments = new DefaultApplicationArguments(
            args);
      //׼������
      ConfigurableEnvironment environment = prepareEnvironment(listeners,
            applicationArguments);
       		//����������ɺ�ص�SpringApplicationRunListener.environmentPrepared()����ʾ����׼�����
       
      Banner printedBanner = printBanner(environment);
       
       //����ApplicationContext����������web��ioc������ͨ��ioc
      context = createApplicationContext();
       
      analyzers = new FailureAnalyzers(context);
       //׼�������Ļ���;��environment���浽ioc�У�����applyInitializers()��
       //applyInitializers()���ص�֮ǰ��������е�ApplicationContextInitializer��initialize����
       //�ص����е�SpringApplicationRunListener��contextPrepared()��
       //
      prepareContext(context, environment, listeners, applicationArguments,
            printedBanner);
       //prepareContext��������Ժ�ص����е�SpringApplicationRunListener��contextLoaded������
       
       //sˢ��������ioc������ʼ���������webӦ�û��ᴴ��Ƕ��ʽ��Tomcat����Springע���
       //ɨ�裬������������������ĵط����������࣬������Զ����ã�
      refreshContext(context);
       //��ioc�����л�ȡ���е�ApplicationRunner��CommandLineRunner���лص�
       //ApplicationRunner�Ȼص���CommandLineRunner�ٻص�
      afterRefresh(context, applicationArguments);
       //���е�SpringApplicationRunListener�ص�finished����
      listeners.finished(context, null);
      stopWatch.stop();
      if (this.logStartupInfo) {
         new StartupInfoLogger(this.mainApplicationClass)
               .logStarted(getApplicationLog(), stopWatch);
      }
       //����SpringBootӦ����������Ժ󷵻�������ioc������
      return context;
   }
   catch (Throwable ex) {
      handleRunFailure(context, listeners, analyzers, ex);
      throw new IllegalStateException(ex);
   }
}
```
## 3���¼���������
������META-INF/spring.factories
**ApplicationContextInitializer**
```java
public class HelloApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("ApplicationContextInitializer...initialize..."+applicationContext);
    }
}
```
**SpringApplicationRunListener**
```java
public class HelloSpringApplicationRunListener implements SpringApplicationRunListener {
    //�����еĹ�����
    public HelloSpringApplicationRunListener(SpringApplication application, String[] args){
    }
    @Override
    public void starting() {
        System.out.println("SpringApplicationRunListener...starting...");
    }
    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        Object o = environment.getSystemProperties().get("os.name");
        System.out.println("SpringApplicationRunListener...environmentPrepared.."+o);
    }
    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("SpringApplicationRunListener...contextPrepared...");
    }
    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("SpringApplicationRunListener...contextLoaded...");
    }
    @Override
    public void finished(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("SpringApplicationRunListener...finished...");
    }
}
```
���ã�META-INF/spring.factories��
```properties
org.springframework.context.ApplicationContextInitializer=\
com.atguigu.springboot.listener.HelloApplicationContextInitializer
org.springframework.boot.SpringApplicationRunListener=\
com.atguigu.springboot.listener.HelloSpringApplicationRunListener
```
ֻ��Ҫ����ioc������
**ApplicationRunner**
```java
@Component
public class HelloApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("ApplicationRunner...run....");
    }
}
```
**CommandLineRunner**
```java
@Component
public class HelloCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineRunner...run..."+ Arrays.asList(args));
    }
}
```
# �ˡ��Զ���starter
starter��
?	1�����������Ҫʹ�õ���������ʲô��
?	2����α�д�Զ�����
```java
@Configuration  //ָ���������һ��������
@ConditionalOnXXX  //��ָ������������������Զ���������Ч
@AutoConfigureAfter  //ָ���Զ��������˳��
@Bean  //��������������
@ConfigurationPropertie������xxxProperties��������ص�����
@EnableConfigurationProperties //��xxxProperties��Ч���뵽������
�Զ�������Ҫ�ܼ���
����Ҫ�����ͼ��ص��Զ������࣬������META-INF/spring.factories
org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration,\
org.springframework.boot.autoconfigure.aop.AopAutoConfiguration,\
```
?	3��ģʽ��
������ֻ�������������룻
ר����дһ���Զ�����ģ�飻
�����������Զ����ã�����ֻ��Ҫ������������starter��
mybatis-spring-boot-starter���Զ�����������-spring-boot-starter
���裺
1����������ģ��
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.atguigu.starter</groupId>
    <artifactId>atguigu-spring-boot-starter</artifactId>
    <version>1.0-SNAPSHOT</version>
    <!--������-->
    <dependencies>
        <!--�����Զ�����ģ��-->
        <dependency>
            <groupId>com.atguigu.starter</groupId>
            <artifactId>atguigu-spring-boot-starter-autoconfigurer</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>
    </dependencies>
</project>
```
2�����Զ�����ģ��
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
   xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
   <modelVersion>4.0.0</modelVersion>
   <groupId>com.atguigu.starter</groupId>
   <artifactId>atguigu-spring-boot-starter-autoconfigurer</artifactId>
   <version>0.0.1-SNAPSHOT</version>
   <packaging>jar</packaging>
   <name>atguigu-spring-boot-starter-autoconfigurer</name>
   <description>Demo project for Spring Boot</description>
   <parent>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-parent</artifactId>
      <version>1.5.10.RELEASE</version>
      <relativePath/> <!-- lookup parent from repository -->
   </parent>
   <properties>
      <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
      <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
      <java.version>1.8</java.version>
   </properties>
   <dependencies>
      <!--����spring-boot-starter������starter�Ļ�������-->
      <dependency>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter</artifactId>
      </dependency>
   </dependencies>
</project>
```
```java
package com.atguigu.starter;
import org.springframework.boot.context.properties.ConfigurationProperties;
@ConfigurationProperties(prefix = "atguigu.hello")
public class HelloProperties {
    private String prefix;
    private String suffix;
    public String getPrefix() {
        return prefix;
    }
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
    public String getSuffix() {
        return suffix;
    }
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
```
```java
package com.atguigu.starter;
public class HelloService {
    HelloProperties helloProperties;
    public HelloProperties getHelloProperties() {
        return helloProperties;
    }
    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }
    public String sayHellAtguigu(String name){
        return helloProperties.getPrefix()+"-" +name + helloProperties.getSuffix();
    }
}
```
```java
package com.atguigu.starter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
@ConditionalOnWebApplication //webӦ�ò���Ч
@EnableConfigurationProperties(HelloProperties.class)
public class HelloServiceAutoConfiguration {
    @Autowired
    HelloProperties helloProperties;
    @Bean
    public HelloService helloService(){
        HelloService service = new HelloService();
        service.setHelloProperties(helloProperties);
        return service;
    }
}
```
# ����SpringBoot����ʾ��
https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples
