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
public class KitSet {
    
    @Id
    @GeneratedValue
    private long id = 0;
    
    @ManyToOne
    private Category category = null;
    
    private String name;
    
    @OneToMany(mappedBy="kitSet")
    private Set<Kit> kits = new HashSet<Kit>();
    
    private int price;

    protected KitSet(){};
    
    public KitSet(String name, int price)
    {
        this.name=name;
        this.price=price;
    }
    
    public long getId() {
        return id;
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

    public Set<Kit> getKits() {
        return kits;
    }

    public void setKits(Set<Kit> kits) {
        this.kits = kits;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
	KitSet other = (KitSet) obj;
	if (id != other.id)
            return false;
	return true;
    }

    @Override
    public String toString() {
        return "KitSet{" + "id=" + id + ", name=" + name + ", price=" + price + '}';
    }
    
    
}
