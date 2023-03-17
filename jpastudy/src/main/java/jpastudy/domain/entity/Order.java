package jpastudy.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS") //DB에 ORDER가 예약어로 걸려 있음.
public class Order {

	@Id
	@GeneratedValue
	@Column(name = "ORDER_ID")
	private Long id;

	/**
	 * UML에 따른 참조가 잘못 작성 된 것.
	 * 객체 그래프 탐색이 불가능
	**/
	// @Column(name = "MEMBER_ID")
	// private Long memberId;

	@Column(name = "MEMBER_ID")
	private Member member;
	private LocalDateTime orderDate;

	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	public Long getId() {
		return id;
	}

	public Long getMemberId() {
		return memberId;
	}

	public Member getMember() {
		return member;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
}
