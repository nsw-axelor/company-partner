package com.axelor.contact.db;

import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

import com.axelor.auth.db.AuditableModel;
import com.axelor.db.annotations.HashKey;
import com.axelor.db.annotations.Widget;
import com.google.common.base.MoreObjects;

@Entity
@Cacheable
@Table(name = "CONTACT_CIRCLE1")
public class Circle1 extends AuditableModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTACT_CIRCLE1_SEQ")
	@SequenceGenerator(name = "CONTACT_CIRCLE1_SEQ", sequenceName = "CONTACT_CIRCLE1_SEQ", allocationSize = 1)
	private Long id;

	@HashKey
	@NotNull
	@Size(min = 2)
	@Column(unique = true)
	private String code;

	@HashKey
	@NotNull
	@Size(min = 2)
	@Column(unique = true)
	private String name;

	@Widget(title = "Attributes")
	@Basic(fetch = FetchType.LAZY)
	@Type(type = "json")
	private String attrs;

	public Circle1() {
	}

	public Circle1(String code, String name) {
		this.code = code;
		this.name = name;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAttrs() {
		return attrs;
	}

	public void setAttrs(String attrs) {
		this.attrs = attrs;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (this == obj) return true;
		if (!(obj instanceof Circle1)) return false;

		final Circle1 other = (Circle1) obj;
		if (this.getId() != null || other.getId() != null) {
			return Objects.equals(this.getId(), other.getId());
		}

		if (!Objects.equals(getCode(), other.getCode())) return false;
		if (!Objects.equals(getName(), other.getName())) return false;

		return true;
	}

	@Override
	public int hashCode() {
		return Objects.hash(-1847364287, this.getCode(), this.getName());
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("id", getId())
			.add("code", getCode())
			.add("name", getName())
			.omitNullValues()
			.toString();
	}
}
