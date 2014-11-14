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
import javax.persistence.OneToMany;

/**
 *
 * @author Ondrej
 */
@Entity
public class Category {

    @Id 
    @GeneratedValue
    private long id = 0;
    
    private String name;
    
    private String description;
    
    @OneToMany(mappedBy="category")
    private Set<KitSet> kitSets = new HashSet<KitSet>();
    
    @OneToMany(mappedBy="category")
    private Set<Kit> kits = new HashSet<Kit>();

    public Category() {
    }
 
    public Category(String name, String description) {
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<KitSet> getKitSets() {
        return kitSets;
    }

    public void setKitSets(Set<KitSet> kitSets) {
        this.kitSets = kitSets;
    }

    public Set<Kit> getKits() {
        return kits;
    }

    public void setKits(Set<Kit> kits) {
        this.kits = kits;
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
	Category other = (Category) obj;
	if (id != other.id)
            return false;
	return true;
    }

    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", name=" + name + ", description=" + description + '}';
    }   
}
