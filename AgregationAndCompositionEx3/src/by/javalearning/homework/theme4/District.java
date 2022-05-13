package by.javalearning.homework.theme4;

import java.util.Objects;

/*
 * 4. Programming with classes
 * Агрегация и композиция.
 * 3. Создать объект класса Государство, используя классы Область, Район, Город.
 * Методы: вывести на консоль столицу, количество областей, площадь, областные центры.
 */

public class District {
    
    private String name;
    
    public District (String name) {
	this.setName(name);
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }
    
    @Override
    public int hashCode() {
	return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	District other = (District) obj;
	return Objects.equals(name, other.name);
    }

    public String toString() {
	String string = "";
	string += name + " район";
	return string;
    }
    
}
