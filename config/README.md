# Config 

### Getting Started 
https://spring.io/guides/gs/centralized-configuration/
http://blog.eomdev.com/springcloud/2019/03/21/Spring-Cloud-Config.html

- /book/dev
- /book/real



### Config Server URL 설명
위에서 Config Server에서 url을 호출해서 환경설정 정보를 확인하기 위해 http://localhost:8888/api/dev 를 호출했는데, 이 부분은 http://localhost:8888/{application}/{profile}/{label} 형태 입니다.

{application} : Config Client에서 설정되어 있는 spring.application.name 속성으로 지정된 애플리케이션의 이름을 의미합니다. 여기에서는 spring.application.name=api으로 설정하여, api.yml에 있는 정보들을 사용할 예정입니다.
{profile} : Config Client에 설정되어 있는 spring.profiles.active 의 값이고, comma(,)로 구분되어 있는 여러 개의 값일 경우 마지막 값이 적용 됩니다. 기본 profile 값은 default 입니다.
{label} : 필수가 아닌 옵션이며, git branch의 이름을 나타냅니다. 기본 값은 master입니다.
이 {application}, {profile}, {lable}의 값을 가지고 아래와 같은 방법으로도 Config Server에게 환경설정 정보 값들을 확인 할 수 있습니다.

~~~
/{application}/{profile}[/{label}]
/{application}-{profile}.yml
/{label}/{application}-{profile}.yml
/{application}-{profile}.properties
/{label}/{application}-{profile}.properties
~~~

### 2.5.x 변경사항 

사용하는 쪽에서 spring-cloud-starter-bootstrap 필요하고 아래와 같이 설정이 필요하다.

~~~yml
spring:
 config:
    import: optional:configserver:http://localhost:8888
~~~
 