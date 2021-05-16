package hcmute.edu.vn.mssv18110299.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Role {
    @PrimaryKey(autoGenerate = true)
    private int Id;
    private String Name;

    public Role() {
    }

    public Role(int id, String name) {
        Id = id;
        Name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
