public class Personne {

    private String name;

    public Personne(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "name='" + name + '\'' +
                '}';
    }
}
