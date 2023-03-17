## JPASHOP

### Setter의 사용을 지양하자.
Setter는 항상 사용하지말고 생성자 등을 통해서 값을 할당하거나 최소화 하는 것이 좋다.  
무분별한 Setter의 사용은 코드 추적성 면에서 유지보수성이 떨어지게 한다.

### 관례
DB의 테이블, 컬럼명은 '_(언더바)'를 포함하는 스네이크 케이스가 주로 관례로 사용된다.  
Java 앱 개발에서는 카멜 케이스가 주로 사용된다.  
따라서 필요한 경우 `@Column`, `@Table`의 Name 속성을 통해 적절한 명칭을 지정하자.

### 제약조건
테이블 엔터티에는 제약조건을 명시해주는 것이 좋다.
Unique, 길이, 인덱스 등 각 제약조건을 명시하면 개발의 관점에서 DB를 직접 확인하지 않아도 된다.

### 객체 지향
연관 관계의 경우 객체 타입을 직접 지정하는 것이 객체 그래프 탐색을 가능하게 한다.
`Long` 등 id의 타입을 직접 작성하는 것은 연관 관계를 유지하지 못하게 한다.

### 애플리케이션 실행 시 생성되는 테이블
Hibernate:

    create table Member (
       MEMBER_ID bigint not null,
        city varchar(255),
        name varchar(255),
        street varchar(255),
        zipcode varchar(255),
        primary key (MEMBER_ID)
    )
Hibernate:

    create table OrderItem (
       ORDER_ITEM_ID bigint not null,
        count integer not null,
        ITEM_ID bigint,
        ORDER_ID bigint,
        orderPrice integer not null,
        primary key (ORDER_ITEM_ID)
    )
Hibernate:

    create table ORDERS (
       ORDER_ID bigint not null,
        MEMBER_ID bigint,
        orderDate timestamp,
        status varchar(255),
        primary key (ORDER_ID)
    )