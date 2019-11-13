package hanoi;

class Disk {
    private int nb;

    Disk(int nb){
        this.nb = nb;
    }

    @Override
    public String toString() {
        return "<" + nb + ">";
    }
}
