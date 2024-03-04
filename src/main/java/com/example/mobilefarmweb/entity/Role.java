package com.example.mobilefarmweb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_role")
	private Integer id;

	@Column(name = "role")
	private String role;

	@Column(name = "title")
	private String title;

	@Override
	public String toString(){
		return "Role{" +
				"id=" + id +
				", role='" + role + '\'' +
				", title='" + title + '\'' +
				'}';
	}
}