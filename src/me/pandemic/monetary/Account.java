/*
    Monetary - An economy plugin for Bukkit
    Copyright (C) 2012 Brandon Dibble (PandemicGaming)

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package me.pandemic.monetary;

import java.io.Serializable;

public class Account implements Serializable
{
	private static final long serialVersionUID = -395462408616906118L;
	
	private String name;
	private float amount;
	
	public Account(String name, float amount)
	{
		this.name = name;
		this.amount = amount;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public float getAmount()
	{
		return this.amount;
	}
	
	public void setAmount(float amount)
	{
		this.amount = amount;
	}
	
	public void addAmount(float amount)
	{
		this.amount += amount;
	}
	
	public void removeAmount(float amount)
	{
		this.amount -= amount;
	}
}