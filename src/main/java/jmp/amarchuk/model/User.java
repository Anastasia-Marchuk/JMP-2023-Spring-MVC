package jmp.amarchuk.model;

import jmp.amarchuk.web.handler.HandlerException;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class User {

    private long id;
    private String name;
    private String email;

    public User() {
    }

    public User(long id, String name, String email) throws HandlerException {
        this.id = id;
        this.name = name;
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        matcher.matches();
        if (!matcher.matches()){
            throw new  HandlerException ();
        }
        this.email = email;
    }

    public User(String name, String email) throws HandlerException {
        this.name = name;
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        matcher.matches();
        if (!matcher.matches()){
            throw new  HandlerException ();
        }
        this.email = email;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws HandlerException {

     String regex = "^(.+)@(.+)$";
     Pattern pattern = Pattern.compile(regex);
     Matcher matcher = pattern.matcher(email);
     System.out.println(email +" : "+ matcher.matches());
        if (!matcher.matches()){
            throw new  HandlerException ();
        }
     this.email = email;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                Objects.equals(getName(), user.getName()) &&
                Objects.equals(getEmail(), user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmail());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
