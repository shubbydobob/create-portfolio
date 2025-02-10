package com.project.portfolio_create.Portfolio.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity                      // DB 테이블과 매핑되는 클래스로, JPA를 사용해 직접 데이터베이스와 연동.
@NoArgsConstructor           // 엔티티를 클라이언트 요청/응답에 직접 노출하면 보안 문제가 발생할 수 있기 때문에 DTO를 만들어서
@AllArgsConstructor          // 별도의 계층을 통해 데이터 흐름을 관리한다.
@Getter
@Setter
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String userId;
    private String password;
    private String email;
    private String career;
    private String studyStack;
    private Instant createdAt;
    private Instant updatedAt;

}
