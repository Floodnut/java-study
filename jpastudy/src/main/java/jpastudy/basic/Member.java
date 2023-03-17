package jpastudy.basic;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Member") // JPA에서 관리하기 위한 어노테이션
@Table(name = "MBR")
@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq") // 시퀀스 제네레이터 생성
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator") //시퀀스 제네레이터 지정
    private Long id;

    @Column(name = "name")
    private String name;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP) // 날짜, 시간 매핑
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    @Lob // 가변 길이의 긴 데이터. BLOB, CLOB(문자열)
    private String description;

    @Transient // 필드를 컬럼에 매핑하지 않음(매핑 무시), 메모리에서만 사용.
    private int tmp;

    public Member(){}

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
}
