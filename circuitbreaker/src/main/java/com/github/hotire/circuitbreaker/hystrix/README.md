# Hystrix

- https://github.com/Netflix/Hystrix

"일종의 Bulkhead 패턴이며, 각 서비스에 대한 의존성을 격리하고 동시 접근을 제한한다."

### 설계 원칙
    
Hystrix는 다음의 설계 원칙을 따른다.
    
- Dependency로부터 보호하고 latency 및 failure를 제어한다.
    
- 분산 환경에서 cascading failures(계단식 장애)를 중단한다. (끊는다)
    
- 빠르게 failure 시키고 복구한다.
    
- 대체 시스템(fallback)으로 자연스럽게 전환한다.
    
- 모니터링 및 경고 시스템 등을 가능하게 한다.
    
   

### Hystrix, How it Works

- https://github.com/Netflix/Hystrix/wiki/How-it-Works
- https://timewizhan.tistory.com/entry/Netflix-Hystrix-Overview

## Command
- https://gunju-ko.github.io/spring-cloud/netflixoss/2018/12/08/HelloHystrixCommnad.html
- https://github.com/Netflix/Hystrix/wiki/Configuration#CommandExecution

- requestVolumeThreshold

특정 시간동안 일정 개수 이상의 호출이 발생한 경우에만 circuit이 open 된다. 호출 개수는 이 설정을 통해 정할 수 있다.

- sleepWindowInMilliseconds

circuit open시 open이 지속되는 시간

- errorThresholdPercentage

circuit이 open되기 위한 최소 에러 비율

- metrics.rollingStats.timeInMilliseconds:

측정 시간 

- execution.isolation.thread.timeoutInMilliseconds

command timeout 값 


## Isolation