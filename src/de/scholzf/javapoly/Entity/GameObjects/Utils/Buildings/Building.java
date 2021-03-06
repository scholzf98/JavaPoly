package de.scholzf.javapoly.Entity.GameObjects.Utils.Buildings;

import de.scholzf.javapoly.Entity.GameObjects.Entities.Entity;
import de.scholzf.javapoly.Entity.Base.BuildingBase;
import de.scholzf.javapoly.Entity.Base.GameObjectType;

public class Building implements BuildingBase {

	private String name;
	private double value;
	private GameObjectType type;
	private Entity owner;
	public double rent;
	
	public Building(String name, double value, GameObjectType type, Entity owner, double rent) {
		setName(name);
		setValue(value);
		setType(type);
		setOwner(owner);
		setRent(rent);
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public double getValue() {
		return this.value;
	}

	@Override
	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public GameObjectType getType() {
		return this.type;
	}

	@Override
	public void setType(GameObjectType type) {
		this.type = type;
	}

	@Override
	public Entity getOwner() {
		return this.owner;
	}

	@Override
	public void setOwner(Entity owner) {
		this.owner = owner;
	}

	public void setRent(double rent) {
		this.rent = rent;
	}

	public double getRent() {
		return this.rent;
	}

}
