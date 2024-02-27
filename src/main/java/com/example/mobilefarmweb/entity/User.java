package com.example.mobilefarmweb.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_users")
	private int id;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "phone")
	private String phone;

	@Column(name = "bio")
	private String bio;

	@Column(name = "age")
	private String age;

	@Column(name = "active")
	private boolean active;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_role"))
	private Set<Role> roles;

//	@JsonIgnore
//	@ManyToOne
//	@JoinTable(name = "user_organization", joinColumns = @JoinColumn(name = "organizationId"), inverseJoinColumns = @JoinColumn(name = "organizationId"))
//	private OrganizationEntity organization;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch =FetchType.LAZY)
	@JoinColumn(name="id_organization")
	private Organization organization;

	@Override
	public String toString(){
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", phone='" + phone + '\'' +
				", bio='" + bio + '\'' +
				", age='" + age + '\'' +
				", active=" + active +
				", organization=" + organization.getUnp() +
				", roles=" + roles +
				'}';
	}
}
