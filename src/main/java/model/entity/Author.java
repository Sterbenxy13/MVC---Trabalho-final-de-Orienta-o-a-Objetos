
package model.entity;

import java.util.Objects;

/**
 *
 * @author Sterbenxy13
 */
public class Author {
    private String name;
    private String homeTown;

    public Author() {
        this.name = "";
        this.homeTown = "";
    }
    
    public Author(String name, String homeTown) {
        this.name = name;
        this.homeTown = homeTown;
    }

    public String getName() {
        return name;
    }

    public String getHomeTown() {
        return homeTown;
    }

    @Override
    public String toString() {
        return "{nome: " + name + ", cidade natal: " + homeTown + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.name);
        hash = 41 * hash + Objects.hashCode(this.homeTown);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Author other = (Author) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.homeTown, other.homeTown);
    }
    
    
    
    
}
