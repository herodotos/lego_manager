/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Ondrej
 */
@Entity
public class Kit {
  
    @Id
    @GeneratedValue
    private long id = 0;
    
    @ManyToOne
    private KitSet kitSet = null;
    
    @ManyToOne
    private Category category = null;
    
    private String name;
    
    @OneToMany
    private Set<Part> parts = new HashSet<Part>();
    
    private int price;
    
    private int ageLimit;

    protected Kit(){};
    
    public Kit(String name,int price,int ageLimit)
    {
        this.name=name;
        this.price=price;
        this.ageLimit=ageLimit;
    }
    
    public long getId() {
        return id;
    }

    public KitSet getKitSet() {
        return kitSet;
    }

    public void setKitSet(KitSet kitSet) {
        this.kitSet = kitSet;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
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
	Kit other = (Kit) obj;
	if (id != other.id)
            return false;
	return true;
    }

    @Override
    public String toString() {
        return "Kit{" + "id=" + id + ", name=" + name + '}';
    }
    
}
