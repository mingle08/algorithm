package algo.jdk.StreamDemoOfJdk8;

public class User {

    private String name;
    private String rank;
    private Integer age;

    public User(String name, String rank, Integer age){
        this.name = name;
        this.rank = rank;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


}
