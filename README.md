## Kafka 를 이용한 Multi-Module 대출 심사 프로젝트  🏦

### ⚒️ 프로젝트 기술 :

- **Language**
  - kotlin
 
- **Library/Framework**
  - Spring Boot(2.6.3) - multi module
  - JPA(Spring Data JPA)
  - Kafka
  - Spring Cloud Gateway(Nginx)
  - Junit 5
  - Swagger
 
- **Infrastructure**
  - MariaDB
  - Redis
  - Docker 

### ⏰ 프로젝트 기간 : 2023.04.10 ~ 2023.05.17

### 🔥 프로젝트 개요
  <img width="713" alt="스크린샷 2023-05-22 오후 9 59 24" src="https://github.com/choidongkuen/Loan_Judgement_Project/assets/96874318/dec0532c-dbcf-4a14-86c8-19e11d2424a7">


### 🦾 프로젝트 어플리케이션 정보 : 

| 이름 | 호스트 : 포트 | 설명 |
| -- | -- | -- |
| API | localhost:8080 | 회원 정보를 통한 `대출 심사 요청` 및 `대출 심사 결과 응답`을 <br> 내려주는 Client 에 직접적인 서비스를 제공하는 어플리케이션 |
| CONSUMER | localhost:8081 | Kafka 메세지를 `pull` 을 통해 소비하는 어플리케이션 <br> 즉, 실제 `심사 요청을 처리` 하는 `CSS` 에 심사 요청하는 어플리케이션 |
| CSS(Credit Scoring System)| localhost:8082 | 실제 외부에서 심사 결과를 진행하는 어플리케이션 <br> `CONSUMER` 로 부터 받은 요청을 정해진 로직에 따라 처리하는 어플리케이션 |

### ⛄️ 기타 외부 서버 포트 정보 : 
  | 이름 | 포트 |
  | -- | -- |
  | redis | 6379 |
  | mariadb | 3305 |
  | kafka | 9092 |
  | zoopkeeper | 2181 |
  | nginx | 8083 |

###  👨‍💻 프로젝트 특징 
  - Kafka 를 통해 모든 대출 심사 요청을 `CONSUMER` 를 통해 `CSS` 로 전달.
  - Kafka 의 topic 이름은 `loanRequest` 이며, `replication-factor` 는 1이다.
  - Nginx 를 통한 Proxy 서버를 `CONSUMER` 어플리케이션과 `CSS` 어플리케이션 사이에 구축하였다.
  - 구현한 모든 어플리케이션은 `Docker` 을 통해 `Excutable File` 로 생성하였다.
  - 데이터베이스와 관련된 구현(Redis, JPA 등)은 `Domain` 모듈에 구현하였다.

