package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // JPA에서 관리하기 위한 어노테이션
public class Member {

    @Id
    private Long id;
    private String name;

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
