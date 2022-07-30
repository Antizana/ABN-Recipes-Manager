/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONObject;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User implements Serializable {

    private Long id;
    private String first_name;
    private String last_name;
    private String father_name;
    private Integer age;
    private String username;
    private String password;
    private Boolean active;
    private Collection<Recipe> recipes;

    public User(String str) {
        JSONObject obj = new JSONObject(str);
        this.id = (Long) obj.getLong("id");
        this.first_name = obj.getString("first_name");
        this.last_name = obj.getString("last_name");
        this.father_name = obj.getString("father_name");
        this.age = obj.getInt("age");
        this.username = obj.getString("username");
        this.password = obj.getString("password");
        this.active = obj.getBoolean("active");
    }
}
