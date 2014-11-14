/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.entity;

import java.awt.Color;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Ondrej
 */
@Entity
public class Part {

	@Id
	@GeneratedValue
	private long id = 0;

	private String name;
	private Color color = null;

	@OneToOne(cascade = CascadeType.MERGE)
	private PartBlueprint blueprint = null;

	public Part() {
	}

	public Part(PartBlueprint blueprint, String name, Color color) {
		this.name = name;
		this.blueprint = blueprint;
		this.color = color;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public PartBlueprint getBlueprint() {
		return blueprint;
	}

	public void setBlueprint(PartBlueprint blueprint) {
		this.blueprint = blueprint;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Part other = (Part) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Part{" + "id=" + id + ", name=" + name + ", color=" + color
				+ '}';
	}

}
